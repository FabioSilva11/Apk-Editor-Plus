package org.p088jf.dexlib2.dexbacked.instruction;

import java.util.List;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexBuffer;
import org.p088jf.dexlib2.dexbacked.util.FixedSizeList;
import org.p088jf.dexlib2.iface.instruction.SwitchElement;
import org.p088jf.dexlib2.iface.instruction.formats.SparseSwitchPayload;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedSparseSwitchPayload extends DexBackedInstruction implements SparseSwitchPayload {
    public final int elementCount;

    public DexBackedSparseSwitchPayload(DexBackedDexFile dexBackedDexFile, int i) {
        super(dexBackedDexFile, Opcode.SPARSE_SWITCH_PAYLOAD, i);
        this.elementCount = dexBackedDexFile.getDataBuffer().readUshort(i + 2);
    }

    @Override // org.p088jf.dexlib2.dexbacked.instruction.DexBackedInstruction, org.p088jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (this.elementCount * 4) + 2;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.SwitchPayload, org.p088jf.dexlib2.iface.instruction.formats.PackedSwitchPayload
    public List<? extends SwitchElement> getSwitchElements() {
        return new FixedSizeList<SwitchElement>() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedSparseSwitchPayload.1
            @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeList
            public SwitchElement readItem(final int i) {
                return new SwitchElement() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedSparseSwitchPayload.1.1
                    @Override // org.p088jf.dexlib2.iface.instruction.SwitchElement
                    public int getKey() {
                        return DexBackedSparseSwitchPayload.this.dexFile.getDataBuffer().readInt(DexBackedSparseSwitchPayload.this.instructionStart + 4 + (i * 4));
                    }

                    @Override // org.p088jf.dexlib2.iface.instruction.SwitchElement
                    public int getOffset() {
                        DexBuffer dataBuffer = DexBackedSparseSwitchPayload.this.dexFile.getDataBuffer();
                        DexBackedSparseSwitchPayload dexBackedSparseSwitchPayload = DexBackedSparseSwitchPayload.this;
                        return dataBuffer.readInt(dexBackedSparseSwitchPayload.instructionStart + 4 + (dexBackedSparseSwitchPayload.elementCount * 4) + (i * 4));
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedSparseSwitchPayload.this.elementCount;
            }
        };
    }
}
