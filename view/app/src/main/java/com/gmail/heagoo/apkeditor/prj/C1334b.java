package com.gmail.heagoo.apkeditor.prj;

import com.gmail.heagoo.common.C1469a;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.prj.b */
/* JADX INFO: loaded from: classes.dex */
final class C1334b extends Thread {

    /* JADX INFO: renamed from: a */
    private boolean f3787a = false;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ ProjectListActivity f3788b;

    C1334b(ProjectListActivity projectListActivity) {
        this.f3788b = projectListActivity;
    }

    /* JADX INFO: renamed from: a */
    final void m3223a() {
        this.f3787a = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new C1469a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.f3787a || i2 >= this.f3788b.f3784c.size()) {
                return;
            }
            C1338f c1338f = (C1338f) this.f3788b.f3784c.get(i2);
            try {
                this.f3788b.f3786e.m3224a(c1338f.f3800b, C1469a.m3488a(this.f3788b, c1338f.f3800b).f4292c);
            } catch (Exception e) {
            }
            i = i2 + 1;
        }
    }
}
