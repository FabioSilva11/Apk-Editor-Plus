package jadx.core.dex.visitors;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.trycatch.CatchAttr;

/* JADX INFO: loaded from: classes.dex */
public class FallbackModeVisitor extends AbstractVisitor {
    @Override // jadx.core.dex.visitors.AbstractVisitor, jadx.core.dex.visitors.IDexTreeVisitor
    public void visit(MethodNode methodNode) {
        CatchAttr catchAttr;
        if (methodNode.isNoCode()) {
            return;
        }
        for (InsnNode insnNode : methodNode.getInstructions()) {
            if (insnNode != null && (catchAttr = (CatchAttr) insnNode.get(AType.CATCH_BLOCK)) != null) {
                switch (insnNode.getType()) {
                    case RETURN:
                    case IF:
                    case GOTO:
                    case MOVE:
                    case MOVE_EXCEPTION:
                    case ARITH:
                    case NEG:
                    case CONST:
                    case CONST_STR:
                    case CONST_CLASS:
                    case CMP_L:
                    case CMP_G:
                        catchAttr.getTryBlock().removeInsn(methodNode, insnNode);
                        break;
                }
            }
        }
    }
}
