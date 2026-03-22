package jadx.core.dex.visitors.typeinference;

import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.nodes.DexNode;
import jadx.core.dex.nodes.InsnNode;

/* JADX INFO: loaded from: classes.dex */
public class SelectTypeVisitor {
    private SelectTypeVisitor() {
    }

    private static void selectType(DexNode dexNode, InsnArg insnArg) {
        ArgType type = insnArg.getType();
        insnArg.setType(ArgType.merge(dexNode, type, type.selectFirst()));
    }

    public static void visit(DexNode dexNode, InsnNode insnNode) {
        RegisterArg result = insnNode.getResult();
        if (result != null && !result.getType().isTypeKnown()) {
            selectType(dexNode, result);
        }
        for (InsnArg insnArg : insnNode.getArguments()) {
            if (!insnArg.getType().isTypeKnown()) {
                selectType(dexNode, insnArg);
            }
        }
    }
}
