package com.gmail.heagoo.apkeditor;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.an */
/* JADX INFO: loaded from: classes.dex */
final class C1050an implements InterfaceC1122cu {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ApkInfoActivity f3007a;

    C1050an(ApkInfoActivity apkInfoActivity) {
        this.f3007a = apkInfoActivity;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) throws Throwable {
        this.f3007a.f2617e.m3042a(str2 + "/" + str.substring(str.lastIndexOf("/") + 1), str);
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
