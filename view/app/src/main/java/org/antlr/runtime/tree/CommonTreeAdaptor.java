package org.antlr.runtime.tree;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class CommonTreeAdaptor extends BaseTreeAdaptor {
    @Override // org.antlr.runtime.tree.TreeAdaptor
    public Object create(Token token) {
        return new CommonTree(token);
    }

    @Override // org.antlr.runtime.tree.BaseTreeAdaptor
    public Token createToken(int i, String str) {
        return new CommonToken(i, str);
    }

    @Override // org.antlr.runtime.tree.BaseTreeAdaptor
    public Token createToken(Token token) {
        return new CommonToken(token);
    }

    @Override // org.antlr.runtime.tree.TreeAdaptor
    public Object dupNode(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((Tree) obj).dupNode();
    }

    @Override // org.antlr.runtime.tree.BaseTreeAdaptor, org.antlr.runtime.tree.TreeAdaptor
    public Object getChild(Object obj, int i) {
        if (obj == null) {
            return null;
        }
        return ((Tree) obj).getChild(i);
    }

    @Override // org.antlr.runtime.tree.BaseTreeAdaptor, org.antlr.runtime.tree.TreeAdaptor
    public int getChildCount(Object obj) {
        if (obj == null) {
            return 0;
        }
        return ((Tree) obj).getChildCount();
    }

    @Override // org.antlr.runtime.tree.TreeAdaptor
    public int getChildIndex(Object obj) {
        if (obj == null) {
            return 0;
        }
        return ((Tree) obj).getChildIndex();
    }

    @Override // org.antlr.runtime.tree.TreeAdaptor
    public Object getParent(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((Tree) obj).getParent();
    }

    @Override // org.antlr.runtime.tree.TreeAdaptor
    public String getText(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((Tree) obj).getText();
    }

    @Override // org.antlr.runtime.tree.TreeAdaptor
    public Token getToken(Object obj) {
        if (obj instanceof CommonTree) {
            return ((CommonTree) obj).getToken();
        }
        return null;
    }

    @Override // org.antlr.runtime.tree.TreeAdaptor
    public int getTokenStartIndex(Object obj) {
        if (obj == null) {
            return -1;
        }
        return ((Tree) obj).getTokenStartIndex();
    }

    @Override // org.antlr.runtime.tree.TreeAdaptor
    public int getTokenStopIndex(Object obj) {
        if (obj == null) {
            return -1;
        }
        return ((Tree) obj).getTokenStopIndex();
    }

    @Override // org.antlr.runtime.tree.TreeAdaptor
    public int getType(Object obj) {
        if (obj == null) {
            return 0;
        }
        return ((Tree) obj).getType();
    }

    @Override // org.antlr.runtime.tree.TreeAdaptor
    public void setChildIndex(Object obj, int i) {
        if (obj != null) {
            ((Tree) obj).setChildIndex(i);
        }
    }

    @Override // org.antlr.runtime.tree.TreeAdaptor
    public void setParent(Object obj, Object obj2) {
        if (obj != null) {
            ((Tree) obj).setParent((Tree) obj2);
        }
    }

    @Override // org.antlr.runtime.tree.TreeAdaptor
    public void setTokenBoundaries(Object obj, Token token, Token token2) {
        if (obj == null) {
            return;
        }
        int tokenIndex = token != null ? token.getTokenIndex() : 0;
        int tokenIndex2 = token2 != null ? token2.getTokenIndex() : 0;
        Tree tree = (Tree) obj;
        tree.setTokenStartIndex(tokenIndex);
        tree.setTokenStopIndex(tokenIndex2);
    }
}
