package com.p016a.p019b.p020a.p021a;

import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p043h.C0887q;

/* JADX INFO: renamed from: com.a.b.a.a.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0434g extends AbstractC0506a {

    /* JADX INFO: renamed from: a */
    private final C0448u f459a;

    public C0434g(C0448u c0448u) {
        super("InnerClasses");
        try {
            if (c0448u.m2002c_()) {
                throw new C0887q("innerClasses.isMutable()");
            }
            this.f459a = c0448u;
        } catch (NullPointerException e) {
            throw new NullPointerException("innerClasses == null");
        }
    }

    @Override // com.p016a.p019b.p020a.p025e.AbstractC0506a
    /* JADX INFO: renamed from: a */
    public final int mo443a() {
        return (this.f459a.m1977d_() << 3) + 8;
    }

    /* JADX INFO: renamed from: b */
    public final C0448u m454b() {
        return this.f459a;
    }
}
