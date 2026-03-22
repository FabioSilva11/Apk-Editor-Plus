package com.gmail.heagoo.neweditor;

import java.text.CharacterIterator;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.z */
/* JADX INFO: loaded from: classes.dex */
public final class C1532z implements CharSequence, Cloneable, CharacterIterator {

    /* JADX INFO: renamed from: a */
    public char[] f4545a;

    /* JADX INFO: renamed from: b */
    public int f4546b;

    /* JADX INFO: renamed from: c */
    public int f4547c;

    /* JADX INFO: renamed from: d */
    private int f4548d;

    public C1532z() {
        this(null, 0, 0);
    }

    private C1532z(char[] cArr, int i, int i2) {
        this.f4545a = null;
        this.f4547c = 0;
        this.f4546b = 0;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        if (i < 0 || i >= this.f4546b) {
            throw new StringIndexOutOfBoundsException(i);
        }
        return this.f4545a[this.f4547c + i];
    }

    @Override // java.text.CharacterIterator
    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override // java.text.CharacterIterator
    public final char current() {
        if (this.f4546b == 0 || this.f4548d >= this.f4547c + this.f4546b) {
            return (char) 65535;
        }
        return this.f4545a[this.f4548d];
    }

    @Override // java.text.CharacterIterator
    public final char first() {
        this.f4548d = this.f4547c;
        if (this.f4546b != 0) {
            return this.f4545a[this.f4548d];
        }
        return (char) 65535;
    }

    @Override // java.text.CharacterIterator
    public final int getBeginIndex() {
        return this.f4547c;
    }

    @Override // java.text.CharacterIterator
    public final int getEndIndex() {
        return this.f4547c + this.f4546b;
    }

    @Override // java.text.CharacterIterator
    public final int getIndex() {
        return this.f4548d;
    }

    @Override // java.text.CharacterIterator
    public final char last() {
        this.f4548d = this.f4547c + this.f4546b;
        if (this.f4546b == 0) {
            return (char) 65535;
        }
        this.f4548d--;
        return this.f4545a[this.f4548d];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f4546b;
    }

    @Override // java.text.CharacterIterator
    public final char next() {
        this.f4548d++;
        int i = this.f4547c + this.f4546b;
        if (this.f4548d < i) {
            return current();
        }
        this.f4548d = i;
        return (char) 65535;
    }

    @Override // java.text.CharacterIterator
    public final char previous() {
        if (this.f4548d == this.f4547c) {
            return (char) 65535;
        }
        this.f4548d--;
        return current();
    }

    @Override // java.text.CharacterIterator
    public final char setIndex(int i) {
        int i2 = this.f4547c + this.f4546b;
        if (i < this.f4547c || i > i2) {
            throw new IllegalArgumentException("bad position: " + i);
        }
        this.f4548d = i;
        if (this.f4548d == i2 || this.f4546b == 0) {
            return (char) 65535;
        }
        return this.f4545a[this.f4548d];
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (i2 > this.f4546b) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        if (i > i2) {
            throw new StringIndexOutOfBoundsException(i2 - i);
        }
        C1532z c1532z = new C1532z();
        c1532z.f4545a = this.f4545a;
        c1532z.f4547c = this.f4547c + i;
        c1532z.f4546b = i2 - i;
        return c1532z;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f4545a != null ? new String(this.f4545a, this.f4547c, this.f4546b) : new String();
    }
}
