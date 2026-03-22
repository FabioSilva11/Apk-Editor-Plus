package jadx.core.dex.visitors.blocksmaker.helpers;

import jadx.core.dex.nodes.BlockNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class BlocksRemoveInfo {
    private BlocksPair end;
    private int endSplitIndex;
    private BlocksPair start;
    private BlockNode startPredecessor;
    private int startSplitIndex;
    private final Set processed = new HashSet();
    private final Set outs = new HashSet();
    private final Map regMap = new HashMap();

    public BlocksRemoveInfo(BlocksPair blocksPair) {
        this.start = blocksPair;
    }

    public final BlockNode getByFirst(BlockNode blockNode) {
        for (BlocksPair blocksPair : this.processed) {
            if (blocksPair.getFirst() == blockNode) {
                return blocksPair.getSecond();
            }
        }
        return null;
    }

    public final BlockNode getBySecond(BlockNode blockNode) {
        for (BlocksPair blocksPair : this.processed) {
            if (blocksPair.getSecond() == blockNode) {
                return blocksPair.getSecond();
            }
        }
        return null;
    }

    public final BlocksPair getEnd() {
        return this.end;
    }

    public final int getEndSplitIndex() {
        return this.endSplitIndex;
    }

    public final Set getOuts() {
        return this.outs;
    }

    public final Set getProcessed() {
        return this.processed;
    }

    public final Map getRegMap() {
        return this.regMap;
    }

    public final BlocksPair getStart() {
        return this.start;
    }

    public final BlockNode getStartPredecessor() {
        return this.startPredecessor;
    }

    public final int getStartSplitIndex() {
        return this.startSplitIndex;
    }

    public final void setEnd(BlocksPair blocksPair) {
        this.end = blocksPair;
    }

    public final void setEndSplitIndex(int i) {
        this.endSplitIndex = i;
    }

    public final void setStart(BlocksPair blocksPair) {
        this.start = blocksPair;
    }

    public final void setStartPredecessor(BlockNode blockNode) {
        this.startPredecessor = blockNode;
    }

    public final void setStartSplitIndex(int i) {
        this.startSplitIndex = i;
    }

    public final String toString() {
        return "BRI start: " + this.start + ", end: " + this.end + ", list: " + this.processed + ", outs: " + this.outs + ", regMap: " + this.regMap + ", split: " + this.startSplitIndex;
    }
}
