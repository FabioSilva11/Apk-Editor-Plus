package com.gmail.heagoo.apkeditor;

import android.content.Intent;
import com.gmail.heagoo.apkeditor.pro.R;
import p000a.p001a.p003b.p004a.InterfaceC0039m;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.jc */
/* JADX INFO: loaded from: classes.dex */
class C1317jc implements InterfaceC0039m {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ SettingActivity f3730a;

    C1317jc(SettingActivity settingActivity) {
        this.f3730a = settingActivity;
    }

    @Override // p000a.p001a.p003b.p004a.InterfaceC0039m
    /* JADX INFO: renamed from: a */
    public void mo93a() {
        this.f3730a.finish();
        this.f3730a.overridePendingTransition(R.anim.abc_fade_in_out, R.anim.abc_fade_out);
        this.f3730a.startActivity(new Intent(this.f3730a, (Class<?>) SettingActivity.class));
        this.f3730a.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_in_out);
    }
}
