package org.antlr.runtime.tree;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.TokenStream;

/* JADX INFO: loaded from: classes.dex */
public interface TreeNodeStream extends IntStream {
    /* JADX INFO: renamed from: LT */
    Object m3792LT(int i);

    TokenStream getTokenStream();

    TreeAdaptor getTreeAdaptor();

    String toString(Object obj, Object obj2);
}
