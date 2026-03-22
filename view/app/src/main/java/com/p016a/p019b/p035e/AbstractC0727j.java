package com.p016a.p019b.p035e;

import com.p016a.p017a.C0401aa;
import com.p016a.p017a.C0410i;
import com.p016a.p017a.C0416o;
import com.p016a.p017a.C0427z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.a.b.e.j */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0727j {

    /* JADX INFO: renamed from: a */
    private final C0416o f1559a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C0719b f1560b;

    protected AbstractC0727j(C0719b c0719b, C0416o c0416o) {
        this.f1560b = c0719b;
        this.f1559a = c0416o;
    }

    /* JADX INFO: renamed from: a */
    private List m1378a(C0410i c0410i, C0730m c0730m) {
        C0401aa c0401aaMo1374a = mo1374a(c0410i.m356a());
        if (!c0401aaMo1374a.m312a()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        C0416o c0416oM354a = c0410i.m354a(c0401aaMo1374a.f343c);
        for (int i = 0; i < c0401aaMo1374a.f342b; i++) {
            arrayList.add(new C0728k(this, c0410i, c0730m, mo1375a(c0416oM354a, c0730m, 0), i, c0416oM354a.m378a()));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    abstract C0401aa mo1374a(C0427z c0427z);

    /* JADX INFO: renamed from: a */
    abstract Comparable mo1375a(C0416o c0416o, C0730m c0730m, int i);

    /* JADX INFO: renamed from: a */
    public final void m1379a() {
        int iM378a;
        Comparable comparableMo1375a;
        int i;
        boolean z;
        boolean z2;
        int i2;
        Comparable comparable;
        Comparable comparable2;
        int i3;
        int i4;
        C0401aa c0401aaMo1374a = mo1374a(this.f1560b.f1528a.m356a());
        C0401aa c0401aaMo1374a2 = mo1374a(this.f1560b.f1529b.m356a());
        mo1374a(this.f1560b.f1546s).f343c = this.f1559a.m378a();
        C0416o c0416oM354a = c0401aaMo1374a.m312a() ? this.f1560b.f1528a.m354a(c0401aaMo1374a.f343c) : null;
        C0416o c0416oM354a2 = c0401aaMo1374a2.m312a() ? this.f1560b.f1529b.m354a(c0401aaMo1374a2.f343c) : null;
        int i5 = -1;
        int i6 = 0;
        Comparable comparableMo1375a2 = null;
        Comparable comparable3 = null;
        int i7 = -1;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (comparable3 != null || i8 >= c0401aaMo1374a.f342b) {
                iM378a = i7;
                comparableMo1375a = comparable3;
            } else {
                iM378a = c0416oM354a.m378a();
                comparableMo1375a = mo1375a(c0416oM354a, this.f1560b.f1547t, i8);
            }
            if (comparableMo1375a2 != null || i6 >= c0401aaMo1374a2.f342b) {
                i = i5;
            } else {
                int iM378a2 = c0416oM354a2.m378a();
                comparableMo1375a2 = mo1375a(c0416oM354a2, this.f1560b.f1548u, i6);
                i = iM378a2;
            }
            if (comparableMo1375a == null || comparableMo1375a2 == null) {
                z = comparableMo1375a != null;
                z2 = comparableMo1375a2 != null;
            } else {
                int iCompareTo = comparableMo1375a.compareTo(comparableMo1375a2);
                z = iCompareTo <= 0;
                z2 = iCompareTo >= 0;
            }
            Comparable comparable4 = null;
            if (z) {
                mo1376a(iM378a, this.f1560b.f1547t, i8, i9);
                i8++;
                i2 = -1;
                Comparable comparable5 = comparableMo1375a;
                comparableMo1375a = null;
                comparable4 = comparable5;
            } else {
                i2 = iM378a;
            }
            if (z2) {
                int i10 = i6 + 1;
                mo1376a(i, this.f1560b.f1548u, i6, i9);
                comparable2 = null;
                i4 = -1;
                Comparable comparable6 = comparableMo1375a2;
                i3 = i10;
                comparable = comparable6;
            } else {
                comparable = comparable4;
                comparable2 = comparableMo1375a2;
                i3 = i6;
                i4 = i;
            }
            if (comparable == null) {
                mo1374a(this.f1560b.f1546s).f342b = i9;
                return;
            }
            mo1377a(comparable);
            i9++;
            Comparable comparable7 = comparableMo1375a;
            i7 = i2;
            i5 = i4;
            i6 = i3;
            comparableMo1375a2 = comparable2;
            comparable3 = comparable7;
        }
    }

    /* JADX INFO: renamed from: a */
    abstract void mo1376a(int i, C0730m c0730m, int i2, int i3);

    /* JADX INFO: renamed from: a */
    abstract void mo1377a(Comparable comparable);

    /* JADX INFO: renamed from: b */
    public final void m1380b() {
        int i;
        mo1374a(this.f1560b.f1546s).f343c = this.f1559a.m378a();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(m1378a(this.f1560b.f1528a, this.f1560b.f1547t));
        arrayList.addAll(m1378a(this.f1560b.f1529b, this.f1560b.f1548u));
        Collections.sort(arrayList);
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3 = i) {
            i = i3 + 1;
            C0728k c0728k = (C0728k) arrayList.get(i3);
            mo1376a(c0728k.f1564d, C0719b.m1347a(this.f1560b, c0728k.f1561a), c0728k.f1563c, i2 - 1);
            while (i < arrayList.size() && c0728k.compareTo((C0728k) arrayList.get(i)) == 0) {
                C0728k c0728k2 = (C0728k) arrayList.get(i);
                mo1376a(c0728k2.f1564d, C0719b.m1347a(this.f1560b, c0728k2.f1561a), c0728k2.f1563c, i2 - 1);
                i++;
            }
            mo1377a(c0728k.f1562b);
            i2++;
        }
        mo1374a(this.f1560b.f1546s).f342b = i2;
    }
}
