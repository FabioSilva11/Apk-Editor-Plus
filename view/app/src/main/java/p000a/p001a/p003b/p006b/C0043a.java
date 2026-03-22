package p000a.p001a.p003b.p006b;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import p000a.p001a.C0000a;
import p000a.p001a.p003b.p004a.C0003a;
import p000a.p001a.p003b.p004a.C0028b;
import p000a.p001a.p003b.p004a.C0029c;
import p000a.p001a.p003b.p004a.C0030d;
import p000a.p001a.p003b.p004a.C0031e;
import p000a.p001a.p003b.p004a.C0032f;
import p000a.p001a.p003b.p004a.C0033g;
import p000a.p001a.p003b.p004a.C0034h;
import p000a.p001a.p003b.p004a.C0035i;
import p000a.p001a.p003b.p004a.p005a.AbstractC0023t;
import p000a.p001a.p003b.p004a.p005a.C0007d;
import p000a.p001a.p003b.p004a.p005a.C0012i;
import p000a.p001a.p003b.p004a.p005a.C0019p;
import p000a.p001a.p003b.p004a.p005a.C0024u;
import p000a.p001a.p003b.p004a.p005a.C0026w;
import p000a.p001a.p003b.p004a.p005a.C0027x;
import p000a.p011d.C0073e;
import p000a.p011d.C0074f;

/* JADX INFO: renamed from: a.a.b.b.a */
/* JADX INFO: loaded from: classes.dex */
public class C0043a {

    /* JADX INFO: renamed from: u */
    private static final Logger f104u = Logger.getLogger(C0043a.class.getName());

    /* JADX INFO: renamed from: a */
    private InterfaceC0055m f105a;

    /* JADX INFO: renamed from: b */
    private boolean[] f106b;

    /* JADX INFO: renamed from: c */
    private boolean f107c;

    /* JADX INFO: renamed from: d */
    private boolean f108d;

    /* JADX INFO: renamed from: f */
    private final C0074f f110f;

    /* JADX INFO: renamed from: g */
    private final C0985a f111g;

    /* JADX INFO: renamed from: h */
    private final C0003a f112h;

    /* JADX INFO: renamed from: i */
    private final List f113i;

    /* JADX INFO: renamed from: j */
    private final boolean f114j;

    /* JADX INFO: renamed from: k */
    private C0046d f115k;

    /* JADX INFO: renamed from: l */
    private C0056n f116l;

    /* JADX INFO: renamed from: m */
    private C0056n f117m;

    /* JADX INFO: renamed from: n */
    private C0056n f118n;

    /* JADX INFO: renamed from: o */
    private C0031e f119o;

    /* JADX INFO: renamed from: p */
    private C0035i f120p;

    /* JADX INFO: renamed from: q */
    private C0034h f121q;

    /* JADX INFO: renamed from: r */
    private int f122r;

    /* JADX INFO: renamed from: s */
    private boolean[] f123s;

    /* JADX INFO: renamed from: e */
    private byte[] f109e = new byte[12];

    /* JADX INFO: renamed from: t */
    private HashMap f124t = new HashMap();

    private C0043a(InputStream inputStream, C0985a c0985a, InterfaceC0055m interfaceC0055m, boolean z, boolean z2, boolean z3) {
        this.f105a = interfaceC0055m;
        this.f108d = z3;
        C0003a c0003a = new C0003a(inputStream);
        this.f112h = c0003a;
        if (z) {
            this.f113i = new ArrayList();
        } else {
            this.f113i = null;
        }
        this.f110f = new C0074f(new C0028b(c0003a));
        this.f111g = c0985a;
        this.f114j = z2;
    }

    /* JADX INFO: renamed from: a */
    private C0019p m100a(byte b2, int i) {
        boolean zM157b;
        String str;
        String str2;
        if ((this.f122r & ViewCompat.MEASURED_STATE_MASK) != 16777216) {
            String strM154a = this.f116l.m154a(i);
            String strM156b = this.f116l.m156b(i, strM154a);
            zM157b = this.f116l.m157b();
            str = strM154a;
            str2 = strM156b;
        } else {
            zM157b = false;
            str = "";
            str2 = "";
        }
        if (b2 != 3) {
            return this.f119o.m57g().m39a(b2, i, (String) null);
        }
        this.f119o.m57g();
        return (str2 == null || str2.equals("")) ? new C0024u(str2, i) : (this.f107c || str2.startsWith("res/") || str2.startsWith("r/") || str2.startsWith("R/")) ? new C0012i(str, i) : new C0024u(str2, i, str, zM157b);
    }

