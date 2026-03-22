package org.p088jf.dexlib2.dexbacked.instruction;

import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction3rms;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedInstruction3rms extends DexBackedInstruction implements Instruction3rms {
    public DexBackedInstruction3rms(DexBackedDexFile dexBackedDexFile, Opcode opcode, int i) {
        super(dexBackedDexFile, opcode, i);
    }

    @Override // org.p088jf.dexlib2.iface.instruction.VariableRegisterInstruction
    public int getRegisterCount() {
        return this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 1);
    }

    @Override // org.p088jf.dexlib2.iface.instruction.RegisterRangeInstruction
    public int getStartRegister() {
        return this.dexFile.getDataBuffer().readUshort(this.instructionStart + 4);
    }

    @Override // org.p088jf.dexlib2.iface.instruction.VtableIndexInstruction
    public int getVtableIndex() {
        return this.dexFile.getDataBuffer().readUshort(this.instructionStart + 2);
    }
}
