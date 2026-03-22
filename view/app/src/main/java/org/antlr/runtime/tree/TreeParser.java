package org.antlr.runtime.tree;

import java.util.regex.Pattern;
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedTreeNodeException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class TreeParser extends BaseRecognizer {
    public static String doubleEtc = ".*\\.\\.\\.\\s+\\.\\.\\..*";
    public TreeNodeStream input;

    static {
        Pattern.compile(".*[^.]\\.\\.[^.].*");
        Pattern.compile(doubleEtc);
    }

    public TreeParser(TreeNodeStream treeNodeStream, RecognizerSharedState recognizerSharedState) {
        super(recognizerSharedState);
        setTreeNodeStream(treeNodeStream);
    }

    @Override // org.antlr.runtime.BaseRecognizer
    public Object getCurrentInputSymbol(IntStream intStream) {
        return ((TreeNodeStream) intStream).m3792LT(1);
    }

    @Override // org.antlr.runtime.BaseRecognizer
    public String getErrorMessage(RecognitionException recognitionException, String[] strArr) {
        TreeAdaptor treeAdaptor = ((TreeNodeStream) recognitionException.input).getTreeAdaptor();
        Token token = treeAdaptor.getToken(recognitionException.node);
        recognitionException.token = token;
        if (token == null) {
            recognitionException.token = new CommonToken(treeAdaptor.getType(recognitionException.node), treeAdaptor.getText(recognitionException.node));
        }
        return super.getErrorMessage(recognitionException, strArr);
    }

    @Override // org.antlr.runtime.BaseRecognizer
    public Object getMissingSymbol(IntStream intStream, RecognitionException recognitionException, int i, BitSet bitSet) {
        return ((TreeNodeStream) recognitionException.input).getTreeAdaptor().create(new CommonToken(i, "<missing " + getTokenNames()[i] + ">"));
    }

    public String getSourceName() {
        return this.input.getSourceName();
    }

    @Override // org.antlr.runtime.BaseRecognizer
    public Object recoverFromMismatchedToken(IntStream intStream, int i, BitSet bitSet) throws RecognitionException {
        throw new MismatchedTreeNodeException(i, (TreeNodeStream) intStream);
    }

    public void setTreeNodeStream(TreeNodeStream treeNodeStream) {
        this.input = treeNodeStream;
    }
}
