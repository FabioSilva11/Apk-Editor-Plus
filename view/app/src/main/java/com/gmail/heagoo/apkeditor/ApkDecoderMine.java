package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.support.v4.os.EnvironmentCompat;
import androidx.versionedparcelable.InterfaceC0376d;
import com.android.apksig.apk.ApkUtils;
import com.gmail.heagoo.common.C1476h;
import com.gmail.heagoo.p054a.p059c.C0985a;
import jadx.core.deobf.Deobfuscator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.p074io.FilenameUtils;
import org.xmlpull.v1.XmlSerializer;
import p000a.p001a.C0000a;
import p000a.p001a.p003b.p004a.C0031e;
import p000a.p001a.p003b.p004a.C0032f;
import p000a.p001a.p003b.p004a.C0033g;
import p000a.p001a.p003b.p004a.C0036j;
import p000a.p001a.p003b.p006b.C0049g;
import p000a.p001a.p003b.p006b.C0052j;
import p000a.p001a.p003b.p006b.C0054l;
import p000a.p001a.p003b.p007c.C0057a;
import p000a.p001a.p003b.p008d.InterfaceC0059a;
import p000a.p010c.C0065e;
import p000a.p010c.C0066f;
import p000a.p010c.InterfaceC0064d;
import p000a.p011d.C0074f;
import p000a.p011d.C0076h;

/* JADX INFO: loaded from: classes.dex */
public final class ApkDecoderMine implements InterfaceC0376d {

    /* JADX INFO: renamed from: a */
    private C0985a f2548a;

    /* JADX INFO: renamed from: b */
    private C1311ix f2549b;

    /* JADX INFO: renamed from: f */
    private byte[] f2553f;

    /* JADX INFO: renamed from: g */
    private byte[] f2554g;

    /* JADX INFO: renamed from: i */
    private boolean f2556i;

    /* JADX INFO: renamed from: j */
    private static final String[] f2546j = {"classes.dex", ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME, "resources.arsc"};

    /* JADX INFO: renamed from: k */
    private static final String[] f2547k = {"res", "r", "R", "lib", "libs", "assets", "kotlin"};
    private static final Pattern NO_COMPRESS_PATTERN = Pattern.compile("(jpg|jpeg|png|gif|wav|mp2|mp3|ogg|aac|mpg|mpeg|mid|midi|smf|jet|rtttl|imy|xmf|mp4|m4a|m4v|3gp|3gpp|3g2|3gpp2|amr|awb|wma|wmv|webm|webp|mkv)$");

    /* JADX INFO: renamed from: c */
    private C0054l f2550c = new C0054l();

    /* JADX INFO: renamed from: d */
    private String f2551d = "";

    /* JADX INFO: renamed from: e */
    private boolean f2552e = false;

    /* JADX INFO: renamed from: h */
    private Map f2555h = new HashMap();

