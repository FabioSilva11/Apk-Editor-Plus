package com.p016a.p019b.p036f.p038b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p043h.C0880j;
import com.p016a.p019b.p043h.InterfaceC0882l;

/* JADX INFO: renamed from: com.a.b.f.b.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0745a implements InterfaceC0882l {

    /* JADX INFO: renamed from: a */
    private final int f1619a;

    /* JADX INFO: renamed from: b */
    private final C0760l f1620b;

    /* JADX INFO: renamed from: c */
    private final C0880j f1621c;

    /* JADX INFO: renamed from: d */
    private final int f1622d;

    public C0745a(int i, C0760l c0760l, C0880j c0880j, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("label < 0");
        }
        try {
            c0760l.m2005m();
            int iD_ = c0760l.m1977d_();
            if (iD_ == 0) {
                throw new IllegalArgumentException("insns.size() == 0");
            }
            for (int i3 = iD_ - 2; i3 >= 0; i3--) {
                if (c0760l.m1497a(i3).m1490f().m1577d() != 1) {
                    throw new IllegalArgumentException("insns[" + i3 + "] is a branch or can throw");
                }
            }
            if (c0760l.m1497a(iD_ - 1).m1490f().m1577d() == 1) {
                throw new IllegalArgumentException("insns does not end with a branch or throwing instruction");
            }
            try {
                c0880j.m2005m();
                if (i2 < -1) {
                    throw new IllegalArgumentException("primarySuccessor < -1");
                }
                if (i2 >= 0 && !c0880j.m1998h(i2)) {
                    throw new IllegalArgumentException("primarySuccessor " + i2 + " not in successors " + c0880j);
                }
                this.f1619a = i;
                this.f1620b = c0760l;
                this.f1621c = c0880j;
                this.f1622d = i2;
            } catch (NullPointerException e) {
                throw new NullPointerException("successors == null");
            }
        } catch (NullPointerException e2) {
            throw new NullPointerException("insns == null");
        }
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0882l
    /* JADX INFO: renamed from: a */
    public final int mo559a() {
        return this.f1619a;
    }

    /* JADX INFO: renamed from: b */
    public final C0760l m1457b() {
        return this.f1620b;
    }

    /* JADX INFO: renamed from: c */
    public final C0880j m1458c() {
        return this.f1621c;
    }

    /* JADX INFO: renamed from: d */
    public final int m1459d() {
        return this.f1622d;
    }

    /* JADX INFO: renamed from: e */
    public final int m1460e() {
        if (this.f1621c.m1985b() != 2) {
            throw new UnsupportedOperationException("block doesn't have exactly two successors");
        }
        int iM1986b = this.f1621c.m1986b(0);
        return iM1986b == this.f1622d ? this.f1621c.m1986b(1) : iM1986b;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    /* JADX INFO: renamed from: f */
    public final AbstractC0757i m1461f() {
        return this.f1620b.m1497a(0);
    }

    /* JADX INFO: renamed from: g */
    public final AbstractC0757i m1462g() {
        return this.f1620b.m1501e();
    }

    /* JADX INFO: renamed from: h */
    public final boolean m1463h() {
        return this.f1620b.m1501e().m1495k();
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    /* JADX INFO: renamed from: i */
    public final boolean m1464i() {
        return this.f1620b.m1501e().mo1470b().mo759d_() != 0;
    }

    public final String toString() {
        return "{" + C0985a.m2296v(this.f1619a) + '}';
    }
}
