package jadx.core.dex.visitors.blocksmaker;

import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.nodes.LoopInfo;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.Edge;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.trycatch.CatchAttr;
import jadx.core.dex.visitors.AbstractVisitor;
import jadx.core.utils.BlockUtils;
import jadx.core.utils.EmptyBitSet;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BlockProcessor extends AbstractVisitor {
    private static void cleanExitNodes(MethodNode methodNode) {
        Iterator it = methodNode.getExitBlocks().iterator();
        while (it.hasNext()) {
            BlockNode blockNode = (BlockNode) it.next();
            if (blockNode.getPredecessors().isEmpty()) {
                methodNode.getBasicBlocks().remove(blockNode);
                it.remove();
            }
        }
    }

    private static void clearBlocksState(MethodNode methodNode) {
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            blockNode.remove(AType.LOOP);
            blockNode.remove(AFlag.LOOP_START);
            blockNode.remove(AFlag.LOOP_END);
            blockNode.setDoms(null);
            blockNode.setIDom(null);
            blockNode.setDomFrontier(null);
            blockNode.getDominatesOn().clear();
        }
    }

    private static void computeBlockDF(MethodNode methodNode, BlockNode blockNode) {
        if (blockNode.getDomFrontier() != null) {
            return;
        }
        Iterator it = blockNode.getDominatesOn().iterator();
        while (it.hasNext()) {
            computeBlockDF(methodNode, (BlockNode) it.next());
        }
        List basicBlocks = methodNode.getBasicBlocks();
        BitSet bitSet = null;
        for (BlockNode blockNode2 : blockNode.getSuccessors()) {
            if (blockNode2.getIDom() != blockNode) {
                if (bitSet == null) {
                    bitSet = new BitSet(basicBlocks.size());
                }
                bitSet.set(blockNode2.getId());
            }
        }
        Iterator it2 = blockNode.getDominatesOn().iterator();
        while (it2.hasNext()) {
            BitSet domFrontier = ((BlockNode) it2.next()).getDomFrontier();
            for (int iNextSetBit = domFrontier.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = domFrontier.nextSetBit(iNextSetBit + 1)) {
                if (((BlockNode) basicBlocks.get(iNextSetBit)).getIDom() != blockNode) {
                    if (bitSet == null) {
                        bitSet = new BitSet(basicBlocks.size());
                    }
                    bitSet.set(iNextSetBit);
                }
            }
        }
        if (bitSet == null || bitSet.cardinality() == 0) {
            bitSet = EmptyBitSet.EMPTY;
        }
        blockNode.setDomFrontier(bitSet);
    }

    private static void computeDominanceFrontier(MethodNode methodNode) {
        Iterator it = methodNode.getExitBlocks().iterator();
        while (it.hasNext()) {
            ((BlockNode) it.next()).setDomFrontier(EmptyBitSet.EMPTY);
        }
        Iterator it2 = methodNode.getBasicBlocks().iterator();
        while (it2.hasNext()) {
            computeBlockDF(methodNode, (BlockNode) it2.next());
        }
    }

    private static void computeDominators(MethodNode methodNode) {
        boolean z;
        Object obj;
        List<BlockNode> basicBlocks = methodNode.getBasicBlocks();
        int size = basicBlocks.size();
        for (int i = 0; i < size; i++) {
            BlockNode blockNode = (BlockNode) basicBlocks.get(i);
            blockNode.setId(i);
            blockNode.setDoms(new BitSet(size));
            blockNode.getDoms().set(0, size);
        }
        BlockNode enterBlock = methodNode.getEnterBlock();
        enterBlock.getDoms().clear();
        enterBlock.getDoms().set(enterBlock.getId());
        BitSet bitSet = new BitSet(size);
        do {
            z = false;
            for (BlockNode blockNode2 : basicBlocks) {
                if (blockNode2 != enterBlock) {
                    BitSet doms = blockNode2.getDoms();
                    if (!z) {
                        bitSet.clear();
                        bitSet.or(doms);
                    }
                    Iterator it = blockNode2.getPredecessors().iterator();
                    while (it.hasNext()) {
                        doms.and(((BlockNode) it.next()).getDoms());
                    }
                    doms.set(blockNode2.getId());
                    z = (z || doms.equals(bitSet)) ? z : true;
                }
            }
        } while (z);
        markLoops(methodNode);
        for (BlockNode blockNode3 : basicBlocks) {
            blockNode3.getDoms().clear(blockNode3.getId());
        }
        for (BlockNode blockNode4 : basicBlocks) {
            if (blockNode4 != enterBlock) {
                List predecessors = blockNode4.getPredecessors();
                if (predecessors.size() == 1) {
                    obj = predecessors.get(0);
                } else {
                    BitSet bitSet2 = new BitSet(blockNode4.getDoms().length());
                    bitSet2.or(blockNode4.getDoms());
                    for (int iNextSetBit = bitSet2.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = bitSet2.nextSetBit(iNextSetBit + 1)) {
                        bitSet2.andNot(((BlockNode) basicBlocks.get(iNextSetBit)).getDoms());
                    }
                    if (bitSet2.cardinality() != 1) {
                        throw new JadxRuntimeException("Can't find immediate dominator for block " + blockNode4 + " in " + bitSet2 + " preds:" + predecessors);
                    }
                    obj = basicBlocks.get(bitSet2.nextSetBit(0));
                }
                BlockNode blockNode5 = (BlockNode) obj;
                blockNode4.setIDom(blockNode5);
                blockNode5.addDominatesOn(blockNode4);
            }
        }
    }

    private static InsnNode duplicateReturnInsn(InsnNode insnNode) {
        InsnNode insnNode2 = new InsnNode(insnNode.getType(), insnNode.getArgsCount());
        if (insnNode.getArgsCount() == 1) {
            RegisterArg registerArg = (RegisterArg) insnNode.getArg(0);
            insnNode2.addArg(InsnArg.reg(registerArg.getRegNum(), registerArg.getType()));
        }
        insnNode2.copyAttributesFrom(insnNode);
        insnNode2.setOffset(insnNode.getOffset());
        insnNode2.setSourceLine(insnNode.getSourceLine());
        return insnNode2;
    }

    private static boolean isReturnArgAssignInPred(List list, InsnNode insnNode) {
        int regNum = ((RegisterArg) insnNode.getArg(0)).getRegNum();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((BlockNode) it.next()).getInstructions().iterator();
            while (it2.hasNext()) {
                RegisterArg result = ((InsnNode) it2.next()).getResult();
                if (result != null && result.getRegNum() == regNum) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void markLoops(MethodNode methodNode) {
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            for (BlockNode blockNode2 : blockNode.getSuccessors()) {
                if (blockNode.getDoms().get(blockNode2.getId())) {
                    blockNode2.add(AFlag.LOOP_START);
                    blockNode.add(AFlag.LOOP_END);
                    LoopInfo loopInfo = new LoopInfo(blockNode2, blockNode);
                    blockNode2.addAttr(AType.LOOP, loopInfo);
                    blockNode.addAttr(AType.LOOP, loopInfo);
                }
            }
        }
    }

    private static void markReturnBlocks(MethodNode methodNode) {
        methodNode.getExitBlocks().clear();
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            if (BlockUtils.checkLastInsnType(blockNode, InsnType.RETURN)) {
                blockNode.add(AFlag.RETURN);
                methodNode.getExitBlocks().add(blockNode);
            }
        }
    }

    private static boolean modifyBlocksTree(MethodNode methodNode) {
        boolean z;
        boolean z2;
        boolean z3;
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            if (blockNode.getPredecessors().isEmpty() && blockNode != methodNode.getEnterBlock()) {
                throw new JadxRuntimeException("Unreachable block: " + blockNode);
            }
            List all = blockNode.getAll(AType.LOOP);
            if (all.size() > 1) {
                Iterator it = all.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = true;
                        break;
                    }
                    if (((LoopInfo) it.next()).getStart() != blockNode) {
                        z3 = false;
                        break;
                    }
                }
                if (z3) {
                    BlockNode blockNodeStartNewBlock = BlockSplitter.startNewBlock(methodNode, blockNode.getStartOffset());
                    blockNodeStartNewBlock.add(AFlag.SYNTHETIC);
                    BlockSplitter.connect(blockNodeStartNewBlock, blockNode);
                    Iterator it2 = all.iterator();
                    while (it2.hasNext()) {
                        BlockNode end = ((LoopInfo) it2.next()).getEnd();
                        BlockSplitter.removeConnection(end, blockNode);
                        BlockSplitter.connect(end, blockNodeStartNewBlock);
                    }
                    return true;
                }
            }
            if (all.size() == 1) {
                LoopInfo loopInfo = (LoopInfo) all.get(0);
                List<Edge> exitEdges = loopInfo.getExitEdges();
                if (!exitEdges.isEmpty()) {
                    boolean z4 = false;
                    for (Edge edge : exitEdges) {
                        BlockNode target = edge.getTarget();
                        if (target.contains(AFlag.SYNTHETIC)) {
                            z2 = z4;
                        } else {
                            BlockSplitter.insertBlockBetween(methodNode, edge.getSource(), target);
                            z2 = true;
                        }
                        z4 = z2;
                    }
                    if (z4) {
                        return true;
                    }
                }
                BlockNode end2 = loopInfo.getEnd();
                if (end2.getPredecessors().size() > 1) {
                    boolean z5 = false;
                    for (BlockNode blockNode2 : new ArrayList(end2.getPredecessors())) {
                        if (blockNode2.contains(AFlag.SYNTHETIC)) {
                            z = z5;
                        } else {
                            BlockSplitter.insertBlockBetween(methodNode, blockNode2, end2);
                            z = true;
                        }
                        z5 = z;
                    }
                    if (z5) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return splitReturn(methodNode);
    }

    private static void processBlocksTree(MethodNode methodNode) {
        computeDominators(methodNode);
        markReturnBlocks(methodNode);
        int i = 0;
        while (modifyBlocksTree(methodNode)) {
            clearBlocksState(methodNode);
            computeDominators(methodNode);
            markReturnBlocks(methodNode);
            int i2 = i + 1;
            if (i > 100) {
                throw new AssertionError("Can't fix method cfg: " + methodNode);
            }
            i = i2;
        }
        computeDominanceFrontier(methodNode);
        registerLoops(methodNode);
        processNestedLoops(methodNode);
    }

    private static void processNestedLoops(MethodNode methodNode) {
        if (methodNode.getLoopsCount() == 0) {
            return;
        }
        for (LoopInfo loopInfo : methodNode.getLoops()) {
            for (LoopInfo loopInfo2 : methodNode.getLoops()) {
                if (loopInfo != loopInfo2 && loopInfo.getLoopBlocks().containsAll(loopInfo2.getLoopBlocks())) {
                    LoopInfo parentLoop = loopInfo2.getParentLoop();
                    if (parentLoop != null) {
                        if (parentLoop.getLoopBlocks().containsAll(loopInfo.getLoopBlocks())) {
                            loopInfo.setParentLoop(parentLoop);
                        } else {
                            parentLoop.setParentLoop(loopInfo);
                        }
                    }
                    loopInfo2.setParentLoop(loopInfo);
                }
            }
        }
    }

    private static void registerLoops(MethodNode methodNode) {
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            if (blockNode.contains(AFlag.LOOP_START)) {
                Iterator it = blockNode.getAll(AType.LOOP).iterator();
                while (it.hasNext()) {
                    methodNode.registerLoop((LoopInfo) it.next());
                }
            }
        }
    }

    private static void removeBlocks(MethodNode methodNode) {
        Iterator it = methodNode.getBasicBlocks().iterator();
        while (it.hasNext()) {
            BlockNode blockNode = (BlockNode) it.next();
            if (blockNode.contains(AFlag.REMOVE) && blockNode.getPredecessors().isEmpty() && blockNode.getSuccessors().isEmpty()) {
                CatchAttr catchAttr = (CatchAttr) blockNode.get(AType.CATCH_BLOCK);
                if (catchAttr != null) {
                    catchAttr.getTryBlock().removeBlock(methodNode, blockNode);
                }
                it.remove();
            }
        }
    }

    public static void rerun(MethodNode methodNode) {
        removeBlocks(methodNode);
        clearBlocksState(methodNode);
        processBlocksTree(methodNode);
    }

    private static boolean splitReturn(MethodNode methodNode) {
        InsnNode insnNodeDuplicateReturnInsn;
        if (methodNode.getExitBlocks().size() != 1) {
            return false;
        }
        BlockNode blockNode = (BlockNode) methodNode.getExitBlocks().get(0);
        if (blockNode.getInstructions().size() != 1 || blockNode.contains(AFlag.SYNTHETIC) || blockNode.getPredecessors().size() < 2) {
            return false;
        }
        List<BlockNode> listFilterPredecessors = BlockUtils.filterPredecessors(blockNode);
        if (listFilterPredecessors.size() < 2) {
            return false;
        }
        InsnNode insnNode = (InsnNode) blockNode.getInstructions().get(0);
        if (insnNode.getArgsCount() != 0 && !isReturnArgAssignInPred(listFilterPredecessors, insnNode)) {
            return false;
        }
        boolean z = true;
        for (BlockNode blockNode2 : listFilterPredecessors) {
            BlockNode blockNodeStartNewBlock = BlockSplitter.startNewBlock(methodNode, blockNode.getStartOffset());
            blockNodeStartNewBlock.add(AFlag.SYNTHETIC);
            if (z) {
                blockNodeStartNewBlock.add(AFlag.ORIG_RETURN);
                insnNodeDuplicateReturnInsn = insnNode;
                z = false;
            } else {
                insnNodeDuplicateReturnInsn = duplicateReturnInsn(insnNode);
            }
            blockNodeStartNewBlock.getInstructions().add(insnNodeDuplicateReturnInsn);
            BlockSplitter.removeConnection(blockNode2, blockNode);
            BlockSplitter.connect(blockNode2, blockNodeStartNewBlock);
        }
        cleanExitNodes(methodNode);
        return true;
    }

    @Override // jadx.core.dex.visitors.AbstractVisitor, jadx.core.dex.visitors.IDexTreeVisitor
    public void visit(MethodNode methodNode) {
        if (methodNode.isNoCode()) {
            return;
        }
        processBlocksTree(methodNode);
    }
}
