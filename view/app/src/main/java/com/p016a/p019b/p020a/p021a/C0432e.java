package com.p016a.p019b.p020a.p021a;

import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p036f.p039c.C0799w;
import com.p016a.p019b.p036f.p039c.C0802z;

/* JADX INFO: renamed from: com.a.b.a.a.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0432e extends AbstractC0506a {

    /* JADX INFO: renamed from: a */
    private final C0802z f456a;

    /* JADX INFO: renamed from: b */
    private final C0799w f457b;

    public C0432e(C0802z c0802z, C0799w c0799w) {
        super("EnclosingMethod");
        if (c0802z == null) {
            throw new NullPointerException("type == null");
        }
        this.f456a = c0802z;
        this.f457b = c0799w;
    }

    @Override // com.p016a.p019b.p020a.p025e.AbstractC0506a
    /* JADX INFO: renamed from: a */
    public final int mo443a() {
        return 10;
    }

    /* JADX INFO: renamed from: b */
    public final C0802z m451b() {
        return this.f456a;
    }

    /* JADX INFO: renamed from: c */
    public final C0799w m452c() {
        return this.f457b;
    }
}
