package com.p016a.p019b.p020a.p021a;

import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p036f.p037a.C0742c;
import com.p016a.p019b.p043h.C0887q;

/* JADX INFO: renamed from: com.a.b.a.a.r */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0445r extends AbstractC0506a {

    /* JADX INFO: renamed from: a */
    private final C0742c f463a;

    /* JADX INFO: renamed from: b */
    private final int f464b;

    public AbstractC0445r(String str, C0742c c0742c, int i) {
        super(str);
        try {
            if (c0742c.m2002c_()) {
                throw new C0887q("annotations.isMutable()");
            }
            this.f463a = c0742c;
            this.f464b = i;
        } catch (NullPointerException e) {
            throw new NullPointerException("annotations == null");
        }
    }

    @Override // com.p016a.p019b.p020a.p025e.AbstractC0506a
    /* JADX INFO: renamed from: a */
    public final int mo443a() {
        return this.f464b + 6;
    }

    /* JADX INFO: renamed from: b */
    public final C0742c m458b() {
        return this.f463a;
    }
}
