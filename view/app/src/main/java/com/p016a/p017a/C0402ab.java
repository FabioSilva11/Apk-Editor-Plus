package com.p016a.p017a;

import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.Serializable;

/* JADX INFO: renamed from: com.a.a.ab */
/* JADX INFO: loaded from: classes.dex */
public final class C0402ab implements Comparable {

    /* JADX INFO: renamed from: a */
    public static final C0402ab f345a = new C0402ab(null, C0410i.f381a);

    /* JADX INFO: renamed from: b */
    private final C0410i f346b;

    /* JADX INFO: renamed from: c */
    private final short[] f347c;

    public C0402ab(C0410i c0410i, short[] sArr) {
        this.f346b = c0410i;
        this.f347c = sArr;
    }

    /* JADX INFO: renamed from: a */
    public final short[] m313a() {
        return this.f347c;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        C0402ab c0402ab = (C0402ab) obj;
        for (int i = 0; i < this.f347c.length && i < c0402ab.f347c.length; i++) {
            if (this.f347c[i] != c0402ab.f347c[i]) {
                return C0985a.m2174a(this.f347c[i], c0402ab.f347c[i]);
            }
        }
        return C0985a.m2170a(this.f347c.length, c0402ab.f347c.length);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        int length = this.f347c.length;
        for (int i = 0; i < length; i++) {
            sb.append(this.f346b != null ? (Serializable) this.f346b.m365g().get(this.f347c[i]) : Short.valueOf(this.f347c[i]));
        }
        sb.append(")");
        return sb.toString();
    }
}
