/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.storage.blob.models;

import com.microsoft.rest.v2.RestResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Contains all response data for the getAccessPolicy operation.
 */
public final class ContainerGetAccessPolicyResponse extends RestResponse<ContainerGetAccessPolicyHeaders, List<SignedIdentifier>> {
    /**
     * Creates an instance of ContainerGetAccessPolicyResponse.
     *
     * @param statusCode the status code of the HTTP response.
     * @param headers the deserialized headers of the HTTP response.
     * @param rawHeaders the raw headers of the HTTP response.
     * @param body the deserialized body of the HTTP response.
     */
    public ContainerGetAccessPolicyResponse(int statusCode, ContainerGetAccessPolicyHeaders headers, Map<String, String> rawHeaders, List<SignedIdentifier> body) {
        super(statusCode, headers, rawHeaders, body);
    }

    /**
     * @return the deserialized response headers.
     */
    @Override
    public ContainerGetAccessPolicyHeaders headers() {
        return super.headers();
    }

    /**
     * @return the deserialized response body.
     */
    @Override
    public List<SignedIdentifier> body() {
        return super.body();
    }
}
