package com.p016a.p019b.p028c.p030b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p041g.AbstractC0831ag;
import com.p016a.p019b.p043h.C0888r;
import com.p016a.p019b.p043h.C0890t;
import java.util.BitSet;

/* JADX INFO: renamed from: com.a.b.c.b.l */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0587l {

    /* JADX INFO: renamed from: a */
    private int f787a;

    /* JADX INFO: renamed from: b */
    private final C0589n f788b;

    /* JADX INFO: renamed from: c */
    private final C0774z f789c;

    /* JADX INFO: renamed from: d */
    private final C0768t f790d;

    public AbstractC0587l(C0589n c0589n, C0774z c0774z, C0768t c0768t) {
        if (c0589n == null) {
            throw new NullPointerException("opcode == null");
        }
        if (c0774z == null) {
            throw new NullPointerException("position == null");
        }
        if (c0768t == null) {
            throw new NullPointerException("registers == null");
        }
        this.f787a = -1;
        this.f788b = c0589n;
        this.f789c = c0774z;
        this.f790d = c0768t;
    }

    /* JADX INFO: renamed from: a */
    public static C0571ai m951a(C0774z c0774z, C0766r c0766r, C0766r c0766r2) {
        boolean z = c0766r.m1537k() == 1;
        boolean zM1692n = c0766r.mo663a().m1692n();
        int iM1533g = c0766r.m1533g();
        return new C0571ai((c0766r2.m1533g() | iM1533g) < 16 ? zM1692n ? C0590o.f999i : z ? C0590o.f929c : C0590o.f996f : iM1533g < 256 ? zM1692n ? C0590o.f1000j : z ? C0590o.f982d : C0590o.f997g : zM1692n ? C0590o.f1001k : z ? C0590o.f995e : C0590o.f998h, c0774z, C0768t.m1547a(c0766r, c0766r2));
    }

    /* JADX INFO: renamed from: a */
    public abstract int mo840a();

    /* JADX INFO: renamed from: a */
    public final int m952a(BitSet bitSet) {
        boolean zM977d = this.f788b.m977d();
        int iD_ = this.f790d.m1977d_();
        int iM1537k = (!zM977d || bitSet.get(0)) ? 0 : this.f790d.m1553b(0).m1537k();
        int iM1537k2 = 0;
        for (int i = zM977d ? 1 : 0; i < iD_; i++) {
            if (!bitSet.get(i)) {
                iM1537k2 += this.f790d.m1553b(i).m1537k();
            }
        }
        return Math.max(iM1537k2, iM1537k);
    }

    /* JADX INFO: renamed from: a */
    public abstract AbstractC0587l mo900a(C0589n c0589n);

    /* JADX INFO: renamed from: a */
    public abstract AbstractC0587l mo841a(C0768t c0768t);

    /* JADX INFO: renamed from: a */
    public AbstractC0587l mo953a(AbstractC0831ag abstractC0831ag) {
        return mo841a(abstractC0831ag.m1774a(this.f790d));
    }

    /* JADX INFO: renamed from: a */
    public final String m954a(String str, int i, boolean z) {
        String strMo842a = mo842a(z);
        if (strMo842a == null) {
            return null;
        }
        String str2 = str + m965l() + ": ";
        int length = str2.length();
        return C0890t.m2031a(str2, length, "", strMo842a, i == 0 ? strMo842a.length() : i - length);
    }

    /* JADX INFO: renamed from: a */
    protected abstract String mo842a(boolean z);

    /* JADX INFO: renamed from: a */
    public abstract void mo843a(C0888r c0888r);

    /* JADX INFO: renamed from: b */
    public final AbstractC0587l m955b(BitSet bitSet) {
        C0768t c0768t = this.f790d;
        boolean z = bitSet.get(0);
        if (this.f788b.m977d()) {
            bitSet.set(0);
        }
        C0768t c0768tM1551a = c0768t.m1551a(bitSet);
        if (this.f788b.m977d()) {
            bitSet.set(0, z);
        }
        if (c0768tM1551a.m1977d_() == 0) {
            return null;
        }
        return new C0592q(this.f789c, c0768tM1551a);
    }

    /* JADX INFO: renamed from: b */
    protected abstract String mo844b();

    /* JADX INFO: renamed from: c */
    public final AbstractC0587l m956c(BitSet bitSet) {
        if (!this.f788b.m977d() || bitSet.get(0)) {
            return null;
        }
        C0766r c0766rM1553b = this.f790d.m1553b(0);
        return m951a(this.f789c, c0766rM1553b, c0766rM1553b.m1525a(0));
    }

    /* JADX INFO: renamed from: c */
    public final void m957c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("address < 0");
        }
        this.f787a = i;
    }

    /* JADX INFO: renamed from: d */
    public abstract AbstractC0587l mo914d(int i);

    /* JADX INFO: renamed from: d */
    public final AbstractC0587l m958d(BitSet bitSet) {
        return mo841a(this.f790d.m1550a(0, this.f788b.m977d(), bitSet));
    }

    /* JADX INFO: renamed from: f */
    public final boolean m959f() {
        return this.f787a >= 0;
    }

    /* JADX INFO: renamed from: g */
    public final int m960g() {
        if (this.f787a < 0) {
            throw new RuntimeException("address not yet known");
        }
        return this.f787a;
    }

    /* JADX INFO: renamed from: h */
    public final C0589n m961h() {
        return this.f788b;
    }

    /* JADX INFO: renamed from: i */
    public final C0774z m962i() {
        return this.f789c;
    }

    /* JADX INFO: renamed from: j */
    public final C0768t m963j() {
        return this.f790d;
    }

    /* JADX INFO: renamed from: k */
    public final AbstractC0587l m964k() {
        return mo841a(this.f790d.m1550a(0, this.f788b.m977d(), (BitSet) null));
    }

    /* JADX INFO: renamed from: l */
    public final String m965l() {
        return this.f787a != -1 ? String.format("%04x", Integer.valueOf(this.f787a)) : C0985a.m2294t(System.identityHashCode(this));
    }

    /* JADX INFO: renamed from: m */
    public final int m966m() {
        return m960g() + mo840a();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(m965l());
        stringBuffer.append(' ');
        stringBuffer.append(this.f789c);
        stringBuffer.append(": ");
        stringBuffer.append(this.f788b.m978e());
        boolean z = false;
        if (this.f790d.m1977d_() != 0) {
            stringBuffer.append(this.f790d.m1976b(" ", ", ", null));
            z = true;
        }
        String strMo844b = mo844b();
        if (strMo844b != null) {
            if (z) {
                stringBuffer.append(',');
            }
            stringBuffer.append(' ');
            stringBuffer.append(strMo844b);
        }
        return stringBuffer.toString();
    }
}
