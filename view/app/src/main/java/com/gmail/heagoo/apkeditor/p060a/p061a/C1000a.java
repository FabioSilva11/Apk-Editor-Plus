package com.gmail.heagoo.apkeditor.p060a.p061a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1000a {

    /* JADX INFO: renamed from: a */
    private byte[] f2822a;

    /* JADX INFO: renamed from: b */
    private C1018s f2823b;

    /* JADX INFO: renamed from: c */
    private C1017r f2824c;

    /* JADX INFO: renamed from: d */
    private List f2825d = new ArrayList();

    public C1000a(C1018s c1018s, C1017r c1017r) {
        this.f2823b = c1018s;
        this.f2824c = c1017r;
    }

    /* JADX INFO: renamed from: b */
    private int m2657b(C1012m c1012m) throws IOException {
        int iM2687a = c1012m.m2687a();
        int iM2687a2 = c1012m.m2687a();
        this.f2822a = new byte[iM2687a2];
        C1004e.m2673a(this.f2822a, 0, iM2687a);
        C1004e.m2673a(this.f2822a, 4, iM2687a2);
        if (iM2687a2 > 8) {
            c1012m.m2689a(this.f2822a, 8, iM2687a2 - 8);
        }
        return iM2687a;
    }

    /* JADX INFO: renamed from: a */
    public final void m2658a() {
        List listM2711a = this.f2823b.m2711a();
        if (listM2711a == null || listM2711a.isEmpty()) {
            return;
        }
        int[] iArrM2717b = this.f2823b.m2717b();
        Iterator it = this.f2825d.iterator();
        while (it.hasNext()) {
            ((C1022w) it.next()).m2745a(iArrM2717b);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2659a(C1011l c1011l) throws IOException {
        Iterator it = this.f2825d.iterator();
        while (it.hasNext()) {
            ((C1022w) it.next()).m2743a(c1011l);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2660a(C1012m c1012m) {
        int iM2657b;
        Stack stack = new Stack();
        do {
            iM2657b = m2657b(c1012m);
            byte[] bArr = this.f2822a;
            C1022w c1022w = null;
            if (iM2657b == 1048834) {
                c1022w = new C1022w(iM2657b, bArr, this.f2823b, this.f2824c, stack.size());
                if (!stack.isEmpty()) {
                    c1022w.m2744a((C1022w) stack.peek());
                }
                stack.push(c1022w);
            } else if (iM2657b != 1048835) {
                c1022w = new C1022w(iM2657b, bArr, this.f2823b, this.f2824c, stack.size());
            } else if (!stack.isEmpty()) {
                stack.pop();
                c1022w = new C1022w(iM2657b, bArr, this.f2823b, this.f2824c, stack.size());
            }
            this.f2825d.add(c1022w);
        } while (iM2657b != C1001b.f2826a);
    }

    /* JADX INFO: renamed from: a */
    public final void m2661a(String str, int i, int i2, int i3, int i4) {
        for (C1022w c1022w : this.f2825d) {
            if (c1022w.m2741a() == 1048834 && str.equals(c1022w.m2746b())) {
                c1022w.m2742a(0, -1, 268435464, i4);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2662a(String str, String str2, InterfaceC1003d interfaceC1003d) {
        List<C1023x> listM2747c;
        for (C1022w c1022w : this.f2825d) {
            if (c1022w.m2741a() == 1048834 && str.equals(c1022w.m2746b()) && (listM2747c = c1022w.m2747c()) != null) {
                for (C1023x c1023x : listM2747c) {
                    if (str2.equals(c1023x.f2931b)) {
                        interfaceC1003d.mo2666a(c1023x);
                    }
                }
            }
        }
    }
}
