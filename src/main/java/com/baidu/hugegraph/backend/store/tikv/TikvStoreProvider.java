/*
 * Copyright 2017 HugeGraph Authors
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.baidu.hugegraph.backend.store.tikv;

import com.baidu.hugegraph.backend.store.AbstractBackendStoreProvider;
import com.baidu.hugegraph.backend.store.BackendStore;
import com.baidu.hugegraph.backend.store.tikv.TikvStore.TikvGraphStore;
import com.baidu.hugegraph.backend.store.tikv.TikvStore.TikvSchemaStore;
import com.baidu.hugegraph.config.HugeConfig;

public class TikvStoreProvider extends AbstractBackendStoreProvider {

    public static final String TYPE = "tikv";

    protected String namespace() {
        return this.graph().toLowerCase();
    }

    @Override
    protected BackendStore newSchemaStore(HugeConfig config, String store) {
        return new TikvSchemaStore(this, this.namespace(), store);
    }

    @Override
    protected BackendStore newGraphStore(HugeConfig config, String store) {
        return new TikvGraphStore(this, this.namespace(), store);
    }

    @Override
    public String type() {
        return "tikv";
    }

    @Override
    public String version() {
        /*
         * Versions history:
         * [1.0] HugeGraph-1328: supports tikv
         */
        return "1.0";
    }
}
