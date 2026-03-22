package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction30t;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction30t extends ImmutableInstruction implements Instruction30t {
    public static final Format FORMAT = Format.Format30t;
    public final int codeOffset;

    public ImmutableInstruction30t(Opcode opcode, int i) {
        super(opcode);
        this.codeOffset = i;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction30t m3893of(Instruction30t instruction30t) {
        return instruction30t instanceof ImmutableInstruction30t ? (ImmutableInstruction30t) instruction30t : new ImmutableInstruction30t(instruction30t.getOpcode(), instruction30t.getCodeOffset());
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
