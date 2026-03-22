package org.p088jf.dexlib2.dexbacked.instruction;

import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.iface.instruction.formats.UnknownInstruction;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedUnknownInstruction extends DexBackedInstruction implements UnknownInstruction {
    public DexBackedUnknownInstruction(DexBackedDexFile dexBackedDexFile, int i) {
        super(dexBackedDexFile, Opcode.NOP, i);
    }

    @Override // org.p088jf.dexlib2.iface.instruction.formats.UnknownInstruction
    public int getOriginalOpcode() {
        int ubyte = this.dexFile.getDataBuffer().readUbyte(this.instructionStart);
        return ubyte == 0 ? this.dexFile.getDataBuffer().readUshort(this.instructionStart) : ubyte;
    }
}
