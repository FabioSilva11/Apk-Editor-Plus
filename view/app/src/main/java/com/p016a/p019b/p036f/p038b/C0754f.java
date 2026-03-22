package com.p016a.p019b.p036f.p038b;

import com.p016a.p019b.p036f.p039c.C0790n;
import com.p016a.p019b.p036f.p040d.C0805c;

/* JADX INFO: renamed from: com.a.b.f.b.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0754f implements InterfaceC0749ad {

    /* JADX INFO: renamed from: a */
    public static final C0754f f1629a = new C0754f();

    /* JADX INFO: renamed from: b */
    private final boolean f1630b = false;

    static {
        new C0754f(true);
    }

    private C0754f() {
    }

    private C0754f(boolean z) {
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0749ad
    /* JADX INFO: renamed from: a */
    public final boolean mo1473a(C0771w c0771w, C0766r c0766r, C0766r c0766r2) {
        if (c0766r.mo663a() != C0805c.f2015f) {
            return false;
        }
        if (!(c0766r2.m1534h() instanceof C0790n)) {
            if ((c0766r.m1534h() instanceof C0790n) && c0771w.m1574a() == 15) {
                return ((C0790n) c0766r.m1534h()).m1634l();
            }
            return false;
        }
        C0790n c0790n = (C0790n) c0766r2.m1534h();
        switch (c0771w.m1574a()) {
            case 14:
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
                return c0790n.m1634l();
            case 15:
                return C0790n.m1629a(-c0790n.mo1632j()).m1634l();
            case 19:
            default:
                return false;
            case 23:
            case 24:
            case 25:
                if (c0790n.mo1631i()) {
                    int iMo1632j = c0790n.mo1632j();
                    if (((byte) iMo1632j) == iMo1632j) {
                        return true;
                    }
                }
                return false;
        }
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0749ad
    /* JADX INFO: renamed from: a */
    public final boolean mo1474a(C0771w c0771w, C0768t c0768t) {
        if (this.f1630b || !c0771w.m1578e()) {
            return false;
        }
        int iD_ = c0768t.m1977d_();
        int iM1537k = 0;
        for (int i = 0; i < iD_; i++) {
            iM1537k += c0768t.m1553b(i).m1537k();
        }
        return iM1537k >= 6;
    }
}
