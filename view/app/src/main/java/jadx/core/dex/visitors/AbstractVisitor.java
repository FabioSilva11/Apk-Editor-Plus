package jadx.core.dex.visitors;

import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.nodes.RootNode;

/* JADX INFO: loaded from: classes.dex */
public class AbstractVisitor implements IDexTreeVisitor {
    @Override // jadx.core.dex.visitors.IDexTreeVisitor
    public void init(RootNode rootNode) {
    }

    @Override // jadx.core.dex.visitors.IDexTreeVisitor
    public void visit(MethodNode methodNode) {
    }

    @Override // jadx.core.dex.visitors.IDexTreeVisitor
    public boolean visit(ClassNode classNode) {
        return true;
    }
}
