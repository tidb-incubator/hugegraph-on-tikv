/*
 * Copyright 2019 HugeGraph Authors
 */

package com.baidu.hugegraph.tikv;

import com.baidu.hugegraph.backend.store.tikv.TikvStoreProvider;
import com.baidu.hugegraph.plugin.HugeGraphPlugin;

public class TikvPlugin implements HugeGraphPlugin {

    @Override
    public String name() {
        return TikvStoreProvider.TYPE;
    }

    @Override
    public void register() {
        String classPath = TikvStoreProvider.class.getName();
        HugeGraphPlugin.registerBackend(TikvStoreProvider.TYPE, classPath);
    }

    @Override
    public String supportsMinVersion() {
        return "0.11.2";
    }

    @Override
    public String supportsMaxVersion() {
        return "0.12";
    }

    public static void main(String[] args) {
        new com.baidu.hugegraph.tikv.TikvPlugin().register();
    }
}
