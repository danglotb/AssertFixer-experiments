/*
 * Copyright (c) 2017 Bosch Software Innovations GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/org/documents/epl-2.0/index.php
 *
 * Contributors:
 *    Bosch Software Innovations GmbH - initial contribution
 */
package org.eclipse.ditto.signals.events.things;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import org.eclipse.ditto.json.JsonFactory;
import org.eclipse.ditto.json.JsonField;
import org.eclipse.ditto.json.JsonObject;
import org.eclipse.ditto.json.JsonObjectBuilder;
import org.eclipse.ditto.json.JsonPointer;
import org.eclipse.ditto.json.JsonValue;
import org.eclipse.ditto.model.base.headers.DittoHeaders;
import org.eclipse.ditto.model.base.json.FieldType;
import org.eclipse.ditto.model.base.json.JsonSchemaVersion;
import org.eclipse.ditto.model.things.Thing;
import org.eclipse.ditto.model.things.ThingsModelFactory;
import org.eclipse.ditto.signals.events.base.EventJsonDeserializer;

/**
 * This event is emitted after a {@link Thing} was created.
 */
@Immutable
public final class ThingCreated extends AbstractThingEvent<ThingCreated> implements ThingModifiedEvent<ThingCreated> {

    /**
     * Name of the "Thing Created" event.
     */
    public static final String NAME = "thingCreated";

    /**
     * Type of this event.
     */
    public static final String TYPE = TYPE_PREFIX + NAME;

    private final Thing thing;

    private ThingCreated(final Thing thing,
            final long revision,
            @Nullable final Instant timestamp,
            final DittoHeaders dittoHeaders) {

        super(TYPE, thing.getId().orElse(null), revision, timestamp, dittoHeaders);
        this.thing = thing;
    }

    /**
     * Constructs a new {@code ThingCreated} object.
     *
     * @param thing the created {@link Thing}.
     * @param revision the revision of the Thing.
     * @param dittoHeaders the headers of the command which was the cause of this event.
     * @return the ThingCreated created.
     * @throws NullPointerException if any argument is {@code null}.
     */
    public static ThingCreated of(final Thing thing, final long revision, final DittoHeaders dittoHeaders) {
        return of(thing, revision, null, dittoHeaders);
    }

    /**
     * Constructs a new {@code ThingCreated} object.
     *
     * @param thing the created {@link Thing}.
     * @param revision the revision of the Thing.
     * @param timestamp the timestamp of this event.
     * @param dittoHeaders the headers of the command which was the cause of this event.
     * @return the ThingCreated created.
     * @throws NullPointerException if any argument but {@code timestamp} is {@code null}.
     */
    public static ThingCreated of(final Thing thing,
            final long revision,
            @Nullable final Instant timestamp,
            final DittoHeaders dittoHeaders) {

        return new ThingCreated(thing, revision, timestamp, dittoHeaders);
    }

    /**
     * Creates a new {@code ThingCreated} from a JSON string.
     *
     * @param jsonString the JSON string of which a new ThingCreated instance is to be deleted.
     * @param dittoHeaders the headers of the command which was the cause of this event.
     * @return the {@code ThingCreated} which was deleted from the given JSON string.
     * @throws NullPointerException if {@code jsonString} is {@code null}.
     * @throws org.eclipse.ditto.json.JsonParseException if the passed in {@code jsonString} was not in the expected
     * 'ThingCreated' format.
     */
    public static ThingCreated fromJson(final String jsonString, final DittoHeaders dittoHeaders) {
        return fromJson(JsonFactory.newObject(jsonString), dittoHeaders);
    }

    /**
     * Creates a new {@code ThingCreated} from a JSON object.
     *
     * @param jsonObject the JSON object from which a new ThingCreated instance is to be created.
     * @param dittoHeaders the headers of the command which was the cause of this event.
     * @return the {@code ThingCreated} which was created from the given JSON object.
     * @throws NullPointerException if {@code jsonObject} is {@code null}.
     * @throws org.eclipse.ditto.json.JsonParseException if the passed in {@code jsonObject} was not in the expected
     * 'ThingCreated' format.
     */
    public static ThingCreated fromJson(final JsonObject jsonObject, final DittoHeaders dittoHeaders) {
        return new EventJsonDeserializer<ThingCreated>(TYPE, jsonObject).deserialize((revision, timestamp) -> {
            final JsonObject thingJsonObject = jsonObject.getValueOrThrow(JsonFields.THING);
            final Thing extractedThing = ThingsModelFactory.newThing(thingJsonObject);

            return of(extractedThing, revision, timestamp, dittoHeaders);
        });
    }

    /**
     * Returns the created {@link Thing}.
     *
     * @return the created Thing.
     */
    public Thing getThing() {
        return thing;
    }

    @Override
    public ThingCreated setRevision(final long revision) {
        return of(thing, revision, getTimestamp().orElse(null), getDittoHeaders());
    }

    @Override
    public ThingCreated setDittoHeaders(final DittoHeaders dittoHeaders) {
        return of(thing, getRevision(), getTimestamp().orElse(null), dittoHeaders);
    }

    @Override
    public Optional<JsonValue> getEntity(final JsonSchemaVersion schemaVersion) {
        return Optional.ofNullable(thing.toJson(schemaVersion, FieldType.notHidden()));
    }

    @Override
    public JsonPointer getResourcePath() {
        return JsonPointer.empty();
    }

    @Override
    protected void appendPayloadAndBuild(final JsonObjectBuilder jsonObjectBuilder,
            final JsonSchemaVersion schemaVersion, final Predicate<JsonField> thePredicate) {
        final Predicate<JsonField> predicate = schemaVersion.and(thePredicate);
        jsonObjectBuilder.set(JsonFields.THING, thing.toJson(schemaVersion, thePredicate), predicate);
    }

    @SuppressWarnings("squid:S109")
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hashCode(thing);
        return result;
    }

    @SuppressWarnings("squid:MethodCyclomaticComplexity")
    @Override
    public boolean equals(@Nullable final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ThingCreated that = (ThingCreated) o;
        return that.canEqual(this) && Objects.equals(thing, that.thing) && super.equals(that);
    }

    @Override
    protected boolean canEqual(final Object other) {
        return (other instanceof ThingCreated);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + super.toString() + ", thing=" + thing + "]";
    }

}
