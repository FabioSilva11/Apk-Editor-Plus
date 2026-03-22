package jadx.core.dex.instructions.args;

import com.p016a.p019b.p033d.p034a.AbstractC0692f;
import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.utils.InsnUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class InsnArg extends Typed {
    protected InsnNode parentInsn;

    private static int getArgIndex(InsnNode insnNode, InsnArg insnArg) {
        int argsCount = insnNode.getArgsCount();
        for (int i = 0; i < argsCount; i++) {
            if (insnNode.getArg(i) == insnArg) {
                return i;
            }
        }
        return -1;
    }

    public static LiteralArg lit(long j, ArgType argType) {
        return new LiteralArg(j, argType);
    }

    public static LiteralArg lit(AbstractC0692f abstractC0692f, ArgType argType) {
        return lit(abstractC0692f.m1303h(), argType);
    }

    public static RegisterArg reg(int i, ArgType argType) {
        return new RegisterArg(i, argType);
    }

    public static RegisterArg reg(int i, ArgType argType, boolean z) {
        return z ? new TypeImmutableArg(i, argType) : new RegisterArg(i, argType);
    }

    public static RegisterArg reg(AbstractC0692f abstractC0692f, int i, ArgType argType) {
        return reg(InsnUtils.getArg(abstractC0692f, i), argType);
    }

    public static TypeImmutableArg typeImmutableReg(int i, ArgType argType) {
        return new TypeImmutableArg(i, argType);
    }

    public static void updateParentInsn(InsnNode insnNode, InsnNode insnNode2) {
        ArrayList arrayList = new ArrayList();
        insnNode.getRegisterArgs(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((RegisterArg) it.next()).setParentInsn(insnNode2);
        }
    }

    private static InsnWrapArg wrap(InsnNode insnNode) {
        return new InsnWrapArg(insnNode);
    }

    public static InsnArg wrapArg(InsnNode insnNode) {
        switch (insnNode.getType()) {
            case MOVE:
            case CONST:
                return insnNode.getArg(0);
            case CONST_STR:
                InsnWrapArg insnWrapArgWrap = wrap(insnNode);
                insnWrapArgWrap.setType(ArgType.STRING);
                return insnWrapArgWrap;
            case CONST_CLASS:
                InsnWrapArg insnWrapArgWrap2 = wrap(insnNode);
                insnWrapArgWrap2.setType(ArgType.CLASS);
                return insnWrapArgWrap2;
            default:
                return wrap(insnNode);
        }
    }

    public InsnNode getParentInsn() {
        return this.parentInsn;
    }

    public boolean isField() {
        return false;
    }

    public boolean isInsnWrap() {
        return false;
    }

    public boolean isLiteral() {
        return false;
    }

    public boolean isNamed() {
        return false;
    }

    public boolean isRegister() {
        return false;
    }

    public boolean isThis() {
        return false;
    }

    public void setParentInsn(InsnNode insnNode) {
        this.parentInsn = insnNode;
    }

    public InsnArg wrapInstruction(InsnNode insnNode) {
        int argIndex;
        InsnNode insnNode2 = this.parentInsn;
        if (insnNode2 == null || insnNode2 == insnNode || (argIndex = getArgIndex(insnNode2, this)) == -1) {
            return null;
        }
        insnNode.add(AFlag.WRAPPED);
        InsnArg insnArgWrapArg = wrapArg(insnNode);
        insnNode2.setArg(argIndex, insnArgWrapArg);
        return insnArgWrapArg;
    }
}
