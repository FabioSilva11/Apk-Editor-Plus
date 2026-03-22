package com.p016a.p019b.p028c.p032c;

import com.p016a.p019b.p043h.C0888r;
import java.util.Collection;

/* JADX INFO: renamed from: com.a.b.c.c.at */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0622at {

    /* JADX INFO: renamed from: a */
    private final String f1099a;

    /* JADX INFO: renamed from: b */
    private final C0650r f1100b;

    /* JADX INFO: renamed from: c */
    private final int f1101c;

    /* JADX INFO: renamed from: d */
    private int f1102d;

    /* JADX INFO: renamed from: e */
    private boolean f1103e;

    public AbstractC0622at(String str, C0650r c0650r, int i) {
        if (c0650r == null) {
            throw new NullPointerException("file == null");
        }
        m1095a(i);
        this.f1099a = str;
        this.f1100b = c0650r;
        this.f1101c = i;
        this.f1102d = -1;
        this.f1103e = false;
    }

    /* JADX INFO: renamed from: a */
    public static void m1095a(int i) {
        if (i <= 0 || ((i - 1) & i) != 0) {
            throw new IllegalArgumentException("invalid alignment");
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract int mo1070a(AbstractC0606ad abstractC0606ad);

    /* JADX INFO: renamed from: a */
    public abstract Collection mo1046a();

    /* JADX INFO: renamed from: a_ */
    protected abstract void mo1073a_(C0888r c0888r);

    /* JADX INFO: renamed from: b */
    public final int m1096b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("fileOffset < 0");
        }
        if (this.f1102d >= 0) {
            throw new RuntimeException("fileOffset already set");
        }
        int i2 = this.f1101c - 1;
        int i3 = (i2 ^ (-1)) & (i + i2);
        this.f1102d = i3;
        return i3;
    }

    /* JADX INFO: renamed from: c */
    public final int m1097c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("relative < 0");
        }
        if (this.f1102d < 0) {
            throw new RuntimeException("fileOffset not yet set");
        }
        return this.f1102d + i;
    }

    /* JADX INFO: renamed from: c */
    protected abstract void mo1075c();

    /* JADX INFO: renamed from: c */
    public final void m1098c(C0888r c0888r) {
        m1103i();
        c0888r.m2027g(this.f1101c);
        int iM2008a = c0888r.m2008a();
        if (this.f1102d < 0) {
            this.f1102d = iM2008a;
        } else if (this.f1102d != iM2008a) {
            throw new RuntimeException("alignment mismatch: for " + this + ", at " + iM2008a + ", but expected " + this.f1102d);
        }
        if (c0888r.m2019b()) {
            if (this.f1099a != null) {
                c0888r.m2010a(0, "\n" + this.f1099a + ":");
            } else if (iM2008a != 0) {
                c0888r.m2010a(0, "\n");
            }
        }
        mo1073a_(c0888r);
    }

    /* JADX INFO: renamed from: e */
    public final C0650r m1099e() {
        return this.f1100b;
    }

    /* JADX INFO: renamed from: f */
    public final int m1100f() {
        return this.f1101c;
    }

    /* JADX INFO: renamed from: f_ */
    public abstract int mo1077f_();

    /* JADX INFO: renamed from: g */
    public final int m1101g() {
        if (this.f1102d < 0) {
            throw new RuntimeException("fileOffset not set");
        }
        return this.f1102d;
    }

    /* JADX INFO: renamed from: h */
    public final void m1102h() {
        m1104j();
        mo1075c();
        this.f1103e = true;
    }

    /* JADX INFO: renamed from: i */
    protected final void m1103i() {
        if (!this.f1103e) {
            throw new RuntimeException("not prepared");
        }
    }

    /* JADX INFO: renamed from: j */
    protected final void m1104j() {
        if (this.f1103e) {
            throw new RuntimeException("already prepared");
        }
    }
}
