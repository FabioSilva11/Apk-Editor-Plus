package com.gmail.heagoo.apkeditor.p068se;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.m */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1357m implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1355k f3905a;

    MenuItemOnMenuItemClickListenerC1357m(ViewOnCreateContextMenuListenerC1355k viewOnCreateContextMenuListenerC1355k) {
        this.f3905a = viewOnCreateContextMenuListenerC1355k;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.f3905a.f3903b.m3275a(this.f3905a.f3902a);
        return true;
    }
}
