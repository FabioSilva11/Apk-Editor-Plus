package com.p016a.p019b.p028c.p032c;

import com.p016a.p019b.p036f.p039c.C0802z;

/* JADX INFO: renamed from: com.a.b.c.c.ab */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0604ab extends AbstractC0605ac {

    /* JADX INFO: renamed from: a */
    private final C0802z f1043a;

    public AbstractC0604ab(C0802z c0802z) {
        if (c0802z == null) {
            throw new NullPointerException("type == null");
        }
        this.f1043a = c0802z;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public void mo1042a(C0650r c0650r) {
        c0650r.m1229k().m1117a(this.f1043a);
    }

    /* JADX INFO: renamed from: d */
    public final C0802z m1048d() {
        return this.f1043a;
    }
}
