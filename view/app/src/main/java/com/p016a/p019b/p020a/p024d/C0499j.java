package com.p016a.p019b.p020a.p024d;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p022b.C0462ak;
import com.p016a.p019b.p020a.p022b.C0469g;
import com.p016a.p019b.p020a.p022b.InterfaceC0473k;
import com.p016a.p019b.p020a.p025e.InterfaceC0515j;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0786j;
import com.p016a.p019b.p036f.p039c.C0789m;
import com.p016a.p019b.p036f.p039c.C0790n;
import com.p016a.p019b.p036f.p039c.C0792p;
import com.p016a.p019b.p036f.p039c.C0796t;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p043h.C0873c;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.a.d.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0499j implements InterfaceC0473k {

    /* JADX INFO: renamed from: a */
    private final C0873c f624a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC0515j f625b;

    public C0499j(C0873c c0873c, InterfaceC0515j interfaceC0515j) {
        if (c0873c == null) {
            throw new NullPointerException("bytes == null");
        }
        if (interfaceC0515j == null) {
            throw new NullPointerException("observer == null");
        }
        this.f624a = c0873c;
        this.f625b = interfaceC0515j;
    }

    /* JADX INFO: renamed from: b */
    private String m734b(int i) {
        int iM1965e = this.f624a.m1965e(i);
        String strM575a = C0469g.m575a(iM1965e);
        if (iM1965e == 196) {
            strM575a = strM575a + " " + C0469g.m575a(this.f624a.m1965e(i + 1));
        }
        return C0985a.m2296v(i) + ": " + strM575a;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final int mo534a() {
        return -1;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo535a(int i) {
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo536a(int i, int i2, int i3) {
        m734b(i2);
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo537a(int i, int i2, int i3, int i4) {
        new StringBuilder().append(m734b(i2)).append(" ").append(i3 <= 3 ? C0985a.m2296v(i4) : C0985a.m2294t(i4));
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo538a(int i, int i2, int i3, int i4, C0805c c0805c, int i5) {
        String strM2298x = i3 <= 3 ? C0985a.m2298x(i4) : C0985a.m2296v(i4);
        boolean z = i3 == 1;
        String str = "";
        if (i == 132) {
            str = ", #" + (i3 <= 3 ? C0985a.m2169B(i5) : C0985a.m2168A(i5));
        }
        String str2 = "";
        if (c0805c.m1689k()) {
            str2 = (z ? "," : " //") + " category-2";
        }
        new StringBuilder().append(m734b(i2)).append(z ? " // " : " ").append(strM2298x).append(str).append(str2);
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo539a(int i, int i2, int i3, C0462ak c0462ak, int i4) {
        int iM544a = c0462ak.m544a();
        StringBuffer stringBuffer = new StringBuffer((iM544a * 20) + 100);
        stringBuffer.append(m734b(i2));
        if (i4 != 0) {
            stringBuffer.append(" // padding: " + C0985a.m2294t(i4));
        }
        stringBuffer.append('\n');
        for (int i5 = 0; i5 < iM544a; i5++) {
            stringBuffer.append("  ");
            stringBuffer.append(C0985a.m2300z(c0462ak.m545a(i5)));
            stringBuffer.append(": ");
            stringBuffer.append(C0985a.m2296v(c0462ak.m548b(i5)));
            stringBuffer.append('\n');
        }
        stringBuffer.append("  default: ");
        stringBuffer.append(C0985a.m2296v(c0462ak.m547b()));
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo540a(int i, int i2, int i3, AbstractC0775a abstractC0775a, int i4) {
        if (abstractC0775a instanceof C0792p) {
            m734b(i2);
            return;
        }
        if (abstractC0775a instanceof C0790n) {
            String str = i3 == 1 ? " // " : " ";
            int iM1965e = this.f624a.m1965e(i2);
            new StringBuilder().append(m734b(i2)).append(str).append((i3 == 1 || iM1965e == 16) ? "#" + C0985a.m2169B(i4) : iM1965e == 17 ? "#" + C0985a.m2168A(i4) : "#" + C0985a.m2300z(i4));
        } else if (abstractC0775a instanceof C0796t) {
            long jK = ((C0796t) abstractC0775a).mo1633k();
            new StringBuilder().append(m734b(i2)).append(i3 == 1 ? " // " : " #").append(i3 == 1 ? C0985a.m2169B((int) jK) : C0985a.m2237b(jK));
        } else if (abstractC0775a instanceof C0789m) {
            int iJ = ((C0789m) abstractC0775a).mo1632j();
            new StringBuilder().append(m734b(i2)).append(i3 != 1 ? " #" + C0985a.m2294t(iJ) : "").append(" // ").append(Float.intBitsToFloat(iJ));
        } else if (!(abstractC0775a instanceof C0786j)) {
            new StringBuilder().append(m734b(i2)).append(" ").append(abstractC0775a).append(i4 != 0 ? i == 197 ? ", " + C0985a.m2298x(i4) : ", " + C0985a.m2296v(i4) : "");
        } else {
            long jK2 = ((C0786j) abstractC0775a).mo1633k();
            new StringBuilder().append(m734b(i2)).append(i3 != 1 ? " #" + C0985a.m2193a(jK2) : "").append(" // ").append(Double.longBitsToDouble(jK2));
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo541a(int i, int i2, int i3, C0805c c0805c) {
        m734b(i2);
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo542a(int i, int i2, C0802z c0802z, ArrayList arrayList) {
        new StringBuilder().append(m734b(i)).append(i2 == 1 ? " // " : " ").append(c0802z.m1655i().m1697s().mo657d());
    }
}
