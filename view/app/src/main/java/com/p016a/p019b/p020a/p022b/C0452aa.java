package com.p016a.p019b.p020a.p022b;

import com.p016a.p019b.p036f.p040d.C0805c;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.a.b.a.b.aa */
/* JADX INFO: loaded from: classes.dex */
final class C0452aa {

    /* JADX INFO: renamed from: a */
    private final Map f487a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C0486x f488b;

    private C0452aa(C0486x c0486x) {
        this.f488b = c0486x;
        this.f487a = new HashMap();
    }

    /* synthetic */ C0452aa(C0486x c0486x, byte b2) {
        this(c0486x);
    }

    /* JADX INFO: renamed from: a */
    final C0453ab m500a(C0805c c0805c) {
        C0453ab c0453ab = (C0453ab) this.f487a.get(c0805c);
        if (c0453ab != null) {
            return c0453ab;
        }
        C0453ab c0453ab2 = new C0453ab(c0805c, this.f488b.f598n.mo504a());
        this.f487a.put(c0805c, c0453ab2);
        return c0453ab2;
    }

    /* JADX INFO: renamed from: a */
    final Collection m501a() {
        return this.f487a.values();
    }
}
