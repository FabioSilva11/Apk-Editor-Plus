package jadx.core.utils.exceptions;

import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.MethodNode;

/* JADX INFO: loaded from: classes.dex */
public class CodegenException extends JadxException {
    private static final long serialVersionUID = 39344288912966824L;

    public CodegenException(ClassNode classNode, String str) {
        super(classNode, str, (Throwable) null);
    }

    public CodegenException(ClassNode classNode, String str, Throwable th) {
        super(classNode, str, th);
    }

    public CodegenException(MethodNode methodNode, String str) {
        super(methodNode, str, (Throwable) null);
    }

    public CodegenException(MethodNode methodNode, String str, Throwable th) {
        super(methodNode, str, th);
    }

    public CodegenException(String str) {
        super(str);
    }

    public CodegenException(String str, Throwable th) {
        super(str, th);
    }
}
