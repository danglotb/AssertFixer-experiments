/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlab;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request body for detaching data disk from a virtual machine.
 */
public class DetachDataDiskProperties {
    /**
     * Specifies the disk resource ID to detach from virtual machine.
     */
    @JsonProperty(value = "existingLabDiskId")
    private String existingLabDiskId;

    /**
     * Get the existingLabDiskId value.
     *
     * @return the existingLabDiskId value
     */
    public String existingLabDiskId() {
        return this.existingLabDiskId;
    }

    /**
     * Set the existingLabDiskId value.
     *
     * @param existingLabDiskId the existingLabDiskId value to set
     * @return the DetachDataDiskProperties object itself.
     */
    public DetachDataDiskProperties withExistingLabDiskId(String existingLabDiskId) {
        this.existingLabDiskId = existingLabDiskId;
        return this;
    }

}
