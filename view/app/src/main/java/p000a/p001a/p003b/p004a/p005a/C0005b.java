package p000a.p001a.p003b.p004a.p005a;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;
import p000a.p001a.C0000a;
import p000a.p001a.p003b.p004a.C0031e;
import p000a.p001a.p003b.p004a.C0033g;
import p000a.p001a.p003b.p008d.InterfaceC0059a;
import p000a.p011d.C0073e;

/* JADX INFO: renamed from: a.a.b.a.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0005b extends C0006c implements InterfaceC0059a {

    /* JADX INFO: renamed from: b */
    private final int f4b;

    /* JADX INFO: renamed from: c */
    private final Integer f5c;

    /* JADX INFO: renamed from: d */
    private final Integer f6d;

    /* JADX INFO: renamed from: e */
    private final Boolean f7e;

    C0005b(C0022s c0022s, int i, Integer num, Integer num2, Boolean bool) {
        super(c0022s);
        this.f4b = i;
        this.f5c = num;
        this.f6d = num2;
        this.f7e = bool;
    }

    /* JADX INFO: renamed from: a */
    public static C0005b m2a(C0022s c0022s, C0073e[] c0073eArr, C0027x c0027x, C0031e c0031e) throws C0000a {
        int i;
        int iM11b = ((C0020q) c0073eArr[0].f191b).m11b();
        int i2 = iM11b & SupportMenu.USER_MASK;
        Integer numValueOf = null;
        Integer numValueOf2 = null;
        Boolean boolValueOf = null;
        int i3 = 1;
        while (true) {
            i = i3;
            if (i < c0073eArr.length) {
                switch (((Integer) c0073eArr[i].f190a).intValue()) {
                    case 16777217:
                        numValueOf = Integer.valueOf(((C0020q) c0073eArr[i].f191b).m11b());
                        continue;
                        i3 = i + 1;
                        break;
                    case 16777218:
                        numValueOf2 = Integer.valueOf(((C0020q) c0073eArr[i].f191b).m11b());
                        continue;
                        i3 = i + 1;
                        break;
                    case 16777219:
                        boolValueOf = Boolean.valueOf(((C0020q) c0073eArr[i].f191b).m11b() != 0);
                        continue;
                        i3 = i + 1;
                        break;
                }
            }
        }
        if (i == c0073eArr.length) {
            return new C0005b(c0022s, i2, numValueOf, numValueOf2, boolValueOf);
        }
        C0073e[] c0073eArr2 = new C0073e[c0073eArr.length - i];
        int i4 = i;
        int i5 = 0;
        while (i4 < c0073eArr.length) {
            int iIntValue = ((Integer) c0073eArr[i4].f190a).intValue();
            c0031e.m45a(iIntValue);
            c0073eArr2[i5] = new C0073e(c0027x.m38a(iIntValue, (String) null), (C0020q) c0073eArr[i4].f191b);
            i4++;
            i5++;
        }
        switch (16711680 & iM11b) {
            case 65536:
                return new C0011h(c0022s, i2, numValueOf, numValueOf2, boolValueOf, c0073eArr2);
            case 131072:
                return new C0013j(c0022s, i2, numValueOf, numValueOf2, boolValueOf, c0073eArr2);
            default:
                throw new C0000a("Could not decode attr value");
        }
    }

    /* JADX INFO: renamed from: a */
    public String mo3a(AbstractC0023t abstractC0023t) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    protected void mo4a(XmlSerializer xmlSerializer) {
    }

    @Override // p000a.p001a.p003b.p004a.p005a.C0006c, p000a.p001a.p003b.p008d.InterfaceC0059a
    /* JADX INFO: renamed from: a */
    public final void mo1a(XmlSerializer xmlSerializer, C0033g c0033g) throws IOException {
        String str = (this.f4b & 1) != 0 ? "|reference" : "";
        if ((this.f4b & 2) != 0) {
            str = str + "|string";
        }
        if ((this.f4b & 4) != 0) {
            str = str + "|integer";
        }
        if ((this.f4b & 8) != 0) {
            str = str + "|boolean";
        }
        if ((this.f4b & 16) != 0) {
            str = str + "|color";
        }
        if ((this.f4b & 32) != 0) {
            str = str + "|float";
        }
        if ((this.f4b & 64) != 0) {
            str = str + "|dimension";
        }
        if ((this.f4b & 128) != 0) {
            str = str + "|fraction";
        }
        String strSubstring = str.isEmpty() ? null : str.substring(1);
        xmlSerializer.startTag(null, "attr");
        xmlSerializer.attribute(null, "name", c0033g.m74c().m67f());
        if (strSubstring != null) {
            xmlSerializer.attribute(null, "format", strSubstring);
        }
        if (this.f5c != null) {
            xmlSerializer.attribute(null, "min", this.f5c.toString());
        }
        if (this.f6d != null) {
            xmlSerializer.attribute(null, "max", this.f6d.toString());
        }
        if (this.f7e != null && this.f7e.booleanValue()) {
            xmlSerializer.attribute(null, "localization", "suggested");
        }
        mo4a(xmlSerializer);
        xmlSerializer.endTag(null, "attr");
    }
}
