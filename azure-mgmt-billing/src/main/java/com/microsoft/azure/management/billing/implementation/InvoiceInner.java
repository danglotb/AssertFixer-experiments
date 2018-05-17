/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.billing.implementation;

import com.microsoft.azure.management.billing.DownloadUrl;
import org.joda.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * An invoice resource can be used download a PDF version of an invoice.
 */
@JsonFlatten
public class InvoiceInner extends Resource {
    /**
     * A secure link to download the PDF version of an invoice. The link will
     * cease to work after its expiry time is reached.
     */
    @JsonProperty(value = "properties.downloadUrl")
    private DownloadUrl downloadUrl;

    /**
     * The start of the date range covered by the invoice.
     */
    @JsonProperty(value = "properties.invoicePeriodStartDate", access = JsonProperty.Access.WRITE_ONLY)
    private LocalDate invoicePeriodStartDate;

    /**
     * The end of the date range covered by the invoice.
     */
    @JsonProperty(value = "properties.invoicePeriodEndDate", access = JsonProperty.Access.WRITE_ONLY)
    private LocalDate invoicePeriodEndDate;

    /**
     * Array of billing perdiod ids that the invoice is attributed to.
     */
    @JsonProperty(value = "properties.billingPeriodIds", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> billingPeriodIds;

    /**
     * Get the downloadUrl value.
     *
     * @return the downloadUrl value
     */
    public DownloadUrl downloadUrl() {
        return this.downloadUrl;
    }

    /**
     * Set the downloadUrl value.
     *
     * @param downloadUrl the downloadUrl value to set
     * @return the InvoiceInner object itself.
     */
    public InvoiceInner withDownloadUrl(DownloadUrl downloadUrl) {
        this.downloadUrl = downloadUrl;
        return this;
    }

    /**
     * Get the invoicePeriodStartDate value.
     *
     * @return the invoicePeriodStartDate value
     */
    public LocalDate invoicePeriodStartDate() {
        return this.invoicePeriodStartDate;
    }

    /**
     * Get the invoicePeriodEndDate value.
     *
     * @return the invoicePeriodEndDate value
     */
    public LocalDate invoicePeriodEndDate() {
        return this.invoicePeriodEndDate;
    }

    /**
     * Get the billingPeriodIds value.
     *
     * @return the billingPeriodIds value
     */
    public List<String> billingPeriodIds() {
        return this.billingPeriodIds;
    }

}
