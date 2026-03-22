package com.gmail.heagoo.neweditor;

import com.gmail.heagoo.apkeditor.InterfaceC1208fa;
import java.io.IOException;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.o */
/* JADX INFO: loaded from: classes.dex */
final class C1521o implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ EditorActivity f4504a;

    C1521o(EditorActivity editorActivity) {
        this.f4504a = editorActivity;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() throws IOException {
        this.f4504a.f4369P.m3643a(this.f4504a);
        this.f4504a.f4369P.m3649a(false);
        if (this.f4504a.f4366M != null) {
            this.f4504a.m3596c();
        }
        this.f4504a.setResult(1);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        this.f4504a.m3591a();
        this.f4504a.f4379c = true;
        this.f4504a.m3597d();
    }
}
