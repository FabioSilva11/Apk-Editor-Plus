package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction22c;
import org.p088jf.dexlib2.iface.reference.Reference;
import org.p088jf.dexlib2.immutable.reference.ImmutableReference;
import org.p088jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction22c extends ImmutableInstruction implements Instruction22c {
    public static final Format FORMAT = Format.Format22c;
    public final ImmutableReference reference;
    public final int registerA;
    public final int registerB;

    public ImmutableInstruction22c(Opcode opcode, int i, int i2, Reference reference) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(i);
        this.registerB = Preconditions.checkNibbleRegister(i2);
        this.reference = ImmutableReferenceFactory.m3916of(opcode.referenceType, reference);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction22c m3887of(Instruction22c instruction22c) {
        return instruction22c instanceof ImmutableInstruction22c ? (ImmutableInstruction22c) instruction22c : new ImmutableInstruction22c(instruction22c.getOpcode(), instruction22c.getRegisterA(), instruction22c.getRegisterB(), instruction22c.getReference());
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

    @Override // org.p088jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.registerA;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.TwoRegisterInstruction
    public int getRegisterB() {
        return this.registerB;
    }
}
