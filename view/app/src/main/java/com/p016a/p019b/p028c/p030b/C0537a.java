package com.p016a.p019b.p028c.p030b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.AbstractC0793q;
import com.p016a.p019b.p036f.p039c.AbstractC0794r;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p043h.C0888r;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.c.b.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0537a extends AbstractC0575am {

    /* JADX INFO: renamed from: a */
    private final C0583h f698a;

    /* JADX INFO: renamed from: b */
    private final ArrayList f699b;

    /* JADX INFO: renamed from: c */
    private final AbstractC0775a f700c;

    /* JADX INFO: renamed from: d */
    private final int f701d;

    /* JADX INFO: renamed from: e */
    private final int f702e;

    public C0537a(C0774z c0774z, C0583h c0583h, ArrayList arrayList, AbstractC0775a abstractC0775a) {
        super(c0774z, C0768t.f1671a);
        if (c0583h == null) {
            throw new NullPointerException("user == null");
        }
        if (arrayList == null) {
            throw new NullPointerException("values == null");
        }
        if (arrayList.size() <= 0) {
            throw new IllegalArgumentException("Illegal number of init values");
        }
        this.f700c = abstractC0775a;
        if (abstractC0775a == C0802z.f1940c || abstractC0775a == C0802z.f1939b) {
            this.f701d = 1;
        } else if (abstractC0775a == C0802z.f1946i || abstractC0775a == C0802z.f1941d) {
            this.f701d = 2;
        } else if (abstractC0775a == C0802z.f1945h || abstractC0775a == C0802z.f1943f) {
            this.f701d = 4;
        } else {
            if (abstractC0775a != C0802z.f1944g && abstractC0775a != C0802z.f1942e) {
                throw new IllegalArgumentException("Unexpected constant type");
            }
            this.f701d = 8;
        }
        this.f698a = c0583h;
        this.f699b = arrayList;
        this.f702e = arrayList.size();
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final int mo840a() {
        return (((this.f702e * this.f701d) + 1) / 2) + 4;
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final AbstractC0587l mo841a(C0768t c0768t) {
        return new C0537a(m962i(), this.f698a, this.f699b, this.f700c);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    protected final String mo842a(boolean z) {
        int iG = this.f698a.m960g();
        StringBuffer stringBuffer = new StringBuffer(100);
        int size = this.f699b.size();
        stringBuffer.append("fill-array-data-payload // for fill-array-data @ ");
        stringBuffer.append(C0985a.m2296v(iG));
        for (int i = 0; i < size; i++) {
            stringBuffer.append("\n  ");
            stringBuffer.append(i);
            stringBuffer.append(": ");
            stringBuffer.append(((AbstractC0775a) this.f699b.get(i)).mo657d());
        }
        return stringBuffer.toString();
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final void mo843a(C0888r c0888r) {
        int size = this.f699b.size();
        c0888r.m2018b(768);
        c0888r.m2018b(this.f701d);
        c0888r.m2020c(this.f702e);
        switch (this.f701d) {
            case 1:
                for (int i = 0; i < size; i++) {
                    c0888r.mo307d((byte) ((AbstractC0793q) ((AbstractC0775a) this.f699b.get(i))).mo1632j());
                }
                break;
            case 2:
                for (int i2 = 0; i2 < size; i2++) {
                    c0888r.m2018b((short) ((AbstractC0793q) ((AbstractC0775a) this.f699b.get(i2))).mo1632j());
                }
                break;
            case 4:
                for (int i3 = 0; i3 < size; i3++) {
                    c0888r.m2020c(((AbstractC0793q) ((AbstractC0775a) this.f699b.get(i3))).mo1632j());
                }
                break;
            case 8:
                for (int i4 = 0; i4 < size; i4++) {
                    c0888r.m2012a(((AbstractC0794r) ((AbstractC0775a) this.f699b.get(i4))).mo1633k());
                }
                break;
        }
        if (this.f701d != 1 || size % 2 == 0) {
            return;
        }
        c0888r.mo307d(0);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: b */
    protected final String mo844b() {
        StringBuffer stringBuffer = new StringBuffer(100);
        int size = this.f699b.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append("\n    ");
            stringBuffer.append(i);
            stringBuffer.append(": ");
            stringBuffer.append(((AbstractC0775a) this.f699b.get(i)).mo657d());
        }
        return stringBuffer.toString();
    }
}
