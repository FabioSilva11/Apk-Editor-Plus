package org.p077c.p084b;

import org.p077c.p078a.InterfaceC1648a;
import org.p077c.p078a.p079a.C1649a;
import org.p077c.p078a.p079a.C1650b;
import org.p077c.p078a.p079a.C1651c;
import org.p077c.p078a.p080b.C1652a;
import org.p077c.p078a.p081c.C1655a;
import org.p077c.p078a.p082d.C1656a;
import org.p077c.p078a.p083e.C1657a;
import org.p077c.p078a.p083e.C1658b;

/* JADX INFO: renamed from: org.c.b.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1662c extends AbstractC1660a {
    @Override // org.p077c.p084b.AbstractC1660a
    /* JADX INFO: renamed from: a */
    public final InterfaceC1648a mo3807a(Class cls) {
        return (C1661b.m3810a("Java HotSpot") || C1661b.m3810a("OpenJDK")) ? new C1657a(cls) : C1661b.m3810a("BEA") ? (!C1661b.f4736a.startsWith("1.4") || C1661b.f4738c.startsWith("R") || (C1661b.f4737b != null && C1661b.f4737b.startsWith("R25.1") && C1661b.f4737b.startsWith("R25.2"))) ? new C1657a(cls) : new C1655a(cls) : C1661b.m3810a("Dalvik") ? C1661b.f4739d <= 10 ? new C1649a(cls) : C1661b.f4739d <= 17 ? new C1650b(cls) : new C1651c(cls) : C1661b.m3810a("GNU libgcj") ? new C1652a(cls) : C1661b.m3810a("PERC") ? new C1656a(cls) : new C1658b(cls);
    }
}
