package org.p088jf.dexlib2.builder.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderInstruction;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction10x;

/* JADX INFO: loaded from: classes.dex */
public class BuilderInstruction10x extends BuilderInstruction implements Instruction10x {
    public static final Format FORMAT = Format.Format10x;

    public BuilderInstruction10x(Opcode opcode) {
        super(opcode);
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }
}
