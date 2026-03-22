package com.gmail.heagoo.apkeditor;

import android.os.AsyncTask;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1474f;
import com.gmail.heagoo.neweditor.C1511e;
import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ip */
/* JADX INFO: loaded from: classes.dex */
final class AsyncTaskC1303ip extends AsyncTask {

    /* JADX INFO: renamed from: a */
    private String f3691a;

    /* JADX INFO: renamed from: b */
    private boolean f3692b;

    /* JADX INFO: renamed from: c */
    private String f3693c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ TextEditNormalActivity f3694d;

    private AsyncTaskC1303ip(TextEditNormalActivity textEditNormalActivity) {
        this.f3694d = textEditNormalActivity;
    }

    /* synthetic */ AsyncTaskC1303ip(TextEditNormalActivity textEditNormalActivity, byte b2) {
        this(textEditNormalActivity);
    }

    /* JADX INFO: renamed from: a */
    private Boolean m3183a() {
        C1511e c1511e = new C1511e(this.f3694d, new File(this.f3693c), this.f3691a);
        try {
            if (this.f3694d.f3581h != null) {
                c1511e.m3644a(this.f3694d, this.f3694d.f3581h, R.string.error_file_too_big);
                c1511e.m3649a(true);
                new File(this.f3694d.f3581h).delete();
                this.f3694d.f3581h = null;
            } else {
                c1511e.m3644a(this.f3694d, this.f3693c, R.string.error_file_too_big);
            }
            this.f3694d.f3583j = c1511e;
            this.f3692b = true;
        } catch (IOException e) {
            this.f3692b = false;
        }
        if (!AbstractActivityC1258gy.m3131e(this.f3693c)) {
            AbstractActivityC1258gy.m3126c(this.f3693c);
        }
        return null;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3183a();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        if (this.f3692b) {
            TextEditNormalActivity.m2606c(this.f3694d, true);
            this.f3694d.f2796l.removeTextChangedListener(this.f3694d.f2783X);
            this.f3694d.f2796l.setText(this.f3694d.f3583j.m3642a());
            this.f3694d.f2796l.m3601b(801639);
            this.f3694d.f2796l.addTextChangedListener(this.f3694d.f2783X);
            int length = this.f3694d.f3583j.m3642a().split("\n").length + 1;
            C1304iq c1304iq = this.f3694d.f2795k;
            TextEditNormalActivity.m2595a(this.f3694d, true, C1304iq.m3184a(length));
            this.f3694d.m2629a(true);
            this.f3694d.m2628a(-1, -1, false);
            this.f3694d.m2631d();
        } else {
            Toast.makeText(this.f3694d, "Failed to open " + this.f3693c, 1).show();
        }
        this.f3694d.f2788ac.setMaxWidth((((C1474f.m3501a(this.f3694d) - this.f3694d.f2789ad.getWidth()) - this.f3694d.f2790ae.getWidth()) - this.f3694d.f2791af.getWidth()) - ((int) (16.0f * this.f3694d.getResources().getDisplayMetrics().density)));
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
        this.f3693c = (String) this.f3694d.f3575b.get(this.f3694d.f3578e);
        this.f3694d.f2792ag = ((Integer) this.f3694d.f3576c.get(this.f3694d.f3578e)).intValue();
        this.f3691a = (String) this.f3694d.f3577d.get(this.f3694d.f3578e);
        this.f3694d.m3138a(this.f3693c);
        this.f3694d.f2788ac.setText(this.f3694d.m3143f(this.f3693c));
        this.f3694d.f2791af.setVisibility((AbstractActivityC1258gy.m3126c(this.f3693c) || AbstractActivityC1258gy.m3129d(this.f3693c)) ? 0 : 8);
        if (this.f3694d.f3578e >= this.f3694d.f3575b.size() - 1) {
            this.f3694d.f2790ae.setVisibility(8);
        } else {
            this.f3694d.f2790ae.setVisibility(0);
        }
        if (this.f3694d.f3578e == 0) {
            this.f3694d.f2789ad.setVisibility(8);
        } else {
            this.f3694d.f2789ad.setVisibility(0);
        }
    }
}
