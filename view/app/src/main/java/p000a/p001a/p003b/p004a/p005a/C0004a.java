package p000a.p001a.p003b.p004a.p005a;

import java.util.Arrays;
import org.xmlpull.v1.XmlSerializer;
import p000a.p001a.p003b.p004a.C0033g;
import p000a.p001a.p003b.p008d.InterfaceC0059a;
import p000a.p011d.C0073e;

/* JADX INFO: renamed from: a.a.b.a.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0004a extends C0006c implements InterfaceC0059a {

    /* JADX INFO: renamed from: b */
    private final AbstractC0023t[] f2b;

    /* JADX INFO: renamed from: c */
    private final String[] f3c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0004a(C0022s c0022s, C0073e[] c0073eArr) {
        super(c0022s);
        int i = 0;
        this.f3c = new String[]{"string", "integer"};
        this.f2b = new AbstractC0023t[c0073eArr.length];
        while (true) {
            int i2 = i;
            if (i2 >= c0073eArr.length) {
                return;
            }
            this.f2b[i2] = (AbstractC0023t) c0073eArr[i2].f191b;
            i = i2 + 1;
        }
    }

    @Override // p000a.p001a.p003b.p004a.p005a.C0006c, p000a.p001a.p003b.p008d.InterfaceC0059a
    /* JADX INFO: renamed from: a */
    public final void mo1a(XmlSerializer xmlSerializer, C0033g c0033g) {
        String str;
        if (this.f2b.length != 0) {
            String strM20k = this.f2b[0].m20k();
            int i = 0;
            while (true) {
                if (i < this.f2b.length) {
                    if (this.f2b[i].mo16g().startsWith("@string")) {
                        str = "string";
                        break;
                    }
                    if (this.f2b[i].mo16g().startsWith("@drawable")) {
                        str = null;
                        break;
                    }
                    if (this.f2b[i].mo16g().startsWith("@integer")) {
                        str = "integer";
                        break;
                    }
                    if (!"string".equals(strM20k) && !"integer".equals(strM20k)) {
                        str = null;
                        break;
                    } else {
                        if (!strM20k.equals(this.f2b[i].m20k())) {
                            str = null;
                            break;
                        }
                        i++;
                    }
                } else {
                    str = !Arrays.asList(this.f3c).contains(strM20k) ? "string" : strM20k;
                }
            }
        } else {
            str = null;
        }
        String str2 = (str == null ? "" : str + "-") + "array";
        xmlSerializer.startTag(null, str2);
        xmlSerializer.attribute(null, "name", c0033g.m74c().m67f());
        int i2 = 0;
        while (true) {
            if (i2 >= this.f2b.length) {
                break;
            }
            if (this.f2b[i2].m19j()) {
                xmlSerializer.attribute(null, "formatted", "false");
                break;
            }
            i2++;
        }
        for (int i3 = 0; i3 < this.f2b.length; i3++) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.text(this.f2b[i3].m18i());
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, str2);
    }
}
