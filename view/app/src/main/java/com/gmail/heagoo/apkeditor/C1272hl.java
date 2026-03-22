package com.gmail.heagoo.apkeditor;

import com.gmail.heagoo.common.InterfaceC1477i;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hl */
/* JADX INFO: loaded from: classes.dex */
final class C1272hl implements InterfaceC1477i {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ DialogInterfaceOnClickListenerC1271hk f3626a;

    C1272hl(DialogInterfaceOnClickListenerC1271hk dialogInterfaceOnClickListenerC1271hk) {
        this.f3626a = dialogInterfaceOnClickListenerC1271hk;
    }

    @Override // com.gmail.heagoo.common.InterfaceC1477i
    /* JADX INFO: renamed from: a */
    public final void mo3144a() {
        this.f3626a.f3625b.f3578e += this.f3626a.f3624a;
        new AsyncTaskC1278hr(this.f3626a.f3625b, (byte) 0).execute(new Void[0]);
    }
}
