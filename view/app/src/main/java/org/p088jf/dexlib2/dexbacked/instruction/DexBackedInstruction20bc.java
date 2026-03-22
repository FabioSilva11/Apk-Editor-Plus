package org.p088jf.dexlib2.dexbacked.instruction;

import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.ReferenceType;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.reference.DexBackedReference;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction20bc;
import org.p088jf.dexlib2.iface.reference.Reference;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedInstruction20bc extends DexBackedInstruction implements Instruction20bc {
    public DexBackedInstruction20bc(DexBackedDexFile dexBackedDexFile, Opcode opcode, int i) {
        super(dexBackedDexFile, opcode, i);
    }

    @Override // org.p088jf.dexlib2.iface.instruction.ReferenceInstruction
    public Reference getReference() {
        final int ushort = this.dexFile.getDataBuffer().readUshort(this.instructionStart + 2);
        try {
            return DexBackedReference.makeReference(this.dexFile, getReferenceType(), ushort);
        } catch (ReferenceType.InvalidReferenceTypeException e) {
            return new Reference(this) { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedInstruction20bc.1
                @Override // org.p088jf.dexlib2.iface.reference.Reference
                public void validateReference() throws Reference.InvalidReferenceException {
                    throw new Reference.InvalidReferenceException(String.format("%d@%d", Integer.valueOf(e.getReferenceType()), Integer.valueOf(ushort)), e);
                }
            };
        }
    }

    @Override // org.p088jf.dexlib2.iface.instruction.ReferenceInstruction
    public int getReferenceType() {
        int ubyte = (this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 1) >>> 6) + 1;
        ReferenceType.validateReferenceType(ubyte);
        return ubyte;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.VerificationErrorInstruction
    public int getVerificationError() {
        return this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 1) & 63;
    }
}
