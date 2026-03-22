package p000a.p001a.p003b.p004a.p005a;

import java.io.IOException;
import java.io.Serializable;
import org.xmlpull.v1.XmlSerializer;
import p000a.p001a.p003b.p004a.C0033g;
import p000a.p001a.p003b.p008d.InterfaceC0059a;

/* JADX INFO: renamed from: a.a.b.a.a.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0018o extends C0026w implements InterfaceC0059a, Serializable {
    @Override // p000a.p001a.p003b.p008d.InterfaceC0059a
    /* JADX INFO: renamed from: a */
    public final void mo1a(XmlSerializer xmlSerializer, C0033g c0033g) throws IOException {
        xmlSerializer.startTag(null, "item");
        xmlSerializer.attribute(null, "type", c0033g.m74c().m69h().m80a());
        xmlSerializer.attribute(null, "name", c0033g.m74c().m67f());
        xmlSerializer.endTag(null, "item");
    }
}
