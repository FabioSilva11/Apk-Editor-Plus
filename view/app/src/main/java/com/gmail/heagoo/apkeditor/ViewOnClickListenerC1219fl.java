package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fl */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1219fl implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private WeakReference f3461a;

    /* JADX INFO: renamed from: b */
    private String f3462b;

    /* JADX INFO: renamed from: c */
    private LinearLayout f3463c;

    /* JADX INFO: renamed from: d */
    private HorizontalScrollView f3464d;

    /* JADX INFO: renamed from: e */
    private List f3465e = new ArrayList();

    public ViewOnClickListenerC1219fl(ApkInfoActivity apkInfoActivity, String str, LinearLayout linearLayout, HorizontalScrollView horizontalScrollView) {
        this.f3461a = new WeakReference(apkInfoActivity);
        this.f3462b = str;
        this.f3463c = linearLayout;
        this.f3464d = horizontalScrollView;
    }

    /* JADX INFO: renamed from: a */
    public final void m3072a(String str) {
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        if (str.equals(this.f3462b)) {
            return;
        }
        if (str.startsWith(this.f3462b + "/")) {
            for (String str2 : str.substring(this.f3462b.length() + 1).split("/")) {
                String str3 = this.f3462b + "/" + str2;
                View viewInflate = LayoutInflater.from((Context) this.f3461a.get()).inflate(R.layout.item_navigation_dir, (ViewGroup) null);
                View viewFindViewById = viewInflate.findViewById(R.id.menu_dirtab);
                viewFindViewById.setTag(str3);
                viewFindViewById.setOnClickListener(this);
                ((TextView) viewInflate.findViewById(R.id.dirname)).setText(str3.substring(str3.lastIndexOf(47) + 1));
                this.f3463c.addView(viewInflate);
                this.f3465e.add(viewInflate);
                this.f3462b = str3;
            }
        } else if (this.f3462b.startsWith(str + "/")) {
            for (int length = this.f3462b.substring(str.length() + 1).split("/").length - 1; length >= 0; length--) {
                int size = this.f3465e.size() - 1;
                View view = (View) this.f3465e.get(size);
                this.f3465e.remove(size);
                this.f3463c.removeView(view);
            }
            this.f3462b = str;
        }
        this.f3464d.postDelayed(new RunnableC1220fm(this), 100L);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = (String) view.getTag();
        if (str == null) {
            return;
        }
        String str2 = this.f3462b;
        m3072a(str);
        if (this.f3461a.get() != null) {
            ((ApkInfoActivity) this.f3461a.get()).m2431a(str, str2.startsWith(new StringBuilder().append(str).append("/").toString()) ? str2.substring(str.length() + 1).split("/").length : 0);
        }
    }
}
