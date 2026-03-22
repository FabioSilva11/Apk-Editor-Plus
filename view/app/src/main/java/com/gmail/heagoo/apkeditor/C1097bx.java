package com.gmail.heagoo.apkeditor;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.android.apksig.apk.ApkUtils;
import com.gmail.heagoo.apkeditor.p060a.C0999a;
import com.gmail.heagoo.apkeditor.p060a.C1029g;
import com.gmail.heagoo.apkeditor.p060a.C1031i;
import com.gmail.heagoo.common.C1469a;
import com.gmail.heagoo.common.C1470b;
import java.io.InputStream;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.bx */
/* JADX INFO: loaded from: classes.dex */
final class C1097bx extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ CommonEditActivity f3120a;

    C1097bx(CommonEditActivity commonEditActivity) {
        this.f3120a = commonEditActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        try {
            CommonEditActivity commonEditActivity = this.f3120a;
            new C1469a();
            commonEditActivity.f2673b = C1469a.m3488a(this.f3120a, this.f3120a.f2672a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ZipFile zipFile = new ZipFile(this.f3120a.f2672a);
            InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME));
            this.f3120a.f2690s = new C1031i(inputStream);
            this.f3120a.f2690s.m2760b();
            inputStream.close();
            zipFile.close();
            C1029g c1029gM2759a = this.f3120a.f2690s.m2759a();
            if (this.f3120a.f2673b == null) {
                this.f3120a.f2673b = new C1470b();
                C0999a c0999a = new C0999a(this.f3120a, this.f3120a.f2672a);
                c0999a.m2655a(c1029gM2759a.f2960n, c1029gM2759a.f2959m);
                this.f3120a.f2673b.f4290a = c0999a.m2654a();
                Bitmap bitmapM2656b = c0999a.m2656b();
                if (bitmapM2656b != null) {
                    this.f3120a.f2673b.f4292c = new BitmapDrawable(bitmapM2656b);
                }
            }
            this.f3120a.f2692u.sendEmptyMessage(0);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f3120a.f2692u.m2821a(e2.getMessage());
            this.f3120a.f2692u.sendEmptyMessage(1);
        }
    }
}
