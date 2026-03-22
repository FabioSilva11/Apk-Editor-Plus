package com.gmail.heagoo.apkeditor;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fs */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1226fs implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1224fq f3487a;

    MenuItemOnMenuItemClickListenerC1226fs(ViewOnCreateContextMenuListenerC1224fq viewOnCreateContextMenuListenerC1224fq) {
        this.f3487a = viewOnCreateContextMenuListenerC1224fq;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        DialogC1222fo.m3078b(this.f3487a.f3485b, this.f3487a.f3484a);
        return true;
    }
}
