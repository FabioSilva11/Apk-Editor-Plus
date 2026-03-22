package com.gmail.heagoo.appdm;

import android.view.MenuItem;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.q */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1432q implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1431p f4214a;

    MenuItemOnMenuItemClickListenerC1432q(ViewOnCreateContextMenuListenerC1431p viewOnCreateContextMenuListenerC1431p) {
        this.f4214a = viewOnCreateContextMenuListenerC1431p;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.f4214a.f4213c.f4210a.m3396a(this.f4214a.f4211a + "/" + this.f4214a.f4212b.f4243a, (String) null);
        return true;
    }
}
