package jadx.core.dex.trycatch;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;

/* JADX INFO: loaded from: classes.dex */
public class CatchAttr implements IAttribute {
    private final TryCatchBlock tryBlock;

    public CatchAttr(TryCatchBlock tryCatchBlock) {
        this.tryBlock = tryCatchBlock;
    }

    public TryCatchBlock getTryBlock() {
        return this.tryBlock;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.CATCH_BLOCK;
    }

    public String toString() {
        return this.tryBlock.toString();
    }
}
