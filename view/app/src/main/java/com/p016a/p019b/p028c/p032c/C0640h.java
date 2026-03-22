package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p028c.p030b.C0579d;
import com.p016a.p019b.p028c.p030b.C0580e;
import com.p016a.p019b.p028c.p030b.C0581f;
import com.p016a.p019b.p028c.p030b.C0582g;
import com.p016a.p019b.p028c.p030b.C0585j;
import com.p016a.p019b.p043h.C0888r;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.a.b.c.c.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0640h {

    /* JADX INFO: renamed from: a */
    private final C0585j f1138a;

    /* JADX INFO: renamed from: b */
    private C0581f f1139b = null;

    /* JADX INFO: renamed from: c */
    private byte[] f1140c = null;

    /* JADX INFO: renamed from: d */
    private int f1141d = 0;

    /* JADX INFO: renamed from: e */
    private TreeMap f1142e = null;

    public C0640h(C0585j c0585j) {
        this.f1138a = c0585j;
    }

    /* JADX INFO: renamed from: a */
    private static void m1151a(C0579d c0579d, int i, int i2, String str, PrintWriter printWriter, C0888r c0888r) {
        String strM922a = c0579d.m922a(str, C0985a.m2296v(i) + ": ");
        if (printWriter != null) {
            printWriter.println(strM922a);
        }
        c0888r.m2010a(i2, strM922a);
    }

    /* JADX INFO: renamed from: a */
    private void m1152a(String str, PrintWriter printWriter, C0888r c0888r) {
        int i = 0;
        m1153c();
        boolean z = c0888r != null;
        int i2 = z ? 6 : 0;
        int i3 = z ? 2 : 0;
        int iD_ = this.f1139b.m1977d_();
        String str2 = str + "  ";
        if (z) {
            c0888r.m2010a(0, str + "tries:");
        } else {
            printWriter.println(str + "tries:");
        }
        for (int i4 = 0; i4 < iD_; i4++) {
            C0582g c0582gM928a = this.f1139b.m928a(i4);
            C0579d c0579dM933c = c0582gM928a.m933c();
            String str3 = str2 + "try " + C0985a.m2297w(c0582gM928a.m930a()) + ".." + C0985a.m2297w(c0582gM928a.m932b());
            String strM922a = c0579dM933c.m922a(str2, "");
            if (z) {
                c0888r.m2010a(i2, str3);
                c0888r.m2010a(i3, strM922a);
            } else {
                printWriter.println(str3);
                printWriter.println(strM922a);
            }
        }
        if (z) {
            c0888r.m2010a(0, str + "handlers:");
            c0888r.m2010a(this.f1141d, str2 + "size: " + C0985a.m2296v(this.f1142e.size()));
            C0579d c0579d = null;
            for (Map.Entry entry : this.f1142e.entrySet()) {
                C0579d c0579d2 = (C0579d) entry.getKey();
                int iIntValue = ((Integer) entry.getValue()).intValue();
                if (c0579d != null) {
                    m1151a(c0579d, i, iIntValue - i, str2, printWriter, c0888r);
                }
                c0579d = c0579d2;
                i = iIntValue;
            }
            m1151a(c0579d, i, this.f1140c.length - i, str2, printWriter, c0888r);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m1153c() {
        if (this.f1139b == null) {
            this.f1139b = this.f1138a.m948g();
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m1154a() {
        m1153c();
        return this.f1139b.m1977d_();
    }

    /* JADX INFO: renamed from: a */
    public final void m1155a(C0650r c0650r) {
        int i;
        m1153c();
        C0630ba c0630baM1229k = c0650r.m1229k();
        int iD_ = this.f1139b.m1977d_();
        this.f1142e = new TreeMap();
        for (int i2 = 0; i2 < iD_; i2++) {
            this.f1142e.put(this.f1139b.m928a(i2).m933c(), null);
        }
        if (this.f1142e.size() > 65535) {
            throw new UnsupportedOperationException("too many catch handlers");
        }
        C0888r c0888r = new C0888r();
        this.f1141d = c0888r.m2024e(this.f1142e.size());
        for (Map.Entry entry : this.f1142e.entrySet()) {
            C0579d c0579d = (C0579d) entry.getKey();
            int iD_2 = c0579d.m1977d_();
            boolean zM924e = c0579d.m924e();
            entry.setValue(Integer.valueOf(c0888r.m2008a()));
            if (zM924e) {
                c0888r.m2029h(-(iD_2 - 1));
                i = iD_2 - 1;
            } else {
                c0888r.m2029h(iD_2);
                i = iD_2;
            }
            for (int i3 = 0; i3 < i; i3++) {
                C0580e c0580eM921a = c0579d.m921a(i3);
                c0888r.m2024e(c0630baM1229k.m1119b(c0580eM921a.m926a()));
                c0888r.m2024e(c0580eM921a.m927b());
            }
            if (zM924e) {
                c0888r.m2024e(c0579d.m921a(i).m927b());
            }
        }
        this.f1140c = c0888r.m2028g();
    }

    /* JADX INFO: renamed from: a */
    public final void m1156a(C0888r c0888r) {
        m1153c();
        if (c0888r.m2019b()) {
            m1152a("  ", null, c0888r);
        }
        int iD_ = this.f1139b.m1977d_();
        for (int i = 0; i < iD_; i++) {
            C0582g c0582gM928a = this.f1139b.m928a(i);
            int iM930a = c0582gM928a.m930a();
            int iM932b = c0582gM928a.m932b();
            int i2 = iM932b - iM930a;
            if (i2 >= 65536) {
                throw new UnsupportedOperationException("bogus exception range: " + C0985a.m2294t(iM930a) + ".." + C0985a.m2294t(iM932b));
            }
            c0888r.m2020c(iM930a);
            c0888r.m2018b(i2);
            c0888r.m2018b(((Integer) this.f1142e.get(c0582gM928a.m933c())).intValue());
        }
        c0888r.m2016a(this.f1140c);
    }

    /* JADX INFO: renamed from: a */
    public final void m1157a(PrintWriter printWriter, String str) {
        m1152a(str, printWriter, null);
    }

    /* JADX INFO: renamed from: b */
    public final int m1158b() {
        return (m1154a() << 3) + this.f1140c.length;
    }
}
