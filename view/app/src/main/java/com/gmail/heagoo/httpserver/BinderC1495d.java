package com.gmail.heagoo.httpserver;

import android.os.Binder;

/* JADX INFO: renamed from: com.gmail.heagoo.httpserver.d */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC1495d extends Binder {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ HttpService f4338a;

    public BinderC1495d(HttpService httpService) {
        this.f4338a = httpService;
    }

    /* JADX INFO: renamed from: a */
    public final String m3553a() {
        if (this.f4338a.f4331c == null || !this.f4338a.f4331c.m257d()) {
            return null;
        }
        return this.f4338a.f4331c.m3550a();
    }
}
