/**
 * Copyright (c) 2017, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.timeseries.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.powsybl.timeseries.ArrayChunk;
import com.powsybl.timeseries.StringArrayChunk;
import com.powsybl.timeseries.TimeSeriesException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Geoffroy Jamgotchian <geoffroy.jamgotchian at rte-france.com>
 */
public class StringArrayChunkJsonDeserializer extends StdDeserializer<StringArrayChunk> {

    public StringArrayChunkJsonDeserializer() {
        super(StringArrayChunk.class);
    }

    @Override
    public StringArrayChunk deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        List<StringArrayChunk> chunks = new ArrayList<>();
        ArrayChunk.parseJson(jsonParser, Collections.emptyList(), chunks, true);
        if (chunks.size() != 1) {
            throw new TimeSeriesException("String array chunk JSON deserialization error");
        }
        return chunks.get(0);
    }
}
