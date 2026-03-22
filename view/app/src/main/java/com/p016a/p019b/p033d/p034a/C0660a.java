package com.p016a.p019b.p033d.p034a;

import java.util.HashMap;

/* JADX INFO: renamed from: com.a.b.d.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0660a {

    /* JADX INFO: renamed from: a */
    private final HashMap f1218a = new HashMap();

    /* JADX INFO: renamed from: a */
    public final int m1259a(int i) {
        Integer num = (Integer) this.f1218a.get(Integer.valueOf(i));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* JADX INFO: renamed from: a */
    public final void m1260a(int i, int i2) {
        this.f1218a.put(Integer.valueOf(i), Integer.valueOf(i2));
    }
}
