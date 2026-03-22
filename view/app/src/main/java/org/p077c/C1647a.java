package org.p077c;

import com.p052d.p053a.InterfaceC0965m;
import java.util.concurrent.ConcurrentHashMap;
import org.p077c.p078a.InterfaceC1648a;
import org.p077c.p084b.AbstractC1660a;

/* JADX INFO: renamed from: org.c.a */
/* JADX INFO: loaded from: classes.dex */
public class C1647a implements InterfaceC0965m {

    /* JADX INFO: renamed from: a */
    private AbstractC1660a f4716a;

    /* JADX INFO: renamed from: b */
    private ConcurrentHashMap f4717b;

    public C1647a(AbstractC1660a abstractC1660a) {
        this(abstractC1660a, true);
    }

    private C1647a(AbstractC1660a abstractC1660a, boolean z) {
        if (abstractC1660a == null) {
            throw new IllegalArgumentException("A strategy can't be null");
        }
        this.f4716a = abstractC1660a;
        this.f4717b = new ConcurrentHashMap();
    }

    @Override // com.p052d.p053a.InterfaceC0965m
    /* JADX INFO: renamed from: a */
    public final Object mo2113a(Class cls) {
        InterfaceC1648a interfaceC1648aMo3807a;
        if (this.f4717b == null) {
            interfaceC1648aMo3807a = this.f4716a.mo3807a(cls);
        } else {
            interfaceC1648aMo3807a = (InterfaceC1648a) this.f4717b.get(cls.getName());
            if (interfaceC1648aMo3807a == null) {
                InterfaceC1648a interfaceC1648aMo3807a2 = this.f4716a.mo3807a(cls);
                interfaceC1648aMo3807a = (InterfaceC1648a) this.f4717b.putIfAbsent(cls.getName(), interfaceC1648aMo3807a2);
                if (interfaceC1648aMo3807a == null) {
                    interfaceC1648aMo3807a = interfaceC1648aMo3807a2;
                }
            }
        }
        return interfaceC1648aMo3807a.mo3796a();
    }

    public String toString() {
        return getClass().getName() + " using " + this.f4716a.getClass().getName() + (this.f4717b == null ? " without" : " with") + " caching";
    }
}
