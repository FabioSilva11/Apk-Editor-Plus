package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p036f.p038b.C0758j;
import com.p016a.p019b.p036f.p038b.C0764p;
import com.p016a.p019b.p036f.p039c.C0790n;

/* JADX INFO: renamed from: com.a.b.c.b.af */
/* JADX INFO: loaded from: classes.dex */
final class C0568af extends C0758j {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ boolean[] f750a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ int f751b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ int f752c;

    C0568af(boolean[] zArr, int i, int i2) {
        this.f750a = zArr;
        this.f751b = i;
        this.f752c = i2;
    }

    @Override // com.p016a.p019b.p036f.p038b.C0758j, com.p016a.p019b.p036f.p038b.InterfaceC0759k
    /* JADX INFO: renamed from: a */
    public final void mo889a(C0764p c0764p) {
        if (c0764p.m1490f().m1574a() == 3) {
            this.f750a[0] = this.f750a[0] && ((C0790n) c0764p.m1486g_()).mo1632j() + (this.f751b - this.f752c) == c0764p.m1492h().m1533g();
        }
    }
}
