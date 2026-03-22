package com.p016a.p019b.p020a.p021a;

import com.p016a.p019b.p020a.p022b.C0467e;
import com.p016a.p019b.p020a.p022b.C0470h;
import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p020a.p025e.InterfaceC0507b;
import com.p016a.p019b.p043h.C0887q;

/* JADX INFO: renamed from: com.a.b.a.a.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0429b extends AbstractC0506a {

    /* JADX INFO: renamed from: a */
    private final int f450a;

    /* JADX INFO: renamed from: b */
    private final int f451b;

    /* JADX INFO: renamed from: c */
    private final C0470h f452c;

    /* JADX INFO: renamed from: d */
    private final C0467e f453d;

    /* JADX INFO: renamed from: e */
    private final InterfaceC0507b f454e;

    public C0429b(int i, int i2, C0470h c0470h, C0467e c0467e, InterfaceC0507b interfaceC0507b) {
        super("Code");
        if (i < 0) {
            throw new IllegalArgumentException("maxStack < 0");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("maxLocals < 0");
        }
        try {
            if (c0467e.m2002c_()) {
                throw new C0887q("catches.isMutable()");
            }
            try {
                if (interfaceC0507b.m787c_()) {
                    throw new C0887q("attributes.isMutable()");
                }
                this.f450a = i;
                this.f451b = i2;
                this.f452c = c0470h;
                this.f453d = c0467e;
                this.f454e = interfaceC0507b;
            } catch (NullPointerException e) {
                throw new NullPointerException("attributes == null");
            }
        } catch (NullPointerException e2) {
            throw new NullPointerException("catches == null");
        }
    }

    @Override // com.p016a.p019b.p020a.p025e.AbstractC0506a
    /* JADX INFO: renamed from: a */
    public final int mo443a() {
        return this.f452c.m581c() + 10 + (this.f453d.m1977d_() << 3) + 2 + this.f454e.mo786b();
    }

    /* JADX INFO: renamed from: b */
    public final int m445b() {
        return this.f450a;
    }

    /* JADX INFO: renamed from: c */
    public final int m446c() {
        return this.f451b;
    }

    /* JADX INFO: renamed from: d */
    public final C0470h m447d() {
        return this.f452c;
    }

    /* JADX INFO: renamed from: e */
    public final C0467e m448e() {
        return this.f453d;
    }

    /* JADX INFO: renamed from: f */
    public final InterfaceC0507b m449f() {
        return this.f454e;
    }
}
