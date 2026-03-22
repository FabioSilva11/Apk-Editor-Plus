package com.gmail.heagoo.apkeditor;

import android.view.ContextMenu;
import android.view.View;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.co */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnCreateContextMenuListenerC1116co implements View.OnCreateContextMenuListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ DialogC1115cn f3177a;

    ViewOnCreateContextMenuListenerC1116co(DialogC1115cn dialogC1115cn) {
        this.f3177a = dialogC1115cn;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, R.string.new_folder).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1117cp(this));
    }
}
