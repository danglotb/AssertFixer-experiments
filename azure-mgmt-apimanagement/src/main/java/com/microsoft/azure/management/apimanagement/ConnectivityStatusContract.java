/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Details about connectivity to a resource.
 */
public class ConnectivityStatusContract {
    /**
     * The hostname of the resource which the service depends on. This can be
     * the database, storage or any other azure resource on which the service
     * depends upon.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * Resource Connectivity Status Type identifier. Possible values include:
     * 'initializing', 'success', 'failure'.
     */
    @JsonProperty(value = "status", required = true)
    private ConnectivityStatusType status;

    /**
     * Error details of the connectivity to the resource.
     */
    @JsonProperty(value = "error")
    private String error;

    /**
     * The date when the resource connectivity status was last updated. This
     * status should be updated every 15 minutes. If this status has not been
     * updated, then it means that the service has lost network connectivity to
     * the resource, from inside the Virtual Network.The date conforms to the
     * following format: `yyyy-MM-ddTHH:mm:ssZ` as specified by the ISO 8601
     * standard.
     */
    @JsonProperty(value = "lastUpdated", required = true)
    private DateTime lastUpdated;

    /**
     * The date when the resource connectivity status last Changed from success
     * to failure or vice-versa. The date conforms to the following format:
     * `yyyy-MM-ddTHH:mm:ssZ` as specified by the ISO 8601 standard.
     */
    @JsonProperty(value = "lastStatusChange", required = true)
    private DateTime lastStatusChange;

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     * @return the ConnectivityStatusContract object itself.
     */
    public ConnectivityStatusContract withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the status value.
     *
     * @return the status value
     */
    public ConnectivityStatusType status() {
        return this.status;
    }

    /**
     * Set the status value.
     *
     * @param status the status value to set
     * @return the ConnectivityStatusContract object itself.
     */
    public ConnectivityStatusContract withStatus(ConnectivityStatusType status) {
        this.status = status;
        return this;
    }

    /**
     * Get the error value.
     *
     * @return the error value
     */
    public String error() {
        return this.error;
    }

    /**
     * Set the error value.
     *
     * @param error the error value to set
     * @return the ConnectivityStatusContract object itself.
     */
    public ConnectivityStatusContract withError(String error) {
        this.error = error;
        return this;
    }

    /**
     * Get the lastUpdated value.
     *
     * @return the lastUpdated value
     */
    public DateTime lastUpdated() {
        return this.lastUpdated;
    }

    /**
     * Set the lastUpdated value.
     *
     * @param lastUpdated the lastUpdated value to set
     * @return the ConnectivityStatusContract object itself.
     */
    public ConnectivityStatusContract withLastUpdated(DateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    /**
     * Get the lastStatusChange value.
     *
     * @return the lastStatusChange value
     */
    public DateTime lastStatusChange() {
        return this.lastStatusChange;
    }

    /**
     * Set the lastStatusChange value.
     *
     * @param lastStatusChange the lastStatusChange value to set
     * @return the ConnectivityStatusContract object itself.
     */
    public ConnectivityStatusContract withLastStatusChange(DateTime lastStatusChange) {
        this.lastStatusChange = lastStatusChange;
        return this;
    }

}
