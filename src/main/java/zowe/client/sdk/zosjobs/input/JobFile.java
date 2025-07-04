/*
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */
package zowe.client.sdk.zosjobs.input;

import java.util.Optional;
import java.util.OptionalLong;

/**
 * Represents the name and details of an output (spool) DD for a z/OS batch job
 *
 * @author Frank Giordano
 * @version 4.0
 */
public class JobFile {

    /**
     * Job id for a job. Uniquely identifies a job on a z/OS system
     */
    private final Optional<String> jobId;

    /**
     * Job Name for a job
     */
    private final Optional<String> jobName;

    /**
     * Record format of the spool file (DD)
     */
    private final Optional<String> recfm;

    /**
     * Total bytes in the spool file
     */
    private final OptionalLong byteCount;

    /**
     * Total records (roughly equivalent to lines) in the spool file
     */
    private final OptionalLong recordCount;

    /**
     * Unique identifier of job (substitute of job name and job id)
     */
    private final Optional<String> jobCorrelator;

    /**
     * Job class for which job ran
     */
    private final Optional<String> classs;

    /**
     * Identifier for this spool file. Each JobFile for a single batch job will have a unique ID
     */
    private final OptionalLong id;

    /**
     * DD name of job spool file
     */
    private final Optional<String> ddName;

    /**
     * Direct access to job record content
     */
    private final Optional<String> recordsUrl;

    /**
     * Job DD lrecl (logical record length - how many bytes each record is)
     */
    private final OptionalLong lrecl;

    /**
     * The primary or secondary JES subsystem. If this value is null, the job was processed by the primary subsystem.
     */
    private final Optional<String> subSystem;

    /**
     * The name of the job step during which this spool file was produced
     */
    private final Optional<String> stepName;

    /**
     * If this spool file was produced during a job procedure step, the name of the step will be here.
     */
    private final Optional<String> procStep;

    /**
     * JobFile constructor
     *
     * @param builder JobFile.Builder object
     * @author Frank Giordano
     */
    private JobFile(final Builder builder) {
        this.jobId = Optional.ofNullable(builder.jobId);
        this.jobName = Optional.ofNullable(builder.jobName);
        this.recfm = Optional.ofNullable(builder.recfm);
        if (builder.byteCount == null) {
            this.byteCount = OptionalLong.empty();
        } else {
            this.byteCount = OptionalLong.of(builder.byteCount);
        }
        if (builder.recordCount == null) {
            this.recordCount = OptionalLong.empty();
        } else {
            this.recordCount = OptionalLong.of(builder.recordCount);
        }
        this.jobCorrelator = Optional.ofNullable(builder.jobCorrelator);
        this.classs = Optional.ofNullable(builder.classs);
        if (builder.id == null) {
            this.id = OptionalLong.empty();
        } else {
            this.id = OptionalLong.of(builder.id);
        }
        this.ddName = Optional.ofNullable(builder.ddName);
        this.recordsUrl = Optional.ofNullable(builder.recordsUrl);
        if (builder.lrecl == null) {
            this.lrecl = OptionalLong.empty();
        } else {
            this.lrecl = OptionalLong.of(builder.lrecl);
        }
        this.subSystem = Optional.ofNullable(builder.subSystem);
        this.stepName = Optional.ofNullable(builder.stepName);
        this.procStep = Optional.ofNullable(builder.procStep);
    }

    /**
     * Retrieve byteCount specified
     *
     * @return byteCount value
     */
    public OptionalLong getByteCount() {
        return byteCount;
    }

    /**
     * Retrieve classs specified
     *
     * @return classs value
     */
    public Optional<String> getClasss() {
        return classs;
    }

    /**
     * Retrieve ddName specified
     *
     * @return ddName value
     */
    public Optional<String> getDdName() {
        return ddName;
    }

    /**
     * Retrieve id specified
     *
     * @return id value
     */
    public OptionalLong getId() {
        return id;
    }

    /**
     * Retrieve jobCorrelator specified
     *
     * @return jobCorrelator value
     */
    public Optional<String> getJobCorrelator() {
        return jobCorrelator;
    }

    /**
     * Retrieve jobId specified
     *
     * @return jobId value
     */
    public Optional<String> getJobId() {
        return jobId;
    }

    /**
     * Retrieve jobName specified
     *
     * @return jobName value
     */
    public Optional<String> getJobName() {
        return jobName;
    }

    /**
     * Retrieve lrecl specified
     *
     * @return lrecl value
     */
    public OptionalLong getLrecl() {
        return lrecl;
    }

    /**
     * Retrieve procStep specified
     *
     * @return procStep value
     */
    public Optional<String> getProcStep() {
        return procStep;
    }

    /**
     * Retrieve recfm specified
     *
     * @return recfm value
     */
    public Optional<String> getRecfm() {
        return recfm;
    }

    /**
     * Retrieve recordCount specified
     *
     * @return recordCount value
     */
    public OptionalLong getRecordCount() {
        return recordCount;
    }

    /**
     * Retrieve recordsUrl specified
     *
     * @return recordsUrl value
     */
    public Optional<String> getRecordsUrl() {
        return recordsUrl;
    }

    /**
     * Retrieve stepName specified
     *
     * @return stepName value
     */
    public Optional<String> getStepName() {
        return stepName;
    }

