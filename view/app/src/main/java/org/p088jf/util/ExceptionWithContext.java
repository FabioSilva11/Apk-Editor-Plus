package org.p088jf.util;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class ExceptionWithContext extends RuntimeException {
    public StringBuffer context;

    public ExceptionWithContext(String str, Object... objArr) {
        this(null, str, objArr);
    }

    public ExceptionWithContext(Throwable th) {
        this(th, null, new Object[0]);
    }

    public ExceptionWithContext(Throwable th, String str, Object... objArr) {
        super(str != null ? formatMessage(str, objArr) : th != null ? th.getMessage() : null, th);
        if (!(th instanceof ExceptionWithContext)) {
            this.context = new StringBuffer(200);
            return;
        }
        String string = ((ExceptionWithContext) th).context.toString();
        StringBuffer stringBuffer = new StringBuffer(string.length() + 200);
        this.context = stringBuffer;
        stringBuffer.append(string);
    }

    public static String formatMessage(String str, Object... objArr) {
        if (str == null) {
            return null;
        }
        return String.format(str, objArr);
    }

    public static ExceptionWithContext withContext(Throwable th, String str, Object... objArr) {
        ExceptionWithContext exceptionWithContext = th instanceof ExceptionWithContext ? (ExceptionWithContext) th : new ExceptionWithContext(th);
        exceptionWithContext.addContext(String.format(str, objArr));
        return exceptionWithContext;
    }

    public void addContext(String str) {
        if (str == null) {
            throw new NullPointerException("str == null");
        }
        this.context.append(str);
        if (str.endsWith("\n")) {
            return;
        }
        this.context.append('\n');
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        printStream.println(this.context);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        printWriter.println(this.context);
    }
}