    /* JADX INFO: renamed from: a */
    public static C0044b m101a(InputStream inputStream, boolean z, boolean z2, C0985a c0985a, InterfaceC0055m interfaceC0055m, boolean z3) throws C0000a {
        try {
            C0043a c0043a = new C0043a(inputStream, c0985a, interfaceC0055m, false, z2, z3);
            c0043a.m112f();
            c0043a.m108b(2);
            int i = c0043a.f110f.readInt();
            c0043a.f116l = C0056n.m145a(c0043a.f110f);
            C0031e[] c0031eArr = new C0031e[i];
            c0043a.m112f();
            for (int i2 = 0; i2 < i; i2++) {
                c0043a.m108b(512);
                byte b2 = (byte) c0043a.f110f.readInt();
                byte b3 = b2 == 0 ? (byte) 2 : b2;
                String strM183a = c0043a.f110f.m183a(128, true);
                c0043a.f110f.skipBytes(4);
                c0043a.f110f.skipBytes(4);
                c0043a.f110f.skipBytes(4);
                c0043a.f110f.skipBytes(4);
                c0043a.f117m = C0056n.m145a(c0043a.f110f);
                c0043a.f118n = C0056n.m145a(c0043a.f110f);
                if (c0043a.f108d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('_');
                    sb.append('r');
                    sb.append('r');
                    String string = sb.toString();
                    int i3 = 0;
                    for (int i4 = 0; i4 < c0043a.f118n.m152a(); i4++) {
                        String strM154a = c0043a.f118n.m154a(i4);
                        if (strM154a != null && !strM154a.equals("") && !strM154a.matches("[a-zA-Z0-9_\\.]+")) {
                            c0043a.f118n.m155a(i4, string + i3);
                            i3++;
                        } else if ("do".equals(strM154a)) {
                            c0043a.f118n.m155a(i4, "do" + string + i3);
                            i3++;
                        } else if ("if".equals(strM154a)) {
                            c0043a.f118n.m155a(i4, "if" + string + i3);
                            i3++;
                        } else if ("for".equals(strM154a)) {
                            c0043a.f118n.m155a(i4, "for" + string + i3);
                            i3++;
                        }
                    }
                }
                c0043a.f106b = new boolean[c0043a.f117m.m152a() + 32];
                Arrays.fill(c0043a.f106b, false);
                for (int i5 = 0; i5 < c0043a.f117m.m152a(); i5++) {
                    String strM154a2 = c0043a.f117m.m154a(i5);
                    if (strM154a2.equals("ani") || strM154a2.equals("animator") || strM154a2.equals("drawable") || strM154a2.equals("interpolator") || strM154a2.equals("layout") || strM154a2.equals("menu") || strM154a2.equals("mipmap") || strM154a2.equals("raw") || strM154a2.equals("transition") || strM154a2.equals("xml")) {
                        c0043a.f106b[i5] = true;
                    }
                }
                c0043a.f122r = b3 << 24;
                c0043a.f119o = new C0031e(c0043a.f111g, b3, strM183a);
                c0043a.m112f();
                boolean z4 = true;
                while (z4) {
                    switch (c0043a.f115k.f126a) {
                        case 514:
                            c0043a.m107b();
                            break;
                        case 515:
                            c0043a.m104a();
                            break;
                        default:
                            z4 = false;
                            break;
                    }
                }
                c0031eArr[i2] = c0043a.f119o;
            }
            return new C0044b(c0031eArr, c0043a.f113i == null ? null : (C0045c[]) c0043a.f113i.toArray(new C0045c[0]), c0985a);
        } catch (IOException e) {
            throw new C0000a("Could not decode arsc file", e);
        }
    }

