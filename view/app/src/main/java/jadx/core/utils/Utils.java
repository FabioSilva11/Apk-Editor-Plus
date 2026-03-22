package jadx.core.utils;

import jadx.api.JadxDecompiler;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    public static final String JADX_API_PACKAGE = JadxDecompiler.class.getPackage().getName();

    private Utils() {
    }

    public static String arrayToString(Object[] objArr) {
        if (objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(objArr[i]);
        }
        return sb.toString();
    }

    public static String cleanObjectName(String str) {
        int length = str.length() - 1;
        return (str.charAt(0) == 'L' && str.charAt(length) == ';') ? str.substring(1, length).replace('/', '.') : str;
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    private static void filter(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int i = -1;
        int length = stackTrace.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = i;
                break;
            }
            if (stackTrace[i2].getClassName().startsWith(JADX_API_PACKAGE)) {
                i = i2;
            } else if (i > 0) {
                break;
            }
            i2++;
        }
        if (i2 <= 0 || i2 >= length) {
            return;
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, 0, i2));
    }

    private static void filterRecursive(Throwable th) {
        do {
            try {
                filter(th);
            } catch (Exception e) {
            }
            th = th.getCause();
        } while (th != null);
    }

    public static String getStackTrace(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
        filterRecursive(th);
        th.printStackTrace(printWriter);
        return stringWriter.getBuffer().toString();
    }

    public static String listToString(Iterable iterable) {
        if (iterable == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static String makeQualifiedObjectName(String str) {
        return "L" + str.replace('.', '/') + ';';
    }
}
