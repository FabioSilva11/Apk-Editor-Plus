package com.p016a.p019b.p028c.p032c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p043h.C0888r;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.c.c.af */
/* JADX INFO: loaded from: classes.dex */
public final class C0608af extends AbstractC0618ap {

    /* JADX INFO: renamed from: a */
    private final EnumC0607ae f1070a;

    /* JADX INFO: renamed from: b */
    private final AbstractC0622at f1071b;

    /* JADX INFO: renamed from: c */
    private final AbstractC0606ad f1072c;

    /* JADX INFO: renamed from: d */
    private final int f1073d;

    private C0608af(EnumC0607ae enumC0607ae, AbstractC0622at abstractC0622at, AbstractC0606ad abstractC0606ad, AbstractC0606ad abstractC0606ad2, int i) {
        super(4, 12);
        if (enumC0607ae == null) {
            throw new NullPointerException("type == null");
        }
        if (abstractC0622at == null) {
            throw new NullPointerException("section == null");
        }
        if (abstractC0606ad == null) {
            throw new NullPointerException("firstItem == null");
        }
        if (abstractC0606ad2 == null) {
            throw new NullPointerException("lastItem == null");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("itemCount <= 0");
        }
        this.f1070a = enumC0607ae;
        this.f1071b = abstractC0622at;
        this.f1072c = abstractC0606ad;
        this.f1073d = i;
    }

    private C0608af(AbstractC0622at abstractC0622at) {
        super(4, 12);
        if (abstractC0622at == null) {
            throw new NullPointerException("section == null");
        }
        this.f1070a = EnumC0607ae.f1052h;
        this.f1071b = abstractC0622at;
        this.f1072c = null;
        this.f1073d = 1;
    }

    /* JADX INFO: renamed from: a */
    public static void m1057a(AbstractC0622at[] abstractC0622atArr, C0614al c0614al) {
        if (abstractC0622atArr == null) {
            throw new NullPointerException("sections == null");
        }
        if (c0614al.mo1046a().size() != 0) {
            throw new IllegalArgumentException("mapSection.items().size() != 0");
        }
        ArrayList arrayList = new ArrayList(50);
        for (AbstractC0622at abstractC0622at : abstractC0622atArr) {
            int i = 0;
            AbstractC0606ad abstractC0606ad = null;
            AbstractC0606ad abstractC0606ad2 = null;
            EnumC0607ae enumC0607ae = null;
            for (AbstractC0606ad abstractC0606ad3 : abstractC0622at.mo1046a()) {
                EnumC0607ae enumC0607aeMo1040a = abstractC0606ad3.mo1040a();
                if (enumC0607aeMo1040a != enumC0607ae) {
                    if (i != 0) {
                        arrayList.add(new C0608af(enumC0607ae, abstractC0622at, abstractC0606ad2, abstractC0606ad, i));
                    }
                    i = 0;
                    abstractC0606ad2 = abstractC0606ad3;
                    enumC0607ae = enumC0607aeMo1040a;
                }
                i++;
                abstractC0606ad = abstractC0606ad3;
            }
            if (i != 0) {
                arrayList.add(new C0608af(enumC0607ae, abstractC0622at, abstractC0606ad2, abstractC0606ad, i));
            } else if (abstractC0622at == c0614al) {
                arrayList.add(new C0608af(c0614al));
            }
        }
        c0614al.m1071a((AbstractC0618ap) new C0633bd(EnumC0607ae.f1052h, arrayList));
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final EnumC0607ae mo1040a() {
        return EnumC0607ae.f1063s;
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1042a(C0650r c0650r) {
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: a_ */
    protected final void mo1044a_(C0650r c0650r, C0888r c0888r) {
        int iM1055a = this.f1070a.m1055a();
        int iM1101g = this.f1072c == null ? this.f1071b.m1101g() : this.f1071b.mo1070a(this.f1072c);
        if (c0888r.m2019b()) {
            c0888r.m2010a(0, m1085h() + ' ' + this.f1070a.m1056b() + " map");
            c0888r.m2010a(2, "  type:   " + C0985a.m2296v(iM1055a) + " // " + this.f1070a.toString());
            c0888r.m2010a(2, "  unused: 0");
            c0888r.m2010a(4, "  size:   " + C0985a.m2294t(this.f1073d));
            c0888r.m2010a(4, "  offset: " + C0985a.m2294t(iM1101g));
        }
        c0888r.m2018b(iM1055a);
        c0888r.m2018b(0);
        c0888r.m2020c(this.f1073d);
        c0888r.m2020c(iM1101g);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0618ap
    /* JADX INFO: renamed from: b */
    public final String mo1045b() {
        return toString();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(this.f1071b.toString());
        stringBuffer.append(' ');
        stringBuffer.append(this.f1070a.mo657d());
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
