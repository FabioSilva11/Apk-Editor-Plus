package com.gmail.heagoo.apkeditor.p060a.p061a;

import com.gmail.heagoo.common.C1487s;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1002c {

    /* JADX INFO: renamed from: a */
    private C1012m f2829a;

    /* JADX INFO: renamed from: b */
    private String f2830b;

    /* JADX INFO: renamed from: c */
    private String f2831c;

    /* JADX INFO: renamed from: d */
    private C1011l f2832d;

    /* JADX INFO: renamed from: e */
    private int f2833e;

    /* JADX INFO: renamed from: f */
    private int f2834f;

    /* JADX INFO: renamed from: g */
    private C1018s f2835g;

    public C1002c(InputStream inputStream, String str) {
        this.f2830b = str;
        this.f2829a = new C1012m(inputStream);
        try {
            this.f2833e = this.f2829a.m2687a();
            this.f2834f = this.f2829a.m2687a();
            this.f2835g = new C1018s();
            this.f2835g.m2714a(this.f2829a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2663a() {
        try {
            this.f2832d.m2680a(this.f2833e);
            this.f2832d.m2680a(this.f2834f);
            int i = this.f2835g.f2883a;
            this.f2835g.m2713a(this.f2832d);
            byte[] bArr = new byte[4096];
            while (true) {
                int iM2691b = this.f2829a.m2691b(bArr, 0, 4096);
                if (iM2691b <= 0) {
                    new Object[1][0] = Integer.valueOf(this.f2832d.m2679a());
                    this.f2832d.m2681a(4, this.f2832d.m2679a());
                    return;
                }
                this.f2832d.m2683a(bArr, 0, iM2691b);
            }
        } finally {
            m2664a(this.f2832d);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2664a(C1011l c1011l) {
        if (c1011l != null) {
            try {
                c1011l.m2685b();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m2665a(String str, String str2) throws IOException {
        boolean z = false;
        int length = this.f2835g.f2886d.length;
        for (int i = 0; i < length; i++) {
            String strM2716b = this.f2835g.m2716b(i);
            if (strM2716b.startsWith(str)) {
                this.f2835g.m2712a(i, str2 + strM2716b.substring(str.length()));
                z = true;
            }
        }
        if (z) {
            File file = new File(new File(this.f2830b), C1487s.m3525a(6));
            if (file.exists()) {
                file.delete();
            }
            this.f2831c = file.getPath();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file.getPath(), "rw");
            randomAccessFile.setLength(0L);
            this.f2832d = new C1011l(randomAccessFile);
            m2663a();
        }
        return this.f2831c;
    }
}
