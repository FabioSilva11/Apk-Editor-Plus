package com.gmail.heagoo.apkeditor;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.cp */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1117cp implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1116co f3178a;

    MenuItemOnMenuItemClickListenerC1117cp(ViewOnCreateContextMenuListenerC1116co viewOnCreateContextMenuListenerC1116co) {
        this.f3178a = viewOnCreateContextMenuListenerC1116co;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        DialogC1115cn.m2849a(this.f3178a.f3177a);
        return true;
    }
}
