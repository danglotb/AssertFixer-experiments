/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * API contract properties for the Tag Resources.
 */
public class ApiTagResourceContractProperties extends ApiEntityBaseContract {
    /**
     * API identifier in the form /apis/{apiId}.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * API name.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * Absolute URL of the backend service implementing this API.
     */
    @JsonProperty(value = "serviceUrl")
    private String serviceUrl;

    /**
     * Relative URL uniquely identifying this API and all of its resource paths
     * within the API Management service instance. It is appended to the API
     * endpoint base URL specified during the service instance creation to form
     * a public URL for this API.
     */
    @JsonProperty(value = "path")
    private String path;

    /**
     * Describes on which protocols the operations in this API can be invoked.
     */
    @JsonProperty(value = "protocols")
    private List<Protocol> protocols;

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
     * @return the ApiTagResourceContractProperties object itself.
     */
    public ApiTagResourceContractProperties withId(String id) {
        this.id = id;
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
     * @return the ApiTagResourceContractProperties object itself.
     */
    public ApiTagResourceContractProperties withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the serviceUrl value.
     *
     * @return the serviceUrl value
     */
    public String serviceUrl() {
        return this.serviceUrl;
    }

    /**
     * Set the serviceUrl value.
     *
     * @param serviceUrl the serviceUrl value to set
     * @return the ApiTagResourceContractProperties object itself.
     */
    public ApiTagResourceContractProperties withServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
        return this;
    }

    /**
     * Get the path value.
     *
     * @return the path value
     */
    public String path() {
        return this.path;
    }

    /**
     * Set the path value.
     *
     * @param path the path value to set
     * @return the ApiTagResourceContractProperties object itself.
     */
    public ApiTagResourceContractProperties withPath(String path) {
        this.path = path;
        return this;
    }

    /**
     * Get the protocols value.
     *
     * @return the protocols value
     */
    public List<Protocol> protocols() {
        return this.protocols;
    }

    /**
     * Set the protocols value.
     *
     * @param protocols the protocols value to set
     * @return the ApiTagResourceContractProperties object itself.
     */
    public ApiTagResourceContractProperties withProtocols(List<Protocol> protocols) {
        this.protocols = protocols;
        return this;
    }

}
