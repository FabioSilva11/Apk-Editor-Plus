package com.p016a.p019b.p020a.p022b;

import com.p016a.p017a.p018a.C0400d;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p043h.C0880j;

/* JADX INFO: renamed from: com.a.b.a.b.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0476n {

    /* JADX INFO: renamed from: a */
    private final AbstractC0481s f568a;

    /* JADX INFO: renamed from: b */
    private final C0475m f569b;

    /* JADX INFO: renamed from: c */
    private final C0880j f570c;

    public C0476n(int i, int i2) {
        this(new C0484v(i), new C0475m(i2));
    }

    private C0476n(AbstractC0481s abstractC0481s, C0475m c0475m) {
        this(abstractC0481s, c0475m, C0880j.f2245a);
    }

    private C0476n(AbstractC0481s abstractC0481s, C0475m c0475m, C0880j c0880j) {
        if (abstractC0481s == null) {
            throw new NullPointerException("locals == null");
        }
        if (c0475m == null) {
            throw new NullPointerException("stack == null");
        }
        c0880j.m2005m();
        this.f568a = abstractC0481s;
        this.f569b = c0475m;
        this.f570c = c0880j;
    }

    /* JADX INFO: renamed from: a */
    public final C0476n m611a() {
        return new C0476n(this.f568a.mo643a(), this.f569b.m598a(), this.f570c);
    }

    /* JADX INFO: renamed from: a */
    public final C0476n m612a(int i, int i2) {
        AbstractC0481s abstractC0481sM656b = this.f568a instanceof C0482t ? ((C0482t) this.f568a).m656b(i2) : null;
        try {
            C0880j c0880jM1995f = this.f570c.m1995f();
            if (c0880jM1995f.m1992e() != i) {
                throw new RuntimeException("returning from invalid subroutine");
            }
            c0880jM1995f.mo549b_();
            if (abstractC0481sM656b == null) {
                return null;
            }
            return new C0476n(abstractC0481sM656b, this.f569b, c0880jM1995f);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("returning from invalid subroutine");
        } catch (NullPointerException e2) {
            throw new NullPointerException("can't return from non-subroutine");
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0476n m613a(C0476n c0476n) {
        C0880j c0880j;
        AbstractC0481s abstractC0481sMo644a = this.f568a.mo644a(c0476n.f568a);
        C0475m c0475mM599a = this.f569b.m599a(c0476n.f569b);
        C0880j c0880j2 = c0476n.f570c;
        if (this.f570c.equals(c0880j2)) {
            c0880j = this.f570c;
        } else {
            c0880j = new C0880j();
            int iM1985b = this.f570c.m1985b();
            int iM1985b2 = c0880j2.m1985b();
            for (int i = 0; i < iM1985b && i < iM1985b2 && this.f570c.m1986b(i) == c0880j2.m1986b(i); i++) {
                c0880j.m1988c(i);
            }
            c0880j.mo549b_();
        }
        if (abstractC0481sMo644a instanceof C0482t) {
            abstractC0481sMo644a = (C0482t) abstractC0481sMo644a;
            if (c0880j.m1985b() == 0) {
                abstractC0481sMo644a = abstractC0481sMo644a.mo651b();
            }
        }
        return (abstractC0481sMo644a == this.f568a && c0475mM599a == this.f569b && this.f570c == c0880j) ? this : new C0476n(abstractC0481sMo644a, c0475mM599a, c0880j);
    }

    /* JADX INFO: renamed from: a */
    public final C0476n m614a(C0476n c0476n, int i, int i2) {
        C0880j c0880j;
        C0482t c0482tMo645a = this.f568a.mo645a(c0476n.f568a, i2);
        C0475m c0475mM599a = this.f569b.m599a(c0476n.f569b);
        C0880j c0880jM1995f = c0476n.f570c.m1995f();
        c0880jM1995f.m1988c(i);
        c0880jM1995f.mo549b_();
        if (c0482tMo645a == this.f568a && c0475mM599a == this.f569b && this.f570c.equals(c0880jM1995f)) {
            return this;
        }
        if (this.f570c.equals(c0880jM1995f)) {
            c0880j = this.f570c;
        } else {
            if (this.f570c.m1985b() > c0880jM1995f.m1985b()) {
                c0880j = this.f570c;
            } else {
                c0880jM1995f = this.f570c;
                c0880j = c0880jM1995f;
            }
            int iM1985b = c0880j.m1985b();
            int iM1985b2 = c0880jM1995f.m1985b();
            for (int i3 = iM1985b2 - 1; i3 >= 0; i3--) {
                if (c0880jM1995f.m1986b(i3) != c0880j.m1986b((iM1985b - iM1985b2) + i3)) {
                    throw new RuntimeException("Incompatible merged subroutines");
                }
            }
        }
        return new C0476n(c0482tMo645a, c0475mM599a, c0880j);
    }

    /* JADX INFO: renamed from: a */
    public final C0476n m615a(C0802z c0802z) {
        C0475m c0475mM598a = this.f569b.m598a();
        c0475mM598a.m608c();
        c0475mM598a.m604a(c0802z);
        return new C0476n(this.f568a, c0475mM598a, this.f570c);
    }

    /* JADX INFO: renamed from: a */
    public final void m616a(C0400d c0400d) {
        this.f568a.mo648a(c0400d);
        this.f569b.m602a(c0400d);
    }

    /* JADX INFO: renamed from: a */
    public final void m617a(C0804b c0804b) {
        int iD_ = c0804b.m1977d_();
        int iM1687i = 0;
        for (int i = 0; i < iD_; i++) {
            C0805c c0805cM1676b = c0804b.m1676b(i);
            this.f568a.mo647a(iM1687i, c0805cM1676b);
            iM1687i += c0805cM1676b.m1687i();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m618a(C0805c c0805c) {
        this.f568a.mo650a(c0805c);
        this.f569b.m603a(c0805c);
    }

    /* JADX INFO: renamed from: b */
    public final C0476n m619b(int i, int i2) {
        this.f570c.m1995f().m1988c(i);
        return new C0476n(this.f568a.mo651b(), this.f569b, C0880j.m1982a(i)).m614a(this, i, i2);
    }

    /* JADX INFO: renamed from: b */
    public final void m620b() {
        this.f568a.mo549b_();
        this.f569b.mo549b_();
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC0481s m621c() {
        return this.f568a;
    }

    /* JADX INFO: renamed from: d */
    public final C0475m m622d() {
        return this.f569b;
    }

    /* JADX INFO: renamed from: e */
    public final C0880j m623e() {
        return this.f570c;
    }
}
