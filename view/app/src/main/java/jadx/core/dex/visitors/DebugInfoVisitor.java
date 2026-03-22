package jadx.core.dex.visitors;

import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.nodes.parser.DebugInfoParser;
import jadx.core.utils.BlockUtils;
import jadx.core.utils.exceptions.DecodeException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DebugInfoVisitor extends AbstractVisitor {
    @Override // jadx.core.dex.visitors.AbstractVisitor, jadx.core.dex.visitors.IDexTreeVisitor
    public void visit(MethodNode methodNode) throws DecodeException {
        InsnNode insnNode;
        int debugInfoOffset = methodNode.getDebugInfoOffset();
        if (debugInfoOffset > 0) {
            InsnNode[] instructions = methodNode.getInstructions();
            new DebugInfoParser(methodNode, debugInfoOffset, instructions).process();
            if (instructions.length != 0) {
                int length = instructions.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    InsnNode insnNode2 = instructions[i];
                    if (insnNode2 != null) {
                        int sourceLine = insnNode2.getSourceLine();
                        if (sourceLine != 0) {
                            methodNode.setSourceLine(sourceLine - 1);
                        }
                    } else {
                        i++;
                    }
                }
            }
            if (!methodNode.getReturnType().equals(ArgType.VOID)) {
                Iterator it = methodNode.getExitBlocks().iterator();
                while (it.hasNext()) {
                    InsnNode lastInsn = BlockUtils.getLastInsn((BlockNode) it.next());
                    if (lastInsn != null && (insnNode = instructions[lastInsn.getOffset()]) != lastInsn) {
                        RegisterArg registerArg = (RegisterArg) insnNode.getArg(0);
                        ((RegisterArg) lastInsn.getArg(0)).mergeDebugInfo(registerArg.getType(), registerArg.getName());
                        lastInsn.setSourceLine(insnNode.getSourceLine());
                    }
                }
            }
        }
        methodNode.unloadInsnArr();
    }
}
