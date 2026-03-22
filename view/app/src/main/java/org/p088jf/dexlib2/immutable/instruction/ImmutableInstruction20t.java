package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction20t;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction20t extends ImmutableInstruction implements Instruction20t {
    public static final Format FORMAT = Format.Format20t;
    public final int codeOffset;

    public ImmutableInstruction20t(Opcode opcode, int i) {
        super(opcode);
        this.codeOffset = Preconditions.checkShortCodeOffset(i);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction20t m3880of(Instruction20t instruction20t) {
        return instruction20t instanceof ImmutableInstruction20t ? (ImmutableInstruction20t) instruction20t : new ImmutableInstruction20t(instruction20t.getOpcode(), instruction20t.getCodeOffset());
    }

    @Override // org.p088jf.dexlib2.iface.instruction.OffsetInstruction
    public int getCodeOffset() {
        return this.codeOffset;
    }

    @Override // org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }
}
