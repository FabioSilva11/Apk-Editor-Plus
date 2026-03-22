package com.gmail.heagoo.httpserver;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.httpserver.f */
/* JADX INFO: loaded from: classes.dex */
final class ServiceConnectionC1497f implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    private WeakReference f4341a;

    /* JADX INFO: renamed from: b */
    private BinderC1495d f4342b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ C1496e f4343c;

    ServiceConnectionC1497f(C1496e c1496e, Activity activity) {
        this.f4343c = c1496e;
        this.f4341a = new WeakReference(activity);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f4342b = (BinderC1495d) iBinder;
        synchronized (this.f4343c.f4340b) {
            this.f4343c.f4340b.add(this);
        }
        String strM3553a = this.f4342b.m3553a();
        C1496e c1496e = this.f4343c;
        C1496e.m3558b((Activity) this.f4341a.get(), strM3553a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
