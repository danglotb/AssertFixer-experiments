/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.search;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for SkuName.
 */
public enum SkuName {
    /** Enum value free. */
    FREE("free"),

    /** Enum value basic. */
    BASIC("basic"),

    /** Enum value standard. */
    STANDARD("standard"),

    /** Enum value standard2. */
    STANDARD2("standard2"),

    /** Enum value standard3. */
    STANDARD3("standard3");

    /** The actual serialized value for a SkuName instance. */
    private String value;

    SkuName(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a SkuName instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed SkuName object, or null if unable to parse.
     */
    @JsonCreator
    public static SkuName fromString(String value) {
        SkuName[] items = SkuName.values();
        for (SkuName item : items) {
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
