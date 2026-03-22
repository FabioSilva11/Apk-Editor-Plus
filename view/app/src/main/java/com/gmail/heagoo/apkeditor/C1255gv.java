package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import common.types.StringItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gv */
/* JADX INFO: loaded from: classes.dex */
final class C1255gv extends BaseAdapter implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    /* JADX INFO: renamed from: a */
    private WeakReference f3559a;

    /* JADX INFO: renamed from: b */
    private final List f3560b = new ArrayList();

    /* JADX INFO: renamed from: c */
    private Map f3561c = new HashMap();

    /* JADX INFO: renamed from: d */
    private String f3562d = null;

    /* JADX INFO: renamed from: e */
    private int f3563e = R.layout.item_stringvaluestatic;

    /* JADX INFO: renamed from: f */
    private Activity f3564f;

    C1255gv(Activity activity) {
        this.f3559a = new WeakReference(activity);
        this.f3564f = activity;
    }

    /* JADX INFO: renamed from: a */
    final Map m3115a() {
        return this.f3561c;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void m3116a(int r6, java.lang.String r7) {
        /*
            r5 = this;
            r1 = 0
            java.util.List r2 = r5.f3560b
            monitor-enter(r2)
            if (r6 < 0) goto L4c
            java.util.List r0 = r5.f3560b     // Catch: java.lang.Throwable -> L49
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L49
            if (r6 >= r0) goto L4c
            java.util.List r0 = r5.f3560b     // Catch: java.lang.Throwable -> L49
            java.lang.Object r0 = r0.get(r6)     // Catch: java.lang.Throwable -> L49
            common.types.StringItem r0 = (common.types.StringItem) r0     // Catch: java.lang.Throwable -> L49
            java.lang.String r3 = r0.value     // Catch: java.lang.Throwable -> L49
            boolean r3 = r3.equals(r7)     // Catch: java.lang.Throwable -> L49
            if (r3 != 0) goto L4c
            java.lang.String r1 = r5.f3562d     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L41
            r0.value = r7     // Catch: java.lang.Throwable -> L49
            java.util.Map r1 = r5.f3561c     // Catch: java.lang.Throwable -> L49
            java.lang.String r3 = r5.f3562d     // Catch: java.lang.Throwable -> L49
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L49
            java.util.Map r1 = (java.util.Map) r1     // Catch: java.lang.Throwable -> L49
            if (r1 != 0) goto L3c
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L49
            r1.<init>()     // Catch: java.lang.Throwable -> L49
            java.util.Map r3 = r5.f3561c     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = r5.f3562d     // Catch: java.lang.Throwable -> L49
            r3.put(r4, r1)     // Catch: java.lang.Throwable -> L49
        L3c:
            java.lang.String r0 = r0.name     // Catch: java.lang.Throwable -> L49
            r1.put(r0, r7)     // Catch: java.lang.Throwable -> L49
        L41:
            r0 = 1
        L42:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L48
            r5.notifyDataSetChanged()
        L48:
            return
        L49:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L49
            throw r0
        L4c:
            r0 = r1
            goto L42
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.C1255gv.m3116a(int, java.lang.String):void");
    }

    /* JADX INFO: renamed from: a */
    final void m3117a(String str, List list) {
        synchronized (this.f3560b) {
            this.f3562d = str;
            this.f3560b.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f3560b.add((StringItem) it.next());
            }
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: a */
    final void m3118a(Map map) {
        this.f3561c = map;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        int size;
        synchronized (this.f3560b) {
            size = this.f3560b.size();
        }
        return size;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        Object obj;
        synchronized (this.f3560b) {
            obj = this.f3560b.get(i);
        }
        return obj;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1256gw c1256gw;
        synchronized (this.f3560b) {
            StringItem stringItem = (StringItem) this.f3560b.get(i);
            if (view == null) {
                view = LayoutInflater.from((Context) this.f3559a.get()).inflate(this.f3563e, (ViewGroup) null);
                C1256gw c1256gw2 = new C1256gw((byte) 0);
                c1256gw2.f3565a = (TextView) view.findViewById(R.id.string_name);
                c1256gw2.f3566b = (TextView) view.findViewById(R.id.string_value);
                view.setTag(c1256gw2);
                c1256gw = c1256gw2;
            } else {
                c1256gw = (C1256gw) view.getTag();
            }
            c1256gw.f3565a.setText(stringItem.name);
            c1256gw.f3566b.setText(stringItem.value);
        }
        return view;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        DialogC1257gx dialogC1257gx = new DialogC1257gx((Context) this.f3559a.get(), this, i);
        synchronized (this.f3560b) {
            StringItem stringItem = (StringItem) this.f3560b.get(i);
            dialogC1257gx.m3119a(stringItem.name, stringItem.value);
        }
        dialogC1257gx.show();
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        String str = ((StringItem) this.f3560b.get(i)).name;
        C0985a.m2257c(this.f3564f, str);
        Toast.makeText(this.f3564f, String.format(this.f3564f.getString(R.string.copied_to_clipboard), str), 0).show();
        return true;
    }
}
