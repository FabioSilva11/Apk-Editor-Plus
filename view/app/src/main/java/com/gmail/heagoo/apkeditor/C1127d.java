package com.gmail.heagoo.apkeditor;

import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.apkeditor.util.C1400x;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.d */
/* JADX INFO: loaded from: classes.dex */
class C1127d implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private String f3190a = null;

    /* JADX INFO: renamed from: b */
    private String f3191b = null;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ ApkComposeActivity f3192c;

    C1127d(ApkComposeActivity apkComposeActivity) {
        this.f3192c = apkComposeActivity;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() throws Exception {
        C1400x c1400x = new C1400x(this.f3192c.f2520w);
        c1400x.m3379a(this.f3192c, this.f3192c.f2519v);
        this.f3191b = c1400x.f4066b;
        if (c1400x.f4065a != null) {
            this.f3190a = c1400x.f4065a;
            throw new Exception(this.f3190a);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        if (this.f3190a != null) {
            this.f3192c.f2509l.setText(this.f3190a);
            return;
        }
        ApkComposeActivity.m2324c(this.f3192c, true);
        this.f3192c.f2509l.setText(String.format(this.f3192c.getString(R.string.patch_code_cache_done), this.f3191b));
        this.f3192c.f2510m.setText(R.string.launch);
    }
}
