package p000a.p001a.p003b.p004a.p005a;

import java.io.IOException;
import java.io.Serializable;
import org.xmlpull.v1.XmlSerializer;
import p000a.p001a.p003b.p004a.C0033g;
import p000a.p001a.p003b.p008d.InterfaceC0059a;
import p000a.p011d.C0073e;

/* JADX INFO: renamed from: a.a.b.a.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0006c extends C0026w implements InterfaceC0059a, Serializable {

    /* JADX INFO: renamed from: a */
    protected final C0022s f8a;

    public C0006c(C0022s c0022s) {
        this.f8a = c0022s;
    }

    /* JADX INFO: renamed from: a */
    public void mo1a(XmlSerializer xmlSerializer, C0033g c0033g) throws IOException {
        String strM80a = c0033g.m74c().m69h().m80a();
        if ("style".equals(strM80a)) {
            new C0025v(this.f8a, new C0073e[0], null).mo1a(xmlSerializer, c0033g);
            return;
        }
        if ("array".equals(strM80a)) {
            new C0004a(this.f8a, new C0073e[0]).mo1a(xmlSerializer, c0033g);
            return;
        }
        if ("plurals".equals(strM80a)) {
            new C0021r(this.f8a, new C0073e[0]).mo1a(xmlSerializer, c0033g);
            return;
        }
        xmlSerializer.startTag(null, "item");
        xmlSerializer.attribute(null, "type", strM80a);
        xmlSerializer.attribute(null, "name", c0033g.m74c().m67f());
        xmlSerializer.endTag(null, "item");
    }
}
