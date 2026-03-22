package jadx.core.dex.instructions;

import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.nodes.InsnNode;

/* JADX INFO: loaded from: classes.dex */
public class NewArrayNode extends InsnNode {
    private final ArgType arrType;

    public NewArrayNode(ArgType argType, RegisterArg registerArg, InsnArg insnArg) {
        super(InsnType.NEW_ARRAY, 1);
        this.arrType = argType;
        setResult(registerArg);
        addArg(insnArg);
    }

    public ArgType getArrayType() {
        return this.arrType;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public boolean isSame(InsnNode insnNode) {
        if (this == insnNode) {
            return true;
        }
        if ((insnNode instanceof NewArrayNode) && super.isSame(insnNode)) {
            return this.arrType == ((NewArrayNode) insnNode).arrType;
        }
        return false;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public String toString() {
        return super.toString() + " type: " + this.arrType;
    }
}
