package com.gmail.heagoo.apkeditor;

import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.af */
/* JADX INFO: loaded from: classes.dex */
final class MenuItemOnMenuItemClickListenerC1042af implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ViewOnCreateContextMenuListenerC1040ad f2996a;

    MenuItemOnMenuItemClickListenerC1042af(ViewOnCreateContextMenuListenerC1040ad viewOnCreateContextMenuListenerC1040ad) {
        this.f2996a = viewOnCreateContextMenuListenerC1040ad;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(this.f2996a.f2992a));
        this.f2996a.f2993b.m2437a((List) arrayList);
        return true;
    }
}
