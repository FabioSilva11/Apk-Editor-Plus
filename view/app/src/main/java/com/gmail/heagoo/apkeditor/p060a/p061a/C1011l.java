package com.gmail.heagoo.apkeditor.p060a.p061a;

import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1011l {

    /* JADX INFO: renamed from: a */
    private RandomAccessFile f2854a;

    /* JADX INFO: renamed from: b */
    private int f2855b = 0;

    public C1011l(RandomAccessFile randomAccessFile) {
        this.f2854a = randomAccessFile;
    }

    /* JADX INFO: renamed from: a */
    public final int m2679a() {
        return this.f2855b;
    }

    /* JADX INFO: renamed from: a */
    public final void m2680a(int i) throws IOException {
        byte[] bArr = new byte[4];
        C1004e.m2673a(bArr, 0, i);
        this.f2854a.write(bArr);
        this.f2855b += 4;
    }

    /* JADX INFO: renamed from: a */
    public final void m2681a(int i, int i2) throws IOException {
        long filePointer = this.f2854a.getFilePointer();
        this.f2854a.seek(4L);
        m2680a(i2);
        this.f2854a.seek(filePointer);
    }

    /* JADX INFO: renamed from: a */
    public final void m2682a(byte[] bArr) throws IOException {
        this.f2854a.write(bArr);
        this.f2855b += bArr.length;
    }

    /* JADX INFO: renamed from: a */
    public final void m2683a(byte[] bArr, int i, int i2) throws IOException {
        this.f2854a.write(bArr, 0, i2);
        this.f2855b += i2;
    }

    /* JADX INFO: renamed from: a */
    public final void m2684a(int[] iArr) throws IOException {
        byte[] bArr = new byte[iArr.length * 4];
        for (int i = 0; i < iArr.length; i++) {
            C1004e.m2673a(bArr, i * 4, iArr[i]);
        }
        m2682a(bArr);
    }

    /* JADX INFO: renamed from: b */
    public final void m2685b() {
        this.f2854a.close();
    }

    /* JADX INFO: renamed from: b */
    public final void m2686b(int i) throws IOException {
        byte[] bArr = new byte[2];
        C1004e.m2675b(bArr, 0, 0);
        this.f2854a.write(bArr);
        this.f2855b += 2;
    }
}
