package p013b.p014a.p015a;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

/* JADX INFO: renamed from: b.a.a.r */
/* JADX INFO: loaded from: classes.dex */
public class C0394r {

    /* JADX INFO: renamed from: a */
    private final File f333a = new File(System.getProperty("java.io.tmpdir"));

    /* JADX INFO: renamed from: b */
    private final List f334b;

    public C0394r() {
        if (!this.f333a.exists()) {
            this.f333a.mkdirs();
        }
        this.f334b = new ArrayList();
    }

    /* JADX INFO: renamed from: a */
    public void m300a() {
        Iterator it = this.f334b.iterator();
        while (it.hasNext()) {
            try {
                ((C0393q) it.next()).m298a();
            } catch (Exception e) {
                AbstractC0377a.f253g.log(Level.WARNING, "could not delete file ", (Throwable) e);
            }
        }
        this.f334b.clear();
    }

    /* JADX INFO: renamed from: b */
    public C0393q m301b() {
        C0393q c0393q = new C0393q(this.f333a);
        this.f334b.add(c0393q);
        return c0393q;
    }
}
