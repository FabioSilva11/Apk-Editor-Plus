package p000a.p011d;

import android.support.v7.appcompat.C0299R;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: renamed from: a.d.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0076h implements XmlSerializer {

    /* JADX INFO: renamed from: b */
    private int f205b;

    /* JADX INFO: renamed from: c */
    private Writer f206c;

    /* JADX INFO: renamed from: d */
    private boolean f207d;

    /* JADX INFO: renamed from: e */
    private int f208e;

    /* JADX INFO: renamed from: f */
    private int f209f;

    /* JADX INFO: renamed from: k */
    private String f214k;

    /* JADX INFO: renamed from: a */
    private final char[] f204a = new char[8192];

    /* JADX INFO: renamed from: g */
    private String[] f210g = new String[12];

    /* JADX INFO: renamed from: h */
    private int[] f211h = new int[4];

    /* JADX INFO: renamed from: i */
    private String[] f212i = new String[8];

    /* JADX INFO: renamed from: j */
    private boolean[] f213j = new boolean[4];

    /* JADX INFO: renamed from: a */
    private final String m193a(String str, boolean z, boolean z2) throws IOException {
        String string;
        String str2;
        for (int i = (this.f211h[this.f209f + 1] << 1) - 2; i >= 0; i -= 2) {
            if (this.f212i[i + 1].equals(str) && (z || !this.f212i[i].isEmpty())) {
                String str3 = this.f212i[i];
                int i2 = i + 2;
                while (true) {
                    if (i2 >= (this.f211h[this.f209f + 1] << 1)) {
                        str2 = str3;
                        break;
                    }
                    if (this.f212i[i2].equals(str3)) {
                        str2 = null;
                        break;
                    }
                    i2++;
                }
                if (str2 != null) {
                    return str2;
                }
            }
        }
        if (!z2) {
            return null;
        }
        if (str.isEmpty()) {
            string = "";
        } else {
            do {
                StringBuilder sb = new StringBuilder("n");
                int i3 = this.f208e;
                this.f208e = i3 + 1;
                string = sb.append(i3).toString();
                int i4 = (this.f211h[this.f209f + 1] << 1) - 2;
                while (true) {
                    if (i4 < 0) {
                        break;
                    }
                    if (string.equals(this.f212i[i4])) {
                        string = null;
                        break;
                    }
                    i4 -= 2;
                }
            } while (string == null);
        }
        boolean z3 = this.f207d;
        this.f207d = false;
        setPrefix(string, str);
        this.f207d = z3;
        return string;
    }

    /* JADX INFO: renamed from: a */
    private final void m194a() throws IOException {
        if (this.f205b > 0) {
            this.f206c.write(this.f204a, 0, this.f205b);
            this.f206c.flush();
            this.f205b = 0;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m195a(char c) throws IOException {
        if (this.f205b >= 8192) {
            m194a();
        }
        char[] cArr = this.f204a;
        int i = this.f205b;
        this.f205b = i + 1;
        cArr[i] = c;
    }

    /* JADX INFO: renamed from: a */
    private void m196a(String str) throws IOException {
        int length = str.length();
        int i = 0;
        while (length > 0) {
            if (this.f205b == 8192) {
                m194a();
            }
            int i2 = 8192 - this.f205b;
            if (i2 > length) {
                i2 = length;
            }
            str.getChars(i, i + i2, this.f204a, this.f205b);
            i += i2;
            length -= i2;
            this.f205b = i2 + this.f205b;
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m197a(String str, int i) throws IOException {
        int i2 = 0;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            switch (cCharAt) {
                case '\t':
                case '\n':
                case '\r':
                    if (i != -1) {
                        m196a("&#" + ((int) cCharAt) + ';');
                    }
                    i2++;
                    break;
                case '&':
                    if (i2 + 4 < str.length() && str.charAt(i2 + 1) == 'a' && str.charAt(i2 + 2) == 'm' && str.charAt(i2 + 3) == 'p' && str.charAt(i2 + 4) == ';') {
                        i2 += 4;
                        m196a("&amp;");
                        continue;
                    } else if (i2 + 3 < str.length() && str.charAt(i2 + 1) == 'l' && str.charAt(i2 + 2) == 't' && str.charAt(i2 + 3) == ';') {
                        i2 += 3;
                        m196a("&lt;");
                    } else {
                        m196a("&amp;");
                    }
                    i2++;
                    break;
                case C0299R.styleable.AppCompatTheme_toolbarStyle /* 60 */:
                    m196a("&lt;");
                    continue;
                    i2++;
                    break;
                default:
                    if (cCharAt == i) {
                        m196a(cCharAt == '\"' ? "&quot;" : "&apos;");
                        continue;
                    }
                    i2++;
                    break;
            }
            m195a(cCharAt);
            i2++;
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m198a(boolean z) throws IOException {
        if (this.f207d) {
            this.f209f++;
            this.f207d = false;
            if (this.f213j.length <= this.f209f) {
                boolean[] zArr = new boolean[this.f209f + 4];
                System.arraycopy(this.f213j, 0, zArr, 0, this.f209f);
                this.f213j = zArr;
            }
            this.f213j[this.f209f] = this.f213j[this.f209f - 1];
            for (int i = this.f211h[this.f209f - 1]; i < this.f211h[this.f209f]; i++) {
                m196a(" xmlns");
                if (!this.f212i[i << 1].isEmpty()) {
                    m195a(':');
                    m196a(this.f212i[i << 1]);
                } else if (getNamespace().isEmpty() && !this.f212i[(i << 1) + 1].isEmpty()) {
                    throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                }
                m196a("=\"");
                m197a(this.f212i[(i << 1) + 1], 34);
                m195a('\"');
            }
            if (this.f211h.length <= this.f209f + 1) {
                int[] iArr = new int[this.f209f + 8];
                System.arraycopy(this.f211h, 0, iArr, 0, this.f209f + 1);
                this.f211h = iArr;
            }
            this.f211h[this.f209f + 1] = this.f211h[this.f209f];
            if (z) {
                m196a(" />");
            } else {
                m195a('>');
            }
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer attribute(String str, String str2, String str3) throws IOException {
        if (!this.f207d) {
            throw new IllegalStateException("illegal position for attribute");
        }
        if (str == null) {
            str = "";
        }
        String strM193a = str.isEmpty() ? "" : m193a(str, false, true);
        m195a(' ');
        if (!strM193a.isEmpty()) {
            m196a(strM193a);
            m195a(':');
        }
        m196a(str2);
        m195a('=');
        char c = str3.indexOf(34) == -1 ? '\"' : '\'';
        m195a(c);
        m197a(str3, c);
        m195a(c);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void cdsect(String str) throws IOException {
        m198a(false);
        String strReplace = str.replace("]]>", "]]]]><![CDATA[>");
        m196a("<![CDATA[");
        int i = 0;
        while (i < strReplace.length()) {
            char cCharAt = strReplace.charAt(i);
            if ((cCharAt >= ' ' && cCharAt <= 55295) || cCharAt == '\t' || cCharAt == '\n' || cCharAt == '\r' || (cCharAt >= 57344 && cCharAt <= 65533)) {
                m195a(cCharAt);
            } else if (!Character.isHighSurrogate(cCharAt) || i >= strReplace.length() - 1) {
                Log.e("APKEDITOR", "Illegal character (U+" + Integer.toHexString(cCharAt) + ")");
            } else {
                m196a("]]>");
                i++;
                char cCharAt2 = strReplace.charAt(i);
                if (!Character.isLowSurrogate(cCharAt2)) {
                    throw new IllegalArgumentException("Bad surrogate pair (U+" + Integer.toHexString(cCharAt) + " U+" + Integer.toHexString(cCharAt2) + ")");
                }
                m196a("&#" + Character.toCodePoint(cCharAt, cCharAt2) + ";");
                m196a("<![CDATA[");
            }
            i++;
        }
        m196a("]]>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void comment(String str) throws IOException {
        m198a(false);
        m196a("<!--");
        m196a(str);
        m196a("-->");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void docdecl(String str) throws IOException {
        m196a("<!DOCTYPE");
        m196a(str);
        m195a('>');
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void endDocument() throws IOException {
        while (this.f209f > 0) {
            endTag(this.f210g[(this.f209f * 3) - 3], this.f210g[(this.f209f * 3) - 1]);
        }
        flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer endTag(String str, String str2) throws IOException {
        if (!this.f207d) {
            this.f209f--;
        }
        if ((str == null && this.f210g[this.f209f * 3] != null) || ((str != null && !str.equals(this.f210g[this.f209f * 3])) || !this.f210g[(this.f209f * 3) + 2].equals(str2))) {
            throw new IllegalArgumentException("</{" + str + "}" + str2 + "> does not match start");
        }
        if (this.f207d) {
            m198a(true);
            this.f209f--;
        } else {
            if (this.f213j[this.f209f + 1]) {
                m196a("\r\n");
                for (int i = 0; i < this.f209f; i++) {
                    m196a("  ");
                }
            }
            m196a("</");
            String str3 = this.f210g[(this.f209f * 3) + 1];
            if (!str3.isEmpty()) {
                m196a(str3);
                m195a(':');
            }
            m196a(str2);
            m195a('>');
        }
        this.f211h[this.f209f + 1] = this.f211h[this.f209f];
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void entityRef(String str) throws IOException {
        m198a(false);
        m195a('&');
        m196a(str);
        m195a(';');
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void flush() throws IOException {
        m198a(false);
        m194a();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final int getDepth() {
        return this.f207d ? this.f209f + 1 : this.f209f;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final boolean getFeature(String str) {
        if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(str)) {
            return this.f213j[this.f209f];
        }
        return false;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final String getName() {
        if (getDepth() == 0) {
            return null;
        }
        return this.f210g[(getDepth() * 3) - 1];
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final String getNamespace() {
        if (getDepth() == 0) {
            return null;
        }
        return this.f210g[(getDepth() * 3) - 3];
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final String getPrefix(String str, boolean z) {
        try {
            return m193a(str, false, z);
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final Object getProperty(String str) {
        throw new RuntimeException("Unsupported property");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void ignorableWhitespace(String str) throws IOException {
        m198a(false);
        this.f213j[this.f209f] = false;
        m196a(str);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void processingInstruction(String str) throws IOException {
        m198a(false);
        m196a("<?");
        m196a(str);
        m196a("?>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setFeature(String str, boolean z) {
        if (!"http://xmlpull.org/v1/doc/features.html#indent-output".equals(str)) {
            throw new RuntimeException("Unsupported Feature");
        }
        this.f213j[this.f209f] = z;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setOutput(OutputStream outputStream, String str) {
        if (outputStream == null) {
            throw new IllegalArgumentException("os == null");
        }
        setOutput(str == null ? new OutputStreamWriter(outputStream) : new OutputStreamWriter(outputStream, str));
        this.f214k = str;
        if (str != null) {
            str.toLowerCase(Locale.US).startsWith("utf");
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setOutput(Writer writer) {
        this.f206c = writer;
        this.f211h[0] = 2;
        this.f211h[1] = 2;
        this.f212i[0] = "";
        this.f212i[1] = "";
        this.f212i[2] = "xml";
        this.f212i[3] = "http://www.w3.org/XML/1998/namespace";
        this.f207d = false;
        this.f208e = 0;
        this.f209f = 0;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setPrefix(String str, String str2) throws IOException {
        m198a(false);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str.equals(m193a(str2, true, false))) {
            return;
        }
        int[] iArr = this.f211h;
        int i = this.f209f + 1;
        int i2 = iArr[i];
        iArr[i] = i2 + 1;
        int i3 = i2 << 1;
        if (this.f212i.length < i3 + 1) {
            String[] strArr = new String[this.f212i.length + 16];
            System.arraycopy(this.f212i, 0, strArr, 0, i3);
            this.f212i = strArr;
        }
        this.f212i[i3] = str;
        this.f212i[i3 + 1] = str2;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setProperty(String str, Object obj) {
        throw new RuntimeException("Unsupported Property:" + obj);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void startDocument(String str, Boolean bool) throws IOException {
        m196a("<?xml version=\"1.0\" ");
        if (str != null) {
            this.f214k = str;
            str.toLowerCase(Locale.US).startsWith("utf");
        }
        if (this.f214k != null) {
            m196a("encoding=\"");
            m196a(this.f214k);
            m196a("\" ");
        }
        if (bool != null) {
            m196a("standalone='");
            m196a(bool.booleanValue() ? "yes" : "no");
            m196a("' ");
        }
        m196a("?>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer startTag(String str, String str2) throws IOException {
        m198a(false);
        if (this.f213j[this.f209f]) {
            m196a("\r\n");
            for (int i = 0; i < this.f209f; i++) {
                m196a("  ");
            }
        }
        int i2 = this.f209f * 3;
        if (this.f210g.length < i2 + 3) {
            String[] strArr = new String[this.f210g.length + 12];
            System.arraycopy(this.f210g, 0, strArr, 0, i2);
            this.f210g = strArr;
        }
        String strM193a = str == null ? "" : m193a(str, true, true);
        if (str != null && str.isEmpty()) {
            for (int i3 = this.f211h[this.f209f]; i3 < this.f211h[this.f209f + 1]; i3++) {
                if (this.f212i[i3 << 1].isEmpty() && !this.f212i[(i3 << 1) + 1].isEmpty()) {
                    throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                }
            }
        }
        int i4 = i2 + 1;
        this.f210g[i2] = str;
        this.f210g[i4] = strM193a;
        this.f210g[i4 + 1] = str2;
        m195a('<');
        if (!strM193a.isEmpty()) {
            m196a(strM193a);
            m195a(':');
        }
        m196a(str2);
        this.f207d = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer text(String str) throws IOException {
        m198a(false);
        this.f213j[this.f209f] = false;
        m197a(str, -1);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer text(char[] cArr, int i, int i2) throws IOException {
        text(new String(cArr, i, i2));
        return this;
    }
}
