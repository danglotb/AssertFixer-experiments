/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batchai;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Counts of various compute node states on the cluster.
 */
public class NodeStateCounts {
    /**
     * Idle node count.
     * Number of compute nodes in idle state.
     */
    @JsonProperty(value = "idleNodeCount", access = JsonProperty.Access.WRITE_ONLY)
    private Integer idleNodeCount;

    /**
     * Running node count.
     * Number of compute nodes which are running jobs.
     */
    @JsonProperty(value = "runningNodeCount", access = JsonProperty.Access.WRITE_ONLY)
    private Integer runningNodeCount;

    /**
     * Preparing node count.
     * Number of compute nodes which are being prepared.
     */
    @JsonProperty(value = "preparingNodeCount", access = JsonProperty.Access.WRITE_ONLY)
    private Integer preparingNodeCount;

    /**
     * Unusable node count.
     * Number of compute nodes which are in unusable state.
     */
    @JsonProperty(value = "unusableNodeCount", access = JsonProperty.Access.WRITE_ONLY)
    private Integer unusableNodeCount;

    /**
     * Leaving node count.
     * Number of compute nodes which are leaving the cluster.
     */
    @JsonProperty(value = "leavingNodeCount", access = JsonProperty.Access.WRITE_ONLY)
    private Integer leavingNodeCount;

    /**
     * Get number of compute nodes in idle state.
     *
     * @return the idleNodeCount value
     */
    public Integer idleNodeCount() {
        return this.idleNodeCount;
    }

    /**
     * Get number of compute nodes which are running jobs.
     *
     * @return the runningNodeCount value
     */
    public Integer runningNodeCount() {
        return this.runningNodeCount;
    }

    /**
     * Get number of compute nodes which are being prepared.
     *
     * @return the preparingNodeCount value
     */
    public Integer preparingNodeCount() {
        return this.preparingNodeCount;
    }

    /**
     * Get number of compute nodes which are in unusable state.
     *
     * @return the unusableNodeCount value
     */
    public Integer unusableNodeCount() {
        return this.unusableNodeCount;
    }

    /**
     * Get number of compute nodes which are leaving the cluster.
     *
     * @return the leavingNodeCount value
     */
    public Integer leavingNodeCount() {
        return this.leavingNodeCount;
    }

}
