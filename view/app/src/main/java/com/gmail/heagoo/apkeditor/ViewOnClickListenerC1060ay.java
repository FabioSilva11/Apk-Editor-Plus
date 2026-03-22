package com.gmail.heagoo.apkeditor;

import android.view.View;
import p000a.p001a.p003b.p004a.p005a.C0027x;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ay */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1060ay implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f3024a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ViewOnClickListenerC1057av f3025b;

    ViewOnClickListenerC1060ay(ViewOnClickListenerC1057av viewOnClickListenerC1057av, String str) {
        this.f3025b = viewOnClickListenerC1057av;
        this.f3024a = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            C0027x.m34b(this.f3025b.f3019a.f2582a, this.f3024a, "/sdcard/axml");
        } catch (Exception e) {
        }
    }
}
