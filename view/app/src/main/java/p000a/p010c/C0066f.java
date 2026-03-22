package p000a.p010c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: renamed from: a.c.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0066f extends AbstractC0061a {

    /* JADX INFO: renamed from: c */
    private File f179c;

    public C0066f(File file) throws C0065e {
        if (!file.isDirectory()) {
            throw new C0065e("File must be a directory: " + file);
        }
        this.f179c = file;
    }

    /* JADX INFO: renamed from: c */
    private void m178c() {
        this.f173a = new LinkedHashSet();
        this.f174b = new LinkedHashMap();
        File[] fileArrListFiles = this.f179c.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isFile()) {
                    this.f173a.add(file.getName());
                } else {
                    try {
                        this.f174b.put(file.getName(), new C0066f(file));
                    } catch (C0065e e) {
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: j */
    private String m179j(String str) {
        return this.f179c.getPath() + '/' + str;
    }

    @Override // p000a.p010c.AbstractC0061a
    /* JADX INFO: renamed from: a */
    protected final void mo165a() {
        m178c();
    }

    @Override // p000a.p010c.AbstractC0061a
    /* JADX INFO: renamed from: b */
    protected final void mo170b() {
        m178c();
    }

    @Override // p000a.p010c.AbstractC0061a
    /* JADX INFO: renamed from: f */
    protected final InputStream mo174f(String str) throws C0065e {
        try {
            return new FileInputStream(m179j(str));
        } catch (FileNotFoundException e) {
            throw new C0065e(e);
        }
    }

    @Override // p000a.p010c.AbstractC0061a
    /* JADX INFO: renamed from: g */
    protected final OutputStream mo175g(String str) throws C0065e {
        try {
            return new FileOutputStream(m179j(str));
        } catch (FileNotFoundException e) {
            throw new C0065e(e);
        }
    }

    @Override // p000a.p010c.InterfaceC0064d
    public int getCompressionLevel(String str) {
        return 0;
    }

    @Override // p000a.p010c.InterfaceC0064d
    public long getSize(String str) {
        return 0L;
    }

    @Override // p000a.p010c.AbstractC0061a
    /* JADX INFO: renamed from: h */
    protected final AbstractC0061a mo176h(String str) {
        File file = new File(m179j(str));
        file.mkdir();
        return new C0066f(file);
    }

    @Override // p000a.p010c.AbstractC0061a
    /* JADX INFO: renamed from: i */
    protected final void mo177i(String str) {
        new File(m179j(str)).delete();
    }
}
