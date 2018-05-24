/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.machinelearning;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Information about the machine learning commitment plan associated with the
 * web service.
 */
public class CommitmentPlan {
    /**
     * Specifies the Azure Resource Manager ID of the commitment plan
     * associated with the web service.
     */
    @JsonProperty(value = "id", required = true)
    private String id;

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
     * @return the CommitmentPlan object itself.
     */
    public CommitmentPlan withId(String id) {
        this.id = id;
        return this;
    }

}
