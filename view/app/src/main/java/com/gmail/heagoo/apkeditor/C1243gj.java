package com.gmail.heagoo.apkeditor;

import com.gmail.heagoo.common.C1471c;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gj */
/* JADX INFO: loaded from: classes.dex */
final class C1243gj implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f3531a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ SettingActivity f3532b;

    C1243gj(SettingActivity settingActivity, String str) {
        this.f3532b = settingActivity;
        this.f3531a = str;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() {
        this.f3532b.m2553a();
        new C1471c().mo3495a("rm -rf " + this.f3531a + "/decoded\nrm -rf " + this.f3531a + "/temp", (String[]) null, (Integer) 8000);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
    }
}
