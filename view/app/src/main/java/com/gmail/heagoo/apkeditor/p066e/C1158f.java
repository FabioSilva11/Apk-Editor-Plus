package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.List;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.f */
/* JADX INFO: loaded from: classes.dex */
final class C1158f extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ List f3264a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ZipFile f3265b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ C1157e f3266c;

    C1158f(C1157e c1157e, List list, ZipFile zipFile) {
        this.f3266c = c1157e;
        this.f3264a = list;
        this.f3265b = zipFile;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int iM2910a = 0;
        while (iM2910a < this.f3264a.size()) {
            AbstractC1159g abstractC1159g = (AbstractC1159g) this.f3264a.get(iM2910a);
            this.f3266c.f3261c.mo2899a(R.string.patch_start_apply, true, Integer.valueOf(abstractC1159g.f3267a));
            String strMo2924a = abstractC1159g.mo2929a(this.f3266c.f3261c) ? abstractC1159g.mo2924a((ApkInfoActivity) this.f3266c.f3259a.get(), this.f3265b, this.f3266c.f3261c) : null;
            iM2910a = strMo2924a != null ? C1157e.m2910a(this.f3266c, this.f3264a, strMo2924a) : iM2910a + 1;
        }
        this.f3266c.f3261c.mo2899a(R.string.all_rules_applied, true, new Object[0]);
        this.f3266c.f3261c.mo2898a();
    }
}
