package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p037a.C0740a;
import com.p016a.p019b.p036f.p037a.C0742c;
import com.p016a.p019b.p043h.C0888r;
import jadx.core.codegen.CodeWriter;
import java.util.Iterator;

/* JADX INFO: renamed from: com.a.b.c.c.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0636d extends AbstractC0618ap {

    /* JADX INFO: renamed from: a */
    private final C0742c f1121a;

    /* JADX INFO: renamed from: b */
    private final C0602a[] f1122b;

    public C0636d(C0742c c0742c, C0650r c0650r) {
        super(4, m1132a(c0742c));
        this.f1121a = c0742c;
        this.f1122b = new C0602a[c0742c.m1449b()];
        int i = 0;
        Iterator it = c0742c.m1450d().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            this.f1122b[i2] = new C0602a((C0740a) it.next(), c0650r);
            i = i2 + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m1132a(C0742c c0742c) {
        try {
            return (c0742c.m1449b() << 2) + 4;
        } catch (NullPointerException e) {
            throw new NullPointerException("list == null");
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    protected final int mo1039a(AbstractC0618ap abstractC0618ap) {
        return this.f1121a.compareTo(((C0636d) abstractC0618ap).f1121a);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1055k;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    protected final void mo1041a(AbstractC0622at abstractC0622at, int i) {
        C0602a.m1038a(this.f1122b);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
        C0614al c0614alM1233o = c0650r.m1233o();
        int length = this.f1122b.length;
        for (int i = 0; i < length; i++) {
            this.f1122b[i] = (C0602a) c0614alM1233o.m1074b(this.f1122b[i]);
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a_ */
    protected final void mo1044a_(C0650r c0650r, C0888r c0888r) {
        boolean zM2019b = c0888r.m2019b();
        int length = this.f1122b.length;
        if (zM2019b) {
            c0888r.m2010a(0, m1085h() + " annotation set");
            c0888r.m2010a(4, "  size: " + C0985a.m2294t(length));
        }
        c0888r.m2020c(length);
        for (int i = 0; i < length; i++) {
            int iF = this.f1122b[i].m1083f();
            if (zM2019b) {
                c0888r.m2010a(4, "  entries[" + Integer.toHexString(i) + "]: " + C0985a.m2294t(iF));
                this.f1122b[i].m1043a(c0888r, CodeWriter.INDENT);
            }
            c0888r.m2020c(iF);
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: b */
    public final String mo1045b() {
        return this.f1121a.toString();
    }

    /* JADX INFO: renamed from: c */
    public final C0742c m1133c() {
        return this.f1121a;
    }

    public final int hashCode() {
        return this.f1121a.hashCode();
    }
}
