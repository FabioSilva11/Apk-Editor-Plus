package com.p016a.p019b.p036f.p039c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.p018a.C0400d;
import com.p016a.p019b.p043h.C0886p;

/* JADX INFO: renamed from: com.a.b.f.c.aa */
/* JADX INFO: loaded from: classes.dex */
public final class C0776aa extends C0886p implements InterfaceC0778b {

    /* JADX INFO: renamed from: a */
    private final AbstractC0775a[] f1901a;

    public C0776aa(int i) {
        super(i > 1);
        if (i <= 0) {
            throw new IllegalArgumentException("size < 1");
        }
        this.f1901a = new AbstractC0775a[i];
    }

    /* JADX INFO: renamed from: d */
    private static AbstractC0775a m1605d(int i) {
        throw new C0400d("invalid constant pool index " + C0985a.m2296v(i));
    }

    @Override // com.p016a.p019b.p036f.p039c.InterfaceC0778b
    /* JADX INFO: renamed from: a */
    public final int mo1606a() {
        return this.f1901a.length;
    }

    @Override // com.p016a.p019b.p036f.p039c.InterfaceC0778b
    /* JADX INFO: renamed from: a */
    public final AbstractC0775a mo1607a(int i) {
        try {
            AbstractC0775a abstractC0775a = this.f1901a[i];
            if (abstractC0775a != null) {
                return abstractC0775a;
            }
            m1605d(i);
            return abstractC0775a;
        } catch (IndexOutOfBoundsException e) {
            return m1605d(i);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1608a(int i, AbstractC0775a abstractC0775a) {
        AbstractC0775a abstractC0775a2;
        m2004l();
        boolean z = abstractC0775a != null && abstractC0775a.mo1603g();
        if (i <= 0) {
            throw new IllegalArgumentException("n < 1");
        }
        if (z) {
            if (i == this.f1901a.length - 1) {
                throw new IllegalArgumentException("(n == size - 1) && cst.isCategory2()");
            }
            this.f1901a[i + 1] = null;
        }
        if (abstractC0775a != null && this.f1901a[i] == null && (abstractC0775a2 = this.f1901a[i - 1]) != null && abstractC0775a2.mo1603g()) {
            this.f1901a[i - 1] = null;
        }
        this.f1901a[i] = abstractC0775a;
    }

    @Override // com.p016a.p019b.p036f.p039c.InterfaceC0778b
    /* JADX INFO: renamed from: b */
    public final AbstractC0775a mo1609b(int i) {
        if (i == 0) {
            return null;
        }
        return mo1607a(i);
    }

    @Override // com.p016a.p019b.p036f.p039c.InterfaceC0778b
    /* JADX INFO: renamed from: c */
    public final AbstractC0775a mo1610c(int i) {
        try {
            return this.f1901a[i];
        } catch (IndexOutOfBoundsException e) {
            return m1605d(i);
        }
    }
}
