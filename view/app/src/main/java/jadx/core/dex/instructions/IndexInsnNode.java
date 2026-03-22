package jadx.core.dex.instructions;

import jadx.core.dex.nodes.InsnNode;
import jadx.core.utils.InsnUtils;

/* JADX INFO: loaded from: classes.dex */
public class IndexInsnNode extends InsnNode {
    private final Object index;

    public IndexInsnNode(InsnType insnType, Object obj, int i) {
        super(insnType, i);
        this.index = obj;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public IndexInsnNode copy() {
        return (IndexInsnNode) copyCommonParams(new IndexInsnNode(this.insnType, this.index, getArgsCount()));
    }

    public Object getIndex() {
        return this.index;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public boolean isSame(InsnNode insnNode) {
        if (this == insnNode) {
            return true;
        }
        if (!(insnNode instanceof IndexInsnNode) || !super.isSame(insnNode)) {
            return false;
        }
        IndexInsnNode indexInsnNode = (IndexInsnNode) insnNode;
        return this.index == null ? indexInsnNode.index == null : this.index.equals(indexInsnNode.index);
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public String toString() {
        return super.toString() + " " + InsnUtils.indexToString(this.index);
    }
}
