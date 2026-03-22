package jadx.core.dex.regions.loops;

import jadx.core.dex.attributes.nodes.LoopInfo;
import jadx.core.dex.instructions.IfNode;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.IContainer;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.regions.AbstractRegion;
import jadx.core.dex.regions.conditions.IfCondition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LoopRegion extends AbstractRegion {
    private IRegion body;
    private IfCondition condition;
    private final boolean conditionAtEnd;
    private final BlockNode conditionBlock;
    private final LoopInfo info;
    private BlockNode preCondition;
    private LoopType type;

    public LoopRegion(IRegion iRegion, LoopInfo loopInfo, BlockNode blockNode, boolean z) {
        super(iRegion);
        this.info = loopInfo;
        this.conditionBlock = blockNode;
        this.condition = IfCondition.fromIfBlock(blockNode);
        this.conditionAtEnd = z;
    }

    private IfNode getIfInsn() {
        return (IfNode) this.conditionBlock.getInstructions().get(0);
    }

    @Override // jadx.core.dex.nodes.IContainer
    public final String baseString() {
        return this.body == null ? "-" : this.body.baseString();
    }

    public final boolean checkPreCondition() {
        List instructions = this.preCondition.getInstructions();
        if (instructions.isEmpty()) {
            return true;
        }
        IfNode ifInsn = getIfInsn();
        int size = instructions.size();
        for (int i = 0; i < size; i++) {
            InsnNode insnNode = (InsnNode) instructions.get(i);
            if (insnNode.getResult() == null) {
                return false;
            }
            RegisterArg result = insnNode.getResult();
            if (result.getSVar().getUseCount() > 1) {
                return false;
            }
            int i2 = i + 1;
            boolean z = false;
            while (i2 < size) {
                i2++;
                z = ((InsnNode) instructions.get(i)).containsArg(result) ? true : z;
            }
            if (!z && ifInsn.containsArg(result)) {
                z = true;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final IRegion getBody() {
        return this.body;
    }

    public final IfCondition getCondition() {
        return this.condition;
    }

    public final BlockNode getHeader() {
        return this.conditionBlock;
    }

    public final LoopInfo getInfo() {
        return this.info;
    }

    @Override // jadx.core.dex.nodes.IRegion
    public final List getSubBlocks() {
        ArrayList arrayList = new ArrayList(3);
        if (this.preCondition != null) {
            arrayList.add(this.preCondition);
        }
        if (this.conditionBlock != null) {
            arrayList.add(this.conditionBlock);
        }
        if (this.body != null) {
            arrayList.add(this.body);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final LoopType getType() {
        return this.type;
    }

    public final boolean isConditionAtEnd() {
        return this.conditionAtEnd;
    }

    public final void mergePreCondition() {
        if (this.preCondition == null || this.conditionBlock == null) {
            return;
        }
        List instructions = this.conditionBlock.getInstructions();
        List instructions2 = this.preCondition.getInstructions();
        instructions2.addAll(instructions);
        instructions.clear();
        instructions.addAll(instructions2);
        instructions2.clear();
        this.preCondition = null;
    }

    @Override // jadx.core.dex.regions.AbstractRegion, jadx.core.dex.nodes.IRegion
    public final boolean replaceSubBlock(IContainer iContainer, IContainer iContainer2) {
        return false;
    }

    public final void setBody(IRegion iRegion) {
        this.body = iRegion;
    }

    public final void setCondition(IfCondition ifCondition) {
        this.condition = ifCondition;
    }

    public final void setPreCondition(BlockNode blockNode) {
        this.preCondition = blockNode;
    }

    public final void setType(LoopType loopType) {
        this.type = loopType;
    }

    public final String toString() {
        return "LOOP:" + this.info.getId() + ": " + baseString();
    }
}
