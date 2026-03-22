package com.gmail.heagoo.apkeditor.prj;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.prj.c */
/* JADX INFO: loaded from: classes.dex */
final class HandlerC1335c extends Handler {

    /* JADX INFO: renamed from: a */
    private WeakReference f3789a;

    /* JADX INFO: renamed from: b */
    private final Map f3790b = new HashMap();

    HandlerC1335c(ProjectListActivity projectListActivity) {
        this.f3789a = new WeakReference(projectListActivity);
    }

    /* JADX INFO: renamed from: a */
    final void m3224a(String str, Drawable drawable) {
        synchronized (this.f3790b) {
            this.f3790b.put(str, drawable);
        }
        sendEmptyMessage(0);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                synchronized (this.f3790b) {
                    ((ProjectListActivity) this.f3789a.get()).f3782a.m3228a(this.f3790b);
                    break;
                }
                ((ProjectListActivity) this.f3789a.get()).f3782a.notifyDataSetChanged();
                return;
            default:
                return;
        }
    }
}
