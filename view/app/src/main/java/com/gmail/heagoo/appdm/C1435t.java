package com.gmail.heagoo.appdm;

import android.widget.Toast;
import com.gmail.heagoo.apkeditor.InterfaceC1208fa;
import com.gmail.heagoo.p054a.p059c.C0986ax;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.t */
/* JADX INFO: loaded from: classes.dex */
final class C1435t implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private String f4221a = null;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f4222b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ PrefOverallActivity f4223c;

    C1435t(PrefOverallActivity prefOverallActivity, String str) {
        this.f4223c = prefOverallActivity;
        this.f4222b = str;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() {
        this.f4221a = PrefOverallActivity.m3394a(this.f4223c, this.f4222b);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        if (this.f4221a != null) {
            C0986ax.b_011(this.f4223c, this.f4221a);
        } else {
            Toast.makeText(this.f4223c, "Failed to open the file.", 0).show();
        }
    }
}
