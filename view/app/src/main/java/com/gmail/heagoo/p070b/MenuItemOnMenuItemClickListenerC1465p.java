package com.gmail.heagoo.p070b;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.b.p */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1465p implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1455f f4284a;

    MenuItemOnMenuItemClickListenerC1465p(ViewOnCreateContextMenuListenerC1455f viewOnCreateContextMenuListenerC1455f) {
        this.f4284a = viewOnCreateContextMenuListenerC1455f;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) throws Throwable {
        C1454e.m3479d(this.f4284a.f4273b, this.f4284a.f4272a);
        return true;
    }
}
