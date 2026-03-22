package jadx.core.dex.regions.conditions;

import jadx.core.dex.instructions.IfNode;
import jadx.core.dex.instructions.IfOp;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.LiteralArg;

/* JADX INFO: loaded from: classes.dex */
public final class Compare {
    private final IfNode insn;

    public Compare(IfNode ifNode) {
        this.insn = ifNode;
    }

    public final InsnArg getA() {
        return this.insn.getArg(0);
    }

    public final InsnArg getB() {
        return this.insn.getArg(1);
    }

    public final IfNode getInsn() {
        return this.insn;
    }

    public final IfOp getOp() {
        return this.insn.getOp();
    }

    public final Compare invert() {
        this.insn.invertCondition();
        return this;
    }

    public final void normalize() {
        if (getOp() == IfOp.NE && getB().isLiteral() && getB().equals(LiteralArg.FALSE)) {
            this.insn.changeCondition(IfOp.EQ, getA(), LiteralArg.TRUE);
        }
    }

    public final String toString() {
        return getA() + " " + getOp().getSymbol() + " " + getB();
    }
}
