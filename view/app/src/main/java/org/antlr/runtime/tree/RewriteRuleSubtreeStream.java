package org.antlr.runtime.tree;

/* JADX INFO: loaded from: classes.dex */
public class RewriteRuleSubtreeStream extends RewriteRuleElementStream {
    public RewriteRuleSubtreeStream(TreeAdaptor treeAdaptor, String str) {
        super(treeAdaptor, str);
    }

    public RewriteRuleSubtreeStream(TreeAdaptor treeAdaptor, String str, Object obj) {
        super(treeAdaptor, str, obj);
    }

    @Override // org.antlr.runtime.tree.RewriteRuleElementStream
    public Object dup(Object obj) {
        return this.adaptor.dupTree(obj);
    }
}
