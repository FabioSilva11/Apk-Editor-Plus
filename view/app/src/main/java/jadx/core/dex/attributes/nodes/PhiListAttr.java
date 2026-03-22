package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.dex.instructions.PhiInsn;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PhiListAttr implements IAttribute {
    private final List list = new LinkedList();

    public List getList() {
        return this.list;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.PHI_LIST;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PHI: ");
        Iterator it = this.list.iterator();
        while (it.hasNext()) {
            sb.append('r').append(((PhiInsn) it.next()).getResult().getRegNum()).append(" ");
        }
        return sb.toString();
    }
}
