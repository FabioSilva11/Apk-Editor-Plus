package com.gmail.heagoo.apkeditor.p068se;

import android.view.ContextMenu;
import android.view.View;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.d */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnCreateContextMenuListenerC1348d implements View.OnCreateContextMenuListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f3885a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ ViewOnClickListenerC1347c f3886b;

    ViewOnCreateContextMenuListenerC1348d(ViewOnClickListenerC1347c viewOnClickListenerC1347c, int i) {
        this.f3886b = viewOnClickListenerC1347c;
        this.f3885a = i;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, R.string.extract).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1349e(this));
        contextMenu.add(0, 2, 0, R.string.replace).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1350f(this));
    }
}
