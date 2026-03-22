package com.p016a.p019b.p020a.p022b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p038b.C0761m;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p040d.C0803a;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0806d;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.a.b.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0451a implements InterfaceC0483u {

    /* JADX INFO: renamed from: a */
    private final C0803a f473a;

    /* JADX INFO: renamed from: b */
    private InterfaceC0806d[] f474b;

    /* JADX INFO: renamed from: c */
    private int f475c;

    /* JADX INFO: renamed from: d */
    private C0805c f476d;

    /* JADX INFO: renamed from: e */
    private int f477e;

    /* JADX INFO: renamed from: f */
    private AbstractC0775a f478f;

    /* JADX INFO: renamed from: g */
    private int f479g;

    /* JADX INFO: renamed from: h */
    private C0462ak f480h;

    /* JADX INFO: renamed from: i */
    private ArrayList f481i;

    /* JADX INFO: renamed from: j */
    private int f482j;

    /* JADX INFO: renamed from: k */
    private boolean f483k;

    /* JADX INFO: renamed from: l */
    private C0766r f484l;

    /* JADX INFO: renamed from: m */
    private InterfaceC0806d[] f485m;

    /* JADX INFO: renamed from: n */
    private int f486n;

    public AbstractC0451a(C0803a c0803a) {
        if (c0803a == null) {
            throw new NullPointerException("prototype == null");
        }
        this.f473a = c0803a;
        this.f474b = new InterfaceC0806d[10];
        this.f485m = new InterfaceC0806d[6];
        mo484b();
    }

    /* JADX INFO: renamed from: a */
    public static void m467a(InterfaceC0806d interfaceC0806d, InterfaceC0806d interfaceC0806d2) {
        throw new C0459ah("local variable type mismatch: attempt to set or access a value of type " + interfaceC0806d.mo657d() + " using a local variable of type " + interfaceC0806d2.mo657d() + ". This is symptomatic of .class transformation tools that ignore local variable information.");
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    public final C0803a mo468a() {
        return this.f473a;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    public final void mo469a(int i) {
        this.f477e = i;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    public final void mo470a(int i, C0805c c0805c, C0761m c0761m) {
        this.f484l = C0766r.m1520b(i, c0805c, c0761m);
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    public final void mo471a(C0462ak c0462ak) {
        if (c0462ak == null) {
            throw new NullPointerException("cases == null");
        }
        this.f480h = c0462ak;
    }

    /* JADX INFO: renamed from: a */
    protected final void m472a(C0476n c0476n) {
        if (this.f486n < 0) {
            throw new C0459ah("results never set");
        }
        if (this.f486n == 0) {
            return;
        }
        if (this.f484l != null) {
            c0476n.m621c().mo649a(m483b(false));
            return;
        }
        C0475m c0475mM622d = c0476n.m622d();
        for (int i = 0; i < this.f486n; i++) {
            if (this.f483k) {
                c0475mM622d.m609d();
            }
            c0475mM622d.m604a(this.f485m[i]);
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    public final void mo473a(C0476n c0476n, int i) {
        C0475m c0475mM622d = c0476n.m622d();
        mo484b();
        if (i > this.f474b.length) {
            this.f474b = new InterfaceC0806d[i + 10];
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            this.f474b[i2] = c0475mM622d.m610e();
        }
        this.f475c = i;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    public final void mo474a(C0476n c0476n, C0803a c0803a) {
        C0804b c0804bM1665b = c0803a.m1665b();
        int iD_ = c0804bM1665b.m1977d_();
        mo473a(c0476n, iD_);
        for (int i = 0; i < iD_; i++) {
            if (!C0985a.m2248b(c0804bM1665b.mo756a(i), this.f474b[i])) {
                throw new C0459ah("at stack depth " + ((iD_ - 1) - i) + ", expected type " + c0804bM1665b.mo756a(i).mo657d() + " but found " + this.f474b[i].mo663a().mo657d());
            }
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    public final void mo475a(C0476n c0476n, C0805c c0805c) {
        mo473a(c0476n, 1);
        if (!C0985a.m2248b(c0805c, this.f474b[0])) {
            throw new C0459ah("expected type " + c0805c.mo657d() + " but found " + this.f474b[0].mo663a().mo657d());
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    public final void mo476a(C0476n c0476n, C0805c c0805c, C0805c c0805c2) {
        mo473a(c0476n, 2);
        if (!C0985a.m2248b(c0805c, this.f474b[0])) {
            throw new C0459ah("expected type " + c0805c.mo657d() + " but found " + this.f474b[0].mo663a().mo657d());
        }
        if (!C0985a.m2248b(c0805c2, this.f474b[1])) {
            throw new C0459ah("expected type " + c0805c2.mo657d() + " but found " + this.f474b[1].mo663a().mo657d());
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    public final void mo477a(C0476n c0476n, C0805c c0805c, C0805c c0805c2, C0805c c0805c3) {
        mo473a(c0476n, 3);
        if (!C0985a.m2248b(c0805c, this.f474b[0])) {
            throw new C0459ah("expected type " + c0805c.mo657d() + " but found " + this.f474b[0].mo663a().mo657d());
        }
        if (!C0985a.m2248b(c0805c2, this.f474b[1])) {
            throw new C0459ah("expected type " + c0805c2.mo657d() + " but found " + this.f474b[1].mo663a().mo657d());
        }
        if (!C0985a.m2248b(c0805c3, this.f474b[2])) {
            throw new C0459ah("expected type " + c0805c3.mo657d() + " but found " + this.f474b[2].mo663a().mo657d());
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    public final void mo478a(AbstractC0775a abstractC0775a) {
        if (abstractC0775a == null) {
            throw new NullPointerException("cst == null");
        }
        this.f478f = abstractC0775a;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    public final void mo479a(C0805c c0805c) {
        this.f476d = c0805c;
    }

    /* JADX INFO: renamed from: a */
    protected final void m480a(InterfaceC0806d interfaceC0806d) {
        if (interfaceC0806d == null) {
            throw new NullPointerException("result == null");
        }
        this.f485m[0] = interfaceC0806d;
        this.f486n = 1;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    public final void mo481a(ArrayList arrayList) {
        this.f481i = arrayList;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    public final void mo482a(boolean z) {
        this.f483k = z;
    }

    /* JADX INFO: renamed from: b */
    protected final C0766r m483b(boolean z) {
        if (this.f484l == null) {
            return null;
        }
        if (this.f486n != 1) {
            throw new C0459ah("local target with " + (this.f486n == 0 ? "no" : "multiple") + " results");
        }
        InterfaceC0806d interfaceC0806d = this.f485m[0];
        C0805c c0805cMo663a = interfaceC0806d.mo663a();
        C0805c c0805cMo663a2 = this.f484l.mo663a();
        if (c0805cMo663a == c0805cMo663a2) {
            return z ? this.f484l.m1528a(interfaceC0806d) : this.f484l;
        }
        if (!C0985a.m2248b(c0805cMo663a2, c0805cMo663a)) {
            m467a(c0805cMo663a, c0805cMo663a2);
            return null;
        }
        if (c0805cMo663a2 == C0805c.f2023n) {
            this.f484l = this.f484l.m1528a(interfaceC0806d);
        }
        return this.f484l;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: b */
    public final void mo484b() {
        this.f475c = 0;
        this.f476d = null;
        this.f477e = 0;
        this.f478f = null;
        this.f479g = 0;
        this.f480h = null;
        this.f481i = null;
        this.f482j = -1;
        this.f483k = false;
        this.f484l = null;
        this.f486n = -1;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: b */
    public final void mo485b(int i) {
        this.f479g = i;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: b */
    public final void mo486b(C0476n c0476n, int i) {
        mo484b();
        this.f474b[0] = c0476n.m621c().mo646a(i);
        this.f475c = 1;
        this.f482j = i;
    }

    /* JADX INFO: renamed from: b */
    protected final void m487b(InterfaceC0806d interfaceC0806d) {
        if (interfaceC0806d == null) {
            throw new NullPointerException("result == null");
        }
        this.f485m[this.f486n] = interfaceC0806d;
        this.f486n++;
    }

    /* JADX INFO: renamed from: c */
    protected final int m488c() {
        return this.f475c;
    }

    /* JADX INFO: renamed from: c */
    protected final InterfaceC0806d m489c(int i) {
        if (i >= this.f475c) {
            throw new IllegalArgumentException("n >= argCount");
        }
        try {
            return this.f474b[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("n < 0");
        }
    }

    /* JADX INFO: renamed from: d */
    protected final C0805c m490d() {
        return this.f476d;
    }

    /* JADX INFO: renamed from: d */
    protected final InterfaceC0806d m491d(int i) {
        if (this.f486n <= 0) {
            throw new IllegalArgumentException("n >= resultCount");
        }
        try {
            return this.f485m[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("n < 0");
        }
    }

    /* JADX INFO: renamed from: e */
    protected final int m492e() {
        return this.f477e;
    }

    /* JADX INFO: renamed from: f */
    protected final AbstractC0775a m493f() {
        return this.f478f;
    }

    /* JADX INFO: renamed from: g */
    protected final int m494g() {
        return this.f479g;
    }

    /* JADX INFO: renamed from: h */
    protected final C0462ak m495h() {
        return this.f480h;
    }

    /* JADX INFO: renamed from: i */
    protected final ArrayList m496i() {
        return this.f481i;
    }

    /* JADX INFO: renamed from: j */
    protected final int m497j() {
        return this.f482j;
    }

    /* JADX INFO: renamed from: k */
    protected final void m498k() {
        this.f486n = 0;
    }

    /* JADX INFO: renamed from: l */
    protected final int m499l() {
        if (this.f486n < 0) {
            throw new C0459ah("results never set");
        }
        return this.f486n;
    }
}
