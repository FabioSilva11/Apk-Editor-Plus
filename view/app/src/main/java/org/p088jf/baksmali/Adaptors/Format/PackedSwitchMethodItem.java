package org.p088jf.baksmali.Adaptors.Format;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.p088jf.baksmali.Adaptors.LabelMethodItem;
import org.p088jf.baksmali.Adaptors.MethodDefinition;
import org.p088jf.baksmali.formatter.BaksmaliWriter;
import org.p088jf.dexlib2.iface.instruction.SwitchElement;
import org.p088jf.dexlib2.iface.instruction.formats.PackedSwitchPayload;
import org.p088jf.dexlib2.immutable.value.ImmutableIntEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class PackedSwitchMethodItem extends InstructionMethodItem<PackedSwitchPayload> {
    public boolean commentedOut;
    public final int firstKey;
    public final List<PackedSwitchTarget> targets;

    public static class PackedSwitchLabelTarget extends PackedSwitchTarget {
        public final LabelMethodItem target;

        public PackedSwitchLabelTarget(LabelMethodItem labelMethodItem) {
            super();
            this.target = labelMethodItem;
        }

        @Override // org.jf.baksmali.Adaptors.Format.PackedSwitchMethodItem.PackedSwitchTarget
        public void writeTargetTo(BaksmaliWriter baksmaliWriter) throws IOException {
            this.target.writeTo(baksmaliWriter);
        }
    }

    public static class PackedSwitchOffsetTarget extends PackedSwitchTarget {
        public final int target;

        public PackedSwitchOffsetTarget(int i) {
            super();
            this.target = i;
        }

        @Override // org.jf.baksmali.Adaptors.Format.PackedSwitchMethodItem.PackedSwitchTarget
        public void writeTargetTo(BaksmaliWriter baksmaliWriter) throws IOException {
            if (this.target >= 0) {
                baksmaliWriter.write(43);
            }
            baksmaliWriter.writeSignedIntAsDec(this.target);
        }
    }

    public static abstract class PackedSwitchTarget {
        public PackedSwitchTarget() {
        }

        public abstract void writeTargetTo(BaksmaliWriter baksmaliWriter) throws IOException;
    }

    public PackedSwitchMethodItem(MethodDefinition methodDefinition, int i, PackedSwitchPayload packedSwitchPayload) {
        int key;
        super(methodDefinition, i, packedSwitchPayload);
        int packedSwitchBaseAddress = methodDefinition.getPackedSwitchBaseAddress(i);
        this.targets = new ArrayList();
        boolean z = true;
        if (packedSwitchBaseAddress >= 0) {
            key = 0;
            for (SwitchElement switchElement : packedSwitchPayload.getSwitchElements()) {
                if (z) {
                    key = switchElement.getKey();
                    z = false;
                }
                this.targets.add(new PackedSwitchLabelTarget(methodDefinition.getLabelCache().internLabel(new LabelMethodItem(methodDefinition.classDef.options, switchElement.getOffset() + packedSwitchBaseAddress, "pswitch_"))));
            }
        } else {
            this.commentedOut = true;
            key = 0;
            for (SwitchElement switchElement2 : packedSwitchPayload.getSwitchElements()) {
                if (z) {
                    key = switchElement2.getKey();
                    z = false;
                }
                this.targets.add(new PackedSwitchOffsetTarget(switchElement2.getOffset()));
            }
        }
        this.firstKey = key;
    }

    @Override // org.p088jf.baksmali.Adaptors.Format.InstructionMethodItem, org.p088jf.baksmali.Adaptors.MethodItem
    public boolean writeTo(BaksmaliWriter baksmaliWriter) throws IOException {
        if (this.commentedOut) {
            baksmaliWriter = this.methodDef.classDef.getCommentingWriter(baksmaliWriter);
        }
        baksmaliWriter.write(".packed-switch ");
        baksmaliWriter.writeEncodedValue(new ImmutableIntEncodedValue(this.firstKey));
        baksmaliWriter.indent(4);
        baksmaliWriter.write(10);
        int i = this.firstKey;
        Iterator<PackedSwitchTarget> it = this.targets.iterator();
        while (it.hasNext()) {
            it.next().writeTargetTo(baksmaliWriter);
            writeCommentIfResourceId(baksmaliWriter, i);
            baksmaliWriter.write(10);
            i++;
        }
        baksmaliWriter.deindent(4);
        baksmaliWriter.write(".end packed-switch");
        return true;
    }
}
