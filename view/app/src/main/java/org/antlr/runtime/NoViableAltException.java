package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class NoViableAltException extends RecognitionException {
    public int decisionNumber;
    public String grammarDecisionDescription;
    public int stateNumber;

    public NoViableAltException() {
    }

    public NoViableAltException(String str, int i, int i2, IntStream intStream) {
        super(intStream);
        this.grammarDecisionDescription = str;
        this.decisionNumber = i;
        this.stateNumber = i2;
    }

    @Override // java.lang.Throwable
    public String toString() {
        if (this.input instanceof CharStream) {
            return "NoViableAltException('" + ((char) getUnexpectedType()) + "'@[" + this.grammarDecisionDescription + "])";
        }
        return "NoViableAltException(" + getUnexpectedType() + "@[" + this.grammarDecisionDescription + "])";
    }
}
