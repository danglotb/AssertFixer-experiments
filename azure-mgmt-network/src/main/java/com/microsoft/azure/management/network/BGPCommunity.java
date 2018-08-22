/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains bgp community information offered in Service Community resources.
 */
public class BGPCommunity {
    /**
     * The region which the service support. e.g. For O365, region is Global.
     */
    @JsonProperty(value = "serviceSupportedRegion")
    private String serviceSupportedRegion;

    /**
     * The name of the bgp community. e.g. Skype.
     */
    @JsonProperty(value = "communityName")
    private String communityName;

    /**
     * The value of the bgp community. For more information:
     * https://docs.microsoft.com/en-us/azure/expressroute/expressroute-routing.
     */
    @JsonProperty(value = "communityValue")
    private String communityValue;

    /**
     * The prefixes that the bgp community contains.
     */
    @JsonProperty(value = "communityPrefixes")
    private List<String> communityPrefixes;

    /**
     * Customer is authorized to use bgp community or not.
     */
    @JsonProperty(value = "isAuthorizedToUse")
    private Boolean isAuthorizedToUse;

    /**
     * The service group of the bgp community contains.
     */
    @JsonProperty(value = "serviceGroup")
    private String serviceGroup;

    /**
     * Get the serviceSupportedRegion value.
     *
     * @return the serviceSupportedRegion value
     */
    public String serviceSupportedRegion() {
        return this.serviceSupportedRegion;
    }

    /**
     * Set the serviceSupportedRegion value.
     *
     * @param serviceSupportedRegion the serviceSupportedRegion value to set
     * @return the BGPCommunity object itself.
     */
    public BGPCommunity withServiceSupportedRegion(String serviceSupportedRegion) {
        this.serviceSupportedRegion = serviceSupportedRegion;
        return this;
    }

    /**
     * Get the communityName value.
     *
     * @return the communityName value
     */
    public String communityName() {
        return this.communityName;
    }

    /**
     * Set the communityName value.
     *
     * @param communityName the communityName value to set
     * @return the BGPCommunity object itself.
     */
    public BGPCommunity withCommunityName(String communityName) {
        this.communityName = communityName;
        return this;
    }

    /**
     * Get the communityValue value.
     *
     * @return the communityValue value
     */
    public String communityValue() {
        return this.communityValue;
    }

    /**
     * Set the communityValue value.
     *
     * @param communityValue the communityValue value to set
     * @return the BGPCommunity object itself.
     */
    public BGPCommunity withCommunityValue(String communityValue) {
        this.communityValue = communityValue;
        return this;
    }

    /**
     * Get the communityPrefixes value.
     *
     * @return the communityPrefixes value
     */
    public List<String> communityPrefixes() {
        return this.communityPrefixes;
    }

    /**
     * Set the communityPrefixes value.
     *
     * @param communityPrefixes the communityPrefixes value to set
     * @return the BGPCommunity object itself.
     */
    public BGPCommunity withCommunityPrefixes(List<String> communityPrefixes) {
        this.communityPrefixes = communityPrefixes;
        return this;
    }

    /**
     * Get the isAuthorizedToUse value.
     *
     * @return the isAuthorizedToUse value
     */
    public Boolean isAuthorizedToUse() {
        return this.isAuthorizedToUse;
    }

    /**
     * Set the isAuthorizedToUse value.
     *
     * @param isAuthorizedToUse the isAuthorizedToUse value to set
     * @return the BGPCommunity object itself.
     */
    public BGPCommunity withIsAuthorizedToUse(Boolean isAuthorizedToUse) {
        this.isAuthorizedToUse = isAuthorizedToUse;
        return this;
    }

    /**
     * Get the serviceGroup value.
     *
     * @return the serviceGroup value
     */
    public String serviceGroup() {
        return this.serviceGroup;
    }

    /**
     * Set the serviceGroup value.
     *
     * @param serviceGroup the serviceGroup value to set
     * @return the BGPCommunity object itself.
     */
    public BGPCommunity withServiceGroup(String serviceGroup) {
        this.serviceGroup = serviceGroup;
        return this;
    }

}
