package com.gmail.heagoo.apkeditor;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fr */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1225fr implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1224fq f3486a;

    MenuItemOnMenuItemClickListenerC1225fr(ViewOnCreateContextMenuListenerC1224fq viewOnCreateContextMenuListenerC1224fq) {
        this.f3486a = viewOnCreateContextMenuListenerC1224fq;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        DialogC1222fo.m3074a(this.f3486a.f3485b, this.f3486a.f3484a);
        return true;
    }
}
