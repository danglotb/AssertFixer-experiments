/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.implementation;

import com.microsoft.azure.management.sql.ReplicationRole;
import org.joda.time.DateTime;
import com.microsoft.azure.management.sql.ReplicationState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Represents a database replication link.
 */
@JsonFlatten
public class ReplicationLinkInner extends ProxyResourceInner {
    /**
     * Location of the server that contains this firewall rule.
     */
    @JsonProperty(value = "location", access = JsonProperty.Access.WRITE_ONLY)
    private String location;

    /**
     * Legacy value indicating whether termination is allowed.  Currently
     * always returns true.
     */
    @JsonProperty(value = "properties.isTerminationAllowed", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isTerminationAllowed;

    /**
     * Replication mode of this replication link.
     */
    @JsonProperty(value = "properties.replicationMode", access = JsonProperty.Access.WRITE_ONLY)
    private String replicationMode;

    /**
     * The name of the server hosting the partner database.
     */
    @JsonProperty(value = "properties.partnerServer", access = JsonProperty.Access.WRITE_ONLY)
    private String partnerServer;

    /**
     * The name of the partner database.
     */
    @JsonProperty(value = "properties.partnerDatabase", access = JsonProperty.Access.WRITE_ONLY)
    private String partnerDatabase;

    /**
     * The Azure Region of the partner database.
     */
    @JsonProperty(value = "properties.partnerLocation", access = JsonProperty.Access.WRITE_ONLY)
    private String partnerLocation;

    /**
     * The role of the database in the replication link. Possible values
     * include: 'Primary', 'Secondary', 'NonReadableSecondary', 'Source',
     * 'Copy'.
     */
    @JsonProperty(value = "properties.role", access = JsonProperty.Access.WRITE_ONLY)
    private ReplicationRole role;

    /**
     * The role of the partner database in the replication link. Possible
     * values include: 'Primary', 'Secondary', 'NonReadableSecondary',
     * 'Source', 'Copy'.
     */
    @JsonProperty(value = "properties.partnerRole", access = JsonProperty.Access.WRITE_ONLY)
    private ReplicationRole partnerRole;

    /**
     * The start time for the replication link.
     */
    @JsonProperty(value = "properties.startTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime startTime;

    /**
     * The percentage of seeding complete for the replication link.
     */
    @JsonProperty(value = "properties.percentComplete", access = JsonProperty.Access.WRITE_ONLY)
    private Integer percentComplete;

    /**
     * The replication state for the replication link. Possible values include:
     * 'PENDING', 'SEEDING', 'CATCH_UP', 'SUSPENDED'.
     */
    @JsonProperty(value = "properties.replicationState", access = JsonProperty.Access.WRITE_ONLY)
    private ReplicationState replicationState;

    /**
     * Get the location value.
     *
     * @return the location value
     */
    public String location() {
        return this.location;
    }

    /**
     * Get the isTerminationAllowed value.
     *
     * @return the isTerminationAllowed value
     */
    public Boolean isTerminationAllowed() {
        return this.isTerminationAllowed;
    }

    /**
     * Get the replicationMode value.
     *
     * @return the replicationMode value
     */
    public String replicationMode() {
        return this.replicationMode;
    }

    /**
     * Get the partnerServer value.
     *
     * @return the partnerServer value
     */
    public String partnerServer() {
        return this.partnerServer;
    }

    /**
     * Get the partnerDatabase value.
     *
     * @return the partnerDatabase value
     */
    public String partnerDatabase() {
        return this.partnerDatabase;
    }

    /**
     * Get the partnerLocation value.
     *
     * @return the partnerLocation value
     */
    public String partnerLocation() {
        return this.partnerLocation;
    }

    /**
     * Get the role value.
     *
     * @return the role value
     */
    public ReplicationRole role() {
        return this.role;
    }

    /**
     * Get the partnerRole value.
     *
     * @return the partnerRole value
     */
    public ReplicationRole partnerRole() {
        return this.partnerRole;
    }

    /**
     * Get the startTime value.
     *
     * @return the startTime value
     */
    public DateTime startTime() {
        return this.startTime;
    }

    /**
     * Get the percentComplete value.
     *
     * @return the percentComplete value
     */
    public Integer percentComplete() {
        return this.percentComplete;
    }

    /**
     * Get the replicationState value.
     *
     * @return the replicationState value
     */
    public ReplicationState replicationState() {
        return this.replicationState;
    }

}
