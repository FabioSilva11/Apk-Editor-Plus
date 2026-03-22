package org.p088jf.dexlib2.dexbacked.instruction;

import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction22t;
import org.p088jf.util.NibbleUtils;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedInstruction22t extends DexBackedInstruction implements Instruction22t {
    public DexBackedInstruction22t(DexBackedDexFile dexBackedDexFile, Opcode opcode, int i) {
        super(dexBackedDexFile, opcode, i);
    }

    @Override // org.p088jf.dexlib2.iface.instruction.OffsetInstruction
    public int getCodeOffset() {
        return this.dexFile.getDataBuffer().readShort(this.instructionStart + 2);
    }

    @Override // org.p088jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return NibbleUtils.extractLowUnsignedNibble(this.dexFile.getDataBuffer().readByte(this.instructionStart + 1));
    }

    @Override // org.p088jf.dexlib2.iface.instruction.TwoRegisterInstruction
    public int getRegisterB() {
        return NibbleUtils.extractHighUnsignedNibble(this.dexFile.getDataBuffer().readByte(this.instructionStart + 1));
    }
}
