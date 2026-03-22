package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface CharStream extends IntStream {
    int getCharPositionInLine();

    int getLine();

    String substring(int i, int i2);
}
