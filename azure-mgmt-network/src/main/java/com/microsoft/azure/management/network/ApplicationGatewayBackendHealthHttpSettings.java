/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network;

import com.microsoft.azure.management.network.implementation.ApplicationGatewayBackendHttpSettingsInner;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Application gateway BackendHealthHttp settings.
 */
public class ApplicationGatewayBackendHealthHttpSettings {
    /**
     * Reference of an ApplicationGatewayBackendHttpSettings resource.
     */
    @JsonProperty(value = "backendHttpSettings")
    private ApplicationGatewayBackendHttpSettingsInner backendHttpSettings;

    /**
     * List of ApplicationGatewayBackendHealthServer resources.
     */
    @JsonProperty(value = "servers")
    private List<ApplicationGatewayBackendHealthServer> servers;

    /**
     * Get the backendHttpSettings value.
     *
     * @return the backendHttpSettings value
     */
    public ApplicationGatewayBackendHttpSettingsInner backendHttpSettings() {
        return this.backendHttpSettings;
    }

    /**
     * Set the backendHttpSettings value.
     *
     * @param backendHttpSettings the backendHttpSettings value to set
     * @return the ApplicationGatewayBackendHealthHttpSettings object itself.
     */
    public ApplicationGatewayBackendHealthHttpSettings withBackendHttpSettings(ApplicationGatewayBackendHttpSettingsInner backendHttpSettings) {
        this.backendHttpSettings = backendHttpSettings;
        return this;
    }

    /**
     * Get the servers value.
     *
     * @return the servers value
     */
    public List<ApplicationGatewayBackendHealthServer> servers() {
        return this.servers;
    }

    /**
     * Set the servers value.
     *
     * @param servers the servers value to set
     * @return the ApplicationGatewayBackendHealthHttpSettings object itself.
     */
    public ApplicationGatewayBackendHealthHttpSettings withServers(List<ApplicationGatewayBackendHealthServer> servers) {
        this.servers = servers;
        return this;
    }

}
