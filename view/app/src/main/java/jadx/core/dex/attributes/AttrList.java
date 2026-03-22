package jadx.core.dex.attributes;

import jadx.core.utils.Utils;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AttrList implements IAttribute {
    private final List list = new LinkedList();
    private final AType type;

    public AttrList(AType aType) {
        this.type = aType;
    }

    public List getList() {
        return this.list;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return this.type;
    }

    public String toString() {
        return Utils.listToString(this.list);
    }
}
