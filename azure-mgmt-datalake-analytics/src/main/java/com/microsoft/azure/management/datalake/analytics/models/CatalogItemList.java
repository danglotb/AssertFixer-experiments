/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalake.analytics.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Data Lake Analytics catalog item list.
 */
public class CatalogItemList {
    /**
     * the link to the next page of results.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /**
     * Get the link to the next page of results.
     *
     * @return the nextLink value
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the link to the next page of results.
     *
     * @param nextLink the nextLink value to set
     * @return the CatalogItemList object itself.
     */
    public CatalogItemList withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

}
