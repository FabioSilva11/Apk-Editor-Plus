package org.antlr.runtime.tree;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTree implements Tree {
    public List<Object> children;

    public BaseTree() {
    }

    public BaseTree(Tree tree) {
    }

    @Override // org.antlr.runtime.tree.Tree
    public void addChild(Tree tree) {
        if (tree == null) {
            return;
        }
        BaseTree baseTree = (BaseTree) tree;
        if (!baseTree.isNil()) {
            if (this.children == null) {
                this.children = createChildrenList();
            }
            this.children.add(tree);
            baseTree.setParent(this);
            baseTree.setChildIndex(this.children.size() - 1);
            return;
        }
        List<Object> list = this.children;
        if (list != null && list == baseTree.children) {
            throw new RuntimeException("attempt to add child list to itself");
        }
        List<Object> list2 = baseTree.children;
        if (list2 != null) {
            if (list == null) {
                this.children = list2;
                freshenParentAndChildIndexes();
                return;
            }
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                Tree tree2 = (Tree) baseTree.children.get(i);
                this.children.add(tree2);
                tree2.setParent(this);
                tree2.setChildIndex(this.children.size() - 1);
            }
        }
    }

    public List<Object> createChildrenList() {
        return new ArrayList();
    }

    public void freshenParentAndChildIndexes() {
        freshenParentAndChildIndexes(0);
    }

    public void freshenParentAndChildIndexes(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            Tree child = getChild(i);
            child.setChildIndex(i);
            child.setParent(this);
            i++;
        }
    }

    @Override // org.antlr.runtime.tree.Tree
    public int getCharPositionInLine() {
        return 0;
    }

    @Override // org.antlr.runtime.tree.Tree
    public Tree getChild(int i) {
        List<Object> list = this.children;
        if (list == null || i >= list.size()) {
            return null;
        }
        return (Tree) this.children.get(i);
    }

    @Override // org.antlr.runtime.tree.Tree
    public int getChildCount() {
        List<Object> list = this.children;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // org.antlr.runtime.tree.Tree
    public int getChildIndex() {
        return 0;
    }

    @Override // org.antlr.runtime.tree.Tree
    public int getLine() {
        return 0;
    }

    @Override // org.antlr.runtime.tree.Tree
    public Tree getParent() {
        return null;
    }

    @Override // org.antlr.runtime.tree.Tree
    public boolean isNil() {
        return false;
    }

    @Override // org.antlr.runtime.tree.Tree
    public void setChildIndex(int i) {
    }

    @Override // org.antlr.runtime.tree.Tree
    public void setParent(Tree tree) {
    }
}
