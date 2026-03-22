package com.gmail.heagoo.apkeditor;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.aj */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1046aj implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1040ad f3000a;

    MenuItemOnMenuItemClickListenerC1046aj(ViewOnCreateContextMenuListenerC1040ad viewOnCreateContextMenuListenerC1040ad) {
        this.f3000a = viewOnCreateContextMenuListenerC1040ad;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.f3000a.f2993b.m2457g();
        return true;
    }
}
