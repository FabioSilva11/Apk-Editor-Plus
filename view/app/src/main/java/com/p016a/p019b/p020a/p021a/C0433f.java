package com.p016a.p019b.p020a.p021a;

import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.C0887q;

/* JADX INFO: renamed from: com.a.b.a.a.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0433f extends AbstractC0506a {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0807e f458a;

    public C0433f(InterfaceC0807e interfaceC0807e) {
        super("Exceptions");
        try {
            if (interfaceC0807e.mo758c_()) {
                throw new C0887q("exceptions.isMutable()");
            }
            this.f458a = interfaceC0807e;
        } catch (NullPointerException e) {
            throw new NullPointerException("exceptions == null");
        }
    }

    @Override // com.p016a.p019b.p020a.p025e.AbstractC0506a
    /* JADX INFO: renamed from: a */
    public final int mo443a() {
        return (this.f458a.mo759d_() << 1) + 8;
    }

    /* JADX INFO: renamed from: b */
    public final InterfaceC0807e m453b() {
        return this.f458a;
    }
}
