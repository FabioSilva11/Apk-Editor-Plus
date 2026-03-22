package org.p085d.p087b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.p085d.InterfaceC1668b;
import org.p085d.p086a.C1664a;
import org.p085d.p086a.InterfaceC1666c;

/* JADX INFO: renamed from: org.d.b.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1673e implements InterfaceC1668b {

    /* JADX INFO: renamed from: a */
    private final String f4752a;

    /* JADX INFO: renamed from: b */
    private volatile InterfaceC1668b f4753b;

    /* JADX INFO: renamed from: c */
    private Boolean f4754c;

    /* JADX INFO: renamed from: d */
    private Method f4755d;

    /* JADX INFO: renamed from: e */
    private C1664a f4756e;

    /* JADX INFO: renamed from: f */
    private Queue f4757f;

    /* JADX INFO: renamed from: g */
    private final boolean f4758g;

    public C1673e(String str, Queue queue, boolean z) {
        this.f4752a = str;
        this.f4757f = queue;
        this.f4758g = z;
    }

    /* JADX INFO: renamed from: e */
    private InterfaceC1668b m3829e() {
        if (this.f4753b != null) {
            return this.f4753b;
        }
        if (this.f4758g) {
            return C1670b.f4751a;
        }
        if (this.f4756e == null) {
            this.f4756e = new C1664a(this, this.f4757f);
        }
        return this.f4756e;
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: a */
    public final String mo3813a() {
        return this.f4752a;
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: a */
    public final void mo3814a(String str) {
        m3829e().mo3814a(str);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: a */
    public final void mo3815a(String str, Object obj) {
        m3829e().mo3815a(str, obj);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: a */
    public final void mo3816a(String str, Object obj, Object obj2) {
        m3829e().mo3816a(str, obj, obj2);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: a */
    public final void mo3817a(String str, Throwable th) {
        m3829e().mo3817a(str, th);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: a */
    public final void mo3818a(String str, Object... objArr) {
        m3829e().mo3818a(str, objArr);
    }

    /* JADX INFO: renamed from: a */
    public final void m3830a(InterfaceC1666c interfaceC1666c) {
        if (m3832b()) {
            try {
                this.f4755d.invoke(this.f4753b, interfaceC1666c);
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e2) {
            } catch (InvocationTargetException e3) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3831a(InterfaceC1668b interfaceC1668b) {
        this.f4753b = interfaceC1668b;
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: b */
    public final void mo3819b(String str) {
        m3829e().mo3819b(str);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: b */
    public final void mo3820b(String str, Object obj) {
        m3829e().mo3820b(str, obj);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: b */
    public final void mo3821b(String str, Object obj, Object obj2) {
        m3829e().mo3821b(str, obj, obj2);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: b */
    public final void mo3822b(String str, Throwable th) {
        m3829e().mo3822b(str, th);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: b */
    public final void mo3823b(String str, Object... objArr) {
        m3829e().mo3823b(str, objArr);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3832b() {
        if (this.f4754c != null) {
            return this.f4754c.booleanValue();
        }
        try {
            this.f4755d = this.f4753b.getClass().getMethod("log", InterfaceC1666c.class);
            this.f4754c = Boolean.TRUE;
        } catch (NoSuchMethodException e) {
            this.f4754c = Boolean.FALSE;
        }
        return this.f4754c.booleanValue();
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: c */
    public final void mo3824c(String str) {
        m3829e().mo3824c(str);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: c */
    public final void mo3825c(String str, Object obj) {
        m3829e().mo3825c(str, obj);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: c */
    public final void mo3826c(String str, Object obj, Object obj2) {
        m3829e().mo3826c(str, obj, obj2);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m3833c() {
        return this.f4753b == null;
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: d */
    public final void mo3827d(String str, Object obj) {
        m3829e().mo3827d(str, obj);
    }

    /* JADX INFO: renamed from: d */
    public final boolean m3834d() {
        return this.f4753b instanceof C1670b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f4752a.equals(((C1673e) obj).f4752a);
    }

    public final int hashCode() {
        return this.f4752a.hashCode();
    }
}
