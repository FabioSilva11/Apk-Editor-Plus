package com.gmail.heagoo.sqliteutil;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: renamed from: com.gmail.heagoo.sqliteutil.d */
/* JADX INFO: loaded from: classes.dex */
final class C1550d extends Thread {

    /* JADX INFO: renamed from: a */
    private InputStream f4657a;

    /* JADX INFO: renamed from: b */
    private String[] f4658b;

    /* JADX INFO: renamed from: c */
    private int f4659c;

    public C1550d(InputStream inputStream, String[] strArr, int i) {
        this.f4657a = inputStream;
        this.f4658b = strArr;
        this.f4659c = i;
    }

    /* JADX INFO: renamed from: a */
    public final void m3768a() {
        interrupt();
        try {
            this.f4657a.close();
        } catch (IOException e) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        char[] cArr = new char[128];
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(this.f4657a, "UTF-8");
            do {
                i = inputStreamReader.read(cArr, 0, 128);
                if (i > 0) {
                    sb.append(cArr, 0, i);
                }
            } while (i >= 0);
        } catch (Exception e) {
        }
        this.f4658b[this.f4659c] = sb.toString();
    }
}
