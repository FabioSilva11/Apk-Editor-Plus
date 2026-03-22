package p000a.p001a.p003b.p004a.p005a;

import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;
import p000a.p001a.C0000a;
import p000a.p001a.p003b.p004a.C0033g;
import p000a.p001a.p003b.p008d.InterfaceC0059a;

/* JADX INFO: renamed from: a.a.b.a.a.t */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0023t extends C0019p implements InterfaceC0059a {

    /* JADX INFO: renamed from: a */
    private String f27a;

    /* JADX INFO: renamed from: b */
    protected String f28b;

    /* JADX INFO: renamed from: c */
    private String f29c;

    /* JADX INFO: renamed from: d */
    private boolean f30d;

    protected AbstractC0023t(String str, int i, String str2) {
        super(i);
        this.f30d = false;
        this.f27a = str;
        this.f28b = str2;
    }

    protected AbstractC0023t(String str, int i, String str2, String str3, boolean z) {
        super(i);
        this.f30d = false;
        this.f27a = str;
        this.f28b = str2;
        this.f29c = str3;
        this.f30d = z;
    }

    /* JADX INFO: renamed from: a */
    protected abstract String mo5a();

    /* JADX INFO: renamed from: a */
    protected void mo14a(XmlSerializer xmlSerializer) {
    }

    @Override // p000a.p001a.p003b.p008d.InterfaceC0059a
    /* JADX INFO: renamed from: a */
    public final void mo1a(XmlSerializer xmlSerializer, C0033g c0033g) throws IOException {
        String strM80a = c0033g.m74c().m69h().m80a();
        boolean z = ("reference".equals(this.f27a) || strM80a.equals(this.f27a)) ? false : true;
        String strMo17h = mo17h();
        boolean z2 = (strM80a.equalsIgnoreCase("color") || !strMo17h.contains("@") || c0033g.m71a().contains("string")) ? z : true;
        String str = z2 ? "item" : strM80a;
        xmlSerializer.startTag(null, str);
        if (z2) {
            xmlSerializer.attribute(null, "type", strM80a);
        }
        xmlSerializer.attribute(null, "name", c0033g.m74c().m67f());
        mo14a(xmlSerializer);
        if (!strMo17h.isEmpty()) {
            xmlSerializer.ignorableWhitespace(strMo17h);
        }
        xmlSerializer.endTag(null, str);
    }

    /* JADX INFO: renamed from: f */
    public String mo15f() {
        return this.f28b != null ? this.f28b : mo5a();
    }

    /* JADX INFO: renamed from: g */
    public String mo16g() {
        return mo17h();
    }

    /* JADX INFO: renamed from: h */
    public String mo17h() {
        return this.f28b != null ? this.f28b : mo5a();
    }

    /* JADX INFO: renamed from: i */
    public final String m18i() {
        return mo17h().replace("&amp;", "&").replace("&lt;", "<");
    }

    /* JADX INFO: renamed from: j */
    public final boolean m19j() {
        return C0985a.m2266d(this.f28b);
    }

    /* JADX INFO: renamed from: k */
    public final String m20k() {
        return this.f27a;
    }

    /* JADX INFO: renamed from: l */
    public final String m21l() {
        return this.f28b;
    }

    /* JADX INFO: renamed from: m */
    public final String m22m() {
        return this.f29c;
    }

    /* JADX INFO: renamed from: n */
    public final boolean m23n() {
        return this.f30d;
    }

    public String toString() {
        try {
            return mo17h();
        } catch (C0000a e) {
            return null;
        }
    }
}
