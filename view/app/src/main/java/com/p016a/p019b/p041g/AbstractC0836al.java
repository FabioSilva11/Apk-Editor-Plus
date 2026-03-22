package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.AbstractC0757i;
import com.p016a.p019b.p036f.p038b.C0761m;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0771w;
import com.p016a.p019b.p043h.InterfaceC0889s;

/* JADX INFO: renamed from: com.a.b.g.al */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0836al implements InterfaceC0889s, Cloneable {

    /* JADX INFO: renamed from: a */
    private final C0833ai f2125a;

    /* JADX INFO: renamed from: b */
    private C0766r f2126b;

    protected AbstractC0836al(C0766r c0766r, C0833ai c0833ai) {
        if (c0833ai == null) {
            throw new NullPointerException("block == null");
        }
        this.f2125a = c0833ai;
        this.f2126b = c0766r;
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC0836al m1822a(AbstractC0757i abstractC0757i, C0833ai c0833ai) {
        return new C0870z(abstractC0757i, c0833ai);
    }

    /* JADX INFO: renamed from: a */
    public abstract C0768t mo1756a();

    /* JADX INFO: renamed from: a */
    public final void m1823a(C0761m c0761m) {
        if (c0761m != this.f2126b.m1535i()) {
            if (c0761m == null || !c0761m.equals(this.f2126b.m1535i())) {
                this.f2126b = C0766r.m1520b(this.f2126b.m1533g(), this.f2126b.mo663a(), c0761m);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo1761a(AbstractC0831ag abstractC0831ag);

    /* JADX INFO: renamed from: a */
    public abstract void mo1762a(InterfaceC0837am interfaceC0837am);

    /* JADX INFO: renamed from: b */
    public abstract AbstractC0757i mo1764b();

    /* JADX INFO: renamed from: b */
    protected final void m1824b(C0766r c0766r) {
        if (c0766r == null) {
            throw new NullPointerException("result == null");
        }
        this.f2126b = c0766r;
    }

    /* JADX INFO: renamed from: b */
    public final void m1825b(AbstractC0831ag abstractC0831ag) {
        C0766r c0766r = this.f2126b;
        this.f2126b = abstractC0831ag.mo1700a(this.f2126b);
        this.f2125a.m1816n().m1844a(this, c0766r);
        mo1761a(abstractC0831ag);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m1826b(int i) {
        return this.f2126b != null && this.f2126b.m1533g() == i;
    }

    /* JADX INFO: renamed from: c */
    public abstract C0771w mo1765c();

    /* JADX INFO: renamed from: c */
    public final void m1827c(int i) {
        if (this.f2126b != null) {
            this.f2126b = this.f2126b.m1525a(i);
        }
    }

    /* JADX INFO: renamed from: e */
    public abstract AbstractC0757i mo1766e();

    /* JADX INFO: renamed from: f */
    public C0766r mo1828f() {
        if (this.f2126b == null || this.f2126b.m1535i() == null) {
            return null;
        }
        return this.f2126b;
    }

    /* JADX INFO: renamed from: h */
    public boolean mo1829h() {
        return false;
    }

    /* JADX INFO: renamed from: i */
    public boolean mo1830i() {
        return false;
    }

    /* JADX INFO: renamed from: j */
    public abstract boolean mo1768j();

    /* JADX INFO: renamed from: k */
    public abstract boolean mo1769k();

    /* JADX INFO: renamed from: l */
    public abstract boolean mo1770l();

    @Override // 
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public AbstractC0836al clone() {
        try {
            return (AbstractC0836al) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("unexpected", e);
        }
    }

    /* JADX INFO: renamed from: n */
    public final C0766r m1831n() {
        return this.f2126b;
    }

    /* JADX INFO: renamed from: o */
    public final C0833ai m1832o() {
        return this.f2125a;
    }
}
