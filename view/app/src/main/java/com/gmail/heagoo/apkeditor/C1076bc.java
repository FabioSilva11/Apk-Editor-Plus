package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1469a;
import com.gmail.heagoo.common.C1470b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.bc */
/* JADX INFO: loaded from: classes.dex */
public final class C1076bc extends BaseAdapter {

    /* JADX INFO: renamed from: b */
    private Context f3066b;

    /* JADX INFO: renamed from: a */
    List f3065a = new ArrayList();

    /* JADX INFO: renamed from: d */
    private LruCache f3067d = new C1077bd(this, 64);

    public C1076bc(Context context) {
        this.f3066b = context;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3065a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f3065a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1078be c1078be;
        String str = (String) this.f3065a.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f3066b).inflate(R.layout.item_file_founded, (ViewGroup) null);
            c1078be = new C1078be((byte) 0);
            c1078be.f3068a = (ImageView) view.findViewById(R.id.file_icon);
            c1078be.f3069b = (TextView) view.findViewById(R.id.filename);
            c1078be.f3070c = (TextView) view.findViewById(R.id.detail1);
            view.setTag(c1078be);
        } else {
            c1078be = (C1078be) view.getTag();
        }
        C1470b c1470b = (C1470b) this.f3067d.get(str);
        if (c1470b == null) {
            try {
                new C1469a();
                c1470b = C1469a.m3488a(this.f3066b, str);
            } catch (Throwable th) {
            }
            if (c1470b == null) {
                c1470b = new C1470b();
                c1470b.f4292c = this.f3066b.getResources().getDrawable(R.drawable.apk_icon);
            }
        }
        this.f3067d.put(str, c1470b);
        c1078be.f3068a.setImageDrawable(c1470b.f4292c);
        if (c1470b.f4290a != null) {
            c1078be.f3069b.setText(c1470b.f4290a);
            c1078be.f3070c.setText(str);
            c1078be.f3070c.setVisibility(0);
        } else {
            c1078be.f3069b.setText(str);
            c1078be.f3070c.setVisibility(8);
        }
        return view;
    }
}
