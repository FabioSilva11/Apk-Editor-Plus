package com.gmail.heagoo.apkeditor;

import android.view.ContextMenu;
import android.view.View;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fq */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnCreateContextMenuListenerC1224fq implements View.OnCreateContextMenuListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f3484a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ DialogC1222fo f3485b;

    ViewOnCreateContextMenuListenerC1224fq(DialogC1222fo dialogC1222fo, int i) {
        this.f3485b = dialogC1222fo;
        this.f3484a = i;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, R.string.delete).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1225fr(this));
        contextMenu.add(0, 2, 0, R.string.extract).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1226fs(this));
        contextMenu.add(0, 3, 0, R.string.replace).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1227ft(this));
    }
}
