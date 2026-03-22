package com.p016a.p017a.p018a;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: renamed from: com.a.a.a.d */
/* JADX INFO: loaded from: classes.dex */
public class C0400d extends RuntimeException {

    /* JADX INFO: renamed from: a */
    private StringBuffer f340a;

    public C0400d(String str) {
        this(str, null);
    }

    public C0400d(String str, Throwable th) {
        super(str == null ? th != null ? th.getMessage() : null : str, th);
        if (!(th instanceof C0400d)) {
            this.f340a = new StringBuffer(200);
            return;
        }
        String string = ((C0400d) th).f340a.toString();
        this.f340a = new StringBuffer(string.length() + 200);
        this.f340a.append(string);
    }

    public C0400d(Throwable th) {
        this(null, th);
    }

    /* JADX INFO: renamed from: a */
    public static C0400d m308a(Throwable th, String str) {
        C0400d c0400d = th instanceof C0400d ? (C0400d) th : new C0400d(th);
        c0400d.m311a(str);
        return c0400d;
    }

    /* JADX INFO: renamed from: a */
    public final String m309a() {
        return this.f340a.toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m310a(PrintStream printStream) {
        printStream.println(getMessage());
        printStream.print(this.f340a);
    }

    /* JADX INFO: renamed from: a */
    public final void m311a(String str) {
        if (str == null) {
            throw new NullPointerException("str == null");
        }
        this.f340a.append(str);
        if (str.endsWith("\n")) {
            return;
        }
        this.f340a.append('\n');
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        printStream.println(this.f340a);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        printWriter.println(this.f340a);
    }
}
