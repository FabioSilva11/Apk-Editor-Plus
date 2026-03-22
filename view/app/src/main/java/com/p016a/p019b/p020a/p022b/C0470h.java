package com.p016a.p019b.p020a.p022b;

import com.p016a.p019b.p036f.p039c.InterfaceC0778b;
import com.p016a.p019b.p043h.C0873c;

/* JADX INFO: renamed from: com.a.b.a.b.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0470h {

    /* JADX INFO: renamed from: a */
    private static InterfaceC0473k f552a = new C0471i();

    /* JADX INFO: renamed from: b */
    private final C0873c f553b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC0778b f554c;

    public C0470h(C0873c c0873c, InterfaceC0778b interfaceC0778b) {
        if (c0873c == null) {
            throw new NullPointerException("bytes == null");
        }
        if (interfaceC0778b == null) {
            throw new NullPointerException("pool == null");
        }
        this.f553b = c0873c;
        this.f554c = interfaceC0778b;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0776  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m577a(int r14, com.p016a.p019b.p020a.p022b.InterfaceC0473k r15) {
        /*
            Method dump skipped, instruction units count: 2414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p016a.p019b.p020a.p022b.C0470h.m577a(int, com.a.b.a.b.k):int");
    }

    /* JADX INFO: renamed from: a */
    public final C0873c m578a() {
        return this.f553b;
    }

    /* JADX INFO: renamed from: a */
    public final void m579a(InterfaceC0473k interfaceC0473k) {
        int iM1957a = this.f553b.m1957a();
        int iM577a = 0;
        while (iM577a < iM1957a) {
            iM577a += m577a(iM577a, interfaceC0473k);
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m580b() {
        return this.f553b.m1957a();
    }

    /* JADX INFO: renamed from: c */
    public final int m581c() {
        return this.f553b.m1957a() + 4;
    }
}
