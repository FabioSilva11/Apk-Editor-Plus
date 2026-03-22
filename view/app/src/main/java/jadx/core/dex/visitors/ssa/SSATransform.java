package jadx.core.dex.visitors.ssa;

import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.nodes.PhiListAttr;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.PhiInsn;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.SSAVar;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.visitors.AbstractVisitor;
import jadx.core.dex.visitors.JadxVisitor;
import jadx.core.dex.visitors.blocksmaker.BlockFinish;
import jadx.core.utils.InsnList;
import jadx.core.utils.InstructionRemover;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@JadxVisitor(desc = "Calculate Single Side Assign (SSA) variables", name = "SSATransform", runAfter = {BlockFinish.class})
public class SSATransform extends AbstractVisitor {
    public static PhiInsn addPhi(MethodNode methodNode, BlockNode blockNode, int i) {
        PhiListAttr phiListAttr;
        int i2;
        PhiListAttr phiListAttr2 = (PhiListAttr) blockNode.get(AType.PHI_LIST);
        if (phiListAttr2 == null) {
            PhiListAttr phiListAttr3 = new PhiListAttr();
            blockNode.addAttr(phiListAttr3);
            phiListAttr = phiListAttr3;
        } else {
            phiListAttr = phiListAttr2;
        }
        int size = blockNode.getPredecessors().size();
        if (methodNode.getEnterBlock() == blockNode) {
            Iterator it = methodNode.getArguments(true).iterator();
            while (it.hasNext()) {
                if (((RegisterArg) it.next()).getRegNum() == i) {
                    i2 = size + 1;
                    break;
                }
            }
            i2 = size;
        } else {
            i2 = size;
        }
        PhiInsn phiInsn = new PhiInsn(i, i2);
        phiListAttr.getList().add(phiInsn);
        phiInsn.setOffset(blockNode.getStartOffset());
        blockNode.getInstructions().add(0, phiInsn);
        return phiInsn;
    }

