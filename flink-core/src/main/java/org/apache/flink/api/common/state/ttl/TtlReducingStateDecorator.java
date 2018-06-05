/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.api.common.state.ttl;

import org.apache.flink.api.common.state.ReducingState;

public class TtlReducingStateDecorator<T>
	extends AbstractTtlDecorator<ReducingState<TtlValue<T>>>
	implements ReducingState<T> {
	// TODO: throw unsupported exception for TtlUpdateType.OnReadAndWrite
	TtlReducingStateDecorator(ReducingState<TtlValue<T>> originalState,
							  TtlConfig config,
							  TtlTimeProvider timeProvider) {
		super(originalState, config, timeProvider);
	}

	@Override
	public T get() throws Exception {
		return getUnexpried(original.get());
	}

	@Override
	public void add(T value) throws Exception {
		original.add(value == null ? null : wrapWithTs(value));
	}

	@Override
	public void clear() {
		original.clear();
	}
}
