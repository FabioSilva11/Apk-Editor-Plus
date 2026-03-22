package com.p016a.p019b.p020a.p024d;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p020a.p025e.C0514i;
import com.p016a.p019b.p020a.p025e.C0516k;
import com.p016a.p019b.p020a.p025e.InterfaceC0515j;

/* JADX INFO: renamed from: com.a.b.a.d.c */
/* JADX INFO: loaded from: classes.dex */
final class C0492c {

    /* JADX INFO: renamed from: a */
    private final C0500k f612a;

    /* JADX INFO: renamed from: b */
    private final int f613b;

    /* JADX INFO: renamed from: c */
    private final int f614c;

    /* JADX INFO: renamed from: d */
    private final C0491b f615d;

    /* JADX INFO: renamed from: e */
    private final C0516k f616e;

    /* JADX INFO: renamed from: f */
    private int f617f;

    /* JADX INFO: renamed from: g */
    private InterfaceC0515j f618g;

    public C0492c(C0500k c0500k, int i, int i2, C0491b c0491b) {
        if (c0500k == null) {
            throw new NullPointerException("cf == null");
        }
        if (c0491b == null) {
            throw new NullPointerException("attributeFactory == null");
        }
        int iM1966f = c0500k.m745b().m1966f(i2);
        this.f612a = c0500k;
        this.f613b = i;
        this.f614c = i2;
        this.f615d = c0491b;
        this.f616e = new C0516k(iM1966f);
        this.f617f = -1;
    }

    /* JADX INFO: renamed from: c */
    private void m722c() {
        if (this.f617f < 0) {
            int iD_ = this.f616e.m1977d_();
            int i = this.f614c + 2;
            if (this.f618g != null) {
                new StringBuilder("attributes_count: ").append(C0985a.m2296v(iD_));
            }
            int i2 = i;
            int i3 = 0;
            while (i3 < iD_) {
                try {
                    if (this.f618g != null) {
                        new StringBuilder("\nattributes[").append(i3).append("]:\n");
                    }
                    AbstractC0506a abstractC0506aM720a = this.f615d.m720a(this.f612a, this.f613b, i2, this.f618g);
                    int iMo443a = abstractC0506aM720a.mo443a() + i2;
                    this.f616e.m796a(i3, abstractC0506aM720a);
                    if (this.f618g != null) {
                        new StringBuilder("end attributes[").append(i3).append("]\n");
                    }
                    i3++;
                    i2 = iMo443a;
                } catch (C0514i e) {
                    e.m311a("...while parsing attributes[" + i3 + "]");
                    throw e;
                } catch (RuntimeException e2) {
                    C0514i c0514i = new C0514i(e2);
                    c0514i.m311a("...while parsing attributes[" + i3 + "]");
                    throw c0514i;
                }
            }
            this.f617f = i2;
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m723a() {
        m722c();
        return this.f617f;
    }

    /* JADX INFO: renamed from: a */
    public final void m724a(InterfaceC0515j interfaceC0515j) {
        this.f618g = interfaceC0515j;
    }

    /* JADX INFO: renamed from: b */
    public final C0516k m725b() {
        m722c();
        return this.f616e;
    }
}
