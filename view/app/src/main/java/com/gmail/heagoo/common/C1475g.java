package com.gmail.heagoo.common;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

/* JADX INFO: renamed from: com.gmail.heagoo.common.g */
/* JADX INFO: loaded from: classes.dex */
final class C1475g extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private int f4299a;

    /* JADX INFO: renamed from: b */
    private int f4300b = 30;

    /* JADX INFO: renamed from: c */
    private boolean f4301c;

    /* JADX INFO: renamed from: d */
    private ListAdapter f4302d;

    /* JADX INFO: renamed from: e */
    private int f4303e;

    public C1475g(ListAdapter listAdapter, int i) {
        this.f4301c = false;
        this.f4302d = listAdapter;
        this.f4299a = i;
        if (listAdapter.getCount() > this.f4299a) {
            this.f4303e = this.f4299a;
            this.f4301c = false;
        } else {
            this.f4303e = listAdapter.getCount();
            this.f4301c = true;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3505a() {
        if (this.f4301c) {
            return;
        }
        this.f4299a += this.f4300b;
        if (this.f4302d.getCount() > this.f4299a) {
            this.f4301c = false;
            this.f4303e = this.f4299a;
        } else {
            this.f4301c = true;
            this.f4303e = this.f4302d.getCount();
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f4303e;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f4302d.getItem(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return this.f4302d.getItemId(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.f4302d.getView(i, view, viewGroup);
    }
}
