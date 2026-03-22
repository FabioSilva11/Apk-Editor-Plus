package org.p088jf.dexlib2.builder.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderInstruction;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction22x;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class BuilderInstruction22x extends BuilderInstruction implements Instruction22x {
    public static final Format FORMAT = Format.Format22x;
    public final int registerA;
    public final int registerB;

    public BuilderInstruction22x(Opcode opcode, int i, int i2) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i);
        this.registerB = Preconditions.checkShortRegister(i2);
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
}
