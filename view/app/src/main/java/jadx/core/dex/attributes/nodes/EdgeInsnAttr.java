package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.InsnNode;

/* JADX INFO: loaded from: classes.dex */
public class EdgeInsnAttr implements IAttribute {
    private final BlockNode end;
    private final InsnNode insn;
    private final BlockNode start;

    public EdgeInsnAttr(BlockNode blockNode, BlockNode blockNode2, InsnNode insnNode) {
        this.start = blockNode;
        this.end = blockNode2;
        this.insn = insnNode;
    }

    public static void addEdgeInsn(BlockNode blockNode, BlockNode blockNode2, InsnNode insnNode) {
        EdgeInsnAttr edgeInsnAttr = new EdgeInsnAttr(blockNode, blockNode2, insnNode);
        blockNode.addAttr(AType.EDGE_INSN, edgeInsnAttr);
        blockNode2.addAttr(AType.EDGE_INSN, edgeInsnAttr);
    }

    public BlockNode getEnd() {
        return this.end;
    }

    public InsnNode getInsn() {
        return this.insn;
    }

    public BlockNode getStart() {
        return this.start;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.EDGE_INSN;
    }

    public String toString() {
        return "EDGE_INSN: " + this.start + "->" + this.end + " " + this.insn;
    }
}
