package p000a.p011d;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: a.d.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0078j {

    /* JADX INFO: renamed from: a */
    private Object[] f216a = new Object[4];

    /* JADX INFO: renamed from: b */
    private int f217b = 0;

    /* JADX INFO: renamed from: c */
    private int f218c;

    /* JADX INFO: renamed from: a */
    private static String m202a(ArrayList arrayList, String str) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (((String) pair.second).equals(str)) {
                return (String) pair.first;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final String m203a(int i, String str) {
        String strM202a = null;
        if (this.f217b != 1) {
            if (i >= this.f216a.length) {
                i = this.f216a.length - 1;
            }
            String strM202a2 = null;
            while (i >= 0) {
                if (this.f216a[i] != null && (strM202a2 = m202a((ArrayList) this.f216a[i], str)) != null) {
                    return strM202a2;
                }
                i--;
            }
            return strM202a2;
        }
        ArrayList arrayList = (ArrayList) this.f216a[this.f218c];
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                Pair pair = (Pair) arrayList.get(0);
                int length = ((String) pair.second).length();
                int length2 = str.length();
                if (length == length2 && ((String) pair.second).charAt(length - 1) == str.charAt(length2 - 1)) {
                    return (String) pair.first;
                }
                return null;
            }
            strM202a = m202a(arrayList, str);
        }
        return strM202a;
    }

    /* JADX INFO: renamed from: a */
    public final void m204a(int i) {
        if (this.f216a.length <= i || this.f216a[i] == null) {
            return;
        }
        this.f216a[i] = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m205a(int i, String str, String str2) {
        this.f218c = i;
        if (i >= this.f216a.length) {
            Object[] objArr = new Object[i + 1];
            for (int i2 = 0; i2 < this.f216a.length; i2++) {
                objArr[i2] = this.f216a[i2];
            }
            this.f216a = objArr;
        }
        if (this.f216a[i] != null) {
            ((ArrayList) this.f216a[i]).add(Pair.create(str, str2));
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create(str, str2));
        this.f216a[i] = arrayList;
        this.f217b++;
    }
}
