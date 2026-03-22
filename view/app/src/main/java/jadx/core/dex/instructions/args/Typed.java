package jadx.core.dex.instructions.args;

import jadx.core.dex.attributes.AttrNode;
import jadx.core.dex.nodes.DexNode;

/* JADX INFO: loaded from: classes.dex */
public abstract class Typed extends AttrNode {
    protected ArgType type;

    public ArgType getType() {
        return this.type;
    }

    public boolean isTypeImmutable() {
        return false;
    }

    public boolean merge(DexNode dexNode, ArgType argType) {
        ArgType argTypeMerge = ArgType.merge(dexNode, this.type, argType);
        if (argTypeMerge == null || argTypeMerge.equals(this.type)) {
            return false;
        }
        setType(argTypeMerge);
        return true;
    }

    public boolean merge(DexNode dexNode, InsnArg insnArg) {
        return merge(dexNode, insnArg.getType());
    }

    public void setType(ArgType argType) {
        this.type = argType;
    }
}
