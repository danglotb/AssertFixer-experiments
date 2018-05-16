/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalake.store.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Data Lake Store trusted identity provider information.
 */
@JsonFlatten
public class TrustedIdProvider extends SubResource {
    /**
     * The URL of this trusted identity provider.
     */
    @JsonProperty(value = "properties.idProvider", access = JsonProperty.Access.WRITE_ONLY)
    private String idProvider;

    /**
     * Get the idProvider value.
     *
     * @return the idProvider value
     */
    public String idProvider() {
        return this.idProvider;
    }

}
