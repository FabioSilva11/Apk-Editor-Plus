package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class FailedPredicateException extends RecognitionException {
    public String predicateText;
    public String ruleName;

    public FailedPredicateException() {
    }

    public FailedPredicateException(IntStream intStream, String str, String str2) {
        super(intStream);
        this.ruleName = str;
        this.predicateText = str2;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "FailedPredicateException(" + this.ruleName + ",{" + this.predicateText + "}?)";
    }
}
