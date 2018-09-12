/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.locks.implementation;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.AzureResponseBuilder;
import com.microsoft.azure.credentials.AzureTokenCredentials;
import com.microsoft.azure.management.apigeneration.Beta;
import com.microsoft.azure.management.apigeneration.Beta.SinceVersion;
import com.microsoft.azure.management.locks.ManagementLocks;
import com.microsoft.azure.management.resources.fluentcore.arm.AzureConfigurable;
import com.microsoft.azure.management.resources.fluentcore.arm.implementation.AzureConfigurableImpl;
import com.microsoft.azure.management.resources.fluentcore.arm.implementation.Manager;
import com.microsoft.azure.management.resources.fluentcore.utils.ProviderRegistrationInterceptor;
import com.microsoft.azure.serializer.AzureJacksonAdapter;
import com.microsoft.rest.RestClient;

/**
 * Entry point to Azure Authorization resource management.
 */
@Beta(SinceVersion.V1_3_0)
public final class AuthorizationManager extends Manager<AuthorizationManager, ManagementLockClientImpl> {

    private ManagementLocks managementLocks;

    /**
    * Get a Configurable instance that can be used to create AuthorizationManager with optional configuration.
    *
    * @return the instance allowing configurations
    */
    public static Configurable configure() {
        return new AuthorizationManager.ConfigurableImpl();
    }
    /**
    * Creates an instance of AuthorizationManager that exposes Authorization resource management API entry points.
    *
    * @param credentials the credentials to use
    * @param subscriptionId the subscription UUID
    * @return the AuthorizationManager
    */
    public static AuthorizationManager authenticate(AzureTokenCredentials credentials, String subscriptionId) {
        return new AuthorizationManager(new RestClient.Builder()
            .withBaseUrl(credentials.environment(), AzureEnvironment.Endpoint.RESOURCE_MANAGER)
            .withCredentials(credentials)
            .withSerializerAdapter(new AzureJacksonAdapter())
            .withResponseBuilderFactory(new AzureResponseBuilder.Factory())
            .withInterceptor(new ProviderRegistrationInterceptor(credentials))
            .build(), subscriptionId);
    }
    /**
    * Creates an instance of AuthorizationManager that exposes Authorization resource management API entry points.
    *
    * @param restClient the RestClient to be used for API calls.
    * @param subscriptionId the subscription UUID
    * @return the AuthorizationManager
    */
    public static AuthorizationManager authenticate(RestClient restClient, String subscriptionId) {
        return new AuthorizationManager(restClient, subscriptionId);
    }
    /**
    * The interface allowing configurations to be set.
    */
    public interface Configurable extends AzureConfigurable<Configurable> {
        /**
        * Creates an instance of AuthorizationManager that exposes Authorization management API entry points.
        *
        * @param credentials the credentials to use
        * @param subscriptionId the subscription UUID
        * @return the interface exposing Authorization management API entry points that work across subscriptions
        */
        AuthorizationManager authenticate(AzureTokenCredentials credentials, String subscriptionId);
    }
    /**
    * The implementation for Configurable interface.
    */
    private static final class ConfigurableImpl extends AzureConfigurableImpl<Configurable> implements Configurable {
        public AuthorizationManager authenticate(AzureTokenCredentials credentials, String subscriptionId) {
           return AuthorizationManager.authenticate(buildRestClient(credentials), subscriptionId);
        }
     }
    private AuthorizationManager(RestClient restClient, String subscriptionId) {
        super(
            restClient,
            subscriptionId,
            new ManagementLockClientImpl(restClient).withSubscriptionId(subscriptionId));
    }

    /**
     * @return entry point to management lock management
     */
    @Beta(SinceVersion.V1_4_0)
    public ManagementLocks managementLocks() {
        if (this.managementLocks == null) {
            this.managementLocks = new ManagementLocksImpl(this);
        }
        return this.managementLocks;
    }
}
