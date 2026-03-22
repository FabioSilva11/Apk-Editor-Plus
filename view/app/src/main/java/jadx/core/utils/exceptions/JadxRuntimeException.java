package jadx.core.utils.exceptions;

/* JADX INFO: loaded from: classes.dex */
public class JadxRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -7410848445429898248L;

    public JadxRuntimeException(String str) {
        super(str);
    }

    public JadxRuntimeException(String str, Throwable th) {
        super(str, th);
    }
}
