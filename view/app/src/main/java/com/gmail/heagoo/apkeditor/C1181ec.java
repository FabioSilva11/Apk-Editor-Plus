package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.support.v4.view.PointerIconCompat;
import com.gmail.heagoo.p054a.p059c.C0985a;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ec */
/* JADX INFO: loaded from: classes.dex */
final class C1181ec implements InterfaceC1122cu {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnClickListenerC1180eb f3326a;

    C1181ec(ViewOnClickListenerC1180eb viewOnClickListenerC1180eb) {
        this.f3326a = viewOnClickListenerC1180eb;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) throws Throwable {
        if (z) {
            ((ApkInfoActivity) this.f3326a.f3325a.f3236a.get()).m2434a(str, str2, (InterfaceC1254gu) null);
            C0985a.m2203a((Activity) this.f3326a.f3325a.f3236a.get(), str, PointerIconCompat.TYPE_CONTEXT_MENU);
        } else {
            ((ApkInfoActivity) this.f3326a.f3325a.f3236a.get()).m2444b(str2, str);
            ((ApkInfoActivity) this.f3326a.f3325a.f3236a.get()).m2439a(true);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final boolean mo2503a(String str, String str2) {
        return str.endsWith(".xml");
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: b */
    public final String mo2504b(String str, String str2) {
        return null;
    }
}
