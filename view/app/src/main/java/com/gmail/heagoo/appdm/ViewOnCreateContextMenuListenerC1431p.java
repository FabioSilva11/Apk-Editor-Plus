package com.gmail.heagoo.appdm;

import android.view.ContextMenu;
import android.view.View;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.appdm.util.C1440e;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.p */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnCreateContextMenuListenerC1431p implements View.OnCreateContextMenuListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ String f4211a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C1440e f4212b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C1430o f4213c;

    ViewOnCreateContextMenuListenerC1431p(C1430o c1430o, String str, C1440e c1440e) {
        this.f4213c = c1430o;
        this.f4211a = str;
        this.f4212b = c1440e;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, R.string.appdm_open_in_editor).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1432q(this));
    }
}
