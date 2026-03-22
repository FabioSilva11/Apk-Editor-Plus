package org.p077c.p078a.p081c;

import com.p016a.p019b.p026b.C0532b;
import java.lang.reflect.Method;
import org.p077c.p078a.InterfaceC1648a;

/* JADX INFO: renamed from: org.c.a.c.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1655a implements InterfaceC1648a {

    /* JADX INFO: renamed from: a */
    private static Method f4729a = null;

    /* JADX INFO: renamed from: b */
    private final Class f4730b;

    public C1655a(Class cls) {
        if (f4729a == null) {
            try {
                Method declaredMethod = Class.forName("jrockit.vm.MemSystem").getDeclaredMethod("safeAllocObject", Class.class);
                f4729a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (ClassNotFoundException e) {
                throw new C0532b(e);
            } catch (NoSuchMethodException e2) {
                throw new C0532b(e2);
            } catch (RuntimeException e3) {
                throw new C0532b(e3);
            }
        }
        this.f4730b = cls;
    }

    @Override // org.p077c.p078a.InterfaceC1648a
    /* JADX INFO: renamed from: a */
    public final Object mo3796a() {
        try {
            return this.f4730b.cast(f4729a.invoke(null, this.f4730b));
        } catch (Exception e) {
            throw new C0532b(e);
        }
    }
}
