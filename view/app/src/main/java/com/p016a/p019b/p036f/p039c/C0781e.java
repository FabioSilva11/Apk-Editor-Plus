package com.p016a.p019b.p036f.p039c;

import com.p016a.p019b.p043h.C0877g;

/* JADX INFO: renamed from: com.a.b.f.c.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0781e extends C0877g implements Comparable {
    public C0781e(int i) {
        super(i);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0781e c0781e) {
        int iD_ = m1977d_();
        int iD_2 = c0781e.m1977d_();
        int i = iD_ < iD_2 ? iD_ : iD_2;
        for (int i2 = 0; i2 < i; i2++) {
            int iCompareTo = ((AbstractC0775a) m1978e(i2)).compareTo((AbstractC0775a) c0781e.m1978e(i2));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        if (iD_ < iD_2) {
            return -1;
        }
        return iD_ > iD_2 ? 1 : 0;
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC0775a m1614a(int i) {
        return (AbstractC0775a) m1978e(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m1615a(int i, AbstractC0775a abstractC0775a) {
        m1975a(i, (Object) abstractC0775a);
    }
}
