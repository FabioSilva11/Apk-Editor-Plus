package org.p088jf.dexlib2.dexbacked.instruction;

import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction30t;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedInstruction30t extends DexBackedInstruction implements Instruction30t {
    public DexBackedInstruction30t(DexBackedDexFile dexBackedDexFile, Opcode opcode, int i) {
        super(dexBackedDexFile, opcode, i);
    }

    @Override // org.p088jf.dexlib2.iface.instruction.OffsetInstruction
    public int getCodeOffset() {
        return this.dexFile.getDataBuffer().readInt(this.instructionStart + 2);
    }
}
