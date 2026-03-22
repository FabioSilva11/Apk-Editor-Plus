package jadx.core.dex.visitors.regions;

import jadx.core.dex.nodes.IBlock;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.MethodNode;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractRegionVisitor implements IRegionVisitor {
    @Override // jadx.core.dex.visitors.regions.IRegionVisitor
    public boolean enterRegion(MethodNode methodNode, IRegion iRegion) {
        return true;
    }

    @Override // jadx.core.dex.visitors.regions.IRegionVisitor
    public void leaveRegion(MethodNode methodNode, IRegion iRegion) {
    }

    @Override // jadx.core.dex.visitors.regions.IRegionVisitor
    public void processBlock(MethodNode methodNode, IBlock iBlock) {
    }
}
