package com.gmail.heagoo.apkeditor.p068se;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.l */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1356l implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1355k f3904a;

    MenuItemOnMenuItemClickListenerC1356l(ViewOnCreateContextMenuListenerC1355k viewOnCreateContextMenuListenerC1355k) {
        this.f3904a = viewOnCreateContextMenuListenerC1355k;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.f3904a.f3903b.m3277b(this.f3904a.f3902a);
        return true;
    }
}
