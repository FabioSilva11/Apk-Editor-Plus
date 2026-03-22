package com.p016a.p019b.p020a.p024d;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: renamed from: com.a.b.a.d.f */
/* JADX INFO: loaded from: classes.dex */
final class C0495f implements Comparator {
    C0495f(C0493d c0493d) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((File) obj).getName().replace('$', '0').replace("package-info", "").compareTo(((File) obj2).getName().replace('$', '0').replace("package-info", ""));
    }
}