    /* JADX INFO: renamed from: a */
    private String m102a(int i) {
        int i2;
        short s;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i == 0 || this.f110f.readByte() == 0) {
                break;
            }
            sb.append((char) s);
            i = i2;
        }
        this.f110f.skipBytes(i2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private String m103a(int i, int i2) {
        String strMo144a;
        return (this.f105a == null || (strMo144a = this.f105a.mo144a(i)) == null) ? this.f118n.m154a(i2) : strMo144a;
    }

    /* JADX INFO: renamed from: a */
    private void m104a() throws C0000a, IOException {
        m108b(515);
        int i = this.f110f.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            f104u.info(String.format("Decoding (%s), pkgId: %d", this.f110f.m183a(128, true), Integer.valueOf(this.f110f.readInt())));
        }
        while (m112f().f126a == 513) {
            m107b();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m105a(C0035i c0035i) {
        this.f124t.put(Integer.valueOf(c0035i.m82b()), c0035i);
    }

    /* JADX INFO: renamed from: a */
    private static char[] m106a(byte b2, byte b3, char c) {
        return ((b2 >> 7) & 1) == 1 ? new char[]{(char) ((b3 & 31) + c), (char) (((b2 & 3) << 3) + ((b3 & 224) >> 5) + c), (char) (((b2 & 124) >> 2) + c)} : new char[]{(char) b2, (char) b3};
    }

    /* JADX INFO: renamed from: b */
    private C0035i m107b() throws C0000a, IOException {
        this.f120p = m109c();
        m105a(this.f120p);
        short s = m112f().f126a;
        while (s == 514) {
            m105a(m109c());
            s = m112f().f126a;
        }
        while (s == 513) {
            m108b(InputDeviceCompat.SOURCE_DPAD);
            this.f110f.readFully(this.f109e);
            int i = this.f109e[0] & 255;
            if (this.f124t.containsKey(Integer.valueOf(i))) {
                this.f122r = (((C0035i) this.f124t.get(Integer.valueOf(i))).m82b() << 16) | (this.f122r & ViewCompat.MEASURED_STATE_MASK);
                this.f120p = (C0035i) this.f124t.get(Integer.valueOf(i));
            }
            if (i < this.f106b.length) {
                this.f107c = this.f106b[i - 1];
            } else {
                this.f107c = false;
            }
            int i2 = ((this.f109e[7] & 255) << 24) | ((this.f109e[6] & 255) << 16) | ((this.f109e[5] & 255) << 8) | (this.f109e[4] & 255);
            int i3 = ((this.f109e[11] & 255) << 24) | ((this.f109e[10] & 255) << 16) | ((this.f109e[9] & 255) << 8) | (this.f109e[8] & 255);
            this.f123s = new boolean[i2];
            Arrays.fill(this.f123s, true);
            int i4 = this.f110f.readInt();
            int i5 = 28;
            if (i4 < 28) {
                throw new C0000a("Config size < 28");
            }
            boolean z = false;
            byte[] bArr = new byte[24];
            this.f110f.readFully(bArr);
            short s2 = (short) (((bArr[1] & 255) << 8) | (bArr[0] & 255));
            short s3 = (short) (((bArr[3] & 255) << 8) | (bArr[2] & 255));
            char[] cArrM106a = m106a(bArr[4], bArr[5], 'a');
            char[] cArrM106a2 = m106a(bArr[6], bArr[7], '0');
            byte b2 = bArr[8];
            byte b3 = bArr[9];
            int i6 = ((bArr[11] & 255) << 8) | (bArr[10] & 255);
            byte b4 = bArr[12];
            byte b5 = bArr[13];
            byte b6 = bArr[14];
            short s4 = (short) (((bArr[17] & 255) << 8) | (bArr[16] & 255));
            short s5 = (short) (((bArr[19] & 255) << 8) | (bArr[18] & 255));
            short s6 = (short) ((bArr[20] & 255) | ((bArr[21] & 255) << 8));
            byte b7 = 0;
            byte b8 = 0;
            short s7 = 0;
            if (i4 >= 32) {
                byte[] bArr2 = new byte[4];
                this.f110f.readFully(bArr2);
                b7 = bArr2[0];
                b8 = bArr2[1];
                s7 = (short) ((bArr2[2] & 255) | ((bArr2[3] & 255) << 8));
                i5 = 32;
            }
            short s8 = 0;
            short s9 = 0;
            if (i4 >= 36) {
                byte[] bArr3 = new byte[4];
                this.f110f.readFully(bArr3);
                s8 = (short) (((bArr3[1] & 255) << 8) | (bArr3[0] & 255));
                s9 = (short) ((bArr3[2] & 255) | ((bArr3[3] & 255) << 8));
                i5 = 36;
            }
            char[] charArray = null;
            char[] charArray2 = null;
            if (i4 >= 48) {
                charArray = m102a(4).toCharArray();
                charArray2 = m102a(8).toCharArray();
                i5 = 48;
            }
            byte b9 = 0;
            byte b10 = 0;
            if (i4 >= 52) {
                b9 = this.f110f.readByte();
                b10 = this.f110f.readByte();
                this.f110f.skipBytes(2);
                i5 = 52;
            }
            if (i4 >= 56) {
                this.f110f.skipBytes(4);
                i5 = 56;
            }
            int i7 = i4 - 56;
            if (i7 > 0) {
                byte[] bArr4 = new byte[i7];
                i5 += i7;
                this.f110f.readFully(bArr4);
                if (!new BigInteger(1, bArr4).equals(BigInteger.ZERO)) {
                    z = true;
                }
            }
            int i8 = i4 - i5;
            if (i8 > 0) {
                this.f110f.skipBytes(i8);
            }
            C0029c c0029c = new C0029c(s2, s3, cArrM106a, cArrM106a2, b2, b3, i6, b4, b5, b6, s4, s5, s6, b7, b8, s7, s8, s9, charArray, charArray2, b9, b10, z, i4);
            int i9 = (this.f115k.f127b + i3) - (i2 << 2);
            if (i9 != this.f112h.m0a()) {
                this.f110f.skipBytes(i9 - this.f112h.m0a());
            }
            int[] iArrA = this.f110f.m182a(i2);
            if (c0029c.f38a) {
                String str = this.f120p.m80a() + c0029c.m42a();
                if (this.f114j) {
                    f104u.warning("Invalid config flags detected: " + str);
                } else {
                    f104u.warning("Invalid config flags detected. Dropping resources: " + str);
                }
            }
            this.f121q = (!c0029c.f38a || this.f114j) ? this.f119o.m43a(c0029c) : null;
            for (int i10 = 0; i10 < iArrA.length; i10++) {
                if (iArrA[i10] != -1) {
                    this.f123s[i10] = false;
                    this.f122r = (this.f122r & SupportMenu.CATEGORY_MASK) | i10;
                    m110d();
                }
            }
            C0034h c0034h = this.f121q;
            if (this.f112h.m0a() < this.f115k.f128c) {
                this.f112h.skip(this.f115k.f128c - this.f112h.m0a());
            }
            s = m112f().f126a;
            m111e();
        }
        return this.f120p;
    }

    /* JADX INFO: renamed from: b */
    private void m108b(int i) throws C0000a {
        if (this.f115k.f126a != i) {
            throw new C0000a(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i), Short.valueOf(this.f115k.f126a)));
        }
    }

    /* JADX INFO: renamed from: c */
    private C0035i m109c() throws C0000a {
        m108b(514);
        int unsignedByte = this.f110f.readUnsignedByte();
        this.f110f.skipBytes(3);
        int i = this.f110f.readInt();
        if (this.f113i != null) {
            this.f113i.add(new C0045c(this.f112h.m0a(), i));
        }
        this.f110f.skipBytes(i << 2);
        this.f120p = new C0035i(this.f117m.m154a(unsignedByte - 1), this.f111g, this.f119o, unsignedByte, i);
        this.f119o.m47a(this.f120p);
        return this.f120p;
    }

    /* JADX INFO: renamed from: d */
    private void m110d() throws C0000a {
        C0026w c0026wM37a;
        C0032f c0032f;
        byte[] bArr = new byte[8];
        this.f110f.readFully(bArr);
        short s = (short) (((bArr[3] & 255) << 8) | (bArr[2] & 255));
        int i = (bArr[7] << 24) | ((bArr[6] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[4] & 255);
        if (this.f112h.m0a() == this.f115k.f128c) {
            return;
        }
        if ((s & 1) == 0) {
            byte[] bArr2 = new byte[8];
            this.f110f.readFully(bArr2);
            c0026wM37a = m100a(bArr2[3], (bArr2[4] & 255) | ((bArr2[7] & 255) << 24) | ((bArr2[6] & 255) << 16) | ((bArr2[5] & 255) << 8));
        } else {
            int[] iArrA = this.f110f.m182a(2);
            int i2 = iArrA[0];
            int i3 = iArrA[1];
            C0027x c0027xM57g = this.f119o.m57g();
            C0073e[] c0073eArr = new C0073e[i3];
            byte[] bArr3 = new byte[i3 * 12];
            this.f110f.readFully(bArr3);
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i4 * 12;
                int i6 = (bArr3[i5] & 255) | ((bArr3[i5 + 3] & 255) << 24) | ((bArr3[i5 + 2] & 255) << 16) | ((bArr3[i5 + 1] & 255) << 8);
                byte b2 = bArr3[i5 + 7];
                int i7 = ((bArr3[i5 + 11] & 255) << 24) | ((bArr3[i5 + 10] & 255) << 16) | ((bArr3[i5 + 9] & 255) << 8) | (bArr3[i5 + 8] & 255);
                if (((bArr3[i5 + 4] & 255) | ((bArr3[i5 + 5] & 255) << 8)) != 8) {
                    Log.d("DEBUG", "error");
                }
                C0019p c0019pM100a = m100a(b2, i7);
                if (c0019pM100a instanceof AbstractC0023t) {
                    c0073eArr[i4] = new C0073e(Integer.valueOf(i6), (AbstractC0023t) c0019pM100a);
                } else {
                    c0073eArr[i4] = new C0073e(Integer.valueOf(i6), new C0024u(c0019pM100a.toString(), c0019pM100a.m10c()));
                }
            }
            c0026wM37a = c0027xM57g.m37a(i2, c0073eArr, this.f120p);
        }
        C0026w c0024u = (this.f120p.m84c() && (c0026wM37a instanceof C0012i)) ? new C0024u(c0026wM37a.toString(), ((C0012i) c0026wM37a).m10c()) : c0026wM37a;
        if (this.f121q != null) {
            C0030d c0030d = new C0030d(this.f122r);
            if (this.f119o.m48a(c0030d)) {
                c0032f = this.f119o.m49b(c0030d);
                if (c0032f.m70i()) {
                    if (this.f119o.m48a(c0032f.m66e())) {
                        this.f119o.m46a(c0032f);
                        this.f120p.m81a(c0032f);
                    }
                    c0032f = new C0032f(c0030d, m103a(c0030d.f64b, i), this.f119o, this.f120p, this.f108d);
                    this.f119o.m51b(c0032f);
                    this.f120p.m83b(c0032f);
                }
            } else {
                c0032f = new C0032f(c0030d, m103a(c0030d.f64b, i), this.f119o, this.f120p, this.f108d);
                this.f119o.m51b(c0032f);
                this.f120p.m83b(c0032f);
            }
            C0033g c0033g = new C0033g(this.f121q, c0032f, c0024u);
            try {
                this.f121q.m77a(c0033g);
                c0032f.m61a(c0033g);
            } catch (C0000a e) {
                if (!this.f114j) {
                    throw e;
                }
                this.f121q.m78a(c0033g, true);
                c0032f.m62a(c0033g, true);
                f104u.warning(String.format("Duplicate res igonred: %s", c0033g.toString()));
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m111e() throws C0000a {
        int i = this.f122r & SupportMenu.CATEGORY_MASK;
        for (int i2 = 0; i2 < this.f123s.length; i2++) {
            if (this.f123s[i2]) {
                C0032f c0032f = new C0032f(new C0030d(i | i2), "carlos_ae_" + Integer.toHexString(i2), this.f119o, this.f120p, false);
                if (!this.f119o.m48a(new C0030d(i | i2))) {
                    this.f119o.m51b(c0032f);
                    this.f120p.m83b(c0032f);
                    if (this.f121q == null) {
                        this.f121q = this.f119o.m43a(new C0029c());
                    }
                    C0033g c0033g = new C0033g(this.f121q, c0032f, new C0007d(false, 0, null));
                    this.f121q.m77a(c0033g);
                    c0032f.m61a(c0033g);
                }
            }
        }
    }

    /* JADX INFO: renamed from: f */
    private C0046d m112f() {
        C0046d c0046dM114a = C0046d.m114a(this.f110f, this.f112h);
        this.f115k = c0046dM114a;
        return c0046dM114a;
    }
}
