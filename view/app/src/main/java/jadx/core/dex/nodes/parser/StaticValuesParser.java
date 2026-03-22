package jadx.core.dex.nodes.parser;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.C0416o;
import jadx.core.dex.nodes.DexNode;
import jadx.core.dex.nodes.FieldNode;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaticValuesParser extends EncValueParser {
    public StaticValuesParser(DexNode dexNode, C0416o c0416o) {
        super(dexNode, c0416o);
    }

    public int processFields(List list) {
        int iM2232b = C0985a.m2232b(this.f4699in);
        for (int i = 0; i < iM2232b; i++) {
            Object value = parseValue();
            if (i < list.size()) {
                ((FieldNode) list.get(i)).addAttr(FieldInitAttr.constValue(value));
            }
        }
        return iM2232b;
    }
}
