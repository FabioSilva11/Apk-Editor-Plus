package org.antlr.runtime;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CommonToken implements Token, Serializable {
    public int channel;
    public int charPositionInLine;
    public int index;
    public transient CharStream input;
    public int line;
    public int start;
    public int stop;
    public String text;
    public int type;

    public CommonToken(int i, String str) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.type = i;
        this.channel = 0;
        this.text = str;
    }

    public CommonToken(Token token) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.text = token.getText();
        this.type = token.getType();
        this.line = token.getLine();
        this.index = token.getTokenIndex();
        this.charPositionInLine = token.getCharPositionInLine();
        this.channel = token.getChannel();
        this.input = token.getInputStream();
        if (token instanceof CommonToken) {
            CommonToken commonToken = (CommonToken) token;
            this.start = commonToken.start;
            this.stop = commonToken.stop;
        }
    }

    @Override // org.antlr.runtime.Token
    public int getChannel() {
        return this.channel;
    }

    @Override // org.antlr.runtime.Token
    public int getCharPositionInLine() {
        return this.charPositionInLine;
    }

    @Override // org.antlr.runtime.Token
    public CharStream getInputStream() {
        return this.input;
    }

    @Override // org.antlr.runtime.Token
    public int getLine() {
        return this.line;
    }

    public int getStartIndex() {
        return this.start;
    }

    public int getStopIndex() {
        return this.stop;
    }

    @Override // org.antlr.runtime.Token
    public String getText() {
        int i;
        String str = this.text;
        if (str != null) {
            return str;
        }
        CharStream charStream = this.input;
        if (charStream == null) {
            return null;
        }
        int size = charStream.size();
        int i2 = this.start;
        return (i2 >= size || (i = this.stop) >= size) ? "<EOF>" : this.input.substring(i2, i);
    }

    @Override // org.antlr.runtime.Token
    public int getTokenIndex() {
        return this.index;
    }

    @Override // org.antlr.runtime.Token
    public int getType() {
        return this.type;
    }

    public void setChannel(int i) {
        this.channel = i;
    }

    public void setCharPositionInLine(int i) {
        this.charPositionInLine = i;
    }

    public void setLine(int i) {
        this.line = i;
    }

    public void setStartIndex(int i) {
        this.start = i;
    }

    public void setStopIndex(int i) {
        this.stop = i;
    }

    @Override // org.antlr.runtime.Token
    public void setText(String str) {
        this.text = str;
    }

    @Override // org.antlr.runtime.Token
    public void setTokenIndex(int i) {
        this.index = i;
    }

    @Override // org.antlr.runtime.Token
    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        String str;
        if (this.channel > 0) {
            str = ",channel=" + this.channel;
        } else {
            str = "";
        }
        String text = getText();
        return "[@" + getTokenIndex() + "," + this.start + ":" + this.stop + "='" + (text != null ? text.replaceAll("\n", "\\\\n").replaceAll("\r", "\\\\r").replaceAll("\t", "\\\\t") : "<no text>") + "',<" + this.type + ">" + str + "," + this.line + ":" + getCharPositionInLine() + "]";
    }
}
