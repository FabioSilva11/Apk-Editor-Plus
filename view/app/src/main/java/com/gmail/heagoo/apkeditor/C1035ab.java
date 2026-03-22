package com.gmail.heagoo.apkeditor;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ab */
/* JADX INFO: loaded from: classes.dex */
final class C1035ab implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ApkInfoActivity f2984a;

    C1035ab(ApkInfoActivity apkInfoActivity) {
        this.f2984a = apkInfoActivity;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        this.f2984a.f2560D = (String) this.f2984a.f2561E.get(i);
        this.f2984a.m2423u();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
