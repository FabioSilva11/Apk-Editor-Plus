package p000a.p001a.p003b.p004a.p005a;

import java.io.Serializable;

/* JADX INFO: renamed from: a.a.b.a.a.l */
/* JADX INFO: loaded from: classes.dex */
final class C0015l implements Serializable {

    /* JADX INFO: renamed from: a */
    public final int f16a;

    /* JADX INFO: renamed from: b */
    private C0022s f17b;

    /* JADX INFO: renamed from: c */
    private String f18c;

    public C0015l(C0022s c0022s, int i) {
        this.f17b = c0022s;
        this.f16a = i;
    }

    /* JADX INFO: renamed from: a */
    public final String m9a() {
        if (this.f18c == null) {
            this.f18c = this.f17b.m12d().m67f();
        }
        return this.f18c;
    }
}