    /**
     * Retrieve subSystem specified
     *
     * @return subSystem value
     */
    public Optional<String> getSubSystem() {
        return subSystem;
    }

    /**
     * Return string value representing JobFile object
     *
     * @return string representation of JobFile
     */
    @Override
    public String toString() {
        return "JobFile{" +
                "jobId=" + jobId +
                ", jobName=" + jobName +
                ", recfm=" + recfm +
                ", byteCount=" + byteCount +
                ", recordCount=" + recordCount +
                ", jobCorrelator=" + jobCorrelator +
                ", classs=" + classs +
                ", id=" + id +
                ", ddName=" + ddName +
                ", recordsUrl=" + recordsUrl +
                ", lrecl=" + lrecl +
                ", subSystem=" + subSystem +
                ", stepName=" + stepName +
                ", procStep=" + procStep +
                '}';
    }

    /**
     * Builder class for JobFile
     */
    public static class Builder {

        /**
         * Job id for a job. Uniquely identifies a job on a z/OS system
         */
        private String jobId;

        /**
         * Job Name for a job
         */
        private String jobName;

        /**
         * Record format of the spool file (DD)
         */
        private String recfm;

        /**
         * Total bytes in the spool file
         */
        private Long byteCount;

        /**
         * Total records (roughly equivalent to lines) in the spool file
         */
        private Long recordCount;

        /**
         * Unique identifier of a job (substitute of job name and job id)
         */
        private String jobCorrelator;

        /**
         * Job class for which a job ran
         */
        private String classs;

        /**
         * Identifier for this spool file. Each JobFile for a single batch job will have a unique ID
         */
        private Long id;

        /**
         * DD name of job spool file
         */
        private String ddName;

        /**
         * Direct access to job record content
         */
        private String recordsUrl;

        /**
         * Job DD lrecl (logical record length - how many bytes each record is)
         */
        private Long lrecl;

        /**
         * The primary or secondary JES subsystem. If this value is null, the job was processed by the primary subsystem.
         */
        private String subSystem;

        /**
         * The name of the job step during which this spool file was produced
         */
        private String stepName;

        /**
         * If this spool file was produced during a job procedure step, the name of the step will be here.
         */
        private String procStep;

        /**
         * Builder constructor
         */
        public Builder() {
        }

        /**
         * Set byteCount long value
         *
         * @param byteCount long value
         * @return Builder this object
         */
        public Builder byteCount(final Long byteCount) {
            this.byteCount = byteCount;
            return this;
        }

        /**
         * Set classs string value
         *
         * @param classs string value
         * @return Builder this object
         */
        public Builder classs(final String classs) {
            this.classs = classs;
            return this;
        }

        /**
         * Set ddName string value
         *
         * @param ddName string value
         * @return Builder this object
         */
        public Builder ddName(final String ddName) {
            this.ddName = ddName;
            return this;
        }

        /**
         * Set id long value
         *
         * @param id long value
         * @return Builder this object
         */
        public Builder id(final Long id) {
            this.id = id;
            return this;
        }

        /**
         * Set jobCorrelator string value
         *
         * @param jobCorrelator string value
         * @return Builder this object
         */
        public Builder jobCorrelator(final String jobCorrelator) {
            this.jobCorrelator = jobCorrelator;
            return this;
        }

        /**
         * Set jobId string value
         *
         * @param jobId string value
         * @return Builder this object
         */
        public Builder jobId(final String jobId) {
            this.jobId = jobId;
            return this;
        }

        /**
         * Set jobName string value
         *
         * @param jobName string value
         * @return Builder this object
         */
        public Builder jobName(final String jobName) {
            this.jobName = jobName;
            return this;
        }

        /**
         * Set lrecl long value
         *
         * @param lrecl long value
         * @return Builder this object
         */
        public Builder lrecl(final Long lrecl) {
            this.lrecl = lrecl;
            return this;
        }

        /**
         * Set procStep string value
         *
         * @param procStep string value
         * @return Builder this object
         */
        public Builder procStep(final String procStep) {
            this.procStep = procStep;
            return this;
        }

        /**
         * Set recfm string value
         *
         * @param recfm string value
         * @return Builder this object
         */
        public Builder recfm(final String recfm) {
            this.recfm = recfm;
            return this;
        }

        /**
         * Set recordCount long value
         *
         * @param recordCount long value
         * @return Builder this object
         */
        public Builder recordCount(final Long recordCount) {
            this.recordCount = recordCount;
            return this;
        }

        /**
         * Set recordsUrl string value
         *
         * @param recordsUrl string value
         * @return Builder this object
         */
        public Builder recordsUrl(final String recordsUrl) {
            this.recordsUrl = recordsUrl;
            return this;
        }

        /**
         * Set stepName string value
         *
         * @param stepName string value
         * @return Builder this object
         */
        public Builder stepName(final String stepName) {
            this.stepName = stepName;
            return this;
        }

        /**
         * Set subSystem string value
         *
         * @param subSystem string value
         * @return Builder this object
         */
        public Builder subSystem(final String subSystem) {
            this.subSystem = subSystem;
            return this;
        }

        /**
         * Return JobFile object based on Builder this object
         *
         * @return JobFile this object
         */
        public JobFile build() {
            return new JobFile(this);
        }

    }

}
