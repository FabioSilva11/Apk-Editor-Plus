package com.p016a.p019b.p026b.p027a;

import com.p016a.p017a.C0410i;
import com.p016a.p017a.C0420s;
import com.p016a.p019b.p020a.p024d.C0491b;
import com.p016a.p019b.p020a.p024d.C0493d;
import com.p016a.p019b.p020a.p024d.C0500k;
import com.p016a.p019b.p020a.p024d.C0505p;
import com.p016a.p019b.p020a.p024d.InterfaceC0498i;
import com.p016a.p019b.p020a.p025e.C0514i;
import com.p016a.p019b.p026b.C0522a;
import com.p016a.p019b.p028c.p029a.C0534a;
import com.p016a.p019b.p028c.p029a.C0536c;
import com.p016a.p019b.p028c.p032c.C0642j;
import com.p016a.p019b.p028c.p032c.C0650r;
import com.p016a.p019b.p028c.p032c.C0654v;
import com.p016a.p019b.p035e.C0718a;
import com.p016a.p019b.p035e.C0719b;
import com.p016a.p019b.p036f.p037a.C0740a;
import com.p016a.p019b.p036f.p037a.C0742c;
import com.p016a.p019b.p036f.p037a.C0743d;
import com.p016a.p019b.p036f.p039c.C0801y;
import jadx.core.codegen.CodeWriter;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

