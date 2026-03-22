package p000a.p001a.p003b.p006b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p000a.p001a.C0000a;
import p000a.p001a.p002a.C0001a;
import p000a.p011d.C0074f;

/* JADX INFO: renamed from: a.a.b.b.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0049g implements InterfaceC0053k {
    /* JADX INFO: renamed from: a */
    private static void m134a(Bitmap bitmap, int i, int i2, int i3) {
        while (i2 <= i3) {
            bitmap.setPixel(i2, i, ViewCompat.MEASURED_STATE_MASK);
            i2++;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m135a(DataInput dataInput) throws C0001a, IOException {
        dataInput.skipBytes(8);
        while (true) {
            try {
                int i = dataInput.readInt();
                if (dataInput.readInt() == 1852855395) {
                    return;
                } else {
                    dataInput.skipBytes(i + 4);
                }
            } catch (IOException e) {
                throw new C0001a("Cant find nine patch chunk", e);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m136b(Bitmap bitmap, int i, int i2, int i3) {
        while (i2 <= i3) {
            bitmap.setPixel(i, i2, ViewCompat.MEASURED_STATE_MASK);
            i2++;
        }
    }

    @Override // p000a.p001a.p003b.p006b.InterfaceC0053k
    /* JADX INFO: renamed from: a */
    public final void mo137a(InputStream inputStream, OutputStream outputStream) throws C0000a {
        C0050h c0050h;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            C0985a.m2244b(inputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            int width = bitmapDecodeByteArray.getWidth();
            int height = bitmapDecodeByteArray.getHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width + 2, height + 2, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeByteArray, 1.0f, 1.0f, new Paint());
            try {
                C0074f c0074f = new C0074f(new ByteArrayInputStream(byteArray));
                m135a(c0074f);
                c0074f.skipBytes(1);
                byte b2 = c0074f.readByte();
                byte b3 = c0074f.readByte();
                c0074f.skipBytes(1);
                c0074f.skipBytes(8);
                int i = c0074f.readInt();
                int i2 = c0074f.readInt();
                int i3 = c0074f.readInt();
                int i4 = c0074f.readInt();
                c0074f.skipBytes(4);
                c0050h = new C0050h(i, i2, i3, i4, c0074f.m182a(b2), c0074f.m182a(b3));
            } catch (Exception e) {
                c0050h = null;
            }
            if (c0050h != null) {
                m134a(bitmapCreateBitmap, height + 1, c0050h.f153a + 1, width - c0050h.f154b);
                m136b(bitmapCreateBitmap, width + 1, c0050h.f155c + 1, height - c0050h.f156d);
                int[] iArr = c0050h.f157e;
                int i5 = 0;
                int length = iArr.length;
                if (length == 0) {
                    m134a(bitmapCreateBitmap, 0, 1, width);
                } else {
                    while (i5 < length) {
                        m134a(bitmapCreateBitmap, 0, iArr[i5] + 1, iArr[i5 + 1]);
                        i5 += 2;
                        length = iArr.length;
                    }
                }
                int[] iArr2 = c0050h.f158f;
                int i6 = 0;
                int length2 = iArr2.length;
                if (length2 == 0) {
                    m136b(bitmapCreateBitmap, 0, 1, height);
                } else {
                    while (i6 < length2) {
                        m136b(bitmapCreateBitmap, 0, iArr2[i6] + 1, iArr2[i6 + 1]);
                        i6 += 2;
                        length2 = iArr2.length;
                    }
                }
            } else {
                m134a(bitmapCreateBitmap, height + 1, 1, width);
                m136b(bitmapCreateBitmap, width + 1, 1, height);
                m134a(bitmapCreateBitmap, 0, 1, width);
                m136b(bitmapCreateBitmap, 0, 1, height);
            }
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        } catch (IOException e2) {
            throw new C0000a(e2);
        }
    }
}
