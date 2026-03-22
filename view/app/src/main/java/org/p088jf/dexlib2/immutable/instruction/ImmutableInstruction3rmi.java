package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction3rmi;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction3rmi extends ImmutableInstruction implements Instruction3rmi {
    public static final Format FORMAT = Format.Format3rmi;
    public final int inlineIndex;
    public final int registerCount;
    public final int startRegister;

    public ImmutableInstruction3rmi(Opcode opcode, int i, int i2, int i3) {
        super(opcode);
        this.startRegister = Preconditions.checkShortRegister(i);
        this.registerCount = Preconditions.checkRegisterRangeCount(i2);
        this.inlineIndex = Preconditions.checkInlineIndex(i3);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction3rmi m3902of(Instruction3rmi instruction3rmi) {
        return instruction3rmi instanceof ImmutableInstruction3rmi ? (ImmutableInstruction3rmi) instruction3rmi : new ImmutableInstruction3rmi(instruction3rmi.getOpcode(), instruction3rmi.getStartRegister(), instruction3rmi.getRegisterCount(), instruction3rmi.getInlineIndex());
    }

    @Override // org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.InlineIndexInstruction
    public int getInlineIndex() {
        return this.inlineIndex;
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
