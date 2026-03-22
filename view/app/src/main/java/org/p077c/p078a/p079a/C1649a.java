package org.p077c.p078a.p079a;

import com.p016a.p019b.p026b.C0532b;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.p077c.p078a.InterfaceC1648a;

/* JADX INFO: renamed from: org.c.a.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1649a implements InterfaceC1648a {

    /* JADX INFO: renamed from: a */
    private final Class f4718a;

    /* JADX INFO: renamed from: b */
    private final Method f4719b = m3797b();

    public C1649a(Class cls) {
        this.f4718a = cls;
    }

    /* JADX INFO: renamed from: b */
    private static Method m3797b() {
        try {
            Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException e) {
            throw new C0532b(e);
        } catch (RuntimeException e2) {
            throw new C0532b(e2);
        }
    }

    @Override // org.p077c.p078a.InterfaceC1648a
    /* JADX INFO: renamed from: a */
    public final Object mo3796a() {
        try {
            return this.f4718a.cast(this.f4719b.invoke(null, this.f4718a, Object.class));
        } catch (Exception e) {
            throw new C0532b(e);
        }
    }
}
