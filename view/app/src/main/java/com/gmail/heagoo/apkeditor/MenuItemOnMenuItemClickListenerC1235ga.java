package com.gmail.heagoo.apkeditor;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ga */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1235ga implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1233fz f3516a;

    MenuItemOnMenuItemClickListenerC1235ga(ViewOnCreateContextMenuListenerC1233fz viewOnCreateContextMenuListenerC1233fz) {
        this.f3516a = viewOnCreateContextMenuListenerC1233fz;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        DialogC1229fv.m3086a(this.f3516a.f3513b, this.f3516a.f3512a);
        return true;
    }
}
