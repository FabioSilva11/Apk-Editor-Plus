package com.gmail.heagoo.apkeditor;

import android.view.ContextMenu;
import android.view.View;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p070b.C1450a;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ad */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnCreateContextMenuListenerC1040ad implements View.OnCreateContextMenuListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f2992a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ ApkInfoActivity f2993b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ boolean f2994c;

    ViewOnCreateContextMenuListenerC1040ad(ApkInfoActivity apkInfoActivity, int i, boolean z) {
        this.f2993b = apkInfoActivity;
        this.f2992a = i;
        this.f2994c = z;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        ArrayList arrayList = new ArrayList();
        String strM3038a = this.f2993b.f2617e.m3038a(arrayList);
        boolean z = ((C1450a) arrayList.get(this.f2992a)).f4256b;
        if (!this.f2994c) {
            contextMenu.add(0, 1, 0, R.string.delete).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1041ae(this));
        }
        if (!this.f2994c || strM3038a.equals(this.f2993b.f2614b)) {
            contextMenu.add(0, 2, 0, R.string.extract).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1042af(this));
        }
        if (!this.f2994c || strM3038a.equals(this.f2993b.f2614b)) {
            contextMenu.add(0, 3, 0, R.string.replace).setOnMenuItemClickListener(z ? new MenuItemOnMenuItemClickListenerC1043ag(this) : new MenuItemOnMenuItemClickListenerC1044ah(this));
        }
        contextMenu.add(0, 4, 0, R.string.add_a_file).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1045ai(this));
        contextMenu.add(0, 5, 0, R.string.new_folder).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1046aj(this));
        contextMenu.add(0, 6, 0, R.string.external_editor).setOnMenuItemClickListener(new ExtEdCtx(this));
    }
}
