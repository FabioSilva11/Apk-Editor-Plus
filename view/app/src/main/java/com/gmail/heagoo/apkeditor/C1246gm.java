package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gm */
/* JADX INFO: loaded from: classes.dex */
public final class C1246gm extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private Context f3540a;

    /* JADX INFO: renamed from: b */
    private List f3541b;

    public C1246gm(Context context, List list) {
        this.f3540a = context;
        this.f3541b = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3541b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f3541b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1247gn c1247gn;
        if (view == null) {
            view = LayoutInflater.from(this.f3540a).inflate(R.layout.popup_item_small, (ViewGroup) null);
            C1247gn c1247gn2 = new C1247gn();
            c1247gn2.f3542a = (TextView) view.findViewById(R.id.groupItem);
            view.setTag(c1247gn2);
            c1247gn = c1247gn2;
        } else {
            c1247gn = (C1247gn) view.getTag();
        }
        c1247gn.f3542a.setText(((C1248go) this.f3541b.get(i)).f3543a);
        return view;
    }
}
