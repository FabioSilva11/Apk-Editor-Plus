package org.p088jf.dexlib2.util;

import java.util.Arrays;
import java.util.List;
import org.p088jf.dexlib2.iface.instruction.Instruction;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class InstructionOffsetMap {
    public final int[] instructionCodeOffsets;

    public static class InvalidInstructionIndex extends ExceptionWithContext {
        public InvalidInstructionIndex(int i) {
            super("Instruction index out of bounds: %d", Integer.valueOf(i));
        }
    }

    public static class InvalidInstructionOffset extends ExceptionWithContext {
        public InvalidInstructionOffset(int i) {
            super("No instruction at offset %d", Integer.valueOf(i));
        }
    }

    public InstructionOffsetMap(List<? extends Instruction> list) {
        this.instructionCodeOffsets = new int[list.size()];
        int codeUnits = 0;
        for (int i = 0; i < list.size(); i++) {
            this.instructionCodeOffsets[i] = codeUnits;
            codeUnits += list.get(i).getCodeUnits();
        }
    }

    public int getInstructionCodeOffset(int i) {
        if (i >= 0) {
            int[] iArr = this.instructionCodeOffsets;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        throw new InvalidInstructionIndex(i);
    }

    public int getInstructionIndexAtCodeOffset(int i) {
        return getInstructionIndexAtCodeOffset(i, true);
    }

    public int getInstructionIndexAtCodeOffset(int i, boolean z) {
        int iBinarySearch = Arrays.binarySearch(this.instructionCodeOffsets, i);
        if (iBinarySearch >= 0) {
            return iBinarySearch;
        }
        if (z) {
            throw new InvalidInstructionOffset(i);
        }
        return (iBinarySearch ^ (-1)) - 1;
    }
}
