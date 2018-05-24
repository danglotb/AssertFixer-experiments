/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalake.store.models;

import java.util.Map;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Data Lake Store account information to update.
 */
@JsonFlatten
public class UpdateDataLakeStoreAccountParameters {
    /**
     * Resource tags.
     */
    @JsonProperty(value = "tags")
    private Map<String, String> tags;

    /**
     * The default owner group for all new folders and files created in the
     * Data Lake Store account.
     */
    @JsonProperty(value = "properties.defaultGroup")
    private String defaultGroup;

    /**
     * Used for rotation of user managed Key Vault keys. Can only be used to
     * rotate a user managed encryption Key Vault key.
     */
    @JsonProperty(value = "properties.encryptionConfig")
    private UpdateEncryptionConfig encryptionConfig;

    /**
     * The list of firewall rules associated with this Data Lake Store account.
     */
    @JsonProperty(value = "properties.firewallRules")
    private List<UpdateFirewallRuleWithAccountParameters> firewallRules;

    /**
     * The current state of the IP address firewall for this Data Lake Store
     * account. Disabling the firewall does not remove existing rules, they
     * will just be ignored until the firewall is re-enabled. Possible values
     * include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.firewallState")
    private FirewallState firewallState;

    /**
     * The current state of allowing or disallowing IPs originating within
     * Azure through the firewall. If the firewall is disabled, this is not
     * enforced. Possible values include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.firewallAllowAzureIps")
    private FirewallAllowAzureIpsState firewallAllowAzureIps;

    /**
     * The list of trusted identity providers associated with this Data Lake
     * Store account.
     */
    @JsonProperty(value = "properties.trustedIdProviders")
    private List<UpdateTrustedIdProviderWithAccountParameters> trustedIdProviders;

    /**
     * The current state of the trusted identity provider feature for this Data
     * Lake Store account. Disabling trusted identity provider functionality
     * does not remove the providers, they will just be ignored until this
     * feature is re-enabled. Possible values include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.trustedIdProviderState")
    private TrustedIdProviderState trustedIdProviderState;

    /**
     * The commitment tier to use for next month. Possible values include:
     * 'Consumption', 'Commitment_1TB', 'Commitment_10TB', 'Commitment_100TB',
     * 'Commitment_500TB', 'Commitment_1PB', 'Commitment_5PB'.
     */
    @JsonProperty(value = "properties.newTier")
    private TierType newTier;

    /**
     * Get the tags value.
     *
     * @return the tags value
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set the tags value.
     *
     * @param tags the tags value to set
     * @return the UpdateDataLakeStoreAccountParameters object itself.
     */
    public UpdateDataLakeStoreAccountParameters withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the defaultGroup value.
     *
     * @return the defaultGroup value
     */
    public String defaultGroup() {
        return this.defaultGroup;
    }

    /**
     * Set the defaultGroup value.
     *
     * @param defaultGroup the defaultGroup value to set
     * @return the UpdateDataLakeStoreAccountParameters object itself.
     */
    public UpdateDataLakeStoreAccountParameters withDefaultGroup(String defaultGroup) {
        this.defaultGroup = defaultGroup;
        return this;
    }

    /**
     * Get the encryptionConfig value.
     *
     * @return the encryptionConfig value
     */
    public UpdateEncryptionConfig encryptionConfig() {
        return this.encryptionConfig;
    }

    /**
     * Set the encryptionConfig value.
     *
     * @param encryptionConfig the encryptionConfig value to set
     * @return the UpdateDataLakeStoreAccountParameters object itself.
     */
    public UpdateDataLakeStoreAccountParameters withEncryptionConfig(UpdateEncryptionConfig encryptionConfig) {
        this.encryptionConfig = encryptionConfig;
        return this;
    }

    /**
     * Get the firewallRules value.
     *
     * @return the firewallRules value
     */
    public List<UpdateFirewallRuleWithAccountParameters> firewallRules() {
        return this.firewallRules;
    }

    /**
     * Set the firewallRules value.
     *
     * @param firewallRules the firewallRules value to set
     * @return the UpdateDataLakeStoreAccountParameters object itself.
     */
    public UpdateDataLakeStoreAccountParameters withFirewallRules(List<UpdateFirewallRuleWithAccountParameters> firewallRules) {
        this.firewallRules = firewallRules;
        return this;
    }

    /**
     * Get the firewallState value.
     *
     * @return the firewallState value
     */
    public FirewallState firewallState() {
        return this.firewallState;
    }

    /**
     * Set the firewallState value.
     *
     * @param firewallState the firewallState value to set
     * @return the UpdateDataLakeStoreAccountParameters object itself.
     */
    public UpdateDataLakeStoreAccountParameters withFirewallState(FirewallState firewallState) {
        this.firewallState = firewallState;
        return this;
    }

    /**
     * Get the firewallAllowAzureIps value.
     *
     * @return the firewallAllowAzureIps value
     */
    public FirewallAllowAzureIpsState firewallAllowAzureIps() {
        return this.firewallAllowAzureIps;
    }

    /**
     * Set the firewallAllowAzureIps value.
     *
     * @param firewallAllowAzureIps the firewallAllowAzureIps value to set
     * @return the UpdateDataLakeStoreAccountParameters object itself.
     */
    public UpdateDataLakeStoreAccountParameters withFirewallAllowAzureIps(FirewallAllowAzureIpsState firewallAllowAzureIps) {
        this.firewallAllowAzureIps = firewallAllowAzureIps;
        return this;
    }

    /**
     * Get the trustedIdProviders value.
     *
     * @return the trustedIdProviders value
     */
    public List<UpdateTrustedIdProviderWithAccountParameters> trustedIdProviders() {
        return this.trustedIdProviders;
    }

    /**
     * Set the trustedIdProviders value.
     *
     * @param trustedIdProviders the trustedIdProviders value to set
     * @return the UpdateDataLakeStoreAccountParameters object itself.
     */
    public UpdateDataLakeStoreAccountParameters withTrustedIdProviders(List<UpdateTrustedIdProviderWithAccountParameters> trustedIdProviders) {
        this.trustedIdProviders = trustedIdProviders;
        return this;
    }

    /**
     * Get the trustedIdProviderState value.
     *
     * @return the trustedIdProviderState value
     */
    public TrustedIdProviderState trustedIdProviderState() {
        return this.trustedIdProviderState;
    }

    /**
     * Set the trustedIdProviderState value.
     *
     * @param trustedIdProviderState the trustedIdProviderState value to set
     * @return the UpdateDataLakeStoreAccountParameters object itself.
     */
    public UpdateDataLakeStoreAccountParameters withTrustedIdProviderState(TrustedIdProviderState trustedIdProviderState) {
        this.trustedIdProviderState = trustedIdProviderState;
        return this;
    }

    /**
     * Get the newTier value.
     *
     * @return the newTier value
     */
    public TierType newTier() {
        return this.newTier;
    }

    /**
     * Set the newTier value.
     *
     * @param newTier the newTier value to set
     * @return the UpdateDataLakeStoreAccountParameters object itself.
     */
    public UpdateDataLakeStoreAccountParameters withNewTier(TierType newTier) {
        this.newTier = newTier;
        return this;
    }

}
