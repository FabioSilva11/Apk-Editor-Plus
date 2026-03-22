package jadx.api;

import jadx.core.dex.info.AccessInfo;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.nodes.MethodNode;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class JavaMethod implements JavaNode {
    private final MethodNode mth;
    private final JavaClass parent;

    JavaMethod(JavaClass javaClass, MethodNode methodNode) {
        this.parent = javaClass;
        this.mth = methodNode;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof JavaMethod) && this.mth.equals(((JavaMethod) obj).mth));
    }

    public final AccessInfo getAccessFlags() {
        return this.mth.getAccessFlags();
    }

    public final List getArguments() {
        return this.mth.getMethodInfo().getArgumentsTypes();
    }

    @Override // jadx.api.JavaNode
    public final JavaClass getDeclaringClass() {
        return this.parent;
    }

    @Override // jadx.api.JavaNode
    public final int getDecompiledLine() {
        return this.mth.getDecompiledLine();
    }

    @Override // jadx.api.JavaNode
    public final String getFullName() {
        return this.mth.getMethodInfo().getFullName();
    }

    @Override // jadx.api.JavaNode
    public final String getName() {
        return this.mth.getAlias();
    }

    public final ArgType getReturnType() {
        return this.mth.getReturnType();
    }

    @Override // jadx.api.JavaNode
    public final JavaClass getTopParentClass() {
        return this.parent.getTopParentClass();
    }

    public final int hashCode() {
        return this.mth.hashCode();
    }

    public final boolean isClassInit() {
        return this.mth.getMethodInfo().isClassInit();
    }

    public final boolean isConstructor() {
        return this.mth.getMethodInfo().isConstructor();
    }

    public final String toString() {
        return this.mth.toString();
    }
}
