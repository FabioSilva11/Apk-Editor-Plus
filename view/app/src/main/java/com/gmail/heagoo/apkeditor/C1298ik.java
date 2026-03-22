package com.gmail.heagoo.apkeditor;

import com.gmail.heagoo.common.InterfaceC1477i;
import java.io.IOException;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ik */
/* JADX INFO: loaded from: classes.dex */
final class C1298ik implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ InterfaceC1477i f3682a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ TextEditNormalActivity f3683b;

    C1298ik(TextEditNormalActivity textEditNormalActivity, InterfaceC1477i interfaceC1477i) {
        this.f3683b = textEditNormalActivity;
        this.f3682a = interfaceC1477i;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() throws IOException {
        this.f3683b.f3583j.m3643a(this.f3683b);
        this.f3683b.f3583j.m3649a(false);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        this.f3683b.m2631d();
        this.f3683b.f3580g = true;
        this.f3683b.m3140b();
        if (this.f3682a != null) {
            this.f3682a.mo3144a();
        }
    }
}
