package jadx.core.dex.trycatch;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.dex.nodes.BlockNode;

/* JADX INFO: loaded from: classes.dex */
public class SplitterBlockAttr implements IAttribute {
    private final BlockNode block;

    public SplitterBlockAttr(BlockNode blockNode) {
        this.block = blockNode;
    }

    public BlockNode getBlock() {
        return this.block;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.SPLITTER_BLOCK;
    }

    public String toString() {
        return "Splitter: " + this.block;
    }
}
