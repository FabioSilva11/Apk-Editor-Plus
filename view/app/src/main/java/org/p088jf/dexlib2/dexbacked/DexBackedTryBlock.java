package org.p088jf.dexlib2.dexbacked;

import java.util.List;
import org.p088jf.dexlib2.base.BaseTryBlock;
import org.p088jf.dexlib2.dexbacked.util.VariableSizeList;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedTryBlock extends BaseTryBlock<DexBackedExceptionHandler> {
    public final DexBackedDexFile dexFile;
    public final int handlersStartOffset;
    public final int tryItemOffset;

    public DexBackedTryBlock(DexBackedDexFile dexBackedDexFile, int i, int i2) {
        this.dexFile = dexBackedDexFile;
        this.tryItemOffset = i;
        this.handlersStartOffset = i2;
    }

    @Override // org.p088jf.dexlib2.iface.TryBlock
    public int getCodeUnitCount() {
        return this.dexFile.getDataBuffer().readUshort(this.tryItemOffset + 4);
    }

    @Override // org.p088jf.dexlib2.iface.TryBlock
    public List<? extends DexBackedExceptionHandler> getExceptionHandlers() {
        DexReader<? extends DexBuffer> dexReader = this.dexFile.getDataBuffer().readerAt(this.handlersStartOffset + this.dexFile.getDataBuffer().readUshort(this.tryItemOffset + 6));
        int sleb128 = dexReader.readSleb128();
        if (sleb128 > 0) {
            return new VariableSizeList<DexBackedTypedExceptionHandler>(this.dexFile.getDataBuffer(), dexReader.getOffset(), sleb128) { // from class: org.jf.dexlib2.dexbacked.DexBackedTryBlock.1
                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeList
                public DexBackedTypedExceptionHandler readNextItem(DexReader dexReader2, int i) {
                    return new DexBackedTypedExceptionHandler(DexBackedTryBlock.this.dexFile, dexReader2);
                }
            };
        }
        final int i = (sleb128 * (-1)) + 1;
        return new VariableSizeList<DexBackedExceptionHandler>(this.dexFile.getDataBuffer(), dexReader.getOffset(), i) { // from class: org.jf.dexlib2.dexbacked.DexBackedTryBlock.2
            @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeList
            public DexBackedExceptionHandler readNextItem(DexReader dexReader2, int i2) {
                return i2 == i + (-1) ? new DexBackedCatchAllExceptionHandler(dexReader2) : new DexBackedTypedExceptionHandler(DexBackedTryBlock.this.dexFile, dexReader2);
            }
        };
    }

    @Override // org.p088jf.dexlib2.iface.TryBlock
    public int getStartCodeAddress() {
        return this.dexFile.getDataBuffer().readSmallUint(this.tryItemOffset + 0);
    }
}
