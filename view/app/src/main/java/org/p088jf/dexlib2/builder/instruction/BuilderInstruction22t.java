package org.p088jf.dexlib2.builder.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderOffsetInstruction;
import org.p088jf.dexlib2.builder.Label;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction22t;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class BuilderInstruction22t extends BuilderOffsetInstruction implements Instruction22t {
    public static final Format FORMAT = Format.Format22t;
    public final int registerA;
    public final int registerB;

    public BuilderInstruction22t(Opcode opcode, int i, int i2, Label label) {
        super(opcode, label);
        this.registerA = Preconditions.checkNibbleRegister(i);
        this.registerB = Preconditions.checkNibbleRegister(i2);
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
