package org.p077c.p078a.p082d;

import com.p016a.p019b.p026b.C0532b;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.p077c.p078a.InterfaceC1648a;

/* JADX INFO: renamed from: org.c.a.d.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1656a implements InterfaceC1648a {

    /* JADX INFO: renamed from: a */
    private final Method f4731a;

    /* JADX INFO: renamed from: b */
    private final Object[] f4732b = {null, Boolean.FALSE};

    public C1656a(Class cls) {
        this.f4732b[0] = cls;
        try {
            this.f4731a = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Boolean.TYPE);
            this.f4731a.setAccessible(true);
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
            return this.f4731a.invoke(null, this.f4732b);
        } catch (Exception e) {
            throw new C0532b(e);
        }
    }
}
