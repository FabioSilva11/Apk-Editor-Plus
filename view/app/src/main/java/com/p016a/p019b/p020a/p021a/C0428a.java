package com.p016a.p019b.p020a.p021a;

import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;

/* JADX INFO: renamed from: com.a.b.a.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0428a extends AbstractC0506a {

    /* JADX INFO: renamed from: a */
    private final AbstractC0775a f448a;

    /* JADX INFO: renamed from: b */
    private final int f449b;

    public C0428a(AbstractC0775a abstractC0775a, int i) {
        super("AnnotationDefault");
        if (abstractC0775a == null) {
            throw new NullPointerException("value == null");
        }
        this.f448a = abstractC0775a;
        this.f449b = i;
    }

    @Override // com.p016a.p019b.p020a.p025e.AbstractC0506a
    /* JADX INFO: renamed from: a */
    public final int mo443a() {
        return this.f449b + 6;
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC0775a m444b() {
        return this.f448a;
    }
}
