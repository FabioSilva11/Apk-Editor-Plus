package jadx.core.utils;

import jadx.core.codegen.CodeWriter;
import jadx.core.codegen.InsnGen;
import jadx.core.codegen.MethodGen;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.nodes.PhiListAttr;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.PhiInsn;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.SSAVar;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.IBlock;
import jadx.core.dex.nodes.IContainer;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.visitors.DotGraphVisitor;
import jadx.core.dex.visitors.regions.DepthRegionTraversal;
import jadx.core.dex.visitors.regions.TracedRegionVisitor;
import jadx.core.utils.exceptions.CodegenException;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DebugUtils {
    private static final InterfaceC1668b LOG = C1677c.m3845a(DebugUtils.class);

    private static void checkPHI(MethodNode methodNode) {
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            ArrayList arrayList = new ArrayList();
            for (InsnNode insnNode : blockNode.getInstructions()) {
                if (insnNode.getType() == InsnType.PHI) {
                    PhiInsn phiInsn = (PhiInsn) insnNode;
                    arrayList.add(phiInsn);
                    if (phiInsn.getArgsCount() != phiInsn.getBlockBinds().size()) {
                        throw new JadxRuntimeException("Incorrect args and binds in PHI");
                    }
                    if (phiInsn.getArgsCount() == 0) {
                        throw new JadxRuntimeException("No args and binds in PHI");
                    }
                    for (InsnArg insnArg : insnNode.getArguments()) {
                        if (!(insnArg instanceof RegisterArg)) {
                            throw new JadxRuntimeException("Not register in phi insn");
                        }
                        if (phiInsn.getBlockByArg((RegisterArg) insnArg) == null) {
                            throw new JadxRuntimeException("Predecessor block not found");
                        }
                    }
                }
            }
            PhiListAttr phiListAttr = (PhiListAttr) blockNode.get(AType.PHI_LIST);
            if (phiListAttr != null) {
                List list = phiListAttr.getList();
                if (list.isEmpty()) {
                    throw new JadxRuntimeException("Empty PHI list attribute");
                }
                if (!arrayList.containsAll(list) || !list.containsAll(arrayList)) {
                    throw new JadxRuntimeException("Instructions not match");
                }
            } else if (!arrayList.isEmpty()) {
                throw new JadxRuntimeException("Missing PHI list attribute");
            }
        }
        for (SSAVar sSAVar : methodNode.getSVars()) {
            PhiInsn usedInPhi = sSAVar.getUsedInPhi();
            if (usedInPhi != null) {
                boolean z = false;
                Iterator it = sSAVar.getUseList().iterator();
                while (it.hasNext()) {
                    InsnNode parentInsn = ((RegisterArg) it.next()).getParentInsn();
                    if (parentInsn != null && parentInsn == usedInPhi) {
                        z = true;
                    }
                    z = z;
                }
                if (!z) {
                    throw new JadxRuntimeException("Used in phi incorrect");
                }
            }
        }
    }

    public static void checkSSA(MethodNode methodNode) {
        Iterator it = methodNode.getBasicBlocks().iterator();
        while (it.hasNext()) {
            for (InsnNode insnNode : ((BlockNode) it.next()).getInstructions()) {
                if (insnNode.getResult() != null) {
                    checkSSAVar(methodNode, insnNode, insnNode.getResult());
                }
                for (InsnArg insnArg : insnNode.getArguments()) {
                    if (insnArg instanceof RegisterArg) {
                        checkSSAVar(methodNode, insnNode, (RegisterArg) insnArg);
                    }
                }
            }
        }
        checkPHI(methodNode);
    }

    private static void checkSSAVar(MethodNode methodNode, InsnNode insnNode, RegisterArg registerArg) {
        SSAVar sVar = registerArg.getSVar();
        if (sVar == null) {
            throw new JadxRuntimeException("Null SSA var in " + insnNode + ", mth: " + methodNode);
        }
        for (RegisterArg registerArg2 : sVar.getUseList()) {
            InsnNode parentInsn = registerArg2.getParentInsn();
            if (parentInsn != null && !parentInsn.containsArg(registerArg2)) {
                throw new JadxRuntimeException("Incorrect use info in PHI insn");
            }
        }
    }

    public static void dump(MethodNode methodNode) throws Throwable {
        dump(methodNode, "");
    }

    public static void dump(MethodNode methodNode, String str) throws Throwable {
        File file = new File("test-graph" + str + "-tmp");
        DotGraphVisitor.dump(file).visit(methodNode);
        DotGraphVisitor.dumpRaw(file).visit(methodNode);
        DotGraphVisitor.dumpRegions(file).visit(methodNode);
    }

    private static void printInsns(MethodNode methodNode, String str, IBlock iBlock) {
        for (InsnNode insnNode : iBlock.getInstructions()) {
            try {
                InsnGen insnGen = new InsnGen(MethodGen.getFallbackMethodGen(methodNode), true);
                CodeWriter codeWriter = new CodeWriter();
                insnGen.makeInsn(insnNode, codeWriter);
                LOG.mo3816a("{} - {}", str, codeWriter.toString().substring(CodeWriter.f4685NL.length()));
            } catch (CodegenException e) {
                LOG.mo3816a("{} - {}", str, insnNode);
            }
        }
    }

    private static void printRegion(MethodNode methodNode, IRegion iRegion, String str, boolean z) {
        LOG.mo3816a("{}{}", str, iRegion);
        String str2 = str + "|  ";
        for (IContainer iContainer : iRegion.getSubBlocks()) {
            if (iContainer instanceof IRegion) {
                printRegion(methodNode, (IRegion) iContainer, str2, z);
            } else {
                LOG.mo3818a("{}{} {}", str2, iContainer, iContainer.getAttributesString());
                if (z && (iContainer instanceof IBlock)) {
                    printInsns(methodNode, str2, (IBlock) iContainer);
                }
            }
        }
    }

    public static void printRegion(MethodNode methodNode, IRegion iRegion, boolean z) {
        printRegion(methodNode, iRegion, "", z);
    }

    public static void printRegions(MethodNode methodNode) {
        printRegions(methodNode, false);
    }

    public static void printRegions(MethodNode methodNode, boolean z) {
        LOG.mo3815a("|{}", methodNode);
        printRegion(methodNode, methodNode.getRegion(), "|  ", z);
    }

    public static void printRegionsWithBlock(MethodNode methodNode, final BlockNode blockNode) {
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        DepthRegionTraversal.traverse(methodNode, new TracedRegionVisitor() { // from class: jadx.core.utils.DebugUtils.1
            @Override // jadx.core.dex.visitors.regions.TracedRegionVisitor
            public final void processBlockTraced(MethodNode methodNode2, IBlock iBlock, IRegion iRegion) {
                if (blockNode.equals(iBlock)) {
                    linkedHashSet.add(iRegion);
                }
            }
        });
        LOG.mo3816a(" Found block: {} in regions: {}", blockNode, linkedHashSet);
    }
}
