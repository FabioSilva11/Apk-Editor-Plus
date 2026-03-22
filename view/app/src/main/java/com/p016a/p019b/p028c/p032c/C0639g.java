package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p037a.C0742c;
import com.p016a.p019b.p036f.p037a.C0743d;
import com.p016a.p019b.p036f.p039c.C0788l;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p043h.C0888r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: renamed from: com.a.b.c.c.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0639g extends AbstractC0618ap {

    /* JADX INFO: renamed from: a */
    private C0636d f1134a;

    /* JADX INFO: renamed from: b */
    private ArrayList f1135b;

    /* JADX INFO: renamed from: c */
    private ArrayList f1136c;

    /* JADX INFO: renamed from: d */
    private ArrayList f1137d;

    public C0639g() {
        super(4, -1);
        this.f1134a = null;
        this.f1135b = null;
        this.f1136c = null;
        this.f1137d = null;
    }

    /* JADX INFO: renamed from: a */
    private static int m1142a(ArrayList arrayList) {
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    public final int mo1039a(AbstractC0618ap abstractC0618ap) {
        if (m1150d()) {
            return this.f1134a.compareTo(((C0639g) abstractC0618ap).f1134a);
        }
        throw new UnsupportedOperationException("uninternable instance");
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1062r;
    }

    /* JADX INFO: renamed from: a */
    public final C0742c m1143a(C0798v c0798v) {
        if (this.f1136c == null) {
            return null;
        }
        for (C0611ai c0611ai : this.f1136c) {
            if (c0611ai.m1062a().equals(c0798v)) {
                return c0611ai.m1065b();
            }
        }
        return null;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    protected final void mo1041a(AbstractC0622at abstractC0622at, int i) {
        m1080a((((m1142a(this.f1135b) + m1142a(this.f1136c)) + m1142a(this.f1137d)) << 3) + 16);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
        C0614al c0614alM1223e = c0650r.m1223e();
        if (this.f1134a != null) {
            this.f1134a = (C0636d) c0614alM1223e.m1074b(this.f1134a);
        }
        if (this.f1135b != null) {
            Iterator it = this.f1135b.iterator();
            while (it.hasNext()) {
                ((C0655w) it.next()).m1247a(c0650r);
            }
        }
        if (this.f1136c != null) {
            Iterator it2 = this.f1136c.iterator();
            while (it2.hasNext()) {
                ((C0611ai) it2.next()).m1063a(c0650r);
            }
        }
        if (this.f1137d != null) {
            Iterator it3 = this.f1137d.iterator();
            while (it3.hasNext()) {
                ((C0619aq) it3.next()).m1087a(c0650r);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1144a(C0742c c0742c, C0650r c0650r) {
        if (c0742c == null) {
            throw new NullPointerException("annotations == null");
        }
        if (this.f1134a != null) {
            throw new UnsupportedOperationException("class annotations already set");
        }
        this.f1134a = new C0636d(c0742c, c0650r);
    }

    /* JADX INFO: renamed from: a */
    public final void m1145a(C0788l c0788l, C0742c c0742c, C0650r c0650r) {
        if (this.f1135b == null) {
            this.f1135b = new ArrayList();
        }
        this.f1135b.add(new C0655w(c0788l, new C0636d(c0742c, c0650r)));
    }

    /* JADX INFO: renamed from: a */
    public final void m1146a(C0798v c0798v, C0742c c0742c, C0650r c0650r) {
        if (this.f1136c == null) {
            this.f1136c = new ArrayList();
        }
        this.f1136c.add(new C0611ai(c0798v, new C0636d(c0742c, c0650r)));
    }

    /* JADX INFO: renamed from: a */
    public final void m1147a(C0798v c0798v, C0743d c0743d, C0650r c0650r) {
        if (this.f1137d == null) {
            this.f1137d = new ArrayList();
        }
        this.f1137d.add(new C0619aq(c0798v, c0743d, c0650r));
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a_ */
    protected final void mo1044a_(C0650r c0650r, C0888r c0888r) {
        boolean zM2019b = c0888r.m2019b();
        int iM1079b = AbstractC0618ap.m1079b(this.f1134a);
        int iM1142a = m1142a(this.f1135b);
        int iM1142a2 = m1142a(this.f1136c);
        int iM1142a3 = m1142a(this.f1137d);
        if (zM2019b) {
            c0888r.m2010a(0, m1085h() + " annotations directory");
            c0888r.m2010a(4, "  class_annotations_off: " + C0985a.m2294t(iM1079b));
            c0888r.m2010a(4, "  fields_size:           " + C0985a.m2294t(iM1142a));
            c0888r.m2010a(4, "  methods_size:          " + C0985a.m2294t(iM1142a2));
            c0888r.m2010a(4, "  parameters_size:       " + C0985a.m2294t(iM1142a3));
        }
        c0888r.m2020c(iM1079b);
        c0888r.m2020c(iM1142a);
        c0888r.m2020c(iM1142a2);
        c0888r.m2020c(iM1142a3);
        if (iM1142a != 0) {
            Collections.sort(this.f1135b);
            if (zM2019b) {
                c0888r.m2010a(0, "  fields:");
            }
            Iterator it = this.f1135b.iterator();
            while (it.hasNext()) {
                ((C0655w) it.next()).m1248a(c0650r, c0888r);
            }
        }
        if (iM1142a2 != 0) {
            Collections.sort(this.f1136c);
            if (zM2019b) {
                c0888r.m2010a(0, "  methods:");
            }
            Iterator it2 = this.f1136c.iterator();
            while (it2.hasNext()) {
                ((C0611ai) it2.next()).m1064a(c0650r, c0888r);
            }
        }
        if (iM1142a3 != 0) {
            Collections.sort(this.f1137d);
            if (zM2019b) {
                c0888r.m2010a(0, "  parameters:");
            }
            Iterator it3 = this.f1137d.iterator();
            while (it3.hasNext()) {
                ((C0619aq) it3.next()).m1088a(c0650r, c0888r);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final C0743d m1148b(C0798v c0798v) {
        if (this.f1137d == null) {
            return null;
        }
        for (C0619aq c0619aq : this.f1137d) {
            if (c0619aq.m1086a().equals(c0798v)) {
                return c0619aq.m1089b();
            }
        }
        return null;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: b */
    public final String mo1045b() {
        throw new RuntimeException("unsupported");
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1149c() {
        return this.f1134a == null && this.f1135b == null && this.f1136c == null && this.f1137d == null;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m1150d() {
        return this.f1134a != null && this.f1135b == null && this.f1136c == null && this.f1137d == null;
    }

    public final int hashCode() {
        if (this.f1134a == null) {
            return 0;
        }
        return this.f1134a.hashCode();
    }
}
