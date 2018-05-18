/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.implementation;

import com.microsoft.azure.management.network.LoadBalancerSku;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * LoadBalancer resource.
 */
@JsonFlatten
@SkipParentValidation
public class LoadBalancerInner extends Resource {
    /**
     * The load balancer SKU.
     */
    @JsonProperty(value = "sku")
    private LoadBalancerSku sku;

    /**
     * Object representing the frontend IPs to be used for the load balancer.
     */
    @JsonProperty(value = "properties.frontendIPConfigurations")
    private List<FrontendIPConfigurationInner> frontendIPConfigurations;

    /**
     * Collection of backend address pools used by a load balancer.
     */
    @JsonProperty(value = "properties.backendAddressPools")
    private List<BackendAddressPoolInner> backendAddressPools;

    /**
     * Object collection representing the load balancing rules Gets the
     * provisioning.
     */
    @JsonProperty(value = "properties.loadBalancingRules")
    private List<LoadBalancingRuleInner> loadBalancingRules;

    /**
     * Collection of probe objects used in the load balancer.
     */
    @JsonProperty(value = "properties.probes")
    private List<ProbeInner> probes;

    /**
     * Collection of inbound NAT Rules used by a load balancer. Defining
     * inbound NAT rules on your load balancer is mutually exclusive with
     * defining an inbound NAT pool. Inbound NAT pools are referenced from
     * virtual machine scale sets. NICs that are associated with individual
     * virtual machines cannot reference an Inbound NAT pool. They have to
     * reference individual inbound NAT rules.
     */
    @JsonProperty(value = "properties.inboundNatRules")
    private List<InboundNatRuleInner> inboundNatRules;

    /**
     * Defines an external port range for inbound NAT to a single backend port
     * on NICs associated with a load balancer. Inbound NAT rules are created
     * automatically for each NIC associated with the Load Balancer using an
     * external port from this range. Defining an Inbound NAT pool on your Load
     * Balancer is mutually exclusive with defining inbound Nat rules. Inbound
     * NAT pools are referenced from virtual machine scale sets. NICs that are
     * associated with individual virtual machines cannot reference an inbound
     * NAT pool. They have to reference individual inbound NAT rules.
     */
    @JsonProperty(value = "properties.inboundNatPools")
    private List<InboundNatPoolInner> inboundNatPools;

    /**
     * The outbound NAT rules.
     */
    @JsonProperty(value = "properties.outboundNatRules")
    private List<OutboundNatRuleInner> outboundNatRules;

    /**
     * The resource GUID property of the load balancer resource.
     */
    @JsonProperty(value = "properties.resourceGuid")
    private String resourceGuid;

    /**
     * Gets the provisioning state of the PublicIP resource. Possible values
     * are: 'Updating', 'Deleting', and 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState")
    private String provisioningState;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag")
    private String etag;

    /**
     * Resource ID.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * Get the sku value.
     *
     * @return the sku value
     */
    public LoadBalancerSku sku() {
        return this.sku;
    }

