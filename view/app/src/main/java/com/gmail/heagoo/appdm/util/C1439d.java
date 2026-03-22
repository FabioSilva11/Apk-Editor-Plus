package com.gmail.heagoo.appdm.util;

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
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.util.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1439d implements XmlSerializer {

    /* JADX INFO: renamed from: a */
    private static final String[] f4235a = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};

    /* JADX INFO: renamed from: c */
    private int f4237c;

    /* JADX INFO: renamed from: d */
    private Writer f4238d;

    /* JADX INFO: renamed from: e */
    private OutputStream f4239e;

    /* JADX INFO: renamed from: f */
    private CharsetEncoder f4240f;

    /* JADX INFO: renamed from: h */
    private boolean f4242h;

    /* JADX INFO: renamed from: b */
    private final char[] f4236b = new char[8192];

    /* JADX INFO: renamed from: g */
    private ByteBuffer f4241g = ByteBuffer.allocate(8192);

    /* JADX INFO: renamed from: a */
    private void m3453a() throws IOException {
        int iPosition = this.f4241g.position();
        if (iPosition > 0) {
            this.f4241g.flip();
            this.f4239e.write(this.f4241g.array(), 0, iPosition);
            this.f4241g.clear();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3454a(char c) throws IOException {
        int i = this.f4237c;
        if (i >= 8191) {
            flush();
            i = this.f4237c;
        }
        this.f4236b[i] = c;
        this.f4237c = i + 1;
    }

    /* JADX INFO: renamed from: a */
    private void m3455a(String str) throws IOException {
        m3456a(str, 0, str.length());
    }

    /* JADX INFO: renamed from: a */
    private void m3456a(String str, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i + i2;
            while (i < i3) {
                int i4 = i + 8192;
                m3456a(str, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f4237c;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f4237c;
        }
        str.getChars(i, i + i2, this.f4236b, i5);
        this.f4237c = i5 + i2;
    }

    /* JADX INFO: renamed from: a */
    private void m3457a(char[] cArr, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i + i2;
            while (i < i3) {
                int i4 = i + 8192;
                m3457a(cArr, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f4237c;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f4237c;
        }
        System.arraycopy(cArr, i, this.f4236b, i5, i2);
        this.f4237c = i5 + i2;
    }

    /* JADX INFO: renamed from: b */
    private void m3458b(String str) throws IOException {
        String str2;
        int i = 0;
        int length = str.length();
        String[] strArr = f4235a;
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < '@' && (str2 = strArr[cCharAt]) != null) {
                if (i < i2) {
                    m3456a(str, i, i2 - i);
                }
                i = i2 + 1;
                m3455a(str2);
            }
            i2++;
        }
        if (i < i2) {
            m3456a(str, i, i2 - i);
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer attribute(String str, String str2, String str3) throws IOException {
        m3454a(' ');
        if (str != null) {
            m3455a(str);
            m3454a(':');
        }
        m3455a(str2);
        m3455a("=\"");
        m3458b(str3);
        m3454a('\"');
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
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer endTag(String str, String str2) throws IOException {
        if (this.f4242h) {
            m3455a(" />\n");
        } else {
            m3455a("</");
            if (str != null) {
                m3455a(str);
                m3454a(':');
            }
            m3455a(str2);
            m3455a(">\n");
        }
        this.f4242h = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void entityRef(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void flush() throws IOException {
        if (this.f4237c > 0) {
            if (this.f4239e != null) {
                CharBuffer charBufferWrap = CharBuffer.wrap(this.f4236b, 0, this.f4237c);
                CoderResult coderResultEncode = this.f4240f.encode(charBufferWrap, this.f4241g, true);
                while (!coderResultEncode.isError()) {
                    if (coderResultEncode.isOverflow()) {
                        m3453a();
                        coderResultEncode = this.f4240f.encode(charBufferWrap, this.f4241g, true);
                    } else {
                        m3453a();
                        this.f4239e.flush();
                    }
                }
                throw new IOException(coderResultEncode.toString());
            }
            this.f4238d.write(this.f4236b, 0, this.f4237c);
            this.f4238d.flush();
            this.f4237c = 0;
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
            this.f4240f = Charset.forName(str).newEncoder();
            this.f4239e = outputStream;
        } catch (IllegalCharsetNameException e) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e));
        } catch (UnsupportedCharsetException e2) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setOutput(Writer writer) {
        this.f4238d = writer;
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
        m3455a("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"" + (bool.booleanValue() ? "yes" : "no") + "\" ?>\n");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer startTag(String str, String str2) throws IOException {
        if (this.f4242h) {
            m3455a(">\n");
        }
        m3454a('<');
        if (str != null) {
            m3455a(str);
            m3454a(':');
        }
        m3455a(str2);
        this.f4242h = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer text(String str) throws IOException {
        if (this.f4242h) {
            m3455a(">");
            this.f4242h = false;
        }
        m3458b(str);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer text(char[] cArr, int i, int i2) throws IOException {
        String str;
        if (this.f4242h) {
            m3455a(">");
            this.f4242h = false;
        }
        String[] strArr = f4235a;
        int i3 = i + i2;
        int i4 = i;
        while (i < i3) {
            char c = cArr[i];
            if (c < '@' && (str = strArr[c]) != null) {
                if (i4 < i) {
                    m3457a(cArr, i4, i - i4);
                }
                i4 = i + 1;
                m3455a(str);
            }
            i++;
        }
        if (i4 < i) {
            m3457a(cArr, i4, i - i4);
        }
        return this;
    }
}
