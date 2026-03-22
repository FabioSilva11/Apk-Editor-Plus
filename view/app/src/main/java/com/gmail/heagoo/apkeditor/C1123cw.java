package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.cw */
/* JADX INFO: loaded from: classes.dex */
final class C1123cw extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private WeakReference f3185a;

    /* JADX INFO: renamed from: b */
    private List f3186b;

    /* JADX INFO: renamed from: c */
    private List f3187c = new ArrayList();

    C1123cw(Context context, List list) {
        this.f3185a = new WeakReference(context);
        this.f3186b = list;
    }

    /* JADX INFO: renamed from: a */
    public final void m2859a(List list) {
        this.f3187c = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3186b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f3186b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1124cx c1124cx;
        if (view == null) {
            view = LayoutInflater.from((Context) this.f3185a.get()).inflate(R.layout.popup_item_big, (ViewGroup) null);
            c1124cx = new C1124cx();
            view.setTag(c1124cx);
            c1124cx.f3189b = (TextView) view.findViewById(R.id.groupItem);
            c1124cx.f3188a = (ImageView) view.findViewById(R.id.checkImage);
        } else {
            c1124cx = (C1124cx) view.getTag();
        }
        c1124cx.f3189b.setText((CharSequence) this.f3186b.get(i));
        c1124cx.f3188a.setVisibility(this.f3187c.contains(Integer.valueOf(i)) ? 0 : 4);
        return view;
    }
}
