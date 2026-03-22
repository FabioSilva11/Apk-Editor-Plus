package com.p016a.p019b.p020a.p021a;

import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p036f.p039c.C0801y;

/* JADX INFO: renamed from: com.a.b.a.a.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0442o extends AbstractC0506a {

    /* JADX INFO: renamed from: a */
    private final C0801y f461a;

    public C0442o(C0801y c0801y) {
        super("Signature");
        if (c0801y == null) {
            throw new NullPointerException("signature == null");
        }
        this.f461a = c0801y;
    }

    @Override // com.p016a.p019b.p020a.p025e.AbstractC0506a
    /* JADX INFO: renamed from: a */
    public final int mo443a() {
        return 8;
    }

    /* JADX INFO: renamed from: b */
    public final C0801y m456b() {
        return this.f461a;
    }
}
