package jadx.core.dex.visitors.regions;

import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.MethodNode;

/* JADX INFO: loaded from: classes.dex */
public interface IRegionIterativeVisitor {
    boolean visitRegion(MethodNode methodNode, IRegion iRegion);
}
