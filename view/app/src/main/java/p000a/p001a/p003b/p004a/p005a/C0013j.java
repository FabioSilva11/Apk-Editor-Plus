package p000a.p001a.p003b.p004a.p005a;

import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;
import p000a.p011d.C0073e;

/* JADX INFO: renamed from: a.a.b.a.a.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0013j extends C0005b {

    /* JADX INFO: renamed from: b */
    private final C0015l[] f13b;

    /* JADX INFO: renamed from: c */
    private C0015l[] f14c;

    /* JADX INFO: renamed from: d */
    private C0015l[] f15d;

    C0013j(C0022s c0022s, int i, Integer num, Integer num2, Boolean bool, C0073e[] c0073eArr) {
        super(c0022s, i, num, num2, bool);
        this.f13b = new C0015l[c0073eArr.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= c0073eArr.length) {
                return;
            }
            this.f13b[i3] = new C0015l((C0022s) c0073eArr[i3].f190a, ((C0020q) c0073eArr[i3].f191b).m11b());
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m8a(C0015l[] c0015lArr) {
        String str = "";
        for (C0015l c0015l : c0015lArr) {
            str = str + "|" + c0015l.m9a();
        }
        return str.equals("") ? str : str.substring(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
    @Override // p000a.p001a.p003b.p004a.p005a.C0005b
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String mo3a(p000a.p001a.p003b.p004a.p005a.AbstractC0023t r11) {
        /*
            r10 = this;
            r1 = 0
            boolean r0 = r11 instanceof p000a.p001a.p003b.p004a.p005a.C0022s
            if (r0 == 0) goto La
            java.lang.String r0 = r11.mo5a()
        L9:
            return r0
        La:
            boolean r0 = r11 instanceof p000a.p001a.p003b.p004a.p005a.C0020q
            if (r0 != 0) goto L13
            java.lang.String r0 = super.mo3a(r11)
            goto L9
        L13:
            a.a.b.a.a.l[] r0 = r10.f15d
            if (r0 != 0) goto L59
            a.a.b.a.a.l[] r0 = r10.f13b
            int r0 = r0.length
            a.a.b.a.a.l[] r5 = new p000a.p001a.p003b.p004a.p005a.C0015l[r0]
            a.a.b.a.a.l[] r0 = r10.f13b
            int r0 = r0.length
            a.a.b.a.a.l[] r6 = new p000a.p001a.p003b.p004a.p005a.C0015l[r0]
            r0 = r1
            r2 = r1
            r3 = r1
        L24:
            a.a.b.a.a.l[] r4 = r10.f13b
            int r4 = r4.length
            if (r0 >= r4) goto L3f
            a.a.b.a.a.l[] r4 = r10.f13b
            r7 = r4[r0]
            int r4 = r7.f16a
            if (r4 != 0) goto L39
            int r4 = r3 + 1
            r5[r3] = r7
            r3 = r4
        L36:
            int r0 = r0 + 1
            goto L24
        L39:
            int r4 = r2 + 1
            r6[r2] = r7
            r2 = r4
            goto L36
        L3f:
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r5, r3)
            a.a.b.a.a.l[] r0 = (p000a.p001a.p003b.p004a.p005a.C0015l[]) r0
            r10.f14c = r0
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r6, r2)
            a.a.b.a.a.l[] r0 = (p000a.p001a.p003b.p004a.p005a.C0015l[]) r0
            r10.f15d = r0
            a.a.b.a.a.l[] r0 = r10.f15d
            a.a.b.a.a.k r2 = new a.a.b.a.a.k
            r2.<init>(r10)
            java.util.Arrays.sort(r0, r2)
        L59:
            a.a.b.a.a.q r11 = (p000a.p001a.p003b.p004a.p005a.C0020q) r11
            int r4 = r11.m11b()
            if (r4 != 0) goto L68
            a.a.b.a.a.l[] r0 = r10.f14c
            java.lang.String r0 = m8a(r0)
            goto L9
        L68:
            a.a.b.a.a.l[] r0 = r10.f15d
            int r0 = r0.length
            a.a.b.a.a.l[] r5 = new p000a.p001a.p003b.p004a.p005a.C0015l[r0]
            a.a.b.a.a.l[] r0 = r10.f15d
            int r0 = r0.length
            int[] r6 = new int[r0]
            r3 = r1
            r2 = r1
        L74:
            a.a.b.a.a.l[] r0 = r10.f15d
            int r0 = r0.length
            if (r3 >= r0) goto L9f
            a.a.b.a.a.l[] r0 = r10.f15d
            r7 = r0[r3]
            int r8 = r7.f16a
            r0 = r4 & r8
            if (r0 != r8) goto Lab
            r0 = r1
        L84:
            int r9 = r6.length
            if (r0 >= r9) goto L9d
            r9 = r6[r0]
            r9 = r9 & r8
            if (r9 != r8) goto L9a
            r0 = 1
        L8d:
            if (r0 != 0) goto Lab
            r6[r2] = r8
            int r0 = r2 + 1
            r5[r2] = r7
        L95:
            int r2 = r3 + 1
            r3 = r2
            r2 = r0
            goto L74
        L9a:
            int r0 = r0 + 1
            goto L84
        L9d:
            r0 = r1
            goto L8d
        L9f:
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r5, r2)
            a.a.b.a.a.l[] r0 = (p000a.p001a.p003b.p004a.p005a.C0015l[]) r0
            java.lang.String r0 = m8a(r0)
            goto L9
        Lab:
            r0 = r2
            goto L95
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p003b.p004a.p005a.C0013j.mo3a(a.a.b.a.a.t):java.lang.String");
    }

    @Override // p000a.p001a.p003b.p004a.p005a.C0005b
    /* JADX INFO: renamed from: a */
    protected final void mo4a(XmlSerializer xmlSerializer) throws IOException {
        for (int i = 0; i < this.f13b.length; i++) {
            C0015l c0015l = this.f13b[i];
            xmlSerializer.startTag(null, "flag");
            xmlSerializer.attribute(null, "name", c0015l.m9a());
            xmlSerializer.attribute(null, "value", String.format("0x%08x", Integer.valueOf(c0015l.f16a)));
            xmlSerializer.endTag(null, "flag");
        }
    }
}
