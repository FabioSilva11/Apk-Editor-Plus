package com.gmail.heagoo.apkeditor;

import android.content.Intent;
import com.gmail.heagoo.apkeditor.pro.R;
import p000a.p001a.p003b.p004a.InterfaceC0042p;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.jb */
/* JADX INFO: loaded from: classes.dex */
class C1316jb implements InterfaceC0042p {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ SettingHideActivity f3729a;

    C1316jb(SettingHideActivity settingHideActivity) {
        this.f3729a = settingHideActivity;
    }

    @Override // p000a.p001a.p003b.p004a.InterfaceC0042p
    /* JADX INFO: renamed from: a */
    public void mo99a() {
        this.f3729a.finish();
        this.f3729a.overridePendingTransition(R.anim.abc_fade_in_out, R.anim.abc_fade_out);
        this.f3729a.startActivity(new Intent(this.f3729a, (Class<?>) SettingHideActivity.class));
        this.f3729a.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_in_out);
    }
}
