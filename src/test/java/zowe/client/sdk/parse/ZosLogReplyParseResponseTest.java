/*
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */
package zowe.client.sdk.parse;

import org.json.simple.JSONObject;
import org.junit.Test;
import zowe.client.sdk.parse.type.ParseType;
import zowe.client.sdk.zoslogs.response.ZosLogReply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Class containing unit tests for ZosLogReplyParseResponse.
 *
 * @author Frank Giordano
 * @version 4.0
 */
public class ZosLogReplyParseResponseTest {

    @Test
    public void tstZosLogReplyParseJsonStopResponseNullFail() {
        String msg = "";
        try {
            JsonParseFactory.buildParser(ParseType.ZOS_LOG_REPLY).parseResponse((Object) null);
        } catch (NullPointerException e) {
            msg = e.getMessage();
        }
        assertEquals("data is null", msg);
    }

    @Test
    public void tstZosLogReplyParseJsonStopResponseSingletonSuccess() {
        final JsonParse parser = JsonParseFactory.buildParser(ParseType.ZOS_LOG_REPLY);
        final JsonParse parser2 = JsonParseFactory.buildParser(ParseType.ZOS_LOG_REPLY);
        assertSame(parser, parser2);
    }

    @Test
    public void tstZosLogReplyParseJsonStopResponseSuccess() {
        final Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("totalitems", 1L);
        jsonMap.put("source", "dev");
        final JSONObject json = new JSONObject(jsonMap);

        final ZosLogReplyJsonParse parser = (ZosLogReplyJsonParse)
                JsonParseFactory.buildParser(ParseType.ZOS_LOG_REPLY);
        final ZosLogReply response = parser.parseResponse(json, new ArrayList<>());
        assertEquals(Long.parseLong("1"), response.getTotalItems().orElse(-1L));
        assertEquals("dev", response.getSource().orElse("n\\a"));
    }

}
