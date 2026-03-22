package com.gmail.heagoo.appdm;

import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.appdm.util.C1444j;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.u */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1436u implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ boolean f4224a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ PrefOverallActivity f4225b;

    RunnableC1436u(PrefOverallActivity prefOverallActivity, boolean z) {
        this.f4225b = prefOverallActivity;
        this.f4224a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4225b.findViewById(R.id.layout_scanning).setVisibility(4);
        if (!this.f4224a) {
            Toast.makeText(this.f4225b, this.f4225b.f4116a, 0).show();
            return;
        }
        String strM3435a = this.f4225b.f4119d.m3435a();
        if (strM3435a != null) {
            String[] strArrSplit = strM3435a.split("\n");
            for (String str : strArrSplit) {
                if (str.endsWith(".xml")) {
                    this.f4225b.f4132q.add(new C1444j(str.substring(str.lastIndexOf(47) + 1).substring(0, r5.length() - 4), str));
                }
            }
        }
        String strM3436b = this.f4225b.f4119d.m3436b();
        if (strM3436b != null) {
            String[] strArrSplit2 = strM3436b.split("\n");
            for (String str2 : strArrSplit2) {
                if (str2.endsWith(".db")) {
                    this.f4225b.f4133r.add(new C1444j(str2.substring(str2.lastIndexOf(47) + 1).substring(0, r5.length() - 3), str2));
                }
            }
        }
        PrefOverallActivity.m3400d(this.f4225b);
        PrefOverallActivity.m3401e(this.f4225b);
        this.f4225b.m3424b();
    }
}
