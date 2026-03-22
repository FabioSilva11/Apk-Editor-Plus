package org.p088jf.dexlib2.dexbacked.instruction;

import java.util.List;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.util.FixedSizeList;
import org.p088jf.dexlib2.iface.instruction.SwitchElement;
import org.p088jf.dexlib2.iface.instruction.formats.PackedSwitchPayload;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedPackedSwitchPayload extends DexBackedInstruction implements PackedSwitchPayload {
    public final int elementCount;

    public DexBackedPackedSwitchPayload(DexBackedDexFile dexBackedDexFile, int i) {
        super(dexBackedDexFile, Opcode.PACKED_SWITCH_PAYLOAD, i);
        this.elementCount = dexBackedDexFile.getDataBuffer().readUshort(i + 2);
    }

    @Override // org.p088jf.dexlib2.dexbacked.instruction.DexBackedInstruction, org.p088jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (this.elementCount * 2) + 4;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.formats.PackedSwitchPayload
    public List<? extends SwitchElement> getSwitchElements() {
        final int i = this.dexFile.getDataBuffer().readInt(this.instructionStart + 4);
        return new FixedSizeList<SwitchElement>() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedPackedSwitchPayload.1
            @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeList
            public SwitchElement readItem(final int i2) {
                return new SwitchElement() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedPackedSwitchPayload.1.1
                    @Override // org.p088jf.dexlib2.iface.instruction.SwitchElement
                    public int getKey() {
                        return i + i2;
                    }

                    @Override // org.p088jf.dexlib2.iface.instruction.SwitchElement
                    public int getOffset() {
                        return DexBackedPackedSwitchPayload.this.dexFile.getDataBuffer().readInt(DexBackedPackedSwitchPayload.this.instructionStart + 8 + (i2 * 4));
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedPackedSwitchPayload.this.elementCount;
            }
        };
    }
}
