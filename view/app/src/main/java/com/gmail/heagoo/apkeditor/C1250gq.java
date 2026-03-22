package com.gmail.heagoo.apkeditor;

import android.view.View;
import android.widget.AdapterView;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gq */
/* JADX INFO: loaded from: classes.dex */
final class C1250gq implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ List f3548a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C1249gp f3549b;

    C1250gq(C1249gp c1249gp, List list) {
        this.f3549b = c1249gp;
        this.f3548a = list;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (i < this.f3548a.size()) {
            C1248go c1248go = (C1248go) this.f3548a.get(i);
            if (this.f3549b.f3545a.get() != null) {
                ((InterfaceC1251gr) this.f3549b.f3545a.get()).mo2589b(c1248go.f3544b + 1);
            }
        }
        if (this.f3549b.f3546b != null) {
            this.f3549b.f3546b.dismiss();
        }
    }
}
