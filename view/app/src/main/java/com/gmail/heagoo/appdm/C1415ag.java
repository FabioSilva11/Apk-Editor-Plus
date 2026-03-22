package com.gmail.heagoo.appdm;

import com.gmail.heagoo.appdm.util.C1441f;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.ag */
/* JADX INFO: loaded from: classes.dex */
final class C1415ag extends Thread {

    /* JADX INFO: renamed from: a */
    private String f4166a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C1412ad f4167b;

    public C1415ag(C1412ad c1412ad, String str) {
        this.f4167b = c1412ad;
        this.f4166a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        List listM3446a = this.f4167b.m3446a(this.f4166a);
        if (listM3446a != null) {
            Collections.sort(listM3446a, new C1441f());
            this.f4167b.m3448a(this.f4166a, listM3446a);
        }
    }
}
