package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction35c;
import org.p088jf.dexlib2.iface.reference.Reference;
import org.p088jf.dexlib2.immutable.reference.ImmutableReference;
import org.p088jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction35c extends ImmutableInstruction implements Instruction35c {
    public static final Format FORMAT = Format.Format35c;
    public final ImmutableReference reference;
    public final int registerC;
    public final int registerCount;
    public final int registerD;
    public final int registerE;
    public final int registerF;
    public final int registerG;

    public ImmutableInstruction35c(Opcode opcode, int i, int i2, int i3, int i4, int i5, int i6, Reference reference) {
        super(opcode);
        this.registerCount = Preconditions.check35cAnd45ccRegisterCount(i);
        this.registerC = i > 0 ? Preconditions.checkNibbleRegister(i2) : 0;
        this.registerD = i > 1 ? Preconditions.checkNibbleRegister(i3) : 0;
        this.registerE = i > 2 ? Preconditions.checkNibbleRegister(i4) : 0;
        this.registerF = i > 3 ? Preconditions.checkNibbleRegister(i5) : 0;
        this.registerG = i > 4 ? Preconditions.checkNibbleRegister(i6) : 0;
        this.reference = ImmutableReferenceFactory.m3916of(opcode.referenceType, reference);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction35c m3898of(Instruction35c instruction35c) {
        return instruction35c instanceof ImmutableInstruction35c ? (ImmutableInstruction35c) instruction35c : new ImmutableInstruction35c(instruction35c.getOpcode(), instruction35c.getRegisterCount(), instruction35c.getRegisterC(), instruction35c.getRegisterD(), instruction35c.getRegisterE(), instruction35c.getRegisterF(), instruction35c.getRegisterG(), instruction35c.getReference());
    }

    @Override // org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.ReferenceInstruction
    public ImmutableReference getReference() {
        return this.reference;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.ReferenceInstruction
    public int getReferenceType() {
        return this.opcode.referenceType;
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
