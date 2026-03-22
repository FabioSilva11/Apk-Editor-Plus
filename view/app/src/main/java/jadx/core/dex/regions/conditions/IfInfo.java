package jadx.core.dex.regions.conditions;

import jadx.core.dex.nodes.BlockNode;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class IfInfo {
    private final IfCondition condition;
    private final BlockNode elseBlock;

    @Deprecated
    private BlockNode ifBlock;
    private final Set mergedBlocks;
    private BlockNode outBlock;
    private final Set skipBlocks;
    private final BlockNode thenBlock;

    public IfInfo(IfCondition ifCondition, BlockNode blockNode, BlockNode blockNode2) {
        this(ifCondition, blockNode, blockNode2, new HashSet(), new HashSet());
    }

    private IfInfo(IfCondition ifCondition, BlockNode blockNode, BlockNode blockNode2, Set set, Set set2) {
        this.condition = ifCondition;
        this.thenBlock = blockNode;
        this.elseBlock = blockNode2;
        this.mergedBlocks = set;
        this.skipBlocks = set2;
    }

    public IfInfo(IfInfo ifInfo, BlockNode blockNode, BlockNode blockNode2) {
        this(ifInfo.getCondition(), blockNode, blockNode2, ifInfo.getMergedBlocks(), ifInfo.getSkipBlocks());
    }

    public static IfInfo invert(IfInfo ifInfo) {
        IfInfo ifInfo2 = new IfInfo(IfCondition.invert(ifInfo.getCondition()), ifInfo.getElseBlock(), ifInfo.getThenBlock(), ifInfo.getMergedBlocks(), ifInfo.getSkipBlocks());
        ifInfo2.setIfBlock(ifInfo.getIfBlock());
        return ifInfo2;
    }

    public final IfCondition getCondition() {
        return this.condition;
    }

    public final BlockNode getElseBlock() {
        return this.elseBlock;
    }

    public final BlockNode getIfBlock() {
        return this.ifBlock;
    }

    public final Set getMergedBlocks() {
        return this.mergedBlocks;
    }

    public final BlockNode getOutBlock() {
        return this.outBlock;
    }

    public final Set getSkipBlocks() {
        return this.skipBlocks;
    }

    public final BlockNode getThenBlock() {
        return this.thenBlock;
    }

    public final void merge(IfInfo... ifInfoArr) {
        for (IfInfo ifInfo : ifInfoArr) {
            this.mergedBlocks.addAll(ifInfo.getMergedBlocks());
            this.skipBlocks.addAll(ifInfo.getSkipBlocks());
        }
    }

    public final void setIfBlock(BlockNode blockNode) {
        this.ifBlock = blockNode;
    }

    public final void setOutBlock(BlockNode blockNode) {
        this.outBlock = blockNode;
    }

    public final String toString() {
        return "IfInfo: then: " + this.thenBlock + ", else: " + this.elseBlock;
    }
}
