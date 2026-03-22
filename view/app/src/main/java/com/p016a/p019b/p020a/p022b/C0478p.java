package com.p016a.p019b.p020a.p022b;

/* JADX INFO: renamed from: com.a.b.a.b.p */
/* JADX INFO: loaded from: classes.dex */
public final class C0478p {

    /* JADX INFO: renamed from: a */
    private final int f572a;

    /* JADX INFO: renamed from: b */
    private final int f573b;

    public C0478p(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("startPc < 0");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("lineNumber < 0");
        }
        this.f572a = i;
        this.f573b = i2;
    }

    /* JADX INFO: renamed from: a */
    public final int m629a() {
        return this.f572a;
    }

    /* JADX INFO: renamed from: b */
    public final int m630b() {
        return this.f573b;
    }
}
