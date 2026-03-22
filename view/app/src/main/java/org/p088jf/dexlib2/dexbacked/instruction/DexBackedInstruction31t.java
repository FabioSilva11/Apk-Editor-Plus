package org.p088jf.dexlib2.dexbacked.instruction;

import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction31t;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedInstruction31t extends DexBackedInstruction implements Instruction31t {
    public DexBackedInstruction31t(DexBackedDexFile dexBackedDexFile, Opcode opcode, int i) {
        super(dexBackedDexFile, opcode, i);
    }

    @Override // org.p088jf.dexlib2.iface.instruction.OffsetInstruction
    public int getCodeOffset() {
        return this.dexFile.getDataBuffer().readInt(this.instructionStart + 2);
    }

    @Override // org.p088jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 1);
    }
}
