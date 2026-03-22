package com.gmail.heagoo.appdm;

import android.view.View;
import android.widget.AdapterView;
import com.gmail.heagoo.appdm.util.C1440e;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.o */
/* JADX INFO: loaded from: classes.dex */
final class C1430o implements AdapterView.OnItemLongClickListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ PrefOverallActivity f4210a;

    C1430o(PrefOverallActivity prefOverallActivity) {
        this.f4210a = prefOverallActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        ArrayList arrayList = new ArrayList();
        String strM3445a = this.f4210a.f4131p.m3445a(arrayList);
        C1440e c1440e = (C1440e) arrayList.get(i);
        if (c1440e.f4245c) {
            return true;
        }
        adapterView.setOnCreateContextMenuListener(new ViewOnCreateContextMenuListenerC1431p(this, strM3445a, c1440e));
        return false;
    }
}
