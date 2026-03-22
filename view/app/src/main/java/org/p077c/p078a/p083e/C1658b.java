package org.p077c.p078a.p083e;

import com.p016a.p019b.p026b.C0532b;
import java.lang.reflect.Field;
import org.p077c.p078a.InterfaceC1648a;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: org.c.a.e.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1658b implements InterfaceC1648a {

    /* JADX INFO: renamed from: a */
    private static Unsafe f4734a;

    /* JADX INFO: renamed from: b */
    private final Class f4735b;

    public C1658b(Class cls) {
        if (f4734a == null) {
            try {
                Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                try {
                    f4734a = (Unsafe) declaredField.get(null);
                } catch (IllegalAccessException e) {
                    throw new C0532b(e);
                }
            } catch (NoSuchFieldException e2) {
                throw new C0532b(e2);
            }
        }
        this.f4735b = cls;
    }

    @Override // org.p077c.p078a.InterfaceC1648a
    /* JADX INFO: renamed from: a */
    public final Object mo3796a() {
        try {
            return this.f4735b.cast(f4734a.allocateInstance(this.f4735b));
        } catch (InstantiationException e) {
            throw new C0532b(e);
        }
    }
}
