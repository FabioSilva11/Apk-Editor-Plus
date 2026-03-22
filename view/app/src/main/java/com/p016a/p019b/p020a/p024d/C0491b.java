package com.p016a.p019b.p020a.p024d;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p021a.C0450w;
import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p020a.p025e.C0514i;
import com.p016a.p019b.p020a.p025e.InterfaceC0515j;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.InterfaceC0778b;
import com.p016a.p019b.p043h.C0873c;

/* JADX INFO: renamed from: com.a.b.a.d.b */
/* JADX INFO: loaded from: classes.dex */
public class C0491b {
    /* JADX INFO: renamed from: a */
    public final AbstractC0506a m720a(C0500k c0500k, int i, int i2, InterfaceC0515j interfaceC0515j) {
        if (c0500k == null) {
            throw new NullPointerException("cf == null");
        }
        if (i < 0 || i >= 4) {
            throw new IllegalArgumentException("bad context");
        }
        C0801y c0801y = null;
        try {
            C0873c c0873cM745b = c0500k.m745b();
            InterfaceC0778b interfaceC0778bM750g = c0500k.m750g();
            int iM1966f = c0873cM745b.m1966f(i2);
            int iM1963c = c0873cM745b.m1963c(i2 + 2);
            c0801y = (C0801y) interfaceC0778bM750g.mo1607a(iM1966f);
            if (interfaceC0515j != null) {
                new StringBuilder("name: ").append(c0801y.mo657d());
                new StringBuilder("length: ").append(C0985a.m2294t(iM1963c));
            }
            return mo721a(c0500k, i, c0801y.m1649j(), i2 + 6, iM1963c, interfaceC0515j);
        } catch (C0514i e) {
            e.m311a("...while parsing " + (c0801y != null ? c0801y.mo657d() + " " : "") + "attribute at offset " + C0985a.m2294t(i2));
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    protected AbstractC0506a mo721a(C0500k c0500k, int i, String str, int i2, int i3, InterfaceC0515j interfaceC0515j) {
        return new C0450w(str, c0500k.m745b(), i2, i3, c0500k.m750g());
    }
}
