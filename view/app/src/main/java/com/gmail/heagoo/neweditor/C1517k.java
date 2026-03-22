package com.gmail.heagoo.neweditor;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.k */
/* JADX INFO: loaded from: classes.dex */
final class C1517k implements TextWatcher {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ EditorActivity f4500a;

    C1517k(EditorActivity editorActivity) {
        this.f4500a = editorActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C1511e c1511e = this.f4500a.f4369P;
        boolean zM3650b = c1511e.m3650b();
        if (!this.f4500a.f4390r) {
            c1511e.m3647a(charSequence, i, i2, i3);
        }
        this.f4500a.m3592a(Math.min(this.f4500a.f4383k, i), Math.max(i2, i3) + i, true);
        this.f4500a.m3594b();
        this.f4500a.m3593a(true);
        if (zM3650b || !c1511e.m3650b()) {
            return;
        }
        this.f4500a.m3591a();
    }
}
