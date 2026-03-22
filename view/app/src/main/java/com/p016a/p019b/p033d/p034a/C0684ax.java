package com.p016a.p019b.p033d.p034a;

/* JADX INFO: renamed from: com.a.b.d.a.ax */
/* JADX INFO: loaded from: classes.dex */
public final class C0684ax extends AbstractC0692f {

    /* JADX INFO: renamed from: a */
    private final int[] f1226a;

    /* JADX INFO: renamed from: b */
    private final int[] f1227b;

    public C0684ax(EnumC0696j enumC0696j, int i, int[] iArr, int[] iArr2) {
        super(enumC0696j, i, 0, 0, 0, 0L);
        if (iArr.length != iArr2.length) {
            throw new IllegalArgumentException("keys/targets length mismatch");
        }
        this.f1226a = iArr;
        this.f1227b = iArr2;
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
    public final int[] m1282u() {
        return this.f1226a;
    }

    /* JADX INFO: renamed from: v */
    public final int[] m1283v() {
        return this.f1227b;
    }
}
