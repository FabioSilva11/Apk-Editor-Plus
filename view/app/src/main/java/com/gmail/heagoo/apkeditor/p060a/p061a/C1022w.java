package com.gmail.heagoo.apkeditor.p060a.p061a;

import jadx.core.codegen.CodeWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.w */
/* JADX INFO: loaded from: classes.dex */
public final class C1022w {

    /* JADX INFO: renamed from: a */
    private int f2922a;

    /* JADX INFO: renamed from: b */
    private byte[] f2923b;

    /* JADX INFO: renamed from: c */
    private int f2924c;

    /* JADX INFO: renamed from: d */
    private String f2925d;

    /* JADX INFO: renamed from: e */
    private List f2926e;

    /* JADX INFO: renamed from: f */
    private C1022w f2927f;

    /* JADX INFO: renamed from: g */
    private C1018s f2928g;

    /* JADX INFO: renamed from: h */
    private C1017r f2929h;

    C1022w(int i, byte[] bArr, C1018s c1018s, C1017r c1017r, int i2) {
        this.f2922a = i;
        this.f2923b = bArr;
        this.f2928g = c1018s;
        this.f2929h = c1017r;
        this.f2924c = i2;
        switch (i) {
            case 1048834:
                this.f2926e = m2739d();
                break;
            case 1048835:
                if (this.f2923b.length >= 24) {
                    this.f2925d = this.f2928g.m2716b(C1004e.m2667a(this.f2923b, 20));
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m2737b(int[] iArr, byte[] bArr, int i) {
        int iM2667a = C1004e.m2667a(bArr, i);
        if (iM2667a < 0 || iM2667a >= iArr.length) {
            return;
        }
        C1004e.m2673a(bArr, i, iArr[iM2667a]);
    }

    /* JADX INFO: renamed from: d */
    private List m2739d() {
        ArrayList arrayList = null;
        int iM2667a = C1004e.m2667a(this.f2923b, 0);
        int iM2667a2 = C1004e.m2667a(this.f2923b, 4);
        if (iM2667a == 1048834 && iM2667a2 == this.f2923b.length) {
            this.f2925d = this.f2928g.m2716b(C1004e.m2667a(this.f2923b, 20));
            byte[] bArr = this.f2923b;
            int i = (bArr[28] & 255) | ((bArr[29] & 255) << 8);
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new C1023x(this, this.f2923b, (i2 * 20) + 36));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: e */
    private String m2740e() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f2924c; i++) {
            sb.append(CodeWriter.INDENT);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public final int m2741a() {
        return this.f2922a;
    }

    /* JADX INFO: renamed from: a */
    public final void m2742a(int i, int i2, int i3, int i4) {
        int length = this.f2923b.length;
        byte[] bArr = new byte[this.f2923b.length + 20];
        System.arraycopy(this.f2923b, 0, bArr, 0, 36);
        System.arraycopy(this.f2923b, 36, bArr, 56, length - 36);
        C1004e.m2673a(bArr, 36, this.f2928g.m2710a("android"));
        C1004e.m2673a(bArr, 40, i);
        C1004e.m2673a(bArr, 44, i2);
        C1004e.m2673a(bArr, 48, i3);
        C1004e.m2673a(bArr, 52, i4);
        C1004e.m2673a(bArr, 4, length + 20);
        int size = (this.f2926e != null ? this.f2926e.size() : 0) + 1;
        C1004e.m2673a(bArr, 28, size);
        this.f2923b = bArr;
        this.f2926e = new ArrayList();
        for (int i5 = 0; i5 < size; i5++) {
            this.f2926e.add(new C1023x(this, this.f2923b, (i5 * 20) + 36));
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2743a(C1011l c1011l) throws IOException {
        c1011l.m2682a(this.f2923b);
    }

    /* JADX INFO: renamed from: a */
    protected final void m2744a(C1022w c1022w) {
        this.f2927f = c1022w;
    }

    /* JADX INFO: renamed from: a */
    protected final void m2745a(int[] iArr) {
        if (this.f2922a == 1048834) {
            m2737b(iArr, this.f2923b, 16);
            m2737b(iArr, this.f2923b, 20);
            if (this.f2926e != null) {
                Iterator it = this.f2926e.iterator();
                while (it.hasNext()) {
                    C1023x.m2748a((C1023x) it.next(), iArr);
                }
                return;
            }
            return;
        }
        if (this.f2922a == 1048835) {
            m2737b(iArr, this.f2923b, 16);
            m2737b(iArr, this.f2923b, 20);
        } else if (this.f2922a == 1048833) {
            m2737b(iArr, this.f2923b, 16);
            m2737b(iArr, this.f2923b, 20);
        } else if (this.f2922a == 1048832) {
            m2737b(iArr, this.f2923b, 16);
            m2737b(iArr, this.f2923b, 20);
        }
    }

    /* JADX INFO: renamed from: b */
    public final String m2746b() {
        ArrayList arrayList = new ArrayList();
        while (this != null) {
            arrayList.add(this.f2925d);
            this = this.f2927f;
        }
        StringBuilder sb = new StringBuilder();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            sb.append((String) arrayList.get(size));
            sb.append("/");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* JADX INFO: renamed from: c */
    public final List m2747c() {
        return this.f2926e;
    }

    public final String toString() {
        switch (this.f2922a) {
            case 1048834:
                StringBuilder sb = new StringBuilder();
                sb.append(m2740e());
                sb.append("<");
                sb.append(this.f2925d);
                if (this.f2926e != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < this.f2926e.size()) {
                            sb.append(" ");
                            sb.append(((C1023x) this.f2926e.get(i2)).toString());
                            i = i2 + 1;
                        }
                    }
                }
                sb.append(">");
                return sb.toString();
            case 1048835:
                return m2740e() + "</" + this.f2925d + ">";
            default:
                return m2740e() + "<unsupported tag>: " + this.f2922a;
        }
    }
}
