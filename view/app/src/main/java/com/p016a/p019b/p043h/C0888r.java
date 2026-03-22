package com.p016a.p019b.p043h;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.p018a.C0400d;
import com.p016a.p017a.p018a.InterfaceC0399c;
import java.io.Writer;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.h.r */
/* JADX INFO: loaded from: classes.dex */
public class C0888r implements InterfaceC0399c {

    /* JADX INFO: renamed from: a */
    private final boolean f2254a;

    /* JADX INFO: renamed from: b */
    private byte[] f2255b;

    /* JADX INFO: renamed from: c */
    private int f2256c;

    /* JADX INFO: renamed from: d */
    private boolean f2257d;

    /* JADX INFO: renamed from: e */
    private ArrayList f2258e;

    /* JADX INFO: renamed from: f */
    private int f2259f;

    /* JADX INFO: renamed from: g */
    private int f2260g;

    public C0888r() {
        this(1000);
    }

    public C0888r(int i) {
        this(new byte[i], true);
    }

    public C0888r(byte[] bArr) {
        this(bArr, false);
    }

    private C0888r(byte[] bArr, boolean z) {
        if (bArr == null) {
            throw new NullPointerException("data == null");
        }
        this.f2254a = z;
        this.f2255b = bArr;
        this.f2256c = 0;
        this.f2257d = false;
        this.f2258e = null;
        this.f2259f = 0;
        this.f2260g = 0;
    }

    /* JADX INFO: renamed from: i */
    private static void m2006i() {
        throw new IndexOutOfBoundsException("attempt to write past the end");
    }

    /* JADX INFO: renamed from: i */
    private void m2007i(int i) {
        if (this.f2255b.length < i) {
            byte[] bArr = new byte[(i << 1) + 1000];
            System.arraycopy(this.f2255b, 0, bArr, 0, this.f2256c);
            this.f2255b = bArr;
        }
    }

    /* JADX INFO: renamed from: a */
    public int m2008a() {
        return this.f2256c;
    }

