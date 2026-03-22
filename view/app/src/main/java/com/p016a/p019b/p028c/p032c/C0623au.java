package com.p016a.p019b.p028c.p032c;

import com.p016a.p019b.p043h.C0888r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.a.b.c.c.au */
/* JADX INFO: loaded from: classes.dex */
public final class C0623au {

    /* JADX INFO: renamed from: a */
    private final HashMap f1104a = new HashMap(50);

    /* JADX INFO: renamed from: a */
    public final String m1105a() {
        StringBuilder sb = new StringBuilder();
        sb.append("Statistics:\n");
        TreeMap treeMap = new TreeMap();
        for (C0624av c0624av : this.f1104a.values()) {
            treeMap.put(c0624av.f1105a, c0624av);
        }
        Iterator it = treeMap.values().iterator();
        while (it.hasNext()) {
            sb.append(((C0624av) it.next()).m1109a());
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m1106a(AbstractC0606ad abstractC0606ad) {
        String strMo657d = abstractC0606ad.mo1040a().mo657d();
        C0624av c0624av = (C0624av) this.f1104a.get(strMo657d);
        if (c0624av == null) {
            this.f1104a.put(strMo657d, new C0624av(abstractC0606ad, strMo657d));
        } else {
            c0624av.m1110a(abstractC0606ad);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1107a(C0888r c0888r) {
        if (this.f1104a.size() == 0) {
            return;
        }
        c0888r.m2010a(0, "\nstatistics:\n");
        TreeMap treeMap = new TreeMap();
        for (C0624av c0624av : this.f1104a.values()) {
            treeMap.put(c0624av.f1105a, c0624av);
        }
        Iterator it = treeMap.values().iterator();
        while (it.hasNext()) {
            c0888r.m2015a(((C0624av) it.next()).m1109a());
        }
    }
}
