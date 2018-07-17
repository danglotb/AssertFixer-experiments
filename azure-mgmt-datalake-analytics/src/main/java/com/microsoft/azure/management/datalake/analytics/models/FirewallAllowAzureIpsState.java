/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalake.analytics.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for FirewallAllowAzureIpsState.
 */
public enum FirewallAllowAzureIpsState {
    /** Enum value Enabled. */
    ENABLED("Enabled"),

    /** Enum value Disabled. */
    DISABLED("Disabled");

    /** The actual serialized value for a FirewallAllowAzureIpsState instance. */
    private String value;

    FirewallAllowAzureIpsState(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a FirewallAllowAzureIpsState instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed FirewallAllowAzureIpsState object, or null if unable to parse.
     */
    @JsonCreator
    public static FirewallAllowAzureIpsState fromString(String value) {
        FirewallAllowAzureIpsState[] items = FirewallAllowAzureIpsState.values();
        for (FirewallAllowAzureIpsState item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
