package org.p088jf.dexlib2.immutable.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.formats.UnknownInstruction;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableUnknownInstruction extends ImmutableInstruction implements UnknownInstruction {
    public static final Format FORMAT = Format.Format10x;
    public final int originalOpcode;

    public ImmutableUnknownInstruction(int i) {
        super(Opcode.NOP);
        this.originalOpcode = i;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableUnknownInstruction m3910of(UnknownInstruction unknownInstruction) {
        return unknownInstruction instanceof ImmutableUnknownInstruction ? (ImmutableUnknownInstruction) unknownInstruction : new ImmutableUnknownInstruction(unknownInstruction.getOriginalOpcode());
    }

    @Override // org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.formats.UnknownInstruction
    public int getOriginalOpcode() {
        return this.originalOpcode;
    }
}
