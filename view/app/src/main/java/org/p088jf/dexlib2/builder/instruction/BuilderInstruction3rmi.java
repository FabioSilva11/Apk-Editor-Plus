package org.p088jf.dexlib2.builder.instruction;

import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderInstruction;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction3rmi;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class BuilderInstruction3rmi extends BuilderInstruction implements Instruction3rmi {
    public static final Format FORMAT = Format.Format3rmi;
    public final int inlineIndex;
    public final int registerCount;
    public final int startRegister;

    public BuilderInstruction3rmi(Opcode opcode, int i, int i2, int i3) {
        super(opcode);
        this.startRegister = Preconditions.checkShortRegister(i);
        this.registerCount = Preconditions.checkRegisterRangeCount(i2);
        this.inlineIndex = i3;
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.InlineIndexInstruction
    public int getInlineIndex() {
        return this.inlineIndex;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.VariableRegisterInstruction
    public int getRegisterCount() {
        return this.registerCount;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.RegisterRangeInstruction
    public int getStartRegister() {
        return this.startRegister;
    }
}
