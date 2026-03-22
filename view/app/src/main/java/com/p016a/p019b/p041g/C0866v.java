package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0770v;
import com.p016a.p019b.p043h.C0886p;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: com.a.b.g.v */
/* JADX INFO: loaded from: classes.dex */
public final class C0866v extends C0886p {

    /* JADX INFO: renamed from: a */
    private final int f2214a;

    /* JADX INFO: renamed from: b */
    private final C0770v f2215b;

    /* JADX INFO: renamed from: c */
    private final C0770v[] f2216c;

    /* JADX INFO: renamed from: d */
    private final HashMap f2217d;

    public C0866v(C0838an c0838an) {
        if (c0838an == null) {
            throw new NullPointerException("method == null");
        }
        ArrayList arrayListM1864j = c0838an.m1864j();
        this.f2214a = c0838an.m1861g();
        this.f2215b = new C0770v(this.f2214a);
        this.f2216c = new C0770v[arrayListM1864j.size()];
        this.f2217d = new HashMap();
        this.f2215b.mo549b_();
    }

    /* JADX INFO: renamed from: b */
    private void m1930b(int i, C0770v c0770v) {
        m2004l();
        if (c0770v == null) {
            throw new NullPointerException("specs == null");
        }
        try {
            this.f2216c[i] = c0770v;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("bogus index");
        }
    }

    /* JADX INFO: renamed from: c */
    private C0770v m1931c(int i) {
        try {
            return this.f2216c[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("bogus index");
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0770v m1932a(int i) {
        C0770v c0770vM1931c = m1931c(i);
        return c0770vM1931c != null ? c0770vM1931c : this.f2215b;
    }

    /* JADX INFO: renamed from: a */
    public final void m1933a(AbstractC0836al abstractC0836al, C0766r c0766r) {
        m2004l();
        if (abstractC0836al == null) {
            throw new NullPointerException("insn == null");
        }
        if (c0766r == null) {
            throw new NullPointerException("spec == null");
        }
        this.f2217d.put(abstractC0836al, c0766r);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1934a(int i, C0770v c0770v) {
        C0770v c0770vM1931c = m1931c(i);
        if (c0770vM1931c == null) {
            m1930b(i, c0770v);
            return true;
        }
        C0770v c0770vM1573e = c0770vM1931c.m1573e();
        c0770vM1573e.m1566a(c0770v, true);
        if (c0770vM1931c.equals(c0770vM1573e)) {
            return false;
        }
        c0770vM1573e.mo549b_();
        m1930b(i, c0770vM1573e);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public final C0770v m1935b(int i) {
        C0770v c0770vM1931c = m1931c(i);
        return c0770vM1931c != null ? c0770vM1931c.m1573e() : new C0770v(this.f2214a);
    }
}
