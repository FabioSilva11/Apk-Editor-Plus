package com.gmail.heagoo.apkeditor;

import android.content.Intent;
import android.view.View;
import com.gmail.heagoo.p054a.p059c.C0985a;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.h */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1260h implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f3601a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ int f3602b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ C1234g f3603c;

    ViewOnClickListenerC1260h(C1234g c1234g, String str, int i) {
        this.f3603c = c1234g;
        this.f3601a = str;
        this.f3602b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ApkComposeActivity apkComposeActivity = (ApkComposeActivity) this.f3603c.f3514a.get();
        Intent intentM2177a = C0985a.m2177a(apkComposeActivity, this.f3601a, apkComposeActivity.f2498a);
        if (this.f3602b > 0) {
            C0985a.m2180a(intentM2177a, "startLine", new StringBuilder().append(this.f3602b).toString());
        }
        apkComposeActivity.startActivity(intentM2177a);
    }
}
