/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalake.analytics.models;

import java.util.UUID;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Recurrence job information for a specific recurrence.
 */
public class JobRecurrenceInformation {
    /**
     * The recurrence identifier (a GUID), unique per activity/script,
     * regardless of iterations. This is something to link different
     * occurrences of the same job together.
     */
    @JsonProperty(value = "recurrenceId", access = JsonProperty.Access.WRITE_ONLY)
    private UUID recurrenceId;

    /**
     * The recurrence name, user friendly name for the correlation between
     * jobs.
     */
    @JsonProperty(value = "recurrenceName", access = JsonProperty.Access.WRITE_ONLY)
    private String recurrenceName;

    /**
     * The number of jobs in this recurrence that have failed.
     */
    @JsonProperty(value = "numJobsFailed", access = JsonProperty.Access.WRITE_ONLY)
    private Integer numJobsFailed;

    /**
     * The number of jobs in this recurrence that have been canceled.
     */
    @JsonProperty(value = "numJobsCanceled", access = JsonProperty.Access.WRITE_ONLY)
    private Integer numJobsCanceled;

    /**
     * The number of jobs in this recurrence that have succeeded.
     */
    @JsonProperty(value = "numJobsSucceeded", access = JsonProperty.Access.WRITE_ONLY)
    private Integer numJobsSucceeded;

    /**
     * The number of job execution hours that resulted in failed jobs.
     */
    @JsonProperty(value = "auHoursFailed", access = JsonProperty.Access.WRITE_ONLY)
    private Double auHoursFailed;

    /**
     * The number of job execution hours that resulted in canceled jobs.
     */
    @JsonProperty(value = "auHoursCanceled", access = JsonProperty.Access.WRITE_ONLY)
    private Double auHoursCanceled;

    /**
     * The number of job execution hours that resulted in successful jobs.
     */
    @JsonProperty(value = "auHoursSucceeded", access = JsonProperty.Access.WRITE_ONLY)
    private Double auHoursSucceeded;

    /**
     * The last time a job in this recurrence was submitted.
     */
    @JsonProperty(value = "lastSubmitTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime lastSubmitTime;

    /**
     * Get the recurrence identifier (a GUID), unique per activity/script, regardless of iterations. This is something to link different occurrences of the same job together.
     *
     * @return the recurrenceId value
     */
    public UUID recurrenceId() {
        return this.recurrenceId;
    }

    /**
     * Get the recurrence name, user friendly name for the correlation between jobs.
     *
     * @return the recurrenceName value
     */
    public String recurrenceName() {
        return this.recurrenceName;
    }

    /**
     * Get the number of jobs in this recurrence that have failed.
     *
     * @return the numJobsFailed value
     */
    public Integer numJobsFailed() {
        return this.numJobsFailed;
    }

    /**
     * Get the number of jobs in this recurrence that have been canceled.
     *
     * @return the numJobsCanceled value
     */
    public Integer numJobsCanceled() {
        return this.numJobsCanceled;
    }

    /**
     * Get the number of jobs in this recurrence that have succeeded.
     *
     * @return the numJobsSucceeded value
     */
    public Integer numJobsSucceeded() {
        return this.numJobsSucceeded;
    }

    /**
     * Get the number of job execution hours that resulted in failed jobs.
     *
     * @return the auHoursFailed value
     */
    public Double auHoursFailed() {
        return this.auHoursFailed;
    }

    /**
     * Get the number of job execution hours that resulted in canceled jobs.
     *
     * @return the auHoursCanceled value
     */
    public Double auHoursCanceled() {
        return this.auHoursCanceled;
    }

    /**
     * Get the number of job execution hours that resulted in successful jobs.
     *
     * @return the auHoursSucceeded value
     */
    public Double auHoursSucceeded() {
        return this.auHoursSucceeded;
    }

    /**
     * Get the last time a job in this recurrence was submitted.
     *
     * @return the lastSubmitTime value
     */
    public DateTime lastSubmitTime() {
        return this.lastSubmitTime;
    }

}
