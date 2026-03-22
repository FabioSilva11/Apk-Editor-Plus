package com.p016a.p019b.p035e;

import com.p016a.p017a.C0421t;
import com.p016a.p019b.p033d.C0659a;
import com.p016a.p019b.p033d.p034a.AbstractC0692f;
import com.p016a.p019b.p033d.p034a.C0683aw;

/* JADX INFO: renamed from: com.a.b.e.o */
/* JADX INFO: loaded from: classes.dex */
final class C0732o {

    /* JADX INFO: renamed from: a */
    private final C0730m f1592a;

    /* JADX INFO: renamed from: b */
    private final C0659a f1593b = new C0659a();

    /* JADX INFO: renamed from: c */
    private AbstractC0692f[] f1594c;

    /* JADX INFO: renamed from: d */
    private int f1595d;

    public C0732o(C0730m c0730m) {
        byte b2 = 0;
        this.f1592a = c0730m;
        this.f1593b.m1253a(new C0734q(this, b2));
        this.f1593b.m1255b(new C0736s(this, b2));
        this.f1593b.m1256c(new C0737t(this, b2));
        this.f1593b.m1257d(new C0733p(this, b2));
        this.f1593b.m1258e(new C0735r(this, b2));
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m1426a(boolean z, int i) {
        if (!z && i > 65535) {
            throw new C0421t("Cannot merge new index " + i + " into a non-jumbo instruction!");
        }
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ int m1428b(C0732o c0732o) {
        int i = c0732o.f1595d;
        c0732o.f1595d = i + 1;
        return i;
    }

    /* JADX INFO: renamed from: a */
    public final short[] m1430a(short[] sArr) {
        AbstractC0692f[] abstractC0692fArrM1291a = AbstractC0692f.m1291a(sArr);
        int length = abstractC0692fArrM1291a.length;
        this.f1594c = new AbstractC0692f[length];
        this.f1595d = 0;
        this.f1593b.m1254a(abstractC0692fArrM1291a);
        C0683aw c0683aw = new C0683aw(length);
        for (AbstractC0692f abstractC0692f : this.f1594c) {
            if (abstractC0692f != null) {
                abstractC0692f.m1294a(c0683aw);
            }
        }
        return c0683aw.m1281c();
    }
}
