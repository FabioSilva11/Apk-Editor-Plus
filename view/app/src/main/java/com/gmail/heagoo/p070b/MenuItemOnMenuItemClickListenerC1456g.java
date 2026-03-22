package com.gmail.heagoo.p070b;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.b.g */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1456g implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1455f f4274a;

    MenuItemOnMenuItemClickListenerC1456g(ViewOnCreateContextMenuListenerC1455f viewOnCreateContextMenuListenerC1455f) {
        this.f4274a = viewOnCreateContextMenuListenerC1455f;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        C1454e.m3474a(this.f4274a.f4273b, this.f4274a.f4272a);
        return true;
    }
}
