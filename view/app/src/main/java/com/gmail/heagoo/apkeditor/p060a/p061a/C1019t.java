package com.gmail.heagoo.apkeditor.p060a.p061a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import p000a.p001a.p003b.p004a.C0028b;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.t */
/* JADX INFO: loaded from: classes.dex */
public final class C1019t {

    /* JADX INFO: renamed from: a */
    private C0028b f2896a;

    /* JADX INFO: renamed from: b */
    private FileOutputStream f2897b;

    /* JADX INFO: renamed from: c */
    private C1020u f2898c;

    /* JADX INFO: renamed from: d */
    private int f2899d;

    /* JADX INFO: renamed from: e */
    private C1020u f2900e;

    /* JADX INFO: renamed from: f */
    private byte[] f2901f;

    /* JADX INFO: renamed from: g */
    private C1020u f2902g;

    /* JADX INFO: renamed from: h */
    private int f2903h;

    /* JADX INFO: renamed from: i */
    private byte[] f2904i;

    /* JADX INFO: renamed from: j */
    private C1021v f2905j;

    public C1019t(InputStream inputStream, String str) throws IOException {
        this.f2896a = new C0028b(inputStream);
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        this.f2897b = new FileOutputStream(file);
        this.f2898c = new C1020u();
        this.f2898c.m2724a(this.f2896a);
        this.f2899d = this.f2896a.readInt();
        this.f2900e = new C1020u();
        this.f2900e.m2724a(this.f2896a);
        this.f2901f = new byte[this.f2900e.f2906a - 8];
        this.f2896a.readFully(this.f2901f);
        this.f2902g = new C1020u();
        this.f2902g.m2724a(this.f2896a);
        this.f2903h = this.f2896a.readInt();
    }

    /* JADX INFO: renamed from: a */
    private void m2719a(int i) throws IOException {
        this.f2897b.write(new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >>> 24)});
    }

    /* JADX INFO: renamed from: a */
    public final void m2720a() throws IOException {
        this.f2898c.m2723a(this.f2898c.f2906a + this.f2905j.m2732a());
        this.f2898c.m2725a(this.f2897b);
        m2719a(this.f2899d);
        if (this.f2905j != null) {
            this.f2905j.m2733a(this.f2897b);
        } else {
            this.f2900e.m2725a(this.f2897b);
            this.f2897b.write(this.f2901f);
        }
        this.f2902g.m2725a(this.f2897b);
        m2719a(this.f2903h);
        if (this.f2904i != null) {
            this.f2897b.write(this.f2904i);
            this.f2896a.skipBytes(256);
        }
        byte[] bArr = new byte[4096];
        int iM40a = this.f2896a.m40a(bArr, 0, 4096);
        while (iM40a > 0) {
            this.f2897b.write(bArr, 0, iM40a);
            iM40a = this.f2896a.m40a(bArr, 0, 4096);
        }
        this.f2897b.close();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m2721a(String str) {
        if (str.length() > 127 || this.f2903h != 127) {
            return false;
        }
        this.f2904i = new byte[256];
        for (int i = 0; i < str.length(); i++) {
            this.f2904i[i * 2] = (byte) str.charAt(i);
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m2722a(String str, String str2, String str3, String str4) {
        this.f2905j = new C1021v(this.f2900e, this.f2901f);
        return this.f2905j.m2734a(str, str2, str3, str4);
    }
}
