package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface IntStream {
    /* JADX INFO: renamed from: LA */
    int mo3787LA(int i);

    void consume();

    String getSourceName();

    int index();

    int mark();

    void rewind();

    void rewind(int i);

    void seek(int i);

    int size();
}
