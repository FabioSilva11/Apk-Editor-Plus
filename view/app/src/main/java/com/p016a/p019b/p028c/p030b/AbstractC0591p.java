package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0768t;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.b.p */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0591p extends AbstractC0587l {
    public AbstractC0591p(C0589n c0589n, C0774z c0774z, C0768t c0768t) {
        super(c0589n, c0774z, c0768t);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final int mo840a() {
        return m961h().m976c().mo845a();
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    protected final String mo842a(boolean z) {
        AbstractC0593r abstractC0593rM976c = m961h().m976c();
        String strM978e = m961h().m978e();
        String strMo846a = abstractC0593rM976c.mo846a(this);
        String strMo847a = abstractC0593rM976c.mo847a(this, z);
        StringBuilder sb = new StringBuilder(100);
        sb.append(strM978e);
        if (strMo846a.length() != 0) {
            sb.append(' ');
            sb.append(strMo846a);
        }
        if (strMo847a.length() != 0) {
            sb.append(" // ");
            sb.append(strMo847a);
        }
        return sb.toString();
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: a */
    public final void mo843a(C0888r c0888r) {
        m961h().m976c().mo848a(c0888r, this);
    }

    @Override // com.p016a.p019b.p028c.p030b.AbstractC0587l
    /* JADX INFO: renamed from: d */
    public final AbstractC0587l mo914d(int i) {
        return mo841a(m963j().m1556d(i));
    }
}
