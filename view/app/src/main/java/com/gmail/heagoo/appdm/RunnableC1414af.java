package com.gmail.heagoo.appdm;

import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.af */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1414af implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f4163a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ List f4164b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ C1412ad f4165c;

    RunnableC1414af(C1412ad c1412ad, String str, List list) {
        this.f4165c = c1412ad;
        this.f4163a = str;
        this.f4164b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4165c.f4159f) {
            this.f4165c.f4156c = this.f4163a;
            this.f4165c.f4159f.clear();
            if (!this.f4165c.f4156c.equals(this.f4165c.f4155b)) {
                this.f4165c.f4159f.add(C1412ad.m3438a());
            }
            this.f4165c.f4159f.addAll(this.f4164b);
        }
        this.f4165c.notifyDataSetChanged();
    }
}
