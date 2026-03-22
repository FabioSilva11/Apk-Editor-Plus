package org.p088jf.dexlib2.builder.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderInstruction;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction23x;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class BuilderInstruction23x extends BuilderInstruction implements Instruction23x {
    public static final Format FORMAT = Format.Format23x;
    public final int registerA;
    public final int registerB;
    public final int registerC;

    public BuilderInstruction23x(Opcode opcode, int i, int i2, int i3) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i);
        this.registerB = Preconditions.checkByteRegister(i2);
        this.registerC = Preconditions.checkByteRegister(i3);
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction
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

    @Override // org.p088jf.dexlib2.iface.instruction.ThreeRegisterInstruction
    public int getRegisterC() {
        return this.registerC;
    }
}
