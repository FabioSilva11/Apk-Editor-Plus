package com.p016a.p017a;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.util.Arrays;

/* JADX INFO: renamed from: com.a.a.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0427z {

    /* JADX INFO: renamed from: t */
    public int f441t;

    /* JADX INFO: renamed from: v */
    public int f443v;

    /* JADX INFO: renamed from: w */
    public int f444w;

    /* JADX INFO: renamed from: x */
    public int f445x;

    /* JADX INFO: renamed from: y */
    public int f446y;

    /* JADX INFO: renamed from: z */
    public int f447z;

    /* JADX INFO: renamed from: a */
    public final C0401aa f422a = new C0401aa(0);

    /* JADX INFO: renamed from: b */
    public final C0401aa f423b = new C0401aa(1);

    /* JADX INFO: renamed from: c */
    public final C0401aa f424c = new C0401aa(2);

    /* JADX INFO: renamed from: d */
    public final C0401aa f425d = new C0401aa(3);

    /* JADX INFO: renamed from: e */
    public final C0401aa f426e = new C0401aa(4);

    /* JADX INFO: renamed from: f */
    public final C0401aa f427f = new C0401aa(5);

    /* JADX INFO: renamed from: g */
    public final C0401aa f428g = new C0401aa(6);

    /* JADX INFO: renamed from: h */
    public final C0401aa f429h = new C0401aa(4096);

    /* JADX INFO: renamed from: i */
    public final C0401aa f430i = new C0401aa(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

    /* JADX INFO: renamed from: j */
    public final C0401aa f431j = new C0401aa(InputDeviceCompat.SOURCE_TOUCHSCREEN);

    /* JADX INFO: renamed from: k */
    public final C0401aa f432k = new C0401aa(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

    /* JADX INFO: renamed from: l */
    public final C0401aa f433l = new C0401aa(8192);

    /* JADX INFO: renamed from: m */
    public final C0401aa f434m = new C0401aa(8193);

    /* JADX INFO: renamed from: n */
    public final C0401aa f435n = new C0401aa(8194);

    /* JADX INFO: renamed from: o */
    public final C0401aa f436o = new C0401aa(8195);

    /* JADX INFO: renamed from: p */
    public final C0401aa f437p = new C0401aa(8196);

    /* JADX INFO: renamed from: q */
    public final C0401aa f438q = new C0401aa(8197);

    /* JADX INFO: renamed from: r */
    public final C0401aa f439r = new C0401aa(8198);

    /* JADX INFO: renamed from: s */
    public final C0401aa[] f440s = {this.f422a, this.f423b, this.f424c, this.f425d, this.f426e, this.f427f, this.f428g, this.f429h, this.f430i, this.f431j, this.f432k, this.f433l, this.f434m, this.f435n, this.f436o, this.f437p, this.f438q, this.f439r};

    /* JADX INFO: renamed from: u */
    public byte[] f442u = new byte[20];

    /* JADX INFO: renamed from: a */
    private void m440a(C0416o c0416o) {
        int iM385b = c0416o.m385b();
        int i = 0;
        C0401aa c0401aa = null;
        while (i < iM385b) {
            short sM387c = c0416o.m387c();
            c0416o.m387c();
            C0401aa[] c0401aaArr = this.f440s;
            for (int i2 = 0; i2 < 18; i2++) {
                C0401aa c0401aa2 = c0401aaArr[i2];
                if (c0401aa2.f341a == sM387c) {
                    int iM385b2 = c0416o.m385b();
                    int iM385b3 = c0416o.m385b();
                    if ((c0401aa2.f342b != 0 && c0401aa2.f342b != iM385b2) || (c0401aa2.f343c != -1 && c0401aa2.f343c != iM385b3)) {
                        throw new C0420s("Unexpected map value for 0x" + Integer.toHexString(sM387c));
                    }
                    c0401aa2.f342b = iM385b2;
                    c0401aa2.f343c = iM385b3;
                    if (c0401aa != null && c0401aa.f343c > c0401aa2.f343c) {
                        throw new C0420s("Map is unsorted at " + c0401aa + ", " + c0401aa2);
                    }
                    i++;
                    c0401aa = c0401aa2;
                }
            }
            throw new IllegalArgumentException("No such map item: " + ((int) sM387c));
        }
        Arrays.sort(this.f440s);
    }

    /* JADX INFO: renamed from: a */
    public final void m441a() {
        int i = this.f446y + this.f447z;
        for (int i2 = 17; i2 >= 0; i2--) {
            C0401aa c0401aa = this.f440s[i2];
            if (c0401aa.f343c != -1) {
                if (c0401aa.f343c > i) {
                    throw new C0420s("Map is unsorted at " + c0401aa);
                }
                c0401aa.f344d = i - c0401aa.f343c;
                i = c0401aa.f343c;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m442a(C0410i c0410i) {
        C0416o c0416oM354a = c0410i.m354a(0);
        byte[] bArrM384a = c0416oM354a.m384a(8);
        if (C0985a.m2233b(bArrM384a) != 13) {
            throw new C0420s("Unexpected magic: " + Arrays.toString(bArrM384a));
        }
        this.f441t = c0416oM354a.m385b();
        this.f442u = c0416oM354a.m384a(20);
        this.f443v = c0416oM354a.m385b();
        int iM385b = c0416oM354a.m385b();
        if (iM385b != 112) {
            throw new C0420s("Unexpected header: 0x" + Integer.toHexString(iM385b));
        }
        int iM385b2 = c0416oM354a.m385b();
        if (iM385b2 != 305419896) {
            throw new C0420s("Unexpected endian tag: 0x" + Integer.toHexString(iM385b2));
        }
        this.f444w = c0416oM354a.m385b();
        this.f445x = c0416oM354a.m385b();
        this.f429h.f343c = c0416oM354a.m385b();
        if (this.f429h.f343c == 0) {
            throw new C0420s("Cannot merge dex files that do not contain a map");
        }
        this.f423b.f342b = c0416oM354a.m385b();
        this.f423b.f343c = c0416oM354a.m385b();
        this.f424c.f342b = c0416oM354a.m385b();
        this.f424c.f343c = c0416oM354a.m385b();
        this.f425d.f342b = c0416oM354a.m385b();
        this.f425d.f343c = c0416oM354a.m385b();
        this.f426e.f342b = c0416oM354a.m385b();
        this.f426e.f343c = c0416oM354a.m385b();
        this.f427f.f342b = c0416oM354a.m385b();
        this.f427f.f343c = c0416oM354a.m385b();
        this.f428g.f342b = c0416oM354a.m385b();
        this.f428g.f343c = c0416oM354a.m385b();
        this.f446y = c0416oM354a.m385b();
        this.f447z = c0416oM354a.m385b();
        m440a(c0410i.m354a(this.f429h.f343c));
        m441a();
    }
}
