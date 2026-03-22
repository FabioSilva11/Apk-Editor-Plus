package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class Parser extends BaseRecognizer {
    public TokenStream input;

    public Parser(TokenStream tokenStream, RecognizerSharedState recognizerSharedState) {
        super(recognizerSharedState);
        this.input = tokenStream;
    }

    @Override // org.antlr.runtime.BaseRecognizer
    public Object getCurrentInputSymbol(IntStream intStream) {
        return ((TokenStream) intStream).mo3788LT(1);
    }

    @Override // org.antlr.runtime.BaseRecognizer
    public Object getMissingSymbol(IntStream intStream, RecognitionException recognitionException, int i, BitSet bitSet) {
        String str;
        if (i == -1) {
            str = "<missing EOF>";
        } else {
            str = "<missing " + getTokenNames()[i] + ">";
        }
        CommonToken commonToken = new CommonToken(i, str);
        TokenStream tokenStream = (TokenStream) intStream;
        Token tokenMo3788LT = tokenStream.mo3788LT(1);
        if (tokenMo3788LT.getType() == -1) {
            tokenMo3788LT = tokenStream.mo3788LT(-1);
        }
        commonToken.line = tokenMo3788LT.getLine();
        commonToken.charPositionInLine = tokenMo3788LT.getCharPositionInLine();
        commonToken.channel = 0;
        commonToken.input = tokenMo3788LT.getInputStream();
        return commonToken;
    }

    public String getSourceName() {
        return this.input.getSourceName();
    }
}
