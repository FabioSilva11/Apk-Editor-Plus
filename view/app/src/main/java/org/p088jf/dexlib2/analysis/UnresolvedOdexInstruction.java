package org.p088jf.dexlib2.analysis;

import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.Instruction;

/* JADX INFO: loaded from: classes.dex */
public class UnresolvedOdexInstruction implements Instruction {
    public final int objectRegisterNum;
    public final Instruction originalInstruction;

    public UnresolvedOdexInstruction(Instruction instruction, int i) {
        this.originalInstruction = instruction;
        this.objectRegisterNum = i;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return this.originalInstruction.getCodeUnits();
    }

    @Override // org.p088jf.dexlib2.iface.instruction.Instruction
    public Opcode getOpcode() {
        return this.originalInstruction.getOpcode();
    }
}
