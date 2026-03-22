package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.dt */
/* JADX INFO: loaded from: classes.dex */
final class C1141dt extends BaseAdapter implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, InterfaceC1126cz, InterfaceC1313iz {

    /* JADX INFO: renamed from: a */
    private String f3225a;

    /* JADX INFO: renamed from: d */
    private WeakReference f3228d;

    /* JADX INFO: renamed from: e */
    private InterfaceC1126cz f3229e;

    /* JADX INFO: renamed from: b */
    private List f3226b = new ArrayList();

    /* JADX INFO: renamed from: c */
    private final List f3227c = new ArrayList();

    /* JADX INFO: renamed from: f */
    private int f3230f = R.layout.item_manifestline;

    C1141dt(Activity activity, String str, InterfaceC1126cz interfaceC1126cz) {
        this.f3228d = new WeakReference(activity);
        this.f3229e = interfaceC1126cz;
        this.f3225a = str;
        m2872b();
    }

    /* JADX INFO: renamed from: a */
    public static void m2870a(Context context) {
        new AlertDialog.Builder(context).setTitle(R.string.not_available).setMessage(R.string.promote_msg).setPositiveButton(R.string.view_pro_version, new DialogInterfaceOnClickListenerC1143dv(context)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m2871a(C1141dt c1141dt, C1135dj c1135dj) {
        synchronized (c1141dt.f3227c) {
            c1135dj.f3214f = !c1135dj.f3214f;
            c1141dt.m2875d();
        }
        c1141dt.notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: b */
    private void m2872b() {
        BufferedReader bufferedReader;
        int i;
        try {
            bufferedReader = new BufferedReader(new FileReader(this.f3225a));
            i = 0;
        } catch (Exception e) {
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            C1135dj c1135dj = new C1135dj(i, line, "\t");
            this.f3226b.add(c1135dj);
            this.f3227c.add(c1135dj);
            i++;
            m2874c();
        }
        bufferedReader.close();
        m2874c();
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ void m2873b(Context context) {
        String str = context.getPackageName() + ".pro";
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
        } catch (ActivityNotFoundException e) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + str)));
        }
    }

    /* JADX INFO: renamed from: c */
    private void m2874c() {
        try {
            Stack stack = new Stack();
            for (int i = 0; i < this.f3227c.size(); i++) {
                C1135dj c1135dj = (C1135dj) this.f3227c.get(i);
                if (c1135dj.f3211c >= 0) {
                    if (c1135dj.f3210b.endsWith("/>")) {
                        c1135dj.f3212d = c1135dj.f3209a;
                        c1135dj.f3213e = c1135dj.f3209a;
                    } else if (c1135dj.f3210b.startsWith("</")) {
                        C1135dj c1135dj2 = (C1135dj) stack.pop();
                        c1135dj2.f3213e = c1135dj.f3209a;
                        c1135dj.f3212d = c1135dj2.f3209a;
                        c1135dj.f3213e = c1135dj.f3209a;
                    } else {
                        c1135dj.f3212d = c1135dj.f3209a;
                        stack.push(c1135dj);
                    }
                }
            }
        } catch (EmptyStackException e) {
            for (int i2 = 0; i2 < this.f3227c.size(); i2++) {
                ((C1135dj) this.f3227c.get(i2)).f3211c = 0;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m2875d() {
        this.f3227c.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3226b.size()) {
                return;
            }
            C1135dj c1135dj = (C1135dj) this.f3226b.get(i2);
            if (!c1135dj.f3215g) {
                this.f3227c.add(c1135dj);
                if (c1135dj.f3214f && c1135dj.f3213e > i2) {
                    i2 = c1135dj.f3213e;
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1126cz
    /* JADX INFO: renamed from: a */
    public final String mo2427a(C1135dj c1135dj) {
        boolean z;
        boolean z2;
        String strM2865a = c1135dj.m2865a();
        if ("manifest".equals(strM2865a) || "application".equals(strM2865a)) {
            z = false;
        } else if ("activity".equals(strM2865a) || "intent-filter".equals(strM2865a)) {
            int i = c1135dj.f3212d;
            while (true) {
                int i2 = i;
                if (i2 >= c1135dj.f3213e) {
                    z2 = false;
                    break;
                }
                C1135dj c1135dj2 = (C1135dj) this.f3226b.get(i2);
                if ("action".equals(c1135dj2.m2865a()) && c1135dj2.f3210b.contains("android.intent.action.MAIN")) {
                    z2 = true;
                    break;
                }
                i = i2 + 1;
            }
            z = !z2;
        } else {
            z = "action".equals(strM2865a) ? !c1135dj.f3210b.contains("android.intent.action.MAIN") : ("category".equals(strM2865a) && c1135dj.f3210b.contains("android.intent.category.LAUNCHER")) ? false : true;
        }
        if (!z) {
            return ((Activity) this.f3228d.get()).getResources().getString(R.string.section_undeletable);
        }
        int i3 = c1135dj.f3212d;
        int i4 = c1135dj.f3213e;
        StringBuilder sb = new StringBuilder();
        synchronized (this.f3227c) {
            for (int i5 = 0; i5 < this.f3226b.size(); i5++) {
                C1135dj c1135dj3 = (C1135dj) this.f3226b.get(i5);
                if (c1135dj3.f3209a >= i3 && c1135dj3.f3209a <= i4) {
                    c1135dj3.f3215g = true;
                }
                if (!c1135dj3.f3215g) {
                    sb.append(c1135dj3.f3210b);
                    sb.append('\n');
                }
            }
            m2875d();
        }
        notifyDataSetChanged();
        if (this.f3229e != null) {
            this.f3229e.mo2461i(sb.toString());
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    final void m2876a() {
        synchronized (this.f3227c) {
            this.f3226b.clear();
            this.f3227c.clear();
            m2872b();
        }
        notifyDataSetChanged();
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1313iz
    /* JADX INFO: renamed from: a */
    public final void mo2877a(int i, String str) {
        StringBuilder sb = new StringBuilder();
        synchronized (this) {
            for (C1135dj c1135dj : this.f3226b) {
                if (c1135dj.f3209a == i) {
                    c1135dj.f3210b = str;
                }
                if (!c1135dj.f3215g) {
                    sb.append(c1135dj.f3210b);
                    sb.append('\n');
                }
            }
            Iterator it = this.f3227c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1135dj c1135dj2 = (C1135dj) it.next();
                if (c1135dj2.f3209a == i) {
                    c1135dj2.f3210b = str;
                    break;
                }
            }
        }
        notifyDataSetChanged();
        if (this.f3229e != null) {
            this.f3229e.mo2461i(sb.toString());
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3227c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f3227c.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1135dj c1135dj;
        C1144dw c1144dw;
        synchronized (this.f3227c) {
            c1135dj = (C1135dj) this.f3227c.get(i);
        }
        if (view == null) {
            view = LayoutInflater.from((Context) this.f3228d.get()).inflate(this.f3230f, (ViewGroup) null);
            c1144dw = new C1144dw((byte) 0);
            c1144dw.f3235b = (ImageView) view.findViewById(R.id.collapse_icon);
            c1144dw.f3234a = (TextView) view.findViewById(R.id.line_data);
            view.setTag(c1144dw);
        } else {
            c1144dw = (C1144dw) view.getTag();
        }
        c1144dw.f3234a.setText(c1135dj.f3210b);
        if (c1135dj.f3211c > 0) {
            c1144dw.f3235b.setVisibility(0);
            ImageView imageView = c1144dw.f3235b;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(c1135dj.f3211c * 48, 48, Bitmap.Config.ALPHA_8);
            if (c1135dj.f3213e != c1135dj.f3209a) {
                new Canvas(bitmapCreateBitmap).drawBitmap(!c1135dj.f3214f ? BitmapFactory.decodeResource(((Activity) this.f3228d.get()).getResources(), R.drawable.arrow_down) : BitmapFactory.decodeResource(((Activity) this.f3228d.get()).getResources(), R.drawable.arrow_right), r4 - 40, 8.0f, new Paint());
            }
            imageView.setImageBitmap(bitmapCreateBitmap);
            c1144dw.f3235b.setOnClickListener(new ViewOnClickListenerC1142du(this, c1135dj));
        } else {
            c1144dw.f3235b.setVisibility(8);
        }
        return view;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1126cz
    /* JADX INFO: renamed from: i */
    public final void mo2461i(String str) {
        if (this.f3229e != null) {
            this.f3229e.mo2461i(str);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C1135dj c1135dj = null;
        try {
            c1135dj = (C1135dj) this.f3227c.get(i);
        } catch (Exception e) {
        }
        if (c1135dj != null) {
            new DialogC1312iy((Context) this.f3228d.get(), this, c1135dj.f3209a, c1135dj.f3210b).show();
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        C1135dj c1135dj = null;
        try {
            c1135dj = (C1135dj) this.f3227c.get(i);
        } catch (Exception e) {
        }
        new DialogC1145dx((Activity) this.f3228d.get(), this.f3225a, c1135dj, this).show();
        return true;
    }
}
