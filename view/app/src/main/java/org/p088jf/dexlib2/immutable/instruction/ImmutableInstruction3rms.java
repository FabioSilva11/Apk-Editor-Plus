package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction3rms;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction3rms extends ImmutableInstruction implements Instruction3rms {
    public static final Format FORMAT = Format.Format3rms;
    public final int registerCount;
    public final int startRegister;
    public final int vtableIndex;

    public ImmutableInstruction3rms(Opcode opcode, int i, int i2, int i3) {
        super(opcode);
        this.startRegister = Preconditions.checkShortRegister(i);
        this.registerCount = Preconditions.checkRegisterRangeCount(i2);
        this.vtableIndex = Preconditions.checkVtableIndex(i3);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction3rms m3903of(Instruction3rms instruction3rms) {
        return instruction3rms instanceof ImmutableInstruction3rms ? (ImmutableInstruction3rms) instruction3rms : new ImmutableInstruction3rms(instruction3rms.getOpcode(), instruction3rms.getStartRegister(), instruction3rms.getRegisterCount(), instruction3rms.getVtableIndex());
    }

    @Override // org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.VariableRegisterInstruction
    public int getRegisterCount() {
        return this.registerCount;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.RegisterRangeInstruction
    public int getStartRegister() {
        return this.startRegister;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.VtableIndexInstruction
    public int getVtableIndex() {
        return this.vtableIndex;
    }
}
