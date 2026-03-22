package com.p052d.p053a;

import java.util.Map;

/* JADX INFO: renamed from: com.d.a.b */
/* JADX INFO: loaded from: classes.dex */
final class C0954b implements InterfaceC0962j {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0953a f2427a;

    C0954b(C0953a c0953a) {
        this.f2427a = c0953a;
    }

    @Override // com.p052d.p053a.InterfaceC0962j
    /* JADX INFO: renamed from: a */
    public final Object mo2110a(Object obj, Map map) {
        try {
            return this.f2427a.m2107a(obj, map);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}
