package jadx.core.codegen;

import jadx.api.IJadxArgs;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.visitors.AbstractVisitor;

/* JADX INFO: loaded from: classes.dex */
public class CodeGen extends AbstractVisitor {
    private final IJadxArgs args;

    public CodeGen(IJadxArgs iJadxArgs) {
        this.args = iJadxArgs;
    }

    @Override // jadx.core.dex.visitors.AbstractVisitor, jadx.core.dex.visitors.IDexTreeVisitor
    public boolean visit(ClassNode classNode) {
        CodeWriter codeWriterMakeClass = new ClassGen(classNode, this.args).makeClass();
        codeWriterMakeClass.finish();
        classNode.setCode(codeWriterMakeClass);
        return false;
    }
}
