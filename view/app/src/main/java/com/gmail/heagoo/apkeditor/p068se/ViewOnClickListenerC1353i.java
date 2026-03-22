package com.gmail.heagoo.apkeditor.p068se;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.DialogC1115cn;
import com.gmail.heagoo.apkeditor.InterfaceC1122cu;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1481m;
import com.gmail.heagoo.common.DynamicExpandListView;
import com.gmail.heagoo.imageviewlib.ViewZipImageActivity;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.i */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1353i extends BaseAdapter implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, InterfaceC1122cu {

    /* JADX INFO: renamed from: a */
    private WeakReference f3892a;

    /* JADX INFO: renamed from: b */
    private Activity f3893b;

    /* JADX INFO: renamed from: c */
    private List f3894c;

    /* JADX INFO: renamed from: d */
    private HashMap f3895d;

    /* JADX INFO: renamed from: e */
    private C1370z f3896e;

    /* JADX INFO: renamed from: f */
    private C1345aa f3897f;

    /* JADX INFO: renamed from: g */
    private ZipFile f3898g;

    /* JADX INFO: renamed from: h */
    private Map f3899h = new HashMap();

    /* JADX INFO: renamed from: i */
    private LruCache f3900i = new C1354j(this, 32);

    /* JADX INFO: renamed from: j */
    private int f3901j = R.layout.item_zipfile;

    public ViewOnClickListenerC1353i(DynamicExpandListView dynamicExpandListView, Activity activity, C1370z c1370z) {
        this.f3892a = new WeakReference(dynamicExpandListView);
        this.f3893b = activity;
        this.f3896e = c1370z;
        this.f3894c = c1370z.f3942a;
        this.f3895d = c1370z.f3943b;
        try {
            this.f3898g = new ZipFile(c1370z.m3294b());
            this.f3897f = new C1345aa(this.f3898g);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m3275a(int i) {
        String str = (String) this.f3894c.get(i);
        C1351g c1351g = (C1351g) this.f3895d.get(str);
        Intent intent = new Intent(this.f3893b, (Class<?>) ViewZipImageActivity.class);
        if (c1351g.f3890b == null) {
            C0985a.m2180a(intent, "zipFilePath", this.f3896e.m3294b());
            C0985a.m2180a(intent, "entryName", c1351g.f3891c + "/" + str);
        } else {
            C0985a.m2180a(intent, "imageFilePath", c1351g.f3890b);
        }
        this.f3893b.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m3277b(int i) {
        String str = (String) this.f3894c.get(i);
        ViewOnClickListenerC1365u.m3282a(this.f3893b, this.f3896e.m3294b(), ((C1351g) this.f3895d.get(str)).f3891c + "/" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m3279c(int i) {
        new DialogC1115cn(this.f3893b, this, null, (String) this.f3894c.get(i), this.f3893b.getString(R.string.select_file_replace)).show();
    }

    /* JADX INFO: renamed from: a */
    public final Map m3281a() {
        return this.f3899h;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) {
        C1351g c1351g = (C1351g) this.f3895d.get(str2);
        c1351g.f3890b = str;
        Iterator it = c1351g.f3889a.iterator();
        while (it.hasNext()) {
            this.f3899h.put(((String) it.next()) + "/" + str2, str);
        }
        this.f3900i.remove(str2);
        DynamicExpandListView dynamicExpandListView = (DynamicExpandListView) this.f3892a.get();
        if (dynamicExpandListView != null) {
            dynamicExpandListView.m3486a();
        }
        ((SimpleEditActivity) this.f3893b).m3253a();
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final boolean mo2503a(String str, String str2) {
        return ViewOnClickListenerC1365u.m3283a(str);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: b */
    public final String mo2504b(String str, String str2) {
        return null;
    }

    protected final void finalize() throws Throwable {
        if (this.f3898g != null) {
            try {
                this.f3898g.close();
            } catch (IOException e) {
            }
        }
        super.finalize();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3895d.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f3895d.get(Integer.valueOf(i));
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1364t c1364t;
        Bitmap bitmapM3261a;
        String str = (String) this.f3894c.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f3893b).inflate(this.f3901j, (ViewGroup) null);
            C1364t c1364t2 = new C1364t();
            c1364t2.f3914a = (ImageView) view.findViewById(R.id.file_icon);
            c1364t2.f3915b = (TextView) view.findViewById(R.id.filename);
            c1364t2.f3916c = (TextView) view.findViewById(R.id.detail1);
            c1364t2.f3917d = view.findViewById(R.id.menu_edit);
            c1364t2.f3918e = view.findViewById(R.id.menu_save);
            view.setTag(c1364t2);
            c1364t = c1364t2;
        } else {
            c1364t = (C1364t) view.getTag();
        }
        c1364t.f3915b.setText(str);
        c1364t.f3917d.setId(i);
        c1364t.f3917d.setOnClickListener(this);
        c1364t.f3918e.setId(this.f3894c.size() + i);
        c1364t.f3918e.setOnClickListener(this);
        C1351g c1351g = (C1351g) this.f3895d.get(str);
        C1359o c1359o = (C1359o) this.f3900i.get(str);
        if (c1359o != null) {
            bitmapM3261a = c1359o.f3907a;
        } else {
            bitmapM3261a = c1351g.f3890b == null ? this.f3897f.m3261a(c1351g.f3891c + "/" + str, 32, 32) : new C1481m().m3518a(c1351g.f3890b, 32, 32);
            C1359o c1359o2 = new C1359o();
            c1359o2.f3907a = bitmapM3261a;
            this.f3900i.put(str, c1359o2);
        }
        c1364t.f3914a.setImageBitmap(bitmapM3261a);
        c1364t.f3916c.setText(c1351g.m3273a());
        return view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id < this.f3894c.size()) {
            m3279c(id);
        } else if (id < (this.f3894c.size() << 1)) {
            m3277b(id - this.f3894c.size());
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        m3275a(i);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        adapterView.setOnCreateContextMenuListener(new ViewOnCreateContextMenuListenerC1355k(this, i));
        return false;
    }
}
