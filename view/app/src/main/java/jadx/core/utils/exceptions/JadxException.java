package jadx.core.utils.exceptions;

import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.utils.ErrorsCounter;

/* JADX INFO: loaded from: classes.dex */
public class JadxException extends Exception {
    private static final long serialVersionUID = 3577449089978463557L;

    public JadxException(ClassNode classNode, String str, Throwable th) {
        super(ErrorsCounter.formatErrorMsg(classNode, str), th);
    }

    public JadxException(MethodNode methodNode, String str, Throwable th) {
        super(ErrorsCounter.formatErrorMsg(methodNode, str), th);
    }

    public JadxException(String str) {
        super(str);
    }

    public JadxException(String str, Throwable th) {
        super(str, th);
    }
}
