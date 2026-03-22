package com.gmail.heagoo.apkeditor.p069ui;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ListView;
import com.gmail.heagoo.neweditor.InterfaceC1525s;

/* JADX INFO: loaded from: classes.dex */
public class LayoutObListView extends ListView implements InterfaceC1525s {

    /* JADX INFO: renamed from: a */
    private boolean f3957a;

    /* JADX INFO: renamed from: b */
    private boolean f3958b;

    /* JADX INFO: renamed from: c */
    private int f3959c;

    /* JADX INFO: renamed from: d */
    private int f3960d;

    /* JADX INFO: renamed from: e */
    private int f3961e;

    public LayoutObListView(Context context) {
        super(context);
        this.f3957a = false;
        this.f3959c = -1;
    }

    public LayoutObListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3957a = false;
        this.f3959c = -1;
    }

    public LayoutObListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3957a = false;
        this.f3959c = -1;
    }

    @RequiresApi(21)
    public LayoutObListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3957a = false;
        this.f3959c = -1;
    }

    /* JADX INFO: renamed from: a */
    public final void m3302a(int i, int i2, int i3) {
        if (i >= getFirstVisiblePosition() && i <= getLastVisiblePosition()) {
            this.f3959c = i;
            this.f3960d = i2;
            this.f3961e = i3;
        }
    }

    @Override // com.gmail.heagoo.neweditor.InterfaceC1525s
    /* JADX INFO: renamed from: a */
    public final void mo3303a(boolean z) {
        this.f3958b = z;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3304a() {
        return this.f3957a;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3305b() {
        return this.f3958b;
    }

    /* JADX INFO: renamed from: c */
    public final void m3306c() {
        this.f3959c = 0;
        this.f3960d = 0;
        this.f3961e = 0;
    }

    /* JADX INFO: renamed from: d */
    public final int m3307d() {
        return this.f3959c;
    }

    /* JADX INFO: renamed from: e */
    public final int m3308e() {
        return this.f3960d;
    }

    /* JADX INFO: renamed from: f */
    public final int m3309f() {
        return this.f3961e;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        this.f3957a = true;
        super.layoutChildren();
        this.f3957a = false;
    }
}
