package com.p016a.p019b.p041g;

import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p041g.p042a.C0817i;
import com.p016a.p019b.p043h.C0871a;
import com.p016a.p019b.p043h.InterfaceC0881k;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.g.r */
/* JADX INFO: loaded from: classes.dex */
public final class C0862r extends C0808a {

    /* JADX INFO: renamed from: a */
    private final ArrayList f2205a;

    /* JADX INFO: renamed from: b */
    private final C0817i f2206b;

    public C0862r(C0817i c0817i, int i) {
        super(i);
        this.f2205a = new ArrayList();
        this.f2206b = c0817i;
    }

    /* JADX INFO: renamed from: a */
    private void m1920a(int i, int i2) {
        this.f2205a.ensureCapacity(i + 1);
        while (i >= this.f2205a.size()) {
            this.f2205a.add(new C0871a(i + 1));
        }
        this.f2206b.m1738a(i2, (InterfaceC0881k) this.f2205a.get(i));
    }

    /* JADX INFO: renamed from: b */
    private boolean m1921b(int i, int i2, int i3) {
        InterfaceC0881k interfaceC0881k;
        if (i2 < this.f2205a.size() && (interfaceC0881k = (InterfaceC0881k) this.f2205a.get(i2)) != null) {
            return i3 == 1 ? interfaceC0881k.mo1947b(i) : interfaceC0881k.mo1947b(i) || m1921b(i, i2 + 1, i3 + (-1));
        }
        return false;
    }

    @Override // com.p016a.p019b.p041g.C0808a
    /* JADX INFO: renamed from: a */
    public final void mo1701a(int i, int i2, int i3) {
        super.mo1701a(i, i2, i3);
        m1920a(i2, i);
        if (i3 == 2) {
            m1920a(i2 + 1, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1922a(C0766r c0766r, int i) {
        return m1921b(c0766r.m1533g(), i, c0766r.m1537k());
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1923a(C0768t c0768t, int i, int i2) {
        int iD_ = c0768t.m1977d_();
        for (int i3 = 0; i3 < iD_; i3++) {
            C0766r c0766rM1553b = c0768t.m1553b(i3);
            int iA = m1699a(c0766rM1553b.m1533g());
            if (iA == i || ((c0766rM1553b.m1537k() == 2 && iA + 1 == i) || (i2 == 2 && iA == i + 1))) {
                return true;
            }
        }
        return false;
    }
}
