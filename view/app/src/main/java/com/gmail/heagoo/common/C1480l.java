package com.gmail.heagoo.common;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: com.gmail.heagoo.common.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1480l {
    /* JADX INFO: renamed from: a */
    private static void m3514a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3515a(Bitmap bitmap, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        boolean z;
        try {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Exception e) {
                e = e;
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                C0985a.m2212a(fileOutputStream);
                throw th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                C0985a.m2212a(fileOutputStream);
                z = true;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C0985a.m2212a(fileOutputStream);
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            C0985a.m2212a(fileOutputStream);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3516a(Bitmap bitmap, int i, int i2, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        OutputStream outputStream = null;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        try {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Exception e) {
                e = e;
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                outputStream = null;
                m3514a(outputStream);
                throw th;
            }
            try {
                if (str.endsWith(".png")) {
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 80, fileOutputStream);
                } else {
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                }
                m3514a(fileOutputStream);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                m3514a(fileOutputStream);
            }
        } catch (Throwable th2) {
            th = th2;
            m3514a(outputStream);
            throw th;
        }
    }
}
