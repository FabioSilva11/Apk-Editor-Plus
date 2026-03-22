package jadx.core.dex.nodes;

import com.p016a.p017a.C0404c;
import jadx.core.deobf.Deobfuscator;
import jadx.core.dex.attributes.nodes.LineAttrNode;
import jadx.core.dex.info.AccessInfo;
import jadx.core.dex.info.FieldInfo;
import jadx.core.dex.instructions.args.ArgType;

/* JADX INFO: loaded from: classes.dex */
public class FieldNode extends LineAttrNode {
    private final AccessInfo accFlags;
    private final FieldInfo fieldInfo;
    private final ClassNode parent;
    private ArgType type;

    public FieldNode(ClassNode classNode, C0404c c0404c) {
        this.parent = classNode;
        this.fieldInfo = FieldInfo.fromDex(classNode.dex(), c0404c.m318a());
        this.type = this.fieldInfo.getType();
        this.accFlags = new AccessInfo(c0404c.m319b(), AccessInfo.AFType.FIELD);
    }

    public FieldNode(ClassNode classNode, FieldInfo fieldInfo, int i) {
        this.parent = classNode;
        this.fieldInfo = fieldInfo;
        this.type = fieldInfo.getType();
        this.accFlags = new AccessInfo(i, AccessInfo.AFType.FIELD);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.fieldInfo.equals(((FieldNode) obj).fieldInfo);
    }

    public AccessInfo getAccessFlags() {
        return this.accFlags;
    }

    public String getAlias() {
        return this.fieldInfo.getAlias();
    }

    public FieldInfo getFieldInfo() {
        return this.fieldInfo;
    }

    public String getName() {
        return this.fieldInfo.getName();
    }

    public ClassNode getParentClass() {
        return this.parent;
    }

    public ArgType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.fieldInfo.hashCode();
    }

    public void setType(ArgType argType) {
        this.type = argType;
    }

    public String toString() {
        return this.fieldInfo.getDeclClass() + Deobfuscator.CLASS_NAME_SEPARATOR + this.fieldInfo.getName() + " :" + this.type;
    }
}
