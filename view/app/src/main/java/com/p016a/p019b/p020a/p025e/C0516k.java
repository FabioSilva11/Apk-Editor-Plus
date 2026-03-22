package com.p016a.p019b.p020a.p025e;

import com.p016a.p019b.p043h.C0877g;

/* JADX INFO: renamed from: com.a.b.a.e.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0516k extends C0877g implements InterfaceC0507b {
    public C0516k(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a */
    private AbstractC0506a m795a(int i) {
        return (AbstractC0506a) m1978e(i);
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0507b
    /* JADX INFO: renamed from: a */
    public final AbstractC0506a mo784a(AbstractC0506a abstractC0506a) {
        int iD_ = m1977d_();
        for (int i = 0; i < iD_; i++) {
            if (m795a(i) == abstractC0506a) {
                String strM783g = abstractC0506a.m783g();
                for (int i2 = i + 1; i2 < iD_; i2++) {
                    AbstractC0506a abstractC0506aM795a = m795a(i2);
                    if (abstractC0506aM795a.m783g().equals(strM783g)) {
                        return abstractC0506aM795a;
                    }
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0507b
    /* JADX INFO: renamed from: a */
    public final AbstractC0506a mo785a(String str) {
        int iD_ = m1977d_();
        for (int i = 0; i < iD_; i++) {
            AbstractC0506a abstractC0506aM795a = m795a(i);
            if (abstractC0506aM795a.m783g().equals(str)) {
                return abstractC0506aM795a;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final void m796a(int i, AbstractC0506a abstractC0506a) {
        m1975a(i, (Object) abstractC0506a);
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0507b
    /* JADX INFO: renamed from: b */
    public final int mo786b() {
        int iD_ = m1977d_();
        int iMo443a = 2;
        for (int i = 0; i < iD_; i++) {
            iMo443a += m795a(i).mo443a();
        }
        return iMo443a;
    }
}
