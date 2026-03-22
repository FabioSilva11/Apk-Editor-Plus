package jadx.core.dex.instructions;

import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.utils.InsnUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class SwitchNode extends InsnNode {
    private final int def;
    private final Object[] keys;
    private final int[] targets;

    public SwitchNode(InsnArg insnArg, Object[] objArr, int[] iArr, int i) {
        super(InsnType.SWITCH, 1);
        this.keys = objArr;
        this.targets = iArr;
        this.def = i;
        addArg(insnArg);
    }

    public int getCasesCount() {
        return this.keys.length;
    }

    public int getDefaultCaseOffset() {
        return this.def;
    }

    public Object[] getKeys() {
        return this.keys;
    }

    public int[] getTargets() {
        return this.targets;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public boolean isSame(InsnNode insnNode) {
        if (this == insnNode) {
            return true;
        }
        if (!(insnNode instanceof SwitchNode) || !super.isSame(insnNode)) {
            return false;
        }
        SwitchNode switchNode = (SwitchNode) insnNode;
        return this.def == switchNode.def && Arrays.equals(this.keys, switchNode.keys) && Arrays.equals(this.targets, switchNode.targets);
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < this.targets.length; i++) {
            sb.append(InsnUtils.formatOffset(this.targets[i]));
            if (i < this.targets.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return super.toString() + " k:" + Arrays.toString(this.keys) + " t:" + ((Object) sb);
    }
}
