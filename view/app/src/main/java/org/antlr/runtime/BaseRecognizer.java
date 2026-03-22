package org.antlr.runtime;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseRecognizer {
    public RecognizerSharedState state;

    public BaseRecognizer(RecognizerSharedState recognizerSharedState) {
        this.state = recognizerSharedState == null ? new RecognizerSharedState() : recognizerSharedState;
    }

    public static List<String> getRuleInvocationStack(Throwable th, String str) {
        ArrayList arrayList = new ArrayList();
        StackTraceElement[] stackTrace = th.getStackTrace();
        for (int length = stackTrace.length - 1; length >= 0; length--) {
            StackTraceElement stackTraceElement = stackTrace[length];
            if (!stackTraceElement.getClassName().startsWith("org.antlr.runtime.") && !stackTraceElement.getMethodName().equals("nextToken") && stackTraceElement.getClassName().equals(str)) {
                arrayList.add(stackTraceElement.getMethodName());
            }
        }
        return arrayList;
    }

    public void beginResync() {
    }

    public BitSet combineFollows(boolean z) {
        BitSet bitSet = new BitSet();
        for (int i = this.state._fsp; i >= 0; i--) {
            BitSet bitSet2 = this.state.following[i];
            bitSet.orInPlace(bitSet2);
            if (z) {
                if (!bitSet2.member(1)) {
                    break;
                }
                if (i > 0) {
                    bitSet.remove(1);
                }
            }
        }
        return bitSet;
    }

    public BitSet computeContextSensitiveRuleFOLLOW() {
        return combineFollows(true);
    }

    public BitSet computeErrorRecoverySet() {
        return combineFollows(false);
    }

    public void consumeUntil(IntStream intStream, BitSet bitSet) {
        int iMo3787LA = intStream.mo3787LA(1);
        while (iMo3787LA != -1 && !bitSet.member(iMo3787LA)) {
            intStream.consume();
            iMo3787LA = intStream.mo3787LA(1);
        }
    }

    public void displayRecognitionError(String[] strArr, RecognitionException recognitionException) {
        emitErrorMessage(getErrorHeader(recognitionException) + " " + getErrorMessage(recognitionException, strArr));
    }

    public void emitErrorMessage(String str) {
        System.err.println(str);
    }

    public void endResync() {
    }

    public abstract Object getCurrentInputSymbol(IntStream intStream);

    public abstract String getErrorHeader(RecognitionException recognitionException);

    public String getErrorMessage(RecognitionException recognitionException, String[] strArr) {
        String message = recognitionException.getMessage();
        if (recognitionException instanceof UnwantedTokenException) {
            UnwantedTokenException unwantedTokenException = (UnwantedTokenException) recognitionException;
            int i = unwantedTokenException.expecting;
            return "extraneous input " + getTokenErrorDisplay(unwantedTokenException.getUnexpectedToken()) + " expecting " + (i != -1 ? strArr[i] : "EOF");
        }
        if (recognitionException instanceof MissingTokenException) {
            int i2 = ((MissingTokenException) recognitionException).expecting;
            return "missing " + (i2 != -1 ? strArr[i2] : "EOF") + " at " + getTokenErrorDisplay(recognitionException.token);
        }
        if (recognitionException instanceof MismatchedTokenException) {
            int i3 = ((MismatchedTokenException) recognitionException).expecting;
            return "mismatched input " + getTokenErrorDisplay(recognitionException.token) + " expecting " + (i3 != -1 ? strArr[i3] : "EOF");
        }
        if (recognitionException instanceof MismatchedTreeNodeException) {
            MismatchedTreeNodeException mismatchedTreeNodeException = (MismatchedTreeNodeException) recognitionException;
            int i4 = mismatchedTreeNodeException.expecting;
            return "mismatched tree node: " + mismatchedTreeNodeException.node + " expecting " + (i4 != -1 ? strArr[i4] : "EOF");
        }
        if (recognitionException instanceof NoViableAltException) {
            return "no viable alternative at input " + getTokenErrorDisplay(recognitionException.token);
        }
        if (recognitionException instanceof EarlyExitException) {
            return "required (...)+ loop did not match anything at input " + getTokenErrorDisplay(recognitionException.token);
        }
        if (recognitionException instanceof MismatchedSetException) {
            return "mismatched input " + getTokenErrorDisplay(recognitionException.token) + " expecting set " + ((MismatchedSetException) recognitionException).expecting;
        }
        if (recognitionException instanceof MismatchedNotSetException) {
            return "mismatched input " + getTokenErrorDisplay(recognitionException.token) + " expecting set " + ((MismatchedNotSetException) recognitionException).expecting;
        }
        if (!(recognitionException instanceof FailedPredicateException)) {
            return message;
        }
        FailedPredicateException failedPredicateException = (FailedPredicateException) recognitionException;
        return "rule " + failedPredicateException.ruleName + " failed predicate: {" + failedPredicateException.predicateText + "}?";
    }

    public abstract Object getMissingSymbol(IntStream intStream, RecognitionException recognitionException, int i, BitSet bitSet);

    public int getNumberOfSyntaxErrors() {
        return this.state.syntaxErrors;
    }

    public String getTokenErrorDisplay(Token token) {
        String text = token.getText();
        if (text == null) {
            if (token.getType() == -1) {
                text = "<EOF>";
            } else {
                text = "<" + token.getType() + ">";
            }
        }
        return "'" + text.replaceAll("\n", "\\\\n").replaceAll("\r", "\\\\r").replaceAll("\t", "\\\\t") + "'";
    }

    public abstract String[] getTokenNames();

    public Object match(IntStream intStream, int i, BitSet bitSet) throws RecognitionException {
        Object currentInputSymbol = getCurrentInputSymbol(intStream);
        if (intStream.mo3787LA(1) == i) {
            intStream.consume();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState.errorRecovery = false;
            recognizerSharedState.failed = false;
            return currentInputSymbol;
        }
        RecognizerSharedState recognizerSharedState2 = this.state;
        if (recognizerSharedState2.backtracking <= 0) {
            return recoverFromMismatchedToken(intStream, i, bitSet);
        }
        recognizerSharedState2.failed = true;
        return currentInputSymbol;
    }

    public boolean mismatchIsMissingToken(IntStream intStream, BitSet bitSet) {
        if (bitSet == null) {
            return false;
        }
        if (bitSet.member(1)) {
            bitSet = bitSet.m3786or(computeContextSensitiveRuleFOLLOW());
            if (this.state._fsp >= 0) {
                bitSet.remove(1);
            }
        }
        return bitSet.member(intStream.mo3787LA(1)) || bitSet.member(1);
    }

    public boolean mismatchIsUnwantedToken(IntStream intStream, int i) {
        return intStream.mo3787LA(2) == i;
    }

    public void pushFollow(BitSet bitSet) {
        RecognizerSharedState recognizerSharedState = this.state;
        int i = recognizerSharedState._fsp + 1;
        BitSet[] bitSetArr = recognizerSharedState.following;
        if (i >= bitSetArr.length) {
            BitSet[] bitSetArr2 = new BitSet[bitSetArr.length * 2];
            System.arraycopy(bitSetArr, 0, bitSetArr2, 0, bitSetArr.length);
            this.state.following = bitSetArr2;
        }
        RecognizerSharedState recognizerSharedState2 = this.state;
        BitSet[] bitSetArr3 = recognizerSharedState2.following;
        int i2 = recognizerSharedState2._fsp + 1;
        recognizerSharedState2._fsp = i2;
        bitSetArr3[i2] = bitSet;
    }

    public void recover(IntStream intStream, RecognitionException recognitionException) {
        if (this.state.lastErrorIndex == intStream.index()) {
            intStream.consume();
        }
        this.state.lastErrorIndex = intStream.index();
        BitSet bitSetComputeErrorRecoverySet = computeErrorRecoverySet();
        beginResync();
        consumeUntil(intStream, bitSetComputeErrorRecoverySet);
        endResync();
    }

    public Object recoverFromMismatchedToken(IntStream intStream, int i, BitSet bitSet) throws RecognitionException {
        if (!mismatchIsUnwantedToken(intStream, i)) {
            if (!mismatchIsMissingToken(intStream, bitSet)) {
                throw new MismatchedTokenException(i, intStream);
            }
            Object missingSymbol = getMissingSymbol(intStream, null, i, bitSet);
            reportError(new MissingTokenException(i, intStream, missingSymbol));
            return missingSymbol;
        }
        UnwantedTokenException unwantedTokenException = new UnwantedTokenException(i, intStream);
        beginResync();
        intStream.consume();
        endResync();
        reportError(unwantedTokenException);
        Object currentInputSymbol = getCurrentInputSymbol(intStream);
        intStream.consume();
        return currentInputSymbol;
    }

    public void reportError(RecognitionException recognitionException) {
        RecognizerSharedState recognizerSharedState = this.state;
        if (recognizerSharedState.errorRecovery) {
            return;
        }
        recognizerSharedState.syntaxErrors++;
        recognizerSharedState.errorRecovery = true;
        displayRecognitionError(getTokenNames(), recognitionException);
    }
}
