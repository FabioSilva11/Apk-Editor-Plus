package com.p016a.p019b.p028c.p032c;

import com.p016a.p019b.p043h.C0888r;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: com.a.b.c.c.bc */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0632bc extends AbstractC0622at {
    public AbstractC0632bc(String str, C0650r c0650r, int i) {
        super(str, c0650r, 4);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: a */
    public final int mo1070a(AbstractC0606ad abstractC0606ad) {
        AbstractC0605ac abstractC0605ac = (AbstractC0605ac) abstractC0606ad;
        return m1097c(abstractC0605ac.m1051i() * abstractC0605ac.mo1054e_());
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: a_ */
    protected final void mo1073a_(C0888r c0888r) {
        C0650r c0650rE = m1099e();
        int iF = m1100f();
        Iterator it = mo1046a().iterator();
        while (it.hasNext()) {
            ((AbstractC0606ad) it.next()).mo1053a(c0650rE, c0888r);
            c0888r.m2027g(iF);
        }
    }

    /* JADX INFO: renamed from: b */
    protected abstract void mo1047b();

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: c */
    protected final void mo1075c() {
        C0650r c0650rE = m1099e();
        mo1047b();
        Iterator it = mo1046a().iterator();
        while (it.hasNext()) {
            ((AbstractC0606ad) it.next()).mo1042a(c0650rE);
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0622at
    /* JADX INFO: renamed from: f_ */
    public final int mo1077f_() {
        Collection collectionA = mo1046a();
        int size = collectionA.size();
        if (size == 0) {
            return 0;
        }
        return ((AbstractC0606ad) collectionA.iterator().next()).mo1054e_() * size;
    }
}
