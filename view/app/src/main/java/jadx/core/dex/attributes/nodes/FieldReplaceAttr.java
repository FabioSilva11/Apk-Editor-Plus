package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.instructions.args.InsnArg;

/* JADX INFO: loaded from: classes.dex */
public class FieldReplaceAttr implements IAttribute {
    private final Object replaceObj;
    private final ReplaceWith replaceType;

    public enum ReplaceWith {
        CLASS_INSTANCE,
        VAR
    }

    public FieldReplaceAttr(ClassInfo classInfo) {
        this.replaceType = ReplaceWith.CLASS_INSTANCE;
        this.replaceObj = classInfo;
    }

    public FieldReplaceAttr(InsnArg insnArg) {
        this.replaceType = ReplaceWith.VAR;
        this.replaceObj = insnArg;
    }

    public ClassInfo getClsRef() {
        return (ClassInfo) this.replaceObj;
    }

    public ReplaceWith getReplaceType() {
        return this.replaceType;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.FIELD_REPLACE;
    }

    public InsnArg getVarRef() {
        return (InsnArg) this.replaceObj;
    }

    public String toString() {
        return "REPLACE: " + this.replaceType + " " + this.replaceObj;
    }
}
