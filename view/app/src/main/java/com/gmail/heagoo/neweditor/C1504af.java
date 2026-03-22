package com.gmail.heagoo.neweditor;

import android.support.v7.appcompat.C0299R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.af */
/* JADX INFO: loaded from: classes.dex */
public class C1504af {

    /* JADX INFO: renamed from: m */
    private static /* synthetic */ boolean f4417m;

    /* JADX INFO: renamed from: b */
    private C1530x f4419b;

    /* JADX INFO: renamed from: c */
    private InterfaceC1503ae f4420c;

    /* JADX INFO: renamed from: d */
    private C1532z f4421d;

    /* JADX INFO: renamed from: e */
    private C1505ag f4422e;

    /* JADX INFO: renamed from: f */
    private C1526t f4423f;

    /* JADX INFO: renamed from: h */
    private int f4425h;

    /* JADX INFO: renamed from: i */
    private int f4426i;

    /* JADX INFO: renamed from: j */
    private int f4427j;

    /* JADX INFO: renamed from: k */
    private int f4428k;

    /* JADX INFO: renamed from: l */
    private boolean f4429l;

    /* JADX INFO: renamed from: a */
    private final Map f4418a = new Hashtable(64);

    /* JADX INFO: renamed from: g */
    private final C1532z f4424g = new C1532z();

