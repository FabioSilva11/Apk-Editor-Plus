package com.p016a.p019b.p028c.p030b;

import com.p016a.p019b.p028c.C0533a;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.c.b.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0601z {

    /* JADX INFO: renamed from: a */
    private final C0563aa f1036a;

    /* JADX INFO: renamed from: b */
    private ArrayList f1037b;

    public C0601z(C0533a c0533a, int i, int i2, int i3, int i4) {
        this.f1036a = new C0563aa(c0533a, i, i3, i4);
        this.f1037b = new ArrayList(i2);
    }

    /* JADX INFO: renamed from: b */
    private void m1032b() {
        int size = this.f1037b.size();
        for (int i = 0; i < size; i++) {
            this.f1036a.m869a((AbstractC0587l) this.f1037b.get(i));
        }
        this.f1037b = null;
    }

    /* JADX INFO: renamed from: a */
    public final C0563aa m1033a() {
        if (this.f1037b == null) {
            throw new UnsupportedOperationException("already processed");
        }
        m1032b();
        return this.f1036a;
    }

    /* JADX INFO: renamed from: a */
    public final void m1034a(int i, C0583h c0583h) {
        this.f1036a.m867a(1, c0583h);
    }

    /* JADX INFO: renamed from: a */
    public final void m1035a(AbstractC0587l abstractC0587l) {
        this.f1036a.m869a(abstractC0587l);
    }

    /* JADX INFO: renamed from: b */
    public final void m1036b(AbstractC0587l abstractC0587l) {
        this.f1037b.add(abstractC0587l);
    }
}
