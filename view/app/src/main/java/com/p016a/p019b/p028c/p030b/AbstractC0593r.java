package com.p016a.p019b.p028c.p030b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.AbstractC0794r;
import com.p016a.p019b.p036f.p039c.AbstractC0795s;
import com.p016a.p019b.p036f.p039c.C0792p;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p043h.C0888r;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.c.b.r */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0593r {
    /* JADX INFO: renamed from: a */
    protected static String m986a(C0768t c0768t) {
        int iD_ = c0768t.m1977d_();
        StringBuffer stringBuffer = new StringBuffer((iD_ * 5) + 2);
        stringBuffer.append('{');
        for (int i = 0; i < iD_; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(c0768t.m1553b(i).m1539m());
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    protected static String m987a(AbstractC0795s abstractC0795s) {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append('#');
        if (abstractC0795s instanceof C0792p) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append(abstractC0795s.mo1604h());
            stringBuffer.append(' ');
            stringBuffer.append(abstractC0795s.mo657d());
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    protected static String m988a(AbstractC0795s abstractC0795s, int i) {
        StringBuffer stringBuffer = new StringBuffer(20);
        stringBuffer.append("#");
        long jMo1633k = abstractC0795s instanceof AbstractC0794r ? ((AbstractC0794r) abstractC0795s).mo1633k() : abstractC0795s.mo1632j();
        switch (i) {
            case 4:
                stringBuffer.append(C0985a.m2299y((int) jMo1633k));
                break;
            case 8:
                stringBuffer.append(C0985a.m2298x((int) jMo1633k));
                break;
            case 16:
                stringBuffer.append(C0985a.m2296v((int) jMo1633k));
                break;
            case 32:
                stringBuffer.append(C0985a.m2294t((int) jMo1633k));
                break;
            case 64:
                stringBuffer.append(C0985a.m2193a(jMo1633k));
                break;
            default:
                throw new RuntimeException("shouldn't happen");
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    protected static short m989a(int i, int i2) {
        if ((i & 255) != i) {
            throw new IllegalArgumentException("low out of range 0..255");
        }
        if ((i2 & 255) != i2) {
            throw new IllegalArgumentException("high out of range 0..255");
        }
        return (short) ((i2 << 8) | i);
    }

    /* JADX INFO: renamed from: a */
    protected static short m990a(AbstractC0587l abstractC0587l, int i) {
        if ((i & 255) != i) {
            throw new IllegalArgumentException("arg out of range 0..255");
        }
        int iM974a = abstractC0587l.m961h().m974a();
        if ((iM974a & 255) != iM974a) {
            throw new IllegalArgumentException("opcode out of range 0..255");
        }
        return (short) (iM974a | (i << 8));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, short] */
    /* JADX INFO: renamed from: a */
    protected static void m991a(C0888r c0888r, short s, int i) {
        m994a(c0888r, s, (short) i, i >> 16);
    }

    /* JADX INFO: renamed from: a */
    protected static void m992a(C0888r c0888r, short s, long j) {
        c0888r.m2018b(s);
        c0888r.m2018b((short) j);
        c0888r.m2018b((short) (j >> 16));
        c0888r.m2018b((short) (j >> 32));
        c0888r.m2018b((short) (j >> 48));
    }

    /* JADX INFO: renamed from: a */
    protected static void m993a(C0888r c0888r, short s, short s2) {
        c0888r.m2018b(s);
        c0888r.m2018b(s2);
    }

    /* JADX INFO: renamed from: a */
    protected static void m994a(C0888r c0888r, short s, short s2, short s3) {
        c0888r.m2018b(s);
        c0888r.m2018b(s2);
        c0888r.m2018b(s3);
    }

    /* JADX INFO: renamed from: a */
    protected static boolean m995a(int i) {
        return i == (i & 15);
    }

    /* JADX INFO: renamed from: b */
    protected static int m996b(int i, int i2) {
        if ((i & 15) != i) {
            throw new IllegalArgumentException("low out of range 0..15");
        }
        if ((i2 & 15) != i2) {
            throw new IllegalArgumentException("high out of range 0..15");
        }
        return (i2 << 4) | i;
    }

    /* JADX INFO: renamed from: b */
    protected static boolean m997b(int i) {
        return ((byte) i) == i;
    }

    /* JADX INFO: renamed from: c */
    protected static boolean m998c(int i) {
        return i == (i & 255);
    }

    /* JADX INFO: renamed from: d */
    protected static String m999d(AbstractC0587l abstractC0587l) {
        int iM911d = ((C0574al) abstractC0587l).m911d();
        return iM911d == ((char) iM911d) ? C0985a.m2296v(iM911d) : C0985a.m2294t(iM911d);
    }

    /* JADX INFO: renamed from: d */
    protected static boolean m1000d(int i) {
        return ((short) i) == i;
    }

    /* JADX INFO: renamed from: e */
    protected static String m1001e(AbstractC0587l abstractC0587l) {
        int iM912e = ((C0574al) abstractC0587l).m912e();
        return iM912e == ((short) iM912e) ? C0985a.m2168A(iM912e) : C0985a.m2300z(iM912e);
    }

    /* JADX INFO: renamed from: e */
    protected static boolean m1002e(int i) {
        return i == (65535 & i);
    }

    /* JADX INFO: renamed from: f */
    protected static String m1003f(AbstractC0587l abstractC0587l) {
        AbstractC0775a abstractC0775aM937c = ((C0584i) abstractC0587l).m937c();
        return abstractC0775aM937c instanceof C0801y ? ((C0801y) abstractC0775aM937c).m1648i() : abstractC0775aM937c.mo657d();
    }

    /* JADX INFO: renamed from: g */
    protected static String m1004g(AbstractC0587l abstractC0587l) {
        C0584i c0584i = (C0584i) abstractC0587l;
        if (!c0584i.m939e()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(20);
        int iM938d = c0584i.m938d();
        sb.append(c0584i.m937c().mo1604h());
        sb.append('@');
        if (iM938d < 65536) {
            sb.append(C0985a.m2296v(iM938d));
        } else {
            sb.append(C0985a.m2294t(iM938d));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public abstract int mo845a();

    /* JADX INFO: renamed from: a */
    public abstract String mo846a(AbstractC0587l abstractC0587l);

    /* JADX INFO: renamed from: a */
    public abstract String mo847a(AbstractC0587l abstractC0587l, boolean z);

    /* JADX INFO: renamed from: a */
    public abstract void mo848a(C0888r c0888r, AbstractC0587l abstractC0587l);

    /* JADX INFO: renamed from: a */
    public boolean mo849a(C0574al c0574al) {
        return false;
    }

    /* JADX INFO: renamed from: b */
    public abstract boolean mo850b(AbstractC0587l abstractC0587l);

    /* JADX INFO: renamed from: c */
    public BitSet mo851c(AbstractC0587l abstractC0587l) {
        return new BitSet();
    }
}
