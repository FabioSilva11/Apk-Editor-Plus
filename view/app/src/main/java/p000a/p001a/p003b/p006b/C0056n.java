package p000a.p001a.p003b.p006b;

import android.util.SparseArray;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Arrays;
import p000a.p011d.C0074f;

/* JADX INFO: renamed from: a.a.b.b.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0056n {

    /* JADX INFO: renamed from: c */
    private int[] f163c;

    /* JADX INFO: renamed from: d */
    private byte[] f164d;

    /* JADX INFO: renamed from: e */
    private int[] f165e;

    /* JADX INFO: renamed from: f */
    private int[] f166f;

    /* JADX INFO: renamed from: g */
    private boolean f167g;

    /* JADX INFO: renamed from: h */
    private int[] f168h;

    /* JADX INFO: renamed from: a */
    private SparseArray f161a = new SparseArray();

    /* JADX INFO: renamed from: b */
    private boolean f162b = false;

    /* JADX INFO: renamed from: i */
    private final CharsetDecoder f169i = Charset.forName("UTF-16LE").newDecoder();

    /* JADX INFO: renamed from: j */
    private final CharsetDecoder f170j = Charset.forName("UTF-8").newDecoder();

    /* JADX INFO: renamed from: k */
    private final CharsetDecoder f171k = Charset.forName("CESU8").newDecoder();

    private C0056n() {
    }

    /* JADX INFO: renamed from: a */
    public static C0056n m145a(C0074f c0074f) throws IOException {
        c0074f.m184a(1835009, 0);
        int i = c0074f.readInt();
        int i2 = c0074f.readInt();
        int i3 = c0074f.readInt();
        int i4 = c0074f.readInt();
        int i5 = c0074f.readInt();
        int i6 = c0074f.readInt();
        C0056n c0056n = new C0056n();
        c0056n.f167g = (i4 & 256) != 0;
        c0056n.f163c = c0074f.m182a(i2);
        c0056n.f168h = new int[i2];
        for (int i7 = 0; i7 < i2; i7++) {
            c0056n.f168h[i7] = -1;
        }
        if (i3 != 0) {
            c0056n.f165e = c0074f.m182a(i3);
        }
        c0056n.f164d = new byte[(i6 == 0 ? i : i6) - i5];
        c0074f.readFully(c0056n.f164d);
        if (i6 != 0) {
            int i8 = i - i6;
            c0056n.f166f = c0074f.m182a(i8 / 4);
            int i9 = i8 % 4;
            if (i9 > 0) {
                while (true) {
                    int i10 = i9 - 1;
                    if (i9 <= 0) {
                        break;
                    }
                    c0074f.readByte();
                    i9 = i10;
                }
            }
        }
        return c0056n;
    }

    /* JADX INFO: renamed from: a */
    private String m146a(int i, int i2) {
        int i3;
        try {
            return (this.f167g ? this.f170j : this.f169i).decode(ByteBuffer.wrap(this.f164d, i, i2)).toString();
        } catch (CharacterCodingException e) {
            if (!this.f167g) {
                return "DCD";
            }
            try {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(this.f164d, i, i + i2);
                byte[] bArr = new byte[i2];
                StringBuilder sb = new StringBuilder();
                int i4 = 0;
                int i5 = 0;
                while (i4 < i2) {
                    if (bArrCopyOfRange[i4] != -19 || bArrCopyOfRange[i4 + 3] != -19 || bArrCopyOfRange[i4 + 1] < -96 || bArrCopyOfRange[i4 + 1] > -81 || bArrCopyOfRange[i4 + 4] < -80 || bArrCopyOfRange[i4 + 4] > -65) {
                        i3 = i5 + 1;
                        bArr[i5] = bArrCopyOfRange[i4];
                    } else {
                        if (bArr[0] != 0) {
                            byte[] bArrTrim = trim(bArr);
                            sb.append(this.f170j.decode(ByteBuffer.wrap(bArrTrim, 0, bArrTrim.length)).toString());
                        }
                        sb.append(this.f171k.decode(ByteBuffer.wrap(bArrCopyOfRange, i4, 6)).toString());
                        i4 += 5;
                        Arrays.fill(bArr, (byte) 0);
                        i3 = 0;
                    }
                    i4++;
                    i5 = i3;
                }
                if (bArr[0] != 0) {
                    byte[] bArrTrim2 = trim(bArr);
                    sb.append(this.f170j.decode(ByteBuffer.wrap(bArrTrim2, 0, bArrTrim2.length)).toString());
                }
                return sb.toString();
            } catch (CharacterCodingException e2) {
                return "CSU";
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m147a(String str, int i, int i2) {
        return i < str.length() ? i2 <= str.length() ? str.substring(i, i2) : str.substring(i) : "";
    }

    /* JADX INFO: renamed from: a */
    private static void m148a(String str, StringBuilder sb, boolean z) {
        String strSubstring;
        sb.append('<');
        if (z) {
            sb.append('/');
        }
        int iIndexOf = str.indexOf(59);
        if (iIndexOf == -1) {
            sb.append(str);
        } else {
            sb.append(str.substring(0, iIndexOf));
            if (!z) {
                boolean z2 = true;
                while (z2) {
                    int iIndexOf2 = str.indexOf(61, iIndexOf + 1);
                    if (iIndexOf2 != -1) {
                        sb.append(' ').append(str.substring(iIndexOf + 1, iIndexOf2)).append("=\"");
                        int iIndexOf3 = str.indexOf(59, iIndexOf2 + 1);
                        if (iIndexOf3 != -1) {
                            strSubstring = str.substring(iIndexOf2 + 1, iIndexOf3);
                        } else {
                            strSubstring = str.substring(iIndexOf2 + 1);
                            z2 = false;
                        }
                        sb.append(C0985a.m2198a(strSubstring)).append('\"');
                        iIndexOf = iIndexOf3;
                    } else {
                        z2 = false;
                    }
                }
            }
        }
        sb.append('>');
    }

    /* JADX INFO: renamed from: a */
    public static final int[] m149a(byte[] bArr, int i) {
        int i2 = (bArr[i] & 128) != 0 ? i + 2 : i + 1;
        int i3 = bArr[i2];
        int i4 = i2 + 1;
        if ((i3 & 128) != 0) {
            i3 = ((i3 & 127) << 8) + (bArr[i4] & 255);
            i4++;
        }
        return new int[]{i4, i3};
    }

    /* JADX INFO: renamed from: b */
    public static final int[] m150b(byte[] bArr, int i) {
        int i2 = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
        return (32768 & i2) != 0 ? new int[]{4, (((i2 & 32767) << 16) + (((bArr[i + 3] & 255) << 8) + (bArr[i + 2] & 255))) << 1} : new int[]{2, i2 << 1};
    }

    /* JADX INFO: renamed from: c */
    private static final int m151c(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    private static byte[] trim(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0 && bArr[length] == 0) {
            length--;
        }
        return Arrays.copyOf(bArr, length + 1);
    }

    /* JADX INFO: renamed from: a */
    public final int m152a() {
        if (this.f163c != null) {
            return this.f163c.length;
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public final int m153a(String str) {
        if (str == null) {
            return -1;
        }
        for (int i = 0; i != this.f163c.length; i++) {
            int i2 = this.f163c[i];
            int iM151c = m151c(this.f164d, i2);
            if (iM151c == str.length()) {
                int i3 = i2;
                int i4 = 0;
                while (i4 != iM151c) {
                    i3 += 2;
                    if (str.charAt(i4) != m151c(this.f164d, i3)) {
                        break;
                    }
                    i4++;
                }
                if (i4 == iM151c) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public final String m154a(int i) {
        int i2;
        int i3;
        String str = (String) this.f161a.get(i);
        if (str != null) {
            return str;
        }
        if (i < 0 || this.f163c == null || i >= this.f163c.length) {
            return null;
        }
        int i4 = this.f163c[i];
        if (this.f167g) {
            int[] iArrM149a = m149a(this.f164d, i4);
            i2 = iArrM149a[0];
            i3 = iArrM149a[1];
        } else {
            int[] iArrM150b = m150b(this.f164d, i4);
            i2 = iArrM150b[0] + i4;
            i3 = iArrM150b[1];
        }
        return m146a(i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public final void m155a(int i, String str) {
        this.f161a.put(i, str);
    }

    /* JADX INFO: renamed from: b */
    public final String m156b(int i, String str) {
        int[] iArr;
        if (str == null) {
            return str;
        }
        if (this.f165e == null || this.f166f == null || i >= this.f165e.length) {
            iArr = null;
        } else {
            int i2 = this.f165e[i] / 4;
            int i3 = 0;
            for (int i4 = i2; i4 < this.f166f.length && this.f166f[i4] != -1; i4++) {
                i3++;
            }
            if (i3 == 0 || i3 % 3 != 0) {
                iArr = null;
            } else {
                iArr = new int[i3];
                int i5 = 0;
                for (int i6 = i2; i6 < this.f166f.length && this.f166f[i6] != -1; i6++) {
                    iArr[i5] = this.f166f[i6];
                    i5++;
                }
            }
        }
        if (iArr == null) {
            this.f162b = false;
            return C0985a.m2198a(str);
        }
        this.f162b = true;
        if (iArr[1] > str.length()) {
            return C0985a.m2198a(str);
        }
        StringBuilder sb = new StringBuilder(str.length() + 32);
        int[] iArr2 = new int[iArr.length / 3];
        boolean[] zArr = new boolean[iArr.length / 3];
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = -1;
            for (int i10 = 0; i10 != iArr.length; i10 += 3) {
                if (iArr[i10 + 1] != -1 && (i9 == -1 || iArr[i9 + 1] > iArr[i10 + 1])) {
                    i9 = i10;
                }
            }
            int length = i9 != -1 ? iArr[i9 + 1] : str.length();
            int i11 = i8 - 1;
            int i12 = i7;
            int i13 = i11;
            while (true) {
                if (i13 < 0) {
                    break;
                }
                int i14 = iArr2[i13];
                int i15 = iArr[i14 + 2];
                if (i15 < length) {
                    if (i12 <= i15) {
                        sb.append(C0985a.m2198a(m147a(str, i12, i15 + 1)));
                        i12 = i15 + 1;
                    }
                    m148a(m154a(iArr[i14]), sb, true);
                    i13--;
                } else if (iArr[i14 + 1] == -1 && i15 != -1) {
                    zArr[i13] = true;
                }
            }
            int i16 = i13 + 1;
            if (i12 < length) {
                sb.append(C0985a.m2198a(m147a(str, i12, length)));
                if (i13 >= 0 && zArr.length >= i13 && zArr[i13] && ((zArr.length > i13 + 1 && zArr[i13 + 1]) || zArr.length == 1)) {
                    m148a(m154a(iArr[iArr2[i13]]), sb, true);
                }
                i7 = length;
            } else {
                i7 = i12;
            }
            if (i9 == -1) {
                return sb.toString();
            }
            m148a(m154a(iArr[i9]), sb, false);
            iArr[i9 + 1] = -1;
            i8 = i16 + 1;
            iArr2[i16] = i9;
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m157b() {
        return this.f162b;
    }
}
