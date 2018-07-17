/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies the retention policy for the log.
 */
public class RetentionPolicy {
    /**
     * a value indicating whether the retention policy is enabled.
     */
    @JsonProperty(value = "enabled", required = true)
    private boolean enabled;

    /**
     * the number of days for the retention in days. A value of 0 will retain
     * the events indefinitely.
     */
    @JsonProperty(value = "days", required = true)
    private int days;

    /**
     * Get the enabled value.
     *
     * @return the enabled value
     */
    public boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled value.
     *
     * @param enabled the enabled value to set
     * @return the RetentionPolicy object itself.
     */
    public RetentionPolicy withEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get the days value.
     *
     * @return the days value
     */
    public int days() {
        return this.days;
    }

    /**
     * Set the days value.
     *
     * @param days the days value to set
     * @return the RetentionPolicy object itself.
     */
    public RetentionPolicy withDays(int days) {
        this.days = days;
        return this;
    }

}
