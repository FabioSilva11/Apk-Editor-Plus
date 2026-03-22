package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction11x;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction11x extends ImmutableInstruction implements Instruction11x {
    public static final Format FORMAT = Format.Format11x;
    public final int registerA;

    public ImmutableInstruction11x(Opcode opcode, int i) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction11x m3877of(Instruction11x instruction11x) {
        return instruction11x instanceof ImmutableInstruction11x ? (ImmutableInstruction11x) instruction11x : new ImmutableInstruction11x(instruction11x.getOpcode(), instruction11x.getRegisterA());
    }

    @Override // org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.registerA;
    }
}
