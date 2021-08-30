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

package org.apache.skywalking.oap.server.configuration.etcd;

import com.google.common.base.Strings;
import java.util.Arrays;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.skywalking.oap.server.library.module.ModuleConfig;

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class EtcdServerSettings extends ModuleConfig {
    private int period;
    private String endpoints;
    private String namespace;
    private String authority;
    private String user;
    private String password;

    private boolean authentication;

    public String getNamespace() {
        if (Strings.isNullOrEmpty(namespace)) {
            return null;
        }
        if (!namespace.endsWith("/")) {
            return namespace + "/";
        }
        return namespace;
    }

    public String[] getEndpointArray() {
        return Arrays.stream(endpoints.split("\\s*,\\s*")).toArray(String[]::new);
    }
}
