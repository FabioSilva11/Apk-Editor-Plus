package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0745a;
import com.p016a.p019b.p036f.p038b.C0751c;
import com.p016a.p019b.p036f.p038b.C0772x;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import com.p016a.p019b.p043h.C0880j;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: renamed from: com.a.b.c.b.aj */
/* JADX INFO: loaded from: classes.dex */
public final class C0572aj implements InterfaceC0578c {

    /* JADX INFO: renamed from: a */
    private final C0772x f758a;

    /* JADX INFO: renamed from: b */
    private final int[] f759b;

    /* JADX INFO: renamed from: c */
    private final C0577b f760c;

    public C0572aj(C0772x c0772x, int[] iArr, C0577b c0577b) {
        if (c0772x == null) {
            throw new NullPointerException("method == null");
        }
        if (iArr == null) {
            throw new NullPointerException("order == null");
        }
        if (c0577b == null) {
            throw new NullPointerException("addresses == null");
        }
        this.f758a = c0772x;
        this.f759b = iArr;
        this.f760c = c0577b;
    }

    /* JADX INFO: renamed from: a */
    private static C0579d m901a(C0745a c0745a, C0577b c0577b) {
        C0880j c0880jM1458c = c0745a.m1458c();
        int iM1985b = c0880jM1458c.m1985b();
        int iM1459d = c0745a.m1459d();
        InterfaceC0807e interfaceC0807eMo1470b = c0745a.m1462g().mo1470b();
        int iMo759d_ = interfaceC0807eMo1470b.mo759d_();
        if (iMo759d_ == 0) {
            return C0579d.f769a;
        }
        if ((iM1459d == -1 && iM1985b != iMo759d_) || (iM1459d != -1 && (iM1985b != iMo759d_ + 1 || iM1459d != c0880jM1458c.m1986b(iMo759d_)))) {
            throw new RuntimeException("shouldn't happen: weird successors list");
        }
        int i = 0;
        while (true) {
            if (i >= iMo759d_) {
                break;
            }
            if (interfaceC0807eMo1470b.mo756a(i).equals(C0805c.f2023n)) {
                iMo759d_ = i + 1;
                break;
            }
            i++;
        }
        C0579d c0579d = new C0579d(iMo759d_);
        for (int i2 = 0; i2 < iMo759d_; i2++) {
            c0579d.m923a(i2, new C0802z(interfaceC0807eMo1470b.mo756a(i2)), c0577b.m916a(c0880jM1458c.m1986b(i2)).m960g());
        }
        c0579d.mo549b_();
        return c0579d;
    }

    /* JADX INFO: renamed from: a */
    private static C0582g m902a(C0745a c0745a, C0745a c0745a2, C0579d c0579d, C0577b c0577b) {
        return new C0582g(c0577b.m918b(c0745a).m960g(), c0577b.m919c(c0745a2).m960g(), c0579d);
    }

    @Override // com.p016a.p019b.p028c.p030b.InterfaceC0578c
    /* JADX INFO: renamed from: a */
    public final C0581f mo903a() {
        C0745a c0745a;
        C0579d c0579d;
        C0745a c0745a2 = null;
        C0772x c0772x = this.f758a;
        int[] iArr = this.f759b;
        C0577b c0577b = this.f760c;
        int length = iArr.length;
        C0751c c0751cM1582a = c0772x.m1582a();
        ArrayList arrayList = new ArrayList(length);
        C0579d c0579d2 = C0579d.f769a;
        int i = 0;
        C0745a c0745a3 = null;
        while (i < length) {
            C0745a c0745aM1478b = c0751cM1582a.m1478b(iArr[i]);
            if (c0745aM1478b.m1463h()) {
                C0579d c0579dM901a = m901a(c0745aM1478b, c0577b);
                if (c0579d2.m1977d_() == 0) {
                    c0745a = c0745aM1478b;
                    c0579d = c0579dM901a;
                } else {
                    if (c0579d2.equals(c0579dM901a)) {
                        if (c0745a3 == null) {
                            throw new NullPointerException("start == null");
                        }
                        if (c0745aM1478b == null) {
                            throw new NullPointerException("end == null");
                        }
                        if (c0577b.m919c(c0745aM1478b).m960g() - c0577b.m918b(c0745a3).m960g() <= 65535) {
                            c0745a = c0745a3;
                            c0579d = c0579d2;
                        }
                    }
                    if (c0579d2.m1977d_() != 0) {
                        arrayList.add(m902a(c0745a3, c0745a2, c0579d2, c0577b));
                    }
                    c0745a = c0745aM1478b;
                    c0579d = c0579dM901a;
                }
            } else {
                c0745aM1478b = c0745a2;
                c0745a = c0745a3;
                c0579d = c0579d2;
            }
            i++;
            c0579d2 = c0579d;
            c0745a3 = c0745a;
            c0745a2 = c0745aM1478b;
        }
        if (c0579d2.m1977d_() != 0) {
            arrayList.add(m902a(c0745a3, c0745a2, c0579d2, c0577b));
        }
        int size = arrayList.size();
        if (size == 0) {
            return C0581f.f772a;
        }
        C0581f c0581f = new C0581f(size);
        for (int i2 = 0; i2 < size; i2++) {
            c0581f.m929a(i2, (C0582g) arrayList.get(i2));
        }
        c0581f.mo549b_();
        return c0581f;
    }

    @Override // com.p016a.p019b.p028c.p030b.InterfaceC0578c
    /* JADX INFO: renamed from: b */
    public final boolean mo904b() {
        C0751c c0751cM1582a = this.f758a.m1582a();
        int iD_ = c0751cM1582a.m1977d_();
        for (int i = 0; i < iD_; i++) {
            if (c0751cM1582a.m1475a(i).m1462g().mo1470b().mo759d_() != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.p016a.p019b.p028c.p030b.InterfaceC0578c
    /* JADX INFO: renamed from: c */
    public final HashSet mo905c() {
        HashSet hashSet = new HashSet(20);
        C0751c c0751cM1582a = this.f758a.m1582a();
        int iD_ = c0751cM1582a.m1977d_();
        for (int i = 0; i < iD_; i++) {
            InterfaceC0807e interfaceC0807eMo1470b = c0751cM1582a.m1475a(i).m1462g().mo1470b();
            int iMo759d_ = interfaceC0807eMo1470b.mo759d_();
            for (int i2 = 0; i2 < iMo759d_; i2++) {
                hashSet.add(interfaceC0807eMo1470b.mo756a(i2));
            }
        }
        return hashSet;
    }
}
