package com.gmail.heagoo.apkeditor;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ft */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1227ft implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1224fq f3488a;

    MenuItemOnMenuItemClickListenerC1227ft(ViewOnCreateContextMenuListenerC1224fq viewOnCreateContextMenuListenerC1224fq) {
        this.f3488a = viewOnCreateContextMenuListenerC1224fq;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        DialogC1222fo.m3080c(this.f3488a.f3485b, this.f3488a.f3484a);
        return true;
    }
}
