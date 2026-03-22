package com.gmail.heagoo.apkeditor.p068se;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.n */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1358n implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1355k f3906a;

    MenuItemOnMenuItemClickListenerC1358n(ViewOnCreateContextMenuListenerC1355k viewOnCreateContextMenuListenerC1355k) {
        this.f3906a = viewOnCreateContextMenuListenerC1355k;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.f3906a.f3903b.m3279c(this.f3906a.f3902a);
        return true;
    }
}
