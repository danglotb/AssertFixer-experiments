/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies the log search query.
 */
public class Source {
    /**
     * Log search query.
     */
    @JsonProperty(value = "query", required = true)
    private String query;

    /**
     * List of  Resource referred into query.
     */
    @JsonProperty(value = "authorizedResources")
    private List<String> authorizedResources;

    /**
     * The resource uri over which log search query is to be run.
     */
    @JsonProperty(value = "dataSourceId", required = true)
    private String dataSourceId;

    /**
     * Set value to 'ResultCount'. Possible values include: 'ResultCount'.
     */
    @JsonProperty(value = "queryType")
    private QueryType queryType;

    /**
     * Get log search query.
     *
     * @return the query value
     */
    public String query() {
        return this.query;
    }

    /**
     * Set log search query.
     *
     * @param query the query value to set
     * @return the Source object itself.
     */
    public Source withQuery(String query) {
        this.query = query;
        return this;
    }

    /**
     * Get list of  Resource referred into query.
     *
     * @return the authorizedResources value
     */
    public List<String> authorizedResources() {
        return this.authorizedResources;
    }

    /**
     * Set list of  Resource referred into query.
     *
     * @param authorizedResources the authorizedResources value to set
     * @return the Source object itself.
     */
    public Source withAuthorizedResources(List<String> authorizedResources) {
        this.authorizedResources = authorizedResources;
        return this;
    }

    /**
     * Get the resource uri over which log search query is to be run.
     *
     * @return the dataSourceId value
     */
    public String dataSourceId() {
        return this.dataSourceId;
    }

    /**
     * Set the resource uri over which log search query is to be run.
     *
     * @param dataSourceId the dataSourceId value to set
     * @return the Source object itself.
     */
    public Source withDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
        return this;
    }

    /**
     * Get set value to 'ResultCount'. Possible values include: 'ResultCount'.
     *
     * @return the queryType value
     */
    public QueryType queryType() {
        return this.queryType;
    }

    /**
     * Set set value to 'ResultCount'. Possible values include: 'ResultCount'.
     *
     * @param queryType the queryType value to set
     * @return the Source object itself.
     */
    public Source withQueryType(QueryType queryType) {
        this.queryType = queryType;
        return this;
    }

}
