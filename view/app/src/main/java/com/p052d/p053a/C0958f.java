package com.p052d.p053a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.d.a.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0958f implements InterfaceC0963k {
    @Override // com.p052d.p053a.InterfaceC0963k
    /* JADX INFO: renamed from: a */
    public final Object mo2111a(Object obj, InterfaceC0962j interfaceC0962j, Map map) {
        HashMap map2 = new HashMap();
        for (Map.Entry entry : ((HashMap) obj).entrySet()) {
            map2.put(interfaceC0962j.mo2110a(entry.getKey(), map), interfaceC0962j.mo2110a(entry.getValue(), map));
        }
        return map2;
    }
}
