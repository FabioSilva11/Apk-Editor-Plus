package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class MismatchedNotSetException extends MismatchedSetException {
    @Override // org.antlr.runtime.MismatchedSetException, java.lang.Throwable
    public String toString() {
        return "MismatchedNotSetException(" + getUnexpectedType() + "!=" + this.expecting + ")";
    }
}
