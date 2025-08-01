/*
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */
package zowe.client.sdk.core;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Class containing unit tests for SshConnection.
 *
 * @author Frank Giordano
 * @version 4.0
 */
public class SshConnectionTest {

    @Test
    public void tstReferenceNotEqualsSuccess() {
        final SshConnection sc1 = new SshConnection("test", 1, "user", "password");
        final SshConnection sc2 = new SshConnection("test", 1, "user", "password");
        assertNotSame(sc1, sc2);
    }

    @Test
    public void tstReferenceEqualsSuccess() {
        final SshConnection sc1 = new SshConnection("test", 1, "user", "password");
        final SshConnection sc2 = sc1;
        assertEquals(sc1, sc2);
    }

    @Test
    public void tstEqualsSuccess() {
        final SshConnection sc1 = new SshConnection("test", 1, "user", "password");
        final SshConnection sc2 = new SshConnection("test", 1, "user", "password");
        assertEquals(sc1, sc2);
    }

    @Test
    public void tstNotEqualsSuccess() {
        final SshConnection sc1 = new SshConnection("test", 1, "user", "password");
        final SshConnection sc2 = new SshConnection("test2", 1, "user", "password");
        assertNotEquals(sc1, sc2);
    }

    @Test
    public void tstHashCodeMapWithSecondHostDifferentSuccess() {
        final SshConnection sc1 = new SshConnection("test", 1, "user", "password");
        final SshConnection sc2 = new SshConnection("test2", 1, "user", "password");
        final var zcs = new HashMap<SshConnection, Integer>();
        zcs.put(sc1, 1);
        zcs.put(sc2, 2);
        assertEquals(2, zcs.size());
    }

    @Test
    public void tstHashCodeMapWithSecondPortDifferentSuccess() {
        final SshConnection sc1 = new SshConnection("test", 1, "user", "password");
        final SshConnection sc2 = new SshConnection("test", 2, "user", "password");
        final var zcs = new HashMap<SshConnection, Integer>();
        zcs.put(sc1, 1);
        zcs.put(sc2, 2);
        assertEquals(2, zcs.size());
    }

    @Test
    public void tstHashCodeMapWithSecondUserDifferentSuccess() {
        final SshConnection sc1 = new SshConnection("test", 1, "user", "password");
        final SshConnection sc2 = new SshConnection("test", 1, "user2", "password");
        final var zcs = new HashMap<SshConnection, Integer>();
        zcs.put(sc1, 1);
        zcs.put(sc2, 2);
        assertEquals(2, zcs.size());
    }

    @Test
    public void tstHashCodeMapWithSecondPasswordDifferentSuccess() {
        final SshConnection sc1 = new SshConnection("test", 1, "user", "password");
        final SshConnection sc2 = new SshConnection("test", 1, "user", "password2");
        final var zcs = new HashMap<SshConnection, Integer>();
        zcs.put(sc1, 1);
        zcs.put(sc2, 2);
        assertEquals(2, zcs.size());
    }

    @Test
    public void tstHashCodeMapNoDuplicateSuccess() {
        final SshConnection sc1 = new SshConnection("test", 1, "user", "password");
        final SshConnection sc2 = new SshConnection("test", 1, "user", "password");
        final var zcs = new HashMap<SshConnection, Integer>();
        zcs.put(sc1, 1);
        zcs.put(sc2, 2);
        assertEquals(1, zcs.size());
    }

}
