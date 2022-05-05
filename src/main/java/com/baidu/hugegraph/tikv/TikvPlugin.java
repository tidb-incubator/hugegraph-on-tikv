/*
 * Copyright 2019 HugeGraph Authors
 */

package com.baidu.hugegraph.tikv;

import com.baidu.hugegraph.backend.serializer.BinarySerializer;
import com.baidu.hugegraph.backend.store.tikv.TikvOptions;
import com.baidu.hugegraph.backend.store.tikv.TikvStoreProvider;
import com.baidu.hugegraph.plugin.HugeGraphPlugin;
import com.baidu.hugegraph.security.HugeSecurityManager;

import org.tikv.raw.RawKVClient;

public class TikvPlugin implements HugeGraphPlugin {

    @Override
    public String name() {
        return TikvStoreProvider.TYPE;
    }

    @Override
    public void register() {
        String classPath = TikvStoreProvider.class.getName();
        HugeGraphPlugin.registerBackend(TikvStoreProvider.TYPE, classPath);
        classPath = TikvOptions.class.getName();
        HugeGraphPlugin.registerOptions(TikvStoreProvider.TYPE, classPath);
        classPath = BinarySerializer.class.getName();
        HugeGraphPlugin.registerSerializer(TikvStoreProvider.TYPE, classPath);
        HugeSecurityManager.ignoreCheckedClass(RawKVClient.class.getName());
    }

    @Override
    public String supportsMinVersion() {
        return "0.13.0";
    }

    @Override
    public String supportsMaxVersion() {
        return "0.14";
    }

    public static void main(String[] args) {
        new TikvPlugin().register();
    }
}
