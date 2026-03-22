package com.gmail.heagoo.apkeditor.p060a.p061a;

import android.content.Context;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1028f;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.zip.Adler32;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1013n implements InterfaceC1026d, Serializable {

    /* JADX INFO: renamed from: a */
    private String f2858a;

    public C1013n(String str) {
        this.f2858a = str;
    }

    @Override // com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d
    /* JADX INFO: renamed from: a */
    public final void mo2692a(Context context, String str, Map map, InterfaceC1028f interfaceC1028f) throws IOException {
        String str2 = C0985a.m2263d(context, "tmp") + "_dex";
        RandomAccessFile randomAccessFile = new RandomAccessFile(str2, "rw");
        randomAccessFile.setLength(0L);
        ZipFile zipFile = new ZipFile(str);
        InputStream inputStream = zipFile.getInputStream(zipFile.getEntry("classes.dex"));
        byte[] bArr = new byte[559000];
        int i = 0;
        while (true) {
            int i2 = inputStream.read(bArr, i, 559000 - i);
            if (i2 <= 0) {
                System.arraycopy(this.f2858a.getBytes(), 0, bArr, 401438, this.f2858a.length());
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    messageDigest.update(bArr, 32, i - 32);
                    try {
                        messageDigest.digest(bArr, 12, 20);
                        Adler32 adler32 = new Adler32();
                        adler32.update(bArr, 12, i - 12);
                        int value = (int) adler32.getValue();
                        bArr[8] = (byte) value;
                        bArr[9] = (byte) (value >> 8);
                        bArr[10] = (byte) (value >> 16);
                        bArr[11] = (byte) (value >>> 24);
                        randomAccessFile.write(bArr, 0, i);
                        inputStream.close();
                        zipFile.close();
                        randomAccessFile.close();
                        map.put("classes.dex", str2);
                        return;
                    } catch (DigestException e) {
                        throw new RuntimeException(e);
                    }
                } catch (NoSuchAlgorithmException e2) {
                    throw new RuntimeException(e2);
                }
            }
            i += i2;
        }
    }
}
