package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: renamed from: com.a.b.g.c */
/* JADX INFO: loaded from: classes.dex */
final class C0847c implements Comparator {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ HashMap f2159a;

    C0847c(C0846b c0846b, HashMap map) {
        this.f2159a = map;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AbstractC0775a abstractC0775a = (AbstractC0775a) obj;
        AbstractC0775a abstractC0775a2 = (AbstractC0775a) obj2;
        int iIntValue = ((Integer) this.f2159a.get(abstractC0775a2)).intValue() - ((Integer) this.f2159a.get(abstractC0775a)).intValue();
        return iIntValue == 0 ? abstractC0775a.compareTo(abstractC0775a2) : iIntValue;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        return obj == this;
    }
}
