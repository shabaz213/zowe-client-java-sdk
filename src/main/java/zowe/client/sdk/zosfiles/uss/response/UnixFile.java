/*
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */
package zowe.client.sdk.zosfiles.uss.response;

import java.util.Optional;
import java.util.OptionalLong;

/**
 * ListItem object representing an item from Unix System Services (USS) list operation
 *
 * @author Frank Giordano
 * @version 4.0
 */
public class UnixFile {

    /**
     * File, symbolic file or directory name
     */
    private final String name;

    /**
     * Permission (mode) of returned name item
     */
    private final String mode;

    /**
     * size of returned name item
     */
    private final Long size;

    /**
     * uid of returned name item
     */
    private final Long uid;

    /**
     * user of returned name item
     */
    private final String user;

    /**
     * gid of returned name item
     */
    private final Long gid;

    /**
     * group of returned name items
     */
    private final String group;

    /**
     * mtime of returned name item
     */
    private final String mtime;
    /**
     * target of returned name item
     */
    private final String target;

    /**
     * UnixFile constructor
     *
     * @param builder UnixFile.Builder object
     * @author Frank Giordano
     */
    public UnixFile(final UnixFile.Builder builder) {
        this.name = builder.name;
        this.mode = builder.mode;
        this.size = builder.size;
        this.uid = builder.uid;
        this.user = builder.user;
        this.gid = builder.gid;
        this.group = builder.group;
        this.mtime = builder.mtime;
        this.target = builder.target;
    }

    /**
     * Retrieve name value
     *
     * @return name value
     */
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    /**
     * Retrieve mode value
     *
     * @return mode value
     */
    public Optional<String> getMode() {
        return Optional.ofNullable(mode);
    }

    /**
     * Retrieve size value
     *
     * @return size value
     */
    public OptionalLong getSize() {
        return (size == null) ? OptionalLong.empty() : OptionalLong.of(size);
    }

    /**
     * Retrieve uid value
     *
     * @return uid value
     */
    public OptionalLong getUid() {
        return (uid == null) ? OptionalLong.empty() : OptionalLong.of(uid);
    }

    /**
     * Retrieve user value
     *
     * @return user value
     */
    public Optional<String> getUser() {
        return Optional.ofNullable(user);
    }

    /**
     * Retrieve gid value
     *
     * @return gid value
     */
    public OptionalLong getGid() {
        return (gid == null) ? OptionalLong.empty() : OptionalLong.of(gid);
    }

    /**
     * Retrieve group value
     *
     * @return group value
     */
    public Optional<String> getGroup() {
        return Optional.ofNullable(group);
    }

    /**
     * Retrieve mtime value
     *
     * @return mtime value
     */
    public Optional<String> getMtime() {
        return Optional.ofNullable(mtime);
    }

    /**
     * Retrieve target value
     *
     * @return target value
     */
    public Optional<String> getTarget() {
        return Optional.ofNullable(target);
    }

    /**
     * Return string value representing UnixFile object
     *
     * @return string representation of UnixFile
     */
    @Override
    public String toString() {
        return "UnixFile{" +
                "name=" + name +
                ", mode=" + mode +
                ", size=" + size +
                ", uid=" + uid +
                ", user=" + user +
                ", gid=" + gid +
                ", group=" + group +
                ", mtime=" + mtime +
                ", target=" + target +
                '}';
    }

    /**
     * Builder class for UnixFile
     */
    public static class Builder {

        /**
         * File, symbolic file or directory name
         */
        private String name;

        /**
         * Permission (mode) of returned name item
         */
        private String mode;

        /**
         * size of returned name item
         */
        private Long size;

        /**
         * uid of returned name item
         */
        private Long uid;

        /**
         * user of returned name item
         */
        private String user;

        /**
         * gid of returned name item
         */
        private Long gid;

        /**
         * group of returned name items
         */
        private String group;

        /**
         * mtime of returned name item
         */
        private String mtime;

        /**
         * target of returned name item
         */
        private String target;

        /**
         * Set name string value
         *
         * @param name string value
         * @return Builder this object
         */
        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * Set mode string value
         *
         * @param mode string value
         * @return Builder this object
         */
        public Builder mode(final String mode) {
            this.mode = mode;
            return this;
        }

        /**
         * Set size long value
         *
         * @param size long value
         * @return Builder this object
         */
        public Builder size(final Long size) {
            this.size = size;
            return this;
        }

        /**
         * Set uid long value
         *
         * @param uid long value
         * @return Builder this object
         */
        public Builder uid(final Long uid) {
            this.uid = uid;
            return this;
        }

        /**
         * Set user string value
         *
         * @param user string value
         * @return Builder this object
         */
        public Builder user(final String user) {
            this.user = user;
            return this;
        }

        /**
         * Set gid value
         *
         * @param gid long value
         * @return Builder this object
         */
        public Builder gid(final Long gid) {
            this.gid = gid;
            return this;
        }

        /**
         * Set group string value
         *
         * @param group string value
         * @return .Builder this object
         */
        public Builder group(final String group) {
            this.group = group;
            return this;
        }

        /**
         * Set mtime string value
         *
         * @param mtime string value
         * @return Builder this object
         */
        public Builder mtime(final String mtime) {
            this.mtime = mtime;
            return this;
        }

        /**
         * Set target string value
         *
         * @param target string value
         * @return Builder this object
         */
        public Builder target(final String target) {
            this.target = target;
            return this;
        }

        /**
         * Return UnixFile object based on Builder this object
         *
         * @return UnixFile this object
         */
        public UnixFile build() {
            return new UnixFile(this);
        }

    }

}
