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
import zowe.client.sdk.zoslogs.response.ZosLogItem;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Class containing unit tests for ZosLogItemParseResponse.
 *
 * @author Frank Giordano
 * @version 4.0
 */
public class ZosLogItemParseResponseTest {

    @Test
    public void tstZosLogItemParseJsonStopResponseNullFail() {
        String msg = "";
        try {
            JsonParseFactory.buildParser(ParseType.ZOS_LOG_ITEM).parseResponse((Object) null);
        } catch (NullPointerException e) {
            msg = e.getMessage();
        }
        assertEquals("data is null", msg);
    }

    @Test
    public void tstZosLogItemParseJsonStopResponseSingletonSuccess() {
        final JsonParse parser = JsonParseFactory.buildParser(ParseType.ZOS_LOG_ITEM);
        final JsonParse parser2 = JsonParseFactory.buildParser(ParseType.ZOS_LOG_ITEM);
        assertSame(parser, parser2);
    }

    @Test
    public void tstZosLogItemParseJsonStopResponseSuccess() {
        final Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("jobName", "ver");
        jsonMap.put("message", "message");
        final JSONObject json = new JSONObject(jsonMap);

        final ZosLogItem response = (ZosLogItem)
                JsonParseFactory.buildParser(ParseType.ZOS_LOG_ITEM).parseResponse(json, false);
        assertEquals("ver", response.getJobName().orElse("n\\a"));
        assertEquals("message", response.getMessage().orElse("n\\a"));
    }

}
