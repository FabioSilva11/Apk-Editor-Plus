package p000a.p010c;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: a.c.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0069i extends AbstractC0061a {

    /* JADX INFO: renamed from: c */
    private ZipFile f180c;

    /* JADX INFO: renamed from: d */
    private String f181d;

    public C0069i(File file) {
        this(file, "");
    }

    private C0069i(File file, String str) throws C0065e {
        try {
            this.f180c = new ZipFile(file);
            this.f181d = str;
        } catch (IOException e) {
            throw new C0065e(e);
        }
    }

    private C0069i(ZipFile zipFile, String str) {
        this.f180c = zipFile;
        this.f181d = str;
    }

    /* JADX INFO: renamed from: c */
    private void m180c() {
        String strSubstring;
        this.f173a = new LinkedHashSet();
        this.f174b = new LinkedHashMap();
        int length = this.f181d.length();
        Enumeration<? extends ZipEntry> enumerationEntries = this.f180c.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            String name = zipEntryNextElement.getName();
            if (!name.equals(this.f181d) && name.startsWith(this.f181d)) {
                String strSubstring2 = name.substring(length);
                int iIndexOf = strSubstring2.indexOf(47);
                if (iIndexOf != -1) {
                    strSubstring = strSubstring2.substring(0, iIndexOf);
                } else if (zipEntryNextElement.isDirectory()) {
                    strSubstring = strSubstring2;
                } else {
                    this.f173a.add(strSubstring2);
                }
                if (!this.f174b.containsKey(strSubstring)) {
                    this.f174b.put(strSubstring, new C0069i(this.f180c, this.f181d + strSubstring + '/'));
                }
            }
        }
    }

    private ZipEntry getZipFileEntry(String str) {
        return this.f180c.getEntry(str);
    }

    @Override // p000a.p010c.AbstractC0061a
    /* JADX INFO: renamed from: a */
    protected final void mo165a() {
        m180c();
    }

    @Override // p000a.p010c.AbstractC0061a
    /* JADX INFO: renamed from: b */
    protected final void mo170b() {
        m180c();
    }

    @Override // p000a.p010c.AbstractC0061a
    /* JADX INFO: renamed from: f */
    protected final InputStream mo174f(String str) throws C0068h {
        try {
            return this.f180c.getInputStream(new ZipEntry(this.f181d + str));
        } catch (IOException e) {
            throw new C0068h(str, e);
        }
    }

    @Override // p000a.p010c.AbstractC0061a
    /* JADX INFO: renamed from: g */
    protected final OutputStream mo175g(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // p000a.p010c.InterfaceC0064d
    public int getCompressionLevel(String str) {
        return getZipFileEntry(str).getMethod();
    }

    @Override // p000a.p010c.InterfaceC0064d
    public long getSize(String str) {
        return getZipFileEntry(str).getSize();
    }

    @Override // p000a.p010c.AbstractC0061a
    /* JADX INFO: renamed from: h */
    protected final AbstractC0061a mo176h(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // p000a.p010c.AbstractC0061a
    /* JADX INFO: renamed from: i */
    protected final void mo177i(String str) {
        throw new UnsupportedOperationException();
    }
}
