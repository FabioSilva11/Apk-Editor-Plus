package jadx.core.dex.nodes;

import jadx.core.dex.attributes.AttrNode;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InsnContainer extends AttrNode implements IBlock {
    private final List insns;

    public InsnContainer(List list) {
        this.insns = list;
    }

    @Override // jadx.core.dex.nodes.IContainer
    public String baseString() {
        return Integer.toString(this.insns.size());
    }

    @Override // jadx.core.dex.nodes.IBlock
    public List getInstructions() {
        return this.insns;
    }

    public String toString() {
        return "InsnContainer:" + this.insns.size();
    }
}
