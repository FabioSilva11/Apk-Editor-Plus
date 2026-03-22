package com.gmail.heagoo.p070b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.b.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1452c extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    List f4258a = new ArrayList();

    /* JADX INFO: renamed from: b */
    private Context f4259b;

    /* JADX INFO: renamed from: c */
    private String f4260c;

    /* JADX INFO: renamed from: d */
    private String f4261d;

    /* JADX INFO: renamed from: e */
    private InterfaceC1464o f4262e;

    public C1452c(Context context, String str, String str2, InterfaceC1464o interfaceC1464o) {
        this.f4259b = context;
        this.f4260c = str;
        this.f4261d = str2;
        this.f4262e = interfaceC1464o;
        m3469c(str2);
    }

    /* JADX INFO: renamed from: c */
    private void m3469c(String str) {
        synchronized (this.f4258a) {
            File file = new File(str);
            if (!file.exists()) {
                str = this.f4260c;
                file = new File(str);
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                this.f4258a.clear();
                for (File file2 : fileArrListFiles) {
                    C1450a c1450a = new C1450a();
                    c1450a.f4255a = file2.getName();
                    c1450a.f4256b = file2.isDirectory();
                    if (!c1450a.f4256b) {
                        file2.length();
                    }
                    this.f4258a.add(c1450a);
                }
                Collections.sort(this.f4258a, new C1451b());
                if (!str.equals(this.f4260c)) {
                    C1450a c1450a2 = new C1450a();
                    c1450a2.f4255a = "..";
                    c1450a2.f4256b = true;
                    this.f4258a.add(0, c1450a2);
                }
                this.f4261d = str;
            } else if (C0985a.m2260c(str, Environment.getExternalStorageDirectory().getPath())) {
                this.f4258a.clear();
                Environment.getExternalStorageDirectory().getPath();
                C1450a c1450a3 = new C1450a();
                c1450a3.f4255a = C0985a.m2264d(str, Environment.getExternalStorageDirectory().getPath());
                c1450a3.f4256b = true;
                this.f4258a.add(c1450a3);
                if (!str.equals(this.f4260c)) {
                    C1450a c1450a4 = new C1450a();
                    c1450a4.f4255a = "..";
                    c1450a4.f4256b = true;
                    this.f4258a.add(0, c1450a4);
                }
                this.f4261d = str;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m3470a(List list) {
        String str;
        synchronized (this.f4258a) {
            if (list != null) {
                list.addAll(this.f4258a);
                str = this.f4261d;
            } else {
                str = this.f4261d;
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    public final void m3471a(String str) {
        if (!this.f4260c.startsWith(str) || str.equals(this.f4260c)) {
            m3469c(str);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3472b(String str) {
        synchronized (this.f4258a) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f4258a.size()) {
                    break;
                }
                if (((C1450a) this.f4258a.get(i2)).f4255a.equals(str)) {
                    this.f4258a.remove(i2);
                    break;
                }
                i = i2 + 1;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f4258a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f4258a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1453d c1453d;
        C1450a c1450a = (C1450a) this.f4258a.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f4259b).inflate(R.layout.item_file, (ViewGroup) null);
            C1453d c1453d2 = new C1453d((byte) 0);
            c1453d2.f4263a = (ImageView) view.findViewById(R.id.file_icon);
            c1453d2.f4264b = (TextView) view.findViewById(R.id.filename);
            c1453d2.f4265c = (TextView) view.findViewById(R.id.detail1);
            view.setTag(c1453d2);
            c1453d = c1453d2;
        } else {
            c1453d = (C1453d) view.getTag();
        }
        c1453d.f4264b.setText(c1450a.f4255a);
        if (c1450a.f4255a.equals("..")) {
            c1453d.f4263a.setImageResource(R.drawable.ic_file_up);
        } else if (c1450a.f4256b) {
            c1453d.f4263a.setImageResource(R.drawable.ic_file_folder);
        } else {
            Drawable drawableMo2515a = this.f4262e.mo2515a(this.f4261d, c1450a);
            if (drawableMo2515a == null) {
                c1453d.f4263a.setImageResource(R.drawable.ic_file_unknown);
            } else {
                c1453d.f4263a.setImageDrawable(drawableMo2515a);
            }
        }
        String strMo2517b = this.f4262e.mo2517b(this.f4261d, c1450a);
        if (strMo2517b != null) {
            c1453d.f4265c.setText(strMo2517b);
            c1453d.f4265c.setVisibility(0);
        } else {
            c1453d.f4265c.setVisibility(8);
        }
        return view;
    }
}