    public ApkDecoderMine(C0985a c0985a, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        boolean z = false;
        this.f2548a = c0985a;
        this.f2553f = bArr;
        this.f2554g = bArr2;
        if (bArr2 == null && bArr == null) {
            z = true;
        }
        this.f2556i = z;
        Set setM2304a = this.f2548a.m2304a();
        this.f2549b = new C1311ix(this, (setM2304a == null || setM2304a.isEmpty()) ? null : (C0031e) setM2304a.iterator().next());
        this.f2550c.m143a("xml", this.f2549b);
        this.f2550c.m143a("9path", new C0049g());
        this.f2550c.m143a("raw", new C0052j());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:50:0x0127
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:280)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:79)
        */
    /* JADX INFO: renamed from: a */
    private void m2362a(p000a.p001a.p003b.p007c.C0057a r17, p000a.p010c.InterfaceC0064d r18) {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.ApkDecoderMine.m2362a(a.a.b.c.a, a.c.d):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m2363a(p000a.p010c.InterfaceC0064d r6, java.lang.String r7, p000a.p010c.InterfaceC0064d r8, java.lang.String r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            r5 = this;
            r2 = 0
            r0 = 1
            java.lang.String r1 = "xml"
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L25
            java.lang.String r1 = ".xml"
            boolean r1 = r9.endsWith(r1)
            if (r1 != 0) goto L25
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r3 = ".xml"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r9 = r1.toString()
        L25:
            r1 = 0
            boolean r3 = r5.f2556i     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbc
            if (r3 != 0) goto Lbf
            java.lang.String r3 = "raw"
            boolean r3 = r3.equals(r10)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbc
            if (r3 == 0) goto Lbf
            java.lang.String r3 = ""
            java.lang.String r4 = r5.f2551d     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbc
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbc
            if (r3 != 0) goto Lbf
            java.lang.String r3 = ".jpg"
            boolean r3 = r9.endsWith(r3)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbc
            if (r3 == 0) goto L90
            java.io.OutputStream r1 = r8.mo171c(r9)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbc
            byte[] r3 = r5.f2554g     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            r1.write(r3)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
        L4d:
            if (r0 != 0) goto L5c
            java.io.InputStream r2 = r6.mo169b(r7)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            java.io.OutputStream r1 = r8.mo171c(r9)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            a.a.b.b.l r0 = r5.f2550c     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            r0.m142a(r2, r1, r10)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
        L5c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            java.lang.String r3 = "res/"
            r0.<init>(r3)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            java.lang.StringBuilder r0 = r0.append(r9)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            r3.<init>()     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            java.lang.String r4 = r5.f2551d     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            boolean r4 = r0.equals(r3)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            if (r4 != 0) goto L89
            java.util.Map r4 = r5.f2555h     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            r4.put(r0, r3)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
        L89:
            m2364a(r2)
            m2364a(r1)
            return
        L90:
            java.lang.String r3 = ".png"
            boolean r3 = r9.endsWith(r3)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbc
            if (r3 == 0) goto Lbf
            java.lang.String r3 = ".9.png"
            boolean r3 = r9.endsWith(r3)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbc
            if (r3 != 0) goto Lbf
            java.io.OutputStream r1 = r8.mo171c(r9)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbc
            byte[] r3 = r5.f2553f     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            r1.write(r3)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb1
            goto L4d
        Laa:
            r0 = move-exception
        Lab:
            a.a.a r3 = new a.a.a     // Catch: java.lang.Throwable -> Lb1
            r3.<init>(r0)     // Catch: java.lang.Throwable -> Lb1
            throw r3     // Catch: java.lang.Throwable -> Lb1
        Lb1:
            r0 = move-exception
        Lb2:
            m2364a(r2)
            m2364a(r1)
            throw r0
        Lb9:
            r0 = move-exception
            r1 = r2
            goto Lb2
        Lbc:
            r0 = move-exception
            r1 = r2
            goto Lab
        Lbf:
            r0 = r1
            r1 = r2
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.ApkDecoderMine.m2363a(a.c.d, java.lang.String, a.c.d, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: renamed from: a */
    private static void m2364a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2365a(File file) throws C0000a {
        for (C0031e c0031e : this.f2548a.m2304a()) {
            if (this.f2552e) {
                return;
            }
            try {
                File file2 = new File(file, "values/public.xml");
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
                outputStreamWriter.write("<resources>\n");
                for (C0032f c0032f : c0031e.m44a()) {
                    outputStreamWriter.write(String.format("<public type=\"%s\" name=\"%s\" id=\"0x%08x\" />\n", c0032f.m69h().m80a(), c0032f.m67f(), Integer.valueOf(c0032f.m66e().f64b)));
                }
                outputStreamWriter.write("</resources>");
                outputStreamWriter.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw new C0000a("Could not generate public.xml file", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2366a(String str) {
        String[] strArr = f2546j;
        for (int i = 0; i < 3; i++) {
            if (strArr[i].equals(str)) {
                return true;
            }
        }
        String[] strArr2 = f2547k;
        for (int i2 = 0; i2 < 7; i2++) {
            if (str.startsWith(strArr2[i2] + "/")) {
                return true;
            }
        }
        return str.endsWith(".dex") && !str.contains("/");
    }

    /* JADX INFO: renamed from: b */
    private void m2367b(C0057a c0057a, File file) throws C0000a {
        File file2 = new File(file, EnvironmentCompat.MEDIA_UNKNOWN);
        try {
            InterfaceC0064d interfaceC0064dM158a = c0057a.m158a();
            Collection collectionValues = this.f2555h.values();
            for (String str : interfaceC0064dM158a.mo164a(true)) {
                if (!m2366a(str) && !collectionValues.contains(str)) {
                    interfaceC0064dM158a.mo167a(file2, str);
                }
            }
        } catch (C0065e e) {
            throw new C0000a(e);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2368b(File file) throws IOException {
        for (C0031e c0031e : this.f2548a.m2304a()) {
            if (this.f2552e) {
                return;
            }
            for (C0036j c0036j : c0031e.m52c()) {
                if (!this.f2552e) {
                    String strM85a = c0036j.m85a();
                    int iLastIndexOf = strM85a.lastIndexOf(47);
                    if (iLastIndexOf != -1) {
                        File file2 = new File(file, strM85a.substring(0, iLastIndexOf));
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                    }
                    XmlSerializer c0076h = new C0076h();
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(file, strM85a));
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    c0076h.setOutput(outputStreamWriter);
                    outputStreamWriter.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
                    outputStreamWriter.write("<resources>\n");
                    for (C0033g c0033g : c0036j.m87b()) {
                        if (!c0036j.m86a(c0033g)) {
                            Object objM75d = c0033g.m75d();
                            if (objM75d instanceof InterfaceC0059a) {
                                try {
                                    ((InterfaceC0059a) objM75d).mo1a(c0076h, c0033g);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            c0076h.flush();
                            outputStreamWriter.write("\n");
                        }
                    }
                    outputStreamWriter.write("</resources>\n");
                    outputStreamWriter.close();
                    fileOutputStream.close();
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m2369c(C0057a c0057a, File file) throws C0000a {
        try {
            InterfaceC0064d interfaceC0064dM158a = c0057a.m158a();
            if (interfaceC0064dM158a.mo168a("assets")) {
                interfaceC0064dM158a.mo167a(file, "assets");
            }
            if (interfaceC0064dM158a.mo168a("lib")) {
                interfaceC0064dM158a.mo167a(file, "lib");
            }
            if (interfaceC0064dM158a.mo168a("libs")) {
                interfaceC0064dM158a.mo167a(file, "libs");
            }
            if (interfaceC0064dM158a.mo168a("kotlin")) {
                interfaceC0064dM158a.mo167a(file, "kotlin");
            }
            for (String str : interfaceC0064dM158a.mo164a(false)) {
                if (str.endsWith(".dex")) {
                    interfaceC0064dM158a.mo167a(file, str);
                }
            }
        } catch (C0065e e) {
            throw new C0000a(e);
        }
    }

    /* JADX INFO: renamed from: d */
    private String m2370d(C0057a c0057a, File file) throws Throwable {
        InputStream inputStreamMo169b;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            inputStreamMo169b = c0057a.m158a().mo169b(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
            try {
                fileOutputStream = new FileOutputStream(new File(file, ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME));
            } catch (Exception e) {
                e = e;
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                try {
                    inputStreamMo169b.close();
                } catch (Exception e2) {
                }
                try {
                    fileOutputStream2.close();
                    throw th;
                } catch (Exception e3) {
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            inputStreamMo169b = null;
        } catch (Throwable th2) {
            th = th2;
            inputStreamMo169b = null;
        }
        try {
            try {
                this.f2549b.m3190b(inputStreamMo169b, fileOutputStream);
                try {
                    inputStreamMo169b.close();
                } catch (Exception e5) {
                }
                try {
                    fileOutputStream.close();
                } catch (Exception e6) {
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                inputStreamMo169b.close();
                fileOutputStream2.close();
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            e.printStackTrace();
            try {
                inputStreamMo169b.close();
            } catch (Exception e8) {
            }
            try {
                fileOutputStream.close();
            } catch (Exception e9) {
            }
        }
        return null;
    }

    private String extension(String str, InterfaceC0064d interfaceC0064d) {
        int iLastIndexOf = str.lastIndexOf(Deobfuscator.CLASS_NAME_SEPARATOR);
        if (iLastIndexOf != -1 && !this.f2551d.equalsIgnoreCase("r/")) {
            return str.endsWith(".9.png") ? ".9.png" : str.substring(iLastIndexOf).toLowerCase();
        }
        byte[] bArr = new byte[4];
        String lowerCase = iLastIndexOf > 0 ? str.substring(iLastIndexOf).toLowerCase() : "";
        try {
            InputStream inputStreamMo169b = interfaceC0064d.mo169b(str);
            if (inputStreamMo169b.read(bArr) != bArr.length) {
                return lowerCase;
            }
            inputStreamMo169b.close();
            return (bArr[0] == 3 && bArr[1] == 0 && bArr[2] == 8 && bArr[3] == 0) ? ".xml" : ((bArr[0] & 255) == 255 && (bArr[1] & 255) == 216 && (bArr[2] & 255) == 255 && (bArr[3] & 255) == 224) ? ".jpg" : (bArr[0] == 82 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 70) ? ".webp" : ((bArr[0] & 255) == 137 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71) ? is9patch(interfaceC0064d, str) ? ".9.png" : ".png" : lowerCase;
        } catch (C0065e | IOException e) {
            e.printStackTrace();
            return lowerCase;
        }
    }

    private boolean find9patchChunk(C0074f c0074f) {
        try {
            c0074f.skipBytes(8);
            while (true) {
                int i = c0074f.readInt();
                if (c0074f.readInt() == 1852855395) {
                    return true;
                }
                c0074f.skipBytes(i + 4);
            }
        } catch (EOFException e) {
            return false;
        }
    }

    private boolean is9patch(InterfaceC0064d interfaceC0064d, String str) {
        try {
            InputStream inputStreamMo169b = interfaceC0064d.mo169b(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            C0985a.m2244b(inputStreamMo169b, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            inputStreamMo169b.close();
            if (byteArray.length == 0) {
                return false;
            }
            return find9patchChunk(new C0074f(new ByteArrayInputStream(byteArray)));
        } catch (IOException e) {
            return false;
        }
    }

    private static boolean isRes(String str) {
        String[] strArr = f2547k;
        for (int i = 0; i < 3; i++) {
            if (str.startsWith(strArr[i] + "/")) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStd(String str) {
        String[] strArr = f2546j;
        for (int i = 0; i < 3; i++) {
            if (strArr[i].equals(str)) {
                return true;
            }
        }
        return str.endsWith(".dex");
    }

    /* JADX INFO: renamed from: a */
    public final Map m2371a() {
        return this.f2555h;
    }

    /* JADX INFO: renamed from: a */
    public final void m2372a(C0057a c0057a, File file) {
        if (!c0057a.m158a().mo168a("res")) {
            this.f2549b.m3189a(true);
        }
        if (!this.f2552e) {
            m2370d(c0057a, file);
        }
        try {
            C1476h.m3508a(new File(file.getPath() + "/res"));
        } catch (Exception e) {
        }
        new StringBuilder().append(file.getPath()).append("/res deleted!");
        File file2 = new File(file, "res");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (!this.f2552e) {
            m2362a(c0057a, new C0066f(file2));
        }
        if (!this.f2552e) {
            m2368b(file2);
        }
        if (!this.f2552e) {
            m2365a(file2);
            recordUncompressedFiles(c0057a);
        }
        if (this.f2556i) {
            if (!this.f2552e) {
                m2369c(c0057a, file);
            }
            if (this.f2552e) {
                return;
            }
            m2367b(c0057a, file);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m2373b() {
        this.f2552e = true;
    }

    public void recordUncompressedFiles(C0057a c0057a) {
        String extension;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f2555h.entrySet()) {
            map.put((String) entry.getValue(), (String) entry.getKey());
        }
        try {
            InterfaceC0064d interfaceC0064dM158a = c0057a.m158a();
            for (String str : interfaceC0064dM158a.mo164a(true)) {
                if (interfaceC0064dM158a.getCompressionLevel(str) == 0 && interfaceC0064dM158a.getSize(str) > 0) {
                    String str2 = (String) map.get(str);
                    if (str2 != null) {
                        extension = FilenameUtils.getExtension(str2);
                        str = str2;
                    } else {
                        extension = FilenameUtils.getExtension(str);
                    }
                    if (!NO_COMPRESS_PATTERN.matcher(extension).find()) {
                        if (extension.isEmpty()) {
                        }
                        if (!isStd(str)) {
                            if (isRes(str)) {
                                hashSet.add(str);
                            } else {
                                hashSet2.add(str);
                            }
                        }
                    }
                }
            }
            if (hashSet.isEmpty() && hashSet2.isEmpty()) {
                return;
            }
            String strM2263d = C0985a.m2263d((Context) null, "tmp");
            if (!hashSet.isEmpty()) {
                C0985a.m2225a(strM2263d + "aaptUncString", hashSet);
            }
            if (hashSet2.isEmpty()) {
                return;
            }
            C0985a.m2225a(strM2263d + "mdUncString", hashSet2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
