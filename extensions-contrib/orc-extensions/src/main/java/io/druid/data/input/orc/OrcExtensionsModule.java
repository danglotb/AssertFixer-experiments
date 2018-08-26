/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.druid.data.input.orc;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.inject.Binder;
import io.druid.initialization.DruidModule;

import java.util.Collections;
import java.util.List;

public class OrcExtensionsModule implements DruidModule
{
  @Override
  public List<? extends Module> getJacksonModules()
  {
    return Collections.singletonList(
        new SimpleModule("OrcInputRowParserModule")
            .registerSubtypes(
                new NamedType(OrcHadoopInputRowParser.class, "orc")
            )
    );
  }

  @Override
  public void configure(Binder binder)
  {
  }
}
