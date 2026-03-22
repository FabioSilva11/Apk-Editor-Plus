package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class MismatchedSetException extends RecognitionException {
    public BitSet expecting;

    public MismatchedSetException() {
    }

    public MismatchedSetException(BitSet bitSet, IntStream intStream) {
        super(intStream);
        this.expecting = bitSet;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "MismatchedSetException(" + getUnexpectedType() + "!=" + this.expecting + ")";
    }
}
