package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class DFA {
    public short[] accept;
    public int decisionNumber;
    public short[] eof;
    public short[] eot;
    public char[] max;
    public char[] min;
    public BaseRecognizer recognizer;
    public short[] special;
    public short[][] transition;

    public static short[] unpackEncodedString(String str) {
        int iCharAt = 0;
        for (int i = 0; i < str.length(); i += 2) {
            iCharAt += str.charAt(i);
        }
        short[] sArr = new short[iCharAt];
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3 += 2) {
            char cCharAt = str.charAt(i3);
            char cCharAt2 = str.charAt(i3 + 1);
            int i4 = 1;
            while (i4 <= cCharAt) {
                sArr[i2] = (short) cCharAt2;
                i4++;
                i2++;
            }
        }
        return sArr;
    }

    public static char[] unpackEncodedStringToUnsignedChars(String str) {
        int iCharAt = 0;
        for (int i = 0; i < str.length(); i += 2) {
            iCharAt += str.charAt(i);
        }
        char[] cArr = new char[iCharAt];
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3 += 2) {
            char cCharAt = str.charAt(i3);
            char cCharAt2 = str.charAt(i3 + 1);
            int i4 = 1;
            while (i4 <= cCharAt) {
                cArr[i2] = cCharAt2;
                i4++;
                i2++;
            }
        }
        return cArr;
    }

    public void error(NoViableAltException noViableAltException) {
    }

    public String getDescription() {
        throw null;
    }

    public void noViableAlt(int i, IntStream intStream) throws NoViableAltException {
        RecognizerSharedState recognizerSharedState = this.recognizer.state;
        if (recognizerSharedState.backtracking > 0) {
            recognizerSharedState.failed = true;
        } else {
            NoViableAltException noViableAltException = new NoViableAltException(getDescription(), this.decisionNumber, i, intStream);
            error(noViableAltException);
            throw noViableAltException;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [short] */
    /* JADX WARN: Type inference failed for: r2v6, types: [short] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.antlr.runtime.DFA] */
    public int predict(IntStream intStream) throws RecognitionException {
        int iMark = intStream.mark();
        short sSpecialStateTransition = 0;
        while (true) {
            try {
                short s = this.special[sSpecialStateTransition];
                if (s >= 0) {
                    sSpecialStateTransition = specialStateTransition(s, intStream);
                    if (sSpecialStateTransition == -1) {
                        noViableAlt(sSpecialStateTransition, intStream);
                        return 0;
                    }
                    intStream.consume();
                } else {
                    short[] sArr = this.accept;
                    if (sArr[sSpecialStateTransition] >= 1) {
                        return sArr[sSpecialStateTransition];
                    }
                    char cMo3787LA = (char) intStream.mo3787LA(1);
                    char[] cArr = this.min;
                    if (cMo3787LA < cArr[sSpecialStateTransition] || cMo3787LA > this.max[sSpecialStateTransition]) {
                        short[] sArr2 = this.eot;
                        if (sArr2[sSpecialStateTransition] < 0) {
                            if (cMo3787LA == 65535) {
                                short[] sArr3 = this.eof;
                                if (sArr3[sSpecialStateTransition] >= 0) {
                                    return this.accept[sArr3[sSpecialStateTransition]];
                                }
                            }
                            noViableAlt(sSpecialStateTransition, intStream);
                            return 0;
                        }
                        sSpecialStateTransition = sArr2[sSpecialStateTransition];
                        intStream.consume();
                    } else {
                        short s2 = this.transition[sSpecialStateTransition][cMo3787LA - cArr[sSpecialStateTransition]];
                        if (s2 < 0) {
                            short[] sArr4 = this.eot;
                            if (sArr4[sSpecialStateTransition] < 0) {
                                noViableAlt(sSpecialStateTransition, intStream);
                                return 0;
                            }
                            sSpecialStateTransition = sArr4[sSpecialStateTransition];
                            intStream.consume();
                        } else {
                            intStream.consume();
                            sSpecialStateTransition = s2;
                        }
                    }
                }
            } finally {
                intStream.rewind(iMark);
            }
        }
    }

    public int specialStateTransition(int i, IntStream intStream) throws NoViableAltException {
        return -1;
    }
}
