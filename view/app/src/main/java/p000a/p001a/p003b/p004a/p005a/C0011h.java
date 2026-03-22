package p000a.p001a.p003b.p004a.p005a;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;
import p000a.p011d.C0073e;

/* JADX INFO: renamed from: a.a.b.a.a.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0011h extends C0005b {

    /* JADX INFO: renamed from: b */
    private final C0073e[] f10b;

    /* JADX INFO: renamed from: c */
    private final Map f11c;

    C0011h(C0022s c0022s, int i, Integer num, Integer num2, Boolean bool, C0073e[] c0073eArr) {
        super(c0022s, i, num, num2, bool);
        this.f11c = new HashMap();
        this.f10b = c0073eArr;
    }

    @Override // p000a.p001a.p003b.p004a.p005a.C0005b
    /* JADX INFO: renamed from: a */
    public final String mo3a(AbstractC0023t abstractC0023t) {
        C0022s c0022s;
        if (abstractC0023t instanceof C0020q) {
            int iM11b = ((C0020q) abstractC0023t).m11b();
            String strM67f = (String) this.f11c.get(Integer.valueOf(iM11b));
            if (strM67f == null) {
                C0073e[] c0073eArr = this.f10b;
                int length = c0073eArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        c0022s = null;
                        break;
                    }
                    C0073e c0073e = c0073eArr[i];
                    if (((C0020q) c0073e.f191b).m11b() == iM11b) {
                        c0022s = (C0022s) c0073e.f190a;
                        break;
                    }
                    i++;
                }
                if (c0022s != null) {
                    strM67f = c0022s.m12d().m67f();
                    this.f11c.put(Integer.valueOf(iM11b), strM67f);
                }
            }
            if (strM67f != null) {
                return strM67f;
            }
        }
        return super.mo3a(abstractC0023t);
    }

    @Override // p000a.p001a.p003b.p004a.p005a.C0005b
    /* JADX INFO: renamed from: a */
    protected final void mo4a(XmlSerializer xmlSerializer) throws IOException {
        for (C0073e c0073e : this.f10b) {
            int iM11b = ((C0020q) c0073e.f191b).m11b();
            xmlSerializer.startTag(null, "enum");
            xmlSerializer.attribute(null, "name", ((C0022s) c0073e.f190a).m12d().m67f());
            xmlSerializer.attribute(null, "value", String.valueOf(iM11b));
            xmlSerializer.endTag(null, "enum");
        }
    }
}
