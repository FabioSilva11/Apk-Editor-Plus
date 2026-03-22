package jadx.core.dex.visitors.regions;

import jadx.core.dex.nodes.IBlock;
import jadx.core.dex.nodes.IContainer;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.trycatch.ExceptionHandler;
import jadx.core.utils.exceptions.JadxOverflowException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DepthRegionTraversal {
    private static final int ITERATIVE_LIMIT = 500;

    private DepthRegionTraversal() {
    }

    public static void traverse(MethodNode methodNode, IRegionVisitor iRegionVisitor) {
        traverseInternal(methodNode, iRegionVisitor, methodNode.getRegion());
    }

    public static void traverseIncludingExcHandlers(MethodNode methodNode, IRegionIterativeVisitor iRegionIterativeVisitor) {
        boolean z;
        int i = 0;
        do {
            int i2 = i;
            boolean zTraverseIterativeStepInternal = traverseIterativeStepInternal(methodNode, iRegionIterativeVisitor, methodNode.getRegion());
            if (!zTraverseIterativeStepInternal) {
                Iterator it = methodNode.getExceptionHandlers().iterator();
                while (it.hasNext() && !(zTraverseIterativeStepInternal = traverseIterativeStepInternal(methodNode, iRegionIterativeVisitor, ((ExceptionHandler) it.next()).getHandlerRegion()))) {
                }
            }
            z = zTraverseIterativeStepInternal;
            i = i2 + 1;
            if (i2 > ITERATIVE_LIMIT) {
                throw new JadxOverflowException("Iterative traversal limit reached, method: " + methodNode);
            }
        } while (z);
    }

    private static void traverseInternal(MethodNode methodNode, IRegionVisitor iRegionVisitor, IContainer iContainer) {
        if (iContainer instanceof IBlock) {
            iRegionVisitor.processBlock(methodNode, (IBlock) iContainer);
            return;
        }
        if (iContainer instanceof IRegion) {
            IRegion iRegion = (IRegion) iContainer;
            if (iRegionVisitor.enterRegion(methodNode, iRegion)) {
                Iterator it = iRegion.getSubBlocks().iterator();
                while (it.hasNext()) {
                    traverseInternal(methodNode, iRegionVisitor, (IContainer) it.next());
                }
            }
            iRegionVisitor.leaveRegion(methodNode, iRegion);
        }
    }

    public static void traverseIterative(MethodNode methodNode, IRegionIterativeVisitor iRegionIterativeVisitor) {
        int i = 0;
        while (true) {
            boolean zTraverseIterativeStepInternal = traverseIterativeStepInternal(methodNode, iRegionIterativeVisitor, methodNode.getRegion());
            int i2 = i + 1;
            if (i > ITERATIVE_LIMIT) {
                throw new JadxOverflowException("Iterative traversal limit reached, method: " + methodNode);
            }
            if (!zTraverseIterativeStepInternal) {
                return;
            } else {
                i = i2;
            }
        }
    }

    private static boolean traverseIterativeStepInternal(MethodNode methodNode, IRegionIterativeVisitor iRegionIterativeVisitor, IContainer iContainer) {
        if (iContainer instanceof IRegion) {
            IRegion iRegion = (IRegion) iContainer;
            if (iRegionIterativeVisitor.visitRegion(methodNode, iRegion)) {
                return true;
            }
            Iterator it = iRegion.getSubBlocks().iterator();
            while (it.hasNext()) {
                if (traverseIterativeStepInternal(methodNode, iRegionIterativeVisitor, (IContainer) it.next())) {
                    return true;
                }
            }
        }
        return false;
    }
}
