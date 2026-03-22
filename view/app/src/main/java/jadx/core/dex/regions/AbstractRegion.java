package jadx.core.dex.regions;

import jadx.core.dex.attributes.AttrNode;
import jadx.core.dex.nodes.IContainer;
import jadx.core.dex.nodes.IRegion;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractRegion extends AttrNode implements IRegion {
    private static final InterfaceC1668b LOG = C1677c.m3845a(AbstractRegion.class);
    private IRegion parent;

    public AbstractRegion(IRegion iRegion) {
        this.parent = iRegion;
    }

    @Override // jadx.core.dex.nodes.IRegion
    public IRegion getParent() {
        return this.parent;
    }

    @Override // jadx.core.dex.nodes.IRegion
    public boolean replaceSubBlock(IContainer iContainer, IContainer iContainer2) {
        LOG.mo3825c("Replace sub block not supported for class \"{}\"", getClass());
        return false;
    }

    public void setParent(IRegion iRegion) {
        this.parent = iRegion;
    }
}
