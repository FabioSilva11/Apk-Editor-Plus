package jadx.core.dex.instructions;

import com.p016a.p019b.p033d.p034a.AbstractC0692f;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.PrimitiveType;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.utils.BlockUtils;
import jadx.core.utils.InsnUtils;

/* JADX INFO: loaded from: classes.dex */
public class IfNode extends GotoNode {
    private static final ArgType ARG_TYPE = ArgType.unknown(PrimitiveType.INT, PrimitiveType.OBJECT, PrimitiveType.ARRAY, PrimitiveType.BOOLEAN, PrimitiveType.BYTE, PrimitiveType.SHORT, PrimitiveType.CHAR);
    private BlockNode elseBlock;

    /* JADX INFO: renamed from: op */
    protected IfOp f4690op;
    private BlockNode thenBlock;

    public IfNode(AbstractC0692f abstractC0692f, IfOp ifOp) {
        this(ifOp, abstractC0692f.m1302g(), InsnArg.reg(abstractC0692f, 0, ARG_TYPE), abstractC0692f.mo1264m() == 1 ? InsnArg.lit(0L, ARG_TYPE) : InsnArg.reg(abstractC0692f, 1, ARG_TYPE));
    }

    public IfNode(IfOp ifOp, int i, InsnArg insnArg, InsnArg insnArg2) {
        super(InsnType.IF, i, 2);
        this.f4690op = ifOp;
        addArg(insnArg);
        addArg(insnArg2);
    }

    public void changeCondition(IfOp ifOp, InsnArg insnArg, InsnArg insnArg2) {
        this.f4690op = ifOp;
        setArg(0, insnArg);
        setArg(1, insnArg2);
    }

    public BlockNode getElseBlock() {
        return this.elseBlock;
    }

    public IfOp getOp() {
        return this.f4690op;
    }

    public BlockNode getThenBlock() {
        return this.thenBlock;
    }

    public void initBlocks(BlockNode blockNode) {
        this.thenBlock = BlockUtils.getBlockByOffset(this.target, blockNode.getSuccessors());
        if (blockNode.getSuccessors().size() == 1) {
            this.elseBlock = this.thenBlock;
        } else {
            this.elseBlock = BlockUtils.selectOther(this.thenBlock, blockNode.getSuccessors());
        }
    }

    public void invertCondition() {
        this.f4690op = this.f4690op.invert();
        BlockNode blockNode = this.thenBlock;
        this.thenBlock = this.elseBlock;
        this.elseBlock = blockNode;
        this.target = this.thenBlock.getStartOffset();
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public boolean isSame(InsnNode insnNode) {
        if (this == insnNode) {
            return true;
        }
        if ((insnNode instanceof IfNode) && super.isSame(insnNode)) {
            return this.f4690op == ((IfNode) insnNode).f4690op;
        }
        return false;
    }

    @Override // jadx.core.dex.instructions.GotoNode, jadx.core.dex.nodes.InsnNode
    public String toString() {
        return InsnUtils.formatOffset(this.offset) + ": " + InsnUtils.insnTypeToString(this.insnType) + getArg(0) + " " + this.f4690op.getSymbol() + " " + getArg(1) + "  -> " + (this.thenBlock != null ? this.thenBlock : InsnUtils.formatOffset(this.target));
    }
}
