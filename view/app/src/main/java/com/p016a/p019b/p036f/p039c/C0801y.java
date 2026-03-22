package com.p016a.p019b.p036f.p039c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p043h.C0873c;

/* JADX INFO: renamed from: com.a.b.f.c.y */
/* JADX INFO: loaded from: classes.dex */
public final class C0801y extends AbstractC0777ab {

    /* JADX INFO: renamed from: a */
    private final String f1936a;

    /* JADX INFO: renamed from: b */
    private final C0873c f1937b;

    static {
        new C0801y("");
    }

    public C0801y(C0873c c0873c) {
        if (c0873c == null) {
            throw new NullPointerException("bytes == null");
        }
        this.f1937b = c0873c;
        this.f1936a = m1646a(c0873c).intern();
    }

    public C0801y(String str) {
        if (str == null) {
            throw new NullPointerException("string == null");
        }
        this.f1936a = str.intern();
        this.f1937b = new C0873c(m1647a(str));
    }

    /* JADX INFO: renamed from: a */
    private static String m1645a(int i, int i2) {
        throw new IllegalArgumentException("bad utf-8 byte " + C0985a.m2298x(i) + " at offset " + C0985a.m2294t(i2));
    }

    /* JADX INFO: renamed from: a */
    private static String m1646a(C0873c c0873c) {
        int i;
        char c;
        int iM1957a = c0873c.m1957a();
        char[] cArr = new char[iM1957a];
        int i2 = 0;
        int i3 = 0;
        while (iM1957a > 0) {
            int iM1965e = c0873c.m1965e(i2);
            switch (iM1965e >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    iM1957a--;
                    if (iM1965e == 0) {
                        return m1645a(iM1965e, i2);
                    }
                    c = (char) iM1965e;
                    i2++;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return m1645a(iM1965e, i2);
                case 12:
                case 13:
                    iM1957a -= 2;
                    if (iM1957a < 0) {
                        return m1645a(iM1965e, i2);
                    }
                    int iM1965e2 = c0873c.m1965e(i2 + 1);
                    if ((iM1965e2 & 192) != 128) {
                        return m1645a(iM1965e2, i2 + 1);
                    }
                    int i4 = ((iM1965e & 31) << 6) | (iM1965e2 & 63);
                    if (i4 != 0 && i4 < 128) {
                        return m1645a(iM1965e2, i2 + 1);
                    }
                    c = (char) i4;
                    i2 += 2;
                    break;
                    break;
                case 14:
                    iM1957a -= 3;
                    if (iM1957a < 0) {
                        return m1645a(iM1965e, i2);
                    }
                    int iM1965e3 = c0873c.m1965e(i2 + 1);
                    if ((iM1965e3 & 192) != 128) {
                        return m1645a(iM1965e3, i2 + 1);
                    }
                    int iM1965e4 = c0873c.m1965e(i2 + 2);
                    if ((iM1965e3 & 192) == 128 && (i = ((iM1965e & 15) << 12) | ((iM1965e3 & 63) << 6) | (iM1965e4 & 63)) >= 2048) {
                        c = (char) i;
                        i2 += 3;
                        break;
                    }
                    return m1645a(iM1965e4, i2 + 2);
            }
            cArr[i3] = c;
            i3++;
        }
        return new String(cArr, 0, i3);
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m1647a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length * 3];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != 0 && cCharAt < 128) {
                bArr[i] = (byte) cCharAt;
                i++;
            } else if (cCharAt < 2048) {
                bArr[i] = (byte) (((cCharAt >> 6) & 31) | 192);
                bArr[i + 1] = (byte) ((cCharAt & '?') | 128);
                i += 2;
            } else {
                bArr[i] = (byte) (((cCharAt >> '\f') & 15) | 224);
                bArr[i + 1] = (byte) (((cCharAt >> 6) & 63) | 128);
                bArr[i + 2] = (byte) ((cCharAt & '?') | 128);
                i += 3;
            }
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    @Override // com.p016a.p019b.p036f.p040d.InterfaceC0806d
    /* JADX INFO: renamed from: a */
    public final C0805c mo663a() {
        return C0805c.f2025p;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: b */
    protected final int mo1602b(AbstractC0775a abstractC0775a) {
        return this.f1936a.compareTo(((C0801y) abstractC0775a).f1936a);
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        int length = this.f1936a.length();
        StringBuilder sb = new StringBuilder((length * 3) / 2);
        int i = 0;
        while (i < length) {
            char cCharAt = this.f1936a.charAt(i);
            if (cCharAt >= ' ' && cCharAt < 127) {
                if (cCharAt == '\'' || cCharAt == '\"' || cCharAt == '\\') {
                    sb.append('\\');
                }
                sb.append(cCharAt);
            } else if (cCharAt <= 127) {
                switch (cCharAt) {
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    case 11:
                    case '\f':
                    default:
                        char cCharAt2 = i < length + (-1) ? this.f1936a.charAt(i + 1) : (char) 0;
                        boolean z = cCharAt2 >= '0' && cCharAt2 <= '7';
                        sb.append('\\');
                        for (int i2 = 6; i2 >= 0; i2 -= 3) {
                            char c = (char) (((cCharAt >> i2) & 7) + 48);
                            if (c != '0' || z) {
                                sb.append(c);
                                z = true;
                            }
                        }
                        if (!z) {
                            sb.append('0');
                        }
                        break;
                    case '\r':
                        sb.append("\\r");
                        break;
                }
            } else {
                sb.append("\\u");
                sb.append(Character.forDigit(cCharAt >> '\f', 16));
                sb.append(Character.forDigit((cCharAt >> '\b') & 15, 16));
                sb.append(Character.forDigit((cCharAt >> 4) & 15, 16));
                sb.append(Character.forDigit(cCharAt & 15, 16));
            }
            i++;
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0801y) {
            return this.f1936a.equals(((C0801y) obj).f1936a);
        }
        return false;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: g */
    public final boolean mo1603g() {
        return false;
    }

    @Override // com.p016a.p019b.p036f.p039c.AbstractC0775a
    /* JADX INFO: renamed from: h */
    public final String mo1604h() {
        return "utf8";
    }

    public final int hashCode() {
        return this.f1936a.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public final String m1648i() {
        return "\"" + mo657d() + '\"';
    }

    /* JADX INFO: renamed from: j */
    public final String m1649j() {
        return this.f1936a;
    }

    /* JADX INFO: renamed from: k */
    public final C0873c m1650k() {
        return this.f1937b;
    }

    /* JADX INFO: renamed from: l */
    public final int m1651l() {
        return this.f1937b.m1957a();
    }

    /* JADX INFO: renamed from: m */
    public final int m1652m() {
        return this.f1936a.length();
    }

    public final String toString() {
        return "string{\"" + mo657d() + "\"}";
    }
}
