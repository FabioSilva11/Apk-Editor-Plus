package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface TokenSource {
    String getSourceName();

    Token nextToken();
}
