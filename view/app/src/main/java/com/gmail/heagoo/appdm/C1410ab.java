package com.gmail.heagoo.appdm;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.ab */
/* JADX INFO: loaded from: classes.dex */
final class C1410ab implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ PrefOverallActivity f4148a;

    C1410ab(PrefOverallActivity prefOverallActivity) {
        this.f4148a = prefOverallActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f4148a.m3422a(i);
    }
}
