/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.relay.implementation;

import org.joda.time.DateTime;
import com.microsoft.azure.management.relay.Relaytype;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * Description of WcfRelays Resource.
 */
@JsonFlatten
public class WcfRelayInner extends Resource {
    /**
     * true if the relay is dynamic; otherwise, false.
     */
    @JsonProperty(value = "properties.isDynamic", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isDynamic;

    /**
     * The time the WCFRelay was created.
     */
    @JsonProperty(value = "properties.createdAt", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime createdAt;

    /**
     * The time the namespace was updated.
     */
    @JsonProperty(value = "properties.updatedAt", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime updatedAt;

    /**
     * The number of listeners for this relay. min :1 and max:25 supported.
     */
    @JsonProperty(value = "properties.listenerCount", access = JsonProperty.Access.WRITE_ONLY)
    private Integer listenerCount;

    /**
     * WCFRelay Type. Possible values include: 'NetTcp', 'Http'.
     */
    @JsonProperty(value = "properties.relayType")
    private Relaytype relayType;

    /**
     * true if client authorization is needed for this relay; otherwise, false.
     */
    @JsonProperty(value = "properties.requiresClientAuthorization")
    private Boolean requiresClientAuthorization;

    /**
     * true if transport security is needed for this relay; otherwise, false.
     */
    @JsonProperty(value = "properties.requiresTransportSecurity")
    private Boolean requiresTransportSecurity;

    /**
     * usermetadata is a placeholder to store user-defined string data for the
     * HybridConnection endpoint.e.g. it can be used to store  descriptive
     * data, such as list of teams and their contact information also
     * user-defined configuration settings can be stored.
     */
    @JsonProperty(value = "properties.userMetadata")
    private String userMetadata;

    /**
     * Get the isDynamic value.
     *
     * @return the isDynamic value
     */
    public Boolean isDynamic() {
        return this.isDynamic;
    }

    /**
     * Get the createdAt value.
     *
     * @return the createdAt value
     */
    public DateTime createdAt() {
        return this.createdAt;
    }

    /**
     * Get the updatedAt value.
     *
     * @return the updatedAt value
     */
    public DateTime updatedAt() {
        return this.updatedAt;
    }

    /**
     * Get the listenerCount value.
     *
     * @return the listenerCount value
     */
    public Integer listenerCount() {
        return this.listenerCount;
    }

    /**
     * Get the relayType value.
     *
     * @return the relayType value
     */
    public Relaytype relayType() {
        return this.relayType;
    }

    /**
     * Set the relayType value.
     *
     * @param relayType the relayType value to set
     * @return the WcfRelayInner object itself.
     */
    public WcfRelayInner withRelayType(Relaytype relayType) {
        this.relayType = relayType;
        return this;
    }

    /**
     * Get the requiresClientAuthorization value.
     *
     * @return the requiresClientAuthorization value
     */
    public Boolean requiresClientAuthorization() {
        return this.requiresClientAuthorization;
    }

    /**
     * Set the requiresClientAuthorization value.
     *
     * @param requiresClientAuthorization the requiresClientAuthorization value to set
     * @return the WcfRelayInner object itself.
     */
    public WcfRelayInner withRequiresClientAuthorization(Boolean requiresClientAuthorization) {
        this.requiresClientAuthorization = requiresClientAuthorization;
        return this;
    }

    /**
     * Get the requiresTransportSecurity value.
     *
     * @return the requiresTransportSecurity value
     */
    public Boolean requiresTransportSecurity() {
        return this.requiresTransportSecurity;
    }

    /**
     * Set the requiresTransportSecurity value.
     *
     * @param requiresTransportSecurity the requiresTransportSecurity value to set
     * @return the WcfRelayInner object itself.
     */
    public WcfRelayInner withRequiresTransportSecurity(Boolean requiresTransportSecurity) {
        this.requiresTransportSecurity = requiresTransportSecurity;
        return this;
    }

    /**
     * Get the userMetadata value.
     *
     * @return the userMetadata value
     */
    public String userMetadata() {
        return this.userMetadata;
    }

    /**
     * Set the userMetadata value.
     *
     * @param userMetadata the userMetadata value to set
     * @return the WcfRelayInner object itself.
     */
    public WcfRelayInner withUserMetadata(String userMetadata) {
        this.userMetadata = userMetadata;
        return this;
    }

}
