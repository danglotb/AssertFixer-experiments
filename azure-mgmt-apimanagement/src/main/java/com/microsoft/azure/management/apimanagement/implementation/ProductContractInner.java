/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.implementation;

import com.microsoft.azure.management.apimanagement.ProductState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * Product details.
 */
@JsonFlatten
public class ProductContractInner extends Resource {
    /**
     * Product description. May include HTML formatting tags.
     */
    @JsonProperty(value = "properties.description")
    private String description;

    /**
     * Product terms of use. Developers trying to subscribe to the product will
     * be presented and required to accept these terms before they can complete
     * the subscription process.
     */
    @JsonProperty(value = "properties.terms")
    private String terms;

    /**
     * Whether a product subscription is required for accessing APIs included
     * in this product. If true, the product is referred to as "protected" and
     * a valid subscription key is required for a request to an API included in
     * the product to succeed. If false, the product is referred to as "open"
     * and requests to an API included in the product can be made without a
     * subscription key. If property is omitted when creating a new product
     * it's value is assumed to be true.
     */
    @JsonProperty(value = "properties.subscriptionRequired")
    private Boolean subscriptionRequired;

    /**
     * whether subscription approval is required. If false, new subscriptions
     * will be approved automatically enabling developers to call the product’s
     * APIs immediately after subscribing. If true, administrators must
     * manually approve the subscription before the developer can any of the
     * product’s APIs. Can be present only if subscriptionRequired property is
     * present and has a value of false.
     */
    @JsonProperty(value = "properties.approvalRequired")
    private Boolean approvalRequired;

    /**
     * Whether the number of subscriptions a user can have to this product at
     * the same time. Set to null or omit to allow unlimited per user
     * subscriptions. Can be present only if subscriptionRequired property is
     * present and has a value of false.
     */
    @JsonProperty(value = "properties.subscriptionsLimit")
    private Integer subscriptionsLimit;

    /**
     * whether product is published or not. Published products are discoverable
     * by users of developer portal. Non published products are visible only to
     * administrators. Default state of Product is notPublished. Possible
     * values include: 'notPublished', 'published'.
     */
    @JsonProperty(value = "properties.state")
    private ProductState state;

    /**
     * Product name.
     */
    @JsonProperty(value = "properties.displayName", required = true)
    private String displayName;

    /**
     * Get the description value.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description value.
     *
     * @param description the description value to set
     * @return the ProductContractInner object itself.
     */
    public ProductContractInner withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the terms value.
     *
     * @return the terms value
     */
    public String terms() {
        return this.terms;
    }

    /**
     * Set the terms value.
     *
     * @param terms the terms value to set
     * @return the ProductContractInner object itself.
     */
    public ProductContractInner withTerms(String terms) {
        this.terms = terms;
        return this;
    }

    /**
     * Get the subscriptionRequired value.
     *
     * @return the subscriptionRequired value
     */
    public Boolean subscriptionRequired() {
        return this.subscriptionRequired;
    }

    /**
     * Set the subscriptionRequired value.
     *
     * @param subscriptionRequired the subscriptionRequired value to set
     * @return the ProductContractInner object itself.
     */
    public ProductContractInner withSubscriptionRequired(Boolean subscriptionRequired) {
        this.subscriptionRequired = subscriptionRequired;
        return this;
    }

    /**
     * Get the approvalRequired value.
     *
     * @return the approvalRequired value
     */
    public Boolean approvalRequired() {
        return this.approvalRequired;
    }

    /**
     * Set the approvalRequired value.
     *
     * @param approvalRequired the approvalRequired value to set
     * @return the ProductContractInner object itself.
     */
    public ProductContractInner withApprovalRequired(Boolean approvalRequired) {
        this.approvalRequired = approvalRequired;
        return this;
    }

    /**
     * Get the subscriptionsLimit value.
     *
     * @return the subscriptionsLimit value
     */
    public Integer subscriptionsLimit() {
        return this.subscriptionsLimit;
    }

    /**
     * Set the subscriptionsLimit value.
     *
     * @param subscriptionsLimit the subscriptionsLimit value to set
     * @return the ProductContractInner object itself.
     */
    public ProductContractInner withSubscriptionsLimit(Integer subscriptionsLimit) {
        this.subscriptionsLimit = subscriptionsLimit;
        return this;
    }

    /**
     * Get the state value.
     *
     * @return the state value
     */
    public ProductState state() {
        return this.state;
    }

    /**
     * Set the state value.
     *
     * @param state the state value to set
     * @return the ProductContractInner object itself.
     */
    public ProductContractInner withState(ProductState state) {
        this.state = state;
        return this;
    }

    /**
     * Get the displayName value.
     *
     * @return the displayName value
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName value.
     *
     * @param displayName the displayName value to set
     * @return the ProductContractInner object itself.
     */
    public ProductContractInner withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

}
