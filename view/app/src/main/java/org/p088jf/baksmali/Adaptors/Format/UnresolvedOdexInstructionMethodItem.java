package org.p088jf.baksmali.Adaptors.Format;

import java.io.IOException;
import org.p088jf.baksmali.Adaptors.MethodDefinition;
import org.p088jf.baksmali.formatter.BaksmaliWriter;
import org.p088jf.dexlib2.analysis.UnresolvedOdexInstruction;

/* JADX INFO: loaded from: classes.dex */
public class UnresolvedOdexInstructionMethodItem extends InstructionMethodItem<UnresolvedOdexInstruction> {
    public UnresolvedOdexInstructionMethodItem(MethodDefinition methodDefinition, int i, UnresolvedOdexInstruction unresolvedOdexInstruction) {
        super(methodDefinition, i, unresolvedOdexInstruction);
    }

    public final void writeThrowTo(BaksmaliWriter baksmaliWriter) throws IOException {
        baksmaliWriter.write("#Replaced unresolvable odex instruction with a throw\n");
        baksmaliWriter.write("throw ");
        writeRegister(baksmaliWriter, ((UnresolvedOdexInstruction) this.instruction).objectRegisterNum);
    }

    @Override // org.p088jf.baksmali.Adaptors.Format.InstructionMethodItem, org.p088jf.baksmali.Adaptors.MethodItem
    public boolean writeTo(BaksmaliWriter baksmaliWriter) throws IOException {
        writeThrowTo(baksmaliWriter);
        return true;
    }
}
