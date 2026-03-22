package com.p016a.p019b.p020a.p021a;

import com.p016a.p019b.p020a.p022b.C0479q;
import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p043h.C0887q;

/* JADX INFO: renamed from: com.a.b.a.a.s */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0446s extends AbstractC0506a {

    /* JADX INFO: renamed from: a */
    private final C0479q f465a;

    public AbstractC0446s(String str, C0479q c0479q) {
        super(str);
        try {
            if (c0479q.m2002c_()) {
                throw new C0887q("localVariables.isMutable()");
            }
            this.f465a = c0479q;
        } catch (NullPointerException e) {
            throw new NullPointerException("localVariables == null");
        }
    }

    @Override // com.p016a.p019b.p020a.p025e.AbstractC0506a
    /* JADX INFO: renamed from: a */
    public final int mo443a() {
        return (this.f465a.m1977d_() * 10) + 8;
    }

    /* JADX INFO: renamed from: b */
    public final C0479q m459b() {
        return this.f465a;
    }
}
