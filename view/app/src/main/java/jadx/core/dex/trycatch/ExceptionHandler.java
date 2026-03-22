package jadx.core.dex.trycatch;

import jadx.core.Consts;
import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.IContainer;
import jadx.core.utils.InsnUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ExceptionHandler {
    private InsnArg arg;
    private final List blocks = new ArrayList();
    private final ClassInfo catchType;
    private final int handleOffset;
    private BlockNode handlerBlock;
    private IContainer handlerRegion;
    private boolean isFinally;
    private TryCatchBlock tryBlock;

    public ExceptionHandler(int i, ClassInfo classInfo) {
        this.handleOffset = i;
        this.catchType = classInfo;
    }

    public void addBlock(BlockNode blockNode) {
        this.blocks.add(blockNode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ExceptionHandler exceptionHandler = (ExceptionHandler) obj;
            if (this.catchType == null) {
                if (exceptionHandler.catchType != null) {
                    return false;
                }
            } else if (!this.catchType.equals(exceptionHandler.catchType)) {
                return false;
            }
            return this.handleOffset == exceptionHandler.handleOffset;
        }
        return false;
    }

    public InsnArg getArg() {
        return this.arg;
    }

    public List getBlocks() {
        return this.blocks;
    }

    public ClassInfo getCatchType() {
        return this.catchType;
    }

    public int getHandleOffset() {
        return this.handleOffset;
    }

    public BlockNode getHandlerBlock() {
        return this.handlerBlock;
    }

    public IContainer getHandlerRegion() {
        return this.handlerRegion;
    }

    public TryCatchBlock getTryBlock() {
        return this.tryBlock;
    }

    public int hashCode() {
        return (this.catchType == null ? 0 : this.catchType.hashCode() * 31) + this.handleOffset;
    }

    public boolean isCatchAll() {
        return this.catchType == null || this.catchType.getFullName().equals(Consts.CLASS_THROWABLE);
    }

    public boolean isFinally() {
        return this.isFinally;
    }

    public void setArg(InsnArg insnArg) {
        this.arg = insnArg;
    }

    public void setFinally(boolean z) {
        this.isFinally = z;
    }

    public void setHandlerBlock(BlockNode blockNode) {
        this.handlerBlock = blockNode;
    }

    public void setHandlerRegion(IContainer iContainer) {
        this.handlerRegion = iContainer;
    }

    public void setTryBlock(TryCatchBlock tryCatchBlock) {
        this.tryBlock = tryCatchBlock;
    }

    public String toString() {
        return (this.catchType == null ? "all" : this.catchType.getShortName()) + " -> " + InsnUtils.formatOffset(this.handleOffset);
    }
}
