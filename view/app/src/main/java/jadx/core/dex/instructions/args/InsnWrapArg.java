package jadx.core.dex.instructions.args;

import jadx.core.dex.nodes.InsnNode;
import jadx.core.utils.exceptions.JadxRuntimeException;

/* JADX INFO: loaded from: classes.dex */
public final class InsnWrapArg extends InsnArg {
    private final InsnNode wrappedInsn;

    public InsnWrapArg(InsnNode insnNode) {
        RegisterArg result = insnNode.getResult();
        this.type = result != null ? result.getType() : ArgType.VOID;
        this.wrappedInsn = insnNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsnWrapArg)) {
            return false;
        }
        InsnNode insnNode = this.wrappedInsn;
        InsnNode insnNode2 = ((InsnWrapArg) obj).wrappedInsn;
        if (!insnNode.isSame(insnNode2)) {
            return false;
        }
        int argsCount = insnNode.getArgsCount();
        for (int i = 0; i < argsCount; i++) {
            if (!insnNode.getArg(i).equals(insnNode2.getArg(i))) {
                return false;
            }
        }
        return true;
    }

    public final InsnNode getWrapInsn() {
        return this.wrappedInsn;
    }

    public final int hashCode() {
        return this.wrappedInsn.hashCode();
    }

    @Override // jadx.core.dex.instructions.args.InsnArg
    public final boolean isInsnWrap() {
        return true;
    }

    @Override // jadx.core.dex.instructions.args.InsnArg
    public final void setParentInsn(InsnNode insnNode) {
        if (insnNode == this.wrappedInsn) {
            throw new JadxRuntimeException("Can't wrap instruction info itself: " + insnNode);
        }
        this.parentInsn = insnNode;
    }

    public final String toString() {
        return "(wrap: " + this.type + "\n  " + this.wrappedInsn + ")";
    }
}
