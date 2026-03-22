package com.gmail.heagoo.apkeditor.util;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.k */
/* JADX INFO: loaded from: classes.dex */
final class C1387k {

    /* JADX INFO: renamed from: a */
    String f4025a;

    /* JADX INFO: renamed from: b */
    List f4026b;

    /* JADX INFO: renamed from: c */
    private List f4027c;

    private C1387k(String str, String str2, int i, String str3, String str4) {
        this.f4026b = new ArrayList();
        this.f4027c = new ArrayList();
        this.f4025a = str2.startsWith("/") ? str2 : str + str2;
        this.f4026b.add(new C1386j(i > 0 ? i - 1 : 0, str3, str4, (byte) 0));
    }

    /* synthetic */ C1387k(String str, String str2, int i, String str3, String str4, byte b2) {
        this(str, str2, i, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public C1385i m3346a(int i) {
        for (C1385i c1385i : this.f4027c) {
            if (c1385i.f4021a == i) {
                return c1385i;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final void m3348a() {
        for (C1386j c1386j : this.f4026b) {
            C1385i c1385iM3346a = m3346a(c1386j.f4023a);
            if (c1385iM3346a == null) {
                c1385iM3346a = new C1385i(c1386j.f4023a, (byte) 0);
                this.f4027c.add(c1385iM3346a);
            }
            c1385iM3346a.f4022b.add(c1386j.f4024b);
        }
    }
}
