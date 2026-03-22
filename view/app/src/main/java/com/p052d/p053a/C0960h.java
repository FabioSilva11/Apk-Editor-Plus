package com.p052d.p053a;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: renamed from: com.d.a.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0960h implements InterfaceC0963k {
    @Override // com.p052d.p053a.InterfaceC0963k
    /* JADX INFO: renamed from: a */
    public final Object mo2111a(Object obj, InterfaceC0962j interfaceC0962j, Map map) {
        LinkedList linkedList = new LinkedList();
        Iterator it = ((LinkedList) obj).iterator();
        while (it.hasNext()) {
            linkedList.add(interfaceC0962j.mo2110a(it.next(), map));
        }
        return linkedList;
    }
}
