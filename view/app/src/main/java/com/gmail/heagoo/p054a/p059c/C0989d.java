package com.gmail.heagoo.p054a.p059c;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;

/* JADX INFO: renamed from: com.gmail.heagoo.a.c.d */
/* JADX INFO: loaded from: classes.dex */
final class C0989d extends FilterOutputStream {

    /* JADX INFO: renamed from: a */
    private Signature f2491a;

    /* JADX INFO: renamed from: b */
    private int f2492b;

    public C0989d(OutputStream outputStream, Signature signature) {
        super(outputStream);
        this.f2491a = signature;
        this.f2492b = 0;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) throws IOException {
        try {
            this.f2491a.update((byte) i);
            super.write(i);
            this.f2492b++;
        } catch (SignatureException e) {
            throw new IOException("SignatureException: " + e);
        }
    }
}
