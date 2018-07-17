/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batch;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An error that occurred when autoscaling a pool.
 */
public class AutoScaleRunError {
    /**
     * An identifier for the error. Codes are invariant and are intended to be
     * consumed programmatically.
     */
    @JsonProperty(value = "code", required = true)
    private String code;

    /**
     * A message describing the error, intended to be suitable for display in a
     * user interface.
     */
    @JsonProperty(value = "message", required = true)
    private String message;

    /**
     * Additional details about the error.
     */
    @JsonProperty(value = "details")
    private List<AutoScaleRunError> details;

    /**
     * Get the code value.
     *
     * @return the code value
     */
    public String code() {
        return this.code;
    }

    /**
     * Set the code value.
     *
     * @param code the code value to set
     * @return the AutoScaleRunError object itself.
     */
    public AutoScaleRunError withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get the message value.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

    /**
     * Set the message value.
     *
     * @param message the message value to set
     * @return the AutoScaleRunError object itself.
     */
    public AutoScaleRunError withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the details value.
     *
     * @return the details value
     */
    public List<AutoScaleRunError> details() {
        return this.details;
    }

    /**
     * Set the details value.
     *
     * @param details the details value to set
     * @return the AutoScaleRunError object itself.
     */
    public AutoScaleRunError withDetails(List<AutoScaleRunError> details) {
        this.details = details;
        return this;
    }

}
