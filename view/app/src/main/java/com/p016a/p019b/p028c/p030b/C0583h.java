package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0774z;

/* JADX INFO: renamed from: com.a.b.c.b.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0583h extends AbstractC0576an {

    /* JADX INFO: renamed from: a */
    private final boolean f776a;

    public C0583h(C0774z c0774z) {
        this(c0774z, false);
    }

    public C0583h(C0774z c0774z, boolean z) {
        super(c0774z);
        this.f776a = z;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final AbstractC0587l mo841a(C0768t c0768t) {
        return new C0583h(m962i());
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    protected final String mo842a(boolean z) {
        return "code-address";
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: b */
    protected final String mo844b() {
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m934c() {
        return this.f776a;
    }
}
