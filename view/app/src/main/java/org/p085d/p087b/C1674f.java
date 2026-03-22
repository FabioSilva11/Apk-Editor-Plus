package org.p085d.p087b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.p085d.InterfaceC1663a;
import org.p085d.InterfaceC1668b;

/* JADX INFO: renamed from: org.d.b.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1674f implements InterfaceC1663a {

    /* JADX INFO: renamed from: a */
    private boolean f4759a = false;

    /* JADX INFO: renamed from: b */
    private Map f4760b = new HashMap();

    /* JADX INFO: renamed from: c */
    private LinkedBlockingQueue f4761c = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: a */
    public final List m3835a() {
        return new ArrayList(this.f4760b.values());
    }

    @Override // org.p085d.InterfaceC1663a
    /* JADX INFO: renamed from: a */
    public final synchronized InterfaceC1668b mo3811a(String str) {
        C1673e c1673e;
        c1673e = (C1673e) this.f4760b.get(str);
        if (c1673e == null) {
            c1673e = new C1673e(str, this.f4761c, this.f4759a);
            this.f4760b.put(str, c1673e);
        }
        return c1673e;
    }

    /* JADX INFO: renamed from: b */
    public final LinkedBlockingQueue m3836b() {
        return this.f4761c;
    }

    /* JADX INFO: renamed from: c */
    public final void m3837c() {
        this.f4759a = true;
    }

    /* JADX INFO: renamed from: d */
    public final void m3838d() {
        this.f4760b.clear();
        this.f4761c.clear();
    }
}
