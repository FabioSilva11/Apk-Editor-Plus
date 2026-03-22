package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction10t;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction10t extends ImmutableInstruction implements Instruction10t {
    public static final Format FORMAT = Format.Format10t;
    public final int codeOffset;

    public ImmutableInstruction10t(Opcode opcode, int i) {
        super(opcode);
        this.codeOffset = Preconditions.checkByteCodeOffset(i);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction10t m3874of(Instruction10t instruction10t) {
        return instruction10t instanceof ImmutableInstruction10t ? (ImmutableInstruction10t) instruction10t : new ImmutableInstruction10t(instruction10t.getOpcode(), instruction10t.getCodeOffset());
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
