package com.gmail.heagoo.appdm;

import android.content.Intent;
import android.support.v4.view.PointerIconCompat;
import android.view.View;
import android.widget.AdapterView;
import com.gmail.heagoo.appdm.util.C1444j;
import com.gmail.heagoo.p054a.p059c.C0986ax;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.z */
/* JADX INFO: loaded from: classes.dex */
final class C1449z implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ PrefOverallActivity f4254a;

    C1449z(PrefOverallActivity prefOverallActivity) {
        this.f4254a = prefOverallActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f4254a.f4110K = System.currentTimeMillis();
        this.f4254a.f4113N++;
        Intent intent = new Intent(this.f4254a, (Class<?>) PrefDetailActivity.class);
        C0986ax.a_001(intent, "appName", (String) this.f4254a.f4128m.loadLabel(this.f4254a.f4127l));
        C0986ax.a_001(intent, "xmlFilePath", ((C1444j) this.f4254a.f4132q.get(i)).f4249b);
        C0986ax.a_001(intent, "packagePath", this.f4254a.f4118c);
        C0986ax.b_012(intent, "isRootMode", this.f4254a.f4107G);
        C0986ax.a_002(intent, "themeId", this.f4254a.f4114O);
        this.f4254a.startActivityForResult(intent, PointerIconCompat.TYPE_CONTEXT_MENU);
    }
}
