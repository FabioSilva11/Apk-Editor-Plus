package com.p052d.p053a;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: com.d.a.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0959g implements InterfaceC0963k {
    @Override // com.p052d.p053a.InterfaceC0963k
    /* JADX INFO: renamed from: a */
    public final Object mo2111a(Object obj, InterfaceC0962j interfaceC0962j, Map map) {
        HashSet hashSet = new HashSet();
        Iterator it = ((HashSet) obj).iterator();
        while (it.hasNext()) {
            hashSet.add(interfaceC0962j.mo2110a(it.next(), map));
        }
        return hashSet;
    }
}
