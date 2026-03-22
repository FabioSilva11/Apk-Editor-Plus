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
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.C1110cg;
import com.gmail.heagoo.apkeditor.DialogC1115cn;
import com.gmail.heagoo.apkeditor.DialogC1201ey;
import com.gmail.heagoo.apkeditor.InterfaceC1122cu;
import com.gmail.heagoo.apkeditor.InterfaceC1208fa;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1481m;
import com.gmail.heagoo.imageviewlib.ViewZipImageActivity;
import com.gmail.heagoo.p054a.C0969a;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.u */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1365u extends BaseAdapter implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, InterfaceC1122cu, InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private Activity f3919a;

    /* JADX INFO: renamed from: b */
    private InterfaceC1352h f3920b;

    /* JADX INFO: renamed from: c */
    private String f3921c;

    /* JADX INFO: renamed from: d */
    private List f3922d;

    /* JADX INFO: renamed from: e */
    private Map f3923e;

    /* JADX INFO: renamed from: f */
    private Map f3924f;

    /* JADX INFO: renamed from: g */
    private boolean f3925g;

    /* JADX INFO: renamed from: h */
    private LruCache f3926h;

    /* JADX INFO: renamed from: i */
    private Comparator f3927i;

    /* JADX INFO: renamed from: j */
    private C1370z f3928j;

    /* JADX INFO: renamed from: k */
    private ZipFile f3929k;

    /* JADX INFO: renamed from: l */
    private C1345aa f3930l;

    /* JADX INFO: renamed from: m */
    private int f3931m;

    /* JADX INFO: renamed from: n */
    private boolean f3932n;

    /* JADX INFO: renamed from: o */
    private String f3933o;

    /* JADX INFO: renamed from: p */
    private String f3934p;

    public ViewOnClickListenerC1365u(Activity activity, InterfaceC1352h interfaceC1352h, C1370z c1370z) {
        this.f3924f = new HashMap();
        this.f3925g = false;
        this.f3926h = new C1366v(this, 32);
        this.f3927i = new C1367w(this);
        this.f3919a = activity;
        this.f3921c = "/";
        this.f3920b = interfaceC1352h;
        this.f3923e = c1370z.f3944c;
        this.f3928j = c1370z;
        this.f3922d = (List) this.f3923e.get(this.f3921c);
        Collections.sort(this.f3922d, this.f3927i);
        this.f3931m = R.layout.item_zipfile;
        try {
            this.f3929k = new ZipFile(c1370z.m3294b());
            this.f3930l = new C1345aa(this.f3929k);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ViewOnClickListenerC1365u(Activity activity, InterfaceC1352h interfaceC1352h, C1370z c1370z, boolean z) {
        this(activity, interfaceC1352h, c1370z);
        this.f3925g = true;
    }

    /* JADX INFO: renamed from: a */
    public static void m3282a(Activity activity, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        C1110cg c1110cg = new C1110cg();
        c1110cg.f3158c = true;
        c1110cg.f3157b = false;
        c1110cg.f3156a = str2;
        arrayList.add(c1110cg);
        new DialogC1115cn(activity, new C1368x(activity, str, arrayList), null, null, activity.getString(R.string.select_folder), true, false, false, null).show();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3283a(String str) {
        return str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".jpeg") || str.endsWith(".gif");
    }

    /* JADX INFO: renamed from: f */
    private boolean m3284f() {
        return "/".equals(this.f3921c);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() throws IOException {
        InputStream inputStream;
        this.f3932n = false;
        if (this.f3929k != null) {
            String str = (String) this.f3924f.get(this.f3933o);
            if (str != null) {
                inputStream = new FileInputStream(str);
            } else {
                inputStream = this.f3929k.getInputStream(this.f3929k.getEntry(this.f3933o));
            }
            this.f3934p = C0985a.m2263d(this.f3919a, "tmp") + this.f3933o.replace('/', '_');
            FileOutputStream fileOutputStream = new FileOutputStream(this.f3934p);
            C0969a c0969a = new C0969a();
            if (inputStream != null) {
                this.f3932n = c0969a.m2120a(inputStream, fileOutputStream);
            }
            C0985a.m2212a((Closeable) inputStream);
            C0985a.m2212a(fileOutputStream);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) {
        this.f3924f.put(str2, str);
        this.f3926h.remove(str2);
        notifyDataSetChanged();
        ((SimpleEditActivity) this.f3919a).m3253a();
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final boolean mo2503a(String str, String str2) {
        int iIndexOf = str2.indexOf(46, str2.lastIndexOf(47) + 1);
        if (iIndexOf != -1) {
            return str.endsWith(str2.substring(iIndexOf));
        }
        return true;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: b */
    public final String mo2504b(String str, String str2) {
        return null;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        if (!this.f3932n) {
            Toast.makeText(this.f3919a, String.format(this.f3919a.getString(R.string.failed_to_parse_xml), this.f3933o), 1).show();
            return;
        }
        Intent intentM2177a = C0985a.m2177a(this.f3919a, this.f3934p, this.f3928j != null ? this.f3928j.m3294b() : null);
        C0985a.m2180a(intentM2177a, "displayFileName", this.f3933o);
        C0985a.m2180a(intentM2177a, "extraString", this.f3933o);
        this.f3919a.startActivityForResult(intentM2177a, 0);
    }

    /* JADX INFO: renamed from: c */
    public final String m3285c() {
        return this.f3921c;
    }

    /* JADX INFO: renamed from: c */
    public final void m3286c(String str, String str2) {
        this.f3924f.put(str, str2);
    }

    /* JADX INFO: renamed from: d */
    public final Map m3287d() {
        return this.f3924f;
    }

    /* JADX INFO: renamed from: e */
    public final void m3288e() {
        try {
            if (this.f3929k != null) {
                this.f3929k.close();
            }
        } catch (IOException e) {
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (m3284f()) {
            return this.f3922d.size();
        }
        if (this.f3922d != null) {
            return this.f3922d.size() + 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (m3284f()) {
            return this.f3922d.get(i);
        }
        if (this.f3922d != null) {
            return this.f3922d.get(i - 1);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1364t c1364t;
        boolean z;
        if (this.f3922d == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f3919a).inflate(this.f3931m, (ViewGroup) null);
            c1364t = new C1364t();
            c1364t.f3914a = (ImageView) view.findViewById(R.id.file_icon);
            c1364t.f3915b = (TextView) view.findViewById(R.id.filename);
            c1364t.f3916c = (TextView) view.findViewById(R.id.detail1);
            c1364t.f3917d = view.findViewById(R.id.menu_edit);
            c1364t.f3918e = view.findViewById(R.id.menu_save);
            view.setTag(c1364t);
        } else {
            c1364t = (C1364t) view.getTag();
        }
        if (!m3284f()) {
            i--;
        }
        if (i >= 0) {
            C1369y c1369y = (C1369y) this.f3922d.get(i);
            c1364t.f3915b.setText(c1369y.f3939a);
            if (c1369y.f3940b) {
                c1364t.f3914a.setImageResource(R.drawable.ic_file_folder);
                z = false;
            } else {
                String str = c1369y.f3939a;
                if ((str.endsWith(".xml") || str.endsWith(".dex") || str.endsWith(".MF") || str.endsWith(".SF") || str.endsWith(".RSA") || str.endsWith(".so")) || !m3283a(c1369y.f3939a)) {
                    c1364t.f3914a.setImageResource(R.drawable.ic_file_unknown);
                    z = true;
                } else {
                    String str2 = this.f3921c.substring(1) + c1369y.f3939a;
                    ImageView imageView = c1364t.f3914a;
                    Bitmap bitmapM3261a = (Bitmap) this.f3926h.get(str2);
                    if (bitmapM3261a == null) {
                        String str3 = (String) this.f3924f.get(str2);
                        bitmapM3261a = str3 == null ? this.f3930l.m3261a(str2, 32, 32) : new C1481m().m3518a(str3, 32, 32);
                        if (bitmapM3261a != null) {
                            this.f3926h.put(str2, bitmapM3261a);
                        }
                    }
                    imageView.setImageBitmap(bitmapM3261a);
                    z = true;
                }
            }
            if (!z || this.f3925g) {
                c1364t.f3917d.setVisibility(8);
                c1364t.f3918e.setVisibility(8);
            } else {
                c1364t.f3917d.setVisibility(0);
                c1364t.f3917d.setId(i);
                c1364t.f3917d.setOnClickListener(this);
                c1364t.f3918e.setVisibility(0);
                c1364t.f3918e.setId(this.f3922d.size() + i);
                c1364t.f3918e.setOnClickListener(this);
            }
        } else {
            c1364t.f3915b.setText("..");
            c1364t.f3914a.setImageResource(R.drawable.ic_file_up);
            c1364t.f3917d.setVisibility(8);
            c1364t.f3918e.setVisibility(8);
        }
        c1364t.f3916c.setVisibility(8);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int size;
        int id = view.getId();
        if (id < this.f3922d.size()) {
            if (id < this.f3922d.size()) {
                new DialogC1115cn(this.f3919a, this, null, this.f3921c.substring(1) + ((C1369y) this.f3922d.get(id)).f3939a, this.f3919a.getString(R.string.select_file_replace)).show();
            }
        } else {
            if (id >= this.f3922d.size() * 2 || (size = id - this.f3922d.size()) >= this.f3922d.size()) {
                return;
            }
            m3282a(this.f3919a, this.f3928j.m3294b(), this.f3921c.substring(1) + ((C1369y) this.f3922d.get(size)).f3939a);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        boolean z;
        boolean z2 = false;
        if (!m3284f()) {
            if (i == 0) {
                String str = this.f3921c;
                this.f3921c = str.substring(0, str.lastIndexOf(47, str.length() - 2) + 1);
                this.f3922d = (List) this.f3923e.get(this.f3921c);
                z2 = true;
                i = -1;
            } else {
                i--;
            }
        }
        if (i != -1) {
            C1369y c1369y = (C1369y) this.f3922d.get(i);
            if (c1369y.f3940b) {
                this.f3921c += c1369y.f3939a + "/";
                this.f3922d = (List) this.f3923e.get(this.f3921c);
                z = true;
            } else if (m3283a(c1369y.f3939a)) {
                String str2 = this.f3921c.substring(1) + c1369y.f3939a;
                String str3 = (String) this.f3924f.get(str2);
                Intent intent = new Intent(this.f3919a, (Class<?>) ViewZipImageActivity.class);
                if (str3 == null) {
                    C0985a.m2180a(intent, "zipFilePath", this.f3928j.m3294b());
                    C0985a.m2180a(intent, "entryName", str2);
                } else {
                    C0985a.m2180a(intent, "imageFilePath", str3);
                }
                this.f3919a.startActivity(intent);
                z = z2;
            } else {
                if (this.f3925g && c1369y.f3939a.endsWith(".xml")) {
                    this.f3933o = this.f3921c.substring(1) + c1369y.f3939a;
                    new DialogC1201ey(this.f3919a, this, -1).show();
                }
                z = z2;
            }
        } else {
            z = z2;
        }
        if (z) {
            this.f3920b.mo2486a(this.f3921c);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        return false;
    }
}
