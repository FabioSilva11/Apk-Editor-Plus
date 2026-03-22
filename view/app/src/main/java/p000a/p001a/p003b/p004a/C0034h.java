package p000a.p001a.p003b.p004a;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: a.a.b.a.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0034h {

    /* JADX INFO: renamed from: a */
    private final C0029c f81a;

    /* JADX INFO: renamed from: b */
    private final Map f82b = new LinkedHashMap();

    public C0034h(C0029c c0029c) {
        this.f81a = c0029c;
    }

    /* JADX INFO: renamed from: a */
    public final C0029c m76a() {
        return this.f81a;
    }

    /* JADX INFO: renamed from: a */
    public final void m77a(C0033g c0033g) {
        m78a(c0033g, true);
    }

    /* JADX INFO: renamed from: a */
    public final void m78a(C0033g c0033g, boolean z) {
        this.f82b.put(c0033g.m74c(), c0033g);
    }

    public final String toString() {
        return this.f81a.toString();
    }
}
