package com.gmail.heagoo.p070b;

import android.view.ContextMenu;
import android.view.View;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.b.f */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnCreateContextMenuListenerC1455f implements View.OnCreateContextMenuListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f4272a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C1454e f4273b;

    ViewOnCreateContextMenuListenerC1455f(C1454e c1454e, int i) {
        this.f4273b = c1454e;
        this.f4272a = i;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, R.string.delete).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1456g(this));
        contextMenu.add(0, 2, 0, R.string.rename).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1457h(this));
        contextMenu.add(0, 3, 0, R.string.new_file).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1458i(this));
        contextMenu.add(0, 4, 0, R.string.install).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1465p(this));
        contextMenu.add(0, 5, 0, R.string.sign).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1466q(this));
        contextMenu.add(0, 6, 0, R.string.action_verify).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1468s(this));
    }
}
