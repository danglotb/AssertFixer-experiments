/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor.implementation;

import java.util.List;
import org.joda.time.DateTime;
import com.microsoft.azure.management.monitor.Baseline;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The response to a calcualte baseline call.
 */
public class CalculateBaselineResponseInner {
    /**
     * the resource type of the baseline resource.
     */
    @JsonProperty(value = "type", required = true)
    private String type;

    /**
     * the array of timestamps of the baselines.
     */
    @JsonProperty(value = "timestamps")
    private List<DateTime> timestamps;

    /**
     * the baseline values for each sensitivity.
     */
    @JsonProperty(value = "baseline", required = true)
    private List<Baseline> baseline;

    /**
     * Get the resource type of the baseline resource.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

    /**
     * Set the resource type of the baseline resource.
     *
     * @param type the type value to set
     * @return the CalculateBaselineResponseInner object itself.
     */
    public CalculateBaselineResponseInner withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get the array of timestamps of the baselines.
     *
     * @return the timestamps value
     */
    public List<DateTime> timestamps() {
        return this.timestamps;
    }

    /**
     * Set the array of timestamps of the baselines.
     *
     * @param timestamps the timestamps value to set
     * @return the CalculateBaselineResponseInner object itself.
     */
    public CalculateBaselineResponseInner withTimestamps(List<DateTime> timestamps) {
        this.timestamps = timestamps;
        return this;
    }

    /**
     * Get the baseline values for each sensitivity.
     *
     * @return the baseline value
     */
    public List<Baseline> baseline() {
        return this.baseline;
    }

    /**
     * Set the baseline values for each sensitivity.
     *
     * @param baseline the baseline value to set
     * @return the CalculateBaselineResponseInner object itself.
     */
    public CalculateBaselineResponseInner withBaseline(List<Baseline> baseline) {
        this.baseline = baseline;
        return this;
    }

}
