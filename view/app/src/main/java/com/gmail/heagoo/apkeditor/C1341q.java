package com.gmail.heagoo.apkeditor;

import android.os.Bundle;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.q */
/* JADX INFO: loaded from: classes.dex */
final class C1341q implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Bundle f3811a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ApkInfoActivity f3812b;

    C1341q(ApkInfoActivity apkInfoActivity, Bundle bundle) {
        this.f3812b = apkInfoActivity;
        this.f3811a = bundle;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() {
        ApkInfoActivity.m2384a(this.f3812b, this.f3811a);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        ApkInfoActivity.m2383a(this.f3812b);
    }
}
