package jadx.core.utils;

import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.nodes.IgnoreEdgeAttr;
import jadx.core.dex.attributes.nodes.PhiListAttr;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.PhiInsn;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.InsnWrapArg;
import jadx.core.dex.instructions.mods.TernaryInsn;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.IBlock;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.regions.conditions.IfCondition;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BlockUtils {
    private BlockUtils() {
    }

    private static void addPredecessors(Set set, BlockNode blockNode, BlockNode blockNode2) {
        set.add(blockNode);
        for (BlockNode blockNode3 : blockNode.getPredecessors()) {
            if (blockNode3 != blockNode2 && !set.contains(blockNode3)) {
                addPredecessors(set, blockNode3, blockNode2);
            }
        }
    }

    public static List bitSetToBlocks(MethodNode methodNode, BitSet bitSet) {
        int iCardinality = bitSet.cardinality();
        if (iCardinality == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCardinality);
        int iNextSetBit = bitSet.nextSetBit(0);
        while (iNextSetBit >= 0) {
            arrayList.add((BlockNode) methodNode.getBasicBlocks().get(iNextSetBit));
            iNextSetBit = bitSet.nextSetBit(iNextSetBit + 1);
        }
        return arrayList;
    }

    public static boolean blockContains(BlockNode blockNode, InsnNode insnNode) {
        Iterator it = blockNode.getInstructions().iterator();
        while (it.hasNext()) {
            if (((InsnNode) it.next()) == insnNode) {
                return true;
            }
        }
        return false;
    }

    public static BitSet blocksToBitSet(MethodNode methodNode, List list) {
        BitSet bitSet = new BitSet(methodNode.getBasicBlocks().size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bitSet.set(((BlockNode) it.next()).getId());
        }
        return bitSet;
    }

    public static List buildSimplePath(BlockNode blockNode) {
        LinkedList linkedList = new LinkedList();
        while (blockNode != null && blockNode.getCleanSuccessors().size() < 2 && blockNode.getPredecessors().size() == 1) {
            linkedList.add(blockNode);
            blockNode = getNextBlock(blockNode);
        }
        return linkedList.isEmpty() ? Collections.emptyList() : linkedList;
    }

    public static boolean checkLastInsnType(IBlock iBlock, InsnType insnType) {
        InsnNode lastInsn = getLastInsn(iBlock);
        return lastInsn != null && lastInsn.getType() == insnType;
    }

    public static void cleanBitSet(MethodNode methodNode, BitSet bitSet) {
        int iNextSetBit = bitSet.nextSetBit(0);
        while (iNextSetBit >= 0) {
            if (isBlockMustBeCleared((BlockNode) methodNode.getBasicBlocks().get(iNextSetBit))) {
                bitSet.clear(iNextSetBit);
            }
            iNextSetBit = bitSet.nextSetBit(iNextSetBit + 1);
        }
    }

    private static List cleanBlockList(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BlockNode blockNode = (BlockNode) it.next();
            if (!isBlockMustBeCleared(blockNode)) {
                arrayList.add(blockNode);
            }
        }
        return arrayList;
    }

    public static List collectBlocksDominatedBy(BlockNode blockNode, BlockNode blockNode2) {
        ArrayList arrayList = new ArrayList();
        collectWhileDominates(blockNode, blockNode2, arrayList);
        return arrayList;
    }

    private static void collectWhileDominates(BlockNode blockNode, BlockNode blockNode2, List list) {
        for (BlockNode blockNode3 : blockNode2.getCleanSuccessors()) {
            if (blockNode3.isDominator(blockNode)) {
                list.add(blockNode3);
                collectWhileDominates(blockNode, blockNode3, list);
            }
        }
    }

    public static List filterPredecessors(BlockNode blockNode) {
        List<BlockNode> predecessors = blockNode.getPredecessors();
        ArrayList arrayList = new ArrayList(predecessors.size());
        for (BlockNode blockNode2 : predecessors) {
            IgnoreEdgeAttr ignoreEdgeAttr = (IgnoreEdgeAttr) blockNode2.get(AType.IGNORE_EDGE);
            if (ignoreEdgeAttr == null) {
                arrayList.add(blockNode2);
            } else if (!ignoreEdgeAttr.contains(blockNode)) {
                arrayList.add(blockNode2);
            }
        }
        return arrayList;
    }

    private static InsnArg foundWrappedInsn(InsnNode insnNode, InsnNode insnNode2) {
        for (InsnArg insnArg : insnNode.getArguments()) {
            if (insnArg.isInsnWrap()) {
                InsnNode wrapInsn = ((InsnWrapArg) insnArg).getWrapInsn();
                if (wrapInsn == insnNode2) {
                    return insnArg;
                }
                InsnArg insnArgFoundWrappedInsn = foundWrappedInsn(wrapInsn, insnNode2);
                if (insnArgFoundWrappedInsn != null) {
                    return insnArgFoundWrappedInsn;
                }
            }
        }
        if (insnNode instanceof TernaryInsn) {
            return foundWrappedInsnInCondition(((TernaryInsn) insnNode).getCondition(), insnNode2);
        }
        return null;
    }

    private static InsnArg foundWrappedInsnInCondition(IfCondition ifCondition, InsnNode insnNode) {
        if (ifCondition.isCompare()) {
            return foundWrappedInsn(ifCondition.getCompare().getInsn(), insnNode);
        }
        Iterator it = ifCondition.getArgs().iterator();
        while (it.hasNext()) {
            InsnArg insnArgFoundWrappedInsnInCondition = foundWrappedInsnInCondition((IfCondition) it.next(), insnNode);
            if (insnArgFoundWrappedInsnInCondition != null) {
                return insnArgFoundWrappedInsnInCondition;
            }
        }
        return null;
    }

    public static Set getAllPathsBlocks(BlockNode blockNode, BlockNode blockNode2) {
        HashSet hashSet = new HashSet();
        hashSet.add(blockNode);
        if (blockNode != blockNode2) {
            addPredecessors(hashSet, blockNode2, blockNode);
        }
        return hashSet;
    }

    public static BlockNode getBlockByInsn(MethodNode methodNode, InsnNode insnNode) {
        if (insnNode instanceof PhiInsn) {
            return searchBlockWithPhi(methodNode, (PhiInsn) insnNode);
        }
        if (insnNode.contains(AFlag.WRAPPED)) {
            return getBlockByWrappedInsn(methodNode, insnNode);
        }
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            if (blockContains(blockNode, insnNode)) {
                return blockNode;
            }
        }
        return null;
    }

    public static BlockNode getBlockByOffset(int i, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            BlockNode blockNode = (BlockNode) it.next();
            if (blockNode.getStartOffset() == i) {
                return blockNode;
            }
        }
        throw new JadxRuntimeException("Can't find block by offset: " + InsnUtils.formatOffset(i) + " in list " + iterable);
    }

    private static BlockNode getBlockByWrappedInsn(MethodNode methodNode, InsnNode insnNode) {
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            for (InsnNode insnNode2 : blockNode.getInstructions()) {
                if (insnNode2 == insnNode || foundWrappedInsn(insnNode2, insnNode) != null) {
                    return blockNode;
                }
            }
        }
        return null;
    }

    public static InsnNode getLastInsn(IBlock iBlock) {
        List instructions = iBlock.getInstructions();
        if (instructions.isEmpty()) {
            return null;
        }
        return (InsnNode) instructions.get(instructions.size() - 1);
    }

    public static BlockNode getNextBlock(BlockNode blockNode) {
        List cleanSuccessors = blockNode.getCleanSuccessors();
        if (cleanSuccessors.isEmpty()) {
            return null;
        }
        return (BlockNode) cleanSuccessors.get(0);
    }

    public static BlockNode getNextBlockToPath(BlockNode blockNode, BlockNode blockNode2) {
        List<BlockNode> cleanSuccessors = blockNode.getCleanSuccessors();
        if (cleanSuccessors.contains(blockNode2)) {
            return blockNode2;
        }
        Set allPathsBlocks = getAllPathsBlocks(blockNode, blockNode2);
        for (BlockNode blockNode3 : cleanSuccessors) {
            if (allPathsBlocks.contains(blockNode3)) {
                return blockNode3;
            }
        }
        return null;
    }

    public static BlockNode getPathCross(MethodNode methodNode, BlockNode blockNode, BlockNode blockNode2) {
        if (blockNode == null || blockNode2 == null) {
            return null;
        }
        BitSet bitSet = new BitSet();
        bitSet.or(blockNode.getDomFrontier());
        bitSet.and(blockNode2.getDomFrontier());
        bitSet.clear(blockNode.getId());
        bitSet.clear(blockNode2.getId());
        if (bitSet.cardinality() == 1) {
            BlockNode blockNode3 = (BlockNode) methodNode.getBasicBlocks().get(bitSet.nextSetBit(0));
            if (isPathExists(blockNode, blockNode3) && isPathExists(blockNode2, blockNode3)) {
                return blockNode3;
            }
        }
        if (isPathExists(blockNode, blockNode2)) {
            return blockNode2;
        }
        if (isPathExists(blockNode2, blockNode)) {
            return blockNode;
        }
        return null;
    }

    public static BlockNode getTopBlock(Collection collection) {
        boolean z;
        if (collection.size() == 1) {
            return (BlockNode) collection.iterator().next();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            BlockNode blockNode = (BlockNode) it.next();
            Iterator it2 = collection.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                BlockNode blockNode2 = (BlockNode) it2.next();
                if (blockNode != blockNode2 && !isAnyPathExists(blockNode, blockNode2)) {
                    z = false;
                    break;
                }
            }
            if (z) {
                return blockNode;
            }
        }
        return null;
    }

    public static boolean isAllBlocksEmpty(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!((BlockNode) it.next()).getInstructions().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnyPathExists(BlockNode blockNode, BlockNode blockNode2) {
        if (blockNode == blockNode2 || blockNode2.isDominator(blockNode) || blockNode.getSuccessors().contains(blockNode2)) {
            return true;
        }
        if (blockNode.getPredecessors().contains(blockNode2)) {
            return false;
        }
        return traverseSuccessorsUntil(blockNode, blockNode2, new BitSet(), false);
    }

    public static boolean isBackEdge(BlockNode blockNode, BlockNode blockNode2) {
        if (blockNode2 == null || blockNode.getCleanSuccessors().contains(blockNode2)) {
            return false;
        }
        return blockNode.getSuccessors().contains(blockNode2);
    }

    public static boolean isBlockMustBeCleared(BlockNode blockNode) {
        if (blockNode.contains(AType.EXC_HANDLER) || blockNode.contains(AFlag.SKIP)) {
            return true;
        }
        if (blockNode.contains(AFlag.SYNTHETIC)) {
            List successors = blockNode.getSuccessors();
            if (successors.size() == 1 && ((BlockNode) successors.get(0)).contains(AType.EXC_HANDLER)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmptySimplePath(BlockNode blockNode, BlockNode blockNode2) {
        if (blockNode == blockNode2 && blockNode.getInstructions().isEmpty()) {
            return true;
        }
        if (!blockNode.getInstructions().isEmpty() || blockNode.getCleanSuccessors().size() != 1) {
            return false;
        }
        BlockNode nextBlock = getNextBlock(blockNode);
        while (nextBlock != null && nextBlock != blockNode2 && nextBlock.getCleanSuccessors().size() < 2 && nextBlock.getPredecessors().size() == 1 && nextBlock.getInstructions().isEmpty()) {
            nextBlock = getNextBlock(nextBlock);
        }
        return nextBlock == blockNode2;
    }

    public static boolean isOnlyOnePathExists(BlockNode blockNode, BlockNode blockNode2) {
        if (blockNode == blockNode2) {
            return true;
        }
        if (!blockNode2.isDominator(blockNode)) {
            return false;
        }
        while (blockNode.getCleanSuccessors().size() == 1) {
            BlockNode blockNode3 = (BlockNode) blockNode.getCleanSuccessors().get(0);
            if (blockNode3 == blockNode2) {
                return true;
            }
            blockNode = blockNode3;
        }
        return false;
    }

    public static boolean isPathExists(BlockNode blockNode, BlockNode blockNode2) {
        if (blockNode == blockNode2 || blockNode2.isDominator(blockNode) || blockNode.getCleanSuccessors().contains(blockNode2)) {
            return true;
        }
        if (blockNode.getPredecessors().contains(blockNode2)) {
            return false;
        }
        return traverseSuccessorsUntil(blockNode, blockNode2, new BitSet(), true);
    }

    public static BlockNode searchBlockWithPhi(MethodNode methodNode, PhiInsn phiInsn) {
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            PhiListAttr phiListAttr = (PhiListAttr) blockNode.get(AType.PHI_LIST);
            if (phiListAttr != null) {
                Iterator it = phiListAttr.getList().iterator();
                while (it.hasNext()) {
                    if (((PhiInsn) it.next()) == phiInsn) {
                        return blockNode;
                    }
                }
            }
        }
        return null;
    }

    public static InsnNode searchInsnParent(MethodNode methodNode, InsnNode insnNode) {
        InsnArg insnArgSearchWrappedInsnParent = searchWrappedInsnParent(methodNode, insnNode);
        if (insnArgSearchWrappedInsnParent == null) {
            return null;
        }
        return insnArgSearchWrappedInsnParent.getParentInsn();
    }

    public static InsnArg searchWrappedInsnParent(MethodNode methodNode, InsnNode insnNode) {
        if (!insnNode.contains(AFlag.WRAPPED)) {
            return null;
        }
        Iterator it = methodNode.getBasicBlocks().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((BlockNode) it.next()).getInstructions().iterator();
            while (it2.hasNext()) {
                InsnArg insnArgFoundWrappedInsn = foundWrappedInsn((InsnNode) it2.next(), insnNode);
                if (insnArgFoundWrappedInsn != null) {
                    return insnArgFoundWrappedInsn;
                }
            }
        }
        return null;
    }

    public static BlockNode selectOther(BlockNode blockNode, List list) {
        if (list.size() > 2) {
            list = cleanBlockList(list);
        }
        if (list.size() != 2) {
            throw new JadxRuntimeException("Incorrect nodes count for selectOther: " + blockNode + " in " + list);
        }
        BlockNode blockNode2 = (BlockNode) list.get(0);
        return blockNode2 != blockNode ? blockNode2 : (BlockNode) list.get(1);
    }

    public static BlockNode selectOtherSafe(BlockNode blockNode, List list) {
        int size = list.size();
        if (size == 1) {
            BlockNode blockNode2 = (BlockNode) list.get(0);
            if (blockNode2 != blockNode) {
                return blockNode2;
            }
            return null;
        }
        if (size != 2) {
            return null;
        }
        BlockNode blockNode3 = (BlockNode) list.get(0);
        return blockNode3 == blockNode ? (BlockNode) list.get(1) : blockNode3;
    }

    public static void skipPredSyntheticPaths(BlockNode blockNode) {
        for (BlockNode blockNode2 : blockNode.getPredecessors()) {
            if (blockNode2.contains(AFlag.SYNTHETIC) && !blockNode2.contains(AType.SPLITTER_BLOCK) && blockNode2.getInstructions().isEmpty()) {
                blockNode2.add(AFlag.SKIP);
                skipPredSyntheticPaths(blockNode2);
            }
        }
    }

    public static BlockNode skipSyntheticPredecessor(BlockNode blockNode) {
        return (blockNode.isSynthetic() && blockNode.getPredecessors().size() == 1) ? (BlockNode) blockNode.getPredecessors().get(0) : blockNode;
    }

    public static BlockNode skipSyntheticSuccessor(BlockNode blockNode) {
        return (blockNode.isSynthetic() && blockNode.getSuccessors().size() == 1) ? (BlockNode) blockNode.getSuccessors().get(0) : blockNode;
    }

    private static boolean traverseSuccessorsUntil(BlockNode blockNode, BlockNode blockNode2, BitSet bitSet, boolean z) {
        for (BlockNode blockNode3 : z ? blockNode.getCleanSuccessors() : blockNode.getSuccessors()) {
            if (blockNode3 == blockNode2) {
                return true;
            }
            int id = blockNode3.getId();
            if (!bitSet.get(id)) {
                bitSet.set(id);
                if (!blockNode2.isDominator(blockNode3) && !traverseSuccessorsUntil(blockNode3, blockNode2, bitSet, z)) {
                }
                return true;
            }
        }
        return false;
    }

    public static BlockNode traverseWhileDominates(BlockNode blockNode, BlockNode blockNode2) {
        for (BlockNode blockNode3 : blockNode2.getCleanSuccessors()) {
            if (!blockNode3.isDominator(blockNode)) {
                return blockNode3;
            }
            BlockNode blockNodeTraverseWhileDominates = traverseWhileDominates(blockNode, blockNode3);
            if (blockNodeTraverseWhileDominates != null) {
                return blockNodeTraverseWhileDominates;
            }
        }
        return null;
    }
}
