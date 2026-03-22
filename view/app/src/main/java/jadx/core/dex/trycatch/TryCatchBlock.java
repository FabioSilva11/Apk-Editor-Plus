package jadx.core.dex.trycatch;

import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.utils.BlockUtils;
import jadx.core.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TryCatchBlock {
    private final List handlers = new LinkedList();
    private final List insns = new ArrayList();
    private final CatchAttr attr = new CatchAttr(this);

    private void removeWholeBlock(MethodNode methodNode) {
        Iterator it = this.handlers.iterator();
        while (it.hasNext()) {
            unbindHandler((ExceptionHandler) it.next());
            it.remove();
        }
        Iterator it2 = this.insns.iterator();
        while (it2.hasNext()) {
            ((InsnNode) it2.next()).removeAttr(this.attr);
        }
        this.insns.clear();
        if (methodNode.getBasicBlocks() != null) {
            Iterator it3 = methodNode.getBasicBlocks().iterator();
            while (it3.hasNext()) {
                ((BlockNode) it3.next()).removeAttr(this.attr);
            }
        }
    }

    private void unbindHandler(ExceptionHandler exceptionHandler) {
        for (BlockNode blockNode : exceptionHandler.getBlocks()) {
            BlockUtils.skipPredSyntheticPaths(blockNode);
            blockNode.add(AFlag.SKIP);
            ExcHandlerAttr excHandlerAttr = (ExcHandlerAttr) blockNode.get(AType.EXC_HANDLER);
            if (excHandlerAttr != null && excHandlerAttr.getHandler().equals(exceptionHandler)) {
                blockNode.remove(AType.EXC_HANDLER);
            }
            SplitterBlockAttr splitterBlockAttr = (SplitterBlockAttr) exceptionHandler.getHandlerBlock().get(AType.SPLITTER_BLOCK);
            if (splitterBlockAttr != null) {
                splitterBlockAttr.getBlock().remove(AType.SPLITTER_BLOCK);
            }
        }
    }

    public ExceptionHandler addHandler(MethodNode methodNode, int i, ClassInfo classInfo) {
        ExceptionHandler exceptionHandlerAddExceptionHandler = methodNode.addExceptionHandler(new ExceptionHandler(i, classInfo));
        this.handlers.add(exceptionHandlerAddExceptionHandler);
        exceptionHandlerAddExceptionHandler.setTryBlock(this);
        return exceptionHandlerAddExceptionHandler;
    }

    public void addInsn(InsnNode insnNode) {
        this.insns.add(insnNode);
        insnNode.addAttr(this.attr);
    }

    public boolean containsAllHandlers(TryCatchBlock tryCatchBlock) {
        return this.handlers.containsAll(tryCatchBlock.handlers);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.handlers.equals(((TryCatchBlock) obj).handlers);
    }

    public CatchAttr getCatchAttr() {
        return this.attr;
    }

    public Iterable getHandlers() {
        return this.handlers;
    }

    public int getHandlersCount() {
        return this.handlers.size();
    }

    public Iterable getInsns() {
        return this.insns;
    }

    public int hashCode() {
        return this.handlers.hashCode();
    }

    public boolean merge(MethodNode methodNode, TryCatchBlock tryCatchBlock) {
        if (tryCatchBlock == this) {
            return false;
        }
        Iterator it = tryCatchBlock.getInsns().iterator();
        while (it.hasNext()) {
            addInsn((InsnNode) it.next());
        }
        this.handlers.addAll(tryCatchBlock.handlers);
        Iterator it2 = this.handlers.iterator();
        while (it2.hasNext()) {
            ((ExceptionHandler) it2.next()).setTryBlock(this);
        }
        tryCatchBlock.handlers.clear();
        tryCatchBlock.removeWholeBlock(methodNode);
        return true;
    }

    public void removeBlock(MethodNode methodNode, BlockNode blockNode) {
        for (InsnNode insnNode : blockNode.getInstructions()) {
            this.insns.remove(insnNode);
            insnNode.remove(AType.CATCH_BLOCK);
        }
        if (this.insns.isEmpty()) {
            removeWholeBlock(methodNode);
        }
    }

    public void removeHandler(MethodNode methodNode, ExceptionHandler exceptionHandler) {
        Iterator it = this.handlers.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ExceptionHandler exceptionHandler2 = (ExceptionHandler) it.next();
            if (exceptionHandler2 == exceptionHandler) {
                unbindHandler(exceptionHandler2);
                it.remove();
                break;
            }
        }
        if (this.handlers.isEmpty()) {
            removeWholeBlock(methodNode);
        }
    }

    public void removeInsn(MethodNode methodNode, InsnNode insnNode) {
        this.insns.remove(insnNode);
        insnNode.remove(AType.CATCH_BLOCK);
        if (this.insns.isEmpty()) {
            removeWholeBlock(methodNode);
        }
    }

    public String toString() {
        return "Catch:{ " + Utils.listToString(this.handlers) + " }";
    }
}
