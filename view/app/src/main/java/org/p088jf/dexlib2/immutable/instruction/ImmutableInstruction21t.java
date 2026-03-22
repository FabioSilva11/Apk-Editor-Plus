package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction21t;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction21t extends ImmutableInstruction implements Instruction21t {
    public static final Format FORMAT = Format.Format21t;
    public final int codeOffset;
    public final int registerA;

    public ImmutableInstruction21t(Opcode opcode, int i, int i2) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i);
        this.codeOffset = Preconditions.checkShortCodeOffset(i2);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction21t m3885of(Instruction21t instruction21t) {
        return instruction21t instanceof ImmutableInstruction21t ? (ImmutableInstruction21t) instruction21t : new ImmutableInstruction21t(instruction21t.getOpcode(), instruction21t.getRegisterA(), instruction21t.getCodeOffset());
    }

    @Override // org.p088jf.dexlib2.iface.instruction.OffsetInstruction
    public int getCodeOffset() {
        return this.codeOffset;
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
