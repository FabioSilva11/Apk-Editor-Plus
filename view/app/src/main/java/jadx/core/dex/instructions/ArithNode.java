package jadx.core.dex.instructions;

import com.p016a.p019b.p033d.p034a.AbstractC0692f;
import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.utils.InsnUtils;

/* JADX INFO: loaded from: classes.dex */
public class ArithNode extends InsnNode {

    /* JADX INFO: renamed from: op */
    private final ArithOp f4688op;

    public ArithNode(AbstractC0692f abstractC0692f, ArithOp arithOp, ArgType argType, boolean z) {
        super(InsnType.ARITH, 2);
        this.f4688op = arithOp;
        setResult(InsnArg.reg(abstractC0692f, 0, argType));
        int iMo1264m = abstractC0692f.mo1264m();
        if (z) {
            if (iMo1264m == 1) {
                addReg(abstractC0692f, 0, argType);
                addLit(abstractC0692f, argType);
                return;
            } else {
                if (iMo1264m == 2) {
                    addReg(abstractC0692f, 1, argType);
                    addLit(abstractC0692f, argType);
                    return;
                }
                return;
            }
        }
        if (iMo1264m == 2) {
            addReg(abstractC0692f, 0, argType);
            addReg(abstractC0692f, 1, argType);
        } else if (iMo1264m == 3) {
            addReg(abstractC0692f, 1, argType);
            addReg(abstractC0692f, 2, argType);
        }
    }

    public ArithNode(ArithOp arithOp, RegisterArg registerArg, InsnArg insnArg) {
        this(arithOp, registerArg, registerArg, insnArg);
        add(AFlag.ARITH_ONEARG);
    }

    public ArithNode(ArithOp arithOp, RegisterArg registerArg, InsnArg insnArg, InsnArg insnArg2) {
        super(InsnType.ARITH, 2);
        this.f4688op = arithOp;
        setResult(registerArg);
        addArg(insnArg);
        addArg(insnArg2);
    }

    public ArithOp getOp() {
        return this.f4688op;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public boolean isSame(InsnNode insnNode) {
        if (this == insnNode) {
            return true;
        }
        if ((insnNode instanceof ArithNode) && super.isSame(insnNode)) {
            return this.f4688op == ((ArithNode) insnNode).f4688op;
        }
        return false;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public String toString() {
        return InsnUtils.formatOffset(this.offset) + ": " + InsnUtils.insnTypeToString(this.insnType) + getResult() + " = " + getArg(0) + " " + this.f4688op.getSymbol() + " " + getArg(1);
    }
}
