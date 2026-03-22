package com.p016a.p019b.p033d.p034a;

/* JADX INFO: renamed from: com.a.b.d.a.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0693g extends AbstractC0692f {

    /* JADX INFO: renamed from: a */
    private final Object f1241a;

    /* JADX INFO: renamed from: b */
    private final int f1242b;

    /* JADX INFO: renamed from: c */
    private final int f1243c;

    private C0693g(EnumC0696j enumC0696j, int i, Object obj, int i2, int i3) {
        super(enumC0696j, i, 0, 0, 0, 0L);
        this.f1241a = obj;
        this.f1242b = i2;
        this.f1243c = i3;
    }

    public C0693g(EnumC0696j enumC0696j, int i, byte[] bArr) {
        this(enumC0696j, i, bArr, bArr.length, 1);
    }

    public C0693g(EnumC0696j enumC0696j, int i, int[] iArr) {
        this(enumC0696j, i, iArr, iArr.length, 4);
    }

    public C0693g(EnumC0696j enumC0696j, int i, long[] jArr) {
        this(enumC0696j, i, jArr, jArr.length, 8);
    }

    public C0693g(EnumC0696j enumC0696j, int i, short[] sArr) {
        this(enumC0696j, i, sArr, sArr.length, 2);
    }

    @Override // com.p016a.p019b.p033d.p034a.AbstractC0692f
    /* JADX INFO: renamed from: d */
    public final AbstractC0692f mo1263d(int i) {
        throw new UnsupportedOperationException("no index in instruction");
    }

    @Override // com.p016a.p019b.p033d.p034a.AbstractC0692f
    /* JADX INFO: renamed from: m */
    public final int mo1264m() {
        return 0;
    }

    /* JADX INFO: renamed from: u */
    public final short m1312u() {
        return (short) this.f1243c;
    }

    /* JADX INFO: renamed from: v */
    public final int m1313v() {
        return this.f1242b;
    }

    /* JADX INFO: renamed from: w */
    public final Object m1314w() {
        return this.f1241a;
    }
}
