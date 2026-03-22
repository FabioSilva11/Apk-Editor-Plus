package com.gmail.heagoo.apkeditor;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.iu */
/* JADX INFO: loaded from: classes.dex */
final class C1308iu implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ UserAppActivity f3701a;

    C1308iu(UserAppActivity userAppActivity) {
        this.f3701a = userAppActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f3701a.f2809c.setVisibility(4);
        this.f3701a.f2817l.setVisibility(0);
        switch (i) {
            case 0:
                UserAppActivity.m2637a(this.f3701a, 0, this.f3701a.f2808b);
                break;
            case 1:
                UserAppActivity.m2637a(this.f3701a, 1, this.f3701a.f2808b);
                break;
            case 2:
                UserAppActivity.m2637a(this.f3701a, this.f3701a.f2807a, 0);
                break;
            case 3:
                UserAppActivity.m2637a(this.f3701a, this.f3701a.f2807a, 1);
                break;
        }
        if (this.f3701a.f2813g != null) {
            this.f3701a.f2813g.dismiss();
        }
    }
}
