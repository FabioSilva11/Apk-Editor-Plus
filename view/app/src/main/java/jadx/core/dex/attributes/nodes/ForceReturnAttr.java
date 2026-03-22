package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.utils.Utils;

/* JADX INFO: loaded from: classes.dex */
public class ForceReturnAttr implements IAttribute {
    private final InsnNode returnInsn;

    public ForceReturnAttr(InsnNode insnNode) {
        this.returnInsn = insnNode;
    }

    public InsnNode getReturnInsn() {
        return this.returnInsn;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.FORCE_RETURN;
    }

    public String toString() {
        return "FORCE_RETURN " + Utils.listToString(this.returnInsn.getArguments());
    }
}
