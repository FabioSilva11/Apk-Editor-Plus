package androidx.versionedparcelable;

import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: androidx.versionedparcelable.b */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class AbstractC0374b {
    /* JADX INFO: renamed from: a */
    private static InterfaceC0376d m214a(String str, AbstractC0374b abstractC0374b) {
        try {
            return (InterfaceC0376d) Class.forName(str, true, AbstractC0374b.class.getClassLoader()).getDeclaredMethod("read", AbstractC0374b.class).invoke(null, abstractC0374b);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    /* JADX INFO: renamed from: a */
    private static Class m215a(Class cls) {
        return Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo216a();

    /* JADX INFO: renamed from: a */
    protected abstract void mo217a(int i);

    /* JADX INFO: renamed from: a */
    public final void m218a(int i, int i2) {
        mo233c(i2);
        mo217a(i);
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo219a(Parcelable parcelable);

    /* JADX INFO: renamed from: a */
    public final void m220a(Parcelable parcelable, int i) {
        mo233c(i);
        mo219a(parcelable);
    }

    /* JADX INFO: renamed from: a */
    protected final void m221a(InterfaceC0376d interfaceC0376d) {
        if (interfaceC0376d == null) {
            mo222a((String) null);
            return;
        }
        try {
            mo222a(m215a(interfaceC0376d.getClass()).getName());
            AbstractC0374b abstractC0374bMo228b = mo228b();
            try {
                m215a(interfaceC0376d.getClass()).getDeclaredMethod("write", interfaceC0376d.getClass(), AbstractC0374b.class).invoke(null, interfaceC0376d, abstractC0374bMo228b);
                abstractC0374bMo228b.mo216a();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (InvocationTargetException e4) {
                if (!(e4.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
                }
                throw ((RuntimeException) e4.getCause());
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(interfaceC0376d.getClass().getSimpleName() + " does not have a Parcelizer", e5);
        }
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo222a(String str);

    /* JADX INFO: renamed from: a */
    public final void m223a(String str, int i) {
        mo233c(7);
        mo222a(str);
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo224a(byte[] bArr);

    /* JADX INFO: renamed from: a */
    public final void m225a(byte[] bArr, int i) {
        mo233c(2);
        mo224a(bArr);
    }

    /* JADX INFO: renamed from: b */
    public final int m226b(int i, int i2) {
        return !mo230b(i2) ? i : mo232c();
    }

    /* JADX INFO: renamed from: b */
    public final Parcelable m227b(Parcelable parcelable, int i) {
        return !mo230b(i) ? parcelable : mo236f();
    }

    /* JADX INFO: renamed from: b */
    protected abstract AbstractC0374b mo228b();

    /* JADX INFO: renamed from: b */
    public final String m229b(String str, int i) {
        return !mo230b(7) ? str : mo234d();
    }

    /* JADX INFO: renamed from: b */
    protected abstract boolean mo230b(int i);

    /* JADX INFO: renamed from: b */
    public final byte[] m231b(byte[] bArr, int i) {
        return !mo230b(2) ? bArr : mo235e();
    }

    /* JADX INFO: renamed from: c */
    protected abstract int mo232c();

    /* JADX INFO: renamed from: c */
    protected abstract void mo233c(int i);

    /* JADX INFO: renamed from: d */
    protected abstract String mo234d();

    /* JADX INFO: renamed from: e */
    protected abstract byte[] mo235e();

    /* JADX INFO: renamed from: f */
    protected abstract Parcelable mo236f();

    /* JADX INFO: renamed from: g */
    protected final InterfaceC0376d m237g() {
        String strMo234d = mo234d();
        if (strMo234d == null) {
            return null;
        }
        return m214a(strMo234d, mo228b());
    }
}
