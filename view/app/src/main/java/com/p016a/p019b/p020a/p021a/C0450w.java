package com.p016a.p019b.p020a.p021a;

import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p036f.p039c.InterfaceC0778b;
import com.p016a.p019b.p043h.C0873c;

/* JADX INFO: renamed from: com.a.b.a.a.w */
/* JADX INFO: loaded from: classes.dex */
public final class C0450w extends AbstractC0506a {

    /* JADX INFO: renamed from: a */
    private final C0873c f472a;

    public C0450w(String str, C0873c c0873c, int i, int i2, InterfaceC0778b interfaceC0778b) {
        this(str, c0873c.m1959a(i, i + i2), interfaceC0778b);
    }

    private C0450w(String str, C0873c c0873c, InterfaceC0778b interfaceC0778b) {
        super(str);
        if (c0873c == null) {
            throw new NullPointerException("data == null");
        }
        this.f472a = c0873c;
    }

    @Override // com.p016a.p019b.p020a.p025e.AbstractC0506a
    /* JADX INFO: renamed from: a */
    public final int mo443a() {
        return this.f472a.m1957a() + 6;
    }
}
