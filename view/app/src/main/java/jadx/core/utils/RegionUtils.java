package jadx.core.utils;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.IBlock;
import jadx.core.dex.nodes.IBranchRegion;
import jadx.core.dex.nodes.IContainer;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.trycatch.CatchAttr;
import jadx.core.dex.trycatch.ExceptionHandler;
import jadx.core.dex.trycatch.TryCatchBlock;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class RegionUtils {
    private RegionUtils() {
    }

    public static void getAllRegionBlocks(IContainer iContainer, Set set) {
        if (iContainer instanceof IBlock) {
            set.add((IBlock) iContainer);
        } else {
            if (!(iContainer instanceof IRegion)) {
                throw new JadxRuntimeException(unknownContainerType(iContainer));
            }
            Iterator it = ((IRegion) iContainer).getSubBlocks().iterator();
            while (it.hasNext()) {
                getAllRegionBlocks((IContainer) it.next(), set);
            }
        }
    }

    public static IContainer getBlockContainer(IContainer iContainer, BlockNode blockNode) {
        if (iContainer instanceof IBlock) {
            if (iContainer == blockNode) {
                return iContainer;
            }
            return null;
        }
        if (!(iContainer instanceof IRegion)) {
            throw new JadxRuntimeException(unknownContainerType(iContainer));
        }
        IRegion iRegion = (IRegion) iContainer;
        Iterator it = iRegion.getSubBlocks().iterator();
        while (it.hasNext()) {
            IContainer blockContainer = getBlockContainer((IContainer) it.next(), blockNode);
            if (blockContainer != null) {
                return !(blockContainer instanceof IBlock) ? blockContainer : iRegion;
            }
        }
        return null;
    }

    public static List getExcHandlersForRegion(IContainer iContainer) {
        CatchAttr catchAttr = (CatchAttr) iContainer.get(AType.CATCH_BLOCK);
        if (catchAttr == null) {
            return Collections.emptyList();
        }
        TryCatchBlock tryBlock = catchAttr.getTryBlock();
        ArrayList arrayList = new ArrayList(tryBlock.getHandlersCount());
        Iterator it = tryBlock.getHandlers().iterator();
        while (it.hasNext()) {
            arrayList.add(((ExceptionHandler) it.next()).getHandlerRegion());
        }
        return arrayList;
    }

    public static IBlock getLastBlock(IContainer iContainer) {
        IContainer iContainer2 = iContainer;
        while (!(iContainer2 instanceof IBlock)) {
            if (iContainer2 instanceof IBranchRegion) {
                return null;
            }
            if (!(iContainer2 instanceof IRegion)) {
                throw new JadxRuntimeException(unknownContainerType(iContainer2));
            }
            List subBlocks = ((IRegion) iContainer2).getSubBlocks();
            if (subBlocks.isEmpty()) {
                return null;
            }
            iContainer2 = (IContainer) subBlocks.get(subBlocks.size() - 1);
        }
        return (IBlock) iContainer2;
    }

    public static InsnNode getLastInsn(IContainer iContainer) {
        IContainer iContainer2 = iContainer;
        while (!(iContainer2 instanceof IBlock)) {
            if (iContainer2 instanceof IBranchRegion) {
                return null;
            }
            if (!(iContainer2 instanceof IRegion)) {
                throw new JadxRuntimeException(unknownContainerType(iContainer2));
            }
            List subBlocks = ((IRegion) iContainer2).getSubBlocks();
            if (subBlocks.isEmpty()) {
                return null;
            }
            iContainer2 = (IContainer) subBlocks.get(subBlocks.size() - 1);
        }
        List instructions = ((IBlock) iContainer2).getInstructions();
        if (instructions.isEmpty()) {
            return null;
        }
        return (InsnNode) instructions.get(instructions.size() - 1);
    }

    public static boolean hasBreakInsn(IContainer iContainer) {
        if (iContainer instanceof IBlock) {
            return BlockUtils.checkLastInsnType((IBlock) iContainer, InsnType.BREAK);
        }
        if (!(iContainer instanceof IRegion)) {
            throw new JadxRuntimeException("Unknown container type: " + iContainer);
        }
        List subBlocks = ((IRegion) iContainer).getSubBlocks();
        return !subBlocks.isEmpty() && hasBreakInsn((IContainer) subBlocks.get(subBlocks.size() + (-1)));
    }

    public static boolean hasExitBlock(IContainer iContainer) {
        if (iContainer instanceof BlockNode) {
            return ((BlockNode) iContainer).getSuccessors().isEmpty();
        }
        if (iContainer instanceof IBlock) {
            return true;
        }
        if (!(iContainer instanceof IRegion)) {
            throw new JadxRuntimeException(unknownContainerType(iContainer));
        }
        List subBlocks = ((IRegion) iContainer).getSubBlocks();
        return !subBlocks.isEmpty() && hasExitBlock((IContainer) subBlocks.get(subBlocks.size() + (-1)));
    }

    public static boolean hasExitEdge(IContainer iContainer) {
        if (iContainer instanceof IBlock) {
            InsnNode lastInsn = BlockUtils.getLastInsn((IBlock) iContainer);
            if (lastInsn == null) {
                return false;
            }
            InsnType type = lastInsn.getType();
            return type == InsnType.RETURN || type == InsnType.CONTINUE || type == InsnType.BREAK || type == InsnType.THROW;
        }
        if (!(iContainer instanceof IBranchRegion)) {
            if (!(iContainer instanceof IRegion)) {
                throw new JadxRuntimeException(unknownContainerType(iContainer));
            }
            List subBlocks = ((IRegion) iContainer).getSubBlocks();
            return !subBlocks.isEmpty() && hasExitEdge((IContainer) subBlocks.get(subBlocks.size() + (-1)));
        }
        for (IContainer iContainer2 : ((IBranchRegion) iContainer).getBranches()) {
            if (iContainer2 == null || !hasExitEdge(iContainer2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasPathThroughBlock(BlockNode blockNode, IContainer iContainer) {
        if (blockNode == iContainer) {
            return true;
        }
        if (iContainer instanceof BlockNode) {
            return BlockUtils.isPathExists(blockNode, (BlockNode) iContainer);
        }
        if (iContainer instanceof IBlock) {
            return false;
        }
        if (!(iContainer instanceof IRegion)) {
            throw new JadxRuntimeException(unknownContainerType(iContainer));
        }
        Iterator it = ((IRegion) iContainer).getSubBlocks().iterator();
        while (it.hasNext()) {
            if (!hasPathThroughBlock(blockNode, (IContainer) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static int insnsCount(IContainer iContainer) {
        if (iContainer instanceof IBlock) {
            return ((IBlock) iContainer).getInstructions().size();
        }
        if (!(iContainer instanceof IRegion)) {
            throw new JadxRuntimeException(unknownContainerType(iContainer));
        }
        int iInsnsCount = 0;
        Iterator it = ((IRegion) iContainer).getSubBlocks().iterator();
        while (true) {
            int i = iInsnsCount;
            if (!it.hasNext()) {
                return i;
            }
            iInsnsCount = insnsCount((IContainer) it.next()) + i;
        }
    }

    public static boolean isDominatedBy(BlockNode blockNode, IContainer iContainer) {
        if (blockNode == iContainer) {
            return true;
        }
        if (iContainer instanceof BlockNode) {
            return ((BlockNode) iContainer).isDominator(blockNode);
        }
        if (iContainer instanceof IBlock) {
            return false;
        }
        if (!(iContainer instanceof IRegion)) {
            throw new JadxRuntimeException(unknownContainerType(iContainer));
        }
        Iterator it = ((IRegion) iContainer).getSubBlocks().iterator();
        while (it.hasNext()) {
            if (!isDominatedBy(blockNode, (IContainer) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(IContainer iContainer) {
        return !notEmpty(iContainer);
    }

    public static boolean isRegionContainsBlock(IContainer iContainer, BlockNode blockNode) {
        if (iContainer instanceof IBlock) {
            return iContainer == blockNode;
        }
        if (!(iContainer instanceof IRegion)) {
            throw new JadxRuntimeException(unknownContainerType(iContainer));
        }
        Iterator it = ((IRegion) iContainer).getSubBlocks().iterator();
        while (it.hasNext()) {
            if (isRegionContainsBlock((IContainer) it.next(), blockNode)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRegionContainsExcHandlerRegion(IContainer iContainer, IRegion iRegion) {
        if (iContainer == iRegion) {
            return true;
        }
        if (iContainer instanceof IRegion) {
            for (IContainer iContainer2 : ((IRegion) iContainer).getSubBlocks()) {
                CatchAttr catchAttr = (CatchAttr) iContainer2.get(AType.CATCH_BLOCK);
                if (catchAttr != null && (iContainer2 instanceof IRegion)) {
                    Iterator it = catchAttr.getTryBlock().getHandlers().iterator();
                    while (it.hasNext()) {
                        if (isRegionContainsRegion(((ExceptionHandler) it.next()).getHandlerRegion(), iRegion)) {
                            return true;
                        }
                    }
                }
                if (isRegionContainsRegion(iContainer2, iRegion)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isRegionContainsRegion(IContainer iContainer, IRegion iRegion) {
        if (iContainer == iRegion) {
            return true;
        }
        if (iRegion == null) {
            return false;
        }
        while (true) {
            IRegion parent = iRegion.getParent();
            if (iContainer == parent) {
                return true;
            }
            if (parent == null) {
                if (iRegion.contains(AType.EXC_HANDLER)) {
                    return isRegionContainsExcHandlerRegion(iContainer, iRegion);
                }
                return false;
            }
            iRegion = parent;
        }
    }

    public static boolean notEmpty(IContainer iContainer) {
        if (iContainer instanceof IBlock) {
            return !((IBlock) iContainer).getInstructions().isEmpty();
        }
        if (!(iContainer instanceof IRegion)) {
            throw new JadxRuntimeException(unknownContainerType(iContainer));
        }
        Iterator it = ((IRegion) iContainer).getSubBlocks().iterator();
        while (it.hasNext()) {
            if (notEmpty((IContainer) it.next())) {
                return true;
            }
        }
        return false;
    }

    protected static String unknownContainerType(IContainer iContainer) {
        return iContainer == null ? "Null container variable" : "Unknown container type: " + iContainer.getClass();
    }
}
