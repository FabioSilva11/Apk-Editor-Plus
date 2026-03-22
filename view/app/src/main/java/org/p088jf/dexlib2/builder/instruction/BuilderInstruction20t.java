package org.p088jf.dexlib2.builder.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderOffsetInstruction;
import org.p088jf.dexlib2.builder.Label;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction20t;

/* JADX INFO: loaded from: classes.dex */
public class BuilderInstruction20t extends BuilderOffsetInstruction implements Instruction20t {
    public static final Format FORMAT = Format.Format20t;

    public BuilderInstruction20t(Opcode opcode, Label label) {
        super(opcode, label);
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }
}
