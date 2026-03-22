package jadx.core.dex.instructions;

import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.nodes.InsnNode;

/* JADX INFO: loaded from: classes.dex */
public class FilledNewArrayNode extends InsnNode {
    private final ArgType elemType;

    public FilledNewArrayNode(ArgType argType, int i) {
        super(InsnType.FILLED_NEW_ARRAY, i);
        this.elemType = argType;
    }

    public ArgType getArrayType() {
        return ArgType.array(this.elemType);
    }

    public ArgType getElemType() {
        return this.elemType;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public boolean isSame(InsnNode insnNode) {
        if (this == insnNode) {
            return true;
        }
        if ((insnNode instanceof FilledNewArrayNode) && super.isSame(insnNode)) {
            return this.elemType == ((FilledNewArrayNode) insnNode).elemType;
        }
        return false;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public String toString() {
        return super.toString() + " elemType: " + this.elemType;
    }
}
