package com.gmail.heagoo.neweditor;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.ag */
/* JADX INFO: loaded from: classes.dex */
public final class C1505ag {

    /* JADX INFO: renamed from: f */
    private static final Map f4430f = new HashMap();

    /* JADX INFO: renamed from: a */
    public C1505ag f4431a;

    /* JADX INFO: renamed from: b */
    public C1529w f4432b;

    /* JADX INFO: renamed from: c */
    public C1530x f4433c;

    /* JADX INFO: renamed from: d */
    public char[] f4434d;

    /* JADX INFO: renamed from: e */
    public C1529w f4435e;

    public C1505ag() {
    }

    public C1505ag(C1530x c1530x, C1505ag c1505ag) {
        this.f4433c = c1530x;
        this.f4431a = c1505ag == null ? null : (C1505ag) c1505ag.clone();
        if (c1530x.m3671a() != null) {
            this.f4435e = this.f4433c.m3691i();
        } else {
            this.f4435e = c1505ag.f4435e;
        }
    }

    /* JADX INFO: renamed from: a */
    public final C1505ag m3620a() {
        C1505ag c1505ag = (C1505ag) f4430f.get(this);
        if (c1505ag != null) {
            return c1505ag;
        }
        f4430f.put(this, this);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final void m3621a(C1529w c1529w) {
        this.f4432b = c1529w;
        if (c1529w != null && c1529w.f4521e != null) {
            this.f4435e = c1529w.f4521e;
            return;
        }
        if (this.f4433c != null && this.f4433c.m3671a() != null) {
            this.f4435e = this.f4433c.m3691i();
        } else if (this.f4431a != null) {
            this.f4435e = this.f4431a.f4435e;
        } else {
            this.f4435e = null;
        }
    }

    public final Object clone() {
        C1505ag c1505ag = new C1505ag();
        c1505ag.f4432b = this.f4432b;
        c1505ag.f4433c = this.f4433c;
        c1505ag.f4431a = this.f4431a == null ? null : (C1505ag) this.f4431a.clone();
        c1505ag.f4434d = this.f4434d;
        c1505ag.f4435e = this.f4435e;
        return c1505ag;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof C1505ag)) {
            return false;
        }
        C1505ag c1505ag = (C1505ag) obj;
        if (c1505ag.f4432b != this.f4432b || c1505ag.f4433c != this.f4433c || !C1500ab.m3607a(this.f4431a, c1505ag.f4431a)) {
            return false;
        }
        char[] cArr = this.f4434d;
        char[] cArr2 = c1505ag.f4434d;
        if (cArr == null) {
            z = cArr2 == null;
        } else if (cArr2 != null && cArr.length == cArr2.length) {
            int i = 0;
            while (true) {
                if (i >= cArr.length) {
                    z = true;
                    break;
                }
                if (cArr[i] != cArr2[i]) {
                    z = false;
                    break;
                }
                i++;
            }
        } else {
            z = false;
        }
        return z;
    }

    public final int hashCode() {
        if (this.f4432b != null) {
            return this.f4432b.hashCode();
        }
        if (this.f4433c != null) {
            return this.f4433c.hashCode();
        }
        return 0;
    }
}
