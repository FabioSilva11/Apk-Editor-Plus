package com.p016a.p019b.p028c.p032c;

/* JADX INFO: renamed from: com.a.b.c.c.ac */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0605ac extends AbstractC0606ad {

    /* JADX INFO: renamed from: a */
    private int f1044a = -1;

    /* JADX INFO: renamed from: a */
    public final void m1049a(int i) {
        if (this.f1044a != -1) {
            throw new RuntimeException("index already set");
        }
        this.f1044a = i;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m1050h() {
        return this.f1044a >= 0;
    }

    /* JADX INFO: renamed from: i */
    public final int m1051i() {
        if (this.f1044a < 0) {
            throw new RuntimeException("index not yet set");
        }
        return this.f1044a;
    }

    /* JADX INFO: renamed from: j */
    public final String m1052j() {
        return "[" + Integer.toHexString(this.f1044a) + ']';
    }
}
