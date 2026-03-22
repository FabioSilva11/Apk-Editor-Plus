package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class MissingTokenException extends MismatchedTokenException {
    public Object inserted;

    public MissingTokenException() {
    }

    public MissingTokenException(int i, IntStream intStream, Object obj) {
        super(i, intStream);
        this.inserted = obj;
    }

    public int getMissingType() {
        return this.expecting;
    }

    @Override // org.antlr.runtime.MismatchedTokenException, java.lang.Throwable
    public String toString() {
        if (this.inserted == null || this.token == null) {
            if (this.token == null) {
                return "MissingTokenException";
            }
            return "MissingTokenException(at " + this.token.getText() + ")";
        }
        return "MissingTokenException(inserted " + this.inserted + " at " + this.token.getText() + ")";
    }
}
