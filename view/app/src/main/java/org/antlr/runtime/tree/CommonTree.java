package org.antlr.runtime.tree;

import org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class CommonTree extends BaseTree {
    public int childIndex;
    public CommonTree parent;
    public int startIndex;
    public int stopIndex;
    public Token token;

    public CommonTree() {
        this.startIndex = -1;
        this.stopIndex = -1;
        this.childIndex = -1;
    }

    public CommonTree(Token token) {
        this.startIndex = -1;
        this.stopIndex = -1;
        this.childIndex = -1;
        this.token = token;
    }

    public CommonTree(CommonTree commonTree) {
        super(commonTree);
        this.startIndex = -1;
        this.stopIndex = -1;
        this.childIndex = -1;
        this.token = commonTree.token;
        this.startIndex = commonTree.startIndex;
        this.stopIndex = commonTree.stopIndex;
    }

    @Override // org.antlr.runtime.tree.Tree
    public Tree dupNode() {
        return new CommonTree(this);
    }

    @Override // org.antlr.runtime.tree.BaseTree, org.antlr.runtime.tree.Tree
    public int getCharPositionInLine() {
        Token token = this.token;
        if (token != null && token.getCharPositionInLine() != -1) {
            return this.token.getCharPositionInLine();
        }
        if (getChildCount() > 0) {
            return getChild(0).getCharPositionInLine();
        }
        return 0;
    }

    @Override // org.antlr.runtime.tree.BaseTree, org.antlr.runtime.tree.Tree
    public int getChildIndex() {
        return this.childIndex;
    }

    @Override // org.antlr.runtime.tree.BaseTree, org.antlr.runtime.tree.Tree
    public int getLine() {
        Token token = this.token;
        if (token != null && token.getLine() != 0) {
            return this.token.getLine();
        }
        if (getChildCount() > 0) {
            return getChild(0).getLine();
        }
        return 0;
    }

    @Override // org.antlr.runtime.tree.BaseTree, org.antlr.runtime.tree.Tree
    public Tree getParent() {
        return this.parent;
    }

    @Override // org.antlr.runtime.tree.Tree
    public String getText() {
        Token token = this.token;
        if (token == null) {
            return null;
        }
        return token.getText();
    }

    public Token getToken() {
        return this.token;
    }

    @Override // org.antlr.runtime.tree.Tree
    public int getTokenStartIndex() {
        Token token;
        int i = this.startIndex;
        return (i != -1 || (token = this.token) == null) ? i : token.getTokenIndex();
    }

    @Override // org.antlr.runtime.tree.Tree
    public int getTokenStopIndex() {
        Token token;
        int i = this.stopIndex;
        return (i != -1 || (token = this.token) == null) ? i : token.getTokenIndex();
    }

    @Override // org.antlr.runtime.tree.Tree
    public int getType() {
        Token token = this.token;
        if (token == null) {
            return 0;
        }
        return token.getType();
    }

    @Override // org.antlr.runtime.tree.BaseTree, org.antlr.runtime.tree.Tree
    public boolean isNil() {
        return this.token == null;
    }

    @Override // org.antlr.runtime.tree.BaseTree, org.antlr.runtime.tree.Tree
    public void setChildIndex(int i) {
        this.childIndex = i;
    }

    @Override // org.antlr.runtime.tree.BaseTree, org.antlr.runtime.tree.Tree
    public void setParent(Tree tree) {
        this.parent = (CommonTree) tree;
    }

    @Override // org.antlr.runtime.tree.Tree
    public void setTokenStartIndex(int i) {
        this.startIndex = i;
    }

    @Override // org.antlr.runtime.tree.Tree
    public void setTokenStopIndex(int i) {
        this.stopIndex = i;
    }

    public String toString() {
        if (isNil()) {
            return "nil";
        }
        if (getType() == 0) {
            return "<errornode>";
        }
        Token token = this.token;
        if (token == null) {
            return null;
        }
        return token.getText();
    }
}
