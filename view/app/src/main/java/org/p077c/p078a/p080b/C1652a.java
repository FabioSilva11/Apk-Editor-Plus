package org.p077c.p078a.p080b;

import com.p016a.p019b.p026b.C0532b;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: org.c.a.b.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1652a extends AbstractC1653b {
    public C1652a(Class cls) {
        super(cls);
    }

    @Override // org.p077c.p078a.InterfaceC1648a
    /* JADX INFO: renamed from: a */
    public final Object mo3796a() {
        try {
            return this.f4728c.cast(f4726a.invoke(f4727b, this.f4728c, Object.class));
        } catch (IllegalAccessException e) {
            throw new C0532b(e);
        } catch (RuntimeException e2) {
            throw new C0532b(e2);
        } catch (InvocationTargetException e3) {
            throw new C0532b(e3);
        }
    }
}
