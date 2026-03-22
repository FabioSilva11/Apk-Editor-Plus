package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.b.y */
/* JADX INFO: loaded from: classes.dex */
public final class C0600y extends AbstractC0575am {
    public C0600y(C0774z c0774z) {
        super(c0774z, C0768t.f1671a);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final int mo840a() {
        return m960g() & 1;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final AbstractC0587l mo841a(C0768t c0768t) {
        return new C0600y(m962i());
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    protected final String mo842a(boolean z) {
        if ((m960g() & 1) == 0) {
            return null;
        }
        return "nop // spacer";
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final void mo843a(C0888r c0888r) {
        if ((m960g() & 1) != 0) {
            c0888r.m2018b(AbstractC0593r.m989a(0, 0));
        }
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: b */
    protected final String mo844b() {
        return null;
    }
}
