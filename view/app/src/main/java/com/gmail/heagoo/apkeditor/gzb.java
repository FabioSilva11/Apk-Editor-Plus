package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class gzb extends BaseAdapter {
    private Context context;
    private List items;

    public gzb(Context context, List list) {
        this.context = context;
        this.items = list;
    }

    public void clear() {
        this.items.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (gzd) this.items.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        gzc gzcVar;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.item_templates, viewGroup, false);
            view.setLongClickable(true);
            gzc gzcVar2 = new gzc(this, view);
            view.setTag(gzcVar2);
            gzcVar = gzcVar2;
        } else {
            gzcVar = (gzc) view.getTag();
        }
        gzd gzdVar = (gzd) getItem(i);
        gzcVar.itemTitle.setText(gzdVar.getTitle());
        gzcVar.itemDescription.setText(gzdVar.getContent());
        return view;
    }
}
