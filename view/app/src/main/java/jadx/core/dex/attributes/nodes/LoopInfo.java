package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.Edge;
import jadx.core.utils.BlockUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LoopInfo {
    private final BlockNode end;

    /* JADX INFO: renamed from: id */
    private int f4687id;
    private final Set loopBlocks;
    private LoopInfo parentLoop;
    private final BlockNode start;

    public LoopInfo(BlockNode blockNode, BlockNode blockNode2) {
        this.start = blockNode;
        this.end = blockNode2;
        this.loopBlocks = Collections.unmodifiableSet(BlockUtils.getAllPathsBlocks(blockNode, blockNode2));
    }

    public BlockNode getEnd() {
        return this.end;
    }

    public List getExitEdges() {
        LinkedList linkedList = new LinkedList();
        Set<BlockNode> loopBlocks = getLoopBlocks();
        for (BlockNode blockNode : loopBlocks) {
            for (BlockNode blockNode2 : blockNode.getSuccessors()) {
                if (!loopBlocks.contains(blockNode2) && !blockNode2.contains(AType.EXC_HANDLER)) {
                    linkedList.add(new Edge(blockNode, blockNode2));
                }
            }
        }
        return linkedList;
    }

    public Set getExitNodes() {
        HashSet hashSet = new HashSet();
        Set<BlockNode> loopBlocks = getLoopBlocks();
        for (BlockNode blockNode : loopBlocks) {
            for (BlockNode blockNode2 : blockNode.getSuccessors()) {
                if (!loopBlocks.contains(blockNode2) && !blockNode2.contains(AType.EXC_HANDLER)) {
                    hashSet.add(blockNode);
                }
            }
        }
        return hashSet;
    }

    public int getId() {
        return this.f4687id;
    }

    public Set getLoopBlocks() {
        return this.loopBlocks;
    }

    public LoopInfo getParentLoop() {
        return this.parentLoop;
    }

    public BlockNode getStart() {
        return this.start;
    }

    public void setId(int i) {
        this.f4687id = i;
    }

    public void setParentLoop(LoopInfo loopInfo) {
        this.parentLoop = loopInfo;
    }

    public String toString() {
        return "LOOP:" + this.f4687id + ": " + this.start + "->" + this.end;
    }
}
