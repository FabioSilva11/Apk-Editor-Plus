package com.p016a.p019b.p033d;

import com.p016a.p019b.p033d.p034a.AbstractC0692f;

/* JADX INFO: renamed from: com.a.b.d.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0659a {

    /* JADX INFO: renamed from: a */
    private InterfaceC0714c f1213a = null;

    /* JADX INFO: renamed from: b */
    private InterfaceC0714c f1214b = null;

    /* JADX INFO: renamed from: c */
    private InterfaceC0714c f1215c = null;

    /* JADX INFO: renamed from: d */
    private InterfaceC0714c f1216d = null;

    /* JADX INFO: renamed from: e */
    private InterfaceC0714c f1217e = null;

    /* JADX INFO: renamed from: a */
    public final void m1253a(InterfaceC0714c interfaceC0714c) {
        this.f1213a = interfaceC0714c;
        this.f1214b = interfaceC0714c;
        this.f1215c = interfaceC0714c;
        this.f1216d = interfaceC0714c;
        this.f1217e = interfaceC0714c;
    }

    /* JADX INFO: renamed from: a */
    public final void m1254a(AbstractC0692f[] abstractC0692fArr) {
        for (AbstractC0692f abstractC0692f : abstractC0692fArr) {
            if (abstractC0692f != null) {
                InterfaceC0714c interfaceC0714c = null;
                switch (C0713b.f1287a[C0716e.m1340c(abstractC0692f.m1295b()) - 1]) {
                    case 1:
                        interfaceC0714c = this.f1214b;
                        break;
                    case 2:
                        interfaceC0714c = this.f1215c;
                        break;
                    case 3:
                        interfaceC0714c = this.f1216d;
                        break;
                    case 4:
                        interfaceC0714c = this.f1217e;
                        break;
                }
                if (interfaceC0714c == null) {
                    interfaceC0714c = this.f1213a;
                }
                if (interfaceC0714c != null) {
                    interfaceC0714c.mo1335a(abstractC0692f);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1255b(InterfaceC0714c interfaceC0714c) {
        this.f1214b = interfaceC0714c;
    }

    /* JADX INFO: renamed from: c */
    public final void m1256c(InterfaceC0714c interfaceC0714c) {
        this.f1215c = interfaceC0714c;
    }

    /* JADX INFO: renamed from: d */
    public final void m1257d(InterfaceC0714c interfaceC0714c) {
        this.f1216d = interfaceC0714c;
    }

    /* JADX INFO: renamed from: e */
    public final void m1258e(InterfaceC0714c interfaceC0714c) {
        this.f1217e = interfaceC0714c;
    }
}
