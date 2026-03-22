package com.p016a.p019b.p026b.p027a;

import com.p016a.p019b.p020a.p024d.InterfaceC0498i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.a.b.b.a.e */
/* JADX INFO: loaded from: classes.dex */
final class C0527e implements InterfaceC0498i {

    /* JADX INFO: renamed from: a */
    private Map f677a = new HashMap();

    public C0527e() {
        Iterator it = C0523a.f669l.iterator();
        while (it.hasNext()) {
            String strM818f = C0523a.m818f((String) it.next());
            String strM827b = m827b(strM818f);
            List arrayList = (List) this.f677a.get(strM827b);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f677a.put(strM827b, arrayList);
            }
            arrayList.add(strM818f);
        }
    }

    /* JADX INFO: renamed from: b */
    private static String m827b(String str) {
        int iLastIndexOf = str.lastIndexOf(47);
        return iLastIndexOf >= 0 ? str.substring(iLastIndexOf + 1) : str;
    }

    @Override // com.p016a.p019b.p020a.p024d.InterfaceC0498i
    /* JADX INFO: renamed from: a */
    public final boolean mo730a(String str) {
        if (!str.endsWith(".class")) {
            return true;
        }
        String strM818f = C0523a.m818f(str);
        List list = (List) this.f677a.get(m827b(strM818f));
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (strM818f.endsWith((String) it.next())) {
                    return true;
                }
            }
        }
        return false;
    }
}
