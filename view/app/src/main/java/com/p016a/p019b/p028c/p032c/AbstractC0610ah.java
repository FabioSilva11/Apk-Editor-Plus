package com.p016a.p019b.p028c.p032c;

import com.p016a.p017a.C0421t;
import com.p016a.p019b.p026b.p027a.C0523a;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: com.a.b.c.c.ah */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0610ah extends AbstractC0632bc {
    public AbstractC0610ah(String str, C0650r c0650r) {
        super(str, c0650r, 4);
    }

    /* JADX INFO: renamed from: d */
    private String m1061d() {
        TreeMap treeMap = new TreeMap();
        Iterator it = mo1046a().iterator();
        while (it.hasNext()) {
            String strM1649j = ((AbstractC0609ag) it.next()).m1048d().m1656j().m1649j();
            int iLastIndexOf = strM1649j.lastIndexOf(47);
            String strReplace = iLastIndexOf == -1 ? "default" : strM1649j.substring(strM1649j.lastIndexOf(91) + 2, iLastIndexOf).replace('/', '.');
            AtomicInteger atomicInteger = (AtomicInteger) treeMap.get(strReplace);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                treeMap.put(strReplace, atomicInteger);
            }
            atomicInteger.incrementAndGet();
        }
        Formatter formatter = new Formatter();
        try {
            formatter.format("Too many %s references: %d; max is %d.%n" + C0523a.m800a() + "%nReferences by package:", this instanceof C0613ak ? "method" : "field", Integer.valueOf(mo1046a().size()), 65536);
            for (Map.Entry entry : treeMap.entrySet()) {
                formatter.format("%n%6d %s", Integer.valueOf(((AtomicInteger) entry.getValue()).get()), entry.getKey());
            }
            return formatter.toString();
        } finally {
            formatter.close();
        }
    }

    @Override // com.p016a.p019b.p028c.p032c.AbstractC0632bc
    /* JADX INFO: renamed from: b */
    protected final void mo1047b() {
        int i = 0;
        if (mo1046a().size() > 65536) {
            throw new C0421t(m1061d());
        }
        Iterator it = mo1046a().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            ((AbstractC0609ag) it.next()).m1049a(i2);
            i = i2 + 1;
        }
    }
}
