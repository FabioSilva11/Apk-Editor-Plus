package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.ReferenceType;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction20bc;
import org.p088jf.dexlib2.iface.reference.Reference;
import org.p088jf.dexlib2.immutable.reference.ImmutableReference;
import org.p088jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction20bc extends ImmutableInstruction implements Instruction20bc {
    public static final Format FORMAT = Format.Format20bc;
    public final ImmutableReference reference;
    public final int verificationError;

    public ImmutableInstruction20bc(Opcode opcode, int i, Reference reference) {
        super(opcode);
        this.verificationError = Preconditions.checkVerificationError(i);
        this.reference = ImmutableReferenceFactory.m3916of(opcode.referenceType, reference);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction20bc m3879of(Instruction20bc instruction20bc) {
        return instruction20bc instanceof ImmutableInstruction20bc ? (ImmutableInstruction20bc) instruction20bc : new ImmutableInstruction20bc(instruction20bc.getOpcode(), instruction20bc.getVerificationError(), instruction20bc.getReference());
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
        return ReferenceType.getReferenceType(this.reference);
    }

    @Override // org.p088jf.dexlib2.iface.instruction.VerificationErrorInstruction
    public int getVerificationError() {
        return this.verificationError;
    }
}
