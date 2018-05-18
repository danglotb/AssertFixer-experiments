/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batch.implementation;

import com.microsoft.azure.management.batch.PackageState;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An application package which represents a particular version of an
 * application.
 */
public class ApplicationPackageInner {
    /**
     * The ID of the application.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    /**
     * The version of the application package.
     */
    @JsonProperty(value = "version", access = JsonProperty.Access.WRITE_ONLY)
    private String version;

    /**
     * The current state of the application package. Possible values include:
     * 'Pending', 'Active', 'Unmapped'.
     */
    @JsonProperty(value = "state", access = JsonProperty.Access.WRITE_ONLY)
    private PackageState state;

    /**
     * The format of the application package, if the package is active.
     */
    @JsonProperty(value = "format", access = JsonProperty.Access.WRITE_ONLY)
    private String format;

    /**
     * The URL for the application package in Azure Storage.
     */
    @JsonProperty(value = "storageUrl", access = JsonProperty.Access.WRITE_ONLY)
    private String storageUrl;

    /**
     * The UTC time at which the Azure Storage URL will expire.
     */
    @JsonProperty(value = "storageUrlExpiry", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime storageUrlExpiry;

    /**
     * The time at which the package was last activated, if the package is
     * active.
     */
    @JsonProperty(value = "lastActivationTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime lastActivationTime;

    /**
     * Get the id value.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Get the version value.
     *
     * @return the version value
     */
    public String version() {
        return this.version;
    }

    /**
     * Get the state value.
     *
     * @return the state value
     */
    public PackageState state() {
        return this.state;
    }

    /**
     * Get the format value.
     *
     * @return the format value
     */
    public String format() {
        return this.format;
    }

    /**
     * Get the storageUrl value.
     *
     * @return the storageUrl value
     */
    public String storageUrl() {
        return this.storageUrl;
    }

    /**
     * Get the storageUrlExpiry value.
     *
     * @return the storageUrlExpiry value
     */
    public DateTime storageUrlExpiry() {
        return this.storageUrlExpiry;
    }

    /**
     * Get the lastActivationTime value.
     *
     * @return the lastActivationTime value
     */
    public DateTime lastActivationTime() {
        return this.lastActivationTime;
    }

}
