package com.p016a.p019b.p026b.p027a;

import com.p016a.p019b.p020a.p024d.C0493d;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.a.b.b.a.h */
/* JADX INFO: loaded from: classes.dex */
final class CallableC0530h implements Callable {

    /* JADX INFO: renamed from: a */
    private C0493d f679a;

    private CallableC0530h(C0493d c0493d) {
        this.f679a = c0493d;
    }

    /* synthetic */ CallableC0530h(C0493d c0493d, byte b2) {
        this(c0493d);
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        if (!this.f679a.m729a()) {
            return null;
        }
        C0523a.m807a(true);
        return null;
    }
}
