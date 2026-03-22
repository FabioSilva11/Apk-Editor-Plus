package org.p088jf.dexlib2.dexbacked.instruction;

import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction35ms;
import org.p088jf.util.NibbleUtils;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedInstruction35ms extends DexBackedInstruction implements Instruction35ms {
    public DexBackedInstruction35ms(DexBackedDexFile dexBackedDexFile, Opcode opcode, int i) {
        super(dexBackedDexFile, opcode, i);
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterC() {
        return NibbleUtils.extractLowUnsignedNibble(this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 4));
    }

    @Override // org.p088jf.dexlib2.iface.instruction.VariableRegisterInstruction
    public int getRegisterCount() {
        return NibbleUtils.extractHighUnsignedNibble(this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 1));
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterD() {
        return NibbleUtils.extractHighUnsignedNibble(this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 4));
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterE() {
        return NibbleUtils.extractLowUnsignedNibble(this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 5));
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterF() {
        return NibbleUtils.extractHighUnsignedNibble(this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 5));
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterG() {
        return NibbleUtils.extractLowUnsignedNibble(this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 1));
    }

    @Override // org.p088jf.dexlib2.iface.instruction.VtableIndexInstruction
    public int getVtableIndex() {
        return this.dexFile.getDataBuffer().readUshort(this.instructionStart + 2);
    }
}
