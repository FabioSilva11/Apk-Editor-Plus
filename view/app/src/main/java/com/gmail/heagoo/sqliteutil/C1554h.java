package com.gmail.heagoo.sqliteutil;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.gmail.heagoo.p054a.p059c.C0986ax;

/* JADX INFO: renamed from: com.gmail.heagoo.sqliteutil.h */
/* JADX INFO: loaded from: classes.dex */
final class C1554h implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ SqliteTableListActivity f4662a;

    C1554h(SqliteTableListActivity sqliteTableListActivity) {
        this.f4662a = sqliteTableListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = (String) this.f4662a.f4602c.get(i);
        Intent intent = new Intent(this.f4662a, (Class<?>) SqliteTableViewActivity.class);
        C0986ax.a_001(intent, "originDbFilePath", this.f4662a.f4600a);
        C0986ax.a_001(intent, "dbFilePath", this.f4662a.f4601b);
        C0986ax.a_001(intent, "tableName", str);
        C0986ax.a_002(intent, "themeId", this.f4662a.f4604e);
        this.f4662a.startActivity(intent);
    }
}
