package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.InterfaceC0889s;

/* JADX INFO: renamed from: com.a.b.f.b.i */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0757i implements InterfaceC0889s {

    /* JADX INFO: renamed from: a */
    private final C0771w f1649a;

    /* JADX INFO: renamed from: b */
    private final C0774z f1650b;

    /* JADX INFO: renamed from: c */
    private final C0766r f1651c;

    /* JADX INFO: renamed from: d */
    private final C0768t f1652d;

    public AbstractC0757i(C0771w c0771w, C0774z c0774z, C0766r c0766r, C0768t c0768t) {
        if (c0771w == null) {
            throw new NullPointerException("opcode == null");
        }
        if (c0774z == null) {
            throw new NullPointerException("position == null");
        }
        if (c0768t == null) {
            throw new NullPointerException("sources == null");
        }
        this.f1649a = c0771w;
        this.f1650b = c0774z;
        this.f1651c = c0766r;
        this.f1652d = c0768t;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1489a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: renamed from: a */
    public abstract AbstractC0757i mo1465a(C0766r c0766r, C0768t c0768t);

    /* JADX INFO: renamed from: a */
    public abstract AbstractC0757i mo1466a(C0805c c0805c);

    /* JADX INFO: renamed from: a */
    public String mo1467a() {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo1468a(InterfaceC0759k interfaceC0759k);

    /* JADX INFO: renamed from: a */
    public boolean mo1469a(AbstractC0757i abstractC0757i) {
        return this.f1649a == abstractC0757i.f1649a && this.f1650b.equals(abstractC0757i.f1650b) && getClass() == abstractC0757i.getClass() && m1489a(this.f1651c, abstractC0757i.f1651c) && m1489a(this.f1652d, abstractC0757i.f1652d) && C0804b.m1671a(mo1470b(), abstractC0757i.mo1470b());
    }

    /* JADX INFO: renamed from: b */
    public abstract InterfaceC0807e mo1470b();

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        String strMo1467a = mo1467a();
        StringBuffer stringBuffer = new StringBuffer(80);
        stringBuffer.append(this.f1650b);
        stringBuffer.append(": ");
        stringBuffer.append(this.f1649a.m1580g());
        if (strMo1467a != null) {
            stringBuffer.append("(");
            stringBuffer.append(strMo1467a);
            stringBuffer.append(")");
        }
        if (this.f1651c == null) {
            stringBuffer.append(" .");
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(this.f1651c.mo657d());
        }
        stringBuffer.append(" <-");
        int iD_ = this.f1652d.m1977d_();
        if (iD_ == 0) {
            stringBuffer.append(" .");
        } else {
            for (int i = 0; i < iD_; i++) {
                stringBuffer.append(" ");
                stringBuffer.append(this.f1652d.m1553b(i).mo657d());
            }
        }
        return stringBuffer.toString();
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    /* JADX INFO: renamed from: f */
    public final C0771w m1490f() {
        return this.f1649a;
    }

    /* JADX INFO: renamed from: g */
    public final C0774z m1491g() {
        return this.f1650b;
    }

    /* JADX INFO: renamed from: h */
    public final C0766r m1492h() {
        return this.f1651c;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    /* JADX INFO: renamed from: i */
    public final C0766r m1493i() {
        C0766r c0766rM1553b = this.f1649a.m1574a() == 54 ? this.f1652d.m1553b(0) : this.f1651c;
        if (c0766rM1553b == null || c0766rM1553b.m1535i() == null) {
            return null;
        }
        return c0766rM1553b;
    }

    /* JADX INFO: renamed from: j */
    public final C0768t m1494j() {
        return this.f1652d;
    }

    /* JADX INFO: renamed from: k */
    public final boolean m1495k() {
        return this.f1649a.m1581h();
    }

    /* JADX INFO: renamed from: l */
    public AbstractC0757i mo1496l() {
        return this;
    }

    public String toString() {
        String strMo1467a = mo1467a();
        StringBuffer stringBuffer = new StringBuffer(80);
        stringBuffer.append("Insn{");
        stringBuffer.append(this.f1650b);
        stringBuffer.append(' ');
        stringBuffer.append(this.f1649a);
        if (strMo1467a != null) {
            stringBuffer.append(' ');
            stringBuffer.append(strMo1467a);
        }
        stringBuffer.append(" :: ");
        if (this.f1651c != null) {
            stringBuffer.append(this.f1651c);
            stringBuffer.append(" <- ");
        }
        stringBuffer.append(this.f1652d);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
