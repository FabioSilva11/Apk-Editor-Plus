package com.gmail.heagoo.apkeditor.p062ac;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ac.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1037a extends BaseAdapter implements Filterable {

    /* JADX INFO: renamed from: a */
    public List f2985a;

    /* JADX INFO: renamed from: b */
    private Context f2986b;

    /* JADX INFO: renamed from: c */
    private String f2987c;

    /* JADX INFO: renamed from: d */
    private String[] f2988d;

    /* JADX INFO: renamed from: e */
    private C1039c f2989e;

    public C1037a(Context context, String str) {
        this.f2986b = context;
        this.f2987c = str;
    }

    /* JADX INFO: renamed from: a */
    private void m2762a() {
        this.f2989e = new C1039c(this, 0 == true ? 1 : 0);
        String string = PreferenceManager.getDefaultSharedPreferences(this.f2986b).getString(this.f2987c, "");
        if (string.equals("")) {
            this.f2988d = new String[0];
        } else {
            this.f2988d = string.split("\n");
        }
        this.f2985a = new ArrayList();
        for (String str : this.f2988d) {
            this.f2985a.add(str);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2764a(String str) {
        if (this.f2985a == null) {
            m2762a();
        }
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(this.f2986b).edit();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (String str2 : this.f2988d) {
            if (!str2.equals(str)) {
                arrayList.add(str2);
                sb.append("\n");
                sb.append(str2);
                if (arrayList.size() >= 32) {
                    break;
                }
            }
        }
        this.f2988d = (String[]) arrayList.toArray(new String[arrayList.size()]);
        editorEdit.putString(this.f2987c, sb.toString());
        editorEdit.commit();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.f2985a == null) {
            m2762a();
        }
        return this.f2985a.size();
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f2989e == null) {
            m2762a();
        }
        return this.f2989e;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.f2985a == null) {
            m2762a();
        }
        return this.f2985a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1038b c1038b;
        View viewInflate;
        String str = (String) this.f2985a.get(i);
        if (view == null) {
            viewInflate = LayoutInflater.from(this.f2986b).inflate(R.layout.item_autocomplete, (ViewGroup) null);
            C1038b c1038b2 = new C1038b();
            c1038b2.f2990a = (TextView) viewInflate.findViewById(R.id.filename);
            viewInflate.setTag(c1038b2);
            c1038b = c1038b2;
        } else {
            c1038b = (C1038b) view.getTag();
            viewInflate = view;
        }
        c1038b.f2990a.setText(str);
        return viewInflate;
    }
}
