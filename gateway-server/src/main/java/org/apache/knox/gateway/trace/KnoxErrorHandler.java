/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.knox.gateway.trace;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.ErrorHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class KnoxErrorHandler extends ErrorHandler {

  private Set<Integer> bodyFilter;

  public void setTracedBodyFilter( String s ) {
    bodyFilter = TraceUtil.parseIntegerSet( s );
  }

  @Override
  public void handle( String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response )
      throws IOException {
    HttpServletResponse traceResponse = new TraceResponse( response, bodyFilter );
    super.handle( target, baseRequest, request, traceResponse );
  }

}
