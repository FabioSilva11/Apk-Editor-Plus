package com.p048b.p049a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.b.a.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0933h extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private WeakReference f2303a;

    /* JADX INFO: renamed from: b */
    private List f2304b = new ArrayList();

    public C0933h(Activity activity, List list) {
        this.f2303a = new WeakReference(activity);
        this.f2304b.addAll(list);
    }

    /* JADX INFO: renamed from: a */
    public final void m2047a(ArrayList arrayList) {
        this.f2304b.clear();
        this.f2304b.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f2304b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f2304b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C0934i c0934i;
        C0932g c0932g = (C0932g) this.f2304b.get(i);
        if (view == null) {
            view = LayoutInflater.from((Context) this.f2303a.get()).inflate(R.layout.item_color_value, (ViewGroup) null);
            C0934i c0934i2 = new C0934i((byte) 0);
            c0934i2.f2305a = view.findViewById(R.id.color_view);
            c0934i2.f2306b = (TextView) view.findViewById(R.id.tv_name);
            c0934i2.f2307c = (TextView) view.findViewById(R.id.tv_value);
            view.setTag(c0934i2);
            c0934i = c0934i2;
        } else {
            c0934i = (C0934i) view.getTag();
        }
        try {
            c0934i.f2306b.setText(c0932g.f2299a);
            c0934i.f2307c.setText(c0932g.f2300b);
            if (c0932g.f2302d) {
                c0934i.f2305a.setBackgroundColor(c0932g.f2301c);
            } else {
                c0934i.f2305a.setBackgroundColor(-1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return view;
    }
}
