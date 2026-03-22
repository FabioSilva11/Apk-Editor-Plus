package org.antlr.runtime.tree;

/* JADX INFO: loaded from: classes.dex */
public interface Tree {
    void addChild(Tree tree);

    Tree dupNode();

    int getCharPositionInLine();

    Tree getChild(int i);

    int getChildCount();

    int getChildIndex();

    int getLine();

    Tree getParent();

    String getText();

    int getTokenStartIndex();

    int getTokenStopIndex();

    int getType();

    boolean isNil();

    void setChildIndex(int i);

    void setParent(Tree tree);

    void setTokenStartIndex(int i);

    void setTokenStopIndex(int i);
}
