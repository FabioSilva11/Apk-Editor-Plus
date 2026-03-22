package jadx.core.dex.trycatch;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;

/* JADX INFO: loaded from: classes.dex */
public class ExcHandlerAttr implements IAttribute {
    private final ExceptionHandler handler;
    private final TryCatchBlock tryBlock;

    public ExcHandlerAttr(TryCatchBlock tryCatchBlock, ExceptionHandler exceptionHandler) {
        this.tryBlock = tryCatchBlock;
        this.handler = exceptionHandler;
    }

    public ExceptionHandler getHandler() {
        return this.handler;
    }

    public TryCatchBlock getTryBlock() {
        return this.tryBlock;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.EXC_HANDLER;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ExcHandler: ");
        if (this.handler.isFinally()) {
            str = " FINALLY";
        } else {
            str = (this.handler.isCatchAll() ? "all" : this.handler.getCatchType()) + " " + this.handler.getArg();
        }
        return sb.append(str).toString();
    }
}
