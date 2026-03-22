package org.p085d.p086a;

import java.util.Queue;
import org.p085d.InterfaceC1668b;
import org.p085d.p087b.C1673e;

/* JADX INFO: renamed from: org.d.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1664a implements InterfaceC1668b {

    /* JADX INFO: renamed from: a */
    private String f4741a;

    /* JADX INFO: renamed from: b */
    private C1673e f4742b;

    /* JADX INFO: renamed from: c */
    private Queue f4743c;

    public C1664a(C1673e c1673e, Queue queue) {
        this.f4742b = c1673e;
        this.f4741a = c1673e.mo3813a();
        this.f4743c = queue;
    }

    /* JADX INFO: renamed from: a */
    private void m3812a(EnumC1665b enumC1665b, String str, Object[] objArr, Throwable th) {
        C1667d c1667d = new C1667d();
        System.currentTimeMillis();
        c1667d.f4750a = this.f4742b;
        Thread.currentThread().getName();
        this.f4743c.add(c1667d);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: a */
    public final String mo3813a() {
        return this.f4741a;
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: a */
    public final void mo3814a(String str) {
        m3812a(EnumC1665b.f4746c, str, null, null);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: a */
    public final void mo3815a(String str, Object obj) {
        m3812a(EnumC1665b.f4747d, str, new Object[]{obj}, null);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: a */
    public final void mo3816a(String str, Object obj, Object obj2) {
        m3812a(EnumC1665b.f4747d, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: a */
    public final void mo3817a(String str, Throwable th) {
        m3812a(EnumC1665b.f4747d, str, null, th);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: a */
    public final void mo3818a(String str, Object... objArr) {
        m3812a(EnumC1665b.f4747d, str, objArr, null);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: b */
    public final void mo3819b(String str) {
        m3812a(EnumC1665b.f4745b, str, null, null);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: b */
    public final void mo3820b(String str, Object obj) {
        m3812a(EnumC1665b.f4746c, str, new Object[]{obj}, null);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: b */
    public final void mo3821b(String str, Object obj, Object obj2) {
        m3812a(EnumC1665b.f4745b, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: b */
    public final void mo3822b(String str, Throwable th) {
        m3812a(EnumC1665b.f4744a, str, null, th);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: b */
    public final void mo3823b(String str, Object... objArr) {
        m3812a(EnumC1665b.f4745b, str, objArr, null);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: c */
    public final void mo3824c(String str) {
        m3812a(EnumC1665b.f4744a, str, null, null);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: c */
    public final void mo3825c(String str, Object obj) {
        m3812a(EnumC1665b.f4745b, str, new Object[]{obj}, null);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: c */
    public final void mo3826c(String str, Object obj, Object obj2) {
        m3812a(EnumC1665b.f4744a, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.p085d.InterfaceC1668b
    /* JADX INFO: renamed from: d */
    public final void mo3827d(String str, Object obj) {
        m3812a(EnumC1665b.f4744a, str, new Object[]{obj}, null);
    }
}
