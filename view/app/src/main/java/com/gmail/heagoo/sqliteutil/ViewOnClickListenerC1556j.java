package com.gmail.heagoo.sqliteutil;

import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.sqliteutil.j */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1556j implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ SqliteTableViewActivity f4664a;

    ViewOnClickListenerC1556j(SqliteTableViewActivity sqliteTableViewActivity) {
        this.f4664a = sqliteTableViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SqliteTableViewActivity.m3732b(this.f4664a);
    }
}
