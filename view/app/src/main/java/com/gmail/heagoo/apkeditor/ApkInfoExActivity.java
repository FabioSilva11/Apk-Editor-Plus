package com.gmail.heagoo.apkeditor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ApkInfoExActivity extends ApkInfoActivity {

    /* JADX INFO: renamed from: A */
    private ViewOnClickListenerC1057av f2633A = new ViewOnClickListenerC1057av(this);

    /* JADX INFO: renamed from: B */
    private boolean f2634B;

    /* JADX INFO: renamed from: n */
    private LinearLayout f2635n;

    /* JADX INFO: renamed from: o */
    private View f2636o;

    /* JADX INFO: renamed from: p */
    private View f2637p;

    /* JADX INFO: renamed from: q */
    private View f2638q;

    /* JADX INFO: renamed from: r */
    private View f2639r;

    /* JADX INFO: renamed from: s */
    private View f2640s;

    /* JADX INFO: renamed from: t */
    private View f2641t;

    /* JADX INFO: renamed from: u */
    private View f2642u;

    /* JADX INFO: renamed from: v */
    private View f2643v;

    /* JADX INFO: renamed from: w */
    private View f2644w;

    /* JADX INFO: renamed from: x */
    private View f2645x;

    /* JADX INFO: renamed from: y */
    private View f2646y;

    /* JADX INFO: renamed from: z */
    private View f2647z;

    /* JADX INFO: renamed from: a */
    private View m2466a(int i, int i2) {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.item_res_menu, (ViewGroup) null);
        ((ImageView) viewInflate.findViewById(R.id.menu_icon)).setImageResource(i);
        ((TextView) viewInflate.findViewById(R.id.menu_title)).setText(i2);
        viewInflate.setId(i);
        viewInflate.setOnClickListener(this.f2633A);
        return viewInflate;
    }

    /* JADX INFO: renamed from: a */
    private static void m2467a(View view, boolean z) {
        ImageView imageView = (ImageView) view.findViewById(R.id.menu_icon);
        TextView textView = (TextView) view.findViewById(R.id.menu_title);
        if (z) {
            imageView.getDrawable().setAlpha(255);
            textView.setEnabled(true);
        } else {
            imageView.getDrawable().setAlpha(127);
            textView.setEnabled(false);
        }
        view.setClickable(z);
        view.setEnabled(z);
    }

    @Override // com.gmail.heagoo.apkeditor.ApkInfoActivity, com.gmail.heagoo.apkeditor.InterfaceC1221fn
    /* JADX INFO: renamed from: b */
    public final void mo2445b(Set set) {
        super.mo2445b(set);
        if (set.size() == 1) {
            m2467a(this.f2646y, true);
            m2467a(this.f2647z, true);
        } else {
            m2467a(this.f2646y, false);
            m2467a(this.f2647z, false);
        }
    }

    /* JADX INFO: renamed from: n */
    public final void m2469n() {
        this.f2621i = !this.f2621i;
        this.f2619g.setImageResource(this.f2634B ? this.f2621i ? R.drawable.searchtxt_checked_white : R.drawable.searchtxt_unchecked_white : this.f2621i ? R.drawable.searchtxt_checked : R.drawable.searchtxt_unchecked);
    }

    /* JADX INFO: renamed from: o */
    public final void m2470o() {
        this.f2622j = !this.f2622j;
        this.f2620h.setImageResource(this.f2634B ? this.f2622j ? R.drawable.ic_case_sensitive_white : R.drawable.ic_case_insensitive_white : this.f2622j ? R.drawable.ic_case_sensitive : R.drawable.ic_case_insensitive);
    }

    @Override // com.gmail.heagoo.apkeditor.ApkInfoActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(128, 128);
        this.f2634B = this.f2624l != 0;
        this.f2636o = findViewById(R.id.menu_home);
        this.f2637p = findViewById(R.id.menu_done);
        this.f2638q = findViewById(R.id.menu_select);
        this.f2639r = findViewById(R.id.menu_addfile);
        this.f2640s = findViewById(R.id.menu_addfolder);
        this.f2641t = findViewById(R.id.menu_searchoptions);
        this.f2642u = findViewById(R.id.menu_caseinsensitive);
        this.f2636o.setOnClickListener(this.f2633A);
        this.f2637p.setOnClickListener(this.f2633A);
        this.f2638q.setOnClickListener(this.f2633A);
        this.f2639r.setOnClickListener(this.f2633A);
        this.f2640s.setOnClickListener(this.f2633A);
        this.f2641t.setOnClickListener(this.f2633A);
        this.f2642u.setOnClickListener(this.f2633A);
        this.f2635n = (LinearLayout) findViewById(R.id.res_menu_layout);
        this.f2643v = m2466a(R.drawable.ic_res_extract, R.string.extract);
        this.f2646y = m2466a(R.drawable.ic_res_replace, R.string.replace);
        this.f2645x = m2466a(R.drawable.ic_res_search, R.string.search);
        this.f2644w = m2466a(R.drawable.ic_res_delete, R.string.delete);
        this.f2647z = m2466a(R.drawable.ic_res_detail, R.string.detail);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2, 1.0f);
        this.f2635n.addView(this.f2643v, layoutParams);
        this.f2635n.addView(this.f2646y, layoutParams);
        this.f2635n.addView(this.f2645x, layoutParams);
        this.f2635n.addView(this.f2644w, layoutParams);
        this.f2635n.addView(this.f2647z, layoutParams);
    }

    @Override // com.gmail.heagoo.apkeditor.ApkInfoActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.gmail.heagoo.apkeditor.ApkInfoActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.gmail.heagoo.apkeditor.ApkInfoActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
