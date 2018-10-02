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
package org.apache.knox.gateway.dispatch;

class NiFiHeaders {
  static final String X_FORWARDED_PROTO = "X-Forwarded-Proto";
  static final String X_FORWARDED_HOST = "X-Forwarded-Server";
  static final String X_FORWARDED_PORT = "X-Forwarded-Port";
  static final String X_FORWARDED_CONTEXT = "X-Forwarded-Context";
  static final String X_PROXIED_ENTITIES_CHAIN = "X-ProxiedEntitiesChain";
}
