package org.p088jf.smali;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;

/* JADX INFO: loaded from: classes.dex */
public class OdexedInstructionException extends RecognitionException {
    public String odexedInstruction;

    public OdexedInstructionException(IntStream intStream, String str) {
        super(intStream);
        this.odexedInstruction = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.odexedInstruction + " is an odexed instruction. You cannot reassemble a disassembled odex file unless it has been deodexed.";
    }
}
