/*
 * Copyright (c) 2010-2017. Axon Framework
 *
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

package org.axonframework.mongo.eventsourcing.eventstore;

import com.mongodb.client.MongoCollection;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventsourcing.DomainEventMessage;
import org.axonframework.eventsourcing.eventstore.DomainEventData;
import org.axonframework.eventsourcing.eventstore.TrackedEventData;
import org.axonframework.eventsourcing.eventstore.TrackingToken;
import org.axonframework.serialization.Serializer;
import org.bson.Document;

import java.util.List;
import java.util.Optional;

/**
 * Interface towards the mechanism that prescribes the structure in which events are stored in the Event Store. Events
 * are provided in "commits", which represent a number of events generated by the same aggregate, inside a single Unit
 * of Work. Implementations may choose to use this fact, or ignore it.
 *
 * @author Allard Buijze
 * @author Rene de Waele
 */
public interface StorageStrategy {

    /**
     * Appends the given list of {@code events} to the given {@code eventCollection}. Use the given {@code serializer}
     * to serialize the payload and metadata of the events.
     *
     * @param eventCollection the document collection that contains event entries
     * @param events          the event messages to append to the event collection
     * @param serializer      the serializer used to serialize the event payload and metadata
     */
    void appendEvents(MongoCollection<Document> eventCollection, List<? extends EventMessage<?>> events,
                      Serializer serializer);

    /**
     * Append the given aggregate {@code snapshot} to the {@code snapshotCollection}. Use the given {@code serializer}
     * to serialize the payload and metadata of the snapshot.
     *
     * @param snapshotCollection the document collection that contains aggregate snapshot entries
     * @param snapshot           the snapshot event message to append to the event collection
     * @param serializer         the serializer used to serialize the payload and metadata of the snapshot event
     */
    void appendSnapshot(MongoCollection<Document> snapshotCollection, DomainEventMessage<?> snapshot,
                        Serializer serializer);

    /**
     * Delete all snapshots of the aggregate with given {@code aggregateIdentifier} from the given {@code
     * snapshotCollection}, whose sequence number is lower than the given {@code sequenceNumber}.
     *
     * @param snapshotCollection  the document collection that contains aggregate snapshot entries
     * @param aggregateIdentifier the identifier of the aggregate for which to delete all snapshots
     * @param sequenceNumber      The sequenceNumber representing the upper bound (exclusive) of the snapshots to delete
     */
    void deleteSnapshots(MongoCollection<Document> snapshotCollection, String aggregateIdentifier, long sequenceNumber);

    /**
     * Returns a batch of events for an aggregate with given {@code aggregateIdentifier} and a sequence number equal or
     * higher than the given {@code firstSequenceNumber}. The returned documents should be ordered chronologically
     * (typically by using the sequence number). The size of the returned list should not exceed the given {@code
     * batchSize}.
     *
     * @param eventCollection     The collection in which to find the events
     * @param aggregateIdentifier The identifier of the aggregate to query
     * @param firstSequenceNumber The sequence number of the first event to return
     * @param batchSize           The maximum number of event entries to fetch
     * @return a list of matching domain event entries
     */
    List<? extends DomainEventData<?>> findDomainEvents(MongoCollection<Document> eventCollection,
                                                        String aggregateIdentifier, long firstSequenceNumber,
                                                        int batchSize);


    /**
     * Returns a batch of tracked events with a tracking token above the given {@code lastToken}. If {@code lastToken}
     * is {@code null} the first (oldest) batch of entries in the store should be returned.
     * <p>
     * The returned documents should be ordered chronologically (typically by using the timestamp of the event). The
     * size of the returned list should not exceed the given {@code batchSize}.
     *
     * @param eventCollection The collection in which to find the events
     * @param lastToken       the token of the last event in the previous batch or {@code null} to load the oldest batch
     * @param batchSize       The maximum number of event entries to fetch
     * @return a list of matching tracked event entries
     */
    List<? extends TrackedEventData<?>> findTrackedEvents(MongoCollection<Document> eventCollection,
                                                          TrackingToken lastToken, int batchSize);

    /**
     * Finds the entry containing the last snapshot event for an aggregate with given {@code aggregateIdentifier}
     * in the given {@code collection}.
     *
     * @param snapshotCollection  The collection to find the last snapshot event in
     * @param aggregateIdentifier The identifier of the aggregate to find a snapshot for
     * @return an optional with DomainEventData of the snapshot if found
     */
    Optional<? extends DomainEventData<?>> findLastSnapshot(MongoCollection<Document> snapshotCollection,
                                                            String aggregateIdentifier);

    /**
     * Ensure that the correct indexes are in place.
     *
     * @param eventsCollection    The collection containing the documents representing commits and events.
     * @param snapshotsCollection The collection containing the document representing snapshots
     */
    void ensureIndexes(MongoCollection<Document> eventsCollection, MongoCollection<Document> snapshotsCollection);

    /**
     * Return the last known sequence number for an Aggregate with given {@code aggregateIdentifier}, whose Events are
     * stored in the given {@code eventsCollection}.
     *
     * @param eventsCollection    The Collection in which to search for Events
     * @param aggregateIdentifier The aggregate to find the last sequence number for
     * @return An optional with the last sequence number, or an empty optional if no Events are present for the given
     * aggregate.
     */
    Optional<Long> lastSequenceNumberFor(MongoCollection<Document> eventsCollection, String aggregateIdentifier);

    /**
     * Creates a token that is at the tail of an event stream - that tracks events from the beginning of time.
     *
     * @return a tracking token at the tail of an event stream, if event stream is empty {@code null} is returned
     */
    TrackingToken createTailToken(MongoCollection<Document> eventsCollection);
}
