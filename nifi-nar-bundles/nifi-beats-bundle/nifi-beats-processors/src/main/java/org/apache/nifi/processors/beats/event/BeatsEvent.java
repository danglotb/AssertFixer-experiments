/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.processors.beats.event;

import org.apache.nifi.processor.util.listen.event.StandardEvent;
import org.apache.nifi.processor.util.listen.response.ChannelResponder;

import java.nio.channels.SocketChannel;

/**
 * A Beat event which adds the transaction number to the StandardEvent.
 */
public class BeatsEvent extends StandardEvent<SocketChannel> {

    private final int seqNumber;

    public BeatsEvent(final String sender, final byte[] data, final ChannelResponder<SocketChannel> responder, final int seqNumber) {
        super(sender, data, responder);
        this.seqNumber = seqNumber;
    }

    public int getSeqNumber() {
        return seqNumber;
    }

}
