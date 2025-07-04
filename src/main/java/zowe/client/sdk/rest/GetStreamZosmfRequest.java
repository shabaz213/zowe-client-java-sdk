/*
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */
package zowe.client.sdk.rest;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;
import zowe.client.sdk.core.ZosConnection;
import zowe.client.sdk.rest.exception.ZosmfRequestException;
import zowe.client.sdk.utility.EncodeUtils;
import zowe.client.sdk.utility.ValidateUtils;

/**
 * Http get stream operation with Json content type
 *
 * @author Frank Giordano
 * @version 4.0
 */
public class GetStreamZosmfRequest extends ZosmfRequest {

    /**
     * GetStreamZosmfRequest constructor
     *
     * @param connection connection information, see ZosConnection object
     * @author Frank Giordano
     */
    public GetStreamZosmfRequest(ZosConnection connection) {
        super(connection);
    }

    /**
     * Perform the http rest request
     *
     * @return Response object
     * @throws ZosmfRequestException request error state
     * @author Frank Giordano
     */
    @Override
    public Response executeRequest() throws ZosmfRequestException {
        ValidateUtils.checkNullParameter(url == null, "url is null");
        HttpResponse<byte[]> reply;
        try {
            reply = cookie != null ? Unirest.get(url).cookie(cookie).headers(headers).asBytes() :
                    Unirest.get(url).headers(headers).asBytes();
        } catch (UnirestException e) {
            throw new ZosmfRequestException(e.getMessage(), e);
        }
        return buildResponse(reply);
    }

    /**
     * Method to set the body information for the http request which is not used for this request.
     *
     * @param body object value
     * @author Frank Giordano
     */
    @Override
    public void setBody(Object body) {
        throw new IllegalStateException("setting body for this request is invalid");
    }

    /**
     * Set the standard headers for the http request
     *
     * @author Frank Giordano
     */
    @Override
    public void setStandardHeaders() {
        headers.put("Authorization", "Basic " + EncodeUtils.encodeAuthComponent(connection));
        headers.put("Content-Type", "application/json");
        headers.put(X_CSRF_ZOSMF_HEADER_KEY, X_CSRF_ZOSMF_HEADER_VALUE);
    }

}
