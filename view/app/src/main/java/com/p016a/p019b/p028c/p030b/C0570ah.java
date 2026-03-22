package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.AbstractC0757i;
import com.p016a.p019b.p036f.p038b.C0745a;
import com.p016a.p019b.p036f.p038b.C0746aa;
import com.p016a.p019b.p036f.p038b.C0747ab;
import com.p016a.p019b.p036f.p038b.C0748ac;
import com.p016a.p019b.p036f.p038b.C0756h;
import com.p016a.p019b.p036f.p038b.C0764p;
import com.p016a.p019b.p036f.p038b.C0765q;
import com.p016a.p019b.p036f.p038b.C0766r;
import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0771w;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p036f.p038b.InterfaceC0759k;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0790n;
import com.p016a.p019b.p043h.C0880j;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.c.b.ah */
/* JADX INFO: loaded from: classes.dex */
class C0570ah implements InterfaceC0759k {

    /* JADX INFO: renamed from: a */
    private final C0601z f754a;

    /* JADX INFO: renamed from: b */
    private C0745a f755b;

    /* JADX INFO: renamed from: c */
    private C0583h f756c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ C0567ae f757d;

    public C0570ah(C0567ae c0567ae, C0601z c0601z) {
        this.f757d = c0567ae;
        this.f754a = c0601z;
    }

