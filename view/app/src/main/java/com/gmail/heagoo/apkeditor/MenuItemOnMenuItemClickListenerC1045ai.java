package com.gmail.heagoo.apkeditor;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ai */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1045ai implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1040ad f2999a;

    MenuItemOnMenuItemClickListenerC1045ai(ViewOnCreateContextMenuListenerC1040ad viewOnCreateContextMenuListenerC1040ad) {
        this.f2999a = viewOnCreateContextMenuListenerC1040ad;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.f2999a.f2993b.m2454f();
        return true;
    }
}