    /**
     * Set the sku value.
     *
     * @param sku the sku value to set
     * @return the LoadBalancerInner object itself.
     */
    public LoadBalancerInner withSku(LoadBalancerSku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the frontendIPConfigurations value.
     *
     * @return the frontendIPConfigurations value
     */
    public List<FrontendIPConfigurationInner> frontendIPConfigurations() {
        return this.frontendIPConfigurations;
    }

    /**
     * Set the frontendIPConfigurations value.
     *
     * @param frontendIPConfigurations the frontendIPConfigurations value to set
     * @return the LoadBalancerInner object itself.
     */
    public LoadBalancerInner withFrontendIPConfigurations(List<FrontendIPConfigurationInner> frontendIPConfigurations) {
        this.frontendIPConfigurations = frontendIPConfigurations;
        return this;
    }

    /**
     * Get the backendAddressPools value.
     *
     * @return the backendAddressPools value
     */
    public List<BackendAddressPoolInner> backendAddressPools() {
        return this.backendAddressPools;
    }

    /**
     * Set the backendAddressPools value.
     *
     * @param backendAddressPools the backendAddressPools value to set
     * @return the LoadBalancerInner object itself.
     */
    public LoadBalancerInner withBackendAddressPools(List<BackendAddressPoolInner> backendAddressPools) {
        this.backendAddressPools = backendAddressPools;
        return this;
    }

    /**
     * Get the loadBalancingRules value.
     *
     * @return the loadBalancingRules value
     */
    public List<LoadBalancingRuleInner> loadBalancingRules() {
        return this.loadBalancingRules;
    }

    /**
     * Set the loadBalancingRules value.
     *
     * @param loadBalancingRules the loadBalancingRules value to set
     * @return the LoadBalancerInner object itself.
     */
    public LoadBalancerInner withLoadBalancingRules(List<LoadBalancingRuleInner> loadBalancingRules) {
        this.loadBalancingRules = loadBalancingRules;
        return this;
    }

    /**
     * Get the probes value.
     *
     * @return the probes value
     */
    public List<ProbeInner> probes() {
        return this.probes;
    }

    /**
     * Set the probes value.
     *
     * @param probes the probes value to set
     * @return the LoadBalancerInner object itself.
     */
    public LoadBalancerInner withProbes(List<ProbeInner> probes) {
        this.probes = probes;
        return this;
    }

    /**
     * Get the inboundNatRules value.
     *
     * @return the inboundNatRules value
     */
    public List<InboundNatRuleInner> inboundNatRules() {
        return this.inboundNatRules;
    }

    /**
     * Set the inboundNatRules value.
     *
     * @param inboundNatRules the inboundNatRules value to set
     * @return the LoadBalancerInner object itself.
     */
    public LoadBalancerInner withInboundNatRules(List<InboundNatRuleInner> inboundNatRules) {
        this.inboundNatRules = inboundNatRules;
        return this;
    }

    /**
     * Get the inboundNatPools value.
     *
     * @return the inboundNatPools value
     */
    public List<InboundNatPoolInner> inboundNatPools() {
        return this.inboundNatPools;
    }

    /**
     * Set the inboundNatPools value.
     *
     * @param inboundNatPools the inboundNatPools value to set
     * @return the LoadBalancerInner object itself.
     */
    public LoadBalancerInner withInboundNatPools(List<InboundNatPoolInner> inboundNatPools) {
        this.inboundNatPools = inboundNatPools;
        return this;
    }

    /**
     * Get the outboundNatRules value.
     *
     * @return the outboundNatRules value
     */
    public List<OutboundNatRuleInner> outboundNatRules() {
        return this.outboundNatRules;
    }

    /**
     * Set the outboundNatRules value.
     *
     * @param outboundNatRules the outboundNatRules value to set
     * @return the LoadBalancerInner object itself.
     */
    public LoadBalancerInner withOutboundNatRules(List<OutboundNatRuleInner> outboundNatRules) {
        this.outboundNatRules = outboundNatRules;
        return this;
    }

    /**
     * Get the resourceGuid value.
     *
     * @return the resourceGuid value
     */
    public String resourceGuid() {
        return this.resourceGuid;
    }

    /**
     * Set the resourceGuid value.
     *
     * @param resourceGuid the resourceGuid value to set
     * @return the LoadBalancerInner object itself.
     */
    public LoadBalancerInner withResourceGuid(String resourceGuid) {
        this.resourceGuid = resourceGuid;
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
     * @return the LoadBalancerInner object itself.
     */
    public LoadBalancerInner withProvisioningState(String provisioningState) {
        this.provisioningState = provisioningState;
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
     * @return the LoadBalancerInner object itself.
     */
    public LoadBalancerInner withEtag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Get the id value.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id value.
     *
     * @param id the id value to set
     * @return the LoadBalancerInner object itself.
     */
    public LoadBalancerInner withId(String id) {
        this.id = id;
        return this;
    }

}
