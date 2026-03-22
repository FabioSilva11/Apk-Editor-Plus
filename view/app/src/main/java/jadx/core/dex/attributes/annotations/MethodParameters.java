package jadx.core.dex.attributes.annotations;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MethodParameters implements IAttribute {
    private final List paramList;

    public MethodParameters(int i) {
        this.paramList = new ArrayList(i);
    }

    public List getParamList() {
        return this.paramList;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.ANNOTATION_MTH_PARAMETERS;
    }

    public String toString() {
        return Utils.listToString(this.paramList);
    }
}
