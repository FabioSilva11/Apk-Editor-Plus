package jadx.core.dex.visitors;

import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.nodes.RootNode;

/* JADX INFO: loaded from: classes.dex */
public interface IDexTreeVisitor {
    void init(RootNode rootNode);

    void visit(MethodNode methodNode);

    boolean visit(ClassNode classNode);
}
