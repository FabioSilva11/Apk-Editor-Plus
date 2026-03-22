package com.gmail.heagoo.apkeditor;

import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import com.gmail.heagoo.apkeditor.pro.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ef */
/* JADX INFO: loaded from: classes.dex */
public final class C1184ef extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a */
    private WeakReference f3329a;

    /* JADX INFO: renamed from: b */
    private WeakReference f3330b;

    /* JADX INFO: renamed from: c */
    private String f3331c;

    /* JADX INFO: renamed from: d */
    private ArrayList f3332d;

    /* JADX INFO: renamed from: e */
    private Set f3333e = new HashSet();

    /* JADX INFO: renamed from: f */
    private int f3334f = R.layout.item_file_selectable;

    public C1184ef(ApkInfoActivity apkInfoActivity, InterfaceC1221fn interfaceC1221fn, String str, ArrayList arrayList) {
        this.f3329a = new WeakReference(apkInfoActivity);
        this.f3330b = new WeakReference(interfaceC1221fn);
        this.f3331c = str;
        this.f3332d = arrayList;
    }

    /* JADX INFO: renamed from: a */
    private static int m2960a(List list, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size() && ((Integer) list.get(i3)).intValue() < i; i3++) {
            i2++;
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public final List m2961a() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f3333e);
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public final void m2962a(ArrayList arrayList, List list) {
        Collections.sort(list);
        HashSet hashSet = new HashSet();
        Iterator it = this.f3333e.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            if (!list.contains(Integer.valueOf(iIntValue))) {
                hashSet.add(Integer.valueOf(iIntValue - m2960a(list, iIntValue)));
            }
        }
        this.f3333e = hashSet;
        this.f3332d = arrayList;
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: b */
    public final void m2963b() {
        for (int i = 0; i < this.f3332d.size(); i++) {
            this.f3333e.add(Integer.valueOf(i));
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: c */
    public final void m2964c() {
        this.f3333e.clear();
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: d */
    public final boolean m2965d() {
        return this.f3333e.size() == this.f3332d.size();
    }

    /* JADX INFO: renamed from: e */
    public final boolean m2966e() {
        return this.f3333e.isEmpty();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3332d.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f3332d.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0109  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.C1184ef.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (z) {
            this.f3333e.add(Integer.valueOf(id));
        } else {
            this.f3333e.remove(Integer.valueOf(id));
        }
        if (this.f3330b != null) {
            ((InterfaceC1221fn) this.f3330b.get()).mo2445b(this.f3333e);
        }
    }
}
