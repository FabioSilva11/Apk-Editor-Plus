package com.gmail.heagoo.sqliteutil;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.sqliteutil.g */
/* JADX INFO: loaded from: classes.dex */
final class C1553g extends ArrayAdapter {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ SqliteTableListActivity f4661a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1553g(SqliteTableListActivity sqliteTableListActivity, Context context, int i, List list) {
        super(context, R.layout.item_sql_table, list);
        this.f4661a = sqliteTableListActivity;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        return (TextView) super.getView(i, view, viewGroup);
    }
}
