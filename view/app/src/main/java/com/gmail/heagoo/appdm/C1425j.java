package com.gmail.heagoo.appdm;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.appdm.util.C1444j;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1425j extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private WeakReference f4201a;

    /* JADX INFO: renamed from: b */
    private List f4202b;

    /* JADX INFO: renamed from: c */
    private boolean f4203c;

    public C1425j(Activity activity, List list, boolean z) {
        this.f4201a = new WeakReference(activity);
        this.f4202b = list;
        this.f4203c = z;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f4202b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f4202b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1426k c1426k;
        C1444j c1444j = (C1444j) getItem(i);
        if (c1444j == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from((Context) this.f4201a.get()).inflate(R.layout.appdm_item_nameandpath, (ViewGroup) null);
            C1426k c1426k2 = new C1426k();
            c1426k2.f4204a = (TextView) view.findViewById(R.id.tv_first);
            c1426k2.f4205b = (TextView) view.findViewById(R.id.tv_second);
            view.setTag(c1426k2);
            c1426k = c1426k2;
        } else {
            c1426k = (C1426k) view.getTag();
        }
        c1426k.f4204a.setText(c1444j.f4248a);
        c1426k.f4205b.setText(c1444j.f4249b);
        return view;
    }
}
