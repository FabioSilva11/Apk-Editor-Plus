package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class RecognizerSharedState {
    public boolean failed;
    public BitSet[] following = new BitSet[100];
    public int _fsp = -1;
    public boolean errorRecovery = false;
    public int lastErrorIndex = -1;
    public int syntaxErrors = 0;
    public int backtracking = 0;
}