    /* JADX INFO: renamed from: a */
    public void m2009a(int i) {
        if (this.f2256c != i) {
            throw new C0400d("expected cursor " + i + "; actual value: " + this.f2256c);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2010a(int i, String str) {
        if (this.f2258e == null) {
            return;
        }
        m2022d();
        int size = this.f2258e.size();
        int iM1969b = size == 0 ? 0 : ((C0876f) this.f2258e.get(size - 1)).m1969b();
        if (iM1969b <= this.f2256c) {
            iM1969b = this.f2256c;
        }
        this.f2258e.add(new C0876f(iM1969b, iM1969b + i, str));
    }

    /* JADX INFO: renamed from: a */
    public void m2011a(int i, boolean z) {
        if (this.f2258e != null || this.f2256c != 0) {
            throw new RuntimeException("cannot enable annotations");
        }
        if (i < 40) {
            throw new IllegalArgumentException("annotationWidth < 40");
        }
        int i2 = (((i - 7) / 15) + 1) & (-2);
        int i3 = i2 >= 6 ? i2 > 10 ? 10 : i2 : 6;
        this.f2258e = new ArrayList(1000);
        this.f2259f = i;
        this.f2260g = i3;
        this.f2257d = z;
    }

    /* JADX INFO: renamed from: a */
    public void m2012a(long j) {
        int i = this.f2256c;
        int i2 = i + 8;
        if (this.f2254a) {
            m2007i(i2);
        } else if (i2 > this.f2255b.length) {
            m2006i();
            return;
        }
        int i3 = (int) j;
        this.f2255b[i] = (byte) i3;
        this.f2255b[i + 1] = (byte) (i3 >> 8);
        this.f2255b[i + 2] = (byte) (i3 >> 16);
        this.f2255b[i + 3] = i3 >> 24;
        int i4 = (int) (j >> 32);
        this.f2255b[i + 4] = (byte) i4;
        this.f2255b[i + 5] = (byte) (i4 >> 8);
        this.f2255b[i + 6] = (byte) (i4 >> 16);
        this.f2255b[i + 7] = i4 >> 24;
        this.f2256c = i2;
    }

    /* JADX INFO: renamed from: a */
    public void m2013a(C0873c c0873c) {
        int iM1957a = c0873c.m1957a();
        int i = this.f2256c;
        int i2 = iM1957a + i;
        if (this.f2254a) {
            m2007i(i2);
        } else if (i2 > this.f2255b.length) {
            m2006i();
            return;
        }
        c0873c.m1960a(this.f2255b, i);
        this.f2256c = i2;
    }

    /* JADX INFO: renamed from: a */
    public void m2014a(Writer writer) {
        String strM1971c;
        C0890t c0890t = new C0890t(writer, (this.f2259f - r1) - 1, m2023e(), "|");
        Writer writerM2034a = c0890t.m2034a();
        Writer writerM2035b = c0890t.m2035b();
        int size = this.f2258e.size();
        int i = 0;
        int i2 = 0;
        while (i2 < this.f2256c && i < size) {
            C0876f c0876f = (C0876f) this.f2258e.get(i);
            int iM1967a = c0876f.m1967a();
            if (i2 < iM1967a) {
                strM1971c = "";
            } else {
                int iM1969b = c0876f.m1969b();
                i++;
                strM1971c = c0876f.m1971c();
                iM1967a = iM1969b;
                i2 = iM1967a;
            }
            writerM2034a.write(C0985a.m2201a(this.f2255b, i2, iM1967a - i2, i2, this.f2260g, 6));
            writerM2035b.write(strM1971c);
            c0890t.m2036c();
            i2 = iM1967a;
        }
        if (i2 < this.f2256c) {
            writerM2034a.write(C0985a.m2201a(this.f2255b, i2, this.f2256c - i2, i2, this.f2260g, 6));
        }
        while (i < size) {
            writerM2035b.write(((C0876f) this.f2258e.get(i)).m1971c());
            i++;
        }
        c0890t.m2036c();
    }

    /* JADX INFO: renamed from: a */
    public void m2015a(String str) {
        if (this.f2258e == null) {
            return;
        }
        m2022d();
        this.f2258e.add(new C0876f(this.f2256c, str));
    }

    /* JADX INFO: renamed from: a */
    public void m2016a(byte[] bArr) {
        m2017a(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a */
    public void m2017a(byte[] bArr, int i, int i2) {
        int i3 = this.f2256c;
        int i4 = i3 + i2;
        int i5 = i2 + 0;
        if ((i2 | 0 | i4) < 0 || i5 > bArr.length) {
            throw new IndexOutOfBoundsException("bytes.length " + bArr.length + "; 0..!" + i4);
        }
        if (this.f2254a) {
            m2007i(i4);
        } else if (i4 > this.f2255b.length) {
            m2006i();
            return;
        }
        System.arraycopy(bArr, 0, this.f2255b, i3, i2);
        this.f2256c = i4;
    }

    /* JADX INFO: renamed from: b */
    public void m2018b(int i) {
        int i2 = this.f2256c;
        int i3 = i2 + 2;
        if (this.f2254a) {
            m2007i(i3);
        } else if (i3 > this.f2255b.length) {
            m2006i();
            return;
        }
        this.f2255b[i2] = (byte) i;
        this.f2255b[i2 + 1] = (byte) (i >> 8);
        this.f2256c = i3;
    }

    /* JADX INFO: renamed from: b */
    public boolean m2019b() {
        return this.f2258e != null;
    }

    /* JADX INFO: renamed from: c */
    public void m2020c(int i) {
        int i2 = this.f2256c;
        int i3 = i2 + 4;
        if (this.f2254a) {
            m2007i(i3);
        } else if (i3 > this.f2255b.length) {
            m2006i();
            return;
        }
        this.f2255b[i2] = (byte) i;
        this.f2255b[i2 + 1] = (byte) (i >> 8);
        this.f2255b[i2 + 2] = (byte) (i >> 16);
        this.f2255b[i2 + 3] = i >> 24;
        this.f2256c = i3;
    }

    /* JADX INFO: renamed from: c */
    public boolean m2021c() {
        return this.f2257d;
    }

    /* JADX INFO: renamed from: d */
    public void m2022d() {
        int size;
        if (this.f2258e == null || (size = this.f2258e.size()) == 0) {
            return;
        }
        ((C0876f) this.f2258e.get(size - 1)).m1968a(this.f2256c);
    }

    @Override // com.p016a.p017a.p018a.InterfaceC0399c
    /* JADX INFO: renamed from: d */
    public void mo307d(int i) {
        int i2 = this.f2256c;
        int i3 = i2 + 1;
        if (this.f2254a) {
            m2007i(i3);
        } else if (i3 > this.f2255b.length) {
            m2006i();
            return;
        }
        this.f2255b[i2] = (byte) i;
        this.f2256c = i3;
    }

    /* JADX INFO: renamed from: e */
    public int m2023e() {
        return this.f2259f - (((this.f2260g << 1) + 8) + (this.f2260g / 2));
    }

    /* JADX INFO: renamed from: e */
    public int m2024e(int i) {
        if (this.f2254a) {
            m2007i(this.f2256c + 5);
        }
        int i2 = this.f2256c;
        C0985a.m2207a(this, i);
        return this.f2256c - i2;
    }

    /* JADX INFO: renamed from: f */
    public void m2025f(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("count < 0");
        }
        int i2 = this.f2256c + i;
        if (this.f2254a) {
            m2007i(i2);
        } else if (i2 > this.f2255b.length) {
            m2006i();
            return;
        }
        this.f2256c = i2;
    }

    /* JADX INFO: renamed from: f */
    public byte[] m2026f() {
        return this.f2255b;
    }

    /* JADX INFO: renamed from: g */
    public void m2027g(int i) {
        int i2 = i - 1;
        if (i < 0 || (i2 & i) != 0) {
            throw new IllegalArgumentException("bogus alignment");
        }
        int i3 = (i2 ^ (-1)) & (this.f2256c + i2);
        if (this.f2254a) {
            m2007i(i3);
        } else if (i3 > this.f2255b.length) {
            m2006i();
            return;
        }
        this.f2256c = i3;
    }

    /* JADX INFO: renamed from: g */
    public byte[] m2028g() {
        byte[] bArr = new byte[this.f2256c];
        System.arraycopy(this.f2255b, 0, bArr, 0, this.f2256c);
        return bArr;
    }

    /* JADX INFO: renamed from: h */
    public int m2029h(int i) {
        if (this.f2254a) {
            m2007i(this.f2256c + 5);
        }
        int i2 = this.f2256c;
        C0985a.m2241b(this, i);
        return this.f2256c - i2;
    }

    /* JADX INFO: renamed from: h */
    public void m2030h() {
        m2022d();
        if (this.f2258e != null) {
            for (int size = this.f2258e.size(); size > 0; size--) {
                C0876f c0876f = (C0876f) this.f2258e.get(size - 1);
                if (c0876f.m1967a() <= this.f2256c) {
                    if (c0876f.m1969b() > this.f2256c) {
                        c0876f.m1970b(this.f2256c);
                        return;
                    }
                    return;
                }
                this.f2258e.remove(size - 1);
            }
        }
    }
}