    static {
        f4417m = !C1504af.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    private byte m3609a(C1529w c1529w, C1529w c1529w2) {
        switch (c1529w.f4522f) {
            case -2:
                return c1529w2.f4526j;
            case -1:
                return this.f4422e.f4433c.m3692j();
            default:
                return c1529w.f4522f;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3610a() {
        C1529w c1529w;
        if (this.f4422e.f4431a == null || (c1529w = this.f4422e.f4431a.f4432b) == null || (this.f4422e.f4431a.f4432b.f4517a & 1024) == 0) {
            return;
        }
        if (this.f4427j != this.f4425h) {
            this.f4420c.mo3608a(c1529w.f4526j, this.f4425h - this.f4421d.f4547c, this.f4427j - this.f4425h, this.f4422e);
        }
        this.f4425h = this.f4427j;
        this.f4422e = this.f4422e.f4431a;
        this.f4423f = this.f4422e.f4433c.m3688f();
        this.f4422e.m3621a(null);
    }

    /* JADX INFO: renamed from: a */
    private void m3611a(InterfaceC1503ae interfaceC1503ae, byte b2, int i, int i2, C1505ag c1505ag) {
        int i3 = i + i2;
        int i4 = i;
        while (i < i3) {
            if (Character.isWhitespace(this.f4421d.f4545a[this.f4421d.f4547c + i])) {
                if (i4 != i) {
                    interfaceC1503ae.mo3608a(b2, i4, i - i4, c1505ag);
                }
                interfaceC1503ae.mo3608a(b2, i, 1, c1505ag);
                i4 = i + 1;
            }
            i++;
        }
        if (i4 != i3) {
            interfaceC1503ae.mo3608a(b2, i4, i3 - i4, c1505ag);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3612a(boolean z) {
        byte bM3655a;
        int i = this.f4427j - this.f4425h;
        if (i == 0) {
            return;
        }
        if (this.f4422e.f4433c.m3689g()) {
            boolean z2 = false;
            boolean zMatches = false;
            for (int i2 = this.f4425h; i2 < this.f4427j; i2++) {
                if (Character.isDigit(this.f4421d.f4545a[i2])) {
                    zMatches = true;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                Pattern patternM3690h = this.f4422e.f4433c.m3690h();
                if (zMatches) {
                    if (patternM3690h == null) {
                        zMatches = false;
                    } else {
                        int i3 = this.f4421d.f4546b;
                        int i4 = this.f4421d.f4547c;
                        this.f4421d.f4547c = this.f4425h;
                        this.f4421d.f4546b = i;
                        zMatches = patternM3690h.matcher(new C1499aa(this.f4421d)).matches();
                        this.f4421d.f4547c = i4;
                        this.f4421d.f4546b = i3;
                    }
                }
            }
            if (zMatches) {
                this.f4420c.mo3608a((byte) 5, this.f4425h - this.f4421d.f4547c, i, this.f4422e);
                this.f4425h = this.f4427j;
                return;
            }
        }
        if (this.f4423f == null || (bM3655a = this.f4423f.m3655a(this.f4421d, this.f4425h, i)) == 0) {
            if (z) {
                this.f4420c.mo3608a(this.f4422e.f4433c.m3692j(), this.f4425h - this.f4421d.f4547c, i, this.f4422e);
                this.f4425h = this.f4427j;
            }
        } else {
            this.f4420c.mo3608a(bM3655a, this.f4425h - this.f4421d.f4547c, i, this.f4422e);
            this.f4425h = this.f4427j;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3613a(int i, int i2) {
        if ((i2 & 2) == 2) {
            if (i != this.f4421d.f4547c) {
                return false;
            }
        } else if ((i2 & 4) == 4) {
            if (i != this.f4428k) {
                return false;
            }
        } else if ((i2 & 8) == 8 && i != this.f4425h) {
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3614a(C1529w c1529w) {
        int iEnd;
        Matcher matcher;
        C1499aa c1499aa;
        boolean z;
        char[] cArrM3615a = null;
        if (c1529w.f4528l == null) {
            if (c1529w.f4527k != null && this.f4427j + c1529w.f4527k.length < this.f4421d.f4545a.length) {
                int i = 0;
                while (true) {
                    if (i >= c1529w.f4527k.length) {
                        z = true;
                        break;
                    }
                    if (Character.toUpperCase(this.f4421d.f4545a[this.f4427j + i]) != c1529w.f4527k[i]) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (!z) {
                    return false;
                }
            }
        } else if (-1 == Arrays.binarySearch(c1529w.f4528l, Character.toUpperCase(this.f4421d.f4545a[this.f4427j]))) {
            return false;
        }
        if (!m3613a((c1529w.f4517a & 4) != 0 ? this.f4425h : this.f4427j, c1529w.f4524h)) {
            return false;
        }
        if ((c1529w.f4517a & 8192) == 0) {
            this.f4424g.f4545a = c1529w.f4523g;
            this.f4424g.f4547c = 0;
            this.f4424g.f4546b = this.f4424g.f4545a.length;
            iEnd = this.f4424g.f4546b;
            if (!C0985a.m2226a(this.f4422e.f4433c.m3687e(), this.f4421d, this.f4427j, this.f4424g.f4545a)) {
                return false;
            }
            matcher = null;
            c1499aa = null;
        } else {
            C1499aa c1499aa2 = new C1499aa(this.f4421d, this.f4427j - this.f4421d.f4547c, this.f4421d.f4546b - (this.f4427j - this.f4421d.f4547c));
            Matcher matcher2 = c1529w.f4525i.matcher(c1499aa2);
            if (!matcher2.lookingAt()) {
                return false;
            }
            if (matcher2.start() != 0) {
                throw new InternalError("Can't happen");
            }
            iEnd = matcher2.end();
            if (iEnd == 0) {
                matcher = matcher2;
                c1499aa = c1499aa2;
                iEnd = 1;
            } else {
                matcher = matcher2;
                c1499aa = c1499aa2;
            }
        }
        if ((c1529w.f4517a & 2048) == 2048) {
            this.f4427j += this.f4424g.f4546b;
        } else {
            if (this.f4422e.f4432b != null) {
                m3616b(this.f4422e.f4432b);
            }
            m3612a((c1529w.f4517a & 4) != 4);
            switch (c1529w.f4517a & 255) {
                case 0:
                    this.f4422e.f4434d = null;
                    if ((c1529w.f4517a & 8192) != 0) {
                        m3611a(this.f4420c, c1529w.f4526j, this.f4427j - this.f4421d.f4547c, iEnd, this.f4422e);
                    } else {
                        this.f4420c.mo3608a(c1529w.f4526j, this.f4427j - this.f4421d.f4547c, iEnd, this.f4422e);
                    }
                    if (c1529w.f4518b != null) {
                        this.f4422e = new C1505ag(c1529w.f4518b, this.f4422e.f4431a);
                        this.f4423f = this.f4422e.f4433c.m3688f();
                    }
                    break;
                case 2:
                case 16:
                    this.f4422e.m3621a(c1529w);
                    byte bM3609a = m3609a(c1529w, this.f4422e.f4432b);
                    if ((c1529w.f4517a & 8192) != 0) {
                        m3611a(this.f4420c, bM3609a, this.f4427j - this.f4421d.f4547c, iEnd, this.f4422e);
                    } else {
                        this.f4420c.mo3608a(bM3609a, this.f4427j - this.f4421d.f4547c, iEnd, this.f4422e);
                    }
                    if (c1499aa != null && c1529w.f4519c != null) {
                        cArrM3615a = m3615a(matcher, c1529w.f4519c);
                    }
                    this.f4422e.f4434d = cArrM3615a;
                    this.f4422e = new C1505ag(c1529w.f4518b, this.f4422e);
                    this.f4423f = this.f4422e.f4433c.m3688f();
                    break;
                case 4:
                    this.f4422e.f4434d = null;
                    if (this.f4427j != this.f4425h) {
                        this.f4420c.mo3608a(c1529w.f4526j, this.f4425h - this.f4421d.f4547c, this.f4427j - this.f4425h, this.f4422e);
                    }
                    this.f4420c.mo3608a(m3609a(c1529w, c1529w), this.f4427j - this.f4421d.f4547c, this.f4424g.f4546b, this.f4422e);
                    break;
                case 8:
                    this.f4420c.mo3608a(m3609a(c1529w, c1529w), this.f4427j - this.f4421d.f4547c, this.f4424g.f4546b, this.f4422e);
                    this.f4422e.f4434d = null;
                    this.f4422e.m3621a(c1529w);
                    break;
                default:
                    throw new InternalError("Unhandled major action");
            }
            this.f4427j += iEnd - 1;
            this.f4425h = this.f4427j + 1;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static char[] m3615a(Matcher matcher, char[] cArr) {
        char cCharAt;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < cArr.length) {
            char c = cArr[i];
            if (c != '$' && c != '~') {
                sb.append(c);
            } else if (i == cArr.length - 1) {
                sb.append(c);
            } else {
                char c2 = cArr[i + 1];
                if (Character.isDigit(c2)) {
                    if (c == '$') {
                        sb.append(matcher.group(c2 - '0'));
                    } else {
                        String strGroup = matcher.group(c2 - '0');
                        if (strGroup.length() == 1) {
                            switch (strGroup.charAt(0)) {
                                case '(':
                                    cCharAt = ')';
                                    break;
                                case ')':
                                    cCharAt = '(';
                                    break;
                                case C0299R.styleable.AppCompatTheme_toolbarStyle /* 60 */:
                                    cCharAt = '>';
                                    break;
                                case C0299R.styleable.AppCompatTheme_popupMenuStyle /* 62 */:
                                    cCharAt = '<';
                                    break;
                                case C0299R.styleable.AppCompatTheme_colorButtonNormal /* 91 */:
                                    cCharAt = ']';
                                    break;
                                case C0299R.styleable.AppCompatTheme_controlBackground /* 93 */:
                                    cCharAt = '[';
                                    break;
                                case '{':
                                    cCharAt = '}';
                                    break;
                                case '}':
                                    cCharAt = '{';
                                    break;
                                default:
                                    cCharAt = 0;
                                    break;
                            }
                            if (cCharAt == 0) {
                                cCharAt = strGroup.charAt(0);
                            }
                            sb.append(cCharAt);
                        } else {
                            sb.append(c);
                        }
                    }
                    i++;
                } else {
                    sb.append(c);
                }
            }
            i++;
        }
        char[] cArr2 = new char[sb.length()];
        sb.getChars(0, sb.length(), cArr2, 0);
        return cArr2;
    }

    /* JADX INFO: renamed from: b */
    private boolean m3616b(C1529w c1529w) {
        if (!m3613a((c1529w.f4517a & 4) != 0 ? this.f4425h : this.f4427j, c1529w.f4520d)) {
            return false;
        }
        if ((c1529w.f4517a & 8) == 0) {
            if (this.f4422e.f4434d != null) {
                this.f4424g.f4545a = this.f4422e.f4434d;
            } else {
                this.f4424g.f4545a = c1529w.f4519c;
            }
            this.f4424g.f4547c = 0;
            this.f4424g.f4546b = this.f4424g.f4545a.length;
            if (!C0985a.m2226a(this.f4422e.f4433c.m3687e(), this.f4421d, this.f4427j, this.f4424g.f4545a)) {
                return false;
            }
        }
        if (!f4417m && (c1529w.f4517a & 2048) != 0) {
            throw new AssertionError();
        }
        if ((this.f4422e.f4432b.f4517a & 8) != 0) {
            if (this.f4427j != this.f4425h) {
                this.f4420c.mo3608a(this.f4422e.f4432b.f4526j, this.f4425h - this.f4421d.f4547c, this.f4427j - this.f4425h, this.f4422e);
            }
            this.f4425h = this.f4427j;
            this.f4422e.m3621a(null);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x012a A[Catch: all -> 0x0179, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x001b, B:7:0x002d, B:8:0x004b, B:11:0x0053, B:14:0x005c, B:15:0x007c, B:17:0x0082, B:38:0x0155, B:19:0x008c, B:21:0x0092, B:23:0x009a, B:25:0x00a4, B:27:0x00c8, B:29:0x00ce, B:30:0x00d5, B:37:0x0152, B:32:0x012a, B:33:0x0140, B:35:0x0146, B:45:0x017e, B:47:0x0188, B:49:0x018c, B:50:0x0192, B:52:0x0198, B:53:0x019f, B:55:0x01ac, B:56:0x01c3, B:57:0x01de, B:59:0x01e2, B:61:0x01ec, B:63:0x01fe, B:65:0x0209, B:67:0x020f, B:68:0x0216, B:69:0x0238, B:71:0x0242, B:72:0x0249, B:73:0x0250, B:75:0x0256, B:77:0x025e, B:80:0x0268, B:81:0x027f, B:39:0x015e), top: B:85:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x017c  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.gmail.heagoo.neweditor.C1505ag m3617a(com.gmail.heagoo.neweditor.C1505ag r10, com.gmail.heagoo.neweditor.InterfaceC1503ae r11, com.gmail.heagoo.neweditor.C1532z r12) {
        /*
            Method dump skipped, instruction units count: 673
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.neweditor.C1504af.m3617a(com.gmail.heagoo.neweditor.ag, com.gmail.heagoo.neweditor.ae, com.gmail.heagoo.neweditor.z):com.gmail.heagoo.neweditor.ag");
    }

    /* JADX INFO: renamed from: a */
    public final C1530x m3618a(String str) {
        return (C1530x) this.f4418a.get(str);
    }

    /* JADX INFO: renamed from: a */
    public final void m3619a(C1530x c1530x) {
        this.f4418a.put(c1530x.m3681b(), c1530x);
        if (c1530x.m3681b().equals("MAIN")) {
            this.f4419b = c1530x;
        }
    }
}
