package com.p016a.p019b.p036f.p038b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.C0801y;

/* JADX INFO: renamed from: com.a.b.f.b.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0774z {

    /* JADX INFO: renamed from: a */
    public static final C0774z f1897a = new C0774z(null, -1, -1);

    /* JADX INFO: renamed from: b */
    private final C0801y f1898b;

    /* JADX INFO: renamed from: c */
    private final int f1899c;

    /* JADX INFO: renamed from: d */
    private final int f1900d;

    public C0774z(C0801y c0801y, int i, int i2) {
        if (i < -1) {
            throw new IllegalArgumentException("address < -1");
        }
        if (i2 < -1) {
            throw new IllegalArgumentException("line < -1");
        }
        this.f1898b = c0801y;
        this.f1899c = i;
        this.f1900d = i2;
    }

    /* JADX INFO: renamed from: a */
    public final int m1599a() {
        return this.f1900d;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1600a(C0774z c0774z) {
        return this.f1900d == c0774z.f1900d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0774z)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C0774z c0774z = (C0774z) obj;
        if (this.f1899c == c0774z.f1899c) {
            return this.f1900d == c0774z.f1900d && (this.f1898b == c0774z.f1898b || (this.f1898b != null && this.f1898b.equals(c0774z.f1898b)));
        }
        return false;
    }

    public final int hashCode() {
        return this.f1898b.hashCode() + this.f1899c + this.f1900d;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        if (this.f1898b != null) {
            stringBuffer.append(this.f1898b.mo657d());
            stringBuffer.append(":");
        }
        if (this.f1900d >= 0) {
            stringBuffer.append(this.f1900d);
        }
        stringBuffer.append('@');
        if (this.f1899c < 0) {
            stringBuffer.append("????");
        } else {
            stringBuffer.append(C0985a.m2296v(this.f1899c));
        }
        return stringBuffer.toString();
    }
}
