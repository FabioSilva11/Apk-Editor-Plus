package org.p088jf.dexlib2.dexbacked.instruction;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.util.FixedSizeList;
import org.p088jf.dexlib2.iface.instruction.formats.ArrayPayload;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedArrayPayload extends DexBackedInstruction implements ArrayPayload {
    public static final Opcode OPCODE = Opcode.ARRAY_PAYLOAD;
    public final int elementCount;
    public final int elementWidth;

    /* JADX INFO: renamed from: org.jf.dexlib2.dexbacked.instruction.DexBackedArrayPayload$1ReturnedList, reason: invalid class name */
    public abstract class C1ReturnedList extends FixedSizeList<Number> {
        public C1ReturnedList() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return DexBackedArrayPayload.this.elementCount;
        }
    }

    public DexBackedArrayPayload(DexBackedDexFile dexBackedDexFile, int i) {
        super(dexBackedDexFile, OPCODE, i);
        int ushort = dexBackedDexFile.getDataBuffer().readUshort(i + 2);
        if (ushort == 0) {
            this.elementWidth = 1;
            this.elementCount = 0;
            return;
        }
        this.elementWidth = ushort;
        int smallUint = dexBackedDexFile.getDataBuffer().readSmallUint(i + 4);
        this.elementCount = smallUint;
        if (((long) ushort) * ((long) smallUint) > 2147483647L) {
            throw new ExceptionWithContext("Invalid array-payload instruction: element width*count overflows", new Object[0]);
        }
    }

    @Override // org.p088jf.dexlib2.iface.instruction.formats.ArrayPayload
    public List<Number> getArrayElements() {
        final int i = this.instructionStart + 8;
        if (this.elementCount == 0) {
            return ImmutableList.m3778of();
        }
        int i2 = this.elementWidth;
        if (i2 == 1) {
            return new C1ReturnedList() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedArrayPayload.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeList
                public Number readItem(int i3) {
                    return Integer.valueOf(DexBackedArrayPayload.this.dexFile.getDataBuffer().readByte(i + i3));
                }
            };
        }
        if (i2 == 2) {
            return new C1ReturnedList() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedArrayPayload.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeList
                public Number readItem(int i3) {
                    return Integer.valueOf(DexBackedArrayPayload.this.dexFile.getDataBuffer().readShort(i + (i3 * 2)));
                }
            };
        }
        if (i2 == 4) {
            return new C1ReturnedList() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedArrayPayload.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeList
                public Number readItem(int i3) {
                    return Integer.valueOf(DexBackedArrayPayload.this.dexFile.getDataBuffer().readInt(i + (i3 * 4)));
                }
            };
        }
        if (i2 == 8) {
            return new C1ReturnedList() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedArrayPayload.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeList
                public Number readItem(int i3) {
                    return Long.valueOf(DexBackedArrayPayload.this.dexFile.getDataBuffer().readLong(i + (i3 * 8)));
                }
            };
        }
        throw new ExceptionWithContext("Invalid element width: %d", Integer.valueOf(this.elementWidth));
    }

    @Override // org.p088jf.dexlib2.dexbacked.instruction.DexBackedInstruction, org.p088jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (((this.elementWidth * this.elementCount) + 1) / 2) + 4;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.formats.ArrayPayload
    public int getElementWidth() {
        return this.elementWidth;
    }
}
