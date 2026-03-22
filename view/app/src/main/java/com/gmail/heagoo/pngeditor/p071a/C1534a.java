package com.gmail.heagoo.pngeditor.p071a;

import android.graphics.Bitmap;
import android.support.v4.view.ViewCompat;
import com.gmail.heagoo.pngeditor.InterfaceC1533a;

/* JADX INFO: renamed from: com.gmail.heagoo.pngeditor.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1534a implements InterfaceC1533a {

    /* JADX INFO: renamed from: a */
    private int f4572a = ViewCompat.MEASURED_SIZE_MASK;

    /* JADX INFO: renamed from: b */
    private int f4573b = 0;

    /* JADX INFO: renamed from: c */
    private boolean f4574c = false;

    @Override // com.gmail.heagoo.pngeditor.InterfaceC1533a
    /* JADX INFO: renamed from: a */
    public final Bitmap mo3712a(Bitmap bitmap) {
        this.f4574c = true;
        int i = this.f4572a;
        int i2 = this.f4573b;
        int i3 = i | ViewCompat.MEASURED_STATE_MASK;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i4 = i2 * 3;
        int i5 = i4 * i4;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[width];
        for (int i6 = 0; i6 < height; i6++) {
            bitmap.getPixels(iArr, 0, width, 0, i6, width, 1);
            if (i4 == 0) {
                for (int i7 = 0; i7 < width; i7++) {
                    if (iArr[i7] == i3) {
                        iArr[i7] = 0;
                    }
                }
            } else {
                for (int i8 = 0; i8 < width; i8++) {
                    int i9 = iArr[i8];
                    int i10 = (i9 & 255) - (i3 & 255);
                    int i11 = ((i9 >> 8) & 255) - ((i3 >> 8) & 255);
                    int i12 = ((i9 >> 16) & 255) - ((i3 >> 16) & 255);
                    if ((i12 * i12) + (i10 * i10) + (i11 * i11) <= i5) {
                        iArr[i8] = 0;
                    }
                }
            }
            bitmapCreateBitmap.setPixels(iArr, 0, width, 0, i6, width, 1);
        }
        return bitmapCreateBitmap;
    }

    @Override // com.gmail.heagoo.pngeditor.InterfaceC1533a
    /* JADX INFO: renamed from: a */
    public final void mo3713a(String str, Object obj) {
        if ("color".equals(str)) {
            this.f4572a = ((Integer) obj).intValue();
        } else if ("tolerance".equals(str)) {
            this.f4573b = ((Integer) obj).intValue();
        }
    }

    @Override // com.gmail.heagoo.pngeditor.InterfaceC1533a
    /* JADX INFO: renamed from: a */
    public final boolean mo3714a() {
        return this.f4574c;
    }
}
