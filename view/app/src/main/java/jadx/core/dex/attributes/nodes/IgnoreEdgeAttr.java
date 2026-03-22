package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.utils.Utils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class IgnoreEdgeAttr implements IAttribute {
    private final Set blocks = new HashSet(3);

    public boolean contains(BlockNode blockNode) {
        return this.blocks.contains(blockNode);
    }

    public Set getBlocks() {
        return this.blocks;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.IGNORE_EDGE;
    }

    public String toString() {
        return "IGNORE_EDGES: " + Utils.listToString(this.blocks);
    }
}
