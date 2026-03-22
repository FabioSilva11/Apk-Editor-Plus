package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class MismatchedTokenException extends RecognitionException {
    public int expecting;

    public MismatchedTokenException() {
        this.expecting = 0;
    }

    public MismatchedTokenException(int i, IntStream intStream) {
        super(intStream);
        this.expecting = 0;
        this.expecting = i;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "MismatchedTokenException(" + getUnexpectedType() + "!=" + this.expecting + ")";
    }
}
