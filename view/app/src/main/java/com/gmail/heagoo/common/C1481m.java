package com.gmail.heagoo.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;

/* JADX INFO: renamed from: com.gmail.heagoo.common.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1481m {

    /* JADX INFO: renamed from: a */
    private int f4308a;

    /* JADX INFO: renamed from: b */
    private int f4309b;

    /* JADX INFO: renamed from: a */
    public final int m3517a() {
        return this.f4308a;
    }

    /* JADX INFO: renamed from: a */
    public final Bitmap m3518a(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        this.f4309b = options.outHeight;
        this.f4308a = options.outWidth;
        int i3 = this.f4308a / 32;
        int i4 = this.f4309b / 32;
        if (i3 >= i4) {
            i3 = i4;
        }
        options.inSampleSize = i3 > 0 ? i3 : 1;
        return ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(str, options), 32, 32, 2);
    }

    /* JADX INFO: renamed from: b */
    public final int m3519b() {
        return this.f4309b;
    }
}
