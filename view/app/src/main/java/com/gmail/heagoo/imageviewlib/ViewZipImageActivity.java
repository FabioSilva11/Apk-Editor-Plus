package com.gmail.heagoo.imageviewlib;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p050c.p051a.C0940f;

/* JADX INFO: loaded from: classes.dex */
public class ViewZipImageActivity extends Activity {

    /* JADX INFO: renamed from: a */
    private C0940f f4344a;

    /* JADX INFO: renamed from: b */
    private String f4345b;

    /* JADX INFO: renamed from: c */
    private String f4346c;

    /* JADX INFO: renamed from: d */
    private String f4347d;

    /* JADX INFO: renamed from: e */
    private int f4348e;

    /* JADX INFO: renamed from: f */
    private int f4349f;

    /* JADX WARN: Removed duplicated region for block: B:47:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap m3564a() throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L3e
            java.lang.String r1 = r5.f4346c     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L3e
            r3.<init>(r1)     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L3e
            java.lang.String r1 = r5.f4347d     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5d
            java.util.zip.ZipEntry r1 = r3.getEntry(r1)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5d
            java.io.InputStream r2 = r3.getInputStream(r1)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5d
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            if (r2 == 0) goto L1b
            r2.close()     // Catch: java.io.IOException -> L4d
        L1b:
            r3.close()     // Catch: java.io.IOException -> L4f
        L1e:
            return r0
        L1f:
            r1 = move-exception
            r2 = r0
            r3 = r0
        L22:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L5b
            r4 = 0
            android.widget.Toast r1 = android.widget.Toast.makeText(r5, r1, r4)     // Catch: java.lang.Throwable -> L5b
            r1.show()     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L36
            r2.close()     // Catch: java.io.IOException -> L51
        L36:
            if (r3 == 0) goto L1e
            r3.close()     // Catch: java.io.IOException -> L3c
            goto L1e
        L3c:
            r1 = move-exception
            goto L1e
        L3e:
            r1 = move-exception
            r2 = r0
            r3 = r0
            r0 = r1
        L42:
            if (r2 == 0) goto L47
            r2.close()     // Catch: java.io.IOException -> L53
        L47:
            if (r3 == 0) goto L4c
            r3.close()     // Catch: java.io.IOException -> L55
        L4c:
            throw r0
        L4d:
            r1 = move-exception
            goto L1b
        L4f:
            r1 = move-exception
            goto L1e
        L51:
            r1 = move-exception
            goto L36
        L53:
            r1 = move-exception
            goto L47
        L55:
            r1 = move-exception
            goto L4c
        L57:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L42
        L5b:
            r0 = move-exception
            goto L42
        L5d:
            r1 = move-exception
            r2 = r0
            goto L22
        L60:
            r1 = move-exception
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.imageviewlib.ViewZipImageActivity.m3564a():android.graphics.Bitmap");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        if (intent.getBooleanExtra("fullScreen", false)) {
            getWindow().setFlags(1024, 1024);
        }
        setContentView(R.layout.imageviewlib_activity_empty);
        this.f4346c = C0985a.m2195a(intent, "zipFilePath");
        this.f4347d = C0985a.m2195a(intent, "entryName");
        this.f4345b = C0985a.m2195a(intent, "imageFilePath");
        Bitmap bitmapDecodeFile = this.f4345b != null ? BitmapFactory.decodeFile(this.f4345b) : m3564a();
        if (bitmapDecodeFile == null) {
            finish();
            return;
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        try {
            defaultDisplay.getSize(point);
        } catch (NoSuchMethodError e) {
            point.x = defaultDisplay.getWidth();
            point.y = defaultDisplay.getHeight();
        }
        this.f4348e = point.x;
        this.f4349f = point.y;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f4344a = new C0940f(this, bitmapDecodeFile);
        this.f4344a.setLayoutParams(layoutParams);
        if (bitmapDecodeFile.getWidth() <= this.f4348e && bitmapDecodeFile.getHeight() <= this.f4349f) {
            this.f4344a.m2069b(1.0f);
            this.f4344a.m2070b(this.f4348e / 2.0f, this.f4349f / 2.0f);
        }
        ((ViewGroup) findViewById(R.id.layout)).addView(this.f4344a);
    }
}
