package com.gmail.heagoo.apkeditor.p068se;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.f */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1350f implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1348d f3888a;

    MenuItemOnMenuItemClickListenerC1350f(ViewOnCreateContextMenuListenerC1348d viewOnCreateContextMenuListenerC1348d) {
        this.f3888a = viewOnCreateContextMenuListenerC1348d;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.f3888a.f3886b.m3267b(this.f3888a.f3885a);
        return true;
    }
}
