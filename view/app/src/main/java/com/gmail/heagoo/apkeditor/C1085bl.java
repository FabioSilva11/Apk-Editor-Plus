package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.bl */
/* JADX INFO: loaded from: classes.dex */
public final class C1085bl extends BaseAdapter {

    /* JADX INFO: renamed from: b */
    private Context f3093b;

    /* JADX INFO: renamed from: c */
    private PackageManager f3094c;

    /* JADX INFO: renamed from: e */
    private int f3095e;

    /* JADX INFO: renamed from: a */
    private List f3092a = new ArrayList();

    /* JADX INFO: renamed from: f */
    private LruCache f3096f = new C1086bm(this, 32);

    public C1085bl(Context context) {
        this.f3093b = context;
        this.f3094c = context.getPackageManager();
    }

    /* JADX INFO: renamed from: a */
    public final void m2816a(List list, String str) {
        String[] stringArray = this.f3093b.getResources().getStringArray(R.array.order_value);
        if (str.equals(stringArray[0]) || !str.equals(stringArray[1])) {
            this.f3095e = C1090bq.f3099a;
        } else {
            this.f3095e = C1090bq.f3100b;
        }
        Locale locale = Locale.getDefault();
        Comparator c1088bo = null;
        switch (C1089bp.f3098a[this.f3095e - 1]) {
            case 1:
                c1088bo = new C1087bn(this, locale);
                break;
            case 2:
                c1088bo = new C1088bo(this);
                break;
        }
        Collections.sort(list, c1088bo);
        synchronized (this.f3092a) {
            this.f3092a.clear();
            this.f3092a.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        int size;
        synchronized (this.f3092a) {
            size = this.f3092a.size();
        }
        return size;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        Object obj;
        synchronized (this.f3092a) {
            obj = this.f3092a.get(i);
        }
        return obj;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1091br c1091br;
        View view2;
        C1084bk c1084bk = (C1084bk) getItem(i);
        if (c1084bk == null) {
            return null;
        }
        if (view == null) {
            View viewInflate = LayoutInflater.from(this.f3093b).inflate(R.layout.item_applist, (ViewGroup) null);
            C1091br c1091br2 = new C1091br();
            c1091br2.f3102a = (ImageView) viewInflate.findViewById(R.id.app_icon);
            c1091br2.f3104c = (TextView) viewInflate.findViewById(R.id.app_name);
            c1091br2.f3103b = (TextView) viewInflate.findViewById(R.id.app_desc1);
            viewInflate.findViewById(R.id.app_desc2);
            viewInflate.setTag(c1091br2);
            c1091br = c1091br2;
            view2 = viewInflate;
        } else {
            c1091br = (C1091br) view.getTag();
            view2 = view;
        }
        try {
            c1091br.f3104c.setText(c1084bk.f3090c);
            c1091br.f3103b.setText(c1084bk.f3089b);
            Drawable drawableLoadIcon = (Drawable) this.f3096f.get(c1084bk.f3089b);
            if (drawableLoadIcon == null) {
                drawableLoadIcon = c1084bk.f3088a.loadIcon(this.f3094c);
                this.f3096f.put(c1084bk.f3089b, drawableLoadIcon);
            }
            c1091br.f3102a.setImageDrawable(drawableLoadIcon);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return view2;
    }
}
