package org.p088jf.dexlib2.builder.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderInstruction;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction21ih;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class BuilderInstruction21ih extends BuilderInstruction implements Instruction21ih {
    public static final Format FORMAT = Format.Format21ih;
    public final int literal;
    public final int registerA;

    public BuilderInstruction21ih(Opcode opcode, int i, int i2) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i);
        this.literal = Preconditions.checkIntegerHatLiteral(i2);
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.HatLiteralInstruction
    public short getHatLiteral() {
        return (short) (this.literal >>> 16);
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
