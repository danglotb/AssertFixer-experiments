/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.customerinsights.implementation;

import java.util.Map;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.management.customerinsights.ProxyResource;

/**
 * The WidgetTypeResourceFormat.
 */
@JsonFlatten
public class WidgetTypeResourceFormatInner extends ProxyResource {
    /**
     * Name of the widget type.
     */
    @JsonProperty(value = "properties.widgetTypeName", access = JsonProperty.Access.WRITE_ONLY)
    private String widgetTypeName;

    /**
     * Definition for widget type.
     */
    @JsonProperty(value = "properties.definition", required = true)
    private String definition;

    /**
     * Description for widget type.
     */
    @JsonProperty(value = "properties.description")
    private String description;

    /**
     * Localized display name for the widget type.
     */
    @JsonProperty(value = "properties.displayName")
    private Map<String, String> displayName;

    /**
     * The image URL.
     */
    @JsonProperty(value = "properties.imageUrl")
    private String imageUrl;

    /**
     * The hub name.
     */
    @JsonProperty(value = "properties.tenantId", access = JsonProperty.Access.WRITE_ONLY)
    private String tenantId;

    /**
     * The widget version.
     */
    @JsonProperty(value = "properties.widgetVersion")
    private String widgetVersion;

    /**
     * Date time when widget type was last modified.
     */
    @JsonProperty(value = "properties.changed", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime changed;

    /**
     * Date time when widget type was created.
     */
    @JsonProperty(value = "properties.created", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime created;

    /**
     * Get the widgetTypeName value.
     *
     * @return the widgetTypeName value
     */
    public String widgetTypeName() {
        return this.widgetTypeName;
    }

    /**
     * Get the definition value.
     *
     * @return the definition value
     */
    public String definition() {
        return this.definition;
    }

    /**
     * Set the definition value.
     *
     * @param definition the definition value to set
     * @return the WidgetTypeResourceFormatInner object itself.
     */
    public WidgetTypeResourceFormatInner withDefinition(String definition) {
        this.definition = definition;
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
     * @return the WidgetTypeResourceFormatInner object itself.
     */
    public WidgetTypeResourceFormatInner withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the displayName value.
     *
     * @return the displayName value
     */
    public Map<String, String> displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName value.
     *
     * @param displayName the displayName value to set
     * @return the WidgetTypeResourceFormatInner object itself.
     */
    public WidgetTypeResourceFormatInner withDisplayName(Map<String, String> displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the imageUrl value.
     *
     * @return the imageUrl value
     */
    public String imageUrl() {
        return this.imageUrl;
    }

    /**
     * Set the imageUrl value.
     *
     * @param imageUrl the imageUrl value to set
     * @return the WidgetTypeResourceFormatInner object itself.
     */
    public WidgetTypeResourceFormatInner withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    /**
     * Get the tenantId value.
     *
     * @return the tenantId value
     */
    public String tenantId() {
        return this.tenantId;
    }

    /**
     * Get the widgetVersion value.
     *
     * @return the widgetVersion value
     */
    public String widgetVersion() {
        return this.widgetVersion;
    }

    /**
     * Set the widgetVersion value.
     *
     * @param widgetVersion the widgetVersion value to set
     * @return the WidgetTypeResourceFormatInner object itself.
     */
    public WidgetTypeResourceFormatInner withWidgetVersion(String widgetVersion) {
        this.widgetVersion = widgetVersion;
        return this;
    }

    /**
     * Get the changed value.
     *
     * @return the changed value
     */
    public DateTime changed() {
        return this.changed;
    }

    /**
     * Get the created value.
     *
     * @return the created value
     */
    public DateTime created() {
        return this.created;
    }

}
