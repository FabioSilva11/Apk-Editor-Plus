package com.gmail.heagoo.apkeditor.p068se;

import android.view.ContextMenu;
import android.view.View;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.k */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnCreateContextMenuListenerC1355k implements View.OnCreateContextMenuListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f3902a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ ViewOnClickListenerC1353i f3903b;

    ViewOnCreateContextMenuListenerC1355k(ViewOnClickListenerC1353i viewOnClickListenerC1353i, int i) {
        this.f3903b = viewOnClickListenerC1353i;
        this.f3902a = i;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, R.string.extract).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1356l(this));
        contextMenu.add(0, 2, 0, R.string.view).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1357m(this));
        contextMenu.add(0, 3, 0, R.string.replace).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1358n(this));
    }
}
