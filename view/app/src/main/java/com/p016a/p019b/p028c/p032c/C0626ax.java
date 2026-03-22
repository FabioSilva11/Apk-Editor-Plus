package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.c.ax */
/* JADX INFO: loaded from: classes.dex */
public final class C0626ax extends AbstractC0605ac implements Comparable {

    /* JADX INFO: renamed from: a */
    private final C0801y f1111a;

    /* JADX INFO: renamed from: b */
    private C0625aw f1112b;

    public C0626ax(C0801y c0801y) {
        if (c0801y == null) {
            throw new NullPointerException("value == null");
        }
        this.f1111a = c0801y;
        this.f1112b = null;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1046b;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
        if (this.f1112b == null) {
            C0614al c0614alM1222d = c0650r.m1222d();
            this.f1112b = new C0625aw(this.f1111a);
            c0614alM1222d.m1071a((AbstractC0618ap) this.f1112b);
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1053a(C0650r c0650r, C0888r c0888r) {
        String str;
        int iF = this.f1112b.m1083f();
        if (c0888r.m2019b()) {
            StringBuilder sbAppend = new StringBuilder().append(m1052j()).append(' ');
            String strMo657d = this.f1111a.mo657d();
            if (strMo657d.length() <= 98) {
                str = "";
            } else {
                strMo657d = strMo657d.substring(0, 95);
                str = "...";
            }
            c0888r.m2010a(0, sbAppend.append("\"" + strMo657d + str + '\"').toString());
            c0888r.m2010a(4, "  string_data_off: " + C0985a.m2294t(iF));
        }
        c0888r.m2020c(iF);
    }

    /* JADX INFO: renamed from: c */
    public final C0801y m1111c() {
        return this.f1111a;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f1111a.compareTo(((C0626ax) obj).f1111a);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: e_ */
    public final int mo1054e_() {
        return 4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0626ax) {
            return this.f1111a.equals(((C0626ax) obj).f1111a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1111a.hashCode();
    }
}