    private static void fixLastAssignInTry(MethodNode methodNode) {
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            PhiListAttr phiListAttr = (PhiListAttr) blockNode.get(AType.PHI_LIST);
            if (phiListAttr != null && blockNode.contains(AType.EXC_HANDLER)) {
                Iterator it = phiListAttr.getList().iterator();
                while (it.hasNext()) {
                    fixPhiInTryCatch((PhiInsn) it.next());
                }
            }
        }
    }

    private static void fixPhiInTryCatch(PhiInsn phiInsn) {
        int argsCount = phiInsn.getArgsCount();
        int i = 0;
        while (i < argsCount) {
            RegisterArg arg = phiInsn.getArg(i);
            InsnNode assignInsn = arg.getAssignInsn();
            if (assignInsn == null || assignInsn.getResult() == null || !assignInsn.contains(AFlag.TRY_LEAVE) || !phiInsn.removeArg(arg)) {
                i++;
            } else {
                argsCount--;
            }
        }
    }

    private static boolean fixPhiWithSameArgs(MethodNode methodNode, BlockNode blockNode, PhiInsn phiInsn) {
        boolean z = true;
        if (phiInsn.getArgsCount() != 0) {
            if (phiInsn.getArgsCount() != 1 && !isSameArgs(phiInsn)) {
                z = false;
            }
            if (z) {
                return replacePhiWithMove(methodNode, blockNode, phiInsn, phiInsn.getArg(0));
            }
            return false;
        }
        for (RegisterArg registerArg : phiInsn.getResult().getSVar().getUseList()) {
            InsnNode parentInsn = registerArg.getParentInsn();
            if (parentInsn != null && parentInsn.getType() == InsnType.PHI) {
                phiInsn.removeArg(registerArg);
            }
        }
        InstructionRemover.remove(methodNode, blockNode, phiInsn);
        return true;
    }

    private static boolean fixUselessPhi(MethodNode methodNode) {
        boolean z;
        InsnNode parentInsn;
        boolean z2 = false;
        ArrayList arrayList = new ArrayList();
        Iterator it = methodNode.getSVars().iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            SSAVar sSAVar = (SSAVar) it.next();
            if (sSAVar.getUseCount() == 0 && (parentInsn = sSAVar.getAssign().getParentInsn()) != null && parentInsn.getType() == InsnType.PHI) {
                arrayList.add((PhiInsn) parentInsn);
                z2 = true;
            } else {
                z2 = z;
            }
        }
        boolean z3 = z;
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            PhiListAttr phiListAttr = (PhiListAttr) blockNode.get(AType.PHI_LIST);
            if (phiListAttr != null) {
                Iterator it2 = phiListAttr.getList().iterator();
                while (it2.hasNext()) {
                    if (fixPhiWithSameArgs(methodNode, blockNode, (PhiInsn) it2.next())) {
                        it2.remove();
                        z3 = true;
                    }
                }
            }
        }
        removePhiList(methodNode, arrayList);
        return z3;
    }

    private static void initPhiInEnterBlock(SSAVar[] sSAVarArr, BlockNode blockNode) {
        PhiListAttr phiListAttr = (PhiListAttr) blockNode.get(AType.PHI_LIST);
        if (phiListAttr != null) {
            for (PhiInsn phiInsn : phiListAttr.getList()) {
                SSAVar sSAVar = sSAVarArr[phiInsn.getResult().getRegNum()];
                if (sSAVar != null) {
                    sSAVar.use(phiInsn.bindArg(blockNode));
                    sSAVar.setUsedInPhi(phiInsn);
                }
            }
        }
    }

    private static boolean inlinePhiInsn(MethodNode methodNode, BlockNode blockNode, PhiInsn phiInsn) {
        InsnNode assignInsn;
        SSAVar sVar = phiInsn.getResult().getSVar();
        if (sVar == null) {
            return false;
        }
        RegisterArg arg = phiInsn.getArg(0);
        if (arg.getSVar() == null) {
            return false;
        }
        for (RegisterArg registerArg : new ArrayList(sVar.getUseList())) {
            InsnNode parentInsn = registerArg.getParentInsn();
            if (parentInsn == null || parentInsn == phiInsn) {
                return false;
            }
            registerArg.getSVar().removeUse(registerArg);
            RegisterArg registerArgDuplicate = arg.duplicate();
            if (!parentInsn.replaceArg(registerArg, registerArgDuplicate)) {
                return false;
            }
            registerArgDuplicate.getSVar().use(registerArgDuplicate);
            registerArgDuplicate.setName(registerArg.getName());
            registerArgDuplicate.setType(registerArg.getType());
        }
        if (blockNode.contains(AType.EXC_HANDLER) && (assignInsn = arg.getAssignInsn()) != null) {
            assignInsn.add(AFlag.DONT_INLINE);
        }
        InstructionRemover.unbindInsn(methodNode, phiInsn);
        return true;
    }

    private static boolean isSameArgs(PhiInsn phiInsn) {
        SSAVar sVar = null;
        for (int i = 0; i < phiInsn.getArgsCount(); i++) {
            RegisterArg arg = phiInsn.getArg(i);
            if (sVar == null) {
                sVar = arg.getSVar();
            } else if (sVar != arg.getSVar()) {
                return false;
            }
        }
        return true;
    }

    private static SSAVar newSSAVar(MethodNode methodNode, int[] iArr, RegisterArg registerArg, int i) {
        int i2 = iArr[i];
        iArr[i] = i2 + 1;
        return methodNode.makeNewSVar(i, i2, registerArg);
    }

    private static void placePhi(MethodNode methodNode, int i, LiveVarAnalysis liveVarAnalysis) {
        List basicBlocks = methodNode.getBasicBlocks();
        int size = basicBlocks.size();
        BitSet bitSet = new BitSet(size);
        BitSet bitSet2 = new BitSet(size);
        LinkedList linkedList = new LinkedList();
        BitSet assignBlocks = liveVarAnalysis.getAssignBlocks(i);
        for (int iNextSetBit = assignBlocks.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = assignBlocks.nextSetBit(iNextSetBit + 1)) {
            bitSet2.set(iNextSetBit);
            linkedList.add(basicBlocks.get(iNextSetBit));
        }
        while (!linkedList.isEmpty()) {
            BitSet domFrontier = ((BlockNode) linkedList.pop()).getDomFrontier();
            for (int iNextSetBit2 = domFrontier.nextSetBit(0); iNextSetBit2 >= 0; iNextSetBit2 = domFrontier.nextSetBit(iNextSetBit2 + 1)) {
                if (!bitSet.get(iNextSetBit2) && liveVarAnalysis.isLive(iNextSetBit2, i)) {
                    BlockNode blockNode = (BlockNode) basicBlocks.get(iNextSetBit2);
                    addPhi(methodNode, blockNode, i);
                    bitSet.set(iNextSetBit2);
                    if (!bitSet2.get(iNextSetBit2)) {
                        bitSet2.set(iNextSetBit2);
                        linkedList.add(blockNode);
                    }
                }
            }
        }
    }

    private static void process(MethodNode methodNode) {
        int i = 0;
        LiveVarAnalysis liveVarAnalysis = new LiveVarAnalysis(methodNode);
        liveVarAnalysis.runAnalysis();
        int regsCount = methodNode.getRegsCount();
        for (int i2 = 0; i2 < regsCount; i2++) {
            placePhi(methodNode, i2, liveVarAnalysis);
        }
        renameVariables(methodNode);
        fixLastAssignInTry(methodNode);
        removeBlockerInsns(methodNode);
        while (true) {
            boolean zFixUselessPhi = fixUselessPhi(methodNode);
            int i3 = i + 1;
            if (i > 50) {
                throw new JadxRuntimeException("Phi nodes fix limit reached!");
            }
            if (!zFixUselessPhi) {
                return;
            } else {
                i = i3;
            }
        }
    }

    private static boolean removeBlockerInsns(MethodNode methodNode) {
        boolean z = false;
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            PhiListAttr phiListAttr = (PhiListAttr) blockNode.get(AType.PHI_LIST);
            if (phiListAttr != null) {
                for (PhiInsn phiInsn : phiListAttr.getList()) {
                    int i = 0;
                    while (i < phiInsn.getArgsCount()) {
                        RegisterArg arg = phiInsn.getArg(i);
                        InsnNode assignInsn = arg.getAssignInsn();
                        if (assignInsn != null && assignInsn.contains(AFlag.REMOVE)) {
                            phiInsn.removeArg(arg);
                            InstructionRemover.remove(methodNode, blockNode, assignInsn);
                            z = true;
                        }
                        i++;
                        z = z;
                    }
                }
            }
        }
        return z;
    }

    private static boolean removePhiList(MethodNode methodNode, List list) {
        SSAVar sVar;
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            PhiListAttr phiListAttr = (PhiListAttr) blockNode.get(AType.PHI_LIST);
            if (phiListAttr != null) {
                List list2 = phiListAttr.getList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    PhiInsn phiInsn = (PhiInsn) it.next();
                    if (list2.remove(phiInsn)) {
                        for (InsnArg insnArg : phiInsn.getArguments()) {
                            if (insnArg != null && (sVar = ((RegisterArg) insnArg).getSVar()) != null) {
                                sVar.setUsedInPhi(null);
                            }
                        }
                        InstructionRemover.remove(methodNode, blockNode, phiInsn);
                    }
                }
                if (list2.isEmpty()) {
                    blockNode.remove(AType.PHI_LIST);
                }
            }
        }
        list.clear();
        return true;
    }

    private static void renameVar(MethodNode methodNode, SSAVar[] sSAVarArr, int[] iArr, BlockNode blockNode) {
        SSAVar[] sSAVarArr2 = (SSAVar[]) Arrays.copyOf(sSAVarArr, sSAVarArr.length);
        for (InsnNode insnNode : blockNode.getInstructions()) {
            if (insnNode.getType() != InsnType.PHI) {
                for (InsnArg insnArg : insnNode.getArguments()) {
                    if (insnArg.isRegister()) {
                        RegisterArg registerArg = (RegisterArg) insnArg;
                        int regNum = registerArg.getRegNum();
                        SSAVar sSAVar = sSAVarArr[regNum];
                        if (sSAVar == null) {
                            throw new JadxRuntimeException("Not initialized variable reg: " + regNum + ", insn: " + insnNode + ", block:" + blockNode + ", method: " + methodNode);
                        }
                        sSAVar.use(registerArg);
                    }
                }
            }
            RegisterArg result = insnNode.getResult();
            if (result != null) {
                int regNum2 = result.getRegNum();
                sSAVarArr[regNum2] = newSSAVar(methodNode, iArr, result, regNum2);
            }
        }
        Iterator it = blockNode.getSuccessors().iterator();
        while (it.hasNext()) {
            PhiListAttr phiListAttr = (PhiListAttr) ((BlockNode) it.next()).get(AType.PHI_LIST);
            if (phiListAttr != null) {
                for (PhiInsn phiInsn : phiListAttr.getList()) {
                    SSAVar sSAVar2 = sSAVarArr[phiInsn.getResult().getRegNum()];
                    if (sSAVar2 != null) {
                        sSAVar2.use(phiInsn.bindArg(blockNode));
                        sSAVar2.setUsedInPhi(phiInsn);
                    }
                }
            }
        }
        Iterator it2 = blockNode.getDominatesOn().iterator();
        while (it2.hasNext()) {
            renameVar(methodNode, sSAVarArr, iArr, (BlockNode) it2.next());
        }
        System.arraycopy(sSAVarArr2, 0, sSAVarArr, 0, sSAVarArr.length);
    }

    private static void renameVariables(MethodNode methodNode) {
        if (!methodNode.getSVars().isEmpty()) {
            throw new JadxRuntimeException("SSA rename variables already executed");
        }
        int regsCount = methodNode.getRegsCount();
        SSAVar[] sSAVarArr = new SSAVar[regsCount];
        int[] iArr = new int[regsCount];
        for (RegisterArg registerArg : methodNode.getArguments(true)) {
            int regNum = registerArg.getRegNum();
            sSAVarArr[regNum] = newSSAVar(methodNode, iArr, registerArg, regNum);
        }
        BlockNode enterBlock = methodNode.getEnterBlock();
        initPhiInEnterBlock(sSAVarArr, enterBlock);
        renameVar(methodNode, sSAVarArr, iArr, enterBlock);
    }

    private static boolean replacePhiWithMove(MethodNode methodNode, BlockNode blockNode, PhiInsn phiInsn, RegisterArg registerArg) {
        List instructions = blockNode.getInstructions();
        int index = InsnList.getIndex(instructions, phiInsn);
        if (index == -1) {
            return false;
        }
        SSAVar sVar = phiInsn.getResult().getSVar();
        SSAVar sVar2 = registerArg.getSVar();
        if (sVar2 != null) {
            sVar2.removeUse(registerArg);
            sVar2.setUsedInPhi(null);
        }
        if (inlinePhiInsn(methodNode, blockNode, phiInsn)) {
            instructions.remove(index);
            return true;
        }
        sVar.setUsedInPhi(null);
        InsnNode insnNode = new InsnNode(InsnType.MOVE, 1);
        insnNode.add(AFlag.SYNTHETIC);
        insnNode.setResult(phiInsn.getResult());
        insnNode.addArg(registerArg);
        registerArg.getSVar().use(registerArg);
        instructions.set(index, insnNode);
        return true;
    }

    @Override // jadx.core.dex.visitors.AbstractVisitor, jadx.core.dex.visitors.IDexTreeVisitor
    public void visit(MethodNode methodNode) {
        if (methodNode.isNoCode()) {
            return;
        }
        process(methodNode);
    }
}
