package org.p077c.p078a.p079a;

import com.p016a.p019b.p026b.C0532b;
import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.p077c.p078a.InterfaceC1648a;

/* JADX INFO: renamed from: org.c.a.a.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1651c implements InterfaceC1648a {

    /* JADX INFO: renamed from: a */
    private final Class f4723a;

    /* JADX INFO: renamed from: b */
    private final Method f4724b = m3800b();

    /* JADX INFO: renamed from: c */
    private final Long f4725c = m3801c();

    public C1651c(Class cls) {
        this.f4723a = cls;
    }

    /* JADX INFO: renamed from: b */
    private static Method m3800b() {
        try {
            Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Long.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException e) {
            throw new C0532b(e);
        } catch (RuntimeException e2) {
            throw new C0532b(e2);
        }
    }

    /* JADX INFO: renamed from: c */
    private static Long m3801c() {
        try {
            Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod.setAccessible(true);
            return (Long) declaredMethod.invoke(null, Object.class);
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
            return this.f4723a.cast(this.f4724b.invoke(null, this.f4723a, this.f4725c));
        } catch (Exception e) {
            throw new C0532b(e);
        }
    }
}
