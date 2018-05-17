/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.eventhub;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for EntityStatus.
 */
public enum EntityStatus {
    /** Enum value Active. */
    ACTIVE("Active"),

    /** Enum value Disabled. */
    DISABLED("Disabled"),

    /** Enum value Restoring. */
    RESTORING("Restoring"),

    /** Enum value SendDisabled. */
    SEND_DISABLED("SendDisabled"),

    /** Enum value ReceiveDisabled. */
    RECEIVE_DISABLED("ReceiveDisabled"),

    /** Enum value Creating. */
    CREATING("Creating"),

    /** Enum value Deleting. */
    DELETING("Deleting"),

    /** Enum value Renaming. */
    RENAMING("Renaming"),

    /** Enum value Unknown. */
    UNKNOWN("Unknown");

    /** The actual serialized value for a EntityStatus instance. */
    private String value;

    EntityStatus(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a EntityStatus instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed EntityStatus object, or null if unable to parse.
     */
    @JsonCreator
    public static EntityStatus fromString(String value) {
        EntityStatus[] items = EntityStatus.values();
        for (EntityStatus item : items) {
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
