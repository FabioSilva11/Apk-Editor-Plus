package com.gmail.heagoo.p054a.p055a.p056a.p057a;

import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: com.gmail.heagoo.a.a.a.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class XmlResourceParserC0970a implements XmlResourceParser {

    /* JADX INFO: renamed from: a */
    private C0972c f2434a;

    /* JADX INFO: renamed from: c */
    private C0973d f2436c;

    /* JADX INFO: renamed from: d */
    private int[] f2437d;

    /* JADX INFO: renamed from: f */
    private boolean f2439f;

    /* JADX INFO: renamed from: g */
    private int f2440g;

    /* JADX INFO: renamed from: h */
    private int f2441h;

    /* JADX INFO: renamed from: i */
    private int f2442i;

    /* JADX INFO: renamed from: j */
    private int f2443j;

    /* JADX INFO: renamed from: k */
    private int[] f2444k;

    /* JADX INFO: renamed from: l */
    private int f2445l;

    /* JADX INFO: renamed from: m */
    private int f2446m;

    /* JADX INFO: renamed from: n */
    private int f2447n;

    /* JADX INFO: renamed from: b */
    private boolean f2435b = false;

    /* JADX INFO: renamed from: e */
    private C0971b f2438e = new C0971b();

    public XmlResourceParserC0970a() {
        m2122a();
    }

    /* JADX INFO: renamed from: a */
    private final int m2121a(String str, String str2) {
        int iM2153a;
        if (this.f2436c == null || str2 == null || (iM2153a = this.f2436c.m2153a(str2)) == -1) {
            return -1;
        }
        int iM2153a2 = str != null ? this.f2436c.m2153a(str) : -1;
        for (int i = 0; i != this.f2444k.length; i++) {
            if (iM2153a == this.f2444k[i + 1] && (iM2153a2 == -1 || iM2153a2 == this.f2444k[i])) {
                return i / 5;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    private final void m2122a() {
        this.f2440g = -1;
        this.f2441h = -1;
        this.f2442i = -1;
        this.f2443j = -1;
        this.f2444k = null;
        this.f2445l = -1;
        this.f2446m = -1;
        this.f2447n = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b6, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r1 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ec, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m2123b() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.p054a.p055a.p056a.p057a.XmlResourceParserC0970a.m2123b():void");
    }

    /* JADX INFO: renamed from: c */
    private final int m2124c(int i) {
        if (this.f2440g != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 >= this.f2444k.length) {
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public final int m2125a(int i) {
        return this.f2444k[m2124c(i) + 3];
    }

    /* JADX INFO: renamed from: a */
    public final void m2126a(InputStream inputStream) {
        close();
        if (inputStream != null) {
            this.f2434a = new C0972c(inputStream, false);
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m2127b(int i) {
        return this.f2444k[m2124c(i) + 4];
    }

    @Override // android.content.res.XmlResourceParser, java.lang.AutoCloseable
    public final void close() {
        if (this.f2435b) {
            this.f2435b = false;
            this.f2434a.m2143a();
            this.f2434a = null;
            this.f2436c = null;
            this.f2437d = null;
            this.f2438e.m2131a();
            m2122a();
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void defineEntityReplacementText(String str, String str2) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    @Override // android.util.AttributeSet
    public final boolean getAttributeBooleanValue(int i, boolean z) {
        return getAttributeIntValue(i, z ? 1 : 0) != 0;
    }

    @Override // android.util.AttributeSet
    public final boolean getAttributeBooleanValue(String str, String str2, boolean z) {
        int iM2121a = m2121a(str, str2);
        return iM2121a == -1 ? z : getAttributeBooleanValue(iM2121a, z);
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final int getAttributeCount() {
        if (this.f2440g != 2) {
            return -1;
        }
        return this.f2444k.length / 5;
    }

    @Override // android.util.AttributeSet
    public final float getAttributeFloatValue(int i, float f) {
        int iM2124c = m2124c(i);
        return this.f2444k[iM2124c + 3] == 4 ? Float.intBitsToFloat(this.f2444k[iM2124c + 4]) : f;
    }

    @Override // android.util.AttributeSet
    public final float getAttributeFloatValue(String str, String str2, float f) {
        int iM2121a = m2121a(str, str2);
        return iM2121a == -1 ? f : getAttributeFloatValue(iM2121a, f);
    }

    @Override // android.util.AttributeSet
    public final int getAttributeIntValue(int i, int i2) {
        int iM2124c = m2124c(i);
        int i3 = this.f2444k[iM2124c + 3];
        return (i3 < 16 || i3 > 31) ? i2 : this.f2444k[iM2124c + 4];
    }

    @Override // android.util.AttributeSet
    public final int getAttributeIntValue(String str, String str2, int i) {
        int iM2121a = m2121a(str, str2);
        return iM2121a == -1 ? i : getAttributeIntValue(iM2121a, i);
    }

    @Override // android.util.AttributeSet
    public final int getAttributeListValue(int i, String[] strArr, int i2) {
        return 0;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeListValue(String str, String str2, String[] strArr, int i) {
        return 0;
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeName(int i) {
        int i2 = this.f2444k[m2124c(i) + 1];
        return i2 == -1 ? "" : this.f2436c.m2154a(i2);
    }

    @Override // android.util.AttributeSet
    public final int getAttributeNameResource(int i) {
        int i2 = this.f2444k[m2124c(i) + 1];
        if (this.f2437d == null || i2 < 0 || i2 >= this.f2437d.length) {
            return 0;
        }
        return this.f2437d[i2];
    }

    @Override // android.content.res.XmlResourceParser, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeNamespace(int i) {
        int i2 = this.f2444k[m2124c(i)];
        return i2 == -1 ? "" : this.f2436c.m2154a(i2);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getAttributePrefix(int i) {
        int iM2138d = this.f2438e.m2138d(this.f2444k[m2124c(i)]);
        return iM2138d == -1 ? "" : this.f2436c.m2154a(iM2138d);
    }

    @Override // android.util.AttributeSet
    public final int getAttributeResourceValue(int i, int i2) {
        int iM2124c = m2124c(i);
        return this.f2444k[iM2124c + 3] == 1 ? this.f2444k[iM2124c + 4] : i2;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeResourceValue(String str, String str2, int i) {
        int iM2121a = m2121a(str, str2);
        return iM2121a == -1 ? i : getAttributeResourceValue(iM2121a, i);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getAttributeType(int i) {
        return "CDATA";
    }

    @Override // android.util.AttributeSet
    public final int getAttributeUnsignedIntValue(int i, int i2) {
        return getAttributeIntValue(i, i2);
    }

    @Override // android.util.AttributeSet
    public final int getAttributeUnsignedIntValue(String str, String str2, int i) {
        int iM2121a = m2121a(str, str2);
        return iM2121a == -1 ? i : getAttributeUnsignedIntValue(iM2121a, i);
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeValue(int i) {
        int iM2124c = m2124c(i);
        if (this.f2444k[iM2124c + 3] != 3) {
            return "";
        }
        return this.f2436c.m2154a(this.f2444k[iM2124c + 2]);
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeValue(String str, String str2) {
        int iM2121a = m2121a(str, str2);
        if (iM2121a == -1) {
            return null;
        }
        return getAttributeValue(iM2121a);
    }

    @Override // android.util.AttributeSet
    public final String getClassAttribute() {
        if (this.f2446m == -1) {
            return null;
        }
        return this.f2436c.m2154a(this.f2444k[m2124c(this.f2446m) + 2]);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getColumnNumber() {
        return -1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getDepth() {
        return this.f2438e.m2137d() - 1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getEventType() {
        return this.f2440g;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean getFeature(String str) {
        return false;
    }

    @Override // android.util.AttributeSet
    public final String getIdAttribute() {
        if (this.f2445l == -1) {
            return null;
        }
        return this.f2436c.m2154a(this.f2444k[m2124c(this.f2445l) + 2]);
    }

    @Override // android.util.AttributeSet
    public final int getIdAttributeResourceValue(int i) {
        if (this.f2445l == -1) {
            return i;
        }
        int iM2124c = m2124c(this.f2445l);
        return this.f2444k[iM2124c + 3] == 1 ? this.f2444k[iM2124c + 4] : i;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getInputEncoding() {
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getLineNumber() {
        return this.f2441h;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getName() {
        if (this.f2442i == -1 || !(this.f2440g == 2 || this.f2440g == 3)) {
            return null;
        }
        return this.f2436c.m2154a(this.f2442i);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespace() {
        return this.f2436c.m2154a(this.f2443j);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespace(String str) {
        throw new RuntimeException("Method is not supported.");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getNamespaceCount(int i) {
        return this.f2438e.m2130a(i);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespacePrefix(int i) {
        return this.f2436c.m2154a(this.f2438e.m2134b(i));
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespaceUri(int i) {
        return this.f2436c.m2154a(this.f2438e.m2135c(i));
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getPositionDescription() {
        return "XML line #" + getLineNumber();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getPrefix() {
        return this.f2436c.m2154a(this.f2438e.m2138d(this.f2443j));
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final Object getProperty(String str) {
        return null;
    }

    @Override // android.util.AttributeSet
    public final int getStyleAttribute() {
        if (this.f2447n == -1) {
            return 0;
        }
        return this.f2444k[m2124c(this.f2447n) + 4];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getText() {
        if (this.f2442i == -1 || this.f2440g != 4) {
            return null;
        }
        return this.f2436c.m2154a(this.f2442i);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final char[] getTextCharacters(int[] iArr) {
        String text = getText();
        if (text == null) {
            return null;
        }
        iArr[0] = 0;
        iArr[1] = text.length();
        char[] cArr = new char[text.length()];
        text.getChars(0, text.length(), cArr, 0);
        return cArr;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean isAttributeDefault(int i) {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean isEmptyElementTag() {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean isWhitespace() {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int next() throws XmlPullParserException, IOException {
        if (this.f2434a == null) {
            throw new XmlPullParserException("Parser is not opened.", this, null);
        }
        try {
            m2123b();
            return this.f2440g;
        } catch (IOException e) {
            close();
            throw e;
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int nextTag() throws XmlPullParserException, IOException {
        int next = next();
        if (next == 4 && isWhitespace()) {
            next = next();
        }
        if (next == 2 || next == 3) {
            return next;
        }
        throw new XmlPullParserException("Expected start or end tag.", this, null);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String nextText() throws XmlPullParserException, IOException {
        if (getEventType() != 2) {
            throw new XmlPullParserException("Parser must be on START_TAG to read next text.", this, null);
        }
        int next = next();
        if (next != 4) {
            if (next == 3) {
                return "";
            }
            throw new XmlPullParserException("Parser must be on START_TAG or TEXT to read text.", this, null);
        }
        String text = getText();
        if (next() != 3) {
            throw new XmlPullParserException("Event TEXT must be immediately followed by END_TAG.", this, null);
        }
        return text;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int nextToken() {
        return next();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void require(int i, String str, String str2) throws XmlPullParserException {
        if (i != getEventType() || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
            throw new XmlPullParserException(TYPES[i] + " is expected.", this, null);
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setFeature(String str, boolean z) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setInput(InputStream inputStream, String str) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setInput(Reader reader) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setProperty(String str, Object obj) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }
}
