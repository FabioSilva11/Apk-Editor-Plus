package org.p088jf.dexlib2.builder.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderInstruction;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction35ms;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class BuilderInstruction35ms extends BuilderInstruction implements Instruction35ms {
    public static final Format FORMAT = Format.Format35ms;
    public final int registerC;
    public final int registerCount;
    public final int registerD;
    public final int registerE;
    public final int registerF;
    public final int registerG;
    public final int vtableIndex;

    public BuilderInstruction35ms(Opcode opcode, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(opcode);
        this.registerCount = Preconditions.check35cAnd45ccRegisterCount(i);
        this.registerC = i > 0 ? Preconditions.checkNibbleRegister(i2) : 0;
        this.registerD = i > 1 ? Preconditions.checkNibbleRegister(i3) : 0;
        this.registerE = i > 2 ? Preconditions.checkNibbleRegister(i4) : 0;
        this.registerF = i > 3 ? Preconditions.checkNibbleRegister(i5) : 0;
        this.registerG = i > 4 ? Preconditions.checkNibbleRegister(i6) : 0;
        this.vtableIndex = i7;
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterC() {
        return this.registerC;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.VariableRegisterInstruction
    public int getRegisterCount() {
        return this.registerCount;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterD() {
        return this.registerD;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterE() {
        return this.registerE;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterF() {
        return this.registerF;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterG() {
        return this.registerG;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.VtableIndexInstruction
    public int getVtableIndex() {
        return this.vtableIndex;
    }
}
