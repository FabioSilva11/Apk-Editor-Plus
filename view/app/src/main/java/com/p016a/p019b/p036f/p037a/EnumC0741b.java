package com.p016a.p019b.p036f.p037a;

import com.p016a.p019b.p043h.InterfaceC0889s;

/* JADX INFO: renamed from: com.a.b.f.a.b */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0741b implements InterfaceC0889s {
    RUNTIME("runtime"),
    BUILD("build"),
    SYSTEM("system"),
    EMBEDDED("embedded");


    /* JADX INFO: renamed from: e */
    private final String f1613e;

    EnumC0741b(String str) {
        this.f1613e = str;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return this.f1613e;
    }
}
