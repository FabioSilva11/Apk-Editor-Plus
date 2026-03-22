package com.gmail.heagoo.apkeditor;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gc */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1237gc implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1233fz f3518a;

    MenuItemOnMenuItemClickListenerC1237gc(ViewOnCreateContextMenuListenerC1233fz viewOnCreateContextMenuListenerC1233fz) {
        this.f3518a = viewOnCreateContextMenuListenerC1233fz;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        DialogC1229fv.m3089c(this.f3518a.f3513b, this.f3518a.f3512a);
        return true;
    }
}
