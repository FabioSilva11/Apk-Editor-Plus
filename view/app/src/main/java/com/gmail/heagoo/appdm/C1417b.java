package com.gmail.heagoo.appdm;

import com.gmail.heagoo.p054a.p059c.C0986ax;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.b */
/* JADX INFO: loaded from: classes.dex */
final class C1417b extends Thread {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f4171a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f4172b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ DialogC1408a f4173c;

    C1417b(DialogC1408a dialogC1408a, String str, String str2) {
        this.f4173c = dialogC1408a;
        this.f4171a = str;
        this.f4172b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            C0986ax.a_003(new FileInputStream(this.f4171a), new FileOutputStream(this.f4172b));
            this.f4173c.m3434b();
        } catch (IOException e) {
            this.f4173c.m3433a(e.getMessage());
        }
    }
}
