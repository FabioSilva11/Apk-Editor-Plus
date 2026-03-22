package p000a.p001a.p003b.p004a.p005a;

import java.io.Serializable;
import p000a.p001a.p002a.C0002b;
import p000a.p001a.p003b.p004a.C0031e;
import p000a.p001a.p003b.p004a.C0032f;

/* JADX INFO: renamed from: a.a.b.a.a.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0022s extends C0020q implements Serializable {

    /* JADX INFO: renamed from: c */
    private final C0031e f25c;

    /* JADX INFO: renamed from: d */
    private final boolean f26d;

    public C0022s(C0031e c0031e, int i, String str) {
        this(c0031e, 0, null, false);
    }

    public C0022s(C0031e c0031e, int i, String str, boolean z) {
        super(i, str, "reference");
        this.f25c = c0031e;
        this.f26d = z;
    }

    @Override // p000a.p001a.p003b.p004a.p005a.C0020q, p000a.p001a.p003b.p004a.p005a.AbstractC0023t
    /* JADX INFO: renamed from: a */
    protected final String mo5a() {
        C0032f c0032fM12d;
        if (m13e() || (c0032fM12d = m12d()) == null) {
            return "@null";
        }
        return ((this.f26d ? '?' : '@') + (c0032fM12d.m65d() && (c0032fM12d.m64c().m75d() instanceof C0018o) ? "+" : "")) + c0032fM12d.m59a(this.f25c, this.f26d && c0032fM12d.m69h().m80a().equals("attr"));
    }

    /* JADX INFO: renamed from: d */
    public final C0032f m12d() {
        try {
            return this.f25c.m54d().m2302a(m11b());
        } catch (C0002b e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public final boolean m13e() {
        return this.f21a == 0;
    }
}
