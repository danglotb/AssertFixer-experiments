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
 * Api Version set base parameters.
 */
public class ApiVersionSetEntityBase {
    /**
     * Description of API Version Set.
     */
    @JsonProperty(value = "description")
    private String description;

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
     * @return the ApiVersionSetEntityBase object itself.
     */
    public ApiVersionSetEntityBase withDescription(String description) {
        this.description = description;
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
     * @return the ApiVersionSetEntityBase object itself.
     */
    public ApiVersionSetEntityBase withVersionQueryName(String versionQueryName) {
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
     * @return the ApiVersionSetEntityBase object itself.
     */
    public ApiVersionSetEntityBase withVersionHeaderName(String versionHeaderName) {
        this.versionHeaderName = versionHeaderName;
        return this;
    }

}
