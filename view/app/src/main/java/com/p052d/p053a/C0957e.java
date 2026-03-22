package com.p052d.p053a;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.d.a.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0957e implements InterfaceC0963k {
    @Override // com.p052d.p053a.InterfaceC0963k
    /* JADX INFO: renamed from: a */
    public final Object mo2111a(Object obj, InterfaceC0962j interfaceC0962j, Map map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry entry : ((ConcurrentHashMap) obj).entrySet()) {
            concurrentHashMap.put(interfaceC0962j.mo2110a(entry.getKey(), map), interfaceC0962j.mo2110a(entry.getValue(), map));
        }
        return concurrentHashMap;
    }
}
