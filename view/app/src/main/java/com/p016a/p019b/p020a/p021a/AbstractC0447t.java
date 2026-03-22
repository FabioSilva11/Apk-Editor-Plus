package com.p016a.p019b.p020a.p021a;

import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p036f.p037a.C0743d;
import com.p016a.p019b.p043h.C0887q;

/* JADX INFO: renamed from: com.a.b.a.a.t */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0447t extends AbstractC0506a {

    /* JADX INFO: renamed from: a */
    private final C0743d f466a;

    /* JADX INFO: renamed from: b */
    private final int f467b;

    public AbstractC0447t(String str, C0743d c0743d, int i) {
        super(str);
        try {
            if (c0743d.m2002c_()) {
                throw new C0887q("parameterAnnotations.isMutable()");
            }
            this.f466a = c0743d;
            this.f467b = i;
        } catch (NullPointerException e) {
            throw new NullPointerException("parameterAnnotations == null");
        }
    }

    @Override // com.p016a.p019b.p020a.p025e.AbstractC0506a
    /* JADX INFO: renamed from: a */
    public final int mo443a() {
        return this.f467b + 6;
    }

    /* JADX INFO: renamed from: b */
    public final C0743d m460b() {
        return this.f466a;
    }
}
