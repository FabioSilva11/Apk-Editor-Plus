package com.p016a.p017a;

import com.p016a.p017a.p018a.C0397a;
import com.p016a.p017a.p018a.InterfaceC0398b;

/* JADX INFO: renamed from: com.a.a.u */
/* JADX INFO: loaded from: classes.dex */
public final class C0422u implements Comparable {

    /* JADX INFO: renamed from: a */
    private final byte[] f405a;

    public C0422u(byte[] bArr) {
        this.f405a = bArr;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0422u c0422u) {
        int iMin = Math.min(this.f405a.length, c0422u.f405a.length);
        for (int i = 0; i < iMin; i++) {
            if (this.f405a[i] != c0422u.f405a[i]) {
                return (this.f405a[i] & 255) - (c0422u.f405a[i] & 255);
            }
        }
        return this.f405a.length - c0422u.f405a.length;
    }

    /* JADX INFO: renamed from: a */
    public final InterfaceC0398b m405a() {
        return new C0397a(this.f405a);
    }

    /* JADX INFO: renamed from: a */
    public final void m406a(C0416o c0416o) {
        c0416o.m382a(this.f405a);
    }

    public final String toString() {
        return Integer.toHexString(this.f405a[0] & 255) + "...(" + this.f405a.length + ")";
    }
}
