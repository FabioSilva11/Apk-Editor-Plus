package org.antlr.runtime.tree;

/* JADX INFO: loaded from: classes.dex */
public class RewriteCardinalityException extends RuntimeException {
    public String elementDescription;

    public RewriteCardinalityException(String str) {
        this.elementDescription = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str = this.elementDescription;
        if (str != null) {
            return str;
        }
        return null;
    }
}
