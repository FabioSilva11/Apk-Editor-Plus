package jadx.core.dex.visitors.regions;

import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.nodes.IBlock;
import jadx.core.dex.nodes.IContainer;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.regions.Region;
import jadx.core.dex.regions.conditions.IfCondition;
import jadx.core.dex.regions.conditions.IfRegion;
import jadx.core.dex.visitors.AbstractVisitor;
import jadx.core.utils.RegionUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class IfRegionVisitor extends AbstractVisitor implements IRegionIterativeVisitor, IRegionVisitor {
    private static final TernaryVisitor TERNARY_VISITOR = new TernaryVisitor();

    class TernaryVisitor implements IRegionIterativeVisitor {
        private TernaryVisitor() {
        }

        @Override // jadx.core.dex.visitors.regions.IRegionIterativeVisitor
        public boolean visitRegion(MethodNode methodNode, IRegion iRegion) {
            return (iRegion instanceof IfRegion) && TernaryMod.makeTernaryInsn(methodNode, (IfRegion) iRegion);
        }
    }

    private static boolean hasBranchTerminator(IContainer iContainer) {
        return RegionUtils.hasExitBlock(iContainer) || RegionUtils.hasBreakInsn(iContainer);
    }

    private static boolean hasSimpleReturnBlock(IContainer iContainer) {
        if (iContainer == null) {
            return false;
        }
        if (iContainer.contains(AFlag.RETURN)) {
            return true;
        }
        if (!(iContainer instanceof IRegion)) {
            return false;
        }
        List subBlocks = ((IRegion) iContainer).getSubBlocks();
        return subBlocks.size() == 1 && ((IContainer) subBlocks.get(0)).contains(AFlag.RETURN);
    }

    private static void invertIfRegion(IfRegion ifRegion) {
        if (ifRegion.getElseRegion() != null) {
            ifRegion.invert();
        }
    }

    private static boolean isIfRegion(IContainer iContainer) {
        if (iContainer instanceof IfRegion) {
            return true;
        }
        if (iContainer instanceof IRegion) {
            List subBlocks = ((IRegion) iContainer).getSubBlocks();
            if (subBlocks.size() == 1 && (subBlocks.get(0) instanceof IfRegion)) {
                return true;
            }
        }
        return false;
    }

    private static void markElseIfChains(IfRegion ifRegion) {
        if (hasSimpleReturnBlock(ifRegion.getThenRegion())) {
            return;
        }
        IContainer elseRegion = ifRegion.getElseRegion();
        if (elseRegion instanceof Region) {
            List subBlocks = ((Region) elseRegion).getSubBlocks();
            if (subBlocks.size() == 1 && (subBlocks.get(0) instanceof IfRegion)) {
                ((IContainer) subBlocks.get(0)).add(AFlag.ELSE_IF_CHAIN);
                elseRegion.add(AFlag.ELSE_IF_CHAIN);
            }
        }
    }

    private static void moveBreakToThenBlock(IfRegion ifRegion) {
        if (ifRegion.getElseRegion() == null || !RegionUtils.hasBreakInsn(ifRegion.getElseRegion())) {
            return;
        }
        invertIfRegion(ifRegion);
    }

    private static void moveReturnToThenBlock(MethodNode methodNode, IfRegion ifRegion) {
        if (methodNode.getReturnType().equals(ArgType.VOID) || !hasSimpleReturnBlock(ifRegion.getElseRegion())) {
            return;
        }
        invertIfRegion(ifRegion);
    }

    private static void processIfRegion(MethodNode methodNode, IfRegion ifRegion) {
        simplifyIfCondition(ifRegion);
        moveReturnToThenBlock(methodNode, ifRegion);
        moveBreakToThenBlock(ifRegion);
        markElseIfChains(ifRegion);
    }

    private static boolean removeRedundantElseBlock(MethodNode methodNode, IfRegion ifRegion) {
        if (ifRegion.getElseRegion() == null || ifRegion.contains(AFlag.ELSE_IF_CHAIN) || ifRegion.getElseRegion().contains(AFlag.ELSE_IF_CHAIN) || !hasBranchTerminator(ifRegion.getThenRegion())) {
            return false;
        }
        if (methodNode.getReturnType() == ArgType.VOID && RegionUtils.insnsCount(ifRegion.getThenRegion()) == 2 && RegionUtils.insnsCount(ifRegion.getElseRegion()) == 2) {
            return false;
        }
        IRegion parent = ifRegion.getParent();
        Region region = new Region(parent);
        if (!parent.replaceSubBlock(ifRegion, region)) {
            return false;
        }
        region.add(ifRegion);
        region.add(ifRegion.getElseRegion());
        ifRegion.setElseRegion(null);
        return true;
    }

    private static void simplifyIfCondition(IfRegion ifRegion) {
        if (ifRegion.simplifyCondition() && ifRegion.getCondition().getMode() == IfCondition.Mode.NOT) {
            invertIfRegion(ifRegion);
        }
        IContainer elseRegion = ifRegion.getElseRegion();
        if (elseRegion == null || RegionUtils.isEmpty(elseRegion)) {
            return;
        }
        boolean zIsEmpty = RegionUtils.isEmpty(ifRegion.getThenRegion());
        if (zIsEmpty || hasSimpleReturnBlock(ifRegion.getThenRegion())) {
            invertIfRegion(ifRegion);
        }
        if (zIsEmpty || !isIfRegion(ifRegion.getThenRegion()) || isIfRegion(elseRegion)) {
            return;
        }
        invertIfRegion(ifRegion);
    }

    @Override // jadx.core.dex.visitors.regions.IRegionVisitor
    public boolean enterRegion(MethodNode methodNode, IRegion iRegion) {
        if (!(iRegion instanceof IfRegion)) {
            return true;
        }
        processIfRegion(methodNode, (IfRegion) iRegion);
        return true;
    }

    @Override // jadx.core.dex.visitors.regions.IRegionVisitor
    public void leaveRegion(MethodNode methodNode, IRegion iRegion) {
    }

    @Override // jadx.core.dex.visitors.regions.IRegionVisitor
    public void processBlock(MethodNode methodNode, IBlock iBlock) {
    }

    @Override // jadx.core.dex.visitors.AbstractVisitor, jadx.core.dex.visitors.IDexTreeVisitor
    public void visit(MethodNode methodNode) {
        DepthRegionTraversal.traverseIterative(methodNode, TERNARY_VISITOR);
        DepthRegionTraversal.traverse(methodNode, this);
        DepthRegionTraversal.traverseIterative(methodNode, this);
    }

    @Override // jadx.core.dex.visitors.regions.IRegionIterativeVisitor
    public boolean visitRegion(MethodNode methodNode, IRegion iRegion) {
        if (iRegion instanceof IfRegion) {
            return removeRedundantElseBlock(methodNode, (IfRegion) iRegion);
        }
        return false;
    }
}
