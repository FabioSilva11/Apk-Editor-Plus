package org.p077c.p078a.p080b;

import com.p016a.p019b.p026b.C0532b;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.p077c.p078a.InterfaceC1648a;

/* JADX INFO: renamed from: org.c.a.b.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1653b implements InterfaceC1648a {

    /* JADX INFO: renamed from: a */
    static Method f4726a = null;

    /* JADX INFO: renamed from: b */
    static ObjectInputStream f4727b;

    /* JADX INFO: renamed from: c */
    protected final Class f4728c;

    public AbstractC1653b(Class cls) {
        this.f4728c = cls;
        if (f4726a == null) {
            try {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newObject", Class.class, Class.class);
                f4726a = declaredMethod;
                declaredMethod.setAccessible(true);
                f4727b = new C1654c();
            } catch (IOException e) {
                throw new C0532b(e);
            } catch (NoSuchMethodException e2) {
                throw new C0532b(e2);
            } catch (RuntimeException e3) {
                throw new C0532b(e3);
            }
        }
    }
}
