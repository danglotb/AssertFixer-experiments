/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalake.analytics.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Error diagnostic information for failed jobs.
 */
public class Diagnostics {
    /**
     * the column where the error occured.
     */
    @JsonProperty(value = "columnNumber", access = JsonProperty.Access.WRITE_ONLY)
    private Integer columnNumber;

    /**
     * the ending index of the error.
     */
    @JsonProperty(value = "end", access = JsonProperty.Access.WRITE_ONLY)
    private Integer end;

    /**
     * the line number the error occured on.
     */
    @JsonProperty(value = "lineNumber", access = JsonProperty.Access.WRITE_ONLY)
    private Integer lineNumber;

    /**
     * the error message.
     */
    @JsonProperty(value = "message", access = JsonProperty.Access.WRITE_ONLY)
    private String message;

    /**
     * the severity of the error. Possible values include: 'Warning', 'Error',
     * 'Info', 'SevereWarning', 'Deprecated', 'UserWarning'.
     */
    @JsonProperty(value = "severity", access = JsonProperty.Access.WRITE_ONLY)
    private SeverityTypes severity;

    /**
     * the starting index of the error.
     */
    @JsonProperty(value = "start", access = JsonProperty.Access.WRITE_ONLY)
    private Integer start;

    /**
     * Get the columnNumber value.
     *
     * @return the columnNumber value
     */
    public Integer columnNumber() {
        return this.columnNumber;
    }

    /**
     * Get the end value.
     *
     * @return the end value
     */
    public Integer end() {
        return this.end;
    }

    /**
     * Get the lineNumber value.
     *
     * @return the lineNumber value
     */
    public Integer lineNumber() {
        return this.lineNumber;
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
     * Get the severity value.
     *
     * @return the severity value
     */
    public SeverityTypes severity() {
        return this.severity;
    }

    /**
     * Get the start value.
     *
     * @return the start value
     */
    public Integer start() {
        return this.start;
    }

}
