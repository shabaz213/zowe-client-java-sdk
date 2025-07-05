/*
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */
package zowe.client.sdk.zostso.response;

import zowe.client.sdk.zostso.TsoConstants;
import zowe.client.sdk.zostso.message.TsoMessages;
import zowe.client.sdk.zostso.message.ZosmfMessages;
import zowe.client.sdk.zostso.message.ZosmfTsoResponse;

import java.util.List;
import java.util.Optional;

/**
 * The TsoStartStop API responses
 *
 * @author Frank Giordano
 * @version 4.0
 */
public class StartStopResponses {

    /**
     * Response from z/OSMF to start rest call
     */
    private final ZosmfTsoResponse zosmfTsoResponse;

    /**
     * If an error occurs, returns the error which contains the cause error.
     */
    private final String failureResponse;

    /**
     * Appended collected messages including READY prompt at the end.
     */
    private final String messages;

    /**
     * True if the command was issued and the responses were collected.
     */
    private final boolean success;

    /**
     * Collected responses from z/OSMF
     */
    private List<ZosmfTsoResponse> collectedResponses;

    /**
     * Servlet key from IZosmfTsoResponse
     */
    private String servletKey;

    /**
     * StartStopResponses constructor
     *
     * @param zosmfTsoResponse   tso response
     * @param collectedResponses collectedResponses
     * @author Frank Giordano
     */
    public StartStopResponses(final ZosmfTsoResponse zosmfTsoResponse, final CollectedResponses collectedResponses) {
        this.zosmfTsoResponse = zosmfTsoResponse;
        if (!zosmfTsoResponse.getMsgData().isEmpty()) {
            // more data means more tso responses to come, and as such tso command request has not ended in success yet
            this.success = false;
            final ZosmfMessages zosmfMsg = zosmfTsoResponse.getMsgData().get(0);
            this.failureResponse = zosmfMsg.getMessageText().orElse(TsoConstants.ZOSMF_UNKNOWN_ERROR);
        } else {
            // no data means no more tso responses to come, and an as such tso command request has ended successfully
            this.success = true;
            this.failureResponse = null;
        }

        this.servletKey = zosmfTsoResponse.getServletKey()
                .orElseThrow(() -> new IllegalStateException("servletKey is missing"));

        final StringBuilder buildMessage = new StringBuilder();
        final List<TsoMessages> tsoMsgLst = zosmfTsoResponse.getTsoData();
        tsoMsgLst.forEach(buildMessage::append);
        this.messages = buildMessage.toString();
        this.collectedResponses = collectedResponses.getTsos();
    }

    /**
     * Retrieve collectedResponses specified
     *
     * @return ZosmfTsoResponse value
     */
    public List<ZosmfTsoResponse> getCollectedResponses() {
        return collectedResponses;
    }

    /**
     * Assign collectedResponses value
     *
     * @param collectedResponses list of ZosmfTsoResponse objects
     */
    public void setCollectedResponses(final List<ZosmfTsoResponse> collectedResponses) {
        this.collectedResponses = collectedResponses;
    }

    /**
     * Retrieve failureResponse specified
     *
     * @return failureResponse value
     */
    public Optional<String> getFailureResponse() {
        return Optional.of(failureResponse);
    }

    /**
     * Retrieve messages specified
     *
     * @return messages value
     */
    public Optional<String> getMessages() {
        return Optional.of(messages);
    }

    /**
     * Retrieve servletKey specified
     *
     * @return servletKey value
     */
    public Optional<String> getServletKey() {
        return Optional.ofNullable(servletKey);
    }

    /**
     * Assign servletKey value
     *
     * @param servletKey key of tso address space
     */
    public void setServletKey(final String servletKey) {
        this.servletKey = servletKey;
    }

    /**
     * Retrieve zosmfTsoResponse specified
     *
     * @return ZosmfTsoResponse value
     */
    public Optional<ZosmfTsoResponse> getZosmfTsoResponse() {
        return Optional.of(zosmfTsoResponse);
    }

    /**
     * Retrieve is success
     *
     * @return boolean true or false
     */
    public boolean isSuccess() {
        return success;
    }

}
