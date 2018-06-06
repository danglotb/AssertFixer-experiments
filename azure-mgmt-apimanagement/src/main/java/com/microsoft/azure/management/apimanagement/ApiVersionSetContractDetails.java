/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An API Version Set contains the common configuration for a set of API
 * Versions relating.
 */
public class ApiVersionSetContractDetails {
    /**
     * Identifier for existing API Version Set. Omit this value to create a new
     * Version Set.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * Description of API Version Set.
     */
    @JsonProperty(value = "description")
    private String description;

    /**
     * An value that determines where the API Version identifer will be located
     * in a HTTP request. Possible values include: 'Segment', 'Query',
     * 'Header'.
     */
    @JsonProperty(value = "versioningScheme")
    private String versioningScheme;

    /**
     * Name of query parameter that indicates the API Version if
     * versioningScheme is set to `query`.
     */
    @JsonProperty(value = "versionQueryName")
    private String versionQueryName;

    /**
     * Name of HTTP header parameter that indicates the API Version if
     * versioningScheme is set to `header`.
     */
    @JsonProperty(value = "versionHeaderName")
    private String versionHeaderName;

    /**
     * Get the id value.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id value.
     *
     * @param id the id value to set
     * @return the ApiVersionSetContractDetails object itself.
     */
    public ApiVersionSetContractDetails withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the description value.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description value.
     *
     * @param description the description value to set
     * @return the ApiVersionSetContractDetails object itself.
     */
    public ApiVersionSetContractDetails withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the versioningScheme value.
     *
     * @return the versioningScheme value
     */
    public String versioningScheme() {
        return this.versioningScheme;
    }

    /**
     * Set the versioningScheme value.
     *
     * @param versioningScheme the versioningScheme value to set
     * @return the ApiVersionSetContractDetails object itself.
     */
    public ApiVersionSetContractDetails withVersioningScheme(String versioningScheme) {
        this.versioningScheme = versioningScheme;
        return this;
    }

    /**
     * Get the versionQueryName value.
     *
     * @return the versionQueryName value
     */
    public String versionQueryName() {
        return this.versionQueryName;
    }

    /**
     * Set the versionQueryName value.
     *
     * @param versionQueryName the versionQueryName value to set
     * @return the ApiVersionSetContractDetails object itself.
     */
    public ApiVersionSetContractDetails withVersionQueryName(String versionQueryName) {
        this.versionQueryName = versionQueryName;
        return this;
    }

    /**
     * Get the versionHeaderName value.
     *
     * @return the versionHeaderName value
     */
    public String versionHeaderName() {
        return this.versionHeaderName;
    }

    /**
     * Set the versionHeaderName value.
     *
     * @param versionHeaderName the versionHeaderName value to set
     * @return the ApiVersionSetContractDetails object itself.
     */
    public ApiVersionSetContractDetails withVersionHeaderName(String versionHeaderName) {
        this.versionHeaderName = versionHeaderName;
        return this;
    }

}
