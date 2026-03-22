package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1474f;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gp */
/* JADX INFO: loaded from: classes.dex */
public final class C1249gp {

    /* JADX INFO: renamed from: a */
    private WeakReference f3545a;

    /* JADX INFO: renamed from: b */
    private PopupWindow f3546b;

    /* JADX INFO: renamed from: c */
    private String f3547c;

    public C1249gp(InterfaceC1251gr interfaceC1251gr) {
        this.f3545a = new WeakReference(interfaceC1251gr);
    }

    /* JADX INFO: renamed from: a */
    static void m3108a(C1249gp c1249gp, Activity activity, String str, List list) {
        c1249gp.f3547c = str;
        View viewInflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.popup_list, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.lvGroup);
        listView.setAdapter((ListAdapter) new C1246gm(activity, list));
        c1249gp.f3546b = new PopupWindow(viewInflate, C1474f.m3501a(activity), -2);
        listView.setOnItemClickListener(new C1250gq(c1249gp, list));
    }

    /* JADX INFO: renamed from: a */
    public final String m3110a() {
        return this.f3547c;
    }

    /* JADX INFO: renamed from: a */
    public final void m3111a(Activity activity, String str, String str2, View view) {
        new AsyncTaskC1252gs(this, activity, str, str2, view).execute(new Void[0]);
    }

    /* JADX INFO: renamed from: a */
    public final void m3112a(View view) {
        if (this.f3546b != null) {
            this.f3546b.setFocusable(true);
            this.f3546b.setOutsideTouchable(true);
            this.f3546b.setBackgroundDrawable(new BitmapDrawable());
            this.f3546b.showAsDropDown(view, 0, 0);
        }
    }
}
