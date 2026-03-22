package org.antlr.runtime.tree;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.misc.LookaheadStream;

/* JADX INFO: loaded from: classes.dex */
public class CommonTreeNodeStream extends LookaheadStream<Object> implements TreeNodeStream, PositionTrackingStream<Object> {
    public TreeAdaptor adaptor;
    public boolean hasNilRoot;

    /* JADX INFO: renamed from: it */
    public TreeIterator f4709it;
    public int level;
    public Object previousLocationElement;
    public Object root;
    public TokenStream tokens;

    public CommonTreeNodeStream(Object obj) {
        this(new CommonTreeAdaptor(), obj);
    }

    public CommonTreeNodeStream(TreeAdaptor treeAdaptor, Object obj) {
        this.hasNilRoot = false;
        this.level = 0;
        this.root = obj;
        this.adaptor = treeAdaptor;
        this.f4709it = new TreeIterator(treeAdaptor, obj);
    }

    @Override // org.antlr.runtime.IntStream
    /* JADX INFO: renamed from: LA */
    public int mo3787LA(int i) {
        return this.adaptor.getType(m3791LT(i));
    }

    @Override // org.antlr.runtime.tree.PositionTrackingStream
    public Object getKnownPositionElement(boolean z) {
        Object obj = this.data.get(this.f4708p);
        if (hasPositionInformation(obj)) {
            return obj;
        }
        if (!z) {
            return null;
        }
        for (int i = this.f4708p - 1; i >= 0; i--) {
            Object obj2 = this.data.get(i);
            if (hasPositionInformation(obj2)) {
                return obj2;
            }
        }
        return this.previousLocationElement;
    }

    @Override // org.antlr.runtime.IntStream
    public String getSourceName() {
        return getTokenStream().getSourceName();
    }

    @Override // org.antlr.runtime.tree.TreeNodeStream
    public TokenStream getTokenStream() {
        return this.tokens;
    }

    @Override // org.antlr.runtime.tree.TreeNodeStream
    public TreeAdaptor getTreeAdaptor() {
        return this.adaptor;
    }

    public boolean hasPositionInformation(Object obj) {
        Token token = this.adaptor.getToken(obj);
        return token != null && token.getLine() > 0;
    }

    @Override // org.antlr.runtime.misc.LookaheadStream
    public boolean isEOF(Object obj) {
        return this.adaptor.getType(obj) == -1;
    }

    @Override // org.antlr.runtime.misc.LookaheadStream
    public Object nextElement() {
        Object next = this.f4709it.next();
        TreeIterator treeIterator = this.f4709it;
        if (next == treeIterator.f4710up) {
            int i = this.level - 1;
            this.level = i;
            if (i == 0 && this.hasNilRoot) {
                return treeIterator.next();
            }
        } else if (next == treeIterator.down) {
            this.level++;
        }
        if (this.level != 0 || !this.adaptor.isNil(next)) {
            return next;
        }
        this.hasNilRoot = true;
        this.f4709it.next();
        this.level++;
        return this.f4709it.next();
    }

    @Override // org.antlr.runtime.misc.LookaheadStream, org.antlr.runtime.misc.FastQueue
    public Object remove() {
        Object objRemove = super.remove();
        if (this.f4708p == 0 && hasPositionInformation(this.prevElement)) {
            this.previousLocationElement = this.prevElement;
        }
        return objRemove;
    }

    public void setTokenStream(TokenStream tokenStream) {
        this.tokens = tokenStream;
    }

    @Override // org.antlr.runtime.tree.TreeNodeStream
    public String toString(Object obj, Object obj2) {
        return "n/a";
    }
}
