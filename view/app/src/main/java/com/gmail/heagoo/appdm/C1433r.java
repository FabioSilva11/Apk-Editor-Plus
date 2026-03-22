package com.gmail.heagoo.appdm;

import com.gmail.heagoo.apkeditor.InterfaceC1208fa;
import com.gmail.heagoo.appdm.util.C1441f;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.r */
/* JADX INFO: loaded from: classes.dex */
final class C1433r implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f4215a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ PrefOverallActivity f4216b;

    C1433r(PrefOverallActivity prefOverallActivity, String str) {
        this.f4216b = prefOverallActivity;
        this.f4215a = str;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() {
        List listM3447a = this.f4216b.f4131p.m3447a(this.f4215a, true);
        Collections.sort(listM3447a, new C1441f());
        if (listM3447a != null) {
            this.f4216b.f4131p.m3448a(this.f4215a, listM3447a);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
    }
}
