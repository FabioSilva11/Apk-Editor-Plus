package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface Token {
    int getChannel();

    int getCharPositionInLine();

    CharStream getInputStream();

    int getLine();

    String getText();

    int getTokenIndex();

    int getType();

    void setText(String str);

    void setTokenIndex(int i);

    void setType(int i);
}
