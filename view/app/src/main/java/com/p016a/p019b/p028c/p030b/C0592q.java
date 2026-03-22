package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.b.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0592q extends AbstractC0575am {

    /* JADX INFO: renamed from: a */
    private C0571ai[] f1017a;

    public C0592q(C0774z c0774z, C0768t c0768t) {
        super(c0774z, c0768t);
        if (c0768t.m1977d_() == 0) {
            throw new IllegalArgumentException("registers.size() == 0");
        }
        this.f1017a = null;
    }

    /* JADX INFO: renamed from: a */
    private static C0571ai m984a(C0766r c0766r, int i) {
        return AbstractC0587l.m951a(C0774z.f1897a, C0766r.m1516a(i, c0766r.mo663a()), c0766r);
    }

    /* JADX INFO: renamed from: c */
    private void m985c() {
        int iM1537k = 0;
        if (this.f1017a != null) {
            return;
        }
        C0768t c0768tJ = m963j();
        int iD_ = c0768tJ.m1977d_();
        this.f1017a = new C0571ai[iD_];
        for (int i = 0; i < iD_; i++) {
            C0766r c0766rM1553b = c0768tJ.m1553b(i);
            this.f1017a[i] = m984a(c0766rM1553b, iM1537k);
            iM1537k += c0766rM1553b.m1537k();
        }
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final int mo840a() {
        m985c();
        int iA = 0;
        for (C0571ai c0571ai : this.f1017a) {
            iA += c0571ai.mo840a();
        }
        return iA;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final AbstractC0587l mo841a(C0768t c0768t) {
        return new C0592q(m962i(), c0768t);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    protected final String mo842a(boolean z) {
        int iM1537k = 0;
        C0768t c0768tJ = m963j();
        int iD_ = c0768tJ.m1977d_();
        StringBuffer stringBuffer = new StringBuffer(100);
        for (int i = 0; i < iD_; i++) {
            C0766r c0766rM1553b = c0768tJ.m1553b(i);
            C0571ai c0571aiM984a = m984a(c0766rM1553b, iM1537k);
            if (i != 0) {
                stringBuffer.append('\n');
            }
            stringBuffer.append(c0571aiM984a.mo842a(z));
            iM1537k += c0766rM1553b.m1537k();
        }
        return stringBuffer.toString();
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final void mo843a(C0888r c0888r) {
        m985c();
        for (C0571ai c0571ai : this.f1017a) {
            c0571ai.mo843a(c0888r);
        }
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: b */
    protected final String mo844b() {
        return null;
    }
}
