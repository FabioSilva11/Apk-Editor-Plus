package org.p077c.p084b;

import com.p016a.p019b.p026b.C0532b;

/* JADX INFO: renamed from: org.c.b.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1661b {

    /* JADX INFO: renamed from: a */
    public static final String f4736a;

    /* JADX INFO: renamed from: b */
    public static final String f4737b;

    /* JADX INFO: renamed from: c */
    public static final String f4738c;

    /* JADX INFO: renamed from: d */
    public static final int f4739d;

    /* JADX INFO: renamed from: e */
    private static String f4740e;

    static {
        System.getProperty("java.specification.version");
        f4736a = System.getProperty("java.runtime.version");
        f4737b = System.getProperty("java.vm.info");
        f4738c = System.getProperty("java.vm.version");
        System.getProperty("java.vm.vendor");
        f4740e = System.getProperty("java.vm.name");
        f4739d = !f4740e.startsWith("Dalvik") ? 0 : m3808a();
    }

    /* JADX INFO: renamed from: a */
    private static int m3808a() {
        try {
            Class<?> cls = Class.forName("android.os.Build$VERSION");
            try {
                try {
                    return ((Integer) cls.getField("SDK_INT").get(null)).intValue();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            } catch (NoSuchFieldException e2) {
                return m3809a(cls);
            }
        } catch (ClassNotFoundException e3) {
            throw new C0532b(e3);
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m3809a(Class cls) {
        try {
            try {
                return Integer.parseInt((String) cls.getField("SDK").get(null));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchFieldException e2) {
            throw new C0532b(e2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3810a(String str) {
        return f4740e.startsWith(str);
    }
}
