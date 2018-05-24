/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.redis.implementation;

import java.util.Map;
import com.microsoft.azure.management.redis.TlsVersion;
import com.microsoft.azure.management.redis.Sku;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Parameters supplied to the Create Redis operation.
 */
@JsonFlatten
public class RedisCreateParametersInner {
    /**
     * All Redis Settings. Few possible keys:
     * rdb-backup-enabled,rdb-storage-connection-string,rdb-backup-frequency,maxmemory-delta,maxmemory-policy,notify-keyspace-events,maxmemory-samples,slowlog-log-slower-than,slowlog-max-len,list-max-ziplist-entries,list-max-ziplist-value,hash-max-ziplist-entries,hash-max-ziplist-value,set-max-intset-entries,zset-max-ziplist-entries,zset-max-ziplist-value
     * etc.
     */
    @JsonProperty(value = "properties.redisConfiguration")
    private Map<String, String> redisConfiguration;

    /**
     * Specifies whether the non-ssl Redis server port (6379) is enabled.
     */
    @JsonProperty(value = "properties.enableNonSslPort")
    private Boolean enableNonSslPort;

    /**
     * A dictionary of tenant settings.
     */
    @JsonProperty(value = "properties.tenantSettings")
    private Map<String, String> tenantSettings;

    /**
     * The number of shards to be created on a Premium Cluster Cache.
     */
    @JsonProperty(value = "properties.shardCount")
    private Integer shardCount;

    /**
     * Optional: requires clients to use a specified TLS version (or higher) to
     * connect (e,g, '1.0', '1.1', '1.2'). Possible values include: '1.0',
     * '1.1', '1.2'.
     */
    @JsonProperty(value = "properties.minimumTlsVersion")
    private TlsVersion minimumTlsVersion;

    /**
     * The SKU of the Redis cache to deploy.
     */
    @JsonProperty(value = "properties.sku", required = true)
    private Sku sku;

    /**
     * The full resource ID of a subnet in a virtual network to deploy the
     * Redis cache in. Example format:
     * /subscriptions/{subid}/resourceGroups/{resourceGroupName}/Microsoft.{Network|ClassicNetwork}/VirtualNetworks/vnet1/subnets/subnet1.
     */
    @JsonProperty(value = "properties.subnetId")
    private String subnetId;

    /**
     * Static IP address. Required when deploying a Redis cache inside an
     * existing Azure Virtual Network.
     */
    @JsonProperty(value = "properties.staticIP")
    private String staticIP;

    /**
     * A list of availability zones denoting where the resource needs to come
     * from.
     */
    @JsonProperty(value = "zones")
    private List<String> zones;

    /**
     * The geo-location where the resource lives.
     */
    @JsonProperty(value = "location", required = true)
    private String location;

    /**
     * Resource tags.
     */
    @JsonProperty(value = "tags")
    private Map<String, String> tags;

    /**
     * Get the redisConfiguration value.
     *
     * @return the redisConfiguration value
     */
    public Map<String, String> redisConfiguration() {
        return this.redisConfiguration;
    }

    /**
     * Set the redisConfiguration value.
     *
     * @param redisConfiguration the redisConfiguration value to set
     * @return the RedisCreateParametersInner object itself.
     */
    public RedisCreateParametersInner withRedisConfiguration(Map<String, String> redisConfiguration) {
        this.redisConfiguration = redisConfiguration;
        return this;
    }

    /**
     * Get the enableNonSslPort value.
     *
     * @return the enableNonSslPort value
     */
    public Boolean enableNonSslPort() {
        return this.enableNonSslPort;
    }

    /**
     * Set the enableNonSslPort value.
     *
     * @param enableNonSslPort the enableNonSslPort value to set
     * @return the RedisCreateParametersInner object itself.
     */
    public RedisCreateParametersInner withEnableNonSslPort(Boolean enableNonSslPort) {
        this.enableNonSslPort = enableNonSslPort;
        return this;
    }

    /**
     * Get the tenantSettings value.
     *
     * @return the tenantSettings value
     */
    public Map<String, String> tenantSettings() {
        return this.tenantSettings;
    }

    /**
     * Set the tenantSettings value.
     *
     * @param tenantSettings the tenantSettings value to set
     * @return the RedisCreateParametersInner object itself.
     */
    public RedisCreateParametersInner withTenantSettings(Map<String, String> tenantSettings) {
        this.tenantSettings = tenantSettings;
        return this;
    }

    /**
     * Get the shardCount value.
     *
     * @return the shardCount value
     */
    public Integer shardCount() {
        return this.shardCount;
    }

    /**
     * Set the shardCount value.
     *
     * @param shardCount the shardCount value to set
     * @return the RedisCreateParametersInner object itself.
     */
    public RedisCreateParametersInner withShardCount(Integer shardCount) {
        this.shardCount = shardCount;
        return this;
    }

    /**
     * Get the minimumTlsVersion value.
     *
     * @return the minimumTlsVersion value
     */
    public TlsVersion minimumTlsVersion() {
        return this.minimumTlsVersion;
    }

    /**
     * Set the minimumTlsVersion value.
     *
     * @param minimumTlsVersion the minimumTlsVersion value to set
     * @return the RedisCreateParametersInner object itself.
     */
    public RedisCreateParametersInner withMinimumTlsVersion(TlsVersion minimumTlsVersion) {
        this.minimumTlsVersion = minimumTlsVersion;
        return this;
    }

    /**
     * Get the sku value.
     *
     * @return the sku value
     */
    public Sku sku() {
        return this.sku;
    }

    /**
     * Set the sku value.
     *
     * @param sku the sku value to set
     * @return the RedisCreateParametersInner object itself.
     */
    public RedisCreateParametersInner withSku(Sku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the subnetId value.
     *
     * @return the subnetId value
     */
    public String subnetId() {
        return this.subnetId;
    }

    /**
     * Set the subnetId value.
     *
     * @param subnetId the subnetId value to set
     * @return the RedisCreateParametersInner object itself.
     */
    public RedisCreateParametersInner withSubnetId(String subnetId) {
        this.subnetId = subnetId;
        return this;
    }

    /**
     * Get the staticIP value.
     *
     * @return the staticIP value
     */
    public String staticIP() {
        return this.staticIP;
    }

    /**
     * Set the staticIP value.
     *
     * @param staticIP the staticIP value to set
     * @return the RedisCreateParametersInner object itself.
     */
    public RedisCreateParametersInner withStaticIP(String staticIP) {
        this.staticIP = staticIP;
        return this;
    }

    /**
     * Get the zones value.
     *
     * @return the zones value
     */
    public List<String> zones() {
        return this.zones;
    }

    /**
     * Set the zones value.
     *
     * @param zones the zones value to set
     * @return the RedisCreateParametersInner object itself.
     */
    public RedisCreateParametersInner withZones(List<String> zones) {
        this.zones = zones;
        return this;
    }

    /**
     * Get the location value.
     *
     * @return the location value
     */
    public String location() {
        return this.location;
    }

    /**
     * Set the location value.
     *
     * @param location the location value to set
     * @return the RedisCreateParametersInner object itself.
     */
    public RedisCreateParametersInner withLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Get the tags value.
     *
     * @return the tags value
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set the tags value.
     *
     * @param tags the tags value to set
     * @return the RedisCreateParametersInner object itself.
     */
    public RedisCreateParametersInner withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

}
