package com.p016a.p017a;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.a.a.k */
/* JADX INFO: loaded from: classes.dex */
final class C0412k implements Iterator {

    /* JADX INFO: renamed from: a */
    private final C0416o f392a;

    /* JADX INFO: renamed from: b */
    private int f393b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ C0410i f394c;

    private C0412k(C0410i c0410i) {
        this.f394c = c0410i;
        this.f392a = this.f394c.m354a(this.f394c.f383c.f428g.f343c);
        this.f393b = 0;
    }

    /* synthetic */ C0412k(C0410i c0410i, byte b2) {
        this(c0410i);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f393b < this.f394c.f383c.f428g.f342b;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f393b++;
        C0416o c0416o = this.f392a;
        return new C0406e(c0416o.f398a, c0416o.m378a(), c0416o.m385b(), c0416o.m385b(), c0416o.m385b(), c0416o.m385b(), c0416o.m385b(), c0416o.m385b(), c0416o.m385b(), c0416o.m385b());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
