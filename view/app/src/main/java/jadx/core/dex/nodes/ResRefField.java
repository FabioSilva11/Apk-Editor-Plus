package jadx.core.dex.nodes;

import jadx.core.dex.info.FieldInfo;
import jadx.core.dex.instructions.args.ArgType;

/* JADX INFO: loaded from: classes.dex */
public class ResRefField extends FieldNode {
    public ResRefField(DexNode dexNode, String str) {
        super(dexNode.root().getAppResClass(), FieldInfo.from(dexNode, dexNode.root().getAppResClass().getClassInfo(), str, ArgType.INT), 1);
    }
}
