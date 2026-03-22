package jadx.core.dex.nodes;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IRegion extends IContainer {
    IRegion getParent();

    List getSubBlocks();

    boolean replaceSubBlock(IContainer iContainer, IContainer iContainer2);
}
