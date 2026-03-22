package jadx.core.dex.instructions;

import jadx.core.dex.nodes.InsnNode;

/* JADX INFO: loaded from: classes.dex */
public final class ConstStringNode extends InsnNode {
    private final String str;

    public ConstStringNode(String str) {
        super(InsnType.CONST_STR, 0);
        this.str = str;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public final InsnNode copy() {
        return copyCommonParams(new ConstStringNode(this.str));
    }

    public final String getString() {
        return this.str;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public final boolean isSame(InsnNode insnNode) {
        if (this == insnNode) {
            return true;
        }
        if ((insnNode instanceof ConstStringNode) && super.isSame(insnNode)) {
            return this.str.equals(((ConstStringNode) insnNode).str);
        }
        return false;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public final String toString() {
        return super.toString() + " \"" + this.str + "\"";
    }
}
