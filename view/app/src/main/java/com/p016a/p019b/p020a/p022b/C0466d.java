package com.p016a.p019b.p020a.p022b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p043h.C0883m;
import com.p016a.p019b.p043h.InterfaceC0882l;

/* JADX INFO: renamed from: com.a.b.a.b.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0466d extends C0883m {
    public C0466d(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a */
    public final C0465c m564a(int i) {
        int iC = m2000c(i);
        if (iC < 0) {
            throw new IllegalArgumentException("no such label: " + C0985a.m2296v(i));
        }
        return (C0465c) m1978e(iC);
    }

    /* JADX INFO: renamed from: a */
    public final void m565a(int i, C0465c c0465c) {
        super.m1999a(i, (InterfaceC0882l) c0465c);
    }
}
