package p013b.p014a.p015a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: b.a.a.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0381e implements Iterable {

    /* JADX INFO: renamed from: a */
    private final HashMap f269a = new HashMap();

    /* JADX INFO: renamed from: b */
    private final ArrayList f270b = new ArrayList();

    public C0381e(AbstractC0377a abstractC0377a, Map map) {
        String str = (String) map.get("cookie");
        if (str != null) {
            String[] strArrSplit = str.split(";");
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.trim().split("=");
                if (strArrSplit2.length == 2) {
                    this.f269a.put(strArrSplit2[0], strArrSplit2[1]);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m264a(C0386j c0386j) {
        Iterator it = this.f270b.iterator();
        while (it.hasNext()) {
            c0386j.m289a("Set-Cookie", ((C0380d) it.next()).m263a());
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f269a.keySet().iterator();
    }
}
