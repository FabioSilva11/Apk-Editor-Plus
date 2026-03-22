package org.p088jf.dexlib2.dexbacked.instruction;

import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.reference.DexBackedReference;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction21c;
import org.p088jf.dexlib2.iface.reference.Reference;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedInstruction21c extends DexBackedInstruction implements Instruction21c {
    public DexBackedInstruction21c(DexBackedDexFile dexBackedDexFile, Opcode opcode, int i) {
        super(dexBackedDexFile, opcode, i);
    }

    @Override // org.p088jf.dexlib2.iface.instruction.ReferenceInstruction
    public Reference getReference() {
        DexBackedDexFile dexBackedDexFile = this.dexFile;
        return DexBackedReference.makeReference(dexBackedDexFile, this.opcode.referenceType, dexBackedDexFile.getDataBuffer().readUshort(this.instructionStart + 2));
    }

    @Override // org.p088jf.dexlib2.iface.instruction.ReferenceInstruction
    public int getReferenceType() {
        return this.opcode.referenceType;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 1);
    }
}
