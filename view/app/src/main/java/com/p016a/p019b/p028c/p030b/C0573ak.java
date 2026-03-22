package com.p016a.p019b.p028c.p030b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p043h.C0880j;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.b.ak */
/* JADX INFO: loaded from: classes.dex */
public final class C0573ak extends AbstractC0575am {

    /* JADX INFO: renamed from: a */
    private final C0583h f761a;

    /* JADX INFO: renamed from: b */
    private final C0880j f762b;

    /* JADX INFO: renamed from: c */
    private final C0583h[] f763c;

    /* JADX INFO: renamed from: d */
    private final boolean f764d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0573ak(C0774z c0774z, C0583h c0583h, C0880j c0880j, C0583h[] c0583hArr) {
        super(c0774z, C0768t.f1671a);
        boolean z = true;
        if (c0583h == null) {
            throw new NullPointerException("user == null");
        }
        if (c0880j == null) {
            throw new NullPointerException("cases == null");
        }
        if (c0583hArr == null) {
            throw new NullPointerException("targets == null");
        }
        int iM1985b = c0880j.m1985b();
        if (iM1985b != c0583hArr.length) {
            throw new IllegalArgumentException("cases / targets mismatch");
        }
        if (iM1985b > 65535) {
            throw new IllegalArgumentException("too many cases");
        }
        this.f761a = c0583h;
        this.f762b = c0880j;
        this.f763c = c0583hArr;
        if (c0880j.m1985b() >= 2) {
            long jM906a = m906a(c0880j);
            long jM907b = m907b(c0880j);
            if (jM906a < 0 || jM906a > (jM907b * 5) / 4) {
                z = false;
            }
        }
        this.f764d = z;
    }

    /* JADX INFO: renamed from: a */
    private static long m906a(C0880j c0880j) {
        long jM1986b = (((((long) c0880j.m1986b(c0880j.m1985b() - 1)) - ((long) c0880j.m1986b(0))) + 1) << 1) + 4;
        if (jM1986b <= 2147483647L) {
            return jM1986b;
        }
        return -1L;
    }

    /* JADX INFO: renamed from: b */
    private static long m907b(C0880j c0880j) {
        return (((long) c0880j.m1985b()) << 2) + 2;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final int mo840a() {
        return this.f764d ? (int) m906a(this.f762b) : (int) m907b(this.f762b);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final AbstractC0587l mo841a(C0768t c0768t) {
        return new C0573ak(m962i(), this.f761a, this.f762b, this.f763c);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    protected final String mo842a(boolean z) {
        int iG = this.f761a.m960g();
        StringBuffer stringBuffer = new StringBuffer(100);
        int length = this.f763c.length;
        stringBuffer.append(this.f764d ? "packed" : "sparse");
        stringBuffer.append("-switch-payload // for switch @ ");
        stringBuffer.append(C0985a.m2296v(iG));
        for (int i = 0; i < length; i++) {
            int iG2 = this.f763c[i].m960g();
            stringBuffer.append("\n  ");
            stringBuffer.append(this.f762b.m1986b(i));
            stringBuffer.append(": ");
            stringBuffer.append(C0985a.m2294t(iG2));
            stringBuffer.append(" // ");
            stringBuffer.append(C0985a.m2300z(iG2 - iG));
        }
        return stringBuffer.toString();
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final void mo843a(C0888r c0888r) {
        int iG;
        int i = 0;
        int iG2 = this.f761a.m960g();
        int iMo845a = C0590o.f805I.m976c().mo845a();
        int length = this.f763c.length;
        if (!this.f764d) {
            c0888r.m2018b(512);
            c0888r.m2018b(length);
            for (int i2 = 0; i2 < length; i2++) {
                c0888r.m2020c(this.f762b.m1986b(i2));
            }
            while (i < length) {
                c0888r.m2020c(this.f763c[i].m960g() - iG2);
                i++;
            }
            return;
        }
        int iM1986b = length == 0 ? 0 : this.f762b.m1986b(0);
        int iM1986b2 = ((length == 0 ? 0 : this.f762b.m1986b(length - 1)) - iM1986b) + 1;
        c0888r.m2018b(256);
        c0888r.m2018b(iM1986b2);
        c0888r.m2020c(iM1986b);
        for (int i3 = 0; i3 < iM1986b2; i3++) {
            if (this.f762b.m1986b(i) > iM1986b + i3) {
                iG = iMo845a;
            } else {
                iG = this.f763c[i].m960g() - iG2;
                i++;
            }
            c0888r.m2020c(iG);
        }
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: b */
    protected final String mo844b() {
        StringBuffer stringBuffer = new StringBuffer(100);
        int length = this.f763c.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append("\n    ");
            stringBuffer.append(this.f762b.m1986b(i));
            stringBuffer.append(": ");
            stringBuffer.append(this.f763c[i]);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: c */
    public final boolean m908c() {
        return this.f764d;
    }
}
