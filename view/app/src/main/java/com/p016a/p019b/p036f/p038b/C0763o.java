package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p043h.C0886p;
import java.util.HashMap;

/* JADX INFO: renamed from: com.a.b.f.b.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0763o extends C0886p {

    /* JADX INFO: renamed from: a */
    private final int f1659a;

    /* JADX INFO: renamed from: b */
    private final C0770v f1660b;

    /* JADX INFO: renamed from: c */
    private final C0770v[] f1661c;

    /* JADX INFO: renamed from: d */
    private final HashMap f1662d;

    public C0763o(C0772x c0772x) {
        if (c0772x == null) {
            throw new NullPointerException("method == null");
        }
        C0751c c0751cM1582a = c0772x.m1582a();
        int iJ = c0751cM1582a.m2001j();
        this.f1659a = c0751cM1582a.m1479e();
        this.f1660b = new C0770v(this.f1659a);
        this.f1661c = new C0770v[iJ];
        this.f1662d = new HashMap(c0751cM1582a.m1480f());
        this.f1660b.mo549b_();
    }

    /* JADX INFO: renamed from: b */
    private void m1508b(int i, C0770v c0770v) {
        m2004l();
        if (c0770v == null) {
            throw new NullPointerException("specs == null");
        }
        try {
            this.f1661c[i] = c0770v;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("bogus label");
        }
    }

    /* JADX INFO: renamed from: c */
    private C0770v m1509c(int i) {
        try {
            return this.f1661c[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("bogus label");
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0766r m1510a(AbstractC0757i abstractC0757i) {
        return (C0766r) this.f1662d.get(abstractC0757i);
    }

    /* JADX INFO: renamed from: a */
    public final C0770v m1511a(int i) {
        C0770v c0770vM1509c = m1509c(i);
        return c0770vM1509c != null ? c0770vM1509c : this.f1660b;
    }

    /* JADX INFO: renamed from: a */
    public final void m1512a(AbstractC0757i abstractC0757i, C0766r c0766r) {
        m2004l();
        if (abstractC0757i == null) {
            throw new NullPointerException("insn == null");
        }
        if (c0766r == null) {
            throw new NullPointerException("spec == null");
        }
        this.f1662d.put(abstractC0757i, c0766r);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1513a(int i, C0770v c0770v) {
        C0770v c0770vM1509c = m1509c(i);
        if (c0770vM1509c == null) {
            m1508b(i, c0770v);
            return true;
        }
        C0770v c0770vM1573e = c0770vM1509c.m1573e();
        if (c0770vM1509c.m1571d() != 0) {
            c0770vM1573e.m1566a(c0770v, true);
        } else {
            c0770vM1573e = c0770v.m1573e();
        }
        if (c0770vM1509c.equals(c0770vM1573e)) {
            return false;
        }
        c0770vM1573e.mo549b_();
        m1508b(i, c0770vM1573e);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public final int m1514b() {
        return this.f1662d.size();
    }

    /* JADX INFO: renamed from: b */
    public final C0770v m1515b(int i) {
        C0770v c0770vM1509c = m1509c(i);
        return c0770vM1509c != null ? c0770vM1509c.m1573e() : new C0770v(this.f1659a);
    }
}
