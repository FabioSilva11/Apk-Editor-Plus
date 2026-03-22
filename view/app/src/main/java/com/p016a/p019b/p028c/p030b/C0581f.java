package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p043h.C0877g;

/* JADX INFO: renamed from: com.a.b.c.b.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0581f extends C0877g implements Comparable {

    /* JADX INFO: renamed from: a */
    public static final C0581f f772a = new C0581f(0);

    public C0581f(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a */
    public final C0582g m928a(int i) {
        return (C0582g) m1978e(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m929a(int i, C0582g c0582g) {
        m1975a(i, (Object) c0582g);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        C0581f c0581f = (C0581f) obj;
        if (this != c0581f) {
            int iD_ = m1977d_();
            int iD_2 = c0581f.m1977d_();
            int iMin = Math.min(iD_, iD_2);
            for (int i = 0; i < iMin; i++) {
                int iCompareTo = m928a(i).compareTo(c0581f.m928a(i));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            if (iD_ < iD_2) {
                return -1;
            }
            if (iD_ > iD_2) {
                return 1;
            }
        }
        return 0;
    }
}
