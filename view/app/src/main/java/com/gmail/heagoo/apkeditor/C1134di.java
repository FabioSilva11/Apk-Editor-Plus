package com.gmail.heagoo.apkeditor;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.di */
/* JADX INFO: loaded from: classes.dex */
final class C1134di implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ DialogC1133dh f3208a;

    C1134di(DialogC1133dh dialogC1133dh) {
        this.f3208a = dialogC1133dh;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        this.f3208a.m2864a(i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
