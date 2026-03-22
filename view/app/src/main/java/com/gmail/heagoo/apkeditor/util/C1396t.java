package com.gmail.heagoo.apkeditor.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.t */
/* JADX INFO: loaded from: classes.dex */
final class C1396t extends ArrayAdapter {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ IconPickerPreference f4052a;

    /* JADX INFO: renamed from: b */
    private Context f4053b;

    /* JADX INFO: renamed from: c */
    private List f4054c;

    /* JADX INFO: renamed from: d */
    private int f4055d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1396t(IconPickerPreference iconPickerPreference, Context context, int i, List list) {
        super(context, i, list);
        this.f4052a = iconPickerPreference;
        this.f4053b = context;
        this.f4055d = i;
        this.f4054c = list;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1399w c1399w;
        if (view == null) {
            view = ((LayoutInflater) this.f4053b.getSystemService("layout_inflater")).inflate(this.f4055d, viewGroup, false);
            c1399w = new C1399w((byte) 0);
            c1399w.f4063b = (TextView) view.findViewById(R.id.iconName);
            c1399w.f4062a = (ImageView) view.findViewById(R.id.iconImage);
            c1399w.f4064c = (RadioButton) view.findViewById(R.id.iconRadio);
            view.setTag(c1399w);
        } else {
            c1399w = (C1399w) view.getTag();
        }
        C1398v c1398v = (C1398v) this.f4054c.get(i);
        c1399w.f4063b.setText(c1398v.f4060c);
        c1399w.f4062a.setImageResource(c1398v.f4058a);
        c1399w.f4064c.setChecked(c1398v.f4059b);
        view.setOnClickListener(new ViewOnClickListenerC1397u(this, i));
        return view;
    }
}
