package jadx.core.dex.info;

import com.p016a.p017a.C0425x;
import com.p016a.p017a.C0426y;
import jadx.core.codegen.TypeGen;
import jadx.core.deobf.Deobfuscator;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.nodes.DexNode;
import jadx.core.utils.Utils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MethodInfo {
    private String alias;
    private boolean aliasFromPreset;
    private final List args;
    private final ClassInfo declClass;
    private final String name;
    private final ArgType retType;
    private final String shortId;

    private MethodInfo(DexNode dexNode, int i) {
        C0425x methodId = dexNode.getMethodId(i);
        this.name = dexNode.getString(methodId.m435c());
        this.alias = this.name;
        this.aliasFromPreset = false;
        this.declClass = ClassInfo.fromDex(dexNode, methodId.m432a());
        C0426y protoId = dexNode.getProtoId(methodId.m434b());
        this.retType = dexNode.getType(protoId.m438b());
        this.args = dexNode.readParamList(protoId.m439c());
        this.shortId = makeSignature(true);
    }

    public static MethodInfo fromDex(DexNode dexNode, int i) {
        MethodInfo method = dexNode.getInfoStorage().getMethod(i);
        if (method != null) {
            return method;
        }
        return dexNode.getInfoStorage().putMethod(i, new MethodInfo(dexNode, i));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MethodInfo)) {
            return false;
        }
        MethodInfo methodInfo = (MethodInfo) obj;
        return this.shortId.equals(methodInfo.shortId) && this.retType.equals(methodInfo.retType) && this.declClass.equals(methodInfo.declClass);
    }

    public final String getAlias() {
        return this.alias;
    }

    public final int getArgsCount() {
        return this.args.size();
    }

    public final List getArgumentsTypes() {
        return this.args;
    }

    public final ClassInfo getDeclClass() {
        return this.declClass;
    }

    public final String getFullId() {
        return this.declClass.getFullName() + Deobfuscator.CLASS_NAME_SEPARATOR + this.shortId;
    }

    public final String getFullName() {
        return this.declClass.getFullName() + Deobfuscator.CLASS_NAME_SEPARATOR + this.name;
    }

    public final String getName() {
        return this.name;
    }

    public final ArgType getReturnType() {
        return this.retType;
    }

    public final String getShortId() {
        return this.shortId;
    }

    public final int hashCode() {
        return (((this.declClass.hashCode() * 31) + this.retType.hashCode()) * 31) + this.shortId.hashCode();
    }

    public final boolean isAliasFromPreset() {
        return this.aliasFromPreset;
    }

    public final boolean isClassInit() {
        return this.name.equals("<clinit>");
    }

    public final boolean isConstructor() {
        return this.name.equals("<init>");
    }

    public final boolean isRenamed() {
        return !this.name.equals(this.alias);
    }

    public final String makeSignature(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('(');
        Iterator it = this.args.iterator();
        while (it.hasNext()) {
            sb.append(TypeGen.signature((ArgType) it.next()));
        }
        sb.append(')');
        if (z) {
            sb.append(TypeGen.signature(this.retType));
        }
        return sb.toString();
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setAliasFromPreset(boolean z) {
        this.aliasFromPreset = z;
    }

    public final String toString() {
        return this.declClass.getFullName() + Deobfuscator.CLASS_NAME_SEPARATOR + this.name + "(" + Utils.listToString(this.args) + "):" + this.retType;
    }
}
