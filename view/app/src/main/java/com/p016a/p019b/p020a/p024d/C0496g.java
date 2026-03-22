package com.p016a.p019b.p020a.p024d;

import java.util.Comparator;
import java.util.zip.ZipEntry;

/* JADX INFO: renamed from: com.a.b.a.d.g */
/* JADX INFO: loaded from: classes.dex */
final class C0496g implements Comparator {
    C0496g(C0493d c0493d) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((ZipEntry) obj).getName().replace('$', '0').replace("package-info", "").compareTo(((ZipEntry) obj2).getName().replace('$', '0').replace("package-info", ""));
    }
}
