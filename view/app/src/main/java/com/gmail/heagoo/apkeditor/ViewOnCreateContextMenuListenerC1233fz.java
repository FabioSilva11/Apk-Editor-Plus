package com.gmail.heagoo.apkeditor;

import android.view.ContextMenu;
import android.view.View;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fz */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnCreateContextMenuListenerC1233fz implements View.OnCreateContextMenuListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f3512a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ DialogC1229fv f3513b;

    ViewOnCreateContextMenuListenerC1233fz(DialogC1229fv dialogC1229fv, int i) {
        this.f3513b = dialogC1229fv;
        this.f3512a = i;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, R.string.delete).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1235ga(this));
        contextMenu.add(0, 2, 0, R.string.extract).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1236gb(this));
        contextMenu.add(0, 3, 0, R.string.replace).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1237gc(this));
    }
}
