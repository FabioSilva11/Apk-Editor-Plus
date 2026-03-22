package com.gmail.heagoo.apkeditor;

import android.util.LruCache;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fg */
/* JADX INFO: loaded from: classes.dex */
final class C1214fg extends LruCache {
    C1214fg(C1213ff c1213ff, int i) {
        super(64);
    }

    @Override // android.util.LruCache
    protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        C1216fi c1216fi = (C1216fi) obj2;
        if (c1216fi.f3451a != null) {
            c1216fi.f3451a.recycle();
        }
    }
}
