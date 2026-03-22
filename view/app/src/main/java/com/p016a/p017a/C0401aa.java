package com.p016a.p017a;

/* JADX INFO: renamed from: com.a.a.aa */
/* JADX INFO: loaded from: classes.dex */
public final class C0401aa implements Comparable {

    /* JADX INFO: renamed from: a */
    public final short f341a;

    /* JADX INFO: renamed from: b */
    public int f342b = 0;

    /* JADX INFO: renamed from: c */
    public int f343c = -1;

    /* JADX INFO: renamed from: d */
    public int f344d = 0;

    public C0401aa(int i) {
        this.f341a = (short) i;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m312a() {
        return this.f342b > 0;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        C0401aa c0401aa = (C0401aa) obj;
        if (this.f343c != c0401aa.f343c) {
            return this.f343c < c0401aa.f343c ? -1 : 1;
        }
        return 0;
    }

    public final String toString() {
        return String.format("Section[type=%#x,off=%#x,size=%#x]", Short.valueOf(this.f341a), Integer.valueOf(this.f343c), Integer.valueOf(this.f342b));
    }
}
