package org.p088jf.dexlib2.builder.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderOffsetInstruction;
import org.p088jf.dexlib2.builder.Label;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction21t;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class BuilderInstruction21t extends BuilderOffsetInstruction implements Instruction21t {
    public static final Format FORMAT = Format.Format21t;
    public final int registerA;

    public BuilderInstruction21t(Opcode opcode, int i, Label label) {
        super(opcode, label);
        this.registerA = Preconditions.checkByteRegister(i);
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.registerA;
    }
}
