package com.gmail.heagoo.apkeditor;

import com.gmail.heagoo.p054a.p059c.C0985a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fk */
/* JADX INFO: loaded from: classes.dex */
public final class C1218fk {

    /* JADX INFO: renamed from: a */
    List f3458a;

    /* JADX INFO: renamed from: b */
    String f3459b;

    /* JADX INFO: renamed from: c */
    boolean f3460c;

    public C1218fk() {
        this.f3459b = "";
        this.f3460c = false;
    }

    private C1218fk(String str, boolean z) {
        this.f3459b = str;
        this.f3460c = z;
    }

    /* JADX INFO: renamed from: a */
    private C1218fk m3062a(String str) {
        if (this.f3458a != null) {
            for (C1218fk c1218fk : this.f3458a) {
                if (str.equals(c1218fk.f3459b)) {
                    return c1218fk;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private C1218fk m3063a(String str, boolean z) {
        if (this.f3458a == null) {
            if (!z) {
                return null;
            }
            this.f3458a = new ArrayList();
        }
        for (C1218fk c1218fk : this.f3458a) {
            if (!c1218fk.f3460c && str.equals(c1218fk.f3459b)) {
                return c1218fk;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private List m3064a() {
        if (this.f3458a == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (C1218fk c1218fk : this.f3458a) {
            if (c1218fk.f3460c) {
                arrayList.add(c1218fk.f3459b);
            } else {
                List listM3064a = c1218fk.m3064a();
                if (listM3064a != null) {
                    Iterator it = listM3064a.iterator();
                    while (it.hasNext()) {
                        arrayList.add(c1218fk.f3459b + "/" + ((String) it.next()));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private void m3065a(C1218fk c1218fk) {
        if (this.f3458a == null) {
            this.f3458a = new ArrayList();
        }
        this.f3458a.add(c1218fk);
    }

    /* JADX INFO: renamed from: b */
    private boolean m3066b(C1218fk c1218fk) {
        if (this.f3458a != null) {
            return this.f3458a.remove(c1218fk);
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public final C1218fk m3067a(String[] strArr) {
        for (String str : strArr) {
            this = this.m3063a(str, false);
            if (this == null) {
                return null;
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final void m3068a(String[] strArr, boolean z) {
        for (int i = 0; i < strArr.length - 1; i++) {
            C1218fk c1218fkM3063a = this.m3063a(strArr[i], true);
            if (c1218fkM3063a == null) {
                c1218fkM3063a = new C1218fk(strArr[i], false);
                this.m3065a(c1218fkM3063a);
            }
            this = c1218fkM3063a;
        }
        this.m3065a(new C1218fk(strArr[strArr.length - 1], z));
    }

    /* JADX INFO: renamed from: b */
    public final C1218fk m3069b(String[] strArr) {
        for (int i = 0; i < strArr.length - 1; i++) {
            this = this.m3063a(strArr[i], false);
            if (this == null) {
                return null;
            }
        }
        return this.m3062a(strArr[strArr.length - 1]);
    }

    /* JADX INFO: renamed from: c */
    public final List m3070c(String[] strArr) {
        C1218fk c1218fkM3062a;
        if (strArr.length > 1) {
            String[] strArr2 = new String[strArr.length - 1];
            for (int i = 0; i < strArr.length - 1; i++) {
                strArr2[i] = strArr[i];
            }
            this = m3067a(strArr2);
        }
        if (this != null && (c1218fkM3062a = this.m3062a(strArr[strArr.length - 1])) != null) {
            if (c1218fkM3062a.f3460c) {
                this.m3066b(c1218fkM3062a);
                ArrayList arrayList = new ArrayList();
                arrayList.add(C0985a.m2199a("/", strArr));
                return arrayList;
            }
            List listM3064a = c1218fkM3062a.m3064a();
            if (listM3064a != null) {
                String strM2199a = C0985a.m2199a("/", strArr);
                for (int i2 = 0; i2 < listM3064a.size(); i2++) {
                    listM3064a.set(i2, strM2199a + "/" + ((String) listM3064a.get(i2)));
                }
                this.m3066b(c1218fkM3062a);
                return listM3064a;
            }
            this.m3066b(c1218fkM3062a);
        }
        return null;
    }
}