/* JADX INFO: renamed from: com.a.b.b.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0523a {

    /* JADX INFO: renamed from: a */
    private static final Attributes.Name f658a;

    /* JADX INFO: renamed from: b */
    private static final String[] f659b;

    /* JADX INFO: renamed from: c */
    private static AtomicInteger f660c;

    /* JADX INFO: renamed from: d */
    private static C0525c f661d;

    /* JADX INFO: renamed from: e */
    private static C0650r f662e;

    /* JADX INFO: renamed from: f */
    private static TreeMap f663f;

    /* JADX INFO: renamed from: g */
    private static final List f664g;

    /* JADX INFO: renamed from: h */
    private static ExecutorService f665h;

    /* JADX INFO: renamed from: i */
    private static List f666i;

    /* JADX INFO: renamed from: j */
    private static volatile boolean f667j;

    /* JADX INFO: renamed from: k */
    private static long f668k;

    /* JADX INFO: renamed from: l */
    private static Set f669l;

    /* JADX INFO: renamed from: m */
    private static List f670m;

    /* JADX INFO: renamed from: n */
    private static OutputStreamWriter f671n;

    /* JADX INFO: renamed from: o */
    private static /* synthetic */ boolean f672o;

    static {
        f672o = !C0523a.class.desiredAssertionStatus();
        f658a = new Attributes.Name("Created-By");
        f659b = new String[]{"accessibility", "crypto", "imageio", "management", "naming", "net", "print", "rmi", "security", "sip", "sound", "sql", "swing", "transaction", "xml"};
        f660c = new AtomicInteger(0);
        f664g = new ArrayList();
        f668k = 0L;
        f669l = null;
        f670m = new ArrayList();
        f671n = null;
    }

    private C0523a() {
    }

    /* JADX INFO: renamed from: a */
    public static int m799a(C0525c c0525c) throws IOException {
        OutputStream outputStream;
        File file;
        byte[] bArrM821h;
        int iM816e;
        byte[] byteArray = null;
        f660c.set(0);
        f664g.clear();
        f661d = c0525c;
        c0525c.makeOptionsObjects();
        if (f661d.humanOutName != null) {
            OutputStream outputStreamM817e = m817e(f661d.humanOutName);
            f671n = new OutputStreamWriter(outputStreamM817e);
            outputStream = outputStreamM817e;
        } else {
            outputStream = null;
        }
        try {
            if (f661d.multiDex) {
                iM816e = m816e();
            } else {
                if (!f661d.incremental) {
                    file = null;
                } else if (f661d.outName == null) {
                    System.err.println("error: no incremental output name specified");
                    iM816e = -1;
                } else {
                    File file2 = new File(f661d.outName);
                    if (file2.exists()) {
                        f668k = file2.lastModified();
                    }
                    file = file2;
                }
                if (!m819f()) {
                    iM816e = 1;
                } else if (!f661d.incremental || f667j) {
                    if (f662e.m1217a() && f661d.humanOutName == null) {
                        bArrM821h = null;
                    } else {
                        bArrM821h = m821h();
                        if (bArrM821h == null) {
                            iM816e = 2;
                        }
                    }
                    if (f661d.incremental) {
                        C0410i c0410i = bArrM821h != null ? new C0410i(bArrM821h) : null;
                        C0410i c0410i2 = file.exists() ? new C0410i(file) : null;
                        if (c0410i != null || c0410i2 != null) {
                            C0410i c0410iM1373a = c0410i == null ? c0410i2 : c0410i2 == null ? c0410i : new C0719b(c0410i, c0410i2, C0718a.f1526a).m1373a();
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            c0410iM1373a.m357a(byteArrayOutputStream);
                            byteArray = byteArrayOutputStream.toByteArray();
                        }
                    } else {
                        byteArray = bArrM821h;
                    }
                    byte[] bArrM808a = m808a(byteArray);
                    if (f661d.jarOutput) {
                        f662e = null;
                        if (bArrM808a != null) {
                            f663f.put("classes.dex", bArrM808a);
                        }
                        if (!m815d(f661d.outName)) {
                            iM816e = 3;
                        }
                    } else if (bArrM808a != null && f661d.outName != null) {
                        OutputStream outputStreamM817e2 = m817e(f661d.outName);
                        outputStreamM817e2.write(bArrM808a);
                        m803a(outputStreamM817e2);
                    }
                    iM816e = 0;
                } else {
                    iM816e = 0;
                }
            }
            return iM816e;
        } finally {
            m803a(outputStream);
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m800a() {
        return f661d.multiDex ? "The list of classes given in --main-dex-list is too big and does not fit in the main dex." : "You may try using --multi-dex option.";
    }

    /* JADX INFO: renamed from: a */
    private static String m801a(int i) {
        return i == 0 ? "classes.dex" : "classes" + (i + 1) + ".dex";
    }

    /* JADX INFO: renamed from: a */
    private static void m803a(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            return;
        }
        outputStream.flush();
        if (outputStream != System.out) {
            outputStream.close();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m804a(String str, InterfaceC0498i interfaceC0498i) {
        byte b2 = 0;
        C0493d c0493d = new C0493d(str, false, interfaceC0498i, new C0524b());
        if (f661d.numThreads > 1) {
            f666i.add(f665h.submit(new CallableC0530h(c0493d, b2)));
        } else if (c0493d.m729a()) {
            f667j = true;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m806a(String str, byte[] bArr) {
        boolean z;
        if (!f661d.coreLibrary) {
            if (str.startsWith("java/")) {
                z = true;
            } else if (str.startsWith("javax/")) {
                int iIndexOf = str.indexOf(47, 6);
                if (iIndexOf == -1) {
                    z = true;
                } else {
                    z = Arrays.binarySearch(f659b, str.substring(6, iIndexOf)) >= 0;
                }
            } else {
                z = false;
            }
            if (z) {
                C0522a.f657b.println("\ntrouble processing \"" + str + "\":\n\nIll-advised or mistaken usage of a core class (java.* or javax.*)\nwhen not building a core library.\n\nThis is often due to inadvertently including a core library file\nin your application's project, when using an IDE (such as\nEclipse). If you are sure you're not intentionally defining a\ncore class, then this is the most likely explanation of what's\ngoing on.\n\nHowever, you might actually be trying to define a class in a core\nnamespace, the source of which you may have taken, for example,\nfrom a non-Android virtual machine project. This will most\nassuredly not work. At a minimum, it jeopardizes the\ncompatibility of your app with future versions of the platform.\nIt is also often of questionable legality.\n\nIf you really intend to build a core library -- which is only\nappropriate as part of creating a full virtual machine\ndistribution, as opposed to compiling an application -- then use\nthe \"--core-library\" option to suppress this error message.\n\nIf you go ahead and use \"--core-library\" but are in fact\nbuilding an application, then be forewarned that your application\nwill still fail to build or run, at some point. Please be\nprepared for angry customers who find, for example, that your\napplication ceases to function once they upgrade their operating\nsystem. You will be to blame for this problem.\n\nIf you are legitimately using some code that happens to be in a\ncore package, then the easiest safe alternative you have is to\nrepackage that code. That is, move the classes in question into\nyour own package namespace. This means that they will never be in\nconflict with core system classes. JarJar is a tool that may help\nyou in this endeavor. If you find that you cannot do this, then\nthat is an indication that the path you are on will ultimately\nlead to pain, suffering, grief, and lamentation.\n");
                f660c.incrementAndGet();
                throw new C0531i((byte) 0);
            }
        }
        C0500k c0500k = new C0500k(bArr, str, f661d.cfOptions$4cfd32cd.f685c);
        c0500k.m744a((C0491b) C0505p.f649a);
        c0500k.m746c();
        int size = f662e.m1232n().mo1046a().size();
        int size2 = f662e.m1231m().mo1046a().size();
        int iMo1606a = c0500k.m750g().mo1606a();
        int iM792d_ = size + iMo1606a + c0500k.m753j().m792d_() + 2;
        int iM790d_ = iMo1606a + size2 + c0500k.m752i().m790d_() + 9;
        if (f661d.multiDex && f662e.m1227i().mo1046a().size() > 0 && (iM792d_ > f661d.maxNumberOfIdxPerDex || iM790d_ > f661d.maxNumberOfIdxPerDex)) {
            C0650r c0650r = f662e;
            m820g();
            if (!f672o && (c0650r.m1232n().mo1046a().size() > size + 2 || c0650r.m1231m().mo1046a().size() > size2 + 9)) {
                throw new AssertionError();
            }
        }
        try {
            C0642j c0642jM828a = C0534a.m828a(c0500k, bArr, f661d.cfOptions$4cfd32cd, f661d.dexOptions, f662e);
            synchronized (f662e) {
                f662e.m1215a(c0642jM828a);
            }
            return true;
        } catch (C0514i e) {
            C0522a.f657b.println("\ntrouble processing:");
            if (f661d.debug) {
                e.printStackTrace(C0522a.f657b);
            } else {
                e.m310a(C0522a.f657b);
            }
            f660c.incrementAndGet();
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m807a(boolean z) {
        f667j = true;
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m808a(byte[] bArr) {
        for (byte[] bArr2 : f664g) {
            bArr = bArr == null ? bArr2 : new C0719b(new C0410i(bArr), new C0410i(bArr2), C0718a.f1527b).m1373a().m362d();
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static boolean m811b(String str, long j, byte[] bArr) {
        boolean zEndsWith = str.endsWith(".class");
        boolean zEquals = str.equals("classes.dex");
        boolean z = f663f != null;
        if (!zEndsWith && !zEquals && !z) {
            if (!f661d.verbose) {
                return false;
            }
            C0522a.f656a.println("ignored resource " + str);
            return false;
        }
        if (f661d.verbose) {
            C0522a.f656a.println("processing " + str + "...");
        }
        String strM818f = m818f(str);
        if (zEndsWith) {
            if (z && f661d.keepClassesInJar) {
                synchronized (f663f) {
                    f663f.put(strM818f, bArr);
                }
            }
            if (j < f668k) {
                return true;
            }
            return m806a(strM818f, bArr);
        }
        if (zEquals) {
            synchronized (f664g) {
                f664g.add(bArr);
            }
            return true;
        }
        synchronized (f663f) {
            f663f.put(strM818f, bArr);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public static Set m813c(String str) throws Throwable {
        BufferedReader bufferedReader;
        HashSet hashSet = new HashSet();
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        return hashSet;
                    }
                    hashSet.add(m818f(line));
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    /* JADX INFO: renamed from: d */
    private static boolean m815d(String str) {
        Manifest manifest;
        Attributes attributes;
        try {
            byte[] bArr = (byte[]) f663f.get("META-INF/MANIFEST.MF");
            if (bArr == null) {
                Manifest manifest2 = new Manifest();
                Attributes mainAttributes = manifest2.getMainAttributes();
                mainAttributes.put(Attributes.Name.MANIFEST_VERSION, "1.0");
                manifest = manifest2;
                attributes = mainAttributes;
            } else {
                Manifest manifest3 = new Manifest(new ByteArrayInputStream(bArr));
                Attributes mainAttributes2 = manifest3.getMainAttributes();
                f663f.remove("META-INF/MANIFEST.MF");
                manifest = manifest3;
                attributes = mainAttributes2;
            }
            String value = attributes.getValue(f658a);
            attributes.put(f658a, (value == null ? "" : value + " + ") + "dx 1.10");
            attributes.putValue("Dex-Location", "classes.dex");
            OutputStream outputStreamM817e = m817e(str);
            JarOutputStream jarOutputStream = new JarOutputStream(outputStreamM817e, manifest);
            try {
                for (Map.Entry entry : f663f.entrySet()) {
                    String str2 = (String) entry.getKey();
                    byte[] bArr2 = (byte[]) entry.getValue();
                    JarEntry jarEntry = new JarEntry(str2);
                    int length = bArr2.length;
                    if (f661d.verbose) {
                        C0522a.f656a.println("writing " + str2 + "; size " + length + "...");
                    }
                    jarEntry.setSize(length);
                    jarOutputStream.putNextEntry(jarEntry);
                    jarOutputStream.write(bArr2);
                    jarOutputStream.closeEntry();
                }
                return true;
            } finally {
                jarOutputStream.finish();
                jarOutputStream.flush();
                m803a(outputStreamM817e);
            }
        } catch (Exception e) {
            if (f661d.debug) {
                C0522a.f657b.println("\ntrouble writing output:");
                e.printStackTrace(C0522a.f657b);
            } else {
                C0522a.f657b.println("\ntrouble writing output: " + e.getMessage());
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: e */
    private static int m816e() throws IOException {
        if (!f672o && f661d.incremental) {
            throw new AssertionError();
        }
        if (!f672o && f661d.numThreads != 1) {
            throw new AssertionError();
        }
        if (f661d.mainDexListFile != null) {
            f669l = m813c(f661d.mainDexListFile);
        }
        if (!m819f()) {
            return 1;
        }
        if (!f664g.isEmpty()) {
            throw new C0420s("Library dex files are not supported in multi-dex mode");
        }
        if (f662e != null) {
            f670m.add(m821h());
            f662e = null;
        }
        if (f661d.jarOutput) {
            for (int i = 0; i < f670m.size(); i++) {
                f663f.put(m801a(i), f670m.get(i));
            }
            return !m815d(f661d.outName) ? 3 : 0;
        }
        if (f661d.outName == null) {
            return 0;
        }
        File file = new File(f661d.outName);
        if (!f672o && !file.isDirectory()) {
            throw new AssertionError();
        }
        for (int i2 = 0; i2 < f670m.size(); i2++) {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, m801a(i2)));
            try {
                fileOutputStream.write((byte[]) f670m.get(i2));
                m803a(fileOutputStream);
            } catch (Throwable th) {
                m803a(fileOutputStream);
                throw th;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: e */
    private static OutputStream m817e(String str) {
        return (str.equals("-") || str.startsWith("-.")) ? System.out : new FileOutputStream(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public static String m818f(String str) {
        if (File.separatorChar == '\\') {
            str = str.replace('\\', '/');
        }
        int iLastIndexOf = str.lastIndexOf("/./");
        return iLastIndexOf != -1 ? str.substring(iLastIndexOf + 3) : str.startsWith("./") ? str.substring(2) : str;
    }

    /* JADX INFO: renamed from: f */
    private static boolean m819f() {
        m820g();
        if (f661d.jarOutput) {
            f663f = new TreeMap();
        }
        f667j = false;
        String[] strArr = f661d.fileNames;
        if (f661d.numThreads > 1) {
            f665h = Executors.newFixedThreadPool(f661d.numThreads);
            f666i = new ArrayList();
        }
        try {
            if (f661d.mainDexListFile != null) {
                InterfaceC0498i c0528f = f661d.strictNameCheck ? new C0528f((byte) 0) : new C0527e();
                for (String str : strArr) {
                    m804a(str, c0528f);
                }
                if (f670m.size() > 0) {
                    throw new C0420s("Too many classes in --main-dex-list, main dex capacity exceeded");
                }
                if (f661d.minimalMainDex) {
                    m820g();
                }
                for (String str2 : strArr) {
                    m804a(str2, new C0529g(c0528f, (byte) 0));
                }
            } else {
                for (String str3 : strArr) {
                    m804a(str3, C0493d.f619a);
                }
            }
        } catch (C0531i e) {
        }
        if (f661d.numThreads > 1) {
            try {
                f665h.shutdown();
                if (!f665h.awaitTermination(600L, TimeUnit.SECONDS)) {
                    throw new RuntimeException("Timed out waiting for threads.");
                }
                try {
                    Iterator it = f666i.iterator();
                    while (it.hasNext()) {
                        ((Future) it.next()).get();
                    }
                } catch (InterruptedException e2) {
                    throw new AssertionError(e2);
                } catch (ExecutionException e3) {
                    if (e3.getCause() instanceof Error) {
                        throw ((Error) e3.getCause());
                    }
                    throw new AssertionError(e3.getCause());
                }
            } catch (InterruptedException e4) {
                f665h.shutdownNow();
                throw new RuntimeException("A thread has been interrupted.");
            }
        }
        int i = f660c.get();
        if (i != 0) {
            C0522a.f657b.println(i + " error" + (i == 1 ? "" : "s") + "; aborting");
            return false;
        }
        if (f661d.incremental && !f667j) {
            return true;
        }
        if (!f667j && !f661d.emptyOk) {
            C0522a.f657b.println("no classfiles specified");
            return false;
        }
        if (f661d.optimize && f661d.statistics) {
            C0536c.m839a(C0522a.f656a);
        }
        return true;
    }

    /* JADX INFO: renamed from: g */
    private static void m820g() {
        if (f662e != null) {
            f670m.add(m821h());
        }
        f662e = new C0650r(f661d.dexOptions);
        if (f661d.dumpWidth != 0) {
            f662e.m1214a(f661d.dumpWidth);
        }
    }

    /* JADX INFO: renamed from: h */
    private static byte[] m821h() {
        byte[] bArrM1218a;
        try {
            try {
                if (f661d.methodToDump != null) {
                    f662e.m1218a((Writer) null, false);
                    C0650r c0650r = f662e;
                    String str = f661d.methodToDump;
                    OutputStreamWriter outputStreamWriter = f671n;
                    boolean zEndsWith = str.endsWith("*");
                    int iLastIndexOf = str.lastIndexOf(46);
                    if (iLastIndexOf <= 0 || iLastIndexOf == str.length() - 1) {
                        C0522a.f657b.println("bogus fully-qualified method name: " + str);
                        bArrM1218a = null;
                    } else {
                        String strReplace = str.substring(0, iLastIndexOf).replace('.', '/');
                        String strSubstring = str.substring(iLastIndexOf + 1);
                        C0642j c0642jM1213a = c0650r.m1213a(strReplace);
                        if (c0642jM1213a == null) {
                            C0522a.f657b.println("no such class: " + strReplace);
                            bArrM1218a = null;
                        } else {
                            String strSubstring2 = zEndsWith ? strSubstring.substring(0, strSubstring.length() - 1) : strSubstring;
                            ArrayList<C0654v> arrayListM1183g = c0642jM1213a.m1183g();
                            TreeMap treeMap = new TreeMap();
                            for (C0654v c0654v : arrayListM1183g) {
                                String strM1649j = c0654v.m1243a().m1649j();
                                if ((zEndsWith && strM1649j.startsWith(strSubstring2)) || (!zEndsWith && strM1649j.equals(strSubstring2))) {
                                    treeMap.put(c0654v.m1246c().m1637l(), c0654v);
                                }
                            }
                            if (treeMap.size() == 0) {
                                C0522a.f657b.println("no such method: " + str);
                                bArrM1218a = null;
                            } else {
                                PrintWriter printWriter = new PrintWriter(outputStreamWriter);
                                for (C0654v c0654v2 : treeMap.values()) {
                                    c0654v2.m1245a(printWriter, f661d.verboseDump);
                                    C0801y c0801yM1182f = c0642jM1213a.m1182f();
                                    if (c0801yM1182f != null) {
                                        printWriter.println("  source file: " + c0801yM1182f.m1648i());
                                    }
                                    C0742c c0742cM1169a = c0642jM1213a.m1169a(c0654v2.m1246c());
                                    C0743d c0743dM1177b = c0642jM1213a.m1177b(c0654v2.m1246c());
                                    if (c0742cM1169a != null) {
                                        printWriter.println("  method annotations:");
                                        Iterator it = c0742cM1169a.m1450d().iterator();
                                        while (it.hasNext()) {
                                            printWriter.println(CodeWriter.INDENT + ((C0740a) it.next()));
                                        }
                                    }
                                    if (c0743dM1177b != null) {
                                        printWriter.println("  parameter annotations:");
                                        int iD_ = c0743dM1177b.m1977d_();
                                        for (int i = 0; i < iD_; i++) {
                                            printWriter.println("    parameter " + i);
                                            Iterator it2 = c0743dM1177b.m1452a(i).m1450d().iterator();
                                            while (it2.hasNext()) {
                                                printWriter.println("      " + ((C0740a) it2.next()));
                                            }
                                        }
                                    }
                                }
                                printWriter.flush();
                                bArrM1218a = null;
                            }
                        }
                    }
                } else {
                    bArrM1218a = f662e.m1218a(f671n, f661d.verboseDump);
                }
                if (f661d.statistics) {
                    C0522a.f656a.println(f662e.m1236r().m1105a());
                }
            } finally {
                if (f671n != null) {
                    f671n.flush();
                }
            }
        } catch (Exception e) {
            if (f661d.debug) {
                C0522a.f657b.println("\ntrouble writing output:");
                e.printStackTrace(C0522a.f657b);
            } else {
                C0522a.f657b.println("\ntrouble writing output: " + e.getMessage());
            }
            return null;
        }
    }
}
