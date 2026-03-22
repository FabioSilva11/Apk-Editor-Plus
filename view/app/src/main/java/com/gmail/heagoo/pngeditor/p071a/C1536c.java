package com.gmail.heagoo.pngeditor.p071a;

import android.graphics.Bitmap;
import android.support.v4.view.ViewCompat;
import com.gmail.heagoo.pngeditor.InterfaceC1533a;

/* JADX INFO: renamed from: com.gmail.heagoo.pngeditor.a.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1536c implements InterfaceC1533a {

    /* JADX INFO: renamed from: a */
    private int f4579a = 255;

    /* JADX INFO: renamed from: b */
    private boolean f4580b = false;

    @Override // com.gmail.heagoo.pngeditor.InterfaceC1533a
    /* JADX INFO: renamed from: a */
    public final Bitmap mo3712a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[width];
        for (int i = 0; i < height; i++) {
            bitmap.getPixels(iArr, 0, width, 0, i, width, 1);
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = iArr[i2] >>> 24;
                if (iArr[i2] != 0) {
                    iArr[i2] = (((i3 * this.f4579a) / 255) << 24) | (iArr[i2] & ViewCompat.MEASURED_SIZE_MASK);
                }
            }
            bitmapCreateBitmap.setPixels(iArr, 0, width, 0, i, width, 1);
        }
        this.f4580b = true;
        return bitmapCreateBitmap;
    }

    @Override // com.gmail.heagoo.pngeditor.InterfaceC1533a
    /* JADX INFO: renamed from: a */
    public final void mo3713a(String str, Object obj) {
        if ("transparency".equals(str)) {
            int iIntValue = ((Integer) obj).intValue();
            int i = iIntValue <= 255 ? iIntValue : 255;
            if (i < 0) {
                i = 0;
            }
            this.f4579a = 255 - i;
        }
    }

    @Override // com.gmail.heagoo.pngeditor.InterfaceC1533a
    /* JADX INFO: renamed from: a */
    public final boolean mo3714a() {
        return this.f4580b;
    }
}
