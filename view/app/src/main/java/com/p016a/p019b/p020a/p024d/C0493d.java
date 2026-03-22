package com.p016a.p019b.p020a.p024d;

import com.gmail.heagoo.p054a.p059c.C0985a;
import jadx.core.deobf.Deobfuscator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.a.b.a.d.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0493d {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC0498i f619a = new C0494e();

    /* JADX INFO: renamed from: b */
    private final String f620b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC0497h f621c;

    /* JADX INFO: renamed from: d */
    private final boolean f622d = false;

    /* JADX INFO: renamed from: e */
    private InterfaceC0498i f623e;

    public C0493d(String str, boolean z, InterfaceC0498i interfaceC0498i, InterfaceC0497h interfaceC0497h) {
        this.f620b = str;
        this.f621c = interfaceC0497h;
        this.f623e = interfaceC0498i;
    }

    /* JADX INFO: renamed from: a */
    private boolean m727a(File file) throws IOException {
        boolean zMo733a;
        ZipFile zipFile = new ZipFile(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(40000);
        byte[] bArr = new byte[20000];
        ArrayList<ZipEntry> list = Collections.list(zipFile.entries());
        if (this.f622d) {
            Collections.sort(list, new C0496g(this));
        }
        this.f621c.mo731a(file);
        boolean z = false;
        for (ZipEntry zipEntry : list) {
            if (!zipEntry.isDirectory()) {
                String name = zipEntry.getName();
                if (this.f623e.mo730a(name)) {
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    byteArrayOutputStream.reset();
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                    inputStream.close();
                    zMo733a = this.f621c.mo733a(name, zipEntry.getTime(), byteArrayOutputStream.toByteArray()) | z;
                } else {
                    zMo733a = z;
                }
                z = zMo733a;
            }
        }
        zipFile.close();
        return z;
    }

    /* JADX INFO: renamed from: a */
    private boolean m728a(File file, boolean z) {
        try {
            if (!file.isDirectory()) {
                String path = file.getPath();
                if (path.endsWith(".zip") || path.endsWith(".jar") || path.endsWith(".apk")) {
                    return m727a(file);
                }
                if (!this.f623e.mo730a(path)) {
                    return false;
                }
                return this.f621c.mo733a(path, file.lastModified(), C0985a.m2251b(file));
            }
            if (z) {
                file = new File(file, Deobfuscator.CLASS_NAME_SEPARATOR);
            }
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            if (this.f622d) {
                Arrays.sort(fileArrListFiles, new C0495f(this));
            }
            int i = 0;
            boolean z2 = false;
            while (i < length) {
                boolean zM728a = m728a(fileArrListFiles[i], false) | z2;
                i++;
                z2 = zM728a;
            }
            return z2;
        } catch (Exception e) {
            this.f621c.mo732a(e);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m729a() {
        return m728a(new File(this.f620b), true);
    }
}
