package org.p085d;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.p085d.p086a.C1667d;
import org.p085d.p087b.C1671c;
import org.p085d.p087b.C1673e;
import org.p085d.p087b.C1674f;
import org.p085d.p087b.C1675g;
import org.slf4j.impl.StaticLoggerBinder;

/* JADX INFO: renamed from: org.d.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1677c {

    /* JADX INFO: renamed from: a */
    private static volatile int f4764a = 0;

    /* JADX INFO: renamed from: b */
    private static C1674f f4765b = new C1674f();

    /* JADX INFO: renamed from: c */
    private static C1671c f4766c = new C1671c();

    /* JADX INFO: renamed from: d */
    private static boolean f4767d = C1675g.m3843b("slf4j.detectLoggerNameMismatch");

    /* JADX INFO: renamed from: e */
    private static final String[] f4768e = {"1.6", "1.7"};

    /* JADX INFO: renamed from: f */
    private static String f4769f = "org/slf4j/impl/StaticLoggerBinder.class";

    private C1677c() {
    }

    /* JADX INFO: renamed from: a */
    public static InterfaceC1668b m3845a(Class cls) {
        Class clsM3839a;
        InterfaceC1668b interfaceC1668bM3846a = m3846a(cls.getName());
        if (f4767d && (clsM3839a = C1675g.m3839a()) != null) {
            if (!clsM3839a.isAssignableFrom(cls)) {
                C1675g.m3844c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", interfaceC1668bM3846a.mo3813a(), clsM3839a.getName()));
                C1675g.m3844c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return interfaceC1668bM3846a;
    }

    /* JADX INFO: renamed from: a */
    private static InterfaceC1668b m3846a(String str) {
        return m3853e().mo3811a(str);
    }

    /* JADX INFO: renamed from: a */
    private static void m3847a() {
        synchronized (f4765b) {
            f4765b.m3837c();
            for (C1673e c1673e : f4765b.m3835a()) {
                c1673e.m3831a(m3846a(c1673e.mo3813a()));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3848a(Throwable th) {
        f4764a = 2;
        C1675g.m3841a("Failed to instantiate SLF4J LoggerFactory", th);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3849a(Set set) {
        return set.size() > 1;
    }

    /* JADX INFO: renamed from: b */
    private static void m3850b() {
        LinkedBlockingQueue linkedBlockingQueueM3836b = f4765b.m3836b();
        int size = linkedBlockingQueueM3836b.size();
        int i = 0;
        ArrayList<C1667d> arrayList = new ArrayList(128);
        while (linkedBlockingQueueM3836b.drainTo(arrayList, 128) != 0) {
            int i2 = i;
            for (C1667d c1667d : arrayList) {
                if (c1667d != null) {
                    C1673e c1673eM3828a = c1667d.m3828a();
                    String strMo3813a = c1673eM3828a.mo3813a();
                    if (c1673eM3828a.m3833c()) {
                        throw new IllegalStateException("Delegate logger cannot be null at this state.");
                    }
                    if (!c1673eM3828a.m3834d()) {
                        if (c1673eM3828a.m3832b()) {
                            c1673eM3828a.m3830a(c1667d);
                        } else {
                            C1675g.m3844c(strMo3813a);
                        }
                    }
                }
                int i3 = i2 + 1;
                if (i2 == 0) {
                    if (c1667d.m3828a().m3832b()) {
                        C1675g.m3844c("A number (" + size + ") of logging calls during the initialization phase have been intercepted and are");
                        C1675g.m3844c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        C1675g.m3844c("See also http://www.slf4j.org/codes.html#replay");
                        i2 = i3;
                    } else if (!c1667d.m3828a().m3834d()) {
                        C1675g.m3844c("The following set of substitute loggers may have been accessed");
                        C1675g.m3844c("during the initialization phase. Logging calls during this");
                        C1675g.m3844c("phase were not honored. However, subsequent logging calls to these");
                        C1675g.m3844c("loggers will work as normally expected.");
                        C1675g.m3844c("See also http://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i2 = i3;
            }
            arrayList.clear();
            i = i2;
        }
    }

    /* JADX INFO: renamed from: c */
    private static final void m3851c() {
        boolean z = false;
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            String[] strArr = f4768e;
            for (int i = 0; i < 2; i++) {
                if (str.startsWith(strArr[i])) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            C1675g.m3844c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f4768e).toString());
            C1675g.m3844c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError e) {
        } catch (Throwable th) {
            C1675g.m3841a("Unexpected problem occured during version sanity check", th);
        }
    }

    /* JADX INFO: renamed from: d */
    private static Set m3852d() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = C1677c.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(f4769f) : classLoader.getResources(f4769f);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e) {
            C1675g.m3841a("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    /* JADX INFO: renamed from: e */
    private static InterfaceC1663a m3853e() {
        boolean zContains;
        boolean z = true;
        if (f4764a == 0) {
            synchronized (C1677c.class) {
                if (f4764a == 0) {
                    f4764a = 1;
                    Set set = null;
                    if ("http://www.android.com/" == 0) {
                        zContains = false;
                    } else {
                        try {
                            try {
                                zContains = "http://www.android.com/".toLowerCase().contains("android");
                            } catch (NoClassDefFoundError e) {
                                String message = e.getMessage();
                                if (message == null || (!message.contains("org/slf4j/impl/StaticLoggerBinder") && !message.contains("org.slf4j.impl.StaticLoggerBinder"))) {
                                    z = false;
                                }
                                if (!z) {
                                    m3848a(e);
                                    throw e;
                                }
                                f4764a = 4;
                                C1675g.m3844c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                                C1675g.m3844c("Defaulting to no-operation (NOP) logger implementation");
                                C1675g.m3844c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                            } catch (NoSuchMethodError e2) {
                                String message2 = e2.getMessage();
                                if (message2 != null && message2.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                                    f4764a = 2;
                                    C1675g.m3844c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                                    C1675g.m3844c("Your binding is version 1.5.5 or earlier.");
                                    C1675g.m3844c("Upgrade your binding to version 1.6.x.");
                                }
                                throw e2;
                            }
                        } catch (Exception e3) {
                            m3848a(e3);
                            throw new IllegalStateException("Unexpected initialization failure", e3);
                        }
                    }
                    if (!zContains) {
                        Set setM3852d = m3852d();
                        if (m3849a(setM3852d)) {
                            C1675g.m3844c("Class path contains multiple SLF4J bindings.");
                            Iterator it = setM3852d.iterator();
                            while (it.hasNext()) {
                                C1675g.m3844c("Found binding in [" + ((URL) it.next()) + "]");
                            }
                            C1675g.m3844c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
                        }
                        set = setM3852d;
                    }
                    StaticLoggerBinder.getSingleton();
                    f4764a = 3;
                    if (set != null && m3849a(set)) {
                        C1675g.m3844c("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
                    }
                    m3847a();
                    m3850b();
                    f4765b.m3838d();
                    if (f4764a == 3) {
                        m3851c();
                    }
                }
            }
        }
        switch (f4764a) {
            case 1:
                return f4765b;
            case 2:
                throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
            case 3:
                return StaticLoggerBinder.getSingleton().getLoggerFactory();
            case 4:
                return f4766c;
            default:
                throw new IllegalStateException("Unreachable code");
        }
    }
}
