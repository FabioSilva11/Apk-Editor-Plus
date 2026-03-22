package com.p016a.p019b.p026b.p027a;

import com.p016a.p019b.p020a.p022b.C0459ah;
import com.p016a.p019b.p020a.p024d.InterfaceC0497h;
import com.p016a.p019b.p026b.C0522a;
import java.io.File;

/* JADX INFO: renamed from: com.a.b.b.a.b */
/* JADX INFO: loaded from: classes.dex */
final class C0524b implements InterfaceC0497h {
    C0524b() {
    }

    @Override // com.p016a.p019b.p020a.p024d.InterfaceC0497h
    /* JADX INFO: renamed from: a */
    public final void mo731a(File file) {
        if (C0523a.f661d.verbose) {
            C0522a.f656a.println("processing archive " + file + "...");
        }
    }

    @Override // com.p016a.p019b.p020a.p024d.InterfaceC0497h
    /* JADX INFO: renamed from: a */
    public final void mo732a(Exception exc) {
        if (exc instanceof C0531i) {
            throw ((C0531i) exc);
        }
        if (exc instanceof C0459ah) {
            C0522a.f657b.println("\nEXCEPTION FROM SIMULATION:");
            C0522a.f657b.println(exc.getMessage() + "\n");
            C0522a.f657b.println(((C0459ah) exc).m309a());
        } else {
            C0522a.f657b.println("\nUNEXPECTED TOP-LEVEL EXCEPTION:");
            exc.printStackTrace(C0522a.f657b);
        }
        C0523a.f660c.incrementAndGet();
    }

    @Override // com.p016a.p019b.p020a.p024d.InterfaceC0497h
    /* JADX INFO: renamed from: a */
    public final boolean mo733a(String str, long j, byte[] bArr) {
        return C0523a.m811b(str, j, bArr);
    }
}
