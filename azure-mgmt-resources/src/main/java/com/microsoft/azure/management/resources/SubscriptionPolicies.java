/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Subscription policies.
 */
public class SubscriptionPolicies {
    /**
     * The subscription location placement ID. The ID indicates which regions
     * are visible for a subscription. For example, a subscription with a
     * location placement Id of Public_2014-09-01 has access to Azure public
     * regions.
     */
    @JsonProperty(value = "locationPlacementId", access = JsonProperty.Access.WRITE_ONLY)
    private String locationPlacementId;

    /**
     * The subscription quota ID.
     */
    @JsonProperty(value = "quotaId", access = JsonProperty.Access.WRITE_ONLY)
    private String quotaId;

    /**
     * The subscription spending limit. Possible values include: 'On', 'Off',
     * 'CurrentPeriodOff'.
     */
    @JsonProperty(value = "spendingLimit", access = JsonProperty.Access.WRITE_ONLY)
    private SpendingLimit spendingLimit;

    /**
     * Get the locationPlacementId value.
     *
     * @return the locationPlacementId value
     */
    public String locationPlacementId() {
        return this.locationPlacementId;
    }

    /**
     * Get the quotaId value.
     *
     * @return the quotaId value
     */
    public String quotaId() {
        return this.quotaId;
    }

    /**
     * Get the spendingLimit value.
     *
     * @return the spendingLimit value
     */
    public SpendingLimit spendingLimit() {
        return this.spendingLimit;
    }

}
