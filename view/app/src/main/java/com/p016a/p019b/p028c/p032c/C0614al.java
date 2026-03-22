package com.p016a.p019b.p028c.p032c;

import com.p016a.p017a.p018a.C0400d;
import com.p016a.p019b.p043h.C0888r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.a.b.c.c.al */
/* JADX INFO: loaded from: classes.dex */
public final class C0614al extends AbstractC0622at {

    /* JADX INFO: renamed from: a */
    private static final Comparator f1078a = new C0615am();

    /* JADX INFO: renamed from: b */
    private final ArrayList f1079b;

    /* JADX INFO: renamed from: c */
    private final HashMap f1080c;

    /* JADX INFO: renamed from: d */
    private final int f1081d;

    /* JADX INFO: renamed from: e */
    private int f1082e;

    public C0614al(String str, C0650r c0650r, int i, int i2) {
        super(str, c0650r, i);
        this.f1079b = new ArrayList(100);
        this.f1080c = new HashMap(100);
        this.f1081d = i2;
        this.f1082e = -1;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: a */
    public final int mo1070a(AbstractC0606ad abstractC0606ad) {
        return ((AbstractC0618ap) abstractC0606ad).m1083f();
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: a */
    public final Collection mo1046a() {
        return this.f1079b;
    }

    /* JADX INFO: renamed from: a */
    public final void m1071a(AbstractC0618ap abstractC0618ap) {
        m1104j();
        try {
            if (abstractC0618ap.m1084g() > m1100f()) {
                throw new IllegalArgumentException("incompatible item alignment");
            }
            this.f1079b.add(abstractC0618ap);
        } catch (NullPointerException e) {
            throw new NullPointerException("item == null");
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1072a(C0888r c0888r, EnumC0607ae enumC0607ae, String str) {
        m1103i();
        TreeMap treeMap = new TreeMap();
        for (AbstractC0618ap abstractC0618ap : this.f1079b) {
            if (abstractC0618ap.mo1040a() == enumC0607ae) {
                treeMap.put(abstractC0618ap.mo1045b(), abstractC0618ap);
            }
        }
        if (treeMap.size() == 0) {
            return;
        }
        c0888r.m2010a(0, str);
        for (Map.Entry entry : treeMap.entrySet()) {
            c0888r.m2010a(0, ((AbstractC0618ap) entry.getValue()).m1085h() + ' ' + ((String) entry.getKey()) + '\n');
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: a_ */
    protected final void mo1073a_(C0888r c0888r) {
        boolean zM2019b = c0888r.m2019b();
        C0650r c0650rE = m1099e();
        int iMo1054e_ = 0;
        boolean z = true;
        for (AbstractC0618ap abstractC0618ap : this.f1079b) {
            if (zM2019b) {
                if (z) {
                    z = false;
                } else {
                    c0888r.m2010a(0, "\n");
                }
            }
            int iM1084g = abstractC0618ap.m1084g() - 1;
            int i = (iM1084g ^ (-1)) & (iMo1054e_ + iM1084g);
            if (iMo1054e_ != i) {
                c0888r.m2025f(i - iMo1054e_);
                iMo1054e_ = i;
            }
            abstractC0618ap.mo1053a(c0650rE, c0888r);
            iMo1054e_ = abstractC0618ap.mo1054e_() + iMo1054e_;
        }
        if (iMo1054e_ != this.f1082e) {
            throw new RuntimeException("output size mismatch");
        }
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC0618ap m1074b(AbstractC0618ap abstractC0618ap) {
        m1104j();
        AbstractC0618ap abstractC0618ap2 = (AbstractC0618ap) this.f1080c.get(abstractC0618ap);
        if (abstractC0618ap2 != null) {
            return abstractC0618ap2;
        }
        m1071a(abstractC0618ap);
        this.f1080c.put(abstractC0618ap, abstractC0618ap);
        return abstractC0618ap;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: c */
    protected final void mo1075c() {
        C0650r c0650rE = m1099e();
        int i = 0;
        while (true) {
            int size = this.f1079b.size();
            if (i >= size) {
                return;
            }
            int i2 = i;
            while (i2 < size) {
                ((AbstractC0618ap) this.f1079b.get(i2)).mo1042a(c0650rE);
                i2++;
            }
            i = i2;
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m1076d() {
        m1103i();
        switch (C0616an.f1083a[this.f1081d - 1]) {
            case 1:
                Collections.sort(this.f1079b);
                break;
            case 2:
                Collections.sort(this.f1079b, f1078a);
                break;
        }
        int size = this.f1079b.size();
        int iMo1054e_ = 0;
        for (int i = 0; i < size; i++) {
            AbstractC0618ap abstractC0618ap = (AbstractC0618ap) this.f1079b.get(i);
            try {
                int iM1081b = abstractC0618ap.m1081b(this, iMo1054e_);
                if (iM1081b < iMo1054e_) {
                    throw new RuntimeException("bogus place() result for " + abstractC0618ap);
                }
                iMo1054e_ = iM1081b + abstractC0618ap.mo1054e_();
            } catch (RuntimeException e) {
                throw C0400d.m308a(e, "...while placing " + abstractC0618ap);
            }
        }
        this.f1082e = iMo1054e_;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: f_ */
    public final int mo1077f_() {
        m1103i();
        return this.f1082e;
    }
}
