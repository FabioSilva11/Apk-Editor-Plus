package com.p016a.p019b.p020a.p024d;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p021a.C0443p;
import com.p016a.p019b.p020a.p023c.C0489a;
import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p020a.p025e.C0514i;
import com.p016a.p019b.p020a.p025e.C0516k;
import com.p016a.p019b.p020a.p025e.InterfaceC0507b;
import com.p016a.p019b.p020a.p025e.InterfaceC0508c;
import com.p016a.p019b.p020a.p025e.InterfaceC0510e;
import com.p016a.p019b.p020a.p025e.InterfaceC0513h;
import com.p016a.p019b.p020a.p025e.InterfaceC0515j;
import com.p016a.p019b.p036f.p039c.C0776aa;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p039c.InterfaceC0778b;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.C0873c;
import jadx.core.deobf.Deobfuscator;

/* JADX INFO: renamed from: com.a.b.a.d.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0500k implements InterfaceC0508c {

    /* JADX INFO: renamed from: a */
    private final String f626a;

    /* JADX INFO: renamed from: b */
    private final C0873c f627b;

    /* JADX INFO: renamed from: c */
    private final boolean f628c;

    /* JADX INFO: renamed from: d */
    private C0776aa f629d;

    /* JADX INFO: renamed from: e */
    private int f630e;

    /* JADX INFO: renamed from: f */
    private C0802z f631f;

    /* JADX INFO: renamed from: g */
    private C0802z f632g;

    /* JADX INFO: renamed from: h */
    private InterfaceC0807e f633h;

    /* JADX INFO: renamed from: i */
    private InterfaceC0510e f634i;

    /* JADX INFO: renamed from: j */
    private InterfaceC0513h f635j;

    /* JADX INFO: renamed from: k */
    private C0516k f636k;

    /* JADX INFO: renamed from: l */
    private C0491b f637l;

    private C0500k(C0873c c0873c, String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("filePath == null");
        }
        this.f626a = str;
        this.f627b = c0873c;
        this.f628c = z;
        this.f630e = -1;
    }

    public C0500k(byte[] bArr, String str, boolean z) {
        this(new C0873c(bArr), str, z);
    }

    /* JADX INFO: renamed from: a */
    public static String m735a(Object obj) {
        return obj == null ? "(none)" : obj.toString();
    }

    /* JADX INFO: renamed from: m */
    private int m736m() {
        return this.f627b.m1963c(0);
    }

    /* JADX INFO: renamed from: n */
    private int m737n() {
        return this.f627b.m1966f(4);
    }

    /* JADX INFO: renamed from: o */
    private int m738o() {
        return this.f627b.m1966f(6);
    }

    /* JADX INFO: renamed from: p */
    private void m739p() {
        if (this.f630e == -1) {
            m741r();
        }
    }

    /* JADX INFO: renamed from: q */
    private void m740q() {
        if (this.f636k == null) {
            m741r();
        }
    }

    /* JADX INFO: renamed from: r */
    private void m741r() {
        boolean z = true;
        try {
            if (this.f627b.m1957a() < 10) {
                throw new C0514i("severely truncated class file");
            }
            if (this.f628c) {
                int iM736m = m736m();
                int iM737n = m737n();
                int iM738o = m738o();
                if (iM736m != -889275714 || iM737n < 0 || (iM738o != 51 ? iM738o >= 51 || iM738o < 45 : iM737n > 0)) {
                    z = false;
                }
                if (!z) {
                    throw new C0514i("bad class file magic (" + C0985a.m2294t(m736m()) + ") or version (" + C0985a.m2296v(m738o()) + Deobfuscator.CLASS_NAME_SEPARATOR + C0985a.m2296v(m737n()) + ")");
                }
            }
            C0489a c0489a = new C0489a(this.f627b);
            c0489a.m709a((InterfaceC0515j) null);
            this.f629d = c0489a.m710b();
            this.f629d.mo549b_();
            int iM708a = c0489a.m708a();
            int iM1966f = this.f627b.m1966f(iM708a);
            this.f631f = (C0802z) this.f629d.mo1607a(this.f627b.m1966f(iM708a + 2));
            this.f632g = (C0802z) this.f629d.mo1609b(this.f627b.m1966f(iM708a + 4));
            int iM1966f2 = this.f627b.m1966f(iM708a + 6);
            int i = iM708a + 8;
            this.f633h = m742a(i, iM1966f2);
            int i2 = (iM1966f2 << 1) + i;
            if (this.f628c) {
                String strM1686h = this.f631f.m1655i().m1686h();
                if (!this.f626a.endsWith(".class") || !this.f626a.startsWith(strM1686h) || this.f626a.length() != strM1686h.length() + 6) {
                    throw new C0514i("class name (" + strM1686h + ") does not match path (" + this.f626a + ")");
                }
            }
            this.f630e = iM1966f;
            C0502m c0502m = new C0502m(this, this.f631f, i2, this.f637l);
            c0502m.m765a((InterfaceC0515j) null);
            this.f634i = c0502m.m761a();
            C0504o c0504o = new C0504o(this, this.f631f, c0502m.m766d(), this.f637l);
            c0504o.m765a((InterfaceC0515j) null);
            this.f635j = c0504o.m770a();
            C0492c c0492c = new C0492c(this, 0, c0504o.m766d(), this.f637l);
            c0492c.m724a(null);
            this.f636k = c0492c.m725b();
            this.f636k.mo549b_();
            int iM723a = c0492c.m723a();
            if (iM723a != this.f627b.m1957a()) {
                throw new C0514i("extra bytes at end of class file, at offset " + C0985a.m2294t(iM723a));
            }
        } catch (C0514i e) {
            e.m311a("...while parsing " + this.f626a);
            throw e;
        } catch (RuntimeException e2) {
            C0514i c0514i = new C0514i(e2);
            c0514i.m311a("...while parsing " + this.f626a);
            throw c0514i;
        }
    }

    /* JADX INFO: renamed from: a */
    public final InterfaceC0807e m742a(int i, int i2) {
        if (i2 == 0) {
            return C0804b.f1974a;
        }
        if (this.f629d == null) {
            throw new IllegalStateException("pool not yet initialized");
        }
        return new C0501l(this.f627b, i, i2, this.f629d, null);
    }

    /* JADX INFO: renamed from: a */
    public final String m743a() {
        return this.f626a;
    }

    /* JADX INFO: renamed from: a */
    public final void m744a(C0491b c0491b) {
        if (c0491b == null) {
            throw new NullPointerException("attributeFactory == null");
        }
        this.f637l = c0491b;
    }

    /* JADX INFO: renamed from: b */
    public final C0873c m745b() {
        return this.f627b;
    }

    /* JADX INFO: renamed from: c */
    public final int m746c() {
        m739p();
        return m736m();
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0508c
    /* JADX INFO: renamed from: d */
    public final int mo747d() {
        m739p();
        return this.f630e;
    }

    /* JADX INFO: renamed from: e */
    public final C0802z m748e() {
        m739p();
        return this.f631f;
    }

    /* JADX INFO: renamed from: f */
    public final C0802z m749f() {
        m739p();
        return this.f632g;
    }

    /* JADX INFO: renamed from: g */
    public final InterfaceC0778b m750g() {
        m739p();
        return this.f629d;
    }

    /* JADX INFO: renamed from: h */
    public final InterfaceC0807e m751h() {
        m739p();
        return this.f633h;
    }

    /* JADX INFO: renamed from: i */
    public final InterfaceC0510e m752i() {
        m740q();
        return this.f634i;
    }

    /* JADX INFO: renamed from: j */
    public final InterfaceC0513h m753j() {
        m740q();
        return this.f635j;
    }

    /* JADX INFO: renamed from: k */
    public final InterfaceC0507b m754k() {
        m740q();
        return this.f636k;
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0508c
    /* JADX INFO: renamed from: l */
    public final C0801y mo755l() {
        AbstractC0506a abstractC0506aMo785a = m754k().mo785a("SourceFile");
        if (abstractC0506aMo785a instanceof C0443p) {
            return ((C0443p) abstractC0506aMo785a).m457b();
        }
        return null;
    }
}
