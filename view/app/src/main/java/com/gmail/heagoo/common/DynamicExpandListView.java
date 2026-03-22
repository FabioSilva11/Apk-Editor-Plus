package com.gmail.heagoo.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public class DynamicExpandListView extends ListView implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a */
    private C1475g f4288a;

    /* JADX INFO: renamed from: b */
    private int f4289b;

    public DynamicExpandListView(Context context) {
        super(context);
        this.f4289b = 30;
        setOnScrollListener(this);
    }

    public DynamicExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4289b = 30;
        setOnScrollListener(this);
    }

    public DynamicExpandListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4289b = 30;
        setOnScrollListener(this);
    }

    /* JADX INFO: renamed from: a */
    public final void m3486a() {
        if (this.f4288a != null) {
            this.f4288a.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i + i2 < i3 || this.f4288a == null) {
            return;
        }
        this.f4288a.m3505a();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        this.f4288a = new C1475g(listAdapter, this.f4289b);
        super.setAdapter((ListAdapter) this.f4288a);
    }
}
