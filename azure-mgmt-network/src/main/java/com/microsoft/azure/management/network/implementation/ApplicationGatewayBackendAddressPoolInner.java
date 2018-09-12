/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.implementation;

import java.util.List;
import com.microsoft.azure.management.network.ApplicationGatewayBackendAddress;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.SubResource;

/**
 * Backend Address Pool of an application gateway.
 */
@JsonFlatten
public class ApplicationGatewayBackendAddressPoolInner extends SubResource {
    /**
     * Collection of references to IPs defined in network interfaces.
     */
    @JsonProperty(value = "properties.backendIPConfigurations")
    private List<NetworkInterfaceIPConfigurationInner> backendIPConfigurations;

    /**
     * Backend addresses.
     */
    @JsonProperty(value = "properties.backendAddresses")
    private List<ApplicationGatewayBackendAddress> backendAddresses;

    /**
     * Provisioning state of the backend address pool resource. Possible values
     * are: 'Updating', 'Deleting', and 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState")
    private String provisioningState;

    /**
     * Name of the backend address pool that is unique within an Application
     * Gateway.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag")
    private String etag;

    /**
     * Type of the resource.
     */
    @JsonProperty(value = "type")
    private String type;

    /**
     * Get the backendIPConfigurations value.
     *
     * @return the backendIPConfigurations value
     */
    public List<NetworkInterfaceIPConfigurationInner> backendIPConfigurations() {
        return this.backendIPConfigurations;
    }

    /**
     * Set the backendIPConfigurations value.
     *
     * @param backendIPConfigurations the backendIPConfigurations value to set
     * @return the ApplicationGatewayBackendAddressPoolInner object itself.
     */
    public ApplicationGatewayBackendAddressPoolInner withBackendIPConfigurations(List<NetworkInterfaceIPConfigurationInner> backendIPConfigurations) {
        this.backendIPConfigurations = backendIPConfigurations;
        return this;
    }

    /**
     * Get the backendAddresses value.
     *
     * @return the backendAddresses value
     */
    public List<ApplicationGatewayBackendAddress> backendAddresses() {
        return this.backendAddresses;
    }

    /**
     * Set the backendAddresses value.
     *
     * @param backendAddresses the backendAddresses value to set
     * @return the ApplicationGatewayBackendAddressPoolInner object itself.
     */
    public ApplicationGatewayBackendAddressPoolInner withBackendAddresses(List<ApplicationGatewayBackendAddress> backendAddresses) {
        this.backendAddresses = backendAddresses;
        return this;
    }

    /**
     * Get the provisioningState value.
     *
     * @return the provisioningState value
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Set the provisioningState value.
     *
     * @param provisioningState the provisioningState value to set
     * @return the ApplicationGatewayBackendAddressPoolInner object itself.
     */
    public ApplicationGatewayBackendAddressPoolInner withProvisioningState(String provisioningState) {
        this.provisioningState = provisioningState;
        return this;
    }

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     * @return the ApplicationGatewayBackendAddressPoolInner object itself.
     */
    public ApplicationGatewayBackendAddressPoolInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the etag value.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Set the etag value.
     *
     * @param etag the etag value to set
     * @return the ApplicationGatewayBackendAddressPoolInner object itself.
     */
    public ApplicationGatewayBackendAddressPoolInner withEtag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Get the type value.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

    /**
     * Set the type value.
     *
     * @param type the type value to set
     * @return the ApplicationGatewayBackendAddressPoolInner object itself.
     */
    public ApplicationGatewayBackendAddressPoolInner withType(String type) {
        this.type = type;
        return this;
    }

}
