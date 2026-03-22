package jadx.core.dex.regions;

import jadx.core.dex.nodes.IContainer;
import jadx.core.dex.nodes.IRegion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Region extends AbstractRegion {
    private final List blocks;

    public Region(IRegion iRegion) {
        super(iRegion);
        this.blocks = new ArrayList(1);
    }

    public final void add(IContainer iContainer) {
        if (iContainer instanceof AbstractRegion) {
            ((AbstractRegion) iContainer).setParent(this);
        }
        this.blocks.add(iContainer);
    }

    @Override // jadx.core.dex.nodes.IContainer
    public final String baseString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.blocks.size());
        Iterator it = this.blocks.iterator();
        while (it.hasNext()) {
            sb.append(((IContainer) it.next()).baseString());
        }
        return sb.toString();
    }

    @Override // jadx.core.dex.nodes.IRegion
    public final List getSubBlocks() {
        return this.blocks;
    }

    @Override // jadx.core.dex.regions.AbstractRegion, jadx.core.dex.nodes.IRegion
    public final boolean replaceSubBlock(IContainer iContainer, IContainer iContainer2) {
        int iIndexOf = this.blocks.indexOf(iContainer);
        if (iIndexOf == -1) {
            return false;
        }
        this.blocks.set(iIndexOf, iContainer2);
        return true;
    }

    public final String toString() {
        return "R:" + baseString();
    }
}
