/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for JobScheduleType.
 */
public enum JobScheduleType {
    /** Enum value Once. */
    ONCE("Once"),

    /** Enum value Recurring. */
    RECURRING("Recurring");

    /** The actual serialized value for a JobScheduleType instance. */
    private String value;

    JobScheduleType(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a JobScheduleType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed JobScheduleType object, or null if unable to parse.
     */
    @JsonCreator
    public static JobScheduleType fromString(String value) {
        JobScheduleType[] items = JobScheduleType.values();
        for (JobScheduleType item : items) {
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
