package org.p088jf.baksmali.Adaptors.Format;

import org.p088jf.baksmali.Adaptors.MethodDefinition;
import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.analysis.UnresolvedOdexInstruction;
import org.p088jf.dexlib2.iface.instruction.Instruction;
import org.p088jf.dexlib2.iface.instruction.OffsetInstruction;
import org.p088jf.dexlib2.iface.instruction.formats.ArrayPayload;
import org.p088jf.dexlib2.iface.instruction.formats.PackedSwitchPayload;
import org.p088jf.dexlib2.iface.instruction.formats.SparseSwitchPayload;

/* JADX INFO: loaded from: classes.dex */
public class InstructionMethodItemFactory {

    /* JADX INFO: renamed from: org.jf.baksmali.Adaptors.Format.InstructionMethodItemFactory$1 */
    public static /* synthetic */ class C16841 {
        public static final /* synthetic */ int[] $SwitchMap$org$jf$dexlib2$Format;

        static {
            int[] iArr = new int[Format.values().length];
            $SwitchMap$org$jf$dexlib2$Format = iArr;
            try {
                iArr[Format.ArrayPayload.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.PackedSwitchPayload.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.SparseSwitchPayload.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static InstructionMethodItem makeInstructionFormatMethodItem(MethodDefinition methodDefinition, int i, Instruction instruction) {
        if (instruction instanceof OffsetInstruction) {
            return new OffsetInstructionFormatMethodItem(methodDefinition.classDef.options, methodDefinition, i, (OffsetInstruction) instruction);
        }
        if (instruction instanceof UnresolvedOdexInstruction) {
            return new UnresolvedOdexInstructionMethodItem(methodDefinition, i, (UnresolvedOdexInstruction) instruction);
        }
        int i2 = C16841.$SwitchMap$org$jf$dexlib2$Format[instruction.getOpcode().format.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? new InstructionMethodItem(methodDefinition, i, instruction) : new SparseSwitchMethodItem(methodDefinition, i, (SparseSwitchPayload) instruction) : new PackedSwitchMethodItem(methodDefinition, i, (PackedSwitchPayload) instruction) : new ArrayDataMethodItem(methodDefinition, i, (ArrayPayload) instruction);
    }
}
