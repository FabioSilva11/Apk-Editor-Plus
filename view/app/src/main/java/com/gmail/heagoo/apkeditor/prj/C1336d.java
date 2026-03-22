package com.gmail.heagoo.apkeditor.prj;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.ApkInfoExActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.prj.d */
/* JADX INFO: loaded from: classes.dex */
final class C1336d extends BaseAdapter implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: b */
    private WeakReference f3791b;

    /* JADX INFO: renamed from: c */
    private final List f3792c = new ArrayList();

    /* JADX INFO: renamed from: d */
    private SimpleDateFormat f3793d;

    C1336d(ProjectListActivity projectListActivity, List list) {
        this.f3791b = new WeakReference(projectListActivity);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f3792c.add((C1338f) it.next());
        }
    }

    /* JADX INFO: renamed from: a */
    private String m3225a(C1338f c1338f) {
        return !new File(c1338f.f3800b).exists() ? String.format(((ProjectListActivity) this.f3791b.get()).getString(R.string.prj_error_apk_notfound), c1338f.f3800b) : new File(c1338f.f3801c).exists() ? null : String.format(((ProjectListActivity) this.f3791b.get()).getString(R.string.prj_error_decode_dir_notfound), c1338f.f3801c);
    }

    /* JADX INFO: renamed from: a */
    final int m3226a() {
        return this.f3792c.size();
    }

    /* JADX INFO: renamed from: a */
    final void m3227a(List list) {
        Iterator it = this.f3792c.iterator();
        while (it.hasNext()) {
            if (!list.contains(it.next())) {
                it.remove();
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            C1338f c1338f = (C1338f) it2.next();
            if (!this.f3792c.contains(c1338f)) {
                this.f3792c.add(c1338f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final void m3228a(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            for (C1338f c1338f : this.f3792c) {
                if (str.equals(c1338f.f3800b)) {
                    c1338f.f3803e = (Drawable) entry.getValue();
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3792c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f3792c.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1337e c1337e;
        C1338f c1338f = (C1338f) this.f3792c.get(i);
        if (view == null) {
            view = LayoutInflater.from((Context) this.f3791b.get()).inflate(R.layout.item_project, (ViewGroup) null);
            c1337e = new C1337e((byte) 0);
            c1337e.f3794a = (ImageView) view.findViewById(R.id.app_icon);
            c1337e.f3795b = (TextView) view.findViewById(R.id.app_name);
            c1337e.f3796c = (TextView) view.findViewById(R.id.app_desc1);
            c1337e.f3797d = (TextView) view.findViewById(R.id.app_desc2);
            c1337e.f3798e = view.findViewById(R.id.menu_delete);
            view.setTag(c1337e);
        } else {
            c1337e = (C1337e) view.getTag();
        }
        if (c1338f.f3803e != null) {
            c1337e.f3794a.setImageDrawable(c1338f.f3803e);
        }
        c1337e.f3795b.setText(c1338f.f3799a);
        String strM3225a = m3225a(c1338f);
        String str = strM3225a != null ? strM3225a : c1338f.f3800b;
        if ("".equals(str)) {
            c1337e.f3796c.setVisibility(8);
        } else {
            c1337e.f3796c.setVisibility(0);
            c1337e.f3796c.setText(str);
        }
        if (strM3225a != null) {
            if (c1337e.f3796c.getTag() == null) {
                c1337e.f3796c.setTag(Integer.valueOf(c1337e.f3796c.getCurrentTextColor()));
            }
            c1337e.f3796c.setTextColor(-48060);
        } else {
            Integer num = (Integer) c1337e.f3796c.getTag();
            if (num != null) {
                c1337e.f3796c.setTextColor(num.intValue());
            }
        }
        TextView textView = c1337e.f3797d;
        long j = c1338f.f3802d;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        if (this.f3793d == null) {
            this.f3793d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        textView.setText(this.f3793d.format(calendar.getTime()));
        c1337e.f3797d.setVisibility(0);
        c1337e.f3798e.setVisibility(0);
        c1337e.f3798e.setTag(Integer.valueOf(i));
        c1337e.f3798e.setOnClickListener((View.OnClickListener) this.f3791b.get());
        return view;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String strM3225a = m3225a((C1338f) this.f3792c.get(i));
        if (strM3225a != null) {
            Toast.makeText((Context) this.f3791b.get(), strM3225a, 1).show();
            return;
        }
        Intent intent = new Intent((Context) this.f3791b.get(), (Class<?>) ApkInfoExActivity.class);
        C0985a.m2180a(intent, "projectName", ((C1338f) this.f3792c.get(i)).f3799a);
        ((ProjectListActivity) this.f3791b.get()).startActivity(intent);
    }
}
