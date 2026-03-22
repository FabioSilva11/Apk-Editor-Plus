package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;

/* JADX INFO: loaded from: classes.dex */
public class LoopLabelAttr implements IAttribute {
    private final LoopInfo loop;

    public LoopLabelAttr(LoopInfo loopInfo) {
        this.loop = loopInfo;
    }

    public LoopInfo getLoop() {
        return this.loop;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.LOOP_LABEL;
    }

    public String toString() {
        return "LOOP_LABEL: " + this.loop;
    }
}
