package com.gmail.heagoo.apkeditor;

import android.support.v4.view.PointerIconCompat;
import com.gmail.heagoo.p054a.p059c.C0985a;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.al */
/* JADX INFO: loaded from: classes.dex */
final class C1048al implements InterfaceC1122cu {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ InterfaceC1254gu f3003a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f3004b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ ApkInfoActivity f3005c;

    C1048al(ApkInfoActivity apkInfoActivity, InterfaceC1254gu interfaceC1254gu, String str) {
        this.f3005c = apkInfoActivity;
        this.f3003a = interfaceC1254gu;
        this.f3004b = str;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) {
        if (z) {
            this.f3005c.m2434a(str, str2, this.f3003a);
            C0985a.m2203a(this.f3005c, str, PointerIconCompat.TYPE_CONTEXT_MENU);
        } else {
            this.f3005c.f2617e.m3056d(str2, str);
            if (this.f3003a != null) {
                this.f3003a.mo3082a();
            }
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final boolean mo2503a(String str, String str2) {
        if (this.f3004b != null) {
            return str.endsWith(this.f3004b);
        }
        return true;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: b */
    public final String mo2504b(String str, String str2) {
        return null;
    }
}
