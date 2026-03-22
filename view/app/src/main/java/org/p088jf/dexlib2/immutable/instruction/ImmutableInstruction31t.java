package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction31t;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction31t extends ImmutableInstruction implements Instruction31t {
    public static final Format FORMAT = Format.Format31t;
    public final int codeOffset;
    public final int registerA;

    public ImmutableInstruction31t(Opcode opcode, int i, int i2) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i);
        this.codeOffset = i2;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction31t m3896of(Instruction31t instruction31t) {
        return instruction31t instanceof ImmutableInstruction31t ? (ImmutableInstruction31t) instruction31t : new ImmutableInstruction31t(instruction31t.getOpcode(), instruction31t.getRegisterA(), instruction31t.getCodeOffset());
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
