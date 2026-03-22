package org.p088jf.dexlib2.builder.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderInstruction;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction31c;
import org.p088jf.dexlib2.iface.reference.Reference;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class BuilderInstruction31c extends BuilderInstruction implements Instruction31c {
    public static final Format FORMAT = Format.Format31c;
    public final Reference reference;
    public final int registerA;

    public BuilderInstruction31c(Opcode opcode, int i, Reference reference) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i);
        this.reference = reference;
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.ReferenceInstruction
    public Reference getReference() {
        return this.reference;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.ReferenceInstruction
    public int getReferenceType() {
        return this.opcode.referenceType;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.registerA;
    }
}
