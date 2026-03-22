package org.p077c.p078a.p079a;

import com.p016a.p019b.p026b.C0532b;
import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.p077c.p078a.InterfaceC1648a;

/* JADX INFO: renamed from: org.c.a.a.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1650b implements InterfaceC1648a {

    /* JADX INFO: renamed from: a */
    private final Class f4720a;

    /* JADX INFO: renamed from: b */
    private final Method f4721b = m3798b();

    /* JADX INFO: renamed from: c */
    private final Integer f4722c = m3799c();

    public C1650b(Class cls) {
        this.f4720a = cls;
    }

    /* JADX INFO: renamed from: b */
    private static Method m3798b() {
        try {
            Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException e) {
            throw new C0532b(e);
        } catch (RuntimeException e2) {
            throw new C0532b(e2);
        }
    }

    /* JADX INFO: renamed from: c */
    private static Integer m3799c() {
        try {
            Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod.setAccessible(true);
            return (Integer) declaredMethod.invoke(null, Object.class);
        } catch (IllegalAccessException e) {
            throw new C0532b(e);
        } catch (NoSuchMethodException e2) {
            throw new C0532b(e2);
        } catch (RuntimeException e3) {
            throw new C0532b(e3);
        } catch (InvocationTargetException e4) {
            throw new C0532b(e4);
        }
    }

    @Override // org.p077c.p078a.InterfaceC1648a
    /* JADX INFO: renamed from: a */
    public final Object mo3796a() {
        try {
            return this.f4720a.cast(this.f4721b.invoke(null, this.f4720a, this.f4722c));
        } catch (Exception e) {
            throw new C0532b(e);
        }
    }
}
