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

import java.util.Objects;

/**
 * SSH Connection information placeholder
 *
 * @author Frank Giordano
 * @version 5.0
 */
public class SshConnection {

    /**
     * Host name pointing to the backend z / OS instance
     */
    private final String host;

    /**
     * Host port number pointing to the backend z / OS instance
     */
    private final int port;

    /**
     * Host username with access to a backend z / OS instance
     */
    private final String user;

    /**
     * Host username's password with access to backend z/OS instance
     */
    private final String password;

    /**
     * SshConnection constructor
     *
     * @param host     machine host pointing to backend z/OS instance
     * @param port     machine host port number pointing to backend z/OS instance
     * @param user     machine host username with access to backend z/OS instance
     * @param password machine host username's password with access to backend z/OS instance
     * @author Frank Giordano
     */
    public SshConnection(final String host, final int port, final String user, final String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    /**
     * Retrieve host specified
     *
     * @return host value
     */
    public String getHost() {
        return host;
    }

    /**
     * Retrieve port number specified
     *
     * @return port value
     */
    public int getPort() {
        return port;
    }

    /**
     * Retrieve username specified
     *
     * @return user value
     */
    public String getUser() {
        return user;
    }

    /**
     * Retrieve password specified
     *
     * @return password value
     */
    public String getPassword() {
        return password;
    }

    /**
     * Return string value representing SshConnection object
     *
     * @return string representation of SshConnection
     */
    @Override
    public String toString() {
        return "SshConnection{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /**
     * Equals method. Use all members for equality.
     *
     * @param obj object
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SshConnection other = (SshConnection) obj;
        return Objects.equals(host, other.host) && port == other.port &&
                Objects.equals(user, other.user) && Objects.equals(password, other.password);
    }

    /**
     * Hashcode method. Use all members for hashing.
     *
     * @return int value
     */
    @Override
    public int hashCode() {
        return Objects.hash(host, port, user, password);
    }

}
