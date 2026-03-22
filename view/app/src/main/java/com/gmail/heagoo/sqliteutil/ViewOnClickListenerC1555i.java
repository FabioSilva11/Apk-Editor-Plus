package com.gmail.heagoo.sqliteutil;

import android.view.View;

/* JADX INFO: renamed from: com.gmail.heagoo.sqliteutil.i */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1555i implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ SqliteTableViewActivity f4663a;

    ViewOnClickListenerC1555i(SqliteTableViewActivity sqliteTableViewActivity) {
        this.f4663a = sqliteTableViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SqliteTableViewActivity.m3729a(this.f4663a);
    }
}
