package com.p016a.p017a;

/* JADX INFO: renamed from: com.a.a.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0406e {

    /* JADX INFO: renamed from: a */
    private final C0410i f357a;

    /* JADX INFO: renamed from: b */
    private final int f358b;

    /* JADX INFO: renamed from: c */
    private final int f359c;

    /* JADX INFO: renamed from: d */
    private final int f360d;

    /* JADX INFO: renamed from: e */
    private final int f361e;

    /* JADX INFO: renamed from: f */
    private final int f362f;

    /* JADX INFO: renamed from: g */
    private final int f363g;

    /* JADX INFO: renamed from: h */
    private final int f364h;

    /* JADX INFO: renamed from: i */
    private final int f365i;

    /* JADX INFO: renamed from: j */
    private final int f366j;

    public C0406e(C0410i c0410i, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f357a = c0410i;
        this.f358b = i;
        this.f359c = i2;
        this.f360d = i3;
        this.f361e = i4;
        this.f362f = i5;
        this.f363g = i6;
        this.f364h = i7;
        this.f365i = i8;
        this.f366j = i9;
    }

    /* JADX INFO: renamed from: a */
    public final int m323a() {
        return this.f358b;
    }

    /* JADX INFO: renamed from: b */
    public final int m324b() {
        return this.f359c;
    }

    /* JADX INFO: renamed from: c */
    public final int m325c() {
        return this.f361e;
    }

    /* JADX INFO: renamed from: d */
    public final int m326d() {
        return this.f362f;
    }

    /* JADX INFO: renamed from: e */
    public final short[] m327e() {
        return this.f357a.m359b(this.f362f).m313a();
    }

    /* JADX INFO: renamed from: f */
    public final int m328f() {
        return this.f360d;
    }

    /* JADX INFO: renamed from: g */
    public final int m329g() {
        return this.f363g;
    }

    /* JADX INFO: renamed from: h */
    public final int m330h() {
        return this.f364h;
    }

    /* JADX INFO: renamed from: i */
    public final int m331i() {
        return this.f365i;
    }

    /* JADX INFO: renamed from: j */
    public final int m332j() {
        return this.f366j;
    }

    public final String toString() {
        if (this.f357a == null) {
            return this.f359c + " " + this.f361e;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((String) this.f357a.m365g().get(this.f359c));
        if (this.f361e != -1) {
            sb.append(" extends ").append((String) this.f357a.m365g().get(this.f361e));
        }
        return sb.toString();
    }
}
