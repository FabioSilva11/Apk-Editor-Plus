package com.gmail.heagoo.apkeditor;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gl */
/* JADX INFO: loaded from: classes.dex */
final class C1245gl implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ DialogC1244gk f3539a;

    C1245gl(DialogC1244gk dialogC1244gk) {
        this.f3539a = dialogC1244gk;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        this.f3539a.m3106a(i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
