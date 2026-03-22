package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction32x;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction32x extends ImmutableInstruction implements Instruction32x {
    public static final Format FORMAT = Format.Format32x;
    public final int registerA;
    public final int registerB;

    public ImmutableInstruction32x(Opcode opcode, int i, int i2) {
        super(opcode);
        this.registerA = Preconditions.checkShortRegister(i);
        this.registerB = Preconditions.checkShortRegister(i2);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction32x m3897of(Instruction32x instruction32x) {
        return instruction32x instanceof ImmutableInstruction32x ? (ImmutableInstruction32x) instruction32x : new ImmutableInstruction32x(instruction32x.getOpcode(), instruction32x.getRegisterA(), instruction32x.getRegisterB());
    }

    @Override // org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
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
