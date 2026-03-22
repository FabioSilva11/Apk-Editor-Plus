package com.gmail.heagoo.apkeditor;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ev */
/* JADX INFO: loaded from: classes.dex */
final class C1198ev implements InterfaceC1122cu {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ DialogC1197eu f3392a;

    C1198ev(DialogC1197eu dialogC1197eu) {
        this.f3392a = dialogC1197eu;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) throws Throwable {
        DialogC1197eu.m2985a(this.f3392a, str);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final boolean mo2503a(String str, String str2) {
        return str.endsWith(".zip");
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: b */
    public final String mo2504b(String str, String str2) {
        return null;
    }
}
