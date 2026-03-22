package com.gmail.heagoo.neweditor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.x */
/* JADX INFO: loaded from: classes.dex */
public final class C1530x {

    /* JADX INFO: renamed from: a */
    private static final C1530x[] f4529a = new C1530x[19];

    /* JADX INFO: renamed from: b */
    private String f4530b;

    /* JADX INFO: renamed from: c */
    private boolean f4531c;

    /* JADX INFO: renamed from: d */
    private byte f4532d;

    /* JADX INFO: renamed from: e */
    private Pattern f4533e;

    /* JADX INFO: renamed from: f */
    private C1529w f4534f;

    /* JADX INFO: renamed from: g */
    private boolean f4535g;

    /* JADX INFO: renamed from: j */
    private C1526t f4538j;

    /* JADX INFO: renamed from: k */
    private final String f4539k;

    /* JADX INFO: renamed from: l */
    private String f4540l;

    /* JADX INFO: renamed from: m */
    private int f4541m;

    /* JADX INFO: renamed from: o */
    private final String f4543o;

    /* JADX INFO: renamed from: h */
    private boolean f4536h = true;

    /* JADX INFO: renamed from: p */
    private int f4544p = -1;

    /* JADX INFO: renamed from: n */
    private final Map f4542n = new HashMap();

    /* JADX INFO: renamed from: i */
    private final List f4537i = new ArrayList();

    static {
        for (byte b2 = 0; b2 < 19; b2 = (byte) (b2 + 1)) {
            f4529a[b2] = new C1530x(null, null);
            f4529a[b2].f4532d = b2;
            f4529a[b2].f4531c = true;
        }
    }

    public C1530x(String str, String str2) {
        this.f4539k = str;
        this.f4543o = str2;
    }

    /* JADX INFO: renamed from: a */
    public static C1530x m3670a(byte b2) {
        return f4529a[b2];
    }

    /* JADX INFO: renamed from: a */
    public final String m3671a() {
        return this.f4539k;
    }

    /* JADX INFO: renamed from: a */
    public final List m3672a(Character ch) {
        List list = (List) this.f4542n.get(null);
        boolean z = list == null || list.isEmpty();
        Character chValueOf = ch == null ? null : Character.valueOf(Character.toUpperCase(ch.charValue()));
        List list2 = chValueOf != null ? (List) this.f4542n.get(chValueOf) : null;
        boolean z2 = list2 == null || list2.isEmpty();
        if (z && z2) {
            return Collections.emptyList();
        }
        if (z2) {
            return list;
        }
        if (z) {
            return list2;
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        arrayList.addAll(list2);
        arrayList.addAll(list);
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public final void m3673a(int i) {
        if (i < 0) {
            i = -1;
        }
        this.f4544p = i;
    }

    /* JADX INFO: renamed from: a */
    public final void m3674a(C1526t c1526t) {
        this.f4538j = c1526t;
        this.f4530b = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m3675a(C1529w c1529w) {
        Character[] chArr;
        this.f4541m++;
        if (c1529w.f4528l == null) {
            Character[] chArr2 = new Character[1];
            if (c1529w.f4527k == null || c1529w.f4527k.length <= 0) {
                chArr2[0] = null;
                chArr = chArr2;
            } else {
                chArr2[0] = Character.valueOf(c1529w.f4527k[0]);
                chArr = chArr2;
            }
        } else {
            Character[] chArr3 = new Character[c1529w.f4528l.length];
            char[] cArr = c1529w.f4528l;
            int length = cArr.length;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                chArr3[i] = Character.valueOf(cArr[i2]);
                i2++;
                i++;
            }
            chArr = chArr3;
        }
        for (Character ch : chArr) {
            List arrayList = (List) this.f4542n.get(ch);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f4542n.put(ch, arrayList);
            }
            arrayList.add(c1529w);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3676a(C1530x c1530x) {
        this.f4537i.add(c1530x);
    }

    /* JADX INFO: renamed from: a */
    public final void m3677a(String str) {
        this.f4540l = str;
        this.f4530b = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m3678a(Hashtable hashtable) {
        this.f4530b = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m3679a(Pattern pattern) {
        this.f4533e = pattern;
    }

    /* JADX INFO: renamed from: a */
    public final void m3680a(boolean z) {
        this.f4536h = z;
    }

    /* JADX INFO: renamed from: b */
    public final String m3681b() {
        return this.f4543o;
    }

    /* JADX INFO: renamed from: b */
    public final void m3682b(byte b2) {
        this.f4532d = b2;
    }

    /* JADX INFO: renamed from: b */
    public final void m3683b(C1529w c1529w) {
        this.f4534f = c1529w;
    }

    /* JADX INFO: renamed from: b */
    public final void m3684b(boolean z) {
        this.f4535g = z;
    }

    /* JADX INFO: renamed from: c */
    public final int m3685c() {
        return this.f4541m;
    }

    /* JADX INFO: renamed from: d */
    public final int m3686d() {
        return this.f4544p;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m3687e() {
        return this.f4536h;
    }

    /* JADX INFO: renamed from: f */
    public final C1526t m3688f() {
        return this.f4538j;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m3689g() {
        return this.f4535g;
    }

    /* JADX INFO: renamed from: h */
    public final Pattern m3690h() {
        return this.f4533e;
    }

    /* JADX INFO: renamed from: i */
    public final C1529w m3691i() {
        return this.f4534f;
    }

    /* JADX INFO: renamed from: j */
    public final byte m3692j() {
        return this.f4532d;
    }

    /* JADX INFO: renamed from: k */
    public final String m3693k() {
        if (this.f4530b == null) {
            this.f4530b = this.f4540l;
            if (this.f4540l == null) {
                this.f4540l = "";
            }
            if (this.f4538j != null) {
                this.f4540l += this.f4538j.m3656a();
            }
        }
        return this.f4540l;
    }

    /* JADX INFO: renamed from: l */
    public final boolean m3694l() {
        return this.f4531c;
    }

    public final String toString() {
        return String.valueOf(getClass().getName()) + '[' + this.f4539k + "::" + this.f4543o + ']';
    }
}
