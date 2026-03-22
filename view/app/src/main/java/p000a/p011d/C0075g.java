package p000a.p011d;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: renamed from: a.d.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0075g implements XmlSerializer {

    /* JADX INFO: renamed from: a */
    private static final String[] f192a = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};

    /* JADX INFO: renamed from: c */
    private int f194c;

    /* JADX INFO: renamed from: d */
    private Writer f195d;

    /* JADX INFO: renamed from: e */
    private OutputStream f196e;

    /* JADX INFO: renamed from: f */
    private CharsetEncoder f197f;

    /* JADX INFO: renamed from: h */
    private boolean f199h;

    /* JADX INFO: renamed from: j */
    private C0078j f201j;

    /* JADX INFO: renamed from: k */
    private boolean f202k;

    /* JADX INFO: renamed from: l */
    private boolean f203l;
    private boolean tab;

    /* JADX INFO: renamed from: b */
    private final char[] f193b = new char[8192];

    /* JADX INFO: renamed from: g */
    private ByteBuffer f198g = ByteBuffer.allocate(8192);

    /* JADX INFO: renamed from: i */
    private int f200i = 0;

    /* JADX INFO: renamed from: a */
    private void m185a() throws IOException {
        int iPosition = this.f198g.position();
        if (iPosition > 0) {
            this.f198g.flip();
            this.f196e.write(this.f198g.array(), 0, iPosition);
            this.f198g.clear();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m186a(char c) throws IOException {
        int i = this.f194c;
        if (i >= 8191) {
            flush();
            i = this.f194c;
        }
        this.f193b[i] = c;
        this.f194c = i + 1;
    }

    /* JADX INFO: renamed from: a */
    private void m187a(String str) throws IOException {
        m188a(str, 0, str.length());
    }

    /* JADX INFO: renamed from: a */
    private void m188a(String str, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i + i2;
            while (i < i3) {
                int i4 = i + 8192;
                m188a(str, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f194c;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f194c;
        }
        str.getChars(i, i + i2, this.f193b, i5);
        this.f194c = i5 + i2;
    }

    /* JADX INFO: renamed from: a */
    private void m189a(char[] cArr, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i + i2;
            while (i < i3) {
                int i4 = i + 8192;
                m189a(cArr, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f194c;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f194c;
        }
        System.arraycopy(cArr, i, this.f193b, i5, i2);
        this.f194c = i5 + i2;
    }

    /* JADX INFO: renamed from: b */
    private void m190b(String str) throws IOException {
        String str2;
        int i = 0;
        int length = str.length();
        String[] strArr = f192a;
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < '@' && (str2 = strArr[cCharAt]) != null) {
                if (i < i2) {
                    m188a(str, i, i2 - i);
                }
                i = i2 + 1;
                m187a(str2);
            }
            i2++;
        }
        if (i < i2) {
            m188a(str, i, i2 - i);
        }
    }

    private String replace(String str) {
        return str.replace("\\\"", "\"");
    }

    /* JADX INFO: renamed from: a */
    public final XmlSerializer m191a(String[] strArr, String[] strArr2, String[] strArr3) throws IOException {
        String strM203a;
        int i = 0;
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            String str2 = strArr2[i2];
            String str3 = strArr3[i2];
            if (str != null && !str.equals("") && (strM203a = this.f201j.m203a(this.f200i, str)) != null) {
                str2 = strM203a + ":" + str2;
            }
            arrayList.add(str2);
            map.put(str2, str3);
        }
        Collections.sort(arrayList);
        while (true) {
            int i3 = i;
            if (i3 >= arrayList.size()) {
                return this;
            }
            String str4 = (String) arrayList.get(i3);
            String str5 = (String) map.get(str4);
            m186a(' ');
            m187a(str4);
            m187a("=\"");
            m190b(str5);
            m186a('\"');
            i = i3 + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m192a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
        int namespaceCount = xmlPullParser.getNamespaceCount(xmlPullParser.getDepth());
        for (int namespaceCount2 = xmlPullParser.getNamespaceCount(xmlPullParser.getDepth() - 1); namespaceCount2 != namespaceCount; namespaceCount2++) {
            String namespacePrefix = xmlPullParser.getNamespacePrefix(namespaceCount2);
            String namespaceUri = xmlPullParser.getNamespaceUri(namespaceCount2);
            if (!"".equals(namespacePrefix)) {
                this.f201j.m205a(this.f200i, namespacePrefix, namespaceUri);
                m187a(String.format(" xmlns:%s=\"%s\"", namespacePrefix, namespaceUri));
            }
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer attribute(String str, String str2, String str3) throws IOException {
        if (str3 != null) {
            m186a(' ');
            if (str != null && !str.equals("")) {
                String strM203a = this.f201j.m203a(this.f200i, str);
                if (strM203a != null) {
                    m187a(strM203a);
                    m186a(':');
                } else {
                    int iLastIndexOf = str.lastIndexOf(47);
                    String strSubstring = (iLastIndexOf == -1 || iLastIndexOf == str.length() + (-1)) ? "ns" + new Random(System.currentTimeMillis()).nextInt() : str.substring(iLastIndexOf + 1);
                    this.f201j.m205a(this.f200i, strSubstring, str);
                    m187a("xmlns:");
                    m187a(strSubstring);
                    m187a("=\"");
                    m187a(str);
                    m187a("\" ");
                    m187a(strSubstring);
                    m186a(':');
                }
            }
            m187a(str2);
            m187a("=\"");
            m187a(str3);
            m186a('\"');
        }
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void cdsect(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void comment(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void docdecl(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void endDocument() throws IOException {
        flush();
        this.f196e = null;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer endTag(String str, String str2) throws IOException {
        String strM203a;
        this.f201j.m204a(this.f200i);
        this.f200i--;
        if (this.f199h) {
            m187a(" />\n");
        } else {
            if (!this.tab) {
                for (int i = 0; i < this.f200i; i++) {
                    m186a('\t');
                }
            }
            this.tab = false;
            m187a("</");
            if (str != null && (strM203a = this.f201j.m203a(this.f200i, str)) != null) {
                m187a(strM203a);
                m186a(':');
            }
            m187a(str2);
            m187a(">\n");
        }
        this.f199h = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void entityRef(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void flush() throws IOException {
        if (this.f194c > 0) {
            if (this.f196e != null) {
                CharBuffer charBufferWrap = CharBuffer.wrap(this.f193b, 0, this.f194c);
                CoderResult coderResultEncode = this.f197f.encode(charBufferWrap, this.f198g, true);
                while (!coderResultEncode.isError()) {
                    if (coderResultEncode.isOverflow()) {
                        m185a();
                        coderResultEncode = this.f197f.encode(charBufferWrap, this.f198g, true);
                    } else {
                        m185a();
                        this.f196e.flush();
                    }
                }
                throw new IOException(coderResultEncode.toString());
            }
            this.f195d.write(this.f193b, 0, this.f194c);
            this.f195d.flush();
            this.f194c = 0;
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final int getDepth() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final String getName() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final String getNamespace() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final String getPrefix(String str, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void ignorableWhitespace(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void processingInstruction(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setFeature(String str, boolean z) {
        if (!str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setOutput(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.f197f = Charset.forName(str).newEncoder();
            this.f196e = outputStream;
        } catch (IllegalCharsetNameException e) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e));
        } catch (UnsupportedCharsetException e2) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setOutput(Writer writer) {
        this.f195d = writer;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setPrefix(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setProperty(String str, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void startDocument(String str, Boolean bool) throws IOException {
        this.tab = false;
        this.f203l = false;
        this.f202k = false;
        this.f201j = new C0078j();
        this.f200i = 0;
        this.f194c = 0;
        this.f199h = false;
        if (bool != null) {
            m187a("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"" + (bool.booleanValue() ? "yes" : "no") + "\" ?>\n");
        } else {
            m187a("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer startTag(String str, String str2) throws IOException {
        String strM203a;
        if (this.f199h) {
            m187a(">\n");
        }
        for (int i = 0; i < this.f200i; i++) {
            m186a('\t');
        }
        m186a('<');
        if (str != null && (strM203a = this.f201j.m203a(this.f200i, str)) != null) {
            m187a(strM203a);
            m186a(':');
        }
        m187a(str2);
        this.f199h = true;
        this.f200i++;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer text(String str) throws IOException {
        String strReplace = replace(str);
        this.tab = true;
        if (this.f199h) {
            m187a(">");
            this.f199h = false;
        }
        this.f203l = false;
        this.f202k = false;
        int i = 0;
        for (int i2 = 0; i2 < strReplace.length(); i2++) {
            char cCharAt = strReplace.charAt(i2);
            if (cCharAt != ']') {
                if (cCharAt == '&') {
                    if (i2 >= strReplace.length() - 3 || strReplace.charAt(i2 + 1) != 'l' || strReplace.charAt(i2 + 2) != 't' || strReplace.charAt(i2 + 3) != ';') {
                        if (i2 > i) {
                            m187a(strReplace.substring(i, i2));
                        }
                        m187a("&amp;");
                        i = i2 + 1;
                    }
                } else if (cCharAt == '<') {
                    if (i2 > i) {
                        m187a(strReplace.substring(i, i2));
                    }
                    m187a("&lt;");
                    i = i2 + 1;
                } else if (this.f203l && cCharAt == '>') {
                    if (i2 > i) {
                        m187a(strReplace.substring(i, i2));
                    }
                    m187a("&gt;");
                    i = i2 + 1;
                }
                if (this.f202k) {
                    this.f202k = false;
                    this.f203l = false;
                }
            } else if (this.f202k) {
                this.f203l = true;
            } else {
                this.f202k = true;
            }
        }
        if (i > 0) {
            m187a(strReplace.substring(i));
        } else {
            m187a(strReplace);
        }
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer text(char[] cArr, int i, int i2) throws IOException {
        if (this.f199h) {
            m187a(">");
            this.f199h = false;
        }
        this.f203l = false;
        this.f202k = false;
        int i3 = i + i2;
        int i4 = i;
        while (i < i3) {
            char c = cArr[i];
            if (c != ']') {
                if (c == '&') {
                    if (i > i4) {
                        m189a(cArr, i4, i - i4);
                    }
                    m187a("&amp;");
                    i4 = i + 1;
                } else if (c == '<') {
                    if (i > i4) {
                        m189a(cArr, i4, i - i4);
                    }
                    m187a("&lt;");
                    i4 = i + 1;
                } else if (this.f203l && c == '>') {
                    if (i > i4) {
                        m189a(cArr, i4, i - i4);
                    }
                    m187a("&gt;");
                    i4 = i + 1;
                }
                if (this.f202k) {
                    this.f202k = false;
                    this.f203l = false;
                }
            } else if (this.f202k) {
                this.f203l = true;
            } else {
                this.f202k = true;
            }
            i++;
        }
        if (i3 > i4) {
            m189a(cArr, i4, i3 - i4);
        }
        return this;
    }
}
