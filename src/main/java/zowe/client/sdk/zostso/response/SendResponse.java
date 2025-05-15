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

import zowe.client.sdk.zostso.message.ZosmfTsoResponse;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * The TsoSend API response
 *
 * @author Frank Giordano
 * @version 3.0
 */
public class SendResponse {

    /**
     * True if the command was issued and the responses were collected.
     */
    private final boolean success;

    /**
     * The list of zOSMF sends API responses. May issue multiple requests or
     * to ensure that all messages are collected. Each individual response is placed here.
     */
    private final List<ZosmfTsoResponse> zosmfTsoResponses;

    /**
     * The command response text.
     */
    private final Optional<String> commandResponse;

    /**
     * SendResponse constructor
     *
     * @param success           boolean value
     * @param zosmfTsoResponses list of ZosmfTsoResponse objects
     * @param commandResponse   tso command response
     * @author Frank Giordano
     */
    public SendResponse(final boolean success, final List<ZosmfTsoResponse> zosmfTsoResponses,
                        final String commandResponse) {
        this.success = success;
        this.zosmfTsoResponses = Objects.requireNonNullElse(zosmfTsoResponses, Collections.emptyList());
        this.commandResponse = Optional.ofNullable(commandResponse);
    }

    /**
     * Retrieve commandResponse specified
     *
     * @return commandResponse value
     */
    public Optional<String> getCommandResponse() {
        return commandResponse;
    }

    /**
     * Retrieve is success
     *
     * @return boolean true or false
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Retrieve zosmfResponses specified
     *
     * @return zosmfTsoResponses value, see ZosmfTsoResponse object
     */
    public List<ZosmfTsoResponse> getZosmfResponses() {
        return zosmfTsoResponses;
    }

    /**
     * Return string value representing SendResponse object
     *
     * @return string representation of SendResponse
     */
    @Override
    public String toString() {
        return "SendResponse{" +
                "success=" + success +
                ", zosmfTsoResponses=" + zosmfTsoResponses +
                ", commandResponse=" + commandResponse +
                '}';
    }

}
