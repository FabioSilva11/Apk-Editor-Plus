package com.gmail.heagoo.apkeditor;

import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
final class ExtEdCtx implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1040ad f2698a;

    ExtEdCtx(ViewOnCreateContextMenuListenerC1040ad viewOnCreateContextMenuListenerC1040ad) {
        this.f2698a = viewOnCreateContextMenuListenerC1040ad;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.f2698a.f2993b.m2441aa(this.f2698a.f2992a);
        return true;
    }
}
