/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.customerinsights;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Salesforce discover setting.
 */
public class SalesforceDiscoverSetting {
    /**
     * The salesforce connection string secret URL.
     */
    @JsonProperty(value = "salesforceConnectionStringSecretUrl", required = true)
    private String salesforceConnectionStringSecretUrl;

    /**
     * Get the salesforceConnectionStringSecretUrl value.
     *
     * @return the salesforceConnectionStringSecretUrl value
     */
    public String salesforceConnectionStringSecretUrl() {
        return this.salesforceConnectionStringSecretUrl;
    }

    /**
     * Set the salesforceConnectionStringSecretUrl value.
     *
     * @param salesforceConnectionStringSecretUrl the salesforceConnectionStringSecretUrl value to set
     * @return the SalesforceDiscoverSetting object itself.
     */
    public SalesforceDiscoverSetting withSalesforceConnectionStringSecretUrl(String salesforceConnectionStringSecretUrl) {
        this.salesforceConnectionStringSecretUrl = salesforceConnectionStringSecretUrl;
        return this;
    }

}
