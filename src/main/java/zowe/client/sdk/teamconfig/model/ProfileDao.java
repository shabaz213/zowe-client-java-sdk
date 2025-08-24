/*
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */
package zowe.client.sdk.teamconfig.model;

/**
 * ProfileDao POJO to act as a container for a parsed Zowe Global Team Configuration file representing a profile section
 * with merged properties from other profiles i.e., base, and KeyTarConfig details (containing credential information).
 *
 * @author Frank Giordano
 * @version 5.0
 */
public class ProfileDao {

    /**
     * Profile object from Zowe Global Team Configuration
     */
    private final Profile profile;

    /**
     * Username from OS credential store
     */
    private final String user;

    /**
     * Password from OS credential store
     */
    private final String password;

    /**
     * Host value from a properties section from Zowe Global Team Configuration
     */
    private final String host;

    /**
     * Port value from a properties section from Zowe Global Team Configuration
     */
    private final String port;

    /**
     * Partition constructor.
     *
     * @param profile  profile object from Zowe Global Team Configuration
     * @param user     username from Keytar keyValue
     * @param password password from Keytar keyValue
     * @param host     host value from Zowe Global Team Configuration
     * @param port     port value from Zowe Global Team Configuration
     * @author Frank Giordano
     */
    public ProfileDao(final Profile profile, final String user, final String password,
                      final String host, final String port) {
        this.profile = profile;
        this.user = user;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    /**
     * Return host name
     *
     * @return profile host string value
     */
    public String getHost() {
        return host;
    }

    /**
     * Return password
     *
     * @return profile password string value
     */
    public String getPassword() {
        return password;
    }

    /**
     * Return port number
     *
     * @return profile port string value
     */
    public String getPort() {
        return port;
    }

    /**
     * Return profile object
     *
     * @return profile object
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Return username
     *
     * @return profile username string value
     */
    public String getUser() {
        return user;
    }

    /**
     * Return string value representing ProfileDao object
     *
     * @return string representation of ProfileDao
     */
    @Override
    public String toString() {
        return "ProfileDao{" +
                "profile=" + profile +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                '}';
    }

}
