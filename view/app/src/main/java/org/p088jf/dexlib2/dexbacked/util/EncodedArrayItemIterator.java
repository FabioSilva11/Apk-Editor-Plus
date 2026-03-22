package org.p088jf.dexlib2.dexbacked.util;

import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexBuffer;
import org.p088jf.dexlib2.dexbacked.DexReader;
import org.p088jf.dexlib2.dexbacked.value.DexBackedEncodedValue;
import org.p088jf.dexlib2.iface.value.EncodedValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class EncodedArrayItemIterator {
    public static final EncodedArrayItemIterator EMPTY = new EncodedArrayItemIterator() { // from class: org.jf.dexlib2.dexbacked.util.EncodedArrayItemIterator.1
        @Override // org.p088jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public int getItemCount() {
            return 0;
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public EncodedValue getNextOrNull() {
            return null;
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public int getReaderOffset() {
            return 0;
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public void skipNext() {
        }
    };

    public static class EncodedArrayItemIteratorImpl extends EncodedArrayItemIterator {
        public final DexBackedDexFile dexFile;
        public int index = 0;
        public final DexReader reader;
        public final int size;

        public EncodedArrayItemIteratorImpl(DexBackedDexFile dexBackedDexFile, int i) {
            this.dexFile = dexBackedDexFile;
            DexReader<? extends DexBuffer> dexReader = dexBackedDexFile.getDataBuffer().readerAt(i);
            this.reader = dexReader;
            this.size = dexReader.readSmallUleb128();
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public int getItemCount() {
            return this.size;
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public EncodedValue getNextOrNull() {
            int i = this.index;
            if (i >= this.size) {
                return null;
            }
            this.index = i + 1;
            return DexBackedEncodedValue.readFrom(this.dexFile, this.reader);
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public int getReaderOffset() {
            return this.reader.getOffset();
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public void skipNext() {
            int i = this.index;
            if (i < this.size) {
                this.index = i + 1;
                DexBackedEncodedValue.skipFrom(this.reader);
            }
        }
    }

    public static EncodedArrayItemIterator newOrEmpty(DexBackedDexFile dexBackedDexFile, int i) {
        return i == 0 ? EMPTY : new EncodedArrayItemIteratorImpl(dexBackedDexFile, i);
    }

    public abstract int getItemCount();

    public abstract EncodedValue getNextOrNull();

    public abstract int getReaderOffset();

    public abstract void skipNext();
}
