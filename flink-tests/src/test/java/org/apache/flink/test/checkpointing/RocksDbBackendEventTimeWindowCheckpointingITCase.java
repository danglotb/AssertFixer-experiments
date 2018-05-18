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

package org.apache.flink.test.checkpointing;

/**
 * Integration tests for fully synchronous RocksDB backend.
 */
public class RocksDbBackendEventTimeWindowCheckpointingITCase extends AbstractEventTimeWindowCheckpointingITCase {

	@Override
	protected StateBackendEnum getStateBackend() {
		return StateBackendEnum.ROCKSDB_FULLY_ASYNC;
	}

	@Override
	protected int numElementsPerKey() {
		return 3000;
	}

	@Override
	protected int windowSize() {
		return 1000;
	}

	@Override
	protected int windowSlide() {
		return 100;
	}

	@Override
	protected int numKeys() {
		return 100;
	}
}
