package com.gmail.heagoo.neweditor;

import java.io.Serializable;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.aa */
/* JADX INFO: loaded from: classes.dex */
public final class C1499aa implements Serializable, CharSequence {

    /* JADX INFO: renamed from: a */
    private int f4413a;

    /* JADX INFO: renamed from: b */
    private int f4414b;

    /* JADX INFO: renamed from: c */
    private C1532z f4415c;

    public C1499aa(C1532z c1532z) {
        this(c1532z, 0, c1532z.f4546b);
    }

    public C1499aa(C1532z c1532z, int i, int i2) {
        this.f4414b = i;
        this.f4413a = i2;
        this.f4415c = c1532z;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f4415c.f4545a[this.f4415c.f4547c + this.f4414b + i];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f4413a;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return new C1499aa(this.f4415c, this.f4414b + i, i2 - i);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return new String(this.f4415c.f4545a, this.f4414b + this.f4415c.f4547c, this.f4413a);
    }
}
