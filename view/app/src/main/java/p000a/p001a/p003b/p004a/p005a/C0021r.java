package p000a.p001a.p003b.p004a.p005a;

import com.gmail.heagoo.p054a.p059c.C0985a;
import org.xmlpull.v1.XmlSerializer;
import p000a.p001a.p003b.p004a.C0033g;
import p000a.p001a.p003b.p008d.InterfaceC0059a;
import p000a.p011d.C0073e;

/* JADX INFO: renamed from: a.a.b.a.a.r */
/* JADX INFO: loaded from: classes.dex */
public final class C0021r extends C0006c implements InterfaceC0059a {

    /* JADX INFO: renamed from: c */
    private static final String[] f23c = {"other", "zero", "one", "two", "few", "many"};

    /* JADX INFO: renamed from: b */
    private final AbstractC0023t[] f24b;

    C0021r(C0022s c0022s, C0073e[] c0073eArr) {
        super(c0022s);
        this.f24b = new AbstractC0023t[6];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c0073eArr.length) {
                return;
            }
            this.f24b[((Integer) c0073eArr[i2].f190a).intValue() - 16777220] = (AbstractC0023t) c0073eArr[i2].f191b;
            i = i2 + 1;
        }
    }

    @Override // p000a.p001a.p003b.p004a.p005a.C0006c, p000a.p001a.p003b.p008d.InterfaceC0059a
    /* JADX INFO: renamed from: a */
    public final void mo1a(XmlSerializer xmlSerializer, C0033g c0033g) {
        xmlSerializer.startTag(null, "plurals");
        xmlSerializer.attribute(null, "name", c0033g.m74c().m67f());
        for (int i = 0; i < 6; i++) {
            AbstractC0023t abstractC0023t = this.f24b[i];
            if (abstractC0023t != null) {
                xmlSerializer.startTag(null, "item");
                xmlSerializer.attribute(null, "quantity", f23c[i]);
                xmlSerializer.text(C0985a.m2269e(abstractC0023t.m18i()));
                xmlSerializer.endTag(null, "item");
            }
        }
        xmlSerializer.endTag(null, "plurals");
    }
}
