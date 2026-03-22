package jadx.core.utils;

import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.PhiInsn;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.InsnWrapArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.SSAVar;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
public class InstructionRemover {
    private static final InterfaceC1668b LOG = C1677c.m3845a(InstructionRemover.class);
    private List instrList;
    private final MethodNode mth;
    private final List toRemove;

    public InstructionRemover(MethodNode methodNode) {
        this(methodNode, null);
    }

    public InstructionRemover(MethodNode methodNode, BlockNode blockNode) {
        this.mth = methodNode;
        this.toRemove = new ArrayList();
        if (blockNode != null) {
            this.instrList = blockNode.getInstructions();
        }
    }

    public static void fixUsedInPhiFlag(RegisterArg registerArg) {
        PhiInsn phiInsn = null;
        Iterator it = registerArg.getSVar().getUseList().iterator();
        while (it.hasNext()) {
            InsnNode parentInsn = ((RegisterArg) it.next()).getParentInsn();
            phiInsn = (parentInsn != null && parentInsn.getType() == InsnType.PHI && parentInsn.containsArg(registerArg)) ? (PhiInsn) parentInsn : phiInsn;
        }
        registerArg.getSVar().setUsedInPhi(phiInsn);
    }

    public static void remove(MethodNode methodNode, BlockNode blockNode, int i) {
        List instructions = blockNode.getInstructions();
        unbindInsn(methodNode, (InsnNode) instructions.get(i));
        instructions.remove(i);
    }

    public static void remove(MethodNode methodNode, BlockNode blockNode, InsnNode insnNode) {
        unbindInsn(methodNode, insnNode);
        Iterator it = blockNode.getInstructions().iterator();
        while (it.hasNext()) {
            if (((InsnNode) it.next()) == insnNode) {
                it.remove();
                return;
            }
        }
    }

    public static void remove(MethodNode methodNode, InsnNode insnNode) {
        BlockNode blockByInsn = BlockUtils.getBlockByInsn(methodNode, insnNode);
        if (blockByInsn != null) {
            remove(methodNode, blockByInsn, insnNode);
        }
    }

    public static void removeAll(MethodNode methodNode, BlockNode blockNode, List list) {
        if (list.isEmpty()) {
            return;
        }
        removeAll(methodNode, blockNode.getInstructions(), list);
    }

    private static void removeAll(MethodNode methodNode, List list, List list2) {
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            InsnNode insnNode = (InsnNode) it.next();
            unbindInsn(methodNode, insnNode);
            int size = list.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (list.get(i) == insnNode) {
                    list.remove(i);
                    break;
                }
                i++;
            }
        }
    }

    public static void unbindArgUsage(MethodNode methodNode, InsnArg insnArg) {
        if (!(insnArg instanceof RegisterArg)) {
            if (insnArg instanceof InsnWrapArg) {
                unbindInsn(methodNode, ((InsnWrapArg) insnArg).getWrapInsn());
            }
        } else {
            RegisterArg registerArg = (RegisterArg) insnArg;
            SSAVar sVar = registerArg.getSVar();
            if (sVar != null) {
                sVar.removeUse(registerArg);
            }
        }
    }

    public static void unbindInsn(MethodNode methodNode, InsnNode insnNode) {
        unbindResult(methodNode, insnNode);
        Iterator it = insnNode.getArguments().iterator();
        while (it.hasNext()) {
            unbindArgUsage(methodNode, (InsnArg) it.next());
        }
        if (insnNode.getType() == InsnType.PHI) {
            for (InsnArg insnArg : insnNode.getArguments()) {
                if (insnArg instanceof RegisterArg) {
                    fixUsedInPhiFlag((RegisterArg) insnArg);
                }
            }
        }
        insnNode.add(AFlag.INCONSISTENT_CODE);
    }

    public static void unbindInsnList(MethodNode methodNode, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            unbindInsn(methodNode, (InsnNode) it.next());
        }
    }

    public static void unbindResult(MethodNode methodNode, InsnNode insnNode) {
        RegisterArg result = insnNode.getResult();
        if (result == null || result.getSVar() == null) {
            return;
        }
        methodNode.removeSVar(result.getSVar());
    }

    public void add(InsnNode insnNode) {
        this.toRemove.add(insnNode);
    }

    public void perform() {
        if (this.toRemove.isEmpty()) {
            return;
        }
        removeAll(this.mth, this.instrList, this.toRemove);
        this.toRemove.clear();
    }

    public void setBlock(BlockNode blockNode) {
        this.instrList = blockNode.getInstructions();
    }
}
