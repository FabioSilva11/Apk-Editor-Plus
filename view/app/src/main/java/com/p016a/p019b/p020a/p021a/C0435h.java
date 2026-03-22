package com.p016a.p019b.p020a.p021a;

import com.p016a.p019b.p020a.p022b.C0477o;
import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p043h.C0887q;

/* JADX INFO: renamed from: com.a.b.a.a.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0435h extends AbstractC0506a {

    /* JADX INFO: renamed from: a */
    private final C0477o f460a;

    public C0435h(C0477o c0477o) {
        super("LineNumberTable");
        try {
            if (c0477o.m2002c_()) {
                throw new C0887q("lineNumbers.isMutable()");
            }
            this.f460a = c0477o;
        } catch (NullPointerException e) {
            throw new NullPointerException("lineNumbers == null");
        }
    }

    @Override // com.p016a.p019b.p020a.p025e.AbstractC0506a
    /* JADX INFO: renamed from: a */
    public final int mo443a() {
        return (this.f460a.m1977d_() * 4) + 8;
    }

    /* JADX INFO: renamed from: b */
    public final C0477o m455b() {
        return this.f460a;
    }
}
