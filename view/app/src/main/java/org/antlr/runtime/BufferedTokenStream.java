package org.antlr.runtime;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BufferedTokenStream implements TokenStream {
    public int lastMarker;
    public TokenSource tokenSource;
    public List<Token> tokens = new ArrayList(100);

    /* JADX INFO: renamed from: p */
    public int f4706p = -1;
    public int range = -1;

    public BufferedTokenStream(TokenSource tokenSource) {
        this.tokenSource = tokenSource;
    }

    @Override // org.antlr.runtime.IntStream
    /* JADX INFO: renamed from: LA */
    public int mo3787LA(int i) {
        return mo3788LT(i).getType();
    }

    @Override // org.antlr.runtime.TokenStream
    /* JADX INFO: renamed from: LT */
    public Token mo3788LT(int i) {
        throw null;
    }

    public void fetch(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            Token tokenNextToken = this.tokenSource.nextToken();
            tokenNextToken.setTokenIndex(this.tokens.size());
            this.tokens.add(tokenNextToken);
            if (tokenNextToken.getType() == -1) {
                return;
            }
        }
    }

    public void fill() {
        if (this.f4706p == -1) {
            setup();
        }
        if (this.tokens.get(this.f4706p).getType() == -1) {
            return;
        }
        int i = this.f4706p + 1;
        sync(i);
        while (this.tokens.get(i).getType() != -1) {
            i++;
            sync(i);
        }
    }

    @Override // org.antlr.runtime.IntStream
    public String getSourceName() {
        return this.tokenSource.getSourceName();
    }

    @Override // org.antlr.runtime.IntStream
    public int index() {
        return this.f4706p;
    }

    @Override // org.antlr.runtime.IntStream
    public int mark() {
        if (this.f4706p == -1) {
            setup();
        }
        int iIndex = index();
        this.lastMarker = iIndex;
        return iIndex;
    }

    @Override // org.antlr.runtime.IntStream
    public void rewind() {
        seek(this.lastMarker);
    }

    @Override // org.antlr.runtime.IntStream
    public void rewind(int i) {
        seek(i);
    }

    @Override // org.antlr.runtime.IntStream
    public void seek(int i) {
        this.f4706p = i;
    }

    public void setup() {
        throw null;
    }

    @Override // org.antlr.runtime.IntStream
    public int size() {
        return this.tokens.size();
    }

    public void sync(int i) {
        int size = (i - this.tokens.size()) + 1;
        if (size > 0) {
            fetch(size);
        }
    }

    public String toString() {
        if (this.f4706p == -1) {
            setup();
        }
        fill();
        return toString(0, this.tokens.size() - 1);
    }

    @Override // org.antlr.runtime.TokenStream
    public String toString(int i, int i2) {
        if (i < 0 || i2 < 0) {
            return null;
        }
        if (this.f4706p == -1) {
            setup();
        }
        if (i2 >= this.tokens.size()) {
            i2 = this.tokens.size() - 1;
        }
        StringBuilder sb = new StringBuilder();
        while (i <= i2) {
            Token token = this.tokens.get(i);
            if (token.getType() == -1) {
                break;
            }
            sb.append(token.getText());
            i++;
        }
        return sb.toString();
    }

    @Override // org.antlr.runtime.TokenStream
    public String toString(Token token, Token token2) {
        if (token == null || token2 == null) {
            return null;
        }
        return toString(token.getTokenIndex(), token2.getTokenIndex());
    }
}
