package org.p088jf.dexlib2.builder;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.Instruction;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public abstract class BuilderInstruction implements Instruction {
    public MethodLocation location;
    public final Opcode opcode;

    public BuilderInstruction(Opcode opcode) {
        Preconditions.checkFormat(opcode, getFormat());
        this.opcode = opcode;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return getFormat().size / 2;
    }

    public abstract Format getFormat();

    public MethodLocation getLocation() {
        MethodLocation methodLocation = this.location;
        if (methodLocation != null) {
            return methodLocation;
        }
        throw new IllegalStateException("Cannot get the location of an instruction that hasn't been added to a method.");
    }

    @Override // org.p088jf.dexlib2.iface.instruction.Instruction
    public Opcode getOpcode() {
        return this.opcode;
    }
}
