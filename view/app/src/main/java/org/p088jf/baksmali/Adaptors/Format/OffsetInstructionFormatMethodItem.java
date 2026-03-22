package org.p088jf.baksmali.Adaptors.Format;

import java.io.IOException;
import org.p088jf.baksmali.Adaptors.LabelMethodItem;
import org.p088jf.baksmali.Adaptors.MethodDefinition;
import org.p088jf.baksmali.BaksmaliOptions;
import org.p088jf.baksmali.formatter.BaksmaliWriter;
import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.OffsetInstruction;

/* JADX INFO: loaded from: classes.dex */
public class OffsetInstructionFormatMethodItem extends InstructionMethodItem<OffsetInstruction> {
    public LabelMethodItem label;

    /* JADX INFO: renamed from: org.jf.baksmali.Adaptors.Format.OffsetInstructionFormatMethodItem$1 */
    public static /* synthetic */ class C16851 {
        public static final /* synthetic */ int[] $SwitchMap$org$jf$dexlib2$Format;

        static {
            int[] iArr = new int[Format.values().length];
            $SwitchMap$org$jf$dexlib2$Format = iArr;
            try {
                iArr[Format.Format10t.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format20t.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format30t.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format21t.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format22t.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format31t.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public OffsetInstructionFormatMethodItem(BaksmaliOptions baksmaliOptions, MethodDefinition methodDefinition, int i, OffsetInstruction offsetInstruction) {
        super(methodDefinition, i, offsetInstruction);
        this.label = new LabelMethodItem(baksmaliOptions, i + offsetInstruction.getCodeOffset(), getLabelPrefix());
        this.label = methodDefinition.getLabelCache().internLabel(this.label);
    }

    public final String getLabelPrefix() {
        Opcode opcode = ((OffsetInstruction) this.instruction).getOpcode();
        switch (C16851.$SwitchMap$org$jf$dexlib2$Format[opcode.format.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return "goto_";
            case 4:
            case 5:
                return "cond_";
            case 6:
                return opcode == Opcode.FILL_ARRAY_DATA ? "array_" : opcode == Opcode.PACKED_SWITCH ? "pswitch_data_" : "sswitch_data_";
            default:
                return null;
        }
    }

    @Override // org.p088jf.baksmali.Adaptors.Format.InstructionMethodItem
    public void writeTargetLabel(BaksmaliWriter baksmaliWriter) throws IOException {
        this.label.writeTo(baksmaliWriter);
    }
}
