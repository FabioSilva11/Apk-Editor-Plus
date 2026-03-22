package com.gmail.heagoo.apkeditor;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ht */
/* JADX INFO: loaded from: classes.dex */
final class C1280ht implements TextWatcher {

    /* JADX INFO: renamed from: a */
    private int f3649a;

    /* JADX INFO: renamed from: b */
    private boolean f3650b = true;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ C1279hs f3651c;

    public C1280ht(C1279hs c1279hs, int i) {
        this.f3651c = c1279hs;
        this.f3649a = i;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        if (this.f3650b) {
            this.f3650b = false;
            return;
        }
        if (this.f3649a < this.f3651c.f3639b.size()) {
            this.f3651c.f3639b.set(this.f3649a, editable.toString());
        }
        if (this.f3651c.f3646i != null) {
            this.f3651c.f3646i.afterTextChanged(editable);
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
