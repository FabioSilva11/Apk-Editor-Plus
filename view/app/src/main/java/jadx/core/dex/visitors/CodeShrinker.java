package jadx.core.dex.visitors;

import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.InsnWrapArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.SSAVar;
import jadx.core.dex.instructions.mods.ConstructorInsn;
import jadx.core.dex.instructions.mods.TernaryInsn;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.utils.BlockUtils;
import jadx.core.utils.EmptyBitSet;
import jadx.core.utils.InsnList;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CodeShrinker extends AbstractVisitor {

    final class ArgsInfo {
        private final List args;
        private final List argsList;
        private int inlineBorder;
        private ArgsInfo inlinedInsn;
        private final InsnNode insn;
        private final int pos;

        public ArgsInfo(InsnNode insnNode, List list, int i) {
            this.insn = insnNode;
            this.argsList = list;
            this.pos = i;
            this.inlineBorder = i;
            this.args = getArgs(insnNode);
        }

        private static void addArgs(InsnNode insnNode, List list) {
            if (insnNode.getType() == InsnType.CONSTRUCTOR) {
                list.add(((ConstructorInsn) insnNode).getInstanceArg());
            } else if (insnNode.getType() == InsnType.TERNARY) {
                list.addAll(((TernaryInsn) insnNode).getCondition().getRegisterArgs());
            }
            for (InsnArg insnArg : insnNode.getArguments()) {
                if (insnArg.isRegister()) {
                    list.add((RegisterArg) insnArg);
                }
            }
            for (InsnArg insnArg2 : insnNode.getArguments()) {
                if (insnArg2.isInsnWrap()) {
                    addArgs(((InsnWrapArg) insnArg2).getWrapInsn(), list);
                }
            }
        }

        private boolean canMove(int i, int i2) {
            BitSet bitSet;
            ArgsInfo argsInfo = (ArgsInfo) this.argsList.get(i);
            List args = argsInfo.getArgs();
            int i3 = i + 1;
            if (i3 == i2) {
                return true;
            }
            if (i3 > i2) {
                throw new JadxRuntimeException("Invalid inline insn positions: " + i3 + " - " + i2);
            }
            if (!args.isEmpty()) {
                bitSet = new BitSet();
                Iterator it = args.iterator();
                while (it.hasNext()) {
                    bitSet.set(((RegisterArg) it.next()).getRegNum());
                }
            } else {
                if (argsInfo.insn.isConstInsn()) {
                    return true;
                }
                bitSet = EmptyBitSet.EMPTY;
            }
            while (i3 < i2) {
                ArgsInfo argsInfo2 = (ArgsInfo) this.argsList.get(i3);
                if (argsInfo2.getInlinedInsn() != this) {
                    InsnNode insnNode = argsInfo2.insn;
                    if (!insnNode.canReorder() || usedArgAssign(insnNode, bitSet)) {
                        return false;
                    }
                }
                i3++;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List getArgs() {
            return this.args;
        }

        public static List getArgs(InsnNode insnNode) {
            LinkedList linkedList = new LinkedList();
            addArgs(insnNode, linkedList);
            return linkedList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean usedArgAssign(InsnNode insnNode, BitSet bitSet) {
            RegisterArg result = insnNode.getResult();
            return result != null && bitSet.get(result.getRegNum());
        }

        public final WrapInfo checkInline(int i, RegisterArg registerArg) {
            if (!registerArg.isThis() && (i >= this.inlineBorder || !canMove(i, this.inlineBorder))) {
                return null;
            }
            this.inlineBorder = i;
            return inline(i, registerArg);
        }

        public final ArgsInfo getInlinedInsn() {
            ArgsInfo inlinedInsn;
            if (this.inlinedInsn != null && (inlinedInsn = this.inlinedInsn.getInlinedInsn()) != null) {
                this.inlinedInsn = inlinedInsn;
            }
            return this.inlinedInsn;
        }

        public final InsnNode getInsn() {
            return this.insn;
        }

        public final WrapInfo inline(int i, RegisterArg registerArg) {
            ArgsInfo argsInfo = (ArgsInfo) this.argsList.get(i);
            argsInfo.inlinedInsn = this;
            return new WrapInfo(argsInfo.insn, registerArg);
        }

        public final String toString() {
            return "ArgsInfo: |" + this.inlineBorder + " ->" + (this.inlinedInsn == null ? "-" : Integer.valueOf(this.inlinedInsn.pos)) + " " + this.args + " : " + this.insn;
        }
    }

    final class WrapInfo {
        private final RegisterArg arg;
        private final InsnNode insn;

        public WrapInfo(InsnNode insnNode, RegisterArg registerArg) {
            this.insn = insnNode;
            this.arg = registerArg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RegisterArg getArg() {
            return this.arg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public InsnNode getInsn() {
            return this.insn;
        }

        public final String toString() {
            return "WrapInfo: " + this.arg + " -> " + this.insn;
        }
    }

    private static boolean canMoveBetweenBlocks(InsnNode insnNode, BlockNode blockNode, BlockNode blockNode2, InsnNode insnNode2) {
        if (!BlockUtils.isPathExists(blockNode, blockNode2)) {
            return false;
        }
        List args = ArgsInfo.getArgs(insnNode);
        BitSet bitSet = new BitSet();
        Iterator it = args.iterator();
        while (it.hasNext()) {
            bitSet.set(((RegisterArg) it.next()).getRegNum());
        }
        boolean z = false;
        for (InsnNode insnNode3 : blockNode.getInstructions()) {
            if (z && (!insnNode3.canReorder() || ArgsInfo.usedArgAssign(insnNode3, bitSet))) {
                return false;
            }
            z = insnNode3 == insnNode ? true : z;
        }
        Set allPathsBlocks = BlockUtils.getAllPathsBlocks(blockNode, blockNode2);
        allPathsBlocks.remove(blockNode);
        allPathsBlocks.remove(blockNode2);
        Iterator it2 = allPathsBlocks.iterator();
        while (it2.hasNext()) {
            for (InsnNode insnNode4 : ((BlockNode) it2.next()).getInstructions()) {
                if (!insnNode4.canReorder() || ArgsInfo.usedArgAssign(insnNode4, bitSet)) {
                    return false;
                }
            }
        }
        for (InsnNode insnNode5 : blockNode2.getInstructions()) {
            if (insnNode5 == insnNode2) {
                return true;
            }
            if (!insnNode5.canReorder() || ArgsInfo.usedArgAssign(insnNode5, bitSet)) {
                return false;
            }
        }
        throw new JadxRuntimeException("Can't process instruction move : " + blockNode);
    }

    private static boolean inline(RegisterArg registerArg, InsnNode insnNode, BlockNode blockNode) {
        InsnNode parentInsn = registerArg.getParentInsn();
        if (parentInsn != null && parentInsn.getType() == InsnType.RETURN) {
            parentInsn.setSourceLine(insnNode.getSourceLine());
        }
        boolean z = registerArg.wrapInstruction(insnNode) != null;
        if (z) {
            InsnList.remove(blockNode, insnNode);
        }
        return z;
    }

    private static void shrinkBlock(MethodNode methodNode, BlockNode blockNode) {
        InsnNode parentInsn;
        if (blockNode.getInstructions().isEmpty()) {
            return;
        }
        InsnList insnList = new InsnList(blockNode.getInstructions());
        int size = insnList.size();
        ArrayList<ArgsInfo> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new ArgsInfo(insnList.get(i), arrayList, i));
        }
        ArrayList<WrapInfo> arrayList2 = new ArrayList();
        for (ArgsInfo argsInfo : arrayList) {
            List args = argsInfo.getArgs();
            if (!args.isEmpty()) {
                ListIterator listIterator = args.listIterator(args.size());
                while (listIterator.hasPrevious()) {
                    RegisterArg registerArg = (RegisterArg) listIterator.previous();
                    SSAVar sVar = registerArg.getSVar();
                    if (sVar != null && (sVar.getVariableUseCount() == 1 || registerArg.isThis())) {
                        if (!sVar.contains(AFlag.DONT_INLINE) && (parentInsn = sVar.getAssign().getParentInsn()) != null && !parentInsn.contains(AFlag.DONT_INLINE)) {
                            int index = insnList.getIndex(parentInsn);
                            if (index != -1) {
                                WrapInfo wrapInfoCheckInline = argsInfo.checkInline(index, registerArg);
                                if (wrapInfoCheckInline != null) {
                                    arrayList2.add(wrapInfoCheckInline);
                                }
                            } else {
                                BlockNode blockByInsn = BlockUtils.getBlockByInsn(methodNode, parentInsn);
                                if (blockByInsn != null && parentInsn != registerArg.getParentInsn() && canMoveBetweenBlocks(parentInsn, blockByInsn, blockNode, argsInfo.getInsn())) {
                                    inline(registerArg, parentInsn, blockByInsn);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        for (WrapInfo wrapInfo : arrayList2) {
            inline(wrapInfo.getArg(), wrapInfo.getInsn(), blockNode);
        }
    }

    public static void shrinkMethod(MethodNode methodNode) {
        if (methodNode.isNoCode() || methodNode.contains(AFlag.DONT_SHRINK)) {
            return;
        }
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            shrinkBlock(methodNode, blockNode);
            simplifyMoveInsns(blockNode);
        }
    }

    private static void simplifyMoveInsns(BlockNode blockNode) {
        List instructions = blockNode.getInstructions();
        int size = instructions.size();
        for (int i = 0; i < size; i++) {
            InsnNode insnNode = (InsnNode) instructions.get(i);
            if (insnNode.getType() == InsnType.MOVE) {
                InsnArg arg = insnNode.getArg(0);
                if (arg.isInsnWrap()) {
                    InsnNode wrapInsn = ((InsnWrapArg) arg).getWrapInsn();
                    wrapInsn.setResult(insnNode.getResult());
                    wrapInsn.copyAttributesFrom(insnNode);
                    wrapInsn.setOffset(insnNode.getOffset());
                    wrapInsn.remove(AFlag.WRAPPED);
                    blockNode.getInstructions().set(i, wrapInsn);
                }
            }
        }
    }

    @Override // jadx.core.dex.visitors.AbstractVisitor, jadx.core.dex.visitors.IDexTreeVisitor
    public void visit(MethodNode methodNode) {
        shrinkMethod(methodNode);
    }
}
