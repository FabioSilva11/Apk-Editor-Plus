package jadx.core.dex.instructions;

import jadx.core.dex.nodes.InsnNode;
import jadx.core.utils.InsnUtils;

/* JADX INFO: loaded from: classes.dex */
public class GotoNode extends InsnNode {
    protected int target;

    public GotoNode(int i) {
        this(InsnType.GOTO, i, 0);
    }

    protected GotoNode(InsnType insnType, int i, int i2) {
        super(insnType, i2);
        this.target = i;
    }

    public int getTarget() {
        return this.target;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public String toString() {
        return super.toString() + "-> " + InsnUtils.formatOffset(this.target);
    }
}
