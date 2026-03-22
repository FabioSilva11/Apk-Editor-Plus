package com.gmail.heagoo.apkeditor;

import com.gmail.heagoo.common.C1476h;
import com.gmail.heagoo.common.InterfaceC1477i;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hm */
/* JADX INFO: loaded from: classes.dex */
final class C1273hm implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ InterfaceC1477i f3627a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ TextEditBigActivity f3628b;

    C1273hm(TextEditBigActivity textEditBigActivity, InterfaceC1477i interfaceC1477i) {
        this.f3628b = textEditBigActivity;
        this.f3627a = interfaceC1477i;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() {
        C1476h.m3511a(this.f3628b.m3135a(), this.f3628b.f2738K.m3174e());
        this.f3628b.f3583j.m3649a(false);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        this.f3628b.m2591d();
        this.f3628b.f3580g = true;
        this.f3628b.m3140b();
        if (this.f3627a != null) {
            this.f3627a.mo3144a();
        }
    }
}
