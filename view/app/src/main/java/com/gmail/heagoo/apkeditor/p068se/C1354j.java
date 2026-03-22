package com.gmail.heagoo.apkeditor.p068se;

import android.util.LruCache;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.j */
/* JADX INFO: loaded from: classes.dex */
final class C1354j extends LruCache {
    C1354j(ViewOnClickListenerC1353i viewOnClickListenerC1353i, int i) {
        super(32);
    }

    @Override // android.util.LruCache
    protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        C1359o c1359o = (C1359o) obj2;
        if (c1359o.f3907a != null) {
            c1359o.f3907a.recycle();
        }
    }
}
