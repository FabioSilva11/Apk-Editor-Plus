package org.p088jf.baksmali.Adaptors;

import java.io.IOException;
import java.util.BitSet;
import org.p088jf.baksmali.formatter.BaksmaliWriter;
import org.p088jf.dexlib2.analysis.AnalyzedInstruction;
import org.p088jf.dexlib2.analysis.RegisterType;

/* JADX INFO: loaded from: classes.dex */
public class PostInstructionRegisterInfoMethodItem extends MethodItem {
    public final AnalyzedInstruction analyzedInstruction;
    public final RegisterFormatter registerFormatter;

    public PostInstructionRegisterInfoMethodItem(RegisterFormatter registerFormatter, AnalyzedInstruction analyzedInstruction, int i) {
        super(i);
        this.registerFormatter = registerFormatter;
        this.analyzedInstruction = analyzedInstruction;
    }

    public final void addDestRegs(BitSet bitSet, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!this.analyzedInstruction.getPreInstructionRegisterType(i2).equals(this.analyzedInstruction.getPostInstructionRegisterType(i2))) {
                bitSet.set(i2);
            }
        }
    }

    @Override // org.p088jf.baksmali.Adaptors.MethodItem
    public double getSortOrder() {
        return 100.1d;
    }

    public final boolean writeRegisterInfo(BaksmaliWriter baksmaliWriter, BitSet bitSet) throws IOException {
        int iNextSetBit = bitSet.nextSetBit(0);
        if (iNextSetBit < 0) {
            return false;
        }
        baksmaliWriter.write(35);
        while (iNextSetBit >= 0) {
            RegisterType postInstructionRegisterType = this.analyzedInstruction.getPostInstructionRegisterType(iNextSetBit);
            this.registerFormatter.writeTo(baksmaliWriter, iNextSetBit);
            baksmaliWriter.write(61);
            postInstructionRegisterType.writeTo(baksmaliWriter);
            baksmaliWriter.write(59);
            iNextSetBit = bitSet.nextSetBit(iNextSetBit + 1);
        }
        return true;
    }

    @Override // org.p088jf.baksmali.Adaptors.MethodItem
    public boolean writeTo(BaksmaliWriter baksmaliWriter) throws IOException {
        int i = this.registerFormatter.options.registerInfo;
        int registerCount = this.analyzedInstruction.getRegisterCount();
        BitSet bitSet = new BitSet(registerCount);
        if ((i & 1) != 0 || (i & 4) != 0) {
            bitSet.set(0, registerCount);
        } else if ((i & 16) != 0) {
            addDestRegs(bitSet, registerCount);
        }
        return writeRegisterInfo(baksmaliWriter, bitSet);
    }
}
