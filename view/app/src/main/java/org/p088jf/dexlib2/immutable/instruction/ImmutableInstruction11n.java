package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction11n;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableInstruction11n extends ImmutableInstruction implements Instruction11n {
    public static final Format FORMAT = Format.Format11n;
    public final int literal;
    public final int registerA;

    public ImmutableInstruction11n(Opcode opcode, int i, int i2) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(i);
        this.literal = Preconditions.checkNibbleLiteral(i2);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction11n m3876of(Instruction11n instruction11n) {
        return instruction11n instanceof ImmutableInstruction11n ? (ImmutableInstruction11n) instruction11n : new ImmutableInstruction11n(instruction11n.getOpcode(), instruction11n.getRegisterA(), instruction11n.getNarrowLiteral());
    }

    @Override // org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.NarrowLiteralInstruction
    public int getNarrowLiteral() {
        return this.literal;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.registerA;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.WideLiteralInstruction
    public long getWideLiteral() {
        return this.literal;
    }
}
