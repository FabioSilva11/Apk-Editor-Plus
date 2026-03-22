package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1483o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.er */
/* JADX INFO: loaded from: classes.dex */
final class C1194er extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private Context f3371a;

    /* JADX INFO: renamed from: b */
    private List f3372b = new ArrayList();

    /* JADX INFO: renamed from: c */
    private List f3373c = new ArrayList();

    C1194er(Context context, String str) {
        this.f3371a = context;
        if (AbstractActivityC1258gy.m3126c(str) || AbstractActivityC1258gy.m3131e(str)) {
            this.f3373c.add(new C1483o(Integer.valueOf(R.drawable.ic_www), Integer.valueOf(R.string.html)));
            this.f3372b.add(0);
        }
        this.f3373c.add(new C1483o(Integer.valueOf(R.drawable.ic_colorize), Integer.valueOf(R.string.colorpad)));
        this.f3372b.add(1);
        if (AbstractActivityC1258gy.m3126c(str) || AbstractActivityC1258gy.m3131e(str)) {
            this.f3373c.add(new C1483o(Integer.valueOf(R.drawable.ic_btn_4), Integer.valueOf(R.string.templates)));
            this.f3372b.add(6);
        }
        this.f3373c.add(new C1483o(Integer.valueOf(R.drawable.ic_delete_lines), Integer.valueOf(R.string.delete_lines)));
        this.f3372b.add(2);
        if (AbstractActivityC1258gy.m3126c(str)) {
            this.f3373c.add(new C1483o(Integer.valueOf(R.drawable.ic_eye), Integer.valueOf(R.string.comment_lines)));
            this.f3372b.add(5);
            this.f3373c.add(new C1483o(Integer.valueOf(R.drawable.ic_java), Integer.valueOf(R.string.java_code)));
            this.f3372b.add(7);
        }
        this.f3373c.add(new C1483o(Integer.valueOf(R.drawable.ic_btn_9), Integer.valueOf(R.string.settings)));
        this.f3372b.add(3);
        this.f3373c.add(new C1483o(Integer.valueOf(R.drawable.ic_help), Integer.valueOf(R.string.help)));
        this.f3372b.add(4);
    }

    /* JADX INFO: renamed from: a */
    public final int m2981a() {
        return this.f3373c.size();
    }

    /* JADX INFO: renamed from: a */
    public final int m2982a(int i) {
        if (i < this.f3372b.size()) {
            return ((Integer) this.f3372b.get(i)).intValue();
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3373c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f3373c.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1195es c1195es;
        if (view == null) {
            view = LayoutInflater.from(this.f3371a).inflate(R.layout.item_more_option, (ViewGroup) null);
            C1195es c1195es2 = new C1195es((byte) 0);
            c1195es2.f3374a = (ImageView) view.findViewById(R.id.menu_icon);
            c1195es2.f3375b = (TextView) view.findViewById(R.id.menu_title);
            view.setTag(c1195es2);
            c1195es = c1195es2;
        } else {
            c1195es = (C1195es) view.getTag();
        }
        C1483o c1483o = (C1483o) this.f3373c.get(i);
        if (((Integer) c1483o.f4310a).intValue() > 0) {
            c1195es.f3374a.setImageResource(((Integer) c1483o.f4310a).intValue());
        } else {
            c1195es.f3374a.setImageBitmap(null);
        }
        c1195es.f3375b.setText(((Integer) c1483o.f4311b).intValue());
        return view;
    }
}
