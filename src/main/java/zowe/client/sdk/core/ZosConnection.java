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

import kong.unirest.core.Cookie;

import java.util.Objects;
import java.util.Optional;

/**
 * Z/OSMF Connection information placeholder
 *
 * @author Frank Giordano
 * @version 3.0
 */
public class ZosConnection {

    /**
     * Host name pointing to the backend z / OS instance
     */
    private final String host;

    /**
     * Host z/OSMF port number pointing to the backend z / OS instance
     */
    private final String zosmfPort;

    /**
     * Host username with access to a backend z / OS instance
     */
    private final String user;

    /**
     * Host username's password with access to backend z/OS instance
     */
    private final String password;

    /**
     * Cookie value set to use as an authentication token for http call
     */
    private Optional<Cookie> cookie;

    /**
     * ZosConnection constructor
     *
     * @param host      machine host pointing to backend z/OS instance
     * @param zosmfPort machine host z/OSMF port number pointing to backend z/OS instance
     * @param user      machine host username with access to backend z/OS instance
     * @param password  machine host username's password with access to backend z/OS instance
     * @author Frank Giordano
     */
    public ZosConnection(final String host, final String zosmfPort, final String user, final String password) {
        this.host = host;
        this.zosmfPort = zosmfPort;
        this.user = user;
        this.password = password;
        this.cookie = Optional.empty();
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
     * Retrieve z/OSMF port number specified
     *
     * @return port value
     */
    public String getZosmfPort() {
        return zosmfPort;
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
     * Retrieve cookie object
     *
     * @return cookie object
     */
    public Optional<Cookie> getCookie() {
        return cookie;
    }

    /**
     * Set a cookie token for this request. This is optional for most requests and not needed.
     * Setting the cookie will remove the HTTP header authentication.
     * Setting the cookie value as null after giving it a value will revert/enable
     * the HTTP header authentication for future requests.
     *
     * @param cookie Cookie object containing a token value
     */
    public void setCookie(final Cookie cookie) {
        this.cookie = Optional.ofNullable(cookie);
    }

    /**
     * Return string value representing ZosConnection object
     *
     * @return string representation of ZosConnection
     */
    @Override
    public String toString() {
        return "ZosConnection{" +
                "host='" + host + '\'' +
                ", zosmfPort='" + zosmfPort + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", cookie=" + cookie +
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
        ZosConnection other = (ZosConnection) obj;
        return Objects.equals(host, other.host) && Objects.equals(zosmfPort, other.zosmfPort)
                && Objects.equals(user, other.user) && Objects.equals(password, other.password)
                && Objects.equals(cookie.orElse(new Cookie("")).getValue(),
                other.cookie.orElse(new Cookie("")).getValue());
    }

    /**
     * Hashcode method. Use all members for hashing.
     *
     * @return int value
     */
    @Override
    public int hashCode() {
        return Objects.hash(host, zosmfPort, user, password, cookie);
    }

}
