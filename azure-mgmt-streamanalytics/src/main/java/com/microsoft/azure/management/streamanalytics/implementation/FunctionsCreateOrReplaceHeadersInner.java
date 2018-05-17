/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.streamanalytics.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines headers for CreateOrReplace operation.
 */
public class FunctionsCreateOrReplaceHeadersInner {
    /**
     * The current entity tag for the function. This is an opaque string. You
     * can use it to detect whether the resource has changed between requests.
     * You can also use it in the If-Match or If-None-Match headers for write
     * operations for optimistic concurrency.
     */
    @JsonProperty(value = "ETag")
    private String eTag;

    /**
     * Get the eTag value.
     *
     * @return the eTag value
     */
    public String eTag() {
        return this.eTag;
    }

    /**
     * Set the eTag value.
     *
     * @param eTag the eTag value to set
     * @return the FunctionsCreateOrReplaceHeadersInner object itself.
     */
    public FunctionsCreateOrReplaceHeadersInner withETag(String eTag) {
        this.eTag = eTag;
        return this;
    }

}
