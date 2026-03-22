package p000a.p001a.p003b.p004a;

import android.support.v4.internal.view.SupportMenu;
import com.gmail.heagoo.neweditor.Token;
import java.io.Serializable;

/* JADX INFO: renamed from: a.a.b.a.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0029c implements Serializable {

    /* JADX INFO: renamed from: z */
    private static int f37z = 0;

    /* JADX INFO: renamed from: a */
    public final boolean f38a;

    /* JADX INFO: renamed from: b */
    private short f39b;

    /* JADX INFO: renamed from: c */
    private short f40c;

    /* JADX INFO: renamed from: d */
    private char[] f41d;

    /* JADX INFO: renamed from: e */
    private char[] f42e;

    /* JADX INFO: renamed from: f */
    private byte f43f;

    /* JADX INFO: renamed from: g */
    private byte f44g;

    /* JADX INFO: renamed from: h */
    private int f45h;

    /* JADX INFO: renamed from: i */
    private byte f46i;

    /* JADX INFO: renamed from: j */
    private byte f47j;

    /* JADX INFO: renamed from: k */
    private byte f48k;

    /* JADX INFO: renamed from: l */
    private short f49l;

    /* JADX INFO: renamed from: m */
    private short f50m;

    /* JADX INFO: renamed from: n */
    private short f51n;

    /* JADX INFO: renamed from: o */
    private byte f52o;

    /* JADX INFO: renamed from: p */
    private byte f53p;

    /* JADX INFO: renamed from: q */
    private short f54q;

    /* JADX INFO: renamed from: r */
    private short f55r;

    /* JADX INFO: renamed from: s */
    private short f56s;

    /* JADX INFO: renamed from: t */
    private final char[] f57t;

    /* JADX INFO: renamed from: u */
    private final char[] f58u;

    /* JADX INFO: renamed from: v */
    private final byte f59v;

    /* JADX INFO: renamed from: w */
    private final byte f60w;

    /* JADX INFO: renamed from: x */
    private String f61x;

    /* JADX INFO: renamed from: y */
    private final int f62y;

    public C0029c() {
        this.f39b = (short) 0;
        this.f40c = (short) 0;
        this.f41d = new char[]{0, 0};
        this.f42e = new char[]{0, 0};
        this.f43f = (byte) 0;
        this.f44g = (byte) 0;
        this.f45h = 0;
        this.f46i = (byte) 0;
        this.f47j = (byte) 0;
        this.f48k = (byte) 0;
        this.f49l = (short) 0;
        this.f50m = (short) 0;
        this.f51n = (short) 0;
        this.f52o = (byte) 0;
        this.f53p = (byte) 0;
        this.f54q = (short) 0;
        this.f55r = (short) 0;
        this.f56s = (short) 0;
        this.f57t = null;
        this.f58u = null;
        this.f59v = (byte) 0;
        this.f60w = (byte) 0;
        this.f38a = false;
        this.f61x = "";
        this.f62y = 0;
    }

    public C0029c(short s, short s2, char[] cArr, char[] cArr2, byte b2, byte b3, int i, byte b4, byte b5, byte b6, short s3, short s4, short s5, byte b7, byte b8, short s6, short s7, short s8, char[] cArr3, char[] cArr4, byte b9, byte b10, boolean z, int i2) {
        boolean z2;
        if (b2 < 0 || b2 > 3) {
            new StringBuilder("Invalid orientation value: ").append((int) b2);
            b2 = 0;
            z2 = true;
        } else {
            z2 = z;
        }
        if (b3 < 0 || b3 > 3) {
            new StringBuilder("Invalid touchscreen value: ").append((int) b3);
            b3 = 0;
            z2 = true;
        }
        if (i < -1) {
            new StringBuilder("Invalid density value: ").append(i);
            i = 0;
            z2 = true;
        }
        if (b4 < 0 || b4 > 3) {
            new StringBuilder("Invalid keyboard value: ").append((int) b4);
            b4 = 0;
            z2 = true;
        }
        if (b5 < 0 || b5 > 4) {
            new StringBuilder("Invalid navigation value: ").append((int) b5);
            b5 = 0;
            z2 = true;
        }
        cArr3 = (cArr3 == null || cArr3.length == 0 || cArr3[0] == 0) ? null : cArr3;
        cArr4 = (cArr4 == null || cArr4.length == 0 || cArr4[0] == 0) ? null : cArr4;
        this.f39b = s;
        this.f40c = s2;
        this.f41d = cArr;
        this.f42e = cArr2;
        this.f43f = b2;
        this.f44g = b3;
        this.f45h = i;
        this.f46i = b4;
        this.f47j = b5;
        this.f48k = b6;
        this.f49l = s3;
        this.f50m = s4;
        this.f51n = s5;
        this.f52o = b7;
        this.f53p = b8;
        this.f54q = s6;
        this.f55r = s7;
        this.f56s = s8;
        this.f57t = cArr3;
        this.f58u = cArr4;
        this.f59v = b9;
        this.f60w = b10;
        this.f38a = z2;
        this.f62y = i2;
        StringBuilder sb = new StringBuilder();
        if (this.f39b != 0) {
            sb.append("-mcc").append(String.format("%03d", Short.valueOf(this.f39b)));
            if (this.f40c == -1) {
                sb.append("-mnc00");
            } else if (this.f40c != 0) {
                sb.append("-mnc");
                if (this.f62y > 32) {
                    sb.append((int) this.f40c);
                } else if (this.f40c <= 0 || this.f40c >= 10) {
                    sb.append(String.format("%03d", Short.valueOf(this.f40c)));
                } else {
                    sb.append(String.format("%02d", Short.valueOf(this.f40c)));
                }
            }
        } else if (this.f40c != 0) {
            sb.append("-mnc").append((int) this.f40c);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f58u == null && this.f57t == null && ((this.f42e[0] != 0 || this.f41d[0] != 0) && this.f42e.length != 3)) {
            sb2.append("-").append(this.f41d);
            if (this.f42e[0] != 0) {
                sb2.append("-r").append(this.f42e);
            }
        } else if (this.f41d[0] != 0 || this.f42e[0] != 0) {
            sb2.append("-b+");
            if (this.f41d[0] != 0) {
                sb2.append(this.f41d);
            }
            if (this.f57t != null && this.f57t.length == 4) {
                sb2.append("+").append(this.f57t);
            }
            if ((this.f42e.length == 2 || this.f42e.length == 3) && this.f42e[0] != 0) {
                sb2.append("+").append(this.f42e);
            }
            if (this.f58u != null && this.f58u.length >= 5) {
                sb2.append("+").append(m41a(this.f58u));
            }
        }
        sb.append(sb2.toString());
        switch (this.f52o & 192) {
            case 64:
                sb.append("-ldltr");
                break;
            case 128:
                sb.append("-ldrtl");
                break;
        }
        if (this.f54q != 0) {
            sb.append("-sw").append((int) this.f54q).append("dp");
        }
        if (this.f55r != 0) {
            sb.append("-w").append((int) this.f55r).append("dp");
        }
        if (this.f56s != 0) {
            sb.append("-h").append((int) this.f56s).append("dp");
        }
        switch (this.f52o & Token.LITERAL3) {
            case 1:
                sb.append("-small");
                break;
            case 2:
                sb.append("-normal");
                break;
            case 3:
                sb.append("-large");
                break;
            case 4:
                sb.append("-xlarge");
                break;
        }
        switch (this.f52o & 48) {
            case 16:
                sb.append("-notlong");
                break;
            case 32:
                sb.append("-long");
                break;
        }
        switch (this.f59v & 3) {
            case 1:
                sb.append("-notround");
                break;
            case 2:
                sb.append("-round");
                break;
        }
        switch (this.f60w & 12) {
            case 4:
                sb.append("-lowdr");
                break;
            case 8:
                sb.append("-highdr");
                break;
        }
        switch (this.f60w & 3) {
            case 1:
                sb.append("-nowidecg");
                break;
            case 2:
                sb.append("-widecg");
                break;
        }
        switch (this.f43f) {
            case 1:
                sb.append("-port");
                break;
            case 2:
                sb.append("-land");
                break;
            case 3:
                sb.append("-square");
                break;
        }
        switch (this.f53p & Token.LITERAL3) {
            case 2:
                sb.append("-desk");
                break;
            case 3:
                sb.append("-car");
                break;
            case 4:
                sb.append("-television");
                break;
            case 5:
                sb.append("-appliance");
                break;
            case 6:
                sb.append("-watch");
                break;
            case 7:
                sb.append("-vrheadset");
                break;
            case 11:
                sb.append("-godzillaui");
                break;
            case 12:
                sb.append("-smallui");
                break;
            case 13:
                sb.append("-mediumui");
                break;
            case 14:
                sb.append("-largeui");
                break;
            case 15:
                sb.append("-hugeui");
                break;
        }
        switch (this.f53p & 48) {
            case 16:
                sb.append("-notnight");
                break;
            case 32:
                sb.append("-night");
                break;
        }
        switch (this.f45h) {
            case 0:
                break;
            case 120:
                sb.append("-ldpi");
                break;
            case 160:
                sb.append("-mdpi");
                break;
            case 213:
                sb.append("-tvdpi");
                break;
            case 240:
                sb.append("-hdpi");
                break;
            case 320:
                sb.append("-xhdpi");
                break;
            case 480:
                sb.append("-xxhdpi");
                break;
            case 640:
                sb.append("-xxxhdpi");
                break;
            case 65534:
                sb.append("-anydpi");
                break;
            case SupportMenu.USER_MASK /* 65535 */:
                sb.append("-nodpi");
                break;
            default:
                sb.append('-').append(this.f45h).append("dpi");
                break;
        }
        switch (this.f44g) {
            case 1:
                sb.append("-notouch");
                break;
            case 2:
                sb.append("-stylus");
                break;
            case 3:
                sb.append("-finger");
                break;
        }
        switch (this.f48k & 3) {
            case 1:
                sb.append("-keysexposed");
                break;
            case 2:
                sb.append("-keyshidden");
                break;
            case 3:
                sb.append("-keyssoft");
                break;
        }
        switch (this.f46i) {
            case 1:
                sb.append("-nokeys");
                break;
            case 2:
                sb.append("-qwerty");
                break;
            case 3:
                sb.append("-12key");
                break;
        }
        switch (this.f48k & 12) {
            case 4:
                sb.append("-navexposed");
                break;
            case 8:
                sb.append("-navhidden");
                break;
        }
        switch (this.f47j) {
            case 1:
                sb.append("-nonav");
                break;
            case 2:
                sb.append("-dpad");
                break;
            case 3:
                sb.append("-trackball");
                break;
            case 4:
                sb.append("-wheel");
                break;
        }
        if (this.f49l != 0 && this.f50m != 0) {
            if (this.f49l > this.f50m) {
                sb.append(String.format("-%dx%d", Short.valueOf(this.f49l), Short.valueOf(this.f50m)));
            } else {
                sb.append(String.format("-%dx%d", Short.valueOf(this.f50m), Short.valueOf(this.f49l)));
            }
        }
        if (this.f51n > 0) {
            if (this.f51n >= (((this.f53p & Token.LITERAL3) != 7 && (this.f60w & 3) == 0 && (this.f60w & 12) == 0) ? (this.f59v & 3) != 0 ? (short) 23 : this.f45h == 65534 ? (short) 21 : (this.f54q == 0 && this.f55r == 0 && this.f56s == 0) ? (this.f53p & 63) != 0 ? (short) 8 : ((this.f52o & 63) == 0 && this.f45h == 0) ? (short) 0 : (short) 4 : (short) 13 : (short) 26)) {
                sb.append("-v").append((int) this.f51n);
            }
        }
        if (this.f38a) {
            StringBuilder sbAppend = sb.append("-ERR");
            int i3 = f37z;
            f37z = i3 + 1;
            sbAppend.append(i3);
        }
        this.f61x = sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private static String m41a(char[] cArr) {
        StringBuilder sb = new StringBuilder();
        for (char c : cArr) {
            sb.append(Character.toUpperCase(c));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public final String m42a() {
        return this.f61x;
    }

    public final boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            return this.f61x.equals(((C0029c) obj).f61x);
        }
        return false;
    }

    public final int hashCode() {
        return this.f61x.hashCode() + 527;
    }

    public final String toString() {
        return !this.f61x.equals("") ? this.f61x : "[DEFAULT]";
    }
}
