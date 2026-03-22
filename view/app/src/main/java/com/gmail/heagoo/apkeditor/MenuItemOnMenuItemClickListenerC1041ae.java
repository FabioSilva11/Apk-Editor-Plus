package com.gmail.heagoo.apkeditor;

import android.view.MenuItem;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ae */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1041ae implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1040ad f2995a;

    MenuItemOnMenuItemClickListenerC1041ae(ViewOnCreateContextMenuListenerC1040ad viewOnCreateContextMenuListenerC1040ad) {
        this.f2995a = viewOnCreateContextMenuListenerC1040ad;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(this.f2995a.f2992a));
        this.f2995a.f2993b.f2617e.m3053c(arrayList);
        return true;
    }
}
