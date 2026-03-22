package com.gmail.heagoo.p054a.p058b;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: com.gmail.heagoo.a.b.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0984j extends AbstractC0976b {

    /* JADX INFO: renamed from: a */
    private ArrayList f2472a = new ArrayList();

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final int mo2158a() {
        int iM2161b = 0;
        Iterator it = this.f2472a.iterator();
        while (true) {
            int i = iM2161b;
            if (!it.hasNext()) {
                return i;
            }
            iM2161b = ((AbstractC0976b) it.next()).m2161b() + i;
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0984j m2164a(AbstractC0976b abstractC0976b) {
        this.f2472a.add(abstractC0976b);
        return this;
    }

    @Override // com.gmail.heagoo.p054a.p058b.AbstractC0976b
    /* JADX INFO: renamed from: a */
    public final void mo2159a(OutputStream outputStream) throws IOException {
        outputStream.write(49);
        m2160a(outputStream, mo2158a());
        Iterator it = this.f2472a.iterator();
        while (it.hasNext()) {
            ((AbstractC0976b) it.next()).mo2159a(outputStream);
        }
    }
}
