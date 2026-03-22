package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.gmail.heagoo.InterfaceC0968a;
import com.gmail.heagoo.apkeditor.p069ui.EditTextRememberCursor;
import com.gmail.heagoo.apkeditor.p069ui.LayoutObListView;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.neweditor.C1511e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hs */
/* JADX INFO: loaded from: classes.dex */
public final class C1279hs extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private Context f3638a;

    /* JADX INFO: renamed from: c */
    private WeakReference f3640c;

    /* JADX INFO: renamed from: d */
    private int f3641d;

    /* JADX INFO: renamed from: e */
    private float f3642e;

    /* JADX INFO: renamed from: h */
    private C1511e f3645h;

    /* JADX INFO: renamed from: i */
    private TextWatcher f3646i;

    /* JADX INFO: renamed from: j */
    private WeakReference f3647j;

    /* JADX INFO: renamed from: f */
    private int f3643f = -1;

    /* JADX INFO: renamed from: g */
    private boolean f3644g = true;

    /* JADX INFO: renamed from: k */
    private HandlerC1281hu f3648k = new HandlerC1281hu(this);

    /* JADX INFO: renamed from: b */
    private List f3639b = new ArrayList();

    public C1279hs(Context context, LayoutObListView layoutObListView) {
        this.f3638a = context;
        this.f3640c = new WeakReference(layoutObListView);
    }

    /* JADX INFO: renamed from: b */
    private static int m3147b(int i) {
        int i2 = 1;
        while (i >= 10) {
            i /= 10;
            i2++;
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public final CharSequence m3149a() {
        StringBuilder sb = new StringBuilder();
        if (this.f3639b.size() > 0) {
            sb.append((String) this.f3639b.get(0));
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= this.f3639b.size()) {
                    break;
                }
                sb.append("\n");
                sb.append((String) this.f3639b.get(i2));
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m3150a(int i) {
        this.f3643f = i;
    }

    /* JADX INFO: renamed from: a */
    public final void m3151a(int i, float f) {
        this.f3641d = i;
        this.f3642e = f;
    }

    /* JADX INFO: renamed from: a */
    public final void m3152a(TextWatcher textWatcher) {
        this.f3646i = textWatcher;
    }

    /* JADX INFO: renamed from: a */
    public final void m3153a(InterfaceC0968a interfaceC0968a) {
        this.f3647j = new WeakReference(interfaceC0968a);
    }

    /* JADX INFO: renamed from: a */
    public final void m3154a(C1511e c1511e) {
        this.f3645h = c1511e;
    }

    /* JADX INFO: renamed from: a */
    public final void m3155a(List list) {
        this.f3639b.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f3639b.add((String) it.next());
        }
        ((LayoutObListView) this.f3640c.get()).m3306c();
    }

    /* JADX INFO: renamed from: a */
    public final void m3156a(boolean z) {
        this.f3644g = z;
    }

    /* JADX INFO: renamed from: b */
    public final List m3157b() {
        return this.f3639b;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3639b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f3639b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1282hv c1282hv;
        String string;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.f3638a).inflate(R.layout.item_lined_text, (ViewGroup) null);
            c1282hv = new C1282hv();
            c1282hv.f3653a = (TextView) view.findViewById(R.id.line_num);
            c1282hv.f3654b = (EditTextRememberCursor) view.findViewById(R.id.text);
            view.setTag(c1282hv);
        } else {
            c1282hv = (C1282hv) view.getTag();
        }
        Object tag = c1282hv.f3654b.getTag();
        if (tag != null) {
            c1282hv.f3654b.removeTextChangedListener((C1280ht) tag);
        }
        C1280ht c1280ht = new C1280ht(this, i);
        c1282hv.f3654b.addTextChangedListener(c1280ht);
        c1282hv.f3654b.setTag(c1280ht);
        c1282hv.f3654b.m3301a(this.f3647j);
        int i2 = i + 1;
        int iM3147b = m3147b(this.f3639b.size());
        int iM3147b2 = m3147b(i2);
        if (iM3147b2 < iM3147b) {
            StringBuilder sb = new StringBuilder();
            switch (iM3147b - iM3147b2) {
                case 1:
                    str = "0";
                    break;
                case 2:
                    str = "00";
                    break;
                case 3:
                    str = "000";
                    break;
                case 4:
                    str = "0000";
                    break;
                case 5:
                    str = "00000";
                    break;
                case 6:
                    str = "000000";
                    break;
                default:
                    str = "0000000";
                    break;
            }
            string = sb.append(str).append(i2).toString();
        } else {
            string = new StringBuilder().append(i2).toString();
        }
        if (this.f3644g) {
            c1282hv.f3653a.setVisibility(0);
            c1282hv.f3653a.setText(string);
            c1282hv.f3653a.setTextColor(this.f3643f);
        } else {
            c1282hv.f3653a.setVisibility(8);
        }
        c1282hv.f3654b.setTextColor(this.f3643f);
        c1282hv.f3654b.setText((CharSequence) this.f3639b.get(i));
        if (this.f3642e > 0.0f) {
            c1282hv.f3653a.setTextSize(this.f3641d, this.f3642e);
            c1282hv.f3654b.setTextSize(this.f3641d, this.f3642e);
        }
        if (this.f3645h != null) {
            this.f3645h.m3645a(c1282hv.f3654b);
        }
        c1282hv.f3654b.setTag(R.id.text, Integer.valueOf(i));
        c1282hv.f3654b.m3300a(this.f3638a, this.f3640c);
        c1282hv.f3654b.m3299a();
        LayoutObListView layoutObListView = (LayoutObListView) this.f3640c.get();
        if (layoutObListView != null && layoutObListView.m3307d() == i) {
            c1282hv.f3654b.setSelection(layoutObListView.m3308e(), layoutObListView.m3309f());
            c1282hv.f3654b.requestFocus();
            this.f3648k.f3652a = c1282hv.f3654b;
            this.f3648k.removeMessages(0);
            this.f3648k.sendEmptyMessageDelayed(0, 100L);
        }
        return view;
    }
}
