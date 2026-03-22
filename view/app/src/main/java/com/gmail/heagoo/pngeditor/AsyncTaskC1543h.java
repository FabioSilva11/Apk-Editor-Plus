package com.gmail.heagoo.pngeditor;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.p050c.p051a.C0940f;

/* JADX INFO: renamed from: com.gmail.heagoo.pngeditor.h */
/* JADX INFO: loaded from: classes.dex */
final class AsyncTaskC1543h extends AsyncTask {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ PngEditActivity f4589a;

    AsyncTaskC1543h(PngEditActivity pngEditActivity) {
        this.f4589a = pngEditActivity;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        this.f4589a.f4566r = BitmapFactory.decodeFile(this.f4589a.f4550b);
        return Boolean.valueOf(this.f4589a.f4566r != null);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            Toast.makeText(this.f4589a, String.format(this.f4589a.getString(R.string.cannot_open_file), this.f4589a.f4550b), 1).show();
            this.f4589a.finish();
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f4589a.f4555g = new C0940f(this.f4589a, this.f4589a.f4566r);
        this.f4589a.f4555g.m2066a(this.f4589a);
        this.f4589a.f4555g.setLayoutParams(layoutParams);
        this.f4589a.f4555g.m2069b(1.0f);
        ((LinearLayout) this.f4589a.findViewById(R.id.image_layout)).addView(this.f4589a.f4555g);
        this.f4589a.mo2079a(this.f4589a.f4555g.m2073e());
    }
}
