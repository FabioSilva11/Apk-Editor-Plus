package com.p016a.p019b.p043h;

import android.support.v7.widget.ActivityChooserView;

/* JADX INFO: renamed from: com.a.b.h.f */
/* JADX INFO: loaded from: classes.dex */
final class C0876f {

    /* JADX INFO: renamed from: a */
    private final int f2235a;

    /* JADX INFO: renamed from: b */
    private int f2236b;

    /* JADX INFO: renamed from: c */
    private final String f2237c;

    public C0876f(int i, int i2, String str) {
        this.f2235a = i;
        this.f2236b = i2;
        this.f2237c = str;
    }

    public C0876f(int i, String str) {
        this(i, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, str);
    }

    /* JADX INFO: renamed from: a */
    public final int m1967a() {
        return this.f2235a;
    }

    /* JADX INFO: renamed from: a */
    public final void m1968a(int i) {
        if (this.f2236b == Integer.MAX_VALUE) {
            this.f2236b = i;
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m1969b() {
        return this.f2236b;
    }

    /* JADX INFO: renamed from: b */
    public final void m1970b(int i) {
        this.f2236b = i;
    }

    /* JADX INFO: renamed from: c */
    public final String m1971c() {
        return this.f2237c;
    }
}
