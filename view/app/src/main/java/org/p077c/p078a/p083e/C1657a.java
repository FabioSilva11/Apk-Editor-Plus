package org.p077c.p078a.p083e;

import com.p016a.p019b.p026b.C0532b;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.p077c.p078a.InterfaceC1648a;

/* JADX INFO: renamed from: org.c.a.e.a */
/* JADX INFO: loaded from: classes.dex */
public class C1657a implements InterfaceC1648a {

    /* JADX INFO: renamed from: a */
    private final Constructor f4733a;

    public C1657a(Class cls) {
        this.f4733a = m3803a(cls, m3806c());
        this.f4733a.setAccessible(true);
    }

    /* JADX INFO: renamed from: a */
    private static Object m3802a(Class cls) {
        try {
            return cls.getDeclaredMethod("getReflectionFactory", new Class[0]).invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new C0532b(e);
        } catch (IllegalArgumentException e2) {
            throw new C0532b(e2);
        } catch (NoSuchMethodException e3) {
            throw new C0532b(e3);
        } catch (InvocationTargetException e4) {
            throw new C0532b(e4);
        }
    }

    /* JADX INFO: renamed from: a */
    public static Constructor m3803a(Class cls, Constructor constructor) {
        Class clsM3804b = m3804b();
        try {
            return (Constructor) m3805b(clsM3804b).invoke(m3802a(clsM3804b), cls, constructor);
        } catch (IllegalAccessException e) {
            throw new C0532b(e);
        } catch (IllegalArgumentException e2) {
            throw new C0532b(e2);
        } catch (InvocationTargetException e3) {
            throw new C0532b(e3);
        }
    }

    /* JADX INFO: renamed from: b */
    private static Class m3804b() {
        try {
            return Class.forName("sun.reflect.ReflectionFactory");
        } catch (ClassNotFoundException e) {
            throw new C0532b(e);
        }
    }

    /* JADX INFO: renamed from: b */
    private static Method m3805b(Class cls) {
        try {
            return cls.getDeclaredMethod("newConstructorForSerialization", Class.class, Constructor.class);
        } catch (NoSuchMethodException e) {
            throw new C0532b(e);
        }
    }

    /* JADX INFO: renamed from: c */
    private static Constructor m3806c() {
        try {
            return Object.class.getConstructor(null);
        } catch (NoSuchMethodException e) {
            throw new C0532b(e);
        }
    }

    @Override // org.p077c.p078a.InterfaceC1648a
    /* JADX INFO: renamed from: a */
    public Object mo3796a() {
        try {
            return this.f4733a.newInstance(null);
        } catch (Exception e) {
            throw new C0532b(e);
        }
    }
}
