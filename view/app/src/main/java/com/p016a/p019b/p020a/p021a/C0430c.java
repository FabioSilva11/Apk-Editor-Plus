package com.p016a.p019b.p020a.p021a;

import com.p016a.p019b.p020a.p025e.AbstractC0506a;
import com.p016a.p019b.p036f.p039c.AbstractC0777ab;
import com.p016a.p019b.p036f.p039c.C0786j;
import com.p016a.p019b.p036f.p039c.C0789m;
import com.p016a.p019b.p036f.p039c.C0790n;
import com.p016a.p019b.p036f.p039c.C0796t;
import com.p016a.p019b.p036f.p039c.C0801y;

/* JADX INFO: renamed from: com.a.b.a.a.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0430c extends AbstractC0506a {

    /* JADX INFO: renamed from: a */
    private final AbstractC0777ab f455a;

    public C0430c(AbstractC0777ab abstractC0777ab) {
        super("ConstantValue");
        if ((abstractC0777ab instanceof C0801y) || (abstractC0777ab instanceof C0790n) || (abstractC0777ab instanceof C0796t) || (abstractC0777ab instanceof C0789m) || (abstractC0777ab instanceof C0786j)) {
            this.f455a = abstractC0777ab;
        } else {
            if (abstractC0777ab != null) {
                throw new IllegalArgumentException("bad type for constantValue");
            }
            throw new NullPointerException("constantValue == null");
        }
    }

    @Override // com.p016a.p019b.p020a.p025e.AbstractC0506a
    /* JADX INFO: renamed from: a */
    public final int mo443a() {
        return 8;
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC0777ab m450b() {
        return this.f455a;
    }
}
