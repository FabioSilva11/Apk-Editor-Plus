package org.p085d.p087b;

/* JADX INFO: renamed from: org.d.b.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1675g {

    /* JADX INFO: renamed from: a */
    private static C1676h f4762a;

    /* JADX INFO: renamed from: b */
    private static boolean f4763b = false;

    private C1675g() {
    }

    /* JADX INFO: renamed from: a */
    public static Class m3839a() {
        C1676h c1676h;
        if (f4762a != null) {
            c1676h = f4762a;
        } else if (f4763b) {
            c1676h = null;
        } else {
            f4762a = m3842b();
            f4763b = true;
            c1676h = f4762a;
        }
        if (c1676h == null) {
            return null;
        }
        Class[] classContext = c1676h.getClassContext();
        String name = C1675g.class.getName();
        int i = 0;
        while (i < classContext.length && !name.equals(classContext[i].getName())) {
            i++;
        }
        if (i >= classContext.length || i + 2 >= classContext.length) {
            throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        }
        return classContext[i + 2];
    }

    /* JADX INFO: renamed from: a */
    public static String m3840a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        try {
            return System.getProperty(str);
        } catch (SecurityException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m3841a(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    /* JADX INFO: renamed from: b */
    private static C1676h m3842b() {
        try {
            return new C1676h((byte) 0);
        } catch (SecurityException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m3843b(String str) {
        String strM3840a = m3840a(str);
        if (strM3840a == null) {
            return false;
        }
        return strM3840a.equalsIgnoreCase("true");
    }

    /* JADX INFO: renamed from: c */
    public static final void m3844c(String str) {
        System.err.println("SLF4J: " + str);
    }
}
