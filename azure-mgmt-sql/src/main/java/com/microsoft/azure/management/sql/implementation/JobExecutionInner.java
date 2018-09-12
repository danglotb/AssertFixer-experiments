/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.implementation;

import java.util.UUID;
import com.microsoft.azure.management.sql.JobExecutionLifecycle;
import com.microsoft.azure.management.sql.ProvisioningState;
import org.joda.time.DateTime;
import com.microsoft.azure.management.sql.JobExecutionTarget;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * An execution of a job.
 */
@JsonFlatten
public class JobExecutionInner extends ProxyResourceInner {
    /**
     * The job version number.
     */
    @JsonProperty(value = "properties.jobVersion", access = JsonProperty.Access.WRITE_ONLY)
    private Integer jobVersion;

    /**
     * The job step name.
     */
    @JsonProperty(value = "properties.stepName", access = JsonProperty.Access.WRITE_ONLY)
    private String stepName;

    /**
     * The job step id.
     */
    @JsonProperty(value = "properties.stepId", access = JsonProperty.Access.WRITE_ONLY)
    private Integer stepId;

    /**
     * The unique identifier of the job execution.
     */
    @JsonProperty(value = "properties.jobExecutionId", access = JsonProperty.Access.WRITE_ONLY)
    private UUID jobExecutionId;

    /**
     * The detailed state of the job execution. Possible values include:
     * 'Created', 'InProgress', 'WaitingForChildJobExecutions',
     * 'WaitingForRetry', 'Succeeded', 'SucceededWithSkipped', 'Failed',
     * 'TimedOut', 'Canceled', 'Skipped'.
     */
    @JsonProperty(value = "properties.lifecycle", access = JsonProperty.Access.WRITE_ONLY)
    private JobExecutionLifecycle lifecycle;

    /**
     * The ARM provisioning state of the job execution. Possible values
     * include: 'Created', 'InProgress', 'Succeeded', 'Failed', 'Canceled'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * The time that the job execution was created.
     */
    @JsonProperty(value = "properties.createTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime createTime;

    /**
     * The time that the job execution started.
     */
    @JsonProperty(value = "properties.startTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime startTime;

    /**
     * The time that the job execution completed.
     */
    @JsonProperty(value = "properties.endTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime endTime;

    /**
     * Number of times the job execution has been attempted.
     */
    @JsonProperty(value = "properties.currentAttempts")
    private Integer currentAttempts;

    /**
     * Start time of the current attempt.
     */
    @JsonProperty(value = "properties.currentAttemptStartTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime currentAttemptStartTime;

    /**
     * The last status or error message.
     */
    @JsonProperty(value = "properties.lastMessage", access = JsonProperty.Access.WRITE_ONLY)
    private String lastMessage;

    /**
     * The target that this execution is executed on.
     */
    @JsonProperty(value = "properties.target", access = JsonProperty.Access.WRITE_ONLY)
    private JobExecutionTarget target;

    /**
     * Get the jobVersion value.
     *
     * @return the jobVersion value
     */
    public Integer jobVersion() {
        return this.jobVersion;
    }

    /**
     * Get the stepName value.
     *
     * @return the stepName value
     */
    public String stepName() {
        return this.stepName;
    }

    /**
     * Get the stepId value.
     *
     * @return the stepId value
     */
    public Integer stepId() {
        return this.stepId;
    }

    /**
     * Get the jobExecutionId value.
     *
     * @return the jobExecutionId value
     */
    public UUID jobExecutionId() {
        return this.jobExecutionId;
    }

    /**
     * Get the lifecycle value.
     *
     * @return the lifecycle value
     */
    public JobExecutionLifecycle lifecycle() {
        return this.lifecycle;
    }

    /**
     * Get the provisioningState value.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the createTime value.
     *
     * @return the createTime value
     */
    public DateTime createTime() {
        return this.createTime;
    }

    /**
     * Get the startTime value.
     *
     * @return the startTime value
     */
    public DateTime startTime() {
        return this.startTime;
    }

    /**
     * Get the endTime value.
     *
     * @return the endTime value
     */
    public DateTime endTime() {
        return this.endTime;
    }

    /**
     * Get the currentAttempts value.
     *
     * @return the currentAttempts value
     */
    public Integer currentAttempts() {
        return this.currentAttempts;
    }

    /**
     * Set the currentAttempts value.
     *
     * @param currentAttempts the currentAttempts value to set
     * @return the JobExecutionInner object itself.
     */
    public JobExecutionInner withCurrentAttempts(Integer currentAttempts) {
        this.currentAttempts = currentAttempts;
        return this;
    }

    /**
     * Get the currentAttemptStartTime value.
     *
     * @return the currentAttemptStartTime value
     */
    public DateTime currentAttemptStartTime() {
        return this.currentAttemptStartTime;
    }

    /**
     * Get the lastMessage value.
     *
     * @return the lastMessage value
     */
    public String lastMessage() {
        return this.lastMessage;
    }

    /**
     * Get the target value.
     *
     * @return the target value
     */
    public JobExecutionTarget target() {
        return this.target;
    }

}
