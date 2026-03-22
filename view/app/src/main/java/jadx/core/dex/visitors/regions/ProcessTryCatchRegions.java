package jadx.core.dex.visitors.regions;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.IBranchRegion;
import jadx.core.dex.nodes.IContainer;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.regions.AbstractRegion;
import jadx.core.dex.regions.Region;
import jadx.core.dex.regions.TryCatchRegion;
import jadx.core.dex.regions.loops.LoopRegion;
import jadx.core.dex.trycatch.CatchAttr;
import jadx.core.dex.trycatch.ExceptionHandler;
import jadx.core.dex.trycatch.SplitterBlockAttr;
import jadx.core.dex.trycatch.TryCatchBlock;
import jadx.core.utils.BlockUtils;
import jadx.core.utils.ErrorsCounter;
import jadx.core.utils.RegionUtils;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ProcessTryCatchRegions extends AbstractRegionVisitor {
    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkAndWrap(MethodNode methodNode, Map map, IRegion iRegion) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            BlockNode blockNode = (BlockNode) ((Map.Entry) it.next()).getKey();
            if (iRegion.getSubBlocks().contains(blockNode)) {
                if (!wrapBlocks(iRegion, (TryCatchBlock) map.get(blockNode), blockNode)) {
                    ErrorsCounter.methodError(methodNode, "Can't wrap try/catch for " + iRegion);
                }
                map.remove(blockNode);
                return true;
            }
        }
        return false;
    }

    private static boolean isHandlerPath(TryCatchBlock tryCatchBlock, IContainer iContainer) {
        Iterator it = tryCatchBlock.getHandlers().iterator();
        while (it.hasNext()) {
            if (RegionUtils.hasPathThroughBlock(((ExceptionHandler) it.next()).getHandlerBlock(), iContainer)) {
                return true;
            }
        }
        return false;
    }

    public static void process(MethodNode methodNode) {
        if (methodNode.isNoCode() || methodNode.isNoExceptionHandlers()) {
            return;
        }
        final HashMap map = new HashMap(2);
        searchTryCatchDominators(methodNode, map);
        DepthRegionTraversal.traverseIncludingExcHandlers(methodNode, new IRegionIterativeVisitor() { // from class: jadx.core.dex.visitors.regions.ProcessTryCatchRegions.1
            @Override // jadx.core.dex.visitors.regions.IRegionIterativeVisitor
            public final boolean visitRegion(MethodNode methodNode2, IRegion iRegion) {
                return ProcessTryCatchRegions.checkAndWrap(methodNode2, map, iRegion) && !map.isEmpty();
            }
        });
    }

    private static void searchTryCatchDominators(MethodNode methodNode, Map map) {
        BlockNode topBlock;
        HashSet<TryCatchBlock> hashSet = new HashSet();
        Iterator it = methodNode.getBasicBlocks().iterator();
        while (it.hasNext()) {
            CatchAttr catchAttr = (CatchAttr) ((BlockNode) it.next()).get(AType.CATCH_BLOCK);
            if (catchAttr != null) {
                hashSet.add(catchAttr.getTryBlock());
            }
        }
        for (TryCatchBlock tryCatchBlock : hashSet) {
            if (tryCatchBlock.getHandlersCount() != 0) {
                BitSet bitSet = new BitSet(methodNode.getBasicBlocks().size());
                Iterator it2 = tryCatchBlock.getHandlers().iterator();
                while (it2.hasNext()) {
                    SplitterBlockAttr splitterBlockAttr = (SplitterBlockAttr) ((ExceptionHandler) it2.next()).getHandlerBlock().get(AType.SPLITTER_BLOCK);
                    if (splitterBlockAttr != null) {
                        bitSet.set(splitterBlockAttr.getBlock().getId());
                    }
                }
                List listBitSetToBlocks = BlockUtils.bitSetToBlocks(methodNode, bitSet);
                if (listBitSetToBlocks.size() != 1) {
                    topBlock = BlockUtils.getTopBlock(listBitSetToBlocks);
                    if (topBlock == null) {
                        throw new JadxRuntimeException("Exception block dominator not found, method:" + methodNode + ". bs: " + listBitSetToBlocks);
                    }
                } else {
                    topBlock = (BlockNode) listBitSetToBlocks.get(0);
                }
                if (((TryCatchBlock) map.put(topBlock, tryCatchBlock)) != null) {
                    ErrorsCounter.methodError(methodNode, "Failed to process nested try/catch");
                }
            }
        }
    }

    private static boolean wrapBlocks(IRegion iRegion, TryCatchBlock tryCatchBlock, BlockNode blockNode) {
        IRegion body = iRegion;
        while (body != null) {
            if (body instanceof LoopRegion) {
                body = ((LoopRegion) body).getBody();
            } else {
                if (!(body instanceof IBranchRegion)) {
                    Region region = new Region(body);
                    List<IContainer> subBlocks = body.getSubBlocks();
                    for (IContainer iContainer : subBlocks) {
                        if (RegionUtils.hasPathThroughBlock(blockNode, iContainer)) {
                            if (isHandlerPath(tryCatchBlock, iContainer)) {
                                break;
                            }
                            region.getSubBlocks().add(iContainer);
                        }
                    }
                    if (region.getSubBlocks().isEmpty()) {
                        return false;
                    }
                    TryCatchRegion tryCatchRegion = new TryCatchRegion(body, region);
                    region.setParent(tryCatchRegion);
                    tryCatchRegion.setTryCatchBlock(tryCatchBlock.getCatchAttr().getTryBlock());
                    if (!body.replaceSubBlock((IContainer) region.getSubBlocks().get(0), tryCatchRegion)) {
                        return false;
                    }
                    subBlocks.removeAll(region.getSubBlocks());
                    for (IContainer iContainer2 : region.getSubBlocks()) {
                        if (iContainer2 instanceof AbstractRegion) {
                            ((AbstractRegion) iContainer2).setParent(region);
                        }
                    }
                    return true;
                }
                body = body.getParent();
            }
        }
        return false;
    }
}
