package com.p016a.p019b.p033d.p034a;

import java.io.EOFException;

/* JADX INFO: renamed from: com.a.b.d.a.av */
/* JADX INFO: loaded from: classes.dex */
public final class C0682av extends AbstractC0687b implements InterfaceC0690d {

    /* JADX INFO: renamed from: a */
    private final short[] f1224a;

    public C0682av(short[] sArr) {
        if (sArr == null) {
            throw new NullPointerException("array == null");
        }
        this.f1224a = sArr;
    }

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0690d
    /* JADX INFO: renamed from: c */
    public final int mo1268c() throws EOFException {
        try {
            short s = this.f1224a[mo1286a()];
            m1287a(1);
            return s & 65535;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new EOFException();
        }
    }

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0690d
    /* JADX INFO: renamed from: d */
    public final int mo1269d() {
        return mo1268c() | (mo1268c() << 16);
    }

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0690d
    /* JADX INFO: renamed from: e */
    public final long mo1270e() {
        return ((long) mo1268c()) | (((long) mo1268c()) << 16) | (((long) mo1268c()) << 32) | (((long) mo1268c()) << 48);
    }

    /* JADX INFO: renamed from: f */
    public final boolean m1271f() {
        return mo1286a() < this.f1224a.length;
    }
}
