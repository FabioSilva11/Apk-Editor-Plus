package com.gmail.heagoo.apkeditor;

import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ak */
/* JADX INFO: loaded from: classes.dex */
final class C1047ak implements InterfaceC1122cu {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ List f3001a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ApkInfoActivity f3002b;

    C1047ak(ApkInfoActivity apkInfoActivity, List list) {
        this.f3002b = apkInfoActivity;
        this.f3001a = list;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) {
        new DialogC1108ce(this.f3002b, this.f3002b.f2582a, this.f3002b.f2614b, this.f3002b.f2623k, this.f3001a, str).show();
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
