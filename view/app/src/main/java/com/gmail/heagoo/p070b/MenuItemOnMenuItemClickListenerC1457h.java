package com.gmail.heagoo.p070b;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.b.h */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1457h implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1455f f4275a;

    MenuItemOnMenuItemClickListenerC1457h(ViewOnCreateContextMenuListenerC1455f viewOnCreateContextMenuListenerC1455f) {
        this.f4275a = viewOnCreateContextMenuListenerC1455f;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        C1454e.m3476b(this.f4275a.f4273b, this.f4275a.f4272a);
        return true;
    }
}
