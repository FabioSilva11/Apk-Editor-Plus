package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p043h.C0888r;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.a.b.c.c.bd */
/* JADX INFO: loaded from: classes.dex */
public final class C0633bd extends AbstractC0618ap {

    /* JADX INFO: renamed from: a */
    private final EnumC0607ae f1117a;

    /* JADX INFO: renamed from: b */
    private final List f1118b;

    /* JADX WARN: Illegal instructions before constructor call */
    public C0633bd(EnumC0607ae enumC0607ae, List list) {
        int iM1123a = m1123a(list);
        AbstractC0618ap abstractC0618ap = (AbstractC0618ap) list.get(0);
        super(iM1123a, (abstractC0618ap.mo1054e_() * list.size()) + m1123a(list));
        if (enumC0607ae == null) {
            throw new NullPointerException("itemType == null");
        }
        this.f1118b = list;
        this.f1117a = enumC0607ae;
    }

    /* JADX INFO: renamed from: a */
    private static int m1123a(List list) {
        try {
            return Math.max(4, ((AbstractC0618ap) list.get(0)).m1084g());
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("items.size() == 0");
        } catch (NullPointerException e2) {
            throw new NullPointerException("items == null");
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return this.f1117a;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a */
    protected final void mo1041a(AbstractC0622at abstractC0622at, int i) {
        int iG = i + m1084g();
        int i2 = 0;
        boolean z = true;
        int iM1081b = iG;
        int iM1084g = 0;
        for (AbstractC0618ap abstractC0618ap : this.f1118b) {
            int iMo1054e_ = abstractC0618ap.mo1054e_();
            if (z) {
                iM1084g = abstractC0618ap.m1084g();
                i2 = iMo1054e_;
                z = false;
            } else {
                if (iMo1054e_ != i2) {
                    throw new UnsupportedOperationException("item size mismatch");
                }
                if (abstractC0618ap.m1084g() != iM1084g) {
                    throw new UnsupportedOperationException("item alignment mismatch");
                }
            }
            iM1081b = abstractC0618ap.m1081b(abstractC0622at, iM1081b) + iMo1054e_;
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
        Iterator it = this.f1118b.iterator();
        while (it.hasNext()) {
            ((AbstractC0618ap) it.next()).mo1042a(c0650r);
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a_ */
    protected final void mo1044a_(C0650r c0650r, C0888r c0888r) {
        int size = this.f1118b.size();
        if (c0888r.m2019b()) {
            c0888r.m2010a(0, m1085h() + " " + mo1040a().mo657d());
            c0888r.m2010a(4, "  size: " + C0985a.m2294t(size));
        }
        c0888r.m2020c(size);
        Iterator it = this.f1118b.iterator();
        while (it.hasNext()) {
            ((AbstractC0618ap) it.next()).mo1053a(c0650r, c0888r);
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: b */
    public final String mo1045b() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("{");
        boolean z = true;
        for (AbstractC0618ap abstractC0618ap : this.f1118b) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(", ");
            }
            stringBuffer.append(abstractC0618ap.mo1045b());
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: c */
    public final List m1124c() {
        return this.f1118b;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append(this.f1118b);
        return stringBuffer.toString();
    }
}
