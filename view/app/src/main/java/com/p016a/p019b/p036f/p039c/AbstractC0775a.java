package com.p016a.p019b.p036f.p039c;

import com.p016a.p019b.p043h.InterfaceC0889s;

/* JADX INFO: renamed from: com.a.b.f.c.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0775a implements InterfaceC0889s, Comparable {
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(AbstractC0775a abstractC0775a) {
        Class<?> cls = getClass();
        Class<?> cls2 = abstractC0775a.getClass();
        return cls != cls2 ? cls.getName().compareTo(cls2.getName()) : mo1602b(abstractC0775a);
    }

    /* JADX INFO: renamed from: b */
    protected abstract int mo1602b(AbstractC0775a abstractC0775a);

    /* JADX INFO: renamed from: g */
    public abstract boolean mo1603g();

    /* JADX INFO: renamed from: h */
    public abstract String mo1604h();
}
