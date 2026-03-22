package p013b.p014a.p015a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* JADX INFO: renamed from: b.a.a.q */
/* JADX INFO: loaded from: classes.dex */
public class C0393q {

    /* JADX INFO: renamed from: a */
    private final File f331a;

    /* JADX INFO: renamed from: b */
    private final OutputStream f332b;

    public C0393q(File file) {
        this.f331a = File.createTempFile("NanoHTTPD-", "", file);
        this.f332b = new FileOutputStream(this.f331a);
    }

    /* JADX INFO: renamed from: a */
    public void m298a() throws Exception {
        AbstractC0377a.m245b(this.f332b);
        if (!this.f331a.delete()) {
            throw new Exception("could not delete temporary file");
        }
    }

    /* JADX INFO: renamed from: b */
    public String m299b() {
        return this.f331a.getAbsolutePath();
    }
}
