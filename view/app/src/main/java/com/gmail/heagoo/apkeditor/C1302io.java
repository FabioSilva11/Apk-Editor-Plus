package com.gmail.heagoo.apkeditor;

import android.text.Editable;
import android.text.TextWatcher;
import com.gmail.heagoo.neweditor.C1511e;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.io */
/* JADX INFO: loaded from: classes.dex */
final class C1302io implements TextWatcher {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ TextEditNormalActivity f3690a;

    private C1302io(TextEditNormalActivity textEditNormalActivity) {
        this.f3690a = textEditNormalActivity;
    }

    /* synthetic */ C1302io(TextEditNormalActivity textEditNormalActivity, byte b2) {
        this(textEditNormalActivity);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C1511e c1511e = this.f3690a.f3583j;
        if (c1511e == null) {
            return;
        }
        boolean zM3650b = c1511e.m3650b();
        if (!TextEditNormalActivity.m2622m(this.f3690a)) {
            c1511e.m3647a(charSequence, i, i2, i3);
        }
        this.f3690a.m2628a(Math.min(this.f3690a.f2801u, i), Math.max(i2, i3) + i, true);
        this.f3690a.m2632e();
        this.f3690a.m2629a(true);
        if (zM3650b || !c1511e.m3650b()) {
            return;
        }
        this.f3690a.m2631d();
    }
}
