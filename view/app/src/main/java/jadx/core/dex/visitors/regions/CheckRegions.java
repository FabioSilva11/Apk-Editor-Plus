package jadx.core.dex.visitors.regions;

import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.IBlock;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.regions.loops.LoopRegion;
import jadx.core.dex.visitors.AbstractVisitor;
import jadx.core.utils.ErrorsCounter;
import java.util.HashSet;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
public class CheckRegions extends AbstractVisitor {
    private static final InterfaceC1668b LOG = C1677c.m3845a(CheckRegions.class);

    @Override // jadx.core.dex.visitors.AbstractVisitor, jadx.core.dex.visitors.IDexTreeVisitor
    public void visit(MethodNode methodNode) {
        if (methodNode.isNoCode() || methodNode.getBasicBlocks().isEmpty() || methodNode.contains(AType.JADX_ERROR)) {
            return;
        }
        final HashSet hashSet = new HashSet();
        DepthRegionTraversal.traverse(methodNode, new AbstractRegionVisitor() { // from class: jadx.core.dex.visitors.regions.CheckRegions.1
            @Override // jadx.core.dex.visitors.regions.AbstractRegionVisitor, jadx.core.dex.visitors.regions.IRegionVisitor
            public void processBlock(MethodNode methodNode2, IBlock iBlock) {
                if (iBlock instanceof BlockNode) {
                    BlockNode blockNode = (BlockNode) iBlock;
                    if (hashSet.add(blockNode) || blockNode.contains(AFlag.RETURN) || blockNode.contains(AFlag.SKIP) || blockNode.contains(AFlag.SYNTHETIC) || blockNode.getInstructions().isEmpty()) {
                        return;
                    }
                    CheckRegions.LOG.mo3816a(" Duplicated block: {} in {}", blockNode, methodNode2);
                }
            }
        });
        if (methodNode.getBasicBlocks().size() != hashSet.size()) {
            for (BlockNode blockNode : methodNode.getBasicBlocks()) {
                if (!hashSet.contains(blockNode) && !blockNode.getInstructions().isEmpty() && !blockNode.contains(AFlag.SKIP)) {
                    methodNode.add(AFlag.INCONSISTENT_CODE);
                    LOG.mo3816a(" Missing block: {} in {}", blockNode, methodNode);
                }
            }
        }
        DepthRegionTraversal.traverse(methodNode, new AbstractRegionVisitor() { // from class: jadx.core.dex.visitors.regions.CheckRegions.2
            @Override // jadx.core.dex.visitors.regions.AbstractRegionVisitor, jadx.core.dex.visitors.regions.IRegionVisitor
            public boolean enterRegion(MethodNode methodNode2, IRegion iRegion) {
                BlockNode header;
                if ((iRegion instanceof LoopRegion) && (header = ((LoopRegion) iRegion).getHeader()) != null && header.getInstructions().size() != 1) {
                    ErrorsCounter.methodError(methodNode2, "Incorrect condition in loop: " + header);
                }
                return true;
            }
        });
    }
}
