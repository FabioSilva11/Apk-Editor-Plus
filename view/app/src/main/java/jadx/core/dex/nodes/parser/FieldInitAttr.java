package jadx.core.dex.nodes.parser;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;

/* JADX INFO: loaded from: classes.dex */
public class FieldInitAttr implements IAttribute {
    public static final FieldInitAttr NULL_VALUE = constValue(null);
    private final MethodNode insnMth;
    private final Object value;
    private final InitType valueType;

    public enum InitType {
        CONST,
        INSN
    }

    private FieldInitAttr(InitType initType, Object obj, MethodNode methodNode) {
        this.value = obj;
        this.valueType = initType;
        this.insnMth = methodNode;
    }

    public static FieldInitAttr constValue(Object obj) {
        return new FieldInitAttr(InitType.CONST, obj, null);
    }

    public static FieldInitAttr insnValue(MethodNode methodNode, InsnNode insnNode) {
        return new FieldInitAttr(InitType.INSN, insnNode, methodNode);
    }

    public InsnNode getInsn() {
        return (InsnNode) this.value;
    }

    public MethodNode getInsnMth() {
        return this.insnMth;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.FIELD_INIT;
    }

    public Object getValue() {
        return this.value;
    }

    public InitType getValueType() {
        return this.valueType;
    }

    public String toString() {
        return "V=" + this.value;
    }
}
