package jadx.core.dex.visitors.regions;

import jadx.core.dex.nodes.IBlock;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.MethodNode;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
public abstract class TracedRegionVisitor implements IRegionVisitor {
    protected final Deque regionStack = new ArrayDeque();

    @Override // jadx.core.dex.visitors.regions.IRegionVisitor
    public boolean enterRegion(MethodNode methodNode, IRegion iRegion) {
        this.regionStack.push(iRegion);
        return true;
    }

    @Override // jadx.core.dex.visitors.regions.IRegionVisitor
    public void leaveRegion(MethodNode methodNode, IRegion iRegion) {
        this.regionStack.pop();
    }

    @Override // jadx.core.dex.visitors.regions.IRegionVisitor
    public void processBlock(MethodNode methodNode, IBlock iBlock) {
        processBlockTraced(methodNode, iBlock, (IRegion) this.regionStack.peek());
    }

    public abstract void processBlockTraced(MethodNode methodNode, IBlock iBlock, IRegion iRegion);
}
