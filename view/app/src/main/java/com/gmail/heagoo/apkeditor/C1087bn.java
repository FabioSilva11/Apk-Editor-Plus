package com.gmail.heagoo.apkeditor;

import java.util.Comparator;
import java.util.Locale;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.bn */
/* JADX INFO: loaded from: classes.dex */
final class C1087bn implements Comparator {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Locale f3097a;

    C1087bn(C1085bl c1085bl, Locale locale) {
        this.f3097a = locale;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((C1084bk) obj).f3090c.toLowerCase(this.f3097a).compareTo(((C1084bk) obj2).f3090c.toLowerCase(this.f3097a));
    }
}
