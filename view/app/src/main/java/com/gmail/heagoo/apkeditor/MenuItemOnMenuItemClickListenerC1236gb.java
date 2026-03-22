package com.gmail.heagoo.apkeditor;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gb */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1236gb implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1233fz f3517a;

    MenuItemOnMenuItemClickListenerC1236gb(ViewOnCreateContextMenuListenerC1233fz viewOnCreateContextMenuListenerC1233fz) {
        this.f3517a = viewOnCreateContextMenuListenerC1233fz;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        DialogC1229fv.m3088b(this.f3517a.f3513b, this.f3517a.f3512a);
        return true;
    }
}