    /* JADX INFO: renamed from: a */
    private C0766r m895a() {
        int iM1459d = this.f755b.m1459d();
        if (iM1459d < 0) {
            return null;
        }
        AbstractC0757i abstractC0757iM1497a = this.f757d.f740a.m1582a().m1478b(iM1459d).m1457b().m1497a(0);
        if (abstractC0757iM1497a.m1490f().m1574a() == 56) {
            return abstractC0757iM1497a.m1492h();
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private void m896b(AbstractC0587l abstractC0587l) {
        this.f754a.m1036b(abstractC0587l);
    }

    /* JADX INFO: renamed from: a */
    protected final void m897a(AbstractC0587l abstractC0587l) {
        this.f754a.m1035a(abstractC0587l);
    }

    /* JADX INFO: renamed from: a */
    public final void m898a(C0745a c0745a, C0583h c0583h) {
        this.f755b = c0745a;
        this.f756c = c0583h;
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0759k
    /* JADX INFO: renamed from: a */
    public void mo891a(C0746aa c0746aa) {
        C0774z c0774zG = c0746aa.m1491g();
        C0880j c0880jM1471c = c0746aa.m1471c();
        C0880j c0880jM1458c = this.f755b.m1458c();
        int iM1985b = c0880jM1471c.m1985b();
        int iM1985b2 = c0880jM1458c.m1985b();
        int iM1459d = this.f755b.m1459d();
        if (iM1985b != iM1985b2 - 1 || iM1459d != c0880jM1458c.m1986b(iM1985b)) {
            throw new RuntimeException("shouldn't happen");
        }
        C0583h[] c0583hArr = new C0583h[iM1985b];
        for (int i = 0; i < iM1985b; i++) {
            c0583hArr[i] = this.f757d.f743d.m916a(c0880jM1458c.m1986b(i));
        }
        C0583h c0583h = new C0583h(c0774zG);
        C0583h c0583h2 = new C0583h(this.f756c.m962i(), true);
        C0573ak c0573ak = new C0573ak(c0774zG, c0583h2, c0880jM1471c, c0583hArr);
        AbstractC0587l c0574al = new C0574al(c0573ak.m908c() ? C0590o.f805I : C0590o.f806J, c0774zG, C0567ae.m884b(c0746aa, c0746aa.m1492h()), c0583h);
        m897a(c0583h2);
        m897a(c0574al);
        m896b(new C0600y(c0774zG));
        m896b(c0583h);
        m896b(c0573ak);
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0759k
    /* JADX INFO: renamed from: a */
    public void mo892a(C0747ab c0747ab) {
        C0774z c0774zG = c0747ab.m1491g();
        C0589n c0589nM878a = C0566ad.m878a(c0747ab);
        C0771w c0771wF = c0747ab.m1490f();
        AbstractC0775a abstractC0775aG_ = c0747ab.m1486g_();
        if (c0771wF.m1577d() != 6) {
            throw new RuntimeException("shouldn't happen");
        }
        m897a(this.f756c);
        if (c0771wF.m1578e()) {
            m897a(new C0584i(c0589nM878a, c0774zG, c0747ab.m1494j(), abstractC0775aG_));
            return;
        }
        C0766r c0766rM895a = m895a();
        C0768t c0768tM884b = C0567ae.m884b(c0747ab, c0766rM895a);
        if ((c0589nM878a.m977d() || c0771wF.m1574a() == 43) != (c0766rM895a != null)) {
            throw new RuntimeException("Insn with result/move-result-pseudo mismatch " + c0747ab);
        }
        m897a((c0771wF.m1574a() != 41 || c0589nM878a.m974a() == 35) ? new C0584i(c0589nM878a, c0774zG, c0768tM884b, abstractC0775aG_) : new C0571ai(c0589nM878a, c0774zG, c0768tM884b));
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0759k
    /* JADX INFO: renamed from: a */
    public void mo893a(C0748ac c0748ac) {
        C0774z c0774zG = c0748ac.m1491g();
        C0589n c0589nM878a = C0566ad.m878a(c0748ac);
        if (c0748ac.m1490f().m1577d() != 6) {
            throw new RuntimeException("shouldn't happen");
        }
        C0766r c0766rM895a = m895a();
        if (c0589nM878a.m977d() != (c0766rM895a != null)) {
            throw new RuntimeException("Insn with result/move-result-pseudo mismatch" + c0748ac);
        }
        m897a(this.f756c);
        m897a(new C0571ai(c0589nM878a, c0774zG, C0567ae.m884b(c0748ac, c0766rM895a)));
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0759k
    /* JADX INFO: renamed from: a */
    public final void mo899a(C0756h c0756h) {
        C0774z c0774zG = c0756h.m1491g();
        AbstractC0775a abstractC0775aM1488e = c0756h.m1488e();
        ArrayList arrayListM1487c = c0756h.m1487c();
        if (c0756h.m1490f().m1577d() != 1) {
            throw new RuntimeException("shouldn't happen");
        }
        C0583h c0583h = new C0583h(c0774zG);
        AbstractC0587l c0537a = new C0537a(c0774zG, this.f756c, arrayListM1487c, abstractC0775aM1488e);
        AbstractC0587l c0574al = new C0574al(C0590o.f802F, c0774zG, C0567ae.m884b(c0756h, c0756h.m1492h()), c0583h);
        m897a(this.f756c);
        m897a(c0574al);
        m896b(new C0600y(c0774zG));
        m896b(c0583h);
        m896b(c0537a);
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0759k
    /* JADX INFO: renamed from: a */
    public void mo889a(C0764p c0764p) {
        C0774z c0774zG = c0764p.m1491g();
        C0589n c0589nM878a = C0566ad.m878a(c0764p);
        C0771w c0771wF = c0764p.m1490f();
        int iM1574a = c0771wF.m1574a();
        if (c0771wF.m1577d() != 1) {
            throw new RuntimeException("shouldn't happen");
        }
        if (iM1574a != 3) {
            m897a(new C0584i(c0589nM878a, c0774zG, C0567ae.m884b(c0764p, c0764p.m1492h()), c0764p.m1486g_()));
        } else {
            if (this.f757d.f749j) {
                return;
            }
            C0766r c0766rH = c0764p.m1492h();
            m897a(new C0571ai(c0589nM878a, c0774zG, C0768t.m1547a(c0766rH, C0766r.m1516a(((C0790n) c0764p.m1486g_()).mo1632j() + (this.f757d.f746g - this.f757d.f748i), c0766rH.mo663a()))));
        }
    }

    @Override // com.p016a.p019b.p036f.p038b.InterfaceC0759k
    /* JADX INFO: renamed from: a */
    public void mo894a(C0765q c0765q) {
        AbstractC0587l c0574al;
        C0771w c0771wF = c0765q.m1490f();
        if (c0771wF.m1574a() == 54 || c0771wF.m1574a() == 56) {
            return;
        }
        C0774z c0774zG = c0765q.m1491g();
        C0589n c0589nM878a = C0566ad.m878a(c0765q);
        switch (c0771wF.m1577d()) {
            case 1:
            case 2:
            case 6:
                c0574al = new C0571ai(c0589nM878a, c0774zG, C0567ae.m884b(c0765q, c0765q.m1492h()));
                break;
            case 3:
                return;
            case 4:
                c0574al = new C0574al(c0589nM878a, c0774zG, C0567ae.m884b(c0765q, c0765q.m1492h()), this.f757d.f743d.m916a(this.f755b.m1458c().m1986b(1)));
                break;
            case 5:
            default:
                throw new RuntimeException("shouldn't happen");
        }
        m897a(c0574al);
    }
}
