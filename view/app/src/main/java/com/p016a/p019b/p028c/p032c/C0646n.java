package com.p016a.p019b.p028c.p032c;

import android.support.v4.view.InputDeviceCompat;
import com.p016a.p017a.p018a.C0400d;
import com.p016a.p019b.p028c.p030b.C0564ab;
import com.p016a.p019b.p028c.p030b.C0565ac;
import com.p016a.p019b.p028c.p030b.C0594s;
import com.p016a.p019b.p028c.p030b.C0596u;
import com.p016a.p019b.p028c.p030b.EnumC0595t;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0803a;
import com.p016a.p019b.p036f.p040d.C0804b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p043h.C0888r;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: renamed from: com.a.b.c.c.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0646n {

    /* JADX INFO: renamed from: a */
    private final C0564ab f1168a;

    /* JADX INFO: renamed from: b */
    private final C0594s f1169b;

    /* JADX INFO: renamed from: d */
    private final C0650r f1171d;

    /* JADX INFO: renamed from: e */
    private final int f1172e;

    /* JADX INFO: renamed from: f */
    private final int f1173f;

    /* JADX INFO: renamed from: g */
    private final C0803a f1174g;

    /* JADX INFO: renamed from: h */
    private final boolean f1175h;

    /* JADX INFO: renamed from: k */
    private C0888r f1178k;

    /* JADX INFO: renamed from: l */
    private PrintWriter f1179l;

    /* JADX INFO: renamed from: m */
    private String f1180m;

    /* JADX INFO: renamed from: n */
    private boolean f1181n;

    /* JADX INFO: renamed from: o */
    private final C0596u[] f1182o;

    /* JADX INFO: renamed from: i */
    private int f1176i = 0;

    /* JADX INFO: renamed from: j */
    private int f1177j = 1;

    /* JADX INFO: renamed from: c */
    private final C0888r f1170c = new C0888r();

    public C0646n(C0564ab c0564ab, C0594s c0594s, C0650r c0650r, int i, int i2, boolean z, C0798v c0798v) {
        this.f1168a = c0564ab;
        this.f1169b = c0594s;
        this.f1171d = c0650r;
        this.f1174g = c0798v.m1618i();
        this.f1175h = z;
        this.f1172e = i;
        this.f1173f = i2;
        this.f1182o = new C0596u[i2];
    }

    /* JADX INFO: renamed from: a */
    private int m1192a(int i) {
        int iD_ = this.f1169b.m1977d_();
        while (i < iD_ && this.f1169b.m1006a(i).m1009a() == this.f1176i) {
            int i2 = i + 1;
            C0596u c0596uM1006a = this.f1169b.m1006a(i);
            int iM1018g = c0596uM1006a.m1018g();
            C0596u c0596u = this.f1182o[iM1018g];
            if (c0596uM1006a != c0596u) {
                this.f1182o[iM1018g] = c0596uM1006a;
                if (c0596uM1006a.m1014c()) {
                    if (c0596u == null || !c0596uM1006a.m1011a(c0596u)) {
                        if (c0596uM1006a.m1016e() != null) {
                            m1203b(c0596uM1006a);
                        } else {
                            int iM2008a = this.f1170c.m2008a();
                            this.f1170c.mo307d(3);
                            m1206d(c0596uM1006a.m1018g());
                            m1198a(c0596uM1006a.m1015d());
                            m1199a(c0596uM1006a.m1017f());
                            if (this.f1178k != null || this.f1179l != null) {
                                m1196a(this.f1170c.m2008a() - iM2008a, String.format("%04x: +local %s", Integer.valueOf(this.f1176i), m1195a(c0596uM1006a)));
                            }
                            i = i2;
                        }
                    } else {
                        if (c0596u.m1014c()) {
                            throw new RuntimeException("shouldn't happen");
                        }
                        int iM2008a2 = this.f1170c.m2008a();
                        this.f1170c.mo307d(6);
                        m1206d(c0596uM1006a.m1018g());
                        if (this.f1178k != null || this.f1179l != null) {
                            m1196a(this.f1170c.m2008a() - iM2008a2, String.format("%04x: +local restart %s", Integer.valueOf(this.f1176i), m1195a(c0596uM1006a)));
                        }
                        i = i2;
                    }
                } else if (c0596uM1006a.m1013b() != EnumC0595t.f1021c) {
                    int iM2008a3 = this.f1170c.m2008a();
                    this.f1170c.mo307d(5);
                    this.f1170c.m2024e(c0596uM1006a.m1018g());
                    if (this.f1178k != null || this.f1179l != null) {
                        m1196a(this.f1170c.m2008a() - iM2008a3, String.format("%04x: -local %s", Integer.valueOf(this.f1176i), m1195a(c0596uM1006a)));
                    }
                }
                i = i2;
            } else {
                i = i2;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    private static int m1193a(int i, int i2) {
        if (i < -4 || i > 10) {
            throw new RuntimeException("Parameter out of range");
        }
        return i + 4 + (i2 * 15) + 10;
    }

    /* JADX INFO: renamed from: a */
    private int m1194a(int i, ArrayList arrayList) {
        int size = arrayList.size();
        while (i < size && ((C0565ac) arrayList.get(i)).m876a() == this.f1176i) {
            m1197a((C0565ac) arrayList.get(i));
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    private static String m1195a(C0596u c0596u) {
        StringBuilder sb = new StringBuilder();
        sb.append("v");
        sb.append(c0596u.m1018g());
        sb.append(' ');
        C0801y c0801yM1015d = c0596u.m1015d();
        if (c0801yM1015d == null) {
            sb.append("null");
        } else {
            sb.append(c0801yM1015d.mo657d());
        }
        sb.append(' ');
        C0802z c0802zM1017f = c0596u.m1017f();
        if (c0802zM1017f == null) {
            sb.append("null");
        } else {
            sb.append(c0802zM1017f.mo657d());
        }
        C0801y c0801yM1016e = c0596u.m1016e();
        if (c0801yM1016e != null) {
            sb.append(' ');
            sb.append(c0801yM1016e.mo657d());
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private void m1196a(int i, String str) {
        if (this.f1180m != null) {
            str = this.f1180m + str;
        }
        if (this.f1178k != null) {
            C0888r c0888r = this.f1178k;
            if (!this.f1181n) {
                i = 0;
            }
            c0888r.m2010a(i, str);
        }
        if (this.f1179l != null) {
            this.f1179l.println(str);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1197a(C0565ac c0565ac) {
        int i;
        int i2;
        int iM1599a = c0565ac.m877b().m1599a();
        int iM876a = c0565ac.m876a();
        int i3 = iM1599a - this.f1177j;
        int i4 = iM876a - this.f1176i;
        if (i4 < 0) {
            throw new RuntimeException("Position entries must be in ascending address order");
        }
        if (i3 < -4 || i3 > 10) {
            m1202b(i3);
            i3 = 0;
        }
        int iM1193a = m1193a(i3, i4);
        if ((iM1193a & InputDeviceCompat.SOURCE_ANY) > 0) {
            m1205c(i4);
            int iM1193a2 = m1193a(i3, 0);
            if ((iM1193a2 & InputDeviceCompat.SOURCE_ANY) > 0) {
                m1202b(i3);
                i = 0;
                iM1193a = m1193a(0, 0);
                i2 = 0;
            } else {
                iM1193a = iM1193a2;
                i = i3;
                i2 = 0;
            }
        } else {
            i = i3;
            i2 = i4;
        }
        this.f1170c.mo307d(iM1193a);
        this.f1177j = i + this.f1177j;
        this.f1176i = i2 + this.f1176i;
        if (this.f1178k == null && this.f1179l == null) {
            return;
        }
        m1196a(1, String.format("%04x: line %d", Integer.valueOf(this.f1176i), Integer.valueOf(this.f1177j)));
    }

    /* JADX INFO: renamed from: a */
    private void m1198a(C0801y c0801y) {
        if (c0801y == null || this.f1171d == null) {
            this.f1170c.m2024e(0);
        } else {
            this.f1170c.m2024e(this.f1171d.m1226h().m1114b(c0801y) + 1);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1199a(C0802z c0802z) {
        if (c0802z == null || this.f1171d == null) {
            this.f1170c.m2024e(0);
        } else {
            this.f1170c.m2024e(this.f1171d.m1229k().m1119b(c0802z) + 1);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1200a(ArrayList arrayList, ArrayList arrayList2) {
        int i;
        C0596u c0596u;
        boolean z = (this.f1178k == null && this.f1179l == null) ? false : true;
        int iM2008a = this.f1170c.m2008a();
        if (arrayList.size() > 0) {
            this.f1177j = ((C0565ac) arrayList.get(0)).m877b().m1599a();
        }
        this.f1170c.m2024e(this.f1177j);
        if (z) {
            m1196a(this.f1170c.m2008a() - iM2008a, "line_start: " + this.f1177j);
        }
        int iM1201b = m1201b();
        C0804b c0804bM1665b = this.f1174g.m1665b();
        int iD_ = c0804bM1665b.m1977d_();
        if (this.f1175h) {
            i = iM1201b;
        } else {
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C0596u c0596u2 = (C0596u) it.next();
                if (iM1201b == c0596u2.m1018g()) {
                    this.f1182o[iM1201b] = c0596u2;
                    break;
                }
            }
            i = iM1201b + 1;
        }
        int iM2008a2 = this.f1170c.m2008a();
        this.f1170c.m2024e(iD_);
        if (z) {
            m1196a(this.f1170c.m2008a() - iM2008a2, String.format("parameters_size: %04x", Integer.valueOf(iD_)));
        }
        int iM1687i = i;
        for (int i2 = 0; i2 < iD_; i2++) {
            C0805c c0805cM1676b = c0804bM1665b.m1676b(i2);
            int iM2008a3 = this.f1170c.m2008a();
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    c0596u = null;
                    break;
                }
                c0596u = (C0596u) it2.next();
                if (iM1687i == c0596u.m1018g()) {
                    if (c0596u.m1016e() != null) {
                        m1198a((C0801y) null);
                    } else {
                        m1198a(c0596u.m1015d());
                    }
                    this.f1182o[iM1687i] = c0596u;
                }
            }
            if (c0596u == null) {
                m1198a((C0801y) null);
            }
            if (z) {
                m1196a(this.f1170c.m2008a() - iM2008a3, "parameter " + ((c0596u == null || c0596u.m1016e() != null) ? "<unnamed>" : c0596u.m1015d().mo657d()) + " v" + iM1687i);
            }
            iM1687i += c0805cM1676b.m1687i();
        }
        for (C0596u c0596u3 : this.f1182o) {
            if (c0596u3 != null && c0596u3.m1016e() != null) {
                m1203b(c0596u3);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private int m1201b() {
        return (this.f1173f - this.f1174g.m1665b().m1678e()) - (this.f1175h ? 0 : 1);
    }

    /* JADX INFO: renamed from: b */
    private void m1202b(int i) {
        int iM2008a = this.f1170c.m2008a();
        this.f1170c.mo307d(2);
        this.f1170c.m2029h(i);
        this.f1177j += i;
        if (this.f1178k == null && this.f1179l == null) {
            return;
        }
        m1196a(this.f1170c.m2008a() - iM2008a, String.format("line = %d", Integer.valueOf(this.f1177j)));
    }

    /* JADX INFO: renamed from: b */
    private void m1203b(C0596u c0596u) {
        int iM2008a = this.f1170c.m2008a();
        this.f1170c.mo307d(4);
        m1206d(c0596u.m1018g());
        m1198a(c0596u.m1015d());
        m1199a(c0596u.m1017f());
        m1198a(c0596u.m1016e());
        if (this.f1178k == null && this.f1179l == null) {
            return;
        }
        m1196a(this.f1170c.m2008a() - iM2008a, String.format("%04x: +localx %s", Integer.valueOf(this.f1176i), m1195a(c0596u)));
    }

    /* JADX INFO: renamed from: c */
    private ArrayList m1204c() {
        ArrayList arrayList = new ArrayList(this.f1174g.m1665b().m1977d_());
        int iM1201b = m1201b();
        BitSet bitSet = new BitSet(this.f1173f - iM1201b);
        int iD_ = this.f1169b.m1977d_();
        for (int i = 0; i < iD_; i++) {
            C0596u c0596uM1006a = this.f1169b.m1006a(i);
            int iM1018g = c0596uM1006a.m1018g();
            if (iM1018g >= iM1201b && !bitSet.get(iM1018g - iM1201b)) {
                bitSet.set(iM1018g - iM1201b);
                arrayList.add(c0596uM1006a);
            }
        }
        Collections.sort(arrayList, new C0648p(this));
        return arrayList;
    }

    /* JADX INFO: renamed from: c */
    private void m1205c(int i) {
        int iM2008a = this.f1170c.m2008a();
        this.f1170c.mo307d(1);
        this.f1170c.m2024e(i);
        this.f1176i += i;
        if (this.f1178k == null && this.f1179l == null) {
            return;
        }
        m1196a(this.f1170c.m2008a() - iM2008a, String.format("%04x: advance pc", Integer.valueOf(this.f1176i)));
    }

    /* JADX INFO: renamed from: d */
    private void m1206d(int i) {
        if (i < 0) {
            throw new RuntimeException("Signed value where unsigned required: " + i);
        }
        this.f1170c.m2024e(i);
    }

    /* JADX INFO: renamed from: a */
    public final byte[] m1207a() {
        int i = 0;
        try {
            int iD_ = this.f1168a == null ? 0 : this.f1168a.m1977d_();
            ArrayList arrayList = new ArrayList(iD_);
            for (int i2 = 0; i2 < iD_; i2++) {
                arrayList.add(this.f1168a.m875a(i2));
            }
            Collections.sort(arrayList, new C0647o(this));
            m1200a(arrayList, m1204c());
            this.f1170c.mo307d(7);
            if (this.f1178k != null || this.f1179l != null) {
                m1196a(1, String.format("%04x: prologue end", Integer.valueOf(this.f1176i)));
            }
            int size = arrayList.size();
            int iD_2 = this.f1169b.m1977d_();
            int i3 = 0;
            while (true) {
                int iM1192a = m1192a(i);
                int iM1194a = m1194a(i3, arrayList);
                int iM1009a = iM1192a < iD_2 ? this.f1169b.m1006a(iM1192a).m1009a() : Integer.MAX_VALUE;
                int iM876a = iM1194a < size ? ((C0565ac) arrayList.get(iM1194a)).m876a() : Integer.MAX_VALUE;
                int iMin = Math.min(iM876a, iM1009a);
                if (iMin == Integer.MAX_VALUE || (iMin == this.f1172e && iM1009a == Integer.MAX_VALUE && iM876a == Integer.MAX_VALUE)) {
                    break;
                }
                if (iMin == iM876a) {
                    i3 = iM1194a + 1;
                    m1197a((C0565ac) arrayList.get(iM1194a));
                    i = iM1192a;
                } else {
                    m1205c(iMin - this.f1176i);
                    i = iM1192a;
                    i3 = iM1194a;
                }
            }
            this.f1170c.mo307d(0);
            if (this.f1178k != null || this.f1179l != null) {
                m1196a(1, "end sequence");
            }
            return this.f1170c.m2028g();
        } catch (IOException e) {
            throw C0400d.m308a(e, "...while encoding debug info");
        }
    }

    /* JADX INFO: renamed from: a */
    public final byte[] m1208a(String str, PrintWriter printWriter, C0888r c0888r, boolean z) {
        this.f1180m = str;
        this.f1179l = printWriter;
        this.f1178k = c0888r;
        this.f1181n = z;
        return m1207a();
    }
}
