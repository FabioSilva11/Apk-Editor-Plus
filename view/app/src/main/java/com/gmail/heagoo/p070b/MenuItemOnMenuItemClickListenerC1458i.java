package com.gmail.heagoo.p070b;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.b.i */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1458i implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1455f f4276a;

    MenuItemOnMenuItemClickListenerC1458i(ViewOnCreateContextMenuListenerC1455f viewOnCreateContextMenuListenerC1455f) {
        this.f4276a = viewOnCreateContextMenuListenerC1455f;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        C1454e.m3473a(this.f4276a.f4273b);
        return true;
    }
}
