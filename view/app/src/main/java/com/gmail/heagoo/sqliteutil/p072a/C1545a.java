package com.gmail.heagoo.sqliteutil.p072a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.sqliteutil.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1545a extends SimpleAdapter {

    /* JADX INFO: renamed from: a */
    private int f4632a;

    /* JADX INFO: renamed from: b */
    private int f4633b;

    public C1545a(Context context, List list, int i, String[] strArr, int[] iArr, boolean z) {
        super(context, list, R.layout.item_sql_raw, strArr, iArr);
        if (z) {
            this.f4632a = -3355444;
            this.f4633b = -5592406;
        } else {
            this.f4632a = -13421773;
            this.f4633b = -11184811;
        }
    }

    @Override // android.widget.SimpleAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        return view2;
    }
}
