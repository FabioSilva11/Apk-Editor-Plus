package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.dex.nodes.InsnNode;

/* JADX INFO: loaded from: classes.dex */
public class MethodInlineAttr implements IAttribute {
    private final InsnNode insn;

    public MethodInlineAttr(InsnNode insnNode) {
        this.insn = insnNode;
    }

    public InsnNode getInsn() {
        return this.insn;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.METHOD_INLINE;
    }

    public String toString() {
        return "INLINE: " + this.insn;
    }
}
