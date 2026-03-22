package com.gmail.heagoo.appdm;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.gmail.heagoo.appdm.util.C1444j;
import com.gmail.heagoo.p054a.p059c.C0986ax;
import com.gmail.heagoo.sqliteutil.SqliteTableListActivity;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.aa */
/* JADX INFO: loaded from: classes.dex */
final class C1409aa implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ PrefOverallActivity f4147a;

    C1409aa(PrefOverallActivity prefOverallActivity) {
        this.f4147a = prefOverallActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Intent intent = new Intent(this.f4147a, (Class<?>) SqliteTableListActivity.class);
        C0986ax.a_001(intent, "dbFilePath", ((C1444j) this.f4147a.f4133r.get(i)).f4249b);
        C0986ax.a_001(intent, "isRootMode", this.f4147a.f4107G ? "true" : "false");
        C0986ax.a_002(intent, "themeId", this.f4147a.f4114O);
        this.f4147a.startActivity(intent);
    }
}
