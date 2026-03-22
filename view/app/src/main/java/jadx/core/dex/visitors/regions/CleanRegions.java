package jadx.core.dex.visitors.regions;

import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.IContainer;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.regions.Region;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CleanRegions {
    private CleanRegions() {
    }

    public static void process(MethodNode methodNode) {
        if (methodNode.isNoCode() || methodNode.getBasicBlocks().isEmpty()) {
            return;
        }
        DepthRegionTraversal.traverse(methodNode, new AbstractRegionVisitor() { // from class: jadx.core.dex.visitors.regions.CleanRegions.1
            @Override // jadx.core.dex.visitors.regions.AbstractRegionVisitor, jadx.core.dex.visitors.regions.IRegionVisitor
            public final boolean enterRegion(MethodNode methodNode2, IRegion iRegion) {
                if (iRegion instanceof Region) {
                    Iterator it = iRegion.getSubBlocks().iterator();
                    while (it.hasNext()) {
                        IContainer iContainer = (IContainer) it.next();
                        if ((iContainer instanceof BlockNode) && ((BlockNode) iContainer).getInstructions().isEmpty()) {
                            try {
                                it.remove();
                            } catch (UnsupportedOperationException e) {
                            }
                        }
                    }
                }
                return true;
            }
        });
    }
}
