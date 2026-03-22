package com.p052d.p053a;

import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.d.a.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0961i implements InterfaceC0963k {
    @Override // com.p052d.p053a.InterfaceC0963k
    /* JADX INFO: renamed from: a */
    public final Object mo2111a(Object obj, InterfaceC0962j interfaceC0962j, Map map) {
        TreeMap treeMap = (TreeMap) obj;
        TreeMap treeMap2 = new TreeMap(treeMap.comparator());
        for (Map.Entry entry : treeMap.entrySet()) {
            treeMap2.put(interfaceC0962j.mo2110a(entry.getKey(), map), interfaceC0962j.mo2110a(entry.getValue(), map));
        }
        return treeMap2;
    }
}
