package jadx.core.dex.nodes;

import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.AttrNode;
import jadx.core.dex.attributes.nodes.IgnoreEdgeAttr;
import jadx.core.dex.attributes.nodes.LoopInfo;
import jadx.core.utils.BlockUtils;
import jadx.core.utils.EmptyBitSet;
import jadx.core.utils.InsnUtils;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BlockNode extends AttrNode implements IBlock {
    private List cleanSuccessors;
    private BitSet domFrontier;

    /* JADX INFO: renamed from: id */
    private int f4698id;
    private BlockNode idom;
    private final int startOffset;
    private final List instructions = new ArrayList(2);
    private List predecessors = new ArrayList(1);
    private List successors = new ArrayList(1);
    private BitSet doms = EmptyBitSet.EMPTY;
    private List dominatesOn = Collections.emptyList();

    public BlockNode(int i, int i2) {
        this.f4698id = i;
        this.startOffset = i2;
    }

    private static List cleanSuccessors(BlockNode blockNode) {
        List<BlockNode> successors = blockNode.getSuccessors();
        if (successors.isEmpty()) {
            return successors;
        }
        LinkedList linkedList = new LinkedList();
        for (BlockNode blockNode2 : successors) {
            if (BlockUtils.isBlockMustBeCleared(blockNode2)) {
                linkedList.add(blockNode2);
            }
        }
        if (blockNode.contains(AFlag.LOOP_END)) {
            Iterator it = blockNode.getAll(AType.LOOP).iterator();
            while (it.hasNext()) {
                linkedList.add(((LoopInfo) it.next()).getStart());
            }
        }
        IgnoreEdgeAttr ignoreEdgeAttr = (IgnoreEdgeAttr) blockNode.get(AType.IGNORE_EDGE);
        if (ignoreEdgeAttr != null) {
            linkedList.addAll(ignoreEdgeAttr.getBlocks());
        }
        if (linkedList.isEmpty()) {
            return successors;
        }
        ArrayList arrayList = new ArrayList(successors);
        arrayList.removeAll(linkedList);
        return arrayList;
    }

    public void addDominatesOn(BlockNode blockNode) {
        if (this.dominatesOn.isEmpty()) {
            this.dominatesOn = new LinkedList();
        }
        this.dominatesOn.add(blockNode);
    }

    @Override // jadx.core.dex.nodes.IContainer
    public String baseString() {
        return Integer.toString(this.f4698id);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockNode)) {
            return false;
        }
        BlockNode blockNode = (BlockNode) obj;
        return this.f4698id == blockNode.f4698id && this.startOffset == blockNode.startOffset;
    }

    public List getCleanSuccessors() {
        return this.cleanSuccessors;
    }

    public BitSet getDomFrontier() {
        return this.domFrontier;
    }

    public List getDominatesOn() {
        return this.dominatesOn;
    }

    public BitSet getDoms() {
        return this.doms;
    }

    public BlockNode getIDom() {
        return this.idom;
    }

    public int getId() {
        return this.f4698id;
    }

    @Override // jadx.core.dex.nodes.IBlock
    public List getInstructions() {
        return this.instructions;
    }

    public List getPredecessors() {
        return this.predecessors;
    }

    public int getStartOffset() {
        return this.startOffset;
    }

    public List getSuccessors() {
        return this.successors;
    }

    public int hashCode() {
        return this.startOffset;
    }

    public boolean isDominator(BlockNode blockNode) {
        return this.doms.get(blockNode.getId());
    }

    public boolean isReturnBlock() {
        return contains(AFlag.RETURN);
    }

    public boolean isSynthetic() {
        return contains(AFlag.SYNTHETIC);
    }

    public void lock() {
        this.cleanSuccessors = lockList(this.cleanSuccessors);
        this.successors = lockList(this.successors);
        this.predecessors = lockList(this.predecessors);
        this.dominatesOn = lockList(this.dominatesOn);
    }

    List lockList(List list) {
        return list.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public void setDomFrontier(BitSet bitSet) {
        this.domFrontier = bitSet;
    }

    public void setDoms(BitSet bitSet) {
        this.doms = bitSet;
    }

    public void setIDom(BlockNode blockNode) {
        this.idom = blockNode;
    }

    public void setId(int i) {
        this.f4698id = i;
    }

    public String toString() {
        return "B:" + this.f4698id + ":" + InsnUtils.formatOffset(this.startOffset);
    }

    public void updateCleanSuccessors() {
        this.cleanSuccessors = cleanSuccessors(this);
    }
}
