package com.gmail.heagoo.apkeditor;

import android.os.AsyncTask;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1474f;
import com.gmail.heagoo.neweditor.C1511e;
import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hr */
/* JADX INFO: loaded from: classes.dex */
final class AsyncTaskC1278hr extends AsyncTask {

    /* JADX INFO: renamed from: a */
    private String f3634a;

    /* JADX INFO: renamed from: b */
    private boolean f3635b;

    /* JADX INFO: renamed from: c */
    private String f3636c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ TextEditBigActivity f3637d;

    private AsyncTaskC1278hr(TextEditBigActivity textEditBigActivity) {
        this.f3637d = textEditBigActivity;
    }

    /* synthetic */ AsyncTaskC1278hr(TextEditBigActivity textEditBigActivity, byte b2) {
        this(textEditBigActivity);
    }

    /* JADX INFO: renamed from: a */
    private Boolean m3145a() {
        C1511e c1511e = new C1511e(this.f3637d, new File(this.f3636c), this.f3634a);
        try {
            if (this.f3637d.f3581h != null) {
                c1511e.m3644a(this.f3637d, this.f3637d.f3581h, R.string.error_file_too_big);
                c1511e.m3649a(true);
                new File(this.f3637d.f3581h).delete();
                this.f3637d.f3581h = null;
            } else {
                c1511e.m3644a(this.f3637d, this.f3636c, R.string.error_file_too_big);
            }
            this.f3637d.f3583j = c1511e;
            this.f3635b = true;
        } catch (IOException e) {
            this.f3635b = false;
        }
        if (!AbstractActivityC1258gy.m3131e(this.f3636c)) {
            AbstractActivityC1258gy.m3126c(this.f3636c);
        }
        return null;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3145a();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        if (this.f3635b) {
            this.f3637d.f2738K.m3164a(this.f3637d.f3583j);
            this.f3637d.f2738K.m3165a(this.f3637d.f3583j.m3642a());
            TextEditBigActivity.m2583f(this.f3637d);
            this.f3637d.m2591d();
        } else {
            Toast.makeText(this.f3637d, "Failed to open " + this.f3636c, 1).show();
        }
        this.f3637d.f2733F.setMaxWidth((((C1474f.m3501a(this.f3637d) - this.f3637d.f2734G.getWidth()) - this.f3637d.f2735H.getWidth()) - this.f3637d.f2736I.getWidth()) - ((int) (16.0f * this.f3637d.getResources().getDisplayMetrics().density)));
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
        this.f3636c = (String) this.f3637d.f3575b.get(this.f3637d.f3578e);
        this.f3637d.f2737J = ((Integer) this.f3637d.f3576c.get(this.f3637d.f3578e)).intValue();
        this.f3634a = (String) this.f3637d.f3577d.get(this.f3637d.f3578e);
        this.f3637d.m3138a(this.f3636c);
        this.f3637d.f2733F.setText(this.f3637d.m3143f(this.f3636c));
        this.f3637d.f2736I.setVisibility((AbstractActivityC1258gy.m3126c(this.f3636c) || AbstractActivityC1258gy.m3129d(this.f3636c)) ? 0 : 8);
        if (this.f3637d.f3578e >= this.f3637d.f3575b.size() - 1) {
            this.f3637d.f2735H.setVisibility(8);
        } else {
            this.f3637d.f2735H.setVisibility(0);
        }
        if (this.f3637d.f3578e == 0) {
            this.f3637d.f2734G.setVisibility(8);
        } else {
            this.f3637d.f2734G.setVisibility(0);
        }
    }
}
