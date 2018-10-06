/*
 * Copyright 2018 The Hekate Project
 *
 * The Hekate Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.hekate.messaging;

import io.hekate.cluster.ClusterFilterSupport;
import io.hekate.cluster.ClusterNode;
import io.hekate.cluster.ClusterNodeFilter;
import io.hekate.codec.CodecFactory;
import io.hekate.core.Hekate;
import io.hekate.core.HekateBootstrap;
import io.hekate.core.service.DefaultServiceFactory;
import io.hekate.core.service.Service;
import io.hekate.failover.FailoverPolicy;
import io.hekate.messaging.broadcast.Aggregate;
import io.hekate.messaging.broadcast.AggregateResult;
import io.hekate.messaging.broadcast.Broadcast;
import io.hekate.messaging.loadbalance.DefaultLoadBalancer;
import io.hekate.messaging.loadbalance.LoadBalancer;
import io.hekate.messaging.unicast.Request;
import io.hekate.messaging.unicast.ResponseCallback;
import io.hekate.messaging.unicast.Send;
import io.hekate.messaging.unicast.SendCallback;
import io.hekate.messaging.unicast.Subscribe;
import io.hekate.partition.Partition;
import java.util.List;

/**
 * <span class="startHere">&laquo; start here</span>Main entry point to messaging API.
 *
 * <h2>Overview</h2>
 * <p>
 * Messaging service provides support for building message-oriented communications in the cluster of {@link Hekate} nodes. Message exchange
 * is based on the concept of messaging channels. Such channels hide all the complexities of managing resources (like socket and threads)
 * and provide a high level API for implementing various messaging patterns.
 * </p>
 *
 * <h2>Messaging Channels</h2>
 * <p>
 * Messaging channel is a communication unit that can act as a sender, as a receiver or perform both of those roles simultaneously.
 * Channels provide support for unicast messaging (node to node communication) and broadcast messaging (node to many nodes communication).
 * Note that "unicast" and "broadcast" in this context are NOT related to UDP (all communications are TCP-based) and merely outline
 * the communication patterns.
 * </p>
 *
 * <h2>Configuring channels</h2>
 * <p>
 * Configuration of a messaging channel is represented by the {@link MessagingChannelConfig} class. Instances of this class be registered
 * via the {@link MessagingServiceFactory#withChannel(MessagingChannelConfig)} method.
 * </p>
 *
 * <p>
 * Below are the key configuration options of a messaging channel:
 * </p>
 * <ul>
 * <li>{@link MessagingChannelConfig#setName(String) Channel Name} - only channels with the same name can communicate with each other.
 * Note that channel name must be unique within each {@link MessagingService} instance and any attempt to register multiple channels with
 * the same name will result in an error</li>
 * <li>{@link MessagingChannelConfig#setReceiver(MessageReceiver) Message Receiver} if channel should be able to receive messages from
 * remote nodes (i.e. act as a server)</li>
 * <li>{@link MessagingChannelConfig#setMessageCodec(CodecFactory) Message Codec} - for messages serialization/deserialization.
 * If not specified then the {@link HekateBootstrap#setDefaultCodec(CodecFactory) default codec} will be used.</li>
 * <li>{@link MessagingChannelConfig#setNioThreads(int) NIO} and {@link MessagingChannelConfig#setWorkerThreads(int) worker} thread pool
 * options</li>
 * </ul>
 *
 * <p>
 * Example:
 * </p>
 *
 * <div class="tabs">
 * <ul>
 * <li><a href="#configure-java">Java</a></li>
 * <li><a href="#configure-xsd">Spring XSD</a></li>
 * <li><a href="#configure-bean">Spring bean</a></li>
 * </ul>
 * <div id="configure-java">
 * ${source: messaging/MessagingServiceJavadocTest.java#configure_channel}
 * </div>
 * <div id="configure-xsd">
 * <b>Note:</b> This example requires Spring Framework integration
 * (see <a href="{@docRoot}/io/hekate/spring/bean/HekateSpringBootstrap.html">HekateSpringBootstrap</a>).
 * ${source: messaging/service-xsd.xml#example}
 * </div>
 * <div id="configure-bean">
 * <b>Note:</b> This example requires Spring Framework integration
 * (see <a href="{@docRoot}/io/hekate/spring/bean/HekateSpringBootstrap.html">HekateSpringBootstrap</a>).
 * ${source: messaging/service-bean.xml#example}
 * </div>
 * </div>
 *
 * <p>
 * For more details about the available configuration options please see the documentation of {@link MessagingChannelConfig} class.
 * </p>
 *
 * <h2>Accessing channels</h2>
 * <p>
 * Channel can be accessed via the {@link MessagingService#channel(String, Class)} method, with the first parameter being the
 * {@link MessagingChannelConfig#setName(String) channel name} and the second parameter being the
 * {@link MessagingChannelConfig#of(Class) base type} of messages that can be transferred over that channel:
 * ${source: messaging/MessagingServiceJavadocTest.java#access_channel}
 * </p>
 *
 * <h2>Sending messages</h2>
 * <p>
 * {@link MessagingChannel} provides API for the following communication patterns:
 * </p>
 * <ul>
 * <li>
 * <a href="#request_response">Request/Response</a> - bidirectional node to node communication
 * </li>
 * <li>
 * <a href="#send_and_forget">Send and Forget</a> - unidirectional node to node communication
 * </li>
 * <li>
 * <a href="#aggregate">Aggregation</a> - bidirectional node to many nodes communication
 * </li>
 * <li>
 * <a href="#broadcast">Broadcasting</a> - unidirectional node to many nodes communication
 * </li>
 * </ul>
 *
 * <a name="request_response"></a>
 * <h3>Request/Response</h3>
 * <p>
 * {@link MessagingChannel#request(Object)} can be used for bidirectional communications with remote nodes using the request-response
 * pattern:
 * ${source: messaging/MessagingServiceJavadocTest.java#unicast_request_sync}
 * </p>
 *
 * <p>
 * ... or using a completely asynchronous callback-based approach:
 * ${source: messaging/MessagingServiceJavadocTest.java#unicast_request_async}
 * </p>
 *
 * <a name="send_and_forget"></a>
 * <h3>Send and Forget</h3>
 * <p>
 * {@link MessagingChannel#newSend(Object)} provides support for unidirectional communications (i.e. when remote node doesn't need to send
 * back a response) using the fire and forget approach:
 * ${source: messaging/MessagingServiceJavadocTest.java#unicast_send_sync}
 * </p>
 *
 * <p>
 * ... or using a completely asynchronous callback-based approach:
 * ${source: messaging/MessagingServiceJavadocTest.java#unicast_send_async}
 * </p>
 *
 * <a name="aggregate"></a>
 * <h3>Aggregation</h3>
 * <p>
 * {@link MessagingChannel#aggregate(Object)} can be used for bidirectional communications by submitting a message to multiple nodes and
 * gathering (aggregating) replies from those nodes. Results of such aggregation are represented by the {@link AggregateResult} interface.
 * This interface provides methods for analyzing responses from remote nodes and checking for possible failures.
 * </p>
 *
 * <p>
 * Below is the example of synchronous aggregation:
 * ${source: messaging/MessagingServiceJavadocTest.java#aggregate_sync}
 * </p>
 *
 * <p>
 * ... or using a completely asynchronous callback-based approach:
 * ${source: messaging/MessagingServiceJavadocTest.java#aggregate_async}
 * </p>
 *
 * <a name="broadcast"></a>
 * <h3>Broadcasting</h3>
 * <p>
 * {@link MessagingChannel#broadcast(Object)} provides support for unidirectional broadcasting (i.e. when remote nodes do not need to send
 * a reply and no aggregation should take place) using the fire and forget approach.
 * </p>
 *
 * <p>
 * Below is the example of synchronous broadcast:
 * ${source: messaging/MessagingServiceJavadocTest.java#broadcast_sync}
 * </p>
 * <p>
 * ... or using a completely asynchronous callback-based approach:
 * ${source: messaging/MessagingServiceJavadocTest.java#broadcast_async}
 * </p>
 *
 * <h2>Receiving messages</h2>
 * <p>
 * Messaging channel can receive messages from remote nodes by {@link MessagingChannelConfig#setReceiver(MessageReceiver) registering} an
 * instance of {@link MessageReceiver} interface. Received messages are represented by the {@link Message} interface. This interface
 * provides methods for {@link Message#get() getting} the payload of a received message as well as methods for {@link Message#reply(Object)
 * replying} to that message.
 * </p>
 *
 * <p>
 * <b>Important:</b> Only one receiver can be registered per each messaging channel.
 * </p>
 *
 * <p>
 * Below is the example of {@link MessageReceiver} implementation:
 * ${source: messaging/MessagingServiceJavadocTest.java#message_receiver}
 * </p>
 *
 * <h2>Routing and load balancing</h2>
 * <p>
 * Every messaging channel uses an instance of {@link LoadBalancer} interface to perform routing of unicast operations
 * (like {@link MessagingChannel#newSend(Object) send(...)} and {@link MessagingChannel#request(Object) request(...)}). Load balancer can
 * be pre-configured via the {@link MessagingChannelConfig#setLoadBalancer(LoadBalancer)} method or specified dynamically via the {@link
 * MessagingChannel#withLoadBalancer(LoadBalancer)} method. If load balancer is not specified then messaging channel will fall back to the
 * {@link DefaultLoadBalancer}.
 * </p>
 * <p>
 * Note that load balancing does not get applied to broadcast operations (like {@link MessagingChannel#broadcast(Object)} and {@link
 * MessagingChannel#aggregate(Object)}). Such operations are submitted to all nodes within the channel's cluster topology.
 * Please see the "<a href="#topology_filterring">Cluster topology filtering</a>" section for details of how to control the channel's
 * cluster topology.
 * </p>
 *
 * <h3>Consistent routing</h3>
 * <p>
 * Applications can provide an affinity key to the {@link LoadBalancer} so that it could perform consistent routing based on some
 * application-specific criteria. For example, if the {@link DefaultLoadBalancer} is being used by the messaging channel then it will make
 * sure that all messages with the same affinity key will always be routed to the same cluster node (unless the cluster topology doesn't
 * change) by using the channel's {@link MessagingChannel#partitions() partition mapper}. Custom implementations of the {@link
 * LoadBalancer} interface can use their own algorithms for consistent routing.
 * </p>
 *
 * <p>
 * Affinity key can for unicast operations can be specified via the following methods:
 * </p>
 * <ul>
 * <li>{@link Send#withAffinity(Object)}</li>
 * <li>{@link Request#withAffinity(Object)}</li>
 * <li>{@link Subscribe#withAffinity(Object)}</li>
 * </ul>
 *
 * <p>
 * Affinity key can for broadcast operations can be specified via the following methods:
 * </p>
 * <ul>
 * <li>{@link Broadcast#withAffinity(Object)}</li>
 * <li>{@link Aggregate#withAffinity(Object)}</li>
 * </ul>
 *
 * <p>
 * <b>Note:</b> If affinity key is specified for a broadcast operation then messaging channel will use its
 * {@link MessagingChannel#partitions() partition mapper} to select the target {@link Partition} for that key. Once the partition is
 * selected then all of its {@link Partition#nodes() nodes} will be used for broadcast (i.e. {@link Partition#primaryNode() primary node} +
 * {@link Partition#backupNodes() backup nodes}).
 * </p>
 *
 * <h3>Thread affinity</h3>
 * <p>
 * Besides providing a hint to the {@link LoadBalancer}, specifying an affinity key also instructs the messaging channel to process all
 * messages of the same affinity key on the same thread. This applies both to sending a message (see {@link SendCallback} or {@link
 * ResponseCallback}) and to receiving a message (see {@link MessageReceiver#receive(Message)}).
 * </p>
 *
 * <a name="topology_filterring"></a>
 * <h3>Cluster topology filtering</h3>
 * <p>
 * It is possible to narrow down the list of nodes that are visible to the {@link MessagingChannel} by setting a {@link ClusterNodeFilter}.
 * Such filter can be pre-configured via the {@link MessagingChannelConfig#setClusterFilter(ClusterNodeFilter)} method or set dynamically
 * via the {@link MessagingChannel#filter(ClusterNodeFilter)} method.
 * </p>
 *
 * <p>
 * Note that the {@link MessagingChannel} interface extends the {@link ClusterFilterSupport} interface, which gives it a number of shortcut
 * methods for dynamic filtering of the cluster topology:
 * </p>
 * <ul>
 * <li>{@link MessagingChannel#forRemotes()}</li>
 * <li>{@link MessagingChannel#forRole(String)}</li>
 * <li>{@link MessagingChannel#forProperty(String)}</li>
 * <li>{@link MessagingChannel#forNode(ClusterNode)}</li>
 * <li>{@link MessagingChannel#forOldest()}</li>
 * <li>{@link MessagingChannel#forYoungest()}</li>
 * <li>...{@link ClusterFilterSupport etc}</li>
 * </ul>
 *
 * <p>
 * If filter is specified then all messaging operations will be distributed among only those nodes that match the filter's criteria.
 * </p>
 *
 * <h2>Thread pooling</h2>
 * <p>
 * Messaging service manages a pool of threads for each of its registered channels. The following  thread pools are managed:
 * </p>
 *
 * <ul>
 * <li>
 * <b>NIO thread pool</b> - thread pool for managing NIO socket channels. The size of this thread pool is controlled by the {@link
 * MessagingChannelConfig#setNioThreads(int)} configuration option.
 * </li>
 * <li>
 * <b>Worker thread pool</b> - Optional thread pool to offload messages processing work from NIO threads. The size of this pool is
 * controlled by the {@link MessagingChannelConfig#setWorkerThreads(int)} configuration option. It is recommended to set this parameter in
 * case if message processing is a heavy operation that can block NIO thread for a long time.
 * </li>
 * </ul>
 *
 * <h2>Messaging failover</h2>
 * <p>
 * Failover of messaging errors is controlled by the {@link FailoverPolicy} interface. Implementations of this interface can be
 * configured for each {@link MessagingChannel} individually via {@link MessagingChannelConfig#setFailoverPolicy(FailoverPolicy)} method or
 * defined at runtime via {@link MessagingChannel#withFailover(FailoverPolicy)}. In case of a messaging error this interface will be called
 * by the channel in order to decided on whether the message should be retransmitted or the messaging operation should fail.
 * </p>
 * <p>
 * On the {@link MessageReceiver#receive(Message) receiving} side it is possible to detect messages that were retransmitted by checking the
 * {@link Message#isRetransmit()} flag.
 * </p>
 *
 * <p>
 * For more details and usage examples please see the documentation of {@link FailoverPolicy} interface.
 * </p>
 */
