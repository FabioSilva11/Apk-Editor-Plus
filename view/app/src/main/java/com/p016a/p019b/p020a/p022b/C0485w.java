package com.p016a.p019b.p020a.p022b;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0806d;

/* JADX INFO: renamed from: com.a.b.a.b.w */
/* JADX INFO: loaded from: classes.dex */
public final class C0485w implements InterfaceC0806d {

    /* JADX INFO: renamed from: a */
    private final int f584a;

    public C0485w(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("subroutineAddress < 0");
        }
        this.f584a = i;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return C0805c.f2020k;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: b */
    public final InterfaceC0806d mo664b() {
        return this;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: c */
    public final int mo665c() {
        return C0805c.f2020k.mo665c();
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return toString();
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: e */
    public final int mo666e() {
        return C0805c.f2020k.mo666e();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0485w) && this.f584a == ((C0485w) obj).f584a;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: f */
    public final boolean mo667f() {
        return false;
    }

    /* JADX INFO: renamed from: g */
    public final int m668g() {
        return this.f584a;
    }

    public final int hashCode() {
        return this.f584a;
    }

    public final String toString() {
        return "<addr:" + C0985a.m2296v(this.f584a) + ">";
    }
}
