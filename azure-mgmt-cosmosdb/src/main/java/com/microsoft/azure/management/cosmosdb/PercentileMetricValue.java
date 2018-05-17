/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cosmosdb;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents percentile metrics values.
 */
public class PercentileMetricValue extends MetricValue {
    /**
     * The 10th percentile value for the metric.
     */
    @JsonProperty(value = "P10", access = JsonProperty.Access.WRITE_ONLY)
    private Double p10;

    /**
     * The 25th percentile value for the metric.
     */
    @JsonProperty(value = "P25", access = JsonProperty.Access.WRITE_ONLY)
    private Double p25;

    /**
     * The 50th percentile value for the metric.
     */
    @JsonProperty(value = "P50", access = JsonProperty.Access.WRITE_ONLY)
    private Double p50;

    /**
     * The 75th percentile value for the metric.
     */
    @JsonProperty(value = "P75", access = JsonProperty.Access.WRITE_ONLY)
    private Double p75;

    /**
     * The 90th percentile value for the metric.
     */
    @JsonProperty(value = "P90", access = JsonProperty.Access.WRITE_ONLY)
    private Double p90;

    /**
     * The 95th percentile value for the metric.
     */
    @JsonProperty(value = "P95", access = JsonProperty.Access.WRITE_ONLY)
    private Double p95;

    /**
     * The 99th percentile value for the metric.
     */
    @JsonProperty(value = "P99", access = JsonProperty.Access.WRITE_ONLY)
    private Double p99;

    /**
     * Get the p10 value.
     *
     * @return the p10 value
     */
    public Double p10() {
        return this.p10;
    }

    /**
     * Get the p25 value.
     *
     * @return the p25 value
     */
    public Double p25() {
        return this.p25;
    }

    /**
     * Get the p50 value.
     *
     * @return the p50 value
     */
    public Double p50() {
        return this.p50;
    }

    /**
     * Get the p75 value.
     *
     * @return the p75 value
     */
    public Double p75() {
        return this.p75;
    }

    /**
     * Get the p90 value.
     *
     * @return the p90 value
     */
    public Double p90() {
        return this.p90;
    }

    /**
     * Get the p95 value.
     *
     * @return the p95 value
     */
    public Double p95() {
        return this.p95;
    }

    /**
     * Get the p99 value.
     *
     * @return the p99 value
     */
    public Double p99() {
        return this.p99;
    }

}
