package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.InterfaceC1125cy;
import com.gmail.heagoo.apkeditor.pro.R;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1157e implements InterfaceC1125cy {

    /* JADX INFO: renamed from: a */
    private WeakReference f3259a;

    /* JADX INFO: renamed from: b */
    private String f3260b;

    /* JADX INFO: renamed from: c */
    private InterfaceC1154b f3261c;

    /* JADX INFO: renamed from: d */
    private C1156d f3262d;

    /* JADX INFO: renamed from: e */
    private ZipFile f3263e;

    public C1157e(ApkInfoActivity apkInfoActivity, String str, InterfaceC1154b interfaceC1154b) {
        this.f3259a = new WeakReference(apkInfoActivity);
        this.f3260b = str;
        this.f3261c = interfaceC1154b;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ int m2910a(C1157e c1157e, List list, String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return -1;
            }
            if (str.equals(((AbstractC1159g) list.get(i2)).m2931b())) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2912a(List list, ZipFile zipFile) {
        new C1158f(this, list, zipFile).start();
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1125cy
    /* JADX INFO: renamed from: a */
    public final void mo2860a() {
        if (this.f3262d == null || this.f3262d.f3258a == null || this.f3263e == null) {
            return;
        }
        m2912a(this.f3262d.f3258a, this.f3263e);
    }

    /* JADX INFO: renamed from: b */
    public final void m2914b() {
        boolean z;
        boolean z2 = false;
        try {
            this.f3263e = new ZipFile(this.f3260b);
            ZipEntry entry = this.f3263e.getEntry("patch.txt");
            if (entry == null) {
                this.f3263e.close();
                this.f3263e = null;
                this.f3261c.mo2900a(R.string.patch_error_no_entry, "patch.txt");
            }
            InputStream inputStream = this.f3263e.getInputStream(entry);
            this.f3262d = C1156d.m2909a(inputStream, this.f3261c);
            inputStream.close();
            if (!((ApkInfoActivity) this.f3259a.get()).m2463k()) {
                Iterator it = this.f3262d.f3258a.iterator();
                boolean zMo2928a = false;
                while (true) {
                    if (!it.hasNext()) {
                        z = zMo2928a;
                        break;
                    }
                    zMo2928a = ((AbstractC1159g) it.next()).mo2928a();
                    if (zMo2928a) {
                        z = zMo2928a;
                        break;
                    }
                }
                if (z) {
                    this.f3261c.mo2899a(R.string.decode_dex_file, true, new Object[0]);
                    ((ApkInfoActivity) this.f3259a.get()).m2430a(this);
                }
                z2 = z;
            }
            if (z2) {
                return;
            }
            m2912a(this.f3262d.f3258a, this.f3263e);
        } catch (Exception e) {
            this.f3261c.mo2900a(R.string.general_error, e.getMessage());
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: c */
    public final List m2915c() {
        ArrayList arrayList = new ArrayList();
        if (this.f3262d != null && this.f3262d.f3258a != null) {
            Iterator it = this.f3262d.f3258a.iterator();
            while (it.hasNext()) {
                arrayList.add(((AbstractC1159g) it.next()).m2931b());
            }
        }
        return arrayList;
    }
}
