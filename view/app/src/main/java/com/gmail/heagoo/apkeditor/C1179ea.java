package com.gmail.heagoo.apkeditor;

import android.content.Context;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ea */
/* JADX INFO: loaded from: classes.dex */
final class C1179ea implements InterfaceC1122cu {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnClickListenerC1147dz f3324a;

    C1179ea(ViewOnClickListenerC1147dz viewOnClickListenerC1147dz) {
        this.f3324a = viewOnClickListenerC1147dz;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) {
        new DialogC1108ce((Context) this.f3324a.f3241a.f3236a.get(), this.f3324a.f3241a.f3237b, str, (String) null, (String) null, (Map) null).show();
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final boolean mo2503a(String str, String str2) {
        return true;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: b */
    public final String mo2504b(String str, String str2) {
        return null;
    }
}
