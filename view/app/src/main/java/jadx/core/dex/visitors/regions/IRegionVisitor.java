package jadx.core.dex.visitors.regions;

import jadx.core.dex.nodes.IBlock;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.MethodNode;

/* JADX INFO: loaded from: classes.dex */
public interface IRegionVisitor {
    boolean enterRegion(MethodNode methodNode, IRegion iRegion);

    void leaveRegion(MethodNode methodNode, IRegion iRegion);

    void processBlock(MethodNode methodNode, IBlock iBlock);
}
