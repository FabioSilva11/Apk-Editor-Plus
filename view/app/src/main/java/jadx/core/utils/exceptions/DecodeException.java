package jadx.core.utils.exceptions;

import jadx.core.dex.nodes.MethodNode;

/* JADX INFO: loaded from: classes.dex */
public class DecodeException extends JadxException {
    private static final long serialVersionUID = -6611189094923499636L;

    public DecodeException(MethodNode methodNode, String str) {
        super(methodNode, str, (Throwable) null);
    }

    public DecodeException(MethodNode methodNode, String str, Throwable th) {
        super(methodNode, str, th);
    }

    public DecodeException(String str) {
        super(str);
    }

    public DecodeException(String str, Throwable th) {
        super(str, th);
    }
}
