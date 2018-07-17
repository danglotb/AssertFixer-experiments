/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor.implementation;

import org.joda.time.Period;
import java.util.List;
import com.microsoft.azure.management.monitor.Metric;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The response to a metrics query.
 */
public class ResponseInner {
    /**
     * The integer value representing the cost of the query, for data case.
     */
    @JsonProperty(value = "cost")
    private Double cost;

    /**
     * The timespan for which the data was retrieved. Its value consists of two
     * datatimes concatenated, separated by '/'.  This may be adjusted in the
     * future and returned back from what was originally requested.
     */
    @JsonProperty(value = "timespan", required = true)
    private String timespan;

    /**
     * The interval (window size) for which the metric data was returned in.
     * This may be adjusted in the future and returned back from what was
     * originally requested.  This is not present if a metadata request was
     * made.
     */
    @JsonProperty(value = "interval")
    private Period interval;

    /**
     * The namespace of the metrics been queried.
     */
    @JsonProperty(value = "namespace")
    private String namespace;

    /**
     * The region of the resource been queried for metrics.
     */
    @JsonProperty(value = "resourceregion")
    private String resourceregion;

    /**
     * the value of the collection.
     */
    @JsonProperty(value = "value", required = true)
    private List<Metric> value;

    /**
     * Get the cost value.
     *
     * @return the cost value
     */
    public Double cost() {
        return this.cost;
    }

    /**
     * Set the cost value.
     *
     * @param cost the cost value to set
     * @return the ResponseInner object itself.
     */
    public ResponseInner withCost(Double cost) {
        this.cost = cost;
        return this;
    }

    /**
     * Get the timespan value.
     *
     * @return the timespan value
     */
    public String timespan() {
        return this.timespan;
    }

    /**
     * Set the timespan value.
     *
     * @param timespan the timespan value to set
     * @return the ResponseInner object itself.
     */
    public ResponseInner withTimespan(String timespan) {
        this.timespan = timespan;
        return this;
    }

    /**
     * Get the interval value.
     *
     * @return the interval value
     */
    public Period interval() {
        return this.interval;
    }

    /**
     * Set the interval value.
     *
     * @param interval the interval value to set
     * @return the ResponseInner object itself.
     */
    public ResponseInner withInterval(Period interval) {
        this.interval = interval;
        return this;
    }

    /**
     * Get the namespace value.
     *
     * @return the namespace value
     */
    public String namespace() {
        return this.namespace;
    }

    /**
     * Set the namespace value.
     *
     * @param namespace the namespace value to set
     * @return the ResponseInner object itself.
     */
    public ResponseInner withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    /**
     * Get the resourceregion value.
     *
     * @return the resourceregion value
     */
    public String resourceregion() {
        return this.resourceregion;
    }

    /**
     * Set the resourceregion value.
     *
     * @param resourceregion the resourceregion value to set
     * @return the ResponseInner object itself.
     */
    public ResponseInner withResourceregion(String resourceregion) {
        this.resourceregion = resourceregion;
        return this;
    }

    /**
     * Get the value value.
     *
     * @return the value value
     */
    public List<Metric> value() {
        return this.value;
    }

    /**
     * Set the value value.
     *
     * @param value the value value to set
     * @return the ResponseInner object itself.
     */
    public ResponseInner withValue(List<Metric> value) {
        this.value = value;
        return this;
    }

}
