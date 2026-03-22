package com.p016a.p019b.p033d.p034a;

/* JADX INFO: renamed from: com.a.b.d.a.aw */
/* JADX INFO: loaded from: classes.dex */
public final class C0683aw extends AbstractC0687b implements InterfaceC0691e {

    /* JADX INFO: renamed from: a */
    private final short[] f1225a;

    public C0683aw(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("maxSize < 0");
        }
        this.f1225a = new short[i];
    }

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0691e
    /* JADX INFO: renamed from: a */
    public final void mo1272a(short s) {
        this.f1225a[mo1286a()] = s;
        m1287a(1);
    }

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0691e
    /* JADX INFO: renamed from: a */
    public final void mo1273a(short s, short s2) {
        mo1272a(s);
        mo1272a(s2);
    }

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0691e
    /* JADX INFO: renamed from: a */
    public final void mo1274a(short s, short s2, short s3) {
        mo1272a(s);
        mo1272a(s2);
        mo1272a(s3);
    }

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0691e
    /* JADX INFO: renamed from: a */
    public final void mo1275a(short s, short s2, short s3, short s4, short s5) {
        mo1272a(s);
        mo1272a(s2);
        mo1272a(s3);
        mo1272a(s4);
        mo1272a(s5);
    }

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0691e
    /* JADX INFO: renamed from: a */
    public final void mo1276a(byte[] bArr) {
        boolean z = true;
        int i = 0;
        for (byte b2 : bArr) {
            if (z) {
                i = b2 & 255;
                z = false;
            } else {
                int i2 = (b2 << 8) | i;
                mo1272a((short) i2);
                i = i2;
                z = true;
            }
        }
        if (z) {
            return;
        }
        mo1272a((short) i);
    }

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0691e
    /* JADX INFO: renamed from: a */
    public final void mo1277a(int[] iArr) {
        for (int i : iArr) {
            mo1280a_(i);
        }
    }

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0691e
    /* JADX INFO: renamed from: a */
    public final void mo1278a(long[] jArr) {
        for (long j : jArr) {
            mo1272a((short) j);
            mo1272a((short) (r2 >> 16));
            mo1272a((short) (r2 >> 32));
            mo1272a((short) (r2 >> 48));
        }
    }

    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0691e
    /* JADX INFO: renamed from: a */
    public final void mo1279a(short[] sArr) {
        for (short s : sArr) {
            mo1272a(s);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int, short] */
    @Override // com.p016a.p019b.p033d.p034a.InterfaceC0691e
    /* JADX INFO: renamed from: a_ */
    public final void mo1280a_(int i) {
        mo1272a((short) i);
        mo1272a((short) (i >> 16));
    }

    /* JADX INFO: renamed from: c */
    public final short[] m1281c() {
        int iA = mo1286a();
        if (iA == this.f1225a.length) {
            return this.f1225a;
        }
        short[] sArr = new short[iA];
        System.arraycopy(this.f1225a, 0, sArr, 0, iA);
        return sArr;
    }
}