@DefaultServiceFactory(MessagingServiceFactory.class)
public interface MessagingService extends Service {
    /**
     * Returns all channels that are {@link MessagingServiceFactory#setChannels(List) registered} within this service.
     *
     * @return Channels or an empty list if there are no registered channels.
     */
    List<MessagingChannel<?>> allChannels();

    /**
     * Returns an unchecked messaging channel for the specified name.
     *
     * @param name Channel name (see {@link MessagingChannelConfig#setName(String)}).
     *
     * @return Messaging channel.
     *
     * @throws IllegalArgumentException if there is no such channel configuration with the specified name.
     * @see MessagingChannelConfig
     */
    MessagingChannel<Object> channel(String name) throws IllegalArgumentException;

    /**
     * Returns a type-safe messaging channel for the specified name.
     *
     * @param name Channel name (see {@link MessagingChannelConfig#setName(String)}).
     * @param baseType Base type of messages that can be supported by the messaging channel (see {@link
     * MessagingChannelConfig#MessagingChannelConfig(Class)}).
     * @param <T> Base type of messages that can be supported by the messaging channel.
     *
     * @return Messaging channel.
     *
     * @throws IllegalArgumentException if there is no such channel configuration with the specified name.
     * @see MessagingChannelConfig
     */
    <T> MessagingChannel<T> channel(String name, Class<T> baseType) throws IllegalArgumentException;

    /**
     * Returns {@code true} if this service has a messaging channel with the specified name.
     *
     * @param channelName Channel name (see {@link MessagingChannelConfig#setName(String)}).
     *
     * @return {@code true} if messaging channel exists.
     */
    boolean hasChannel(String channelName);
}
