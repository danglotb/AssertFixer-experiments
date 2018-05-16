/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalake.store.models;

import java.util.UUID;
import org.joda.time.DateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * Data Lake Store account information.
 */
@JsonFlatten
public class DataLakeStoreAccount extends Resource {
    /**
     * The Key Vault encryption identity, if any.
     */
    @JsonProperty(value = "identity", access = JsonProperty.Access.WRITE_ONLY)
    private EncryptionIdentity identity;

    /**
     * The unique identifier associated with this Data Lake Store account.
     */
    @JsonProperty(value = "properties.accountId", access = JsonProperty.Access.WRITE_ONLY)
    private UUID accountId;

    /**
     * The provisioning status of the Data Lake Store account. Possible values
     * include: 'Failed', 'Creating', 'Running', 'Succeeded', 'Patching',
     * 'Suspending', 'Resuming', 'Deleting', 'Deleted', 'Undeleting',
     * 'Canceled'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private DataLakeStoreAccountStatus provisioningState;

    /**
     * The state of the Data Lake Store account. Possible values include:
     * 'Active', 'Suspended'.
     */
    @JsonProperty(value = "properties.state", access = JsonProperty.Access.WRITE_ONLY)
    private DataLakeStoreAccountState state;

    /**
     * The account creation time.
     */
    @JsonProperty(value = "properties.creationTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime creationTime;

    /**
     * The account last modified time.
     */
    @JsonProperty(value = "properties.lastModifiedTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime lastModifiedTime;

    /**
     * The full CName endpoint for this account.
     */
    @JsonProperty(value = "properties.endpoint", access = JsonProperty.Access.WRITE_ONLY)
    private String endpoint;

    /**
     * The default owner group for all new folders and files created in the
     * Data Lake Store account.
     */
    @JsonProperty(value = "properties.defaultGroup", access = JsonProperty.Access.WRITE_ONLY)
    private String defaultGroup;

    /**
     * The Key Vault encryption configuration.
     */
    @JsonProperty(value = "properties.encryptionConfig", access = JsonProperty.Access.WRITE_ONLY)
    private EncryptionConfig encryptionConfig;

    /**
     * The current state of encryption for this Data Lake Store account.
     * Possible values include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.encryptionState", access = JsonProperty.Access.WRITE_ONLY)
    private EncryptionState encryptionState;

    /**
     * The current state of encryption provisioning for this Data Lake Store
     * account. Possible values include: 'Creating', 'Succeeded'.
     */
    @JsonProperty(value = "properties.encryptionProvisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private EncryptionProvisioningState encryptionProvisioningState;

    /**
     * The list of firewall rules associated with this Data Lake Store account.
     */
    @JsonProperty(value = "properties.firewallRules", access = JsonProperty.Access.WRITE_ONLY)
    private List<FirewallRule> firewallRules;

    /**
     * The current state of the IP address firewall for this Data Lake Store
     * account. Possible values include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.firewallState", access = JsonProperty.Access.WRITE_ONLY)
    private FirewallState firewallState;

    /**
     * The current state of allowing or disallowing IPs originating within
     * Azure through the firewall. If the firewall is disabled, this is not
     * enforced. Possible values include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.firewallAllowAzureIps", access = JsonProperty.Access.WRITE_ONLY)
    private FirewallAllowAzureIpsState firewallAllowAzureIps;

    /**
     * The list of trusted identity providers associated with this Data Lake
     * Store account.
     */
    @JsonProperty(value = "properties.trustedIdProviders", access = JsonProperty.Access.WRITE_ONLY)
    private List<TrustedIdProvider> trustedIdProviders;

    /**
     * The current state of the trusted identity provider feature for this Data
     * Lake Store account. Possible values include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.trustedIdProviderState", access = JsonProperty.Access.WRITE_ONLY)
    private TrustedIdProviderState trustedIdProviderState;

    /**
     * The commitment tier to use for next month. Possible values include:
     * 'Consumption', 'Commitment_1TB', 'Commitment_10TB', 'Commitment_100TB',
     * 'Commitment_500TB', 'Commitment_1PB', 'Commitment_5PB'.
     */
    @JsonProperty(value = "properties.newTier", access = JsonProperty.Access.WRITE_ONLY)
    private TierType newTier;

    /**
     * The commitment tier in use for the current month. Possible values
     * include: 'Consumption', 'Commitment_1TB', 'Commitment_10TB',
     * 'Commitment_100TB', 'Commitment_500TB', 'Commitment_1PB',
     * 'Commitment_5PB'.
     */
    @JsonProperty(value = "properties.currentTier", access = JsonProperty.Access.WRITE_ONLY)
    private TierType currentTier;

    /**
     * Get the identity value.
     *
     * @return the identity value
     */
    public EncryptionIdentity identity() {
        return this.identity;
    }

    /**
     * Get the accountId value.
     *
     * @return the accountId value
     */
    public UUID accountId() {
        return this.accountId;
    }

    /**
     * Get the provisioningState value.
     *
     * @return the provisioningState value
     */
    public DataLakeStoreAccountStatus provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the state value.
     *
     * @return the state value
     */
    public DataLakeStoreAccountState state() {
        return this.state;
    }

    /**
     * Get the creationTime value.
     *
     * @return the creationTime value
     */
    public DateTime creationTime() {
        return this.creationTime;
    }

    /**
     * Get the lastModifiedTime value.
     *
     * @return the lastModifiedTime value
     */
    public DateTime lastModifiedTime() {
        return this.lastModifiedTime;
    }

    /**
     * Get the endpoint value.
     *
     * @return the endpoint value
     */
    public String endpoint() {
        return this.endpoint;
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
     * Get the encryptionConfig value.
     *
     * @return the encryptionConfig value
     */
    public EncryptionConfig encryptionConfig() {
        return this.encryptionConfig;
    }

    /**
     * Get the encryptionState value.
     *
     * @return the encryptionState value
     */
    public EncryptionState encryptionState() {
        return this.encryptionState;
    }

    /**
     * Get the encryptionProvisioningState value.
     *
     * @return the encryptionProvisioningState value
     */
    public EncryptionProvisioningState encryptionProvisioningState() {
        return this.encryptionProvisioningState;
    }

    /**
     * Get the firewallRules value.
     *
     * @return the firewallRules value
     */
    public List<FirewallRule> firewallRules() {
        return this.firewallRules;
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
     * Get the firewallAllowAzureIps value.
     *
     * @return the firewallAllowAzureIps value
     */
    public FirewallAllowAzureIpsState firewallAllowAzureIps() {
        return this.firewallAllowAzureIps;
    }

    /**
     * Get the trustedIdProviders value.
     *
     * @return the trustedIdProviders value
     */
    public List<TrustedIdProvider> trustedIdProviders() {
        return this.trustedIdProviders;
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
     * Get the newTier value.
     *
     * @return the newTier value
     */
    public TierType newTier() {
        return this.newTier;
    }

    /**
     * Get the currentTier value.
     *
     * @return the currentTier value
     */
    public TierType currentTier() {
        return this.currentTier;
    }

}
