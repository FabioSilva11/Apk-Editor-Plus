package com.p016a.p019b.p020a.p022b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.p018a.C0400d;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0806d;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.a.b.t */
/* JADX INFO: loaded from: classes.dex */
public final class C0482t extends AbstractC0481s {

    /* JADX INFO: renamed from: a */
    private final C0484v f581a;

    /* JADX INFO: renamed from: b */
    private final ArrayList f582b;

    public C0482t(int i) {
        super(i != 0);
        this.f581a = new C0484v(i);
        this.f582b = new ArrayList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0482t(C0482t c0482t) {
        super(c0482t.f581a.m662f() > 0);
        this.f581a = c0482t.f581a.mo643a();
        this.f582b = new ArrayList(c0482t.f582b.size());
        int size = c0482t.f582b.size();
        for (int i = 0; i < size; i++) {
            AbstractC0481s abstractC0481s = (AbstractC0481s) c0482t.f582b.get(i);
            if (abstractC0481s == null) {
                this.f582b.add(null);
            } else {
                this.f582b.add(abstractC0481s.mo643a());
            }
        }
    }

    private C0482t(C0484v c0484v, ArrayList arrayList) {
        super(c0484v.m662f() > 0);
        this.f581a = c0484v;
        this.f582b = arrayList;
    }

    /* JADX INFO: renamed from: a */
    private C0482t m652a(C0482t c0482t) {
        AbstractC0481s abstractC0481sMo644a;
        C0484v c0484vM658a = this.f581a.m658a(c0482t.f581a);
        int size = this.f582b.size();
        int size2 = c0482t.f582b.size();
        int iMax = Math.max(size, size2);
        ArrayList arrayList = new ArrayList(iMax);
        int i = 0;
        boolean z = false;
        while (i < iMax) {
            AbstractC0481s abstractC0481s = i < size ? (AbstractC0481s) this.f582b.get(i) : null;
            AbstractC0481s abstractC0481s2 = i < size2 ? (AbstractC0481s) c0482t.f582b.get(i) : null;
            if (abstractC0481s == abstractC0481s2) {
                abstractC0481sMo644a = abstractC0481s;
            } else if (abstractC0481s == null) {
                abstractC0481sMo644a = abstractC0481s2;
            } else if (abstractC0481s2 == null) {
                abstractC0481sMo644a = abstractC0481s;
            } else {
                try {
                    abstractC0481sMo644a = abstractC0481s.mo644a(abstractC0481s2);
                } catch (C0459ah e) {
                    e.m311a("Merging locals set for caller block " + C0985a.m2296v(i));
                    abstractC0481sMo644a = null;
                }
            }
            boolean z2 = z || abstractC0481s != abstractC0481sMo644a;
            arrayList.add(abstractC0481sMo644a);
            i++;
            z = z2;
        }
        return (this.f581a != c0484vM658a || z) ? new C0482t(c0484vM658a, arrayList) : this;
    }

    /* JADX INFO: renamed from: a */
    private C0482t m653a(C0484v c0484v) {
        C0484v c0484vM658a = this.f581a.m658a(c0484v.mo651b());
        ArrayList arrayList = new ArrayList(this.f582b.size());
        int size = this.f582b.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            AbstractC0481s abstractC0481s = (AbstractC0481s) this.f582b.get(i);
            AbstractC0481s abstractC0481sMo644a = null;
            if (abstractC0481s != null) {
                try {
                    abstractC0481sMo644a = abstractC0481s.mo644a(c0484v);
                } catch (C0459ah e) {
                    e.m311a("Merging one locals against caller block " + C0985a.m2296v(i));
                }
            }
            boolean z2 = z || abstractC0481s != abstractC0481sMo644a;
            arrayList.add(abstractC0481sMo644a);
            i++;
            z = z2;
        }
        return (this.f581a != c0484vM658a || z) ? new C0482t(c0484vM658a, arrayList) : this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0482t mo644a(AbstractC0481s abstractC0481s) {
        try {
            C0482t c0482tM652a = abstractC0481s instanceof C0482t ? m652a((C0482t) abstractC0481s) : m653a((C0484v) abstractC0481s);
            c0482tM652a.mo549b_();
            return c0482tM652a;
        } catch (C0459ah e) {
            e.m311a("underlay locals:");
            mo648a(e);
            e.m311a("overlay locals:");
            abstractC0481s.mo648a(e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: c */
    private AbstractC0481s m655c(int i) {
        if (i >= this.f582b.size()) {
            return null;
        }
        return (AbstractC0481s) this.f582b.get(i);
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final AbstractC0481s mo643a() {
        return new C0482t(this);
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final C0482t mo645a(AbstractC0481s abstractC0481s, int i) {
        AbstractC0481s abstractC0481sM655c = m655c(i);
        C0484v c0484vM658a = this.f581a.m658a(abstractC0481s.mo651b());
        AbstractC0481s abstractC0481sMo644a = abstractC0481sM655c == abstractC0481s ? abstractC0481sM655c : abstractC0481sM655c == null ? abstractC0481s : abstractC0481sM655c.mo644a(abstractC0481s);
        if (abstractC0481sMo644a == abstractC0481sM655c && c0484vM658a == this.f581a) {
            return this;
        }
        int size = this.f582b.size();
        int iMax = Math.max(i + 1, size);
        ArrayList arrayList = new ArrayList(iMax);
        int i2 = 0;
        C0484v c0484v = null;
        while (i2 < iMax) {
            AbstractC0481s abstractC0481s2 = i2 == i ? abstractC0481sMo644a : i2 < size ? (AbstractC0481s) this.f582b.get(i2) : null;
            C0484v c0484vMo651b = abstractC0481s2 != null ? c0484v == null ? abstractC0481s2.mo651b() : c0484v.m658a(abstractC0481s2.mo651b()) : c0484v;
            arrayList.add(abstractC0481s2);
            i2++;
            c0484v = c0484vMo651b;
        }
        C0482t c0482t = new C0482t(c0484v, arrayList);
        c0482t.mo549b_();
        return c0482t;
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final InterfaceC0806d mo646a(int i) {
        return this.f581a.mo646a(i);
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final void mo647a(int i, InterfaceC0806d interfaceC0806d) {
        m2004l();
        this.f581a.mo647a(i, interfaceC0806d);
        for (AbstractC0481s abstractC0481s : this.f582b) {
            if (abstractC0481s != null) {
                abstractC0481s.mo647a(i, interfaceC0806d);
            }
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final void mo648a(C0400d c0400d) {
        c0400d.m311a("(locals array set; primary)");
        this.f581a.mo648a(c0400d);
        int size = this.f582b.size();
        for (int i = 0; i < size; i++) {
            AbstractC0481s abstractC0481s = (AbstractC0481s) this.f582b.get(i);
            if (abstractC0481s != null) {
                c0400d.m311a("(locals array set: primary for caller " + C0985a.m2296v(i) + ')');
                abstractC0481s.mo651b().mo648a(c0400d);
            }
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final void mo649a(C0766r c0766r) {
        mo647a(c0766r.m1533g(), c0766r);
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: a */
    public final void mo650a(C0805c c0805c) {
        if (this.f581a.m662f() == 0) {
            return;
        }
        m2004l();
        this.f581a.mo650a(c0805c);
        for (AbstractC0481s abstractC0481s : this.f582b) {
            if (abstractC0481s != null) {
                abstractC0481s.mo650a(c0805c);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC0481s m656b(int i) {
        return m655c(i);
    }

    @Override // com.p016a.p019b.p020a.p022b.AbstractC0481s
    /* JADX INFO: renamed from: b */
    protected final C0484v mo651b() {
        return this.f581a;
    }

    @Override // com.p016a.p019b.p043h.C0886p
    /* JADX INFO: renamed from: b_ */
    public final void mo549b_() {
        this.f581a.mo549b_();
        for (AbstractC0481s abstractC0481s : this.f582b) {
            if (abstractC0481s != null) {
                abstractC0481s.mo549b_();
            }
        }
        super.mo549b_();
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        StringBuilder sb = new StringBuilder();
        sb.append("(locals array set; primary)\n");
        sb.append(this.f581a.mo657d());
        sb.append('\n');
        int size = this.f582b.size();
        for (int i = 0; i < size; i++) {
            AbstractC0481s abstractC0481s = (AbstractC0481s) this.f582b.get(i);
            if (abstractC0481s != null) {
                sb.append("(locals array set: primary for caller " + C0985a.m2296v(i) + ")\n");
                sb.append(abstractC0481s.mo651b().mo657d());
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}
