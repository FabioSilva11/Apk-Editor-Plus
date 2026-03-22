package jadx.core.deobf;

import jadx.core.dex.info.MethodInfo;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class OverridedMethodsNode {
    private Set methods;

    public OverridedMethodsNode(Set set) {
        this.methods = set;
    }

    public void add(MethodInfo methodInfo) {
        this.methods.add(methodInfo);
    }

    public boolean contains(MethodInfo methodInfo) {
        return this.methods.contains(methodInfo);
    }

    public Set getMethods() {
        return this.methods;
    }
}
