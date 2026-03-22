package com.gmail.heagoo.apkeditor.prj;

import android.content.Context;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.InterfaceC1208fa;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1476h;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.prj.g */
/* JADX INFO: loaded from: classes.dex */
final class C1339g implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private WeakReference f3804a;

    /* JADX INFO: renamed from: b */
    private C1338f f3805b;

    /* JADX INFO: renamed from: c */
    private boolean f3806c = false;

    /* JADX INFO: renamed from: d */
    private String f3807d;

    C1339g(ProjectListActivity projectListActivity, C1338f c1338f) {
        this.f3804a = new WeakReference(projectListActivity);
        this.f3805b = c1338f;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() {
        try {
            C1476h.m3508a(new File(this.f3805b.f3801c));
        } catch (IOException e) {
        }
        try {
            C1476h.m3508a(new File(C0985a.m2263d((Context) this.f3804a.get(), ".projects") + this.f3805b.f3799a));
            this.f3806c = true;
        } catch (Exception e2) {
            this.f3807d = e2.getMessage();
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        if (this.f3806c) {
            Context context = (Context) this.f3804a.get();
            Toast.makeText(context, String.format(context.getString(R.string.project_removed), this.f3805b.f3799a), 1).show();
            ((ProjectListActivity) this.f3804a.get()).m3222a();
        } else if (this.f3807d != null) {
            Toast.makeText((Context) this.f3804a.get(), String.format(((ProjectListActivity) this.f3804a.get()).getString(R.string.general_error), this.f3807d), 1).show();
        }
    }
}
