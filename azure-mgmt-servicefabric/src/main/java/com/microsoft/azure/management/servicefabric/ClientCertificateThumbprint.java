/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.servicefabric;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Client certificate details using thumbprint.
 */
public class ClientCertificateThumbprint {
    /**
     * Is this certificate used for admin access from the client, if false, it
     * is used or query only access.
     */
    @JsonProperty(value = "isAdmin", required = true)
    private boolean isAdmin;

    /**
     * Certificate thumbprint.
     */
    @JsonProperty(value = "certificateThumbprint", required = true)
    private String certificateThumbprint;

    /**
     * Get the isAdmin value.
     *
     * @return the isAdmin value
     */
    public boolean isAdmin() {
        return this.isAdmin;
    }

    /**
     * Set the isAdmin value.
     *
     * @param isAdmin the isAdmin value to set
     * @return the ClientCertificateThumbprint object itself.
     */
    public ClientCertificateThumbprint withIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }

    /**
     * Get the certificateThumbprint value.
     *
     * @return the certificateThumbprint value
     */
    public String certificateThumbprint() {
        return this.certificateThumbprint;
    }

    /**
     * Set the certificateThumbprint value.
     *
     * @param certificateThumbprint the certificateThumbprint value to set
     * @return the ClientCertificateThumbprint object itself.
     */
    public ClientCertificateThumbprint withCertificateThumbprint(String certificateThumbprint) {
        this.certificateThumbprint = certificateThumbprint;
        return this;
    }

}
