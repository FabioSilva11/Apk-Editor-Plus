package com.gmail.heagoo.apkeditor;

import com.gmail.heagoo.common.InterfaceC1477i;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ij */
/* JADX INFO: loaded from: classes.dex */
final class C1297ij implements InterfaceC1477i {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ DialogInterfaceOnClickListenerC1296ii f3681a;

    C1297ij(DialogInterfaceOnClickListenerC1296ii dialogInterfaceOnClickListenerC1296ii) {
        this.f3681a = dialogInterfaceOnClickListenerC1296ii;
    }

    @Override // com.gmail.heagoo.common.InterfaceC1477i
    /* JADX INFO: renamed from: a */
    public final void mo3144a() {
        this.f3681a.f3680b.f3578e += this.f3681a.f3679a;
        new AsyncTaskC1303ip(this.f3681a.f3680b, (byte) 0).execute(new Void[0]);
    }
}
