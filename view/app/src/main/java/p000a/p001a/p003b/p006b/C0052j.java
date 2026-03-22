package p000a.p001a.p003b.p006b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p000a.p001a.C0000a;

/* JADX INFO: renamed from: a.a.b.b.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0052j implements InterfaceC0053k {
    @Override // p000a.p001a.p003b.p006b.InterfaceC0053k
    /* JADX INFO: renamed from: a */
    public final void mo137a(InputStream inputStream, OutputStream outputStream) throws C0000a {
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return;
                } else {
                    outputStream.write(bArr, 0, i);
                }
            }
        } catch (IOException e) {
            throw new C0000a("Cannot decode raw stream", e);
        }
    }
}
