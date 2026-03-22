package org.p088jf.baksmali.Adaptors.Format;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.p088jf.baksmali.Adaptors.LabelMethodItem;
import org.p088jf.baksmali.Adaptors.MethodDefinition;
import org.p088jf.baksmali.formatter.BaksmaliWriter;
import org.p088jf.dexlib2.iface.instruction.SwitchElement;
import org.p088jf.dexlib2.iface.instruction.formats.SparseSwitchPayload;
import org.p088jf.dexlib2.immutable.value.ImmutableIntEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class SparseSwitchMethodItem extends InstructionMethodItem<SparseSwitchPayload> {
    public boolean commentedOut;
    public final List<SparseSwitchTarget> targets;

    public static class SparseSwitchLabelTarget extends SparseSwitchTarget {
        public final LabelMethodItem target;

        public SparseSwitchLabelTarget(int i, LabelMethodItem labelMethodItem) {
            super(i);
            this.target = labelMethodItem;
        }

        @Override // org.jf.baksmali.Adaptors.Format.SparseSwitchMethodItem.SparseSwitchTarget
        public void writeTargetTo(BaksmaliWriter baksmaliWriter) throws IOException {
            this.target.writeTo(baksmaliWriter);
        }
    }

    public static class SparseSwitchOffsetTarget extends SparseSwitchTarget {
        public final int target;

        public SparseSwitchOffsetTarget(int i, int i2) {
            super(i);
            this.target = i2;
        }

        @Override // org.jf.baksmali.Adaptors.Format.SparseSwitchMethodItem.SparseSwitchTarget
        public void writeTargetTo(BaksmaliWriter baksmaliWriter) throws IOException {
            if (this.target >= 0) {
                baksmaliWriter.write(43);
            }
            baksmaliWriter.writeSignedIntAsDec(this.target);
        }
    }

    public static abstract class SparseSwitchTarget {
        public final int key;

        public SparseSwitchTarget(int i) {
            this.key = i;
        }

        public int getKey() {
            return this.key;
        }

        public abstract void writeTargetTo(BaksmaliWriter baksmaliWriter) throws IOException;
    }

    public SparseSwitchMethodItem(MethodDefinition methodDefinition, int i, SparseSwitchPayload sparseSwitchPayload) {
        super(methodDefinition, i, sparseSwitchPayload);
        int sparseSwitchBaseAddress = methodDefinition.getSparseSwitchBaseAddress(i);
        this.targets = new ArrayList();
        if (sparseSwitchBaseAddress >= 0) {
            for (SwitchElement switchElement : sparseSwitchPayload.getSwitchElements()) {
                this.targets.add(new SparseSwitchLabelTarget(switchElement.getKey(), methodDefinition.getLabelCache().internLabel(new LabelMethodItem(methodDefinition.classDef.options, switchElement.getOffset() + sparseSwitchBaseAddress, "sswitch_"))));
            }
            return;
        }
        this.commentedOut = true;
        for (SwitchElement switchElement2 : sparseSwitchPayload.getSwitchElements()) {
            this.targets.add(new SparseSwitchOffsetTarget(switchElement2.getKey(), switchElement2.getOffset()));
        }
    }

    @Override // org.p088jf.baksmali.Adaptors.Format.InstructionMethodItem, org.p088jf.baksmali.Adaptors.MethodItem
    public boolean writeTo(BaksmaliWriter baksmaliWriter) throws IOException {
        if (this.commentedOut) {
            baksmaliWriter = this.methodDef.classDef.getCommentingWriter(baksmaliWriter);
        }
        baksmaliWriter.write(".sparse-switch\n");
        baksmaliWriter.indent(4);
        for (SparseSwitchTarget sparseSwitchTarget : this.targets) {
            baksmaliWriter.writeEncodedValue(new ImmutableIntEncodedValue(sparseSwitchTarget.getKey()));
            baksmaliWriter.write(" -> ");
            sparseSwitchTarget.writeTargetTo(baksmaliWriter);
            writeCommentIfResourceId(baksmaliWriter, sparseSwitchTarget.getKey());
            baksmaliWriter.write(10);
        }
        baksmaliWriter.deindent(4);
        baksmaliWriter.write(".end sparse-switch");
        return true;
    }
}
