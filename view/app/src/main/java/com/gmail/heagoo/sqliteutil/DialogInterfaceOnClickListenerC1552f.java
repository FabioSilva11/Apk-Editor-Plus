package com.gmail.heagoo.sqliteutil;

import android.content.DialogInterface;
import android.widget.Toast;

/* JADX INFO: renamed from: com.gmail.heagoo.sqliteutil.f */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1552f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ SqliteRowViewActivity f4660a;

    DialogInterfaceOnClickListenerC1552f(SqliteRowViewActivity sqliteRowViewActivity) {
        this.f4660a = sqliteRowViewActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            SqliteRowViewActivity.m3717a(this.f4660a);
            this.f4660a.finish();
        } catch (Exception e) {
            Toast.makeText(this.f4660a, e.getClass().getSimpleName() + ": " + e.getMessage(), 0).show();
        }
    }
}
