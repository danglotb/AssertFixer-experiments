/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A request to check whether the specified name for a resource is available.
 */
public class CheckNameAvailabilityRequest {
    /**
     * The name whose availability is to be checked.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * The type of resource that is used as the scope of the availability
     * check.
     */
    @JsonProperty(value = "type", required = true)
    private String type;

    /**
     * Creates an instance of CheckNameAvailabilityRequest class.
     */
    public CheckNameAvailabilityRequest() {
        type = "Microsoft.Sql/servers";
    }

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
     * @return the CheckNameAvailabilityRequest object itself.
     */
    public CheckNameAvailabilityRequest withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the type value.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

    /**
     * Set the type value.
     *
     * @param type the type value to set
     * @return the CheckNameAvailabilityRequest object itself.
     */
    public CheckNameAvailabilityRequest withType(String type) {
        this.type = type;
        return this;
    }

}
