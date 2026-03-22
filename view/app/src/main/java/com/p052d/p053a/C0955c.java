package com.p052d.p053a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: com.d.a.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0955c implements InterfaceC0963k {
    @Override // com.p052d.p053a.InterfaceC0963k
    /* JADX INFO: renamed from: a */
    public final Object mo2111a(Object obj, InterfaceC0962j interfaceC0962j, Map map) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(interfaceC0962j.mo2110a(it.next(), map));
        }
        return arrayList;
    }
}
