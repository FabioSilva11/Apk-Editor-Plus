package com.p016a.p019b.p043h;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: renamed from: com.a.b.h.t */
/* JADX INFO: loaded from: classes.dex */
public final class C0890t {

    /* JADX INFO: renamed from: a */
    private final Writer f2261a;

    /* JADX INFO: renamed from: b */
    private final int f2262b;

    /* JADX INFO: renamed from: c */
    private final StringBuffer f2263c;

    /* JADX INFO: renamed from: d */
    private final StringBuffer f2264d;

    /* JADX INFO: renamed from: e */
    private final C0878h f2265e;

    /* JADX INFO: renamed from: f */
    private final C0878h f2266f;

    public C0890t(Writer writer, int i, int i2, String str) {
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("leftWidth < 1");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("rightWidth < 1");
        }
        if (str == null) {
            throw new NullPointerException("spacer == null");
        }
        StringWriter stringWriter = new StringWriter(1000);
        StringWriter stringWriter2 = new StringWriter(1000);
        this.f2261a = writer;
        this.f2262b = i;
        this.f2263c = stringWriter.getBuffer();
        this.f2264d = stringWriter2.getBuffer();
        this.f2265e = new C0878h(stringWriter, i);
        this.f2266f = new C0878h(stringWriter2, i2, str);
    }

    /* JADX INFO: renamed from: a */
    public static String m2031a(String str, int i, String str2, String str3, int i2) {
        StringWriter stringWriter = new StringWriter((str.length() + str3.length()) * 3);
        C0890t c0890t = new C0890t(stringWriter, i, i2, str2);
        try {
            c0890t.f2265e.write(str);
            c0890t.f2266f.write(str3);
            c0890t.m2036c();
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException("shouldn't happen", e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2032a(StringBuffer stringBuffer, Writer writer) throws IOException {
        int length = stringBuffer.length();
        if (length == 0 || stringBuffer.charAt(length - 1) == '\n') {
            return;
        }
        writer.write(10);
    }

    /* JADX INFO: renamed from: d */
    private void m2033d() throws IOException {
        int iIndexOf;
        while (true) {
            int iIndexOf2 = this.f2263c.indexOf("\n");
            if (iIndexOf2 < 0 || (iIndexOf = this.f2264d.indexOf("\n")) < 0) {
                return;
            }
            if (iIndexOf2 != 0) {
                this.f2261a.write(this.f2263c.substring(0, iIndexOf2));
            }
            if (iIndexOf != 0) {
                Writer writer = this.f2261a;
                for (int i = this.f2262b - iIndexOf2; i > 0; i--) {
                    writer.write(32);
                }
                this.f2261a.write(this.f2264d.substring(0, iIndexOf));
            }
            this.f2261a.write(10);
            this.f2263c.delete(0, iIndexOf2 + 1);
            this.f2264d.delete(0, iIndexOf + 1);
        }
    }

    /* JADX INFO: renamed from: a */
    public final Writer m2034a() {
        return this.f2265e;
    }

    /* JADX INFO: renamed from: b */
    public final Writer m2035b() {
        return this.f2266f;
    }

    /* JADX INFO: renamed from: c */
    public final void m2036c() {
        try {
            m2032a(this.f2263c, this.f2265e);
            m2032a(this.f2264d, this.f2266f);
            m2033d();
            m2032a(this.f2263c, this.f2265e);
            while (this.f2263c.length() != 0) {
                this.f2266f.write(10);
                m2033d();
            }
            m2032a(this.f2264d, this.f2266f);
            while (this.f2264d.length() != 0) {
                this.f2265e.write(10);
                m2033d();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
