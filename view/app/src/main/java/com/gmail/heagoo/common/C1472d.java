package com.gmail.heagoo.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: renamed from: com.gmail.heagoo.common.d */
/* JADX INFO: loaded from: classes.dex */
final class C1472d extends Thread {

    /* JADX INFO: renamed from: a */
    private InputStream f4294a;

    /* JADX INFO: renamed from: b */
    private String[] f4295b;

    /* JADX INFO: renamed from: c */
    private int f4296c;

    public C1472d(InputStream inputStream, String[] strArr, int i) {
        this.f4294a = inputStream;
        this.f4295b = strArr;
        this.f4296c = i;
    }

    /* JADX INFO: renamed from: a */
    public final void m3499a() {
        interrupt();
        try {
            this.f4294a.close();
        } catch (IOException e) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        char[] cArr = new char[128];
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(this.f4294a, "UTF-8");
            do {
                i = inputStreamReader.read(cArr, 0, 128);
                if (i > 0) {
                    sb.append(cArr, 0, i);
                }
            } while (i >= 0);
        } catch (Exception e) {
        }
        this.f4295b[this.f4296c] = sb.toString();
    }
}
