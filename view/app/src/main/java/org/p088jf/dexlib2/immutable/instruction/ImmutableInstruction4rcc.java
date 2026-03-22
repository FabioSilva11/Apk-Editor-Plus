package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction4rcc;
import org.p088jf.dexlib2.iface.reference.Reference;
import org.p088jf.dexlib2.immutable.reference.ImmutableReference;
import org.p088jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction4rcc extends ImmutableInstruction implements Instruction4rcc {
    public static final Format FORMAT = Format.Format4rcc;
    public final ImmutableReference reference;
    public final ImmutableReference reference2;
    public final int registerCount;
    public final int startRegister;

    public ImmutableInstruction4rcc(Opcode opcode, int i, int i2, Reference reference, Reference reference2) {
        super(opcode);
        this.startRegister = Preconditions.checkShortRegister(i);
        this.registerCount = Preconditions.checkRegisterRangeCount(i2);
        this.reference = ImmutableReferenceFactory.m3917of(reference);
        this.reference2 = ImmutableReferenceFactory.m3917of(reference2);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction4rcc m3905of(Instruction4rcc instruction4rcc) {
        return instruction4rcc instanceof ImmutableInstruction4rcc ? (ImmutableInstruction4rcc) instruction4rcc : new ImmutableInstruction4rcc(instruction4rcc.getOpcode(), instruction4rcc.getStartRegister(), instruction4rcc.getRegisterCount(), instruction4rcc.getReference(), instruction4rcc.getReference2());
    }

    @Override // org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction
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

    @Override // org.p088jf.dexlib2.iface.instruction.VariableRegisterInstruction
    public int getRegisterCount() {
        return this.registerCount;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.RegisterRangeInstruction
    public int getStartRegister() {
        return this.startRegister;
    }
}
