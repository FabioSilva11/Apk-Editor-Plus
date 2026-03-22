package org.p088jf.dexlib2.dexbacked;

import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;
import org.p088jf.dexlib2.dexbacked.instruction.DexBackedInstruction;
import org.p088jf.dexlib2.dexbacked.util.DebugInfo;
import org.p088jf.dexlib2.dexbacked.util.FixedSizeList;
import org.p088jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator;
import org.p088jf.dexlib2.iface.MethodImplementation;
import org.p088jf.dexlib2.iface.debug.DebugItem;
import org.p088jf.dexlib2.iface.instruction.Instruction;
import org.p088jf.dexlib2.util.AlignmentUtils;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedMethodImplementation implements MethodImplementation {
    public final int codeOffset;
    public final DexBackedDexFile dexFile;
    public final DexBackedMethod method;

    public DexBackedMethodImplementation(DexBackedDexFile dexBackedDexFile, DexBackedMethod dexBackedMethod, int i) {
        this.dexFile = dexBackedDexFile;
        this.method = dexBackedMethod;
        this.codeOffset = i;
    }

    public final DebugInfo getDebugInfo() {
        int debugOffset = getDebugOffset();
        if (debugOffset == -1 || debugOffset == 0) {
            return DebugInfo.newOrEmpty(this.dexFile, 0, this);
        }
        if (debugOffset < 0) {
            System.err.println(String.format("%s: Invalid debug offset", this.method));
            return DebugInfo.newOrEmpty(this.dexFile, 0, this);
        }
        if (this.dexFile.getBaseDataOffset() + debugOffset < this.dexFile.getBuffer().buf.length) {
            return DebugInfo.newOrEmpty(this.dexFile, debugOffset, this);
        }
        System.err.println(String.format("%s: Invalid debug offset", this.method));
        return DebugInfo.newOrEmpty(this.dexFile, 0, this);
    }

    @Override // org.p088jf.dexlib2.iface.MethodImplementation
    public Iterable<? extends DebugItem> getDebugItems() {
        return getDebugInfo();
    }

    public int getDebugOffset() {
        return this.dexFile.getDataBuffer().readInt(this.codeOffset + 8);
    }

    @Override // org.p088jf.dexlib2.iface.MethodImplementation
    public Iterable<? extends Instruction> getInstructions() {
        int instructionsSize = getInstructionsSize();
        final int instructionsStartOffset = getInstructionsStartOffset();
        final int i = (instructionsSize * 2) + instructionsStartOffset;
        return new Iterable<Instruction>() { // from class: org.jf.dexlib2.dexbacked.DexBackedMethodImplementation.1
            @Override // java.lang.Iterable
            public Iterator<Instruction> iterator() {
                return new VariableSizeLookaheadIterator<Instruction>(DexBackedMethodImplementation.this.dexFile.getDataBuffer(), instructionsStartOffset) { // from class: org.jf.dexlib2.dexbacked.DexBackedMethodImplementation.1.1
                    @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator
                    public Instruction readNextItem(DexReader dexReader) {
                        int offset = dexReader.getOffset();
                        C17261 c17261 = C17261.this;
                        if (offset >= i) {
                            return endOfData();
                        }
                        Instruction from = DexBackedInstruction.readFrom(DexBackedMethodImplementation.this.dexFile, dexReader);
                        int offset2 = dexReader.getOffset();
                        if (offset2 > i || offset2 < 0) {
                            throw new ExceptionWithContext("The last instruction in method %s is truncated", DexBackedMethodImplementation.this.method);
                        }
                        return from;
                    }
                };
            }
        };
    }

    public int getInstructionsSize() {
        return this.dexFile.getDataBuffer().readSmallUint(this.codeOffset + 12);
    }

    public int getInstructionsStartOffset() {
        return this.codeOffset + 16;
    }

    public Iterator<String> getParameterNames(DexReader dexReader) {
        return getDebugInfo().getParameterNames(dexReader);
    }

    @Override // org.p088jf.dexlib2.iface.MethodImplementation
    public int getRegisterCount() {
        return this.dexFile.getDataBuffer().readUshort(this.codeOffset);
    }

    public int getTriesSize() {
        return this.dexFile.getDataBuffer().readUshort(this.codeOffset + 6);
    }

    @Override // org.p088jf.dexlib2.iface.MethodImplementation
    public List<? extends DexBackedTryBlock> getTryBlocks() {
        final int triesSize = getTriesSize();
        if (triesSize <= 0) {
            return ImmutableList.m3778of();
        }
        final int iAlignOffset = AlignmentUtils.alignOffset(getInstructionsStartOffset() + (getInstructionsSize() * 2), 4);
        final int i = (triesSize * 8) + iAlignOffset;
        return new FixedSizeList<DexBackedTryBlock>() { // from class: org.jf.dexlib2.dexbacked.DexBackedMethodImplementation.2
            @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeList
            public DexBackedTryBlock readItem(int i2) {
                return new DexBackedTryBlock(DexBackedMethodImplementation.this.dexFile, iAlignOffset + (i2 * 8), i);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return triesSize;
            }
        };
    }
}
