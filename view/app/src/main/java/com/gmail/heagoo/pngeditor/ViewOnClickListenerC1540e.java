package com.gmail.heagoo.pngeditor;

import android.view.View;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.pngeditor.e */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1540e implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ PngEditActivity f4584a;

    ViewOnClickListenerC1540e(PngEditActivity pngEditActivity) {
        this.f4584a = pngEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        float fM2062a = 1.0f;
        int id = view.getId();
        if (id == R.id.btn_scale_fit) {
            fM2062a = this.f4584a.f4555g.m2062a();
        } else if (id != R.id.btn_scale_100) {
            if (id == R.id.btn_scale_200) {
                fM2062a = 2.0f;
            } else if (id == R.id.btn_scale_400) {
                fM2062a = 4.0f;
            }
        }
        this.f4584a.f4555g.m2063a(fM2062a);
        this.f4584a.f4555g.postInvalidate();
        this.f4584a.mo2079a(fM2062a);
        this.f4584a.f4570v.dismiss();
    }
}
