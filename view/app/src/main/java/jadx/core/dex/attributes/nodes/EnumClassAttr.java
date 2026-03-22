package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.dex.info.FieldInfo;
import jadx.core.dex.instructions.mods.ConstructorInsn;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.MethodNode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EnumClassAttr implements IAttribute {
    private final List fields;
    private MethodNode staticMethod;

    public class EnumField {
        private ClassNode cls;
        private final ConstructorInsn constrInsn;
        private final FieldInfo field;
        private final int startArg;

        public EnumField(FieldInfo fieldInfo, ConstructorInsn constructorInsn, int i) {
            this.field = fieldInfo;
            this.constrInsn = constructorInsn;
            this.startArg = i;
        }

        public ClassNode getCls() {
            return this.cls;
        }

        public ConstructorInsn getConstrInsn() {
            return this.constrInsn;
        }

        public FieldInfo getField() {
            return this.field;
        }

        public int getStartArg() {
            return this.startArg;
        }

        public void setCls(ClassNode classNode) {
            this.cls = classNode;
        }

        public String toString() {
            return this.field + "(" + this.constrInsn + ") " + this.cls;
        }
    }

    public EnumClassAttr(int i) {
        this.fields = new ArrayList(i);
    }

    public List getFields() {
        return this.fields;
    }

    public MethodNode getStaticMethod() {
        return this.staticMethod;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.ENUM_CLASS;
    }

    public void setStaticMethod(MethodNode methodNode) {
        this.staticMethod = methodNode;
    }

    public String toString() {
        return "Enum fields: " + this.fields;
    }
}
