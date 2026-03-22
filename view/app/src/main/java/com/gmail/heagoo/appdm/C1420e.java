package com.gmail.heagoo.appdm;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1420e extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private WeakReference f4177a;

    /* JADX INFO: renamed from: b */
    private List f4178b;

    /* JADX INFO: renamed from: c */
    private boolean f4179c;

    public C1420e(Activity activity, List list, boolean z) {
        this.f4177a = new WeakReference(activity);
        this.f4178b = list;
        this.f4179c = z;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f4178b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f4178b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1421f c1421f;
        C1422g c1422g = (C1422g) getItem(i);
        if (c1422g == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from((Context) this.f4177a.get()).inflate(R.layout.appdm_item_basicinfo, (ViewGroup) null);
            C1421f c1421f2 = new C1421f();
            c1421f2.f4180a = (TextView) view.findViewById(R.id.tv_title);
            c1421f2.f4181b = (TextView) view.findViewById(R.id.tv_value);
            c1421f2.f4182c = (Button) view.findViewById(R.id.btn_operation);
            view.setTag(c1421f2);
            c1421f = c1421f2;
        } else {
            c1421f = (C1421f) view.getTag();
        }
        c1421f.f4180a.setText(c1422g.f4183a);
        c1421f.f4181b.setText(c1422g.f4184b);
        if (c1422g.f4186d == null) {
            c1421f.f4182c.setVisibility(8);
            return view;
        }
        c1421f.f4182c.setVisibility(0);
        c1421f.f4182c.setText(c1422g.f4185c);
        c1421f.f4182c.setOnClickListener(c1422g.f4186d);
        return view;
    }
}
