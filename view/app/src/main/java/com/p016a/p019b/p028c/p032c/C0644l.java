package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.p018a.C0400d;
import com.p016a.p019b.p028c.p030b.C0585j;
import com.p016a.p019b.p028c.p030b.C0588m;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.C0888r;
import jadx.core.codegen.CodeWriter;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: renamed from: com.a.b.c.c.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0644l extends AbstractC0618ap {

    /* JADX INFO: renamed from: a */
    private final C0798v f1161a;

    /* JADX INFO: renamed from: b */
    private final C0585j f1162b;

    /* JADX INFO: renamed from: c */
    private C0640h f1163c;

    /* JADX INFO: renamed from: d */
    private final boolean f1164d;

    /* JADX INFO: renamed from: e */
    private final InterfaceC0807e f1165e;

    /* JADX INFO: renamed from: f */
    private C0649q f1166f;

    public C0644l(C0798v c0798v, C0585j c0585j, boolean z, InterfaceC0807e interfaceC0807e) {
        super(4, -1);
        if (c0798v == null) {
            throw new NullPointerException("ref == null");
        }
        if (c0585j == null) {
            throw new NullPointerException("code == null");
        }
        if (interfaceC0807e == null) {
            throw new NullPointerException("throwsList == null");
        }
        this.f1161a = c0798v;
        this.f1162b = c0585j;
        this.f1164d = z;
        this.f1165e = interfaceC0807e;
        this.f1163c = null;
        this.f1166f = null;
    }

    /* JADX INFO: renamed from: c */
    private int m1188c() {
        return this.f1161a.m1617b(this.f1164d);
    }

    /* JADX INFO: renamed from: d */
    private int m1189d() {
        return this.f1162b.m947f().m973g();
    }

    /* JADX INFO: renamed from: e */
    private int m1190e() {
        return this.f1162b.m947f().m972f();
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1057m;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    protected final void mo1041a(AbstractC0622at abstractC0622at, int i) {
        int iM1158b;
        C0650r c0650rM1099e = abstractC0622at.m1099e();
        this.f1162b.m941a(new C0645m(this, c0650rM1099e));
        if (this.f1163c != null) {
            this.f1163c.m1155a(c0650rM1099e);
            iM1158b = this.f1163c.m1158b();
        } else {
            iM1158b = 0;
        }
        int iM971e = this.f1162b.m947f().m971e();
        if ((iM971e & 1) != 0) {
            iM971e++;
        }
        m1080a(iM1158b + (iM971e << 1) + 16);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
        C0614al c0614alM1233o = c0650r.m1233o();
        C0630ba c0630baM1229k = c0650r.m1229k();
        if (this.f1162b.m942a() || this.f1162b.m943b()) {
            this.f1166f = new C0649q(this.f1162b, this.f1164d, this.f1161a);
            c0614alM1233o.m1071a((AbstractC0618ap) this.f1166f);
        }
        if (this.f1162b.m944c()) {
            Iterator it = this.f1162b.m945d().iterator();
            while (it.hasNext()) {
                c0630baM1229k.m1118a((C0805c) it.next());
            }
            this.f1163c = new C0640h(this.f1162b);
        }
        Iterator it2 = this.f1162b.m946e().iterator();
        while (it2.hasNext()) {
            c0650r.m1216a((AbstractC0775a) it2.next());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1191a(PrintWriter printWriter, String str, boolean z) {
        printWriter.println(this.f1161a.mo657d() + ":");
        C0588m c0588mM947f = this.f1162b.m947f();
        printWriter.println("regs: " + C0985a.m2296v(m1190e()) + "; ins: " + C0985a.m2296v(m1188c()) + "; outs: " + C0985a.m2296v(m1189d()));
        c0588mM947f.m970a(printWriter, str, z);
        String str2 = str + "  ";
        if (this.f1163c != null) {
            printWriter.print(str);
            printWriter.println("catches");
            this.f1163c.m1157a(printWriter, str2);
        }
        if (this.f1166f != null) {
            printWriter.print(str);
            printWriter.println("debug info");
            this.f1166f.m1211a(printWriter, str2);
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a_ */
    protected final void mo1044a_(C0650r c0650r, C0888r c0888r) {
        boolean zM2019b = c0888r.m2019b();
        int iM1190e = m1190e();
        int iM1189d = m1189d();
        int iM1188c = m1188c();
        int iM971e = this.f1162b.m947f().m971e();
        boolean z = (iM971e & 1) != 0;
        int iM1154a = this.f1163c == null ? 0 : this.f1163c.m1154a();
        int iF = this.f1166f == null ? 0 : this.f1166f.m1083f();
        if (zM2019b) {
            c0888r.m2010a(0, m1085h() + ' ' + this.f1161a.mo657d());
            c0888r.m2010a(2, "  registers_size: " + C0985a.m2296v(iM1190e));
            c0888r.m2010a(2, "  ins_size:       " + C0985a.m2296v(iM1188c));
            c0888r.m2010a(2, "  outs_size:      " + C0985a.m2296v(iM1189d));
            c0888r.m2010a(2, "  tries_size:     " + C0985a.m2296v(iM1154a));
            c0888r.m2010a(4, "  debug_off:      " + C0985a.m2294t(iF));
            c0888r.m2010a(4, "  insns_size:     " + C0985a.m2294t(iM971e));
            if (this.f1165e.mo759d_() != 0) {
                c0888r.m2010a(0, "  throws " + C0804b.m1670a(this.f1165e));
            }
        }
        c0888r.m2018b(iM1190e);
        c0888r.m2018b(iM1188c);
        c0888r.m2018b(iM1189d);
        c0888r.m2018b(iM1154a);
        c0888r.m2020c(iF);
        c0888r.m2020c(iM971e);
        try {
            this.f1162b.m947f().m969a(c0888r);
            if (this.f1163c != null) {
                if (z) {
                    if (zM2019b) {
                        c0888r.m2010a(2, "  padding: 0");
                    }
                    c0888r.m2018b(0);
                }
                this.f1163c.m1156a(c0888r);
            }
            if (!zM2019b || this.f1166f == null) {
                return;
            }
            c0888r.m2010a(0, "  debug info");
            this.f1166f.m1210a(c0650r, c0888r, CodeWriter.INDENT);
        } catch (RuntimeException e) {
            throw C0400d.m308a(e, "...while writing instructions for " + this.f1161a.mo657d());
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: b */
    public final String mo1045b() {
        return this.f1161a.mo657d();
    }

    public final String toString() {
        return "CodeItem{" + mo1045b() + "}";
    }
}
