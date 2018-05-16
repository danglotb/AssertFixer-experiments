/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batchai.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Additional parameters for listOutputFiles operation.
 */
public class JobsListOutputFilesOptionsInner {
    /**
     * Id of the job output directory. This is the OutputDirectory--&gt;id
     * parameter that is given by the user during Create Job.
     */
    @JsonProperty(value = "", required = true)
    private String outputdirectoryid;

    /**
     * The path to the directory.
     */
    @JsonProperty(value = "")
    private String directory;

    /**
     * The number of minutes after which the download link will expire.
     */
    @JsonProperty(value = "")
    private Integer linkexpiryinminutes;

    /**
     * The maximum number of items to return in the response. A maximum of 1000
     * files can be returned.
     */
    @JsonProperty(value = "")
    private Integer maxResults;

    /**
     * Get the outputdirectoryid value.
     *
     * @return the outputdirectoryid value
     */
    public String outputdirectoryid() {
        return this.outputdirectoryid;
    }

    /**
     * Set the outputdirectoryid value.
     *
     * @param outputdirectoryid the outputdirectoryid value to set
     * @return the JobsListOutputFilesOptionsInner object itself.
     */
    public JobsListOutputFilesOptionsInner withOutputdirectoryid(String outputdirectoryid) {
        this.outputdirectoryid = outputdirectoryid;
        return this;
    }

    /**
     * Get the directory value.
     *
     * @return the directory value
     */
    public String directory() {
        return this.directory;
    }

    /**
     * Set the directory value.
     *
     * @param directory the directory value to set
     * @return the JobsListOutputFilesOptionsInner object itself.
     */
    public JobsListOutputFilesOptionsInner withDirectory(String directory) {
        this.directory = directory;
        return this;
    }

    /**
     * Get the linkexpiryinminutes value.
     *
     * @return the linkexpiryinminutes value
     */
    public Integer linkexpiryinminutes() {
        return this.linkexpiryinminutes;
    }

    /**
     * Set the linkexpiryinminutes value.
     *
     * @param linkexpiryinminutes the linkexpiryinminutes value to set
     * @return the JobsListOutputFilesOptionsInner object itself.
     */
    public JobsListOutputFilesOptionsInner withLinkexpiryinminutes(Integer linkexpiryinminutes) {
        this.linkexpiryinminutes = linkexpiryinminutes;
        return this;
    }

    /**
     * Get the maxResults value.
     *
     * @return the maxResults value
     */
    public Integer maxResults() {
        return this.maxResults;
    }

    /**
     * Set the maxResults value.
     *
     * @param maxResults the maxResults value to set
     * @return the JobsListOutputFilesOptionsInner object itself.
     */
    public JobsListOutputFilesOptionsInner withMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }

}
