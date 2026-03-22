package com.gmail.heagoo.apkeditor;

import android.content.Context;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.it */
/* JADX INFO: loaded from: classes.dex */
final class C1307it implements InterfaceC1105cb {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Context f3699a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f3700b;

    C1307it(Context context, String str) {
        this.f3699a = context;
        this.f3700b = str;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1105cb
    /* JADX INFO: renamed from: a */
    public final void mo2834a(int i) {
        UserAppActivity.m2641b(this.f3699a, this.f3700b, new StringBuilder().append(i).toString());
    }
}
