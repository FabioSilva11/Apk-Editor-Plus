package com.gmail.heagoo.pngeditor.p071a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.gmail.heagoo.pngeditor.InterfaceC1533a;

/* JADX INFO: renamed from: com.gmail.heagoo.pngeditor.a.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1535b implements InterfaceC1533a {

    /* JADX INFO: renamed from: a */
    private int f4575a = 0;

    /* JADX INFO: renamed from: b */
    private int f4576b = 0;

    /* JADX INFO: renamed from: c */
    private boolean f4577c = true;

    /* JADX INFO: renamed from: d */
    private boolean f4578d = false;

    @Override // com.gmail.heagoo.pngeditor.InterfaceC1533a
    /* JADX INFO: renamed from: a */
    public final Bitmap mo3712a(Bitmap bitmap) {
        if (this.f4575a <= 0 || this.f4576b <= 0) {
            return null;
        }
        this.f4578d = true;
        if (!this.f4577c) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f4575a, this.f4576b, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, (r1 - bitmap.getWidth()) / 2, (r2 - bitmap.getHeight()) / 2, new Paint());
            return bitmapCreateBitmap;
        }
        int i = this.f4575a;
        int i2 = this.f4576b;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    @Override // com.gmail.heagoo.pngeditor.InterfaceC1533a
    /* JADX INFO: renamed from: a */
    public final void mo3713a(String str, Object obj) {
        if ("width".equals(str)) {
            this.f4575a = ((Integer) obj).intValue();
        } else if ("height".equals(str)) {
            this.f4576b = ((Integer) obj).intValue();
        } else if ("zooming".equals(str)) {
            this.f4577c = ((Boolean) obj).booleanValue();
        }
    }

    @Override // com.gmail.heagoo.pngeditor.InterfaceC1533a
    /* JADX INFO: renamed from: a */
    public final boolean mo3714a() {
        return this.f4578d;
    }
}
