/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor.implementation;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * An action group object for the body of patch operations.
 */
@JsonFlatten
public class ActionGroupPatchBodyInner {
    /**
     * Resource tags.
     */
    @JsonProperty(value = "tags")
    private Map<String, String> tags;

    /**
     * Indicates whether this action group is enabled. If an action group is
     * not enabled, then none of its actions will be activated.
     */
    @JsonProperty(value = "properties.enabled")
    private Boolean enabled;

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
     * @return the ActionGroupPatchBodyInner object itself.
     */
    public ActionGroupPatchBodyInner withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the enabled value.
     *
     * @return the enabled value
     */
    public Boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled value.
     *
     * @param enabled the enabled value to set
     * @return the ActionGroupPatchBodyInner object itself.
     */
    public ActionGroupPatchBodyInner withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

}
