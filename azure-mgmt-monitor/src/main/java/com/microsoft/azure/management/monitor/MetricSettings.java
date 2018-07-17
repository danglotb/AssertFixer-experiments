/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor;

import org.joda.time.Period;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Part of MultiTenantDiagnosticSettings. Specifies the settings for a
 * particular metric.
 */
public class MetricSettings {
    /**
     * the timegrain of the metric in ISO8601 format.
     */
    @JsonProperty(value = "timeGrain")
    private Period timeGrain;

    /**
     * Name of a Diagnostic Metric category for a resource type this setting is
     * applied to. To obtain the list of Diagnostic metric categories for a
     * resource, first perform a GET diagnostic settings operation.
     */
    @JsonProperty(value = "category")
    private String category;

    /**
     * a value indicating whether this category is enabled.
     */
    @JsonProperty(value = "enabled", required = true)
    private boolean enabled;

    /**
     * the retention policy for this category.
     */
    @JsonProperty(value = "retentionPolicy")
    private RetentionPolicy retentionPolicy;

    /**
     * Get the timeGrain value.
     *
     * @return the timeGrain value
     */
    public Period timeGrain() {
        return this.timeGrain;
    }

    /**
     * Set the timeGrain value.
     *
     * @param timeGrain the timeGrain value to set
     * @return the MetricSettings object itself.
     */
    public MetricSettings withTimeGrain(Period timeGrain) {
        this.timeGrain = timeGrain;
        return this;
    }

    /**
     * Get the category value.
     *
     * @return the category value
     */
    public String category() {
        return this.category;
    }

    /**
     * Set the category value.
     *
     * @param category the category value to set
     * @return the MetricSettings object itself.
     */
    public MetricSettings withCategory(String category) {
        this.category = category;
        return this;
    }

    /**
     * Get the enabled value.
     *
     * @return the enabled value
     */
    public boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled value.
     *
     * @param enabled the enabled value to set
     * @return the MetricSettings object itself.
     */
    public MetricSettings withEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get the retentionPolicy value.
     *
     * @return the retentionPolicy value
     */
    public RetentionPolicy retentionPolicy() {
        return this.retentionPolicy;
    }

    /**
     * Set the retentionPolicy value.
     *
     * @param retentionPolicy the retentionPolicy value to set
     * @return the MetricSettings object itself.
     */
    public MetricSettings withRetentionPolicy(RetentionPolicy retentionPolicy) {
        this.retentionPolicy = retentionPolicy;
        return this;
    }

}
