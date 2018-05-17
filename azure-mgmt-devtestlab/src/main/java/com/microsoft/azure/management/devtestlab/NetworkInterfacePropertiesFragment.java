/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlab;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Properties of a network interface.
 */
public class NetworkInterfacePropertiesFragment {
    /**
     * The resource ID of the virtual network.
     */
    @JsonProperty(value = "virtualNetworkId")
    private String virtualNetworkId;

    /**
     * The resource ID of the sub net.
     */
    @JsonProperty(value = "subnetId")
    private String subnetId;

    /**
     * The resource ID of the public IP address.
     */
    @JsonProperty(value = "publicIpAddressId")
    private String publicIpAddressId;

    /**
     * The public IP address.
     */
    @JsonProperty(value = "publicIpAddress")
    private String publicIpAddress;

    /**
     * The private IP address.
     */
    @JsonProperty(value = "privateIpAddress")
    private String privateIpAddress;

    /**
     * The DNS name.
     */
    @JsonProperty(value = "dnsName")
    private String dnsName;

    /**
     * The RdpAuthority property is a server DNS host name or IP address
     * followed by the service port number for RDP (Remote Desktop Protocol).
     */
    @JsonProperty(value = "rdpAuthority")
    private String rdpAuthority;

    /**
     * The SshAuthority property is a server DNS host name or IP address
     * followed by the service port number for SSH.
     */
    @JsonProperty(value = "sshAuthority")
    private String sshAuthority;

    /**
     * The configuration for sharing a public IP address across multiple
     * virtual machines.
     */
    @JsonProperty(value = "sharedPublicIpAddressConfiguration")
    private SharedPublicIpAddressConfigurationFragment sharedPublicIpAddressConfiguration;

    /**
     * Get the virtualNetworkId value.
     *
     * @return the virtualNetworkId value
     */
    public String virtualNetworkId() {
        return this.virtualNetworkId;
    }

    /**
     * Set the virtualNetworkId value.
     *
     * @param virtualNetworkId the virtualNetworkId value to set
     * @return the NetworkInterfacePropertiesFragment object itself.
     */
    public NetworkInterfacePropertiesFragment withVirtualNetworkId(String virtualNetworkId) {
        this.virtualNetworkId = virtualNetworkId;
        return this;
    }

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
     * @return the NetworkInterfacePropertiesFragment object itself.
     */
    public NetworkInterfacePropertiesFragment withSubnetId(String subnetId) {
        this.subnetId = subnetId;
        return this;
    }

    /**
     * Get the publicIpAddressId value.
     *
     * @return the publicIpAddressId value
     */
    public String publicIpAddressId() {
        return this.publicIpAddressId;
    }

    /**
     * Set the publicIpAddressId value.
     *
     * @param publicIpAddressId the publicIpAddressId value to set
     * @return the NetworkInterfacePropertiesFragment object itself.
     */
    public NetworkInterfacePropertiesFragment withPublicIpAddressId(String publicIpAddressId) {
        this.publicIpAddressId = publicIpAddressId;
        return this;
    }

    /**
     * Get the publicIpAddress value.
     *
     * @return the publicIpAddress value
     */
    public String publicIpAddress() {
        return this.publicIpAddress;
    }

    /**
     * Set the publicIpAddress value.
     *
     * @param publicIpAddress the publicIpAddress value to set
     * @return the NetworkInterfacePropertiesFragment object itself.
     */
    public NetworkInterfacePropertiesFragment withPublicIpAddress(String publicIpAddress) {
        this.publicIpAddress = publicIpAddress;
        return this;
    }

    /**
     * Get the privateIpAddress value.
     *
     * @return the privateIpAddress value
     */
    public String privateIpAddress() {
        return this.privateIpAddress;
    }

    /**
     * Set the privateIpAddress value.
     *
     * @param privateIpAddress the privateIpAddress value to set
     * @return the NetworkInterfacePropertiesFragment object itself.
     */
    public NetworkInterfacePropertiesFragment withPrivateIpAddress(String privateIpAddress) {
        this.privateIpAddress = privateIpAddress;
        return this;
    }

    /**
     * Get the dnsName value.
     *
     * @return the dnsName value
     */
    public String dnsName() {
        return this.dnsName;
    }

    /**
     * Set the dnsName value.
     *
     * @param dnsName the dnsName value to set
     * @return the NetworkInterfacePropertiesFragment object itself.
     */
    public NetworkInterfacePropertiesFragment withDnsName(String dnsName) {
        this.dnsName = dnsName;
        return this;
    }

    /**
     * Get the rdpAuthority value.
     *
     * @return the rdpAuthority value
     */
    public String rdpAuthority() {
        return this.rdpAuthority;
    }

    /**
     * Set the rdpAuthority value.
     *
     * @param rdpAuthority the rdpAuthority value to set
     * @return the NetworkInterfacePropertiesFragment object itself.
     */
    public NetworkInterfacePropertiesFragment withRdpAuthority(String rdpAuthority) {
        this.rdpAuthority = rdpAuthority;
        return this;
    }

    /**
     * Get the sshAuthority value.
     *
     * @return the sshAuthority value
     */
    public String sshAuthority() {
        return this.sshAuthority;
    }

    /**
     * Set the sshAuthority value.
     *
     * @param sshAuthority the sshAuthority value to set
     * @return the NetworkInterfacePropertiesFragment object itself.
     */
    public NetworkInterfacePropertiesFragment withSshAuthority(String sshAuthority) {
        this.sshAuthority = sshAuthority;
        return this;
    }

    /**
     * Get the sharedPublicIpAddressConfiguration value.
     *
     * @return the sharedPublicIpAddressConfiguration value
     */
    public SharedPublicIpAddressConfigurationFragment sharedPublicIpAddressConfiguration() {
        return this.sharedPublicIpAddressConfiguration;
    }

    /**
     * Set the sharedPublicIpAddressConfiguration value.
     *
     * @param sharedPublicIpAddressConfiguration the sharedPublicIpAddressConfiguration value to set
     * @return the NetworkInterfacePropertiesFragment object itself.
     */
    public NetworkInterfacePropertiesFragment withSharedPublicIpAddressConfiguration(SharedPublicIpAddressConfigurationFragment sharedPublicIpAddressConfiguration) {
        this.sharedPublicIpAddressConfiguration = sharedPublicIpAddressConfiguration;
        return this;
    }

}
