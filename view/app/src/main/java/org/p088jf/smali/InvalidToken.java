package org.p088jf.smali;

import org.antlr.runtime.CommonToken;

/* JADX INFO: loaded from: classes.dex */
public class InvalidToken extends CommonToken {
    public final String message;

    public InvalidToken(String str, String str2) {
        super(96, str2);
        this.message = str;
        this.channel = 100;
    }

    public String getMessage() {
        return this.message;
    }
}
