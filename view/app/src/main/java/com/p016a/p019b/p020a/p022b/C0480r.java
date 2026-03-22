package com.p016a.p019b.p020a.p022b;

import com.p016a.p019b.p036f.p038b.C0761m;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.a.b.r */
/* JADX INFO: loaded from: classes.dex */
public final class C0480r {

    /* JADX INFO: renamed from: a */
    private final int f575a;

    /* JADX INFO: renamed from: b */
    private final int f576b;

    /* JADX INFO: renamed from: c */
    private final C0801y f577c;

    /* JADX INFO: renamed from: d */
    private final C0801y f578d;

    /* JADX INFO: renamed from: e */
    private final C0801y f579e;

    /* JADX INFO: renamed from: f */
    private final int f580f;

    public C0480r(int i, int i2, C0801y c0801y, C0801y c0801y2, C0801y c0801y3, int i3) {
        if (i < 0) {
            throw new IllegalArgumentException("startPc < 0");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("length < 0");
        }
        if (c0801y == null) {
            throw new NullPointerException("name == null");
        }
        if (c0801y2 == null && c0801y3 == null) {
            throw new NullPointerException("(descriptor == null) && (signature == null)");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        this.f575a = i;
        this.f576b = i2;
        this.f577c = c0801y;
        this.f578d = c0801y2;
        this.f579e = c0801y3;
        this.f580f = i3;
    }

    /* JADX INFO: renamed from: a */
    public final C0480r m638a(C0801y c0801y) {
        return new C0480r(this.f575a, this.f576b, this.f577c, this.f578d, c0801y, this.f580f);
    }

    /* JADX INFO: renamed from: a */
    public final C0761m m639a() {
        return C0761m.m1502a(this.f577c, this.f579e);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m640a(int i, int i2) {
        return i2 == this.f580f && i >= this.f575a && i < this.f575a + this.f576b;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m641a(C0480r c0480r) {
        return this.f575a == c0480r.f575a && this.f576b == c0480r.f576b && this.f580f == c0480r.f580f && this.f577c.equals(c0480r.f577c);
    }

    /* JADX INFO: renamed from: b */
    public final C0805c m642b() {
        return C0805c.m1679a(this.f578d.m1649j());
    }
}
