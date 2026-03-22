package com.p016a.p019b.p028c.p030b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p043h.C0877g;

/* JADX INFO: renamed from: com.a.b.c.b.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0579d extends C0877g implements Comparable {

    /* JADX INFO: renamed from: a */
    public static final C0579d f769a = new C0579d(0);

    public C0579d(int i) {
        super(i);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0579d c0579d) {
        if (this == c0579d) {
            return 0;
        }
        int iD_ = m1977d_();
        int iD_2 = c0579d.m1977d_();
        int iMin = Math.min(iD_, iD_2);
        for (int i = 0; i < iMin; i++) {
            int iCompareTo = m921a(i).compareTo(c0579d.m921a(i));
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
    public final C0580e m921a(int i) {
        return (C0580e) m1978e(i);
    }

    /* JADX INFO: renamed from: a */
    public final String m922a(String str, String str2) {
        StringBuilder sb = new StringBuilder(100);
        int iD_ = m1977d_();
        sb.append(str);
        sb.append(str2);
        sb.append("catch ");
        for (int i = 0; i < iD_; i++) {
            C0580e c0580eM921a = m921a(i);
            if (i != 0) {
                sb.append(",\n");
                sb.append(str);
                sb.append("  ");
            }
            if (i == iD_ - 1 && m924e()) {
                sb.append("<any>");
            } else {
                sb.append(c0580eM921a.m926a().mo657d());
            }
            sb.append(" -> ");
            sb.append(C0985a.m2297w(c0580eM921a.m927b()));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m923a(int i, C0802z c0802z, int i2) {
        m1975a(i, new C0580e(c0802z, i2));
    }

    @Override // com.p016a.p019b.p043h.C0877g, com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return m922a("", "");
    }

    /* JADX INFO: renamed from: e */
    public final boolean m924e() {
        int iD_ = m1977d_();
        if (iD_ == 0) {
            return false;
        }
        return m921a(iD_ - 1).m926a().equals(C0802z.f1938a);
    }
}
