/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batch;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The network configuration for a pool.
 */
public class NetworkConfiguration {
    /**
     * The ARM resource identifier of the virtual network subnet which the
     * compute nodes of the pool will join. This is of the form
     * /subscriptions/{subscription}/resourceGroups/{group}/providers/{provider}/virtualNetworks/{network}/subnets/{subnet}.
     * The virtual network must be in the same region and subscription as the
     * Azure Batch account. The specified subnet should have enough free IP
     * addresses to accommodate the number of nodes in the pool. If the subnet
     * doesn't have enough free IP addresses, the pool will partially allocate
     * compute nodes, and a resize error will occur. The 'MicrosoftAzureBatch'
     * service principal must have the 'Classic Virtual Machine Contributor'
     * Role-Based Access Control (RBAC) role for the specified VNet. The
     * specified subnet must allow communication from the Azure Batch service
     * to be able to schedule tasks on the compute nodes. This can be verified
     * by checking if the specified VNet has any associated Network Security
     * Groups (NSG). If communication to the compute nodes in the specified
     * subnet is denied by an NSG, then the Batch service will set the state of
     * the compute nodes to unusable. For pools created via
     * virtualMachineConfiguration the Batch account must have
     * poolAllocationMode userSubscription in order to use a VNet. If the
     * specified VNet has any associated Network Security Groups (NSG), then a
     * few reserved system ports must be enabled for inbound communication. For
     * pools created with a virtual machine configuration, enable ports 29876
     * and 29877, as well as port 22 for Linux and port 3389 for Windows. For
     * pools created with a cloud service configuration, enable ports 10100,
     * 20100, and 30100. Also enable outbound connections to Azure Storage on
     * port 443. For more details see:
     * https://docs.microsoft.com/en-us/azure/batch/batch-api-basics#virtual-network-vnet-and-firewall-configuration.
     */
    @JsonProperty(value = "subnetId")
    private String subnetId;

    /**
     * The configuration for endpoints on compute nodes in the Batch pool.
     * Pool endpoint configuration is only supported on pools with the
     * virtualMachineConfiguration property.
     */
    @JsonProperty(value = "endpointConfiguration")
    private PoolEndpointConfiguration endpointConfiguration;

    /**
     * Get the subnetId value.
     *
     * @return the subnetId value
     */
    public String subnetId() {
        return this.subnetId;
    }

    /**
     * Set the subnetId value.
     *
     * @param subnetId the subnetId value to set
     * @return the NetworkConfiguration object itself.
     */
    public NetworkConfiguration withSubnetId(String subnetId) {
        this.subnetId = subnetId;
        return this;
    }

    /**
     * Get the endpointConfiguration value.
     *
     * @return the endpointConfiguration value
     */
    public PoolEndpointConfiguration endpointConfiguration() {
        return this.endpointConfiguration;
    }

    /**
     * Set the endpointConfiguration value.
     *
     * @param endpointConfiguration the endpointConfiguration value to set
     * @return the NetworkConfiguration object itself.
     */
    public NetworkConfiguration withEndpointConfiguration(PoolEndpointConfiguration endpointConfiguration) {
        this.endpointConfiguration = endpointConfiguration;
        return this;
    }

}
