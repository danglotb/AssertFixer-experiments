/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.memory;

import com.facebook.presto.spi.memory.MemoryPoolId;
import com.facebook.presto.spi.memory.MemoryPoolInfo;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.airlift.units.DataSize;

import javax.inject.Inject;

import java.util.List;
import java.util.Map;

import static com.facebook.presto.memory.NodeMemoryConfig.QUERY_MAX_MEMORY_PER_NODE_CONFIG;
import static com.facebook.presto.memory.NodeMemoryConfig.QUERY_MAX_TOTAL_MEMORY_PER_NODE_CONFIG;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Verify.verify;
import static io.airlift.units.DataSize.Unit.BYTE;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public final class LocalMemoryManager
{
    public static final MemoryPoolId GENERAL_POOL = new MemoryPoolId("general");
    public static final MemoryPoolId RESERVED_POOL = new MemoryPoolId("reserved");
    public static final MemoryPoolId SYSTEM_POOL = new MemoryPoolId("system");

    private DataSize maxMemory;
    private Map<MemoryPoolId, MemoryPool> pools;

    @Inject
    public LocalMemoryManager(NodeMemoryConfig config, ReservedSystemMemoryConfig systemMemoryConfig)
    {
        requireNonNull(config, "config is null");
        long availableMemory = Runtime.getRuntime().maxMemory();
        if (config.isLegacySystemPoolEnabled()) {
            configureLegacyMemoryPools(config, systemMemoryConfig, availableMemory);
        }
        else {
            configureMemoryPools(config, availableMemory);
        }
    }

    private void configureMemoryPools(NodeMemoryConfig config, long availableMemory)
    {
        validateHeapHeadroom(config, availableMemory);
        maxMemory = new DataSize(availableMemory - config.getHeapHeadroom().toBytes(), BYTE);
        checkArgument(
                config.getMaxQueryMemoryPerNode().toBytes() <= config.getMaxQueryTotalMemoryPerNode().toBytes(),
                "Max query memory per node (%s) cannot be greater than the max query total memory per node (%s).",
                QUERY_MAX_MEMORY_PER_NODE_CONFIG,
                QUERY_MAX_TOTAL_MEMORY_PER_NODE_CONFIG);
        ImmutableMap.Builder<MemoryPoolId, MemoryPool> builder = ImmutableMap.builder();
        builder.put(RESERVED_POOL, new MemoryPool(RESERVED_POOL, config.getMaxQueryTotalMemoryPerNode()));
        long generalPoolSize = maxMemory.toBytes() - config.getMaxQueryTotalMemoryPerNode().toBytes();
        verify(generalPoolSize > 0, "general memory pool size is 0");
        builder.put(GENERAL_POOL, new MemoryPool(GENERAL_POOL, new DataSize(generalPoolSize, BYTE)));
        this.pools = builder.build();
    }

    private void configureLegacyMemoryPools(NodeMemoryConfig config, ReservedSystemMemoryConfig systemMemoryConfig, long availableMemory)
    {
        checkArgument(systemMemoryConfig.getReservedSystemMemory().toBytes() < availableMemory, "Reserved memory %s is greater than available heap %s", systemMemoryConfig.getReservedSystemMemory(), new DataSize(availableMemory, BYTE));
        maxMemory = new DataSize(availableMemory - systemMemoryConfig.getReservedSystemMemory().toBytes(), BYTE);

        ImmutableMap.Builder<MemoryPoolId, MemoryPool> builder = ImmutableMap.builder();
        checkArgument(config.getMaxQueryMemoryPerNode().toBytes() <= maxMemory.toBytes(), format("%s set to %s, but only %s of useable heap available", QUERY_MAX_MEMORY_PER_NODE_CONFIG, config.getMaxQueryMemoryPerNode(), maxMemory));
        builder.put(RESERVED_POOL, new MemoryPool(RESERVED_POOL, config.getMaxQueryMemoryPerNode()));
        DataSize generalPoolSize = new DataSize(Math.max(0, maxMemory.toBytes() - config.getMaxQueryMemoryPerNode().toBytes()), BYTE);
        builder.put(GENERAL_POOL, new MemoryPool(GENERAL_POOL, generalPoolSize));
        builder.put(SYSTEM_POOL, new MemoryPool(SYSTEM_POOL, systemMemoryConfig.getReservedSystemMemory()));
        this.pools = builder.build();
    }

    @VisibleForTesting
    static void validateHeapHeadroom(NodeMemoryConfig config, long availableMemory)
    {
        long maxQueryTotalMemoryPerNode = config.getMaxQueryTotalMemoryPerNode().toBytes();
        long heapHeadroom = config.getHeapHeadroom().toBytes();
        // (availableMemory - maxQueryTotalMemoryPerNode) bytes will be available for the general pool and the
        // headroom/untracked allocations, so the heapHeadroom cannot be larger than that space.
        if (heapHeadroom < 0 || heapHeadroom + maxQueryTotalMemoryPerNode > availableMemory) {
            throw new IllegalArgumentException(
                    format("Invalid memory configuration. The sum of max total query memory per node (%s) and heap headroom (%s) cannot be larger than the available heap memory (%s)",
                            maxQueryTotalMemoryPerNode,
                            heapHeadroom,
                            availableMemory));
        }
    }

    public MemoryInfo getInfo()
    {
        ImmutableMap.Builder<MemoryPoolId, MemoryPoolInfo> builder = ImmutableMap.builder();
        for (Map.Entry<MemoryPoolId, MemoryPool> entry : pools.entrySet()) {
            builder.put(entry.getKey(), entry.getValue().getInfo());
        }
        return new MemoryInfo(maxMemory, builder.build());
    }

    public List<MemoryPool> getPools()
    {
        return ImmutableList.copyOf(pools.values());
    }

    public MemoryPool getPool(MemoryPoolId id)
    {
        return pools.get(id);
    }
}
