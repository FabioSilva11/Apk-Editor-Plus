package p000a.p001a.p003b.p006b;

import p000a.p001a.C0000a;
import p000a.p001a.p003b.p004a.C0031e;
import p000a.p001a.p003b.p004a.C0032f;
import p000a.p001a.p003b.p004a.p005a.AbstractC0023t;
import p000a.p001a.p003b.p004a.p005a.C0005b;

/* JADX INFO: renamed from: a.a.b.b.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0051i {

    /* JADX INFO: renamed from: a */
    private C0031e f159a;

    /* JADX INFO: renamed from: a */
    private C0031e m138a() throws C0000a {
        if (this.f159a == null) {
            throw new C0000a("Current package is null");
        }
        return this.f159a;
    }

    /* JADX INFO: renamed from: a */
    public final String m139a(int i) {
        C0032f c0032fM2302a;
        if (i == 0 || (c0032fM2302a = m138a().m54d().m2302a(i)) == null) {
            return null;
        }
        return c0032fM2302a.m67f();
    }

    /* JADX INFO: renamed from: a */
    public final String m140a(int i, int i2, String str, int i3) throws C0000a {
        String strMo3a;
        AbstractC0023t abstractC0023tM39a = this.f159a.m57g().m39a(i, i2, str);
        if (i3 > 0) {
            try {
                strMo3a = ((C0005b) m138a().m54d().m2302a(i3).m64c().m75d()).mo3a(abstractC0023tM39a);
            } catch (Exception e) {
                strMo3a = null;
            }
        } else {
            strMo3a = null;
        }
        return strMo3a != null ? strMo3a : abstractC0023tM39a.mo15f();
    }

    /* JADX INFO: renamed from: a */
    public final void m141a(C0031e c0031e) {
        this.f159a = c0031e;
    }
}
