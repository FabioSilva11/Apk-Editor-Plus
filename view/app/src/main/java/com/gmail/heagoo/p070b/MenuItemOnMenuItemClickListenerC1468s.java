package com.gmail.heagoo.p070b;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.b.s */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1468s implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1455f f4287a;

    MenuItemOnMenuItemClickListenerC1468s(ViewOnCreateContextMenuListenerC1455f viewOnCreateContextMenuListenerC1455f) {
        this.f4287a = viewOnCreateContextMenuListenerC1455f;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        C1454e.m3482g(this.f4287a.f4273b, this.f4287a.f4272a);
        return true;
    }
}
