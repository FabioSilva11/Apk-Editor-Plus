package com.p016a.p019b.p028c.p032c;

import com.p016a.p017a.p018a.C0400d;
import com.p016a.p019b.p043h.C0888r;

/* JADX INFO: renamed from: com.a.b.c.c.ap */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0618ap extends AbstractC0606ad implements Comparable {

    /* JADX INFO: renamed from: a */
    private final int f1088a;

    /* JADX INFO: renamed from: b */
    private int f1089b;

    /* JADX INFO: renamed from: c */
    private AbstractC0622at f1090c;

    /* JADX INFO: renamed from: d */
    private int f1091d;

    public AbstractC0618ap(int i, int i2) {
        AbstractC0622at.m1095a(i);
        if (i2 < -1) {
            throw new IllegalArgumentException("writeSize < -1");
        }
        this.f1088a = i;
        this.f1089b = i2;
        this.f1090c = null;
        this.f1091d = -1;
    }

    /* JADX INFO: renamed from: b */
    public static int m1079b(AbstractC0618ap abstractC0618ap) {
        if (abstractC0618ap == null) {
            return 0;
        }
        return abstractC0618ap.m1083f();
    }

    /* JADX INFO: renamed from: a */
    protected int mo1039a(AbstractC0618ap abstractC0618ap) {
        throw new UnsupportedOperationException("unsupported");
    }

    /* JADX INFO: renamed from: a */
    public final void m1080a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("writeSize < 0");
        }
        if (this.f1089b >= 0) {
            throw new UnsupportedOperationException("writeSize already set");
        }
        this.f1089b = i;
    }

    /* JADX INFO: renamed from: a */
    protected void mo1041a(AbstractC0622at abstractC0622at, int i) {
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: a */
    public final void mo1053a(C0650r c0650r, C0888r c0888r) {
        c0888r.m2027g(this.f1088a);
        try {
            if (this.f1089b < 0) {
                throw new UnsupportedOperationException("writeSize is unknown");
            }
            c0888r.m2009a(m1083f());
            mo1044a_(c0650r, c0888r);
        } catch (RuntimeException e) {
            throw C0400d.m308a(e, "...while writing " + this);
        }
    }

    /* JADX INFO: renamed from: a_ */
    protected abstract void mo1044a_(C0650r c0650r, C0888r c0888r);

    /* JADX INFO: renamed from: b */
    public final int m1081b(AbstractC0622at abstractC0622at, int i) {
        if (abstractC0622at == null) {
            throw new NullPointerException("addedTo == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("offset < 0");
        }
        if (this.f1090c != null) {
            throw new RuntimeException("already written");
        }
        int i2 = this.f1088a - 1;
        int i3 = (i2 ^ (-1)) & (i + i2);
        this.f1090c = abstractC0622at;
        this.f1091d = i3;
        mo1041a(abstractC0622at, i3);
        return i3;
    }

    /* JADX INFO: renamed from: b */
    public abstract String mo1045b();

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(AbstractC0618ap abstractC0618ap) {
        if (this == abstractC0618ap) {
            return 0;
        }
        EnumC0607ae enumC0607aeA = mo1040a();
        EnumC0607ae enumC0607aeA2 = abstractC0618ap.mo1040a();
        return enumC0607aeA != enumC0607aeA2 ? enumC0607aeA.compareTo(enumC0607aeA2) : mo1039a(abstractC0618ap);
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0606ad
    /* JADX INFO: renamed from: e_ */
    public final int mo1054e_() {
        if (this.f1089b < 0) {
            throw new UnsupportedOperationException("writeSize is unknown");
        }
        return this.f1089b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        AbstractC0618ap abstractC0618ap = (AbstractC0618ap) obj;
        return mo1040a() == abstractC0618ap.mo1040a() && mo1039a(abstractC0618ap) == 0;
    }

    /* JADX INFO: renamed from: f */
    public final int m1083f() {
        if (this.f1091d < 0) {
            throw new RuntimeException("offset not yet known");
        }
        return this.f1090c.m1097c(this.f1091d);
    }

    /* JADX INFO: renamed from: g */
    public final int m1084g() {
        return this.f1088a;
    }

    /* JADX INFO: renamed from: h */
    public final String m1085h() {
        return "[" + Integer.toHexString(m1083f()) + ']';
    }
}
