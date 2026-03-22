package org.p088jf.dexlib2.builder.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderInstruction;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction45cc;
import org.p088jf.dexlib2.iface.reference.Reference;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class BuilderInstruction45cc extends BuilderInstruction implements Instruction45cc {
    public static final Format FORMAT = Format.Format45cc;
    public final Reference reference;
    public final Reference reference2;
    public final int registerC;
    public final int registerCount;
    public final int registerD;
    public final int registerE;
    public final int registerF;
    public final int registerG;

    public BuilderInstruction45cc(Opcode opcode, int i, int i2, int i3, int i4, int i5, int i6, Reference reference, Reference reference2) {
        super(opcode);
        this.registerCount = Preconditions.check35cAnd45ccRegisterCount(i);
        this.registerC = i > 0 ? Preconditions.checkNibbleRegister(i2) : 0;
        this.registerD = i > 1 ? Preconditions.checkNibbleRegister(i3) : 0;
        this.registerE = i > 2 ? Preconditions.checkNibbleRegister(i4) : 0;
        this.registerF = i > 3 ? Preconditions.checkNibbleRegister(i5) : 0;
        this.registerG = i > 4 ? Preconditions.checkNibbleRegister(i6) : 0;
        this.reference = reference;
        this.reference2 = reference2;
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.ReferenceInstruction
    public Reference getReference() {
        return this.reference;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.DualReferenceInstruction
    public Reference getReference2() {
        return this.reference2;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.ReferenceInstruction
    public int getReferenceType() {
        return this.opcode.referenceType;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.DualReferenceInstruction
    public int getReferenceType2() {
        return this.opcode.referenceType2;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterC() {
        return this.registerC;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.VariableRegisterInstruction
    public int getRegisterCount() {
        return this.registerCount;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterD() {
        return this.registerD;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterE() {
        return this.registerE;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterF() {
        return this.registerF;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterG() {
        return this.registerG;
    }
}
