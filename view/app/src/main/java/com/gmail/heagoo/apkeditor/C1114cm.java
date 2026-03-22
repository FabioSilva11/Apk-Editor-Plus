package com.gmail.heagoo.apkeditor;

import com.gmail.heagoo.common.C1469a;
import com.gmail.heagoo.common.C1470b;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.cm */
/* JADX INFO: loaded from: classes.dex */
final class C1114cm extends Thread {

    /* JADX INFO: renamed from: a */
    private C1469a f3163a = null;

    /* JADX INFO: renamed from: b */
    private boolean f3164b = false;

    /* JADX INFO: renamed from: c */
    private List f3165c = new LinkedList();

    /* JADX INFO: renamed from: d */
    private /* synthetic */ FileListActivity f3166d;

    C1114cm(FileListActivity fileListActivity) {
        this.f3166d = fileListActivity;
    }

    /* JADX INFO: renamed from: a */
    public final void m2847a() {
        this.f3164b = true;
        synchronized (this.f3165c) {
            this.f3165c.notify();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2848a(String str) {
        synchronized (this.f3165c) {
            this.f3165c.add(str);
            this.f3165c.notify();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        C1470b c1470bM3488a;
        this.f3163a = new C1469a();
        while (!this.f3164b) {
            synchronized (this.f3165c) {
                if (this.f3165c.isEmpty()) {
                    try {
                        this.f3165c.wait();
                    } catch (InterruptedException e) {
                    }
                }
                str = !this.f3165c.isEmpty() ? (String) this.f3165c.remove(0) : null;
            }
            if (str != null) {
                try {
                    c1470bM3488a = C1469a.m3488a(this.f3166d, str);
                } catch (Throwable th) {
                    c1470bM3488a = null;
                }
                if (c1470bM3488a != null) {
                    this.f3166d.f2705k.put(str, c1470bM3488a);
                    FileListActivity.m2513g(this.f3166d);
                }
            }
        }
    }
}
