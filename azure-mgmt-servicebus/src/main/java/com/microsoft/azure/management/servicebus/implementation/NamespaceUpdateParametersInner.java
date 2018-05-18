/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.servicebus.implementation;

import java.util.Map;
import com.microsoft.azure.management.servicebus.Sku;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Parameters supplied to the Patch Namespace operation.
 */
public class NamespaceUpdateParametersInner {
    /**
     * Resource tags.
     */
    @JsonProperty(value = "tags")
    private Map<String, String> tags;

    /**
     * The sku of the created namespace.
     */
    @JsonProperty(value = "sku")
    private Sku sku;

    /**
     * Get the tags value.
     *
     * @return the tags value
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set the tags value.
     *
     * @param tags the tags value to set
     * @return the NamespaceUpdateParametersInner object itself.
     */
    public NamespaceUpdateParametersInner withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the sku value.
     *
     * @return the sku value
     */
    public Sku sku() {
        return this.sku;
    }

    /**
     * Set the sku value.
     *
     * @param sku the sku value to set
     * @return the NamespaceUpdateParametersInner object itself.
     */
    public NamespaceUpdateParametersInner withSku(Sku sku) {
        this.sku = sku;
        return this;
    }

}
