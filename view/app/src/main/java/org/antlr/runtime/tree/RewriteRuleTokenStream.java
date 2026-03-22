package org.antlr.runtime.tree;

import org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class RewriteRuleTokenStream extends RewriteRuleElementStream {
    public RewriteRuleTokenStream(TreeAdaptor treeAdaptor, String str) {
        super(treeAdaptor, str);
    }

    public RewriteRuleTokenStream(TreeAdaptor treeAdaptor, String str, Object obj) {
        super(treeAdaptor, str, obj);
    }

    @Override // org.antlr.runtime.tree.RewriteRuleElementStream
    public Object dup(Object obj) {
        throw new UnsupportedOperationException("dup can't be called for a token stream.");
    }

    public Object nextNode() {
        return this.adaptor.create((Token) _next());
    }

    @Override // org.antlr.runtime.tree.RewriteRuleElementStream
    public Object toTree(Object obj) {
        return obj;
    }
}
