package com.gmail.heagoo.apkeditor;

import android.content.Intent;
import com.gmail.heagoo.apkeditor.pro.R;
import p000a.p001a.p003b.p004a.InterfaceC0039m;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ja */
/* JADX INFO: loaded from: classes.dex */
class C1315ja implements InterfaceC0039m {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ MainActivity f3728a;

    C1315ja(MainActivity mainActivity) {
        this.f3728a = mainActivity;
    }

    @Override // p000a.p001a.p003b.p004a.InterfaceC0039m
    /* JADX INFO: renamed from: a */
    public void mo93a() {
        this.f3728a.finish();
        this.f3728a.overridePendingTransition(R.anim.abc_fade_in_out, R.anim.abc_fade_out);
        this.f3728a.startActivity(new Intent(this.f3728a, (Class<?>) MainActivity.class));
        this.f3728a.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_in_out);
    }
}
