package com.gmail.heagoo.p070b;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.b.q */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1466q implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1455f f4285a;

    MenuItemOnMenuItemClickListenerC1466q(ViewOnCreateContextMenuListenerC1455f viewOnCreateContextMenuListenerC1455f) {
        this.f4285a = viewOnCreateContextMenuListenerC1455f;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        C1454e.m3481f(this.f4285a.f4273b, this.f4285a.f4272a);
        return true;
    }
}
