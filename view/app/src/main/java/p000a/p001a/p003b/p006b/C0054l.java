package p000a.p001a.p003b.p006b;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.C0000a;

/* JADX INFO: renamed from: a.a.b.b.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0054l {

    /* JADX INFO: renamed from: a */
    private final Map f160a = new HashMap();

    /* JADX INFO: renamed from: a */
    public final void m142a(InputStream inputStream, OutputStream outputStream, String str) throws C0000a {
        InterfaceC0053k interfaceC0053k = (InterfaceC0053k) this.f160a.get(str);
        if (interfaceC0053k == null) {
            throw new C0000a("Unkown DER: " + str);
        }
        interfaceC0053k.mo137a(inputStream, outputStream);
    }

    /* JADX INFO: renamed from: a */
    public final void m143a(String str, InterfaceC0053k interfaceC0053k) {
        this.f160a.put(str, interfaceC0053k);
    }
}
