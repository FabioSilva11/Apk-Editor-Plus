package com.p016a.p019b.p020a.p025e;

import com.p016a.p019b.p036f.p039c.C0799w;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;

/* JADX INFO: renamed from: com.a.b.a.e.n */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0519n implements InterfaceC0511f {

    /* JADX INFO: renamed from: a */
    private final C0802z f651a;

    /* JADX INFO: renamed from: b */
    private final int f652b;

    /* JADX INFO: renamed from: c */
    private final C0799w f653c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC0507b f654d;

    public AbstractC0519n(C0802z c0802z, int i, C0799w c0799w, InterfaceC0507b interfaceC0507b) {
        if (c0802z == null) {
            throw new NullPointerException("definingClass == null");
        }
        if (c0799w == null) {
            throw new NullPointerException("nat == null");
        }
        if (interfaceC0507b == null) {
            throw new NullPointerException("attributes == null");
        }
        this.f651a = c0802z;
        this.f652b = i;
        this.f653c = c0799w;
        this.f654d = interfaceC0507b;
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0511f
    /* JADX INFO: renamed from: a */
    public final C0799w mo583a() {
        return this.f653c;
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0511f
    /* JADX INFO: renamed from: b */
    public final C0801y mo584b() {
        return this.f653c.m1638a();
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0511f
    /* JADX INFO: renamed from: c */
    public final C0801y mo585c() {
        return this.f653c.m1639b();
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0511f
    /* JADX INFO: renamed from: d */
    public final int mo586d() {
        return this.f652b;
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0511f
    /* JADX INFO: renamed from: e */
    public final InterfaceC0507b mo587e() {
        return this.f654d;
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0511f
    /* JADX INFO: renamed from: f */
    public final C0802z mo588f() {
        return this.f651a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(this.f653c.mo657d());
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
