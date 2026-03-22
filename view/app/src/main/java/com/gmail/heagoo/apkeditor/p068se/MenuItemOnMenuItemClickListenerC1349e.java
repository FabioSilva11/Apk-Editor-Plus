package com.gmail.heagoo.apkeditor.p068se;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.e */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1349e implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1348d f3887a;

    MenuItemOnMenuItemClickListenerC1349e(ViewOnCreateContextMenuListenerC1348d viewOnCreateContextMenuListenerC1348d) {
        this.f3887a = viewOnCreateContextMenuListenerC1348d;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.f3887a.f3886b.m3269c(this.f3887a.f3885a);
        return true;
    }
}
